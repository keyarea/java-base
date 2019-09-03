package 日期处理类;

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
