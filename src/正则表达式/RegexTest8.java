package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest8 {
    public static void main(String[] args) {
        String str = "fjodsijfoi3jjojoi34234jfo3423";
        String regex = "\\D+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        System.out.println(mat.replaceAll(""));
    }
}
