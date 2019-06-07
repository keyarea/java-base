package Lambda;
import java.util.function.*;

/**
 * 内建函数式接口
 */

public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // 功能性函数式接口
        Function<String, Boolean> fun = "**Hello"::startsWith;
        System.out.println(fun.apply("**"));

        // 消费性函数式接口
        Consumer<String> con = System.out::println;
        con.accept("hello world");

        // 供给性函数式接口
        Supplier<String> supplier = "HELLO"::toLowerCase;
        String str = supplier.get();
        System.out.println(str);

        // 断言性函数式接口
        Predicate<String> predicate = "hello"::equalsIgnoreCase;
        System.out.println(predicate.test("HELLO"));
    }
}
