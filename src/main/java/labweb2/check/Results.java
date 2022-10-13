package labweb2.check;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Results {
    private final double x;
    private final double y;
    private final double r;
    private final FieldResult result;
    private final String data;

    public Results(double x, double y, double r, boolean result) {
        this.x = Math.floor(x * 1000) / 1000;
        this.y = Math.floor(y * 1000) / 1000;
        this.r = r;
        this.result = result ? FieldResult.REACH : FieldResult.MISS;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        this.data = formatter.format(date);

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

    public FieldResult getResult() {
        return result;
    }

    public String getData() {
        return data;
    }
    public String getHTTP(){
        return  "<div class=" + "content__scroll_table_row"+ "> " +
                "<div class=" + "content__scroll_table_row_cell" + ">" +
                x +
                "</div> <div class=" + "content__scroll_table_row_cell" + ">" +
                y +
                "</div> <div class=" + "content__scroll_table_row_cell" + ">" +
                r +
                "</div> <div class=" + "content__scroll_table_row_cell" + ">" +
                result +
                "</div> <div class=" + "content__scroll_table_row_cell" + ">" +
                data +
                "</div> </div>";
    }
}
