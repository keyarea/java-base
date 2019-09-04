package 正则表达式;

import java.util.Arrays;

public class RegexTest2 {
    public static void main(String[] args) {
        String str = "fi2121d2jf3oij1fj";
        String regex = "\\d+";
        String[] result = str.split(regex);
        System.out.println(Arrays.toString(result));
    }
}
