package labweb2.check;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateHttpResults {
    private final String SESSION_ATTRIBUTE="data";
    private final Results results;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CreateHttpResults(Results results, HttpServletRequest request, HttpServletResponse response) {
        this.results = results;
        this.request = request;
        this.response = response;
    }
    public void work() {
        HttpSession session =  request.getSession();
        ArrayList<Results> oldResults = (ArrayList<Results>) session.getAttribute(SESSION_ATTRIBUTE);
        if(oldResults ==null) {
            oldResults = new ArrayList<Results>();
        }
        oldResults.add(results);
        System.out.println(results);
        session.setAttribute(SESSION_ATTRIBUTE, oldResults);
        request.setAttribute(SESSION_ATTRIBUTE, oldResults);

        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO: 07.10.2022  
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO: 07.10.2022  
            throw new RuntimeException(e);
        }
    }
}
