package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest9 {
    public static void main(String[] args) {
        String str = "hello${var},my name is ${name}";
        String regEx = "\\$\\{\\w+\\}";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        while (mat.find()) {
            System.out.println(mat.group(0).replaceAll("\\$|\\{|\\}", ""));
        }
    }
}
