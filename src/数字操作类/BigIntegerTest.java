package 数字操作类;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger big1 = new BigInteger("1234344354534643");
        BigInteger big2 = new BigInteger("123423");
        System.out.println("加法操作: " + big1.add(big2));
        System.out.println("减法操作: " + big1.subtract(big2));
        System.out.println("乘法操作: " + big1.multiply(big2));
        System.out.println("除法操作: " + big1.divide(big2));
    }
}
