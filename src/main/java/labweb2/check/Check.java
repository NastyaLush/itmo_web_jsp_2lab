package labweb2.check;

public class Check {
    private final Double x;
    private final Double y;
    private final Double r;

    public Check(String x, String y, String r) {
        this.x =  Double.parseDouble(x);
        this.y =  Double.parseDouble(y);
        this.r =  Double.parseDouble(r);
    }
    private boolean isInTriangle(){
        return between(-r/2, 0 , x) && between(highTriangle(),0, y);
    }
    private double highTriangle(){
         return 2*x - r;
    }
    private boolean isInSector(){
        return between(0, r , x) && between(0, highSector(), y);
    }
    private double highSector(){
        return Math.sqrt(Math.pow(r, 2) - Math.pow(y,2));
    }
    private boolean isInSquare(){
        return between(-r, 0 , x) && between(0, r, y);
    }
    private boolean between(double x1, double x2, double x){
        return x>=x1 && x<=x2;
    }
    public Results getResults(){
        return new Results(x, y, r,
                isInSector()||isInSquare()||isInTriangle());
    }

}
