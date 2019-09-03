package 日期处理类;

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
