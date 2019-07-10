package Java基础类库;

/**
 * String类的引用传递
 */

public class JavaApiDemo {
    public static void main(String[] args) {
        String hello = "Hello";
        change(hello);
        System.out.println(hello); // hello字符串并没有发生改变
    }

    public static void change(String temp) {
        temp += " World";
    }
}
