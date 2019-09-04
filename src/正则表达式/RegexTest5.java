package 正则表达式;

public class RegexTest5 {
    public static void main(String[] args) {
        String str = "mail@qipo.net";
        String regex = "[a-zA-Z0-9]\\w+@\\w+.(net|com|cn|org|gov|com.cn)";
        System.out.println(str.matches(regex));
    }
}
