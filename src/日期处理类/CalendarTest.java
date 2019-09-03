package 日期处理类;

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
