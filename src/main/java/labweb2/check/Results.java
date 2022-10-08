package labweb2.check;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Results {
    public final double x;
    public final double y;
    public final double r;
    public final Result result;
    public final String date;

    public Results(double x, double y, double r, boolean result) {
        this.x = Math.floor(x*1000)/1000;
        this.y = Math.floor(y*1000)/1000;
        this.r = r;
        this.result = result?Result.REACH:Result.MISS;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        this.date = formatter.format(date);

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

    public Result getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }
}
