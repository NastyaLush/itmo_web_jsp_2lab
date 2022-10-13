package labweb2.view;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import labweb2.check.Results;

public class CreateHttpResults {
    private final String SESSION_ATTRIBUTE = "data";
    private final Results results;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CreateHttpResults(Results results, HttpServletRequest request, HttpServletResponse response) {
        this.results = results;
        this.request = request;
        this.response = response;
    }

    public void work() {
        HttpSession session = request.getSession();
        ArrayList<Results> oldResults = (ArrayList<Results>) session.getAttribute(SESSION_ATTRIBUTE);
        if (oldResults == null) {
            oldResults = new ArrayList<>();
        }
        oldResults.add(results);
        System.out.println(results);
        session.setAttribute(SESSION_ATTRIBUTE, oldResults);
        response.setContentType("text/plain");
        try {
            response.getWriter().write(results.getHTTP());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
