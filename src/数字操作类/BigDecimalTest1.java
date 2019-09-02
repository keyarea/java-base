package 数字操作类;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest1 {
    public static void main(String[] args) {
        double flag = 123.2354;
        System.out.println(round(flag, 2));
    }

    public static double round(double num, int scale) {
        return new BigDecimal(num).divide(new BigDecimal(1.0), scale, RoundingMode.HALF_UP).doubleValue();
    }
}
