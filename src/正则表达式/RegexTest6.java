package 正则表达式;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegexTest6 {
    public static void main(String[] args) {
        String str = "fjsdojo3ojf9gjdfoj4ojfjos3423jofjdosjf";
        String regex = "[^a-zA-Z]+";
        Pattern pat = Pattern.compile(regex);
        String[] result = pat.split(str);
        System.out.println(Arrays.toString(result));
    }
}
