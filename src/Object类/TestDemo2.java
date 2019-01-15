package Object类;

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }


    // 覆写Object中的toString()方法
    @Override
    public String toString(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
}

public class TestDemo2 {
    public static void main(String[] args){
        print("hello");  // hello
        print(new Dog("doudou", 12)); // 姓名：doudou，年龄：12
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
