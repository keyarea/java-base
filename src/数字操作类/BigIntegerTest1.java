package 数字操作类;

import java.math.BigInteger;

public class BigIntegerTest1 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("12345678912323213");
        System.out.println(bigInteger.pow(Integer.MAX_VALUE));
    }
}
