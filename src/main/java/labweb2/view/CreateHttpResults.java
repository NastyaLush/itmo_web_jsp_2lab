package labweb2.view;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import labweb2.check.Results;

public class CreateHttpResults extends CreateHttpResultDefault {
    private final Results results;

    public CreateHttpResults(Results results, HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        this.results = results;
    }

    public void work() {
        HttpSession session = request.getSession();
        String oldResults = (String) session.getAttribute(SESSION_ATTRIBUTE);
        if (oldResults == null) {
            oldResults = results.getHTTP();
        } else {
            oldResults = results.getHTTP() + oldResults;
        }
        session.setAttribute(SESSION_ATTRIBUTE, oldResults);
        response.setContentType("text/plain");
        try {
            response.getWriter().write(oldResults);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
