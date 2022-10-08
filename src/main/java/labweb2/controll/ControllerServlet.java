package labweb2.controll;

import java.io.IOException;
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
            RequestParameters requestParameters = new RequestParameters(
                    req.getParameter("x"),
                    req.getParameter("y"),
                    req.getParameter("r"));
            AreaCheckServlet areaCheckServlet = new AreaCheckServlet(requestParameters, resp, req);
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
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
