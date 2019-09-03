package 日期处理类;

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
