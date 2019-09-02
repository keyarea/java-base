package 数字操作类;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal big1 = new BigDecimal("12312321321");
        BigDecimal big2 = new BigDecimal("12323");
        System.out.println("加法计算: " + big1.add(big2));
        BigDecimal[] result = big1.divideAndRemainder(big2);
        System.out.println("商为: " + result[0] + ", 余数为: " + result[1]);
    }
}
