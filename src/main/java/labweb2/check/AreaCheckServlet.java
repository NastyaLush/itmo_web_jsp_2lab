package labweb2.check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import labweb2.view.CreateHttpResults;

@WebServlet(urlPatterns = "/check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Results results = new Check(req.getParameter("x"), req.getParameter("y"), req.getParameter("r")).getResults();
        new CreateHttpResults(results, req, resp).work();
    }

}
