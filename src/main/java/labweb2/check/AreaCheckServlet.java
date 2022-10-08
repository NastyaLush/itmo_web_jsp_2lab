package labweb2.check;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import labweb2.controll.RequestParameters;

public class AreaCheckServlet extends HttpServlet {
    private final RequestParameters parameters;
    private final HttpServletResponse response;
    private final HttpServletRequest request;

    public AreaCheckServlet(RequestParameters parameters, HttpServletResponse response, HttpServletRequest request) {
        this.parameters = parameters;
        this.response = response;
        this.request = request;
    }
    public void work() {
       Results results =  new Check(parameters).getResults();
       new CreateHttpResults(results, request, response).work();
    }
}
