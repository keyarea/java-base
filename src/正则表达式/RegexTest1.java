package 正则表达式;

public class RegexTest1 {
    public static void main(String[] args) {
        String str = "djfosdjfoj3j4o3#@#@OJOjojoj@J#$JOjoj";
        String regex = "[^a-zA-Z0-9]+";
        System.out.println(str.replaceAll(regex, ""));
    }
}
