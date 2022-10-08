package labweb2.controll;

public class RequestParameters {
    private final double x;
    private final double y;
    private final double r;

    public RequestParameters(String x, String y, String r) {
        this.x = Double.parseDouble(x);
        this.y = Double.parseDouble(y);
        this.r = Double.parseDouble(r);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}
