package Object类;

class Produce{
    private int age;
    private String name;
    public Produce(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class TestDemo1 {
    public static void main(String[] args){

        // String是Object类的子类
        fun("helloworld");      // helloworld

        // 自定义对象
        fun(new Produce("kyle", 24));  // Object类.Produce@61bbe9ba

        print("helloworld");  //  helloworld
        print(new Produce("kyel", 24)); // Object类.Produce@610455d6
    }

    // 默认输出，对象调用的就是toString()方法
    public static void fun(Object obj){
        System.out.println(obj);
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}
