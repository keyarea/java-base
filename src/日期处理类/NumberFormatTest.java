package 日期处理类;

import java.text.NumberFormat;

public class NumberFormatTest {
    public static void main(String[] args) {
        double num = 123232343.23;
        String str = NumberFormat.getInstance().format(num);
        System.out.println(str); // 123,232,343.23
    }
}
