package Java基础类库;

/**
 * StringBuffer类的引用传递
 */

public class JavaApiDemo1 {
    public static void main(String[] args) {
        String str = "Hello";
        StringBuffer buf = new StringBuffer(str);
        change(buf);
        System.out.println(buf); //  Hello World
    }

    public static void change(StringBuffer buf) {
        buf.append(" World");
    }
}
