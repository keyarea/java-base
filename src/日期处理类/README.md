# 日期处理类

> 从整体的java来讲一直在强调简单java类的主要设计来自于数据表的结构，那么在数据表的结构里面常用的类型：数字、字符串、日期。

## Date类

> 在Java里面提供有一个`java.util.Date`的类，这个类直接实例化就可以获取当前的日期时间。

范例： 观察java.util.Date类

```java
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);  // Tue Sep 03 10:52:01 CST 2019
    }
}
```
> 这个时候需要进一步的去观察Date类中的构造方法：

```
// Date类中的无参构造
public Date() {
    this(System.currentTimeMillis());
}
    
// Date类中的有参构造
public Date(long date) {
    fastTime = date;
}
```

> 通过以上的源代码分析可以得出一个结论：Date类中只是对long数据的一种包装。所以Date类中一定提供有Date与long数据类型转换的方法：
> - 将long数据类型转为日期：`public Date(long date)`;
> - 将Date转为long数据类型：`public long getTime()`;

范例：观察Date与long之间的转换

```java
import java.util.Date;

public class DateTest1 {
    public static void main(String[] args) {
        Date date = new Date();
        long current = date.getTime();
        current += 864000 * 1000; // 加上10天
        System.out.println(new Date(current));
    }
}
```

> long之中可以保存毫秒的数据级，这样方便程序处理。

## 日期格式化

> 虽然Date可以获取当前的日期时间，但是默认情况下Date类输出的日期时间结构并不能够被我们国人所习惯，那么现在就需要对显示的格式进行格式化的处理，为了可以格式化日期，在java.text
包中提供有SimpleDateFormat程序类。
> 该类是DateFormat类的子类，在该类中提供有如下的方法：
> - [DateFormat继承]将日期格式化：`public final String format(Date date)`;
> - [DateFormat继承]将字符串转为日期：`public Date parse(String source) throws parseException`;
> - 构造方法：`public SimpleDateFormat(String pattern)`;
>  - 日期格式：年（yyyy），月（MM），日（dd），时（HH），分（mm），秒（ss），毫秒（SSS）;

范例：格式化日期显示

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss.SSS");
        String str = simpleDateFormat.format(date);
        System.out.println(str); // 2019-09-03 14:09:24.415
    }
}
```

> 除了可以将日期格式化为字符串之后，也可以字符串与日期之间的格式化转换处理。

范例： 将日期转为Date

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest1 {
    public static void main(String[] args) throws Exception {
        String birthday = "1994-06-23 12:23:23.988";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = simpleDateFormat.parse(birthday);
        System.out.println(date); // Thu Jun 23 12:23:23 CST 1994
    }
}
```

> 如果在进行字符串定义的时候，所使用的日期时间数字超过了指定的合理范围，则会自动进位处理

范例：数字格式化

```java
import java.text.NumberFormat;

public class NumberFormatTest {
    public static void main(String[] args) {
        double num = 123232343.23;
        String str = NumberFormat.getInstance().format(num);
        System.out.println(str); // 123,232,343.23
    }
}
```

> String可以向所有类型转换，基本类型、日期类型。

## Calendar类

> Calendar是Java提供的一个util类，在java.util中。我们在开发过程中经常遇到，需要对时间进行处理的方式。而Java中Calendar给我们提供了很好的控制方式。

范例：获取时间

```java
import java.util.Calendar;

/**
 * 获取时间
 */

public class CalendarTest {
    public static void main(String[] args) {
        // 使用默认时区和语言环境获取一个日历
        Calendar calendar = Calendar.getInstance();
        //  赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        System.out.println("月：" + calendar.get(Calendar.MONTH) + 1);
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));
    }
}
```

范例：设置时间

```java
import java.util.Calendar;

public class CalendarTest1 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1
        // cal.set(year, month, date, hourOfDay, minute, second);
        cal.set(2018, 1, 15, 23, 59, 59);
        System.out.println(cal.getTime());

        // 单个字段一一设置
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2018);
        cal1.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal1.set(Calendar.DAY_OF_MONTH, 15);
        cal1.set(Calendar.HOUR_OF_DAY, 23);
        cal1.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.SECOND, 59);
        System.out.println(cal1.getTime());
    }
}
```

范例：时间计算

```java
import java.util.Calendar;

public class CalendarTest2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.MARCH, 15, 23, 59, 59);
        cal.add(Calendar.SECOND, 1);
        System.out.println(cal.getTime());  // Fri Feb 16 00:00:00 CST 2018

        // 1月31号加一个月会出现什么情况呢？是2月31号？
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2019, Calendar.JANUARY, 31, 8, 0, 0);
        System.out.println(cal1.getTime());
        cal1.add(Calendar.MONTH, 1);
        System.out.println(cal1.getTime());
    }
}
```

> 说明 add 月份时，会将不存在的日期归为当月日历的最后一天。






