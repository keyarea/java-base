package 数字操作类;

import java.math.BigInteger;

public class BigIntegerTest2 {
    public static void main(String[] args) {
        BigInteger big1 = new BigInteger("1233434324324");
        BigInteger big2 = new BigInteger("12434324");
        BigInteger[] result = big1.divideAndRemainder(big2);
        System.out.println("商为 " + result[0] + ", 余数为 " + result[1]);
    }
}
