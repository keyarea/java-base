package 正则表达式;

public class RegexTest3 {
    public static void main(String[] args) {
        String str = "100.1";
        String regex = "\\d+(\\.\\d+)?";
        System.out.println(str.matches(regex));
    }
}
