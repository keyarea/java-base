package Lambda;

/**
 * 方法引用
 */



// P描述的是参数,R描述的是返回值
@FunctionalInterface // 函数式接口
interface IFunction<P,R>{
    public R change(P p);
}

@FunctionalInterface
interface IMethod<R> {
    public R upper();
}

@FunctionalInterface //函数式接口
interface ICompare<P> {
    public int compare(P p1, P p2);
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名:" + this.name + ", 年龄: " + this.age;
    }
}

@FunctionalInterface
interface ICreate<R> {
    public R create(String name, int age);
}


public class MethodReferenceDemo {
    public static void main(String[] args){
        // 方法引用,静态方法
        IFunction<Integer, String> fun = String :: valueOf;
        String str = fun.change(100);
        System.out.println(str.length());

        // 方法引用,实例化对象方法
        IMethod<String> method = "hello world" :: toUpperCase;
        String upperStr = method.upper();
        System.out.println(upperStr);

        // 引用特定类中方法
        ICompare<String> function = String::compareTo;
        int num = function.compare("A", "a");
        System.out.println(num);

        // 引用构造方法
        ICreate<Person> f = Person::new;
        System.out.println(f.create("王五", 23));
    }
}
