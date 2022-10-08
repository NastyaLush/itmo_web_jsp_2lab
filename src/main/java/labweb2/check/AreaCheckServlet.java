package labweb2.check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import labweb2.controll.RequestParametrs;

public class AreaCheckServlet extends HttpServlet {
    private final RequestParametrs parameters;
    private final HttpServletResponse response;
    private final HttpServletRequest request;

    public AreaCheckServlet(RequestParametrs parameters, HttpServletResponse response, HttpServletRequest request) {
        this.parameters = parameters;
        this.response = response;
        this.request = request;
    }
    public void work() {
       Results results =  new Check(parameters).getResults();
       new CreateHttpResults(results, request, response).work();
    }
}
