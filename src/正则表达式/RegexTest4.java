package 正则表达式;

import java.text.SimpleDateFormat;

public class RegexTest4 {
    public static void main(String[] args) throws Exception{
        String str = "1994-09-12";
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        if(str.matches(regex)) {
            System.out.println((new SimpleDateFormat("yyyy-MM-dd")).parse(str));
        }
    }
}
