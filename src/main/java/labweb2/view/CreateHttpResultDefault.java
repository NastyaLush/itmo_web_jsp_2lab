package labweb2.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateHttpResultDefault {
    protected final HttpServletRequest request;
    protected final HttpServletResponse response;

    public CreateHttpResultDefault(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    protected final String SESSION_ATTRIBUTE = "data";

    public void work() throws ServletException, IOException {
        HttpSession session = request.getSession();
        String oldResults = (String) session.getAttribute(SESSION_ATTRIBUTE);
        if (oldResults != null) {
            session.setAttribute(SESSION_ATTRIBUTE, oldResults);
            response.setContentType("text/plain");
            try {
                response.getWriter().write(oldResults);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
