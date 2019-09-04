package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest7 {
    public static void main(String[] args) {
        String str = "101";
        String regex = "\\d+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        System.out.println(mat.matches());
    }
}
