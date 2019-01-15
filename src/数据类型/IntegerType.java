package 数据类型;

/**
 * 整型用于表示没有小数部分的数值，它允许是负数。
 */
public class IntegerType {
    public static void main(String[] args){
        // 定义一个int类型，取值范围-2147483648 - 2147483647 正好超过20亿
        int num1 = 1;
        // 定义一个short类型，取值范围-32768 - 32767
        short num2 = 1;
        // 定义一个byte类型，取值范围-128 - 127
        byte num3 = 1;
        // 定义一个长整型，取值范围-9223372036854775808 - 9223372036854775807
        // 长整型数据有一个后缀L或者l，如下
        long num4 = 10000000L;
    }
}
