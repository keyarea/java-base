package 数字操作类;

class MathUtil {
    private MathUtil() {}

    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}

public class MathTest1 {
    public static void main(String[] args) {
        System.out.println(MathUtil.round(19.4567, 2)); // 19.46
    }
}
