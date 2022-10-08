package labweb2.controll;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import labweb2.check.AreaCheckServlet;

public class ControllerServlet extends HttpServlet {


    //если вздом с помошью урла
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isCorrectParameters(req.getParameter("x"))
                && isCorrectParameters(req.getParameter("y"))
                && isCorrectParameters(req.getParameter("r"))
        ) {
            RequestParametrs requestParametrs = new RequestParametrs(
                    req.getParameter("x"),
                    req.getParameter("y"),
                    req.getParameter("r"));
            AreaCheckServlet areaCheckServlet = new AreaCheckServlet(requestParametrs, resp, req);
            areaCheckServlet.work();
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    private boolean isCorrectParameters(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
