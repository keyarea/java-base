package 数字操作类;

public class MathTest {
    public static void main(String[] args) {
        System.out.println(Math.abs(12.1)); // 12.1
        System.out.println(Math.abs(-12.1)); // 12.1
        System.out.println(Math.max(12.1, 13.1)); // 13.1
        System.out.println(Math.round(12.1)); // 12
        System.out.println(Math.round(-12.1)); // -12
        System.out.println(Math.round(-12.5)); // -12
        System.out.println(Math.round(-12.51)); // -13
        System.out.println(Math.log(5)); // 1.6094379124341003
        System.out.println(Math.pow(2,3)); // 8.0
    }
}
