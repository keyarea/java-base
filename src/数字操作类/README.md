# 数字操作类

> 程序就是一个数学处理的过程,所以在Java语言本身也提供有相应的数字处理类库支持.

## Math类

> Math类的主要功能是进行数学计算的操作类,提供有基础的计算公式,这个类的构造方法被私有化了,该类中提供的所有方法都是static的方法,即:这些方法都可以通过我们的
类名称直接调用.

实例: 

```java
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
```

> 虽然在Math类里面提供有四舍五入的处理方法,但是这个四舍五入在处理的时候是直接将小数点后的所有位进行进位处理了,这样肯定不方便,那么现在最方便的方法就是
实现指定位数的保留.

范例: 自定义的四舍五入功能

```java

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
```

> Math类里面提供的基本上都是基础的数学公式,需要的时候需要自己重新整合.

## Random类

> java.util.Random类的主要功能是产生随机数的,这个类主要是依靠内部提供的方法来完成:
> - 产生一个不大于边界的随机正整数: `public int nextInt(int bound);`

范例: 产生随机数

```java

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            System.out.print(random.nextInt(100) + ",");
        }
    }
}
```

范例: 彩票36选7,不能为0,不能重复

```java
import java.util.Arrays;
import java.util.Random;

public class RandomTest1 {
    public static void main(String[] args) {
        int[] data = new int[7]; // 开辟一个能存放7个值的数组
        Random random = new Random();
        int foot = 0; // 脚标
        while (foot < 7){
            int flag = random.nextInt(37);
            if(isUse(flag, data)) {
                data[foot++] = flag;
            }
        }

        System.out.println(Arrays.toString(data));
    }

    public static boolean isUse(int flag, int[] data) {
        if(flag == 0) {
            return false;
        }

        for(int i = 0 ; i < data.length ; i ++) {
            if(flag == data[i]) {
                return false;
            }
        }
        return true;
    }
}
```

> 以后的这种随机数的操作都可以利用random来处理.

## 大数字操作类

> 在进行数学计算的过程里面还有一个大数字的操作类,可以实现海量数字的计算(能提供的也是基础计算), 现在假设一个数字很大,超过了double范围.
那么这个时候将没有任何的数据类型可以保存下此类的内容,最早的时候只能通过String保存.

```
String str1 = "123";
String str2 = "244";
```

> 如果这个时候要想进行加法计算,那么就需要逐位拆分,每一位自己计算,而后自己独立控制进位处理.那么这样的开发难度是非常高的,所以为了解决这类的问题,提供有
两个大数字的操作类:BigInteger,BigDecimal;

![](http://imgs.loong.io/20190902203321_lwmMfr_Screenshot.jpeg)

> 之前分析了,当数字很大的时候只能够利用字符串描述数字操作,所以这一点可以观察两个大数字类的构造方法:
> - BigInteger类构造: `public BigInteger(String val)`;
> - BigDecimal类构造: `public BigDecimal(String val)`;

```java
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
```

> 需要注意的是,虽然提供有大数字的操作类,但是整体的操作之中还是需要考虑到我们的性能问题.

范例: 观察性能问题

```java
import java.math.BigInteger;

public class BigIntegerTest1 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("12345678912323213");
        System.out.println(bigInteger.pow(Integer.MAX_VALUE));
    }
}
```

> 此时的计算过程是十分缓慢的,所以任何的电脑都是有极限的.既然在进行数学计算的时候有可能无法进行整除处理,那么就可以使用其他的除法计算来求出余数;
> - 求余: `public BigInteger[] divideAndRemainder(BigInteger val)`.数组的第一个为商,第二个为余数;

范例: 求余除法

```java
import java.math.BigInteger;

public class BigIntegerTest2 {
    public static void main(String[] args) {
        BigInteger big1 = new BigInteger("1233434324324");
        BigInteger big2 = new BigInteger("12434324");
        BigInteger[] result = big1.divideAndRemainder(big2);
        System.out.println("商为 " + result[0] + ", 余数为 " + result[1]);
    }
}
```

> 如果在开发中真进行计算的时候,该计算没有超过基本数据类型所包含的位数,强烈不建议使用大数字类,因为这种计算性能是非常差的.

> BigDecimal的操作形式是和BigInteger是非常相似的,都有基础的数学支持.

范例: 使用BigDecimal计算

```java
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
```

> 但是在使用BigDecimal的时候会有一个数据进位的问题, 在这个类里面定义有如下的除法操作:
> - 除法操作: `public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)`;

范例: 使用BigDecimal实现四舍五入处理

```java
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
```

> Math的处理由于使用的都是基本数据类型,所以性能一定要高于大数字处理类的.



















