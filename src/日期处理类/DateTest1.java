package 日期处理类;

import java.util.Date;

public class DateTest1 {
    public static void main(String[] args) {
        Date date = new Date();
        long current = date.getTime();
        current += 864000 * 1000; // 加上10天
        System.out.println(new Date(current));
    }
}
