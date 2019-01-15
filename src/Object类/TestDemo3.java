package Object类;

class Animal{
    private String name;
    private int age;

    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
}

public class TestDemo3 {
    public static void main(String[] args){
        String result = "hello," + new Animal("doudou",12);
        System.out.println(result); // hello,姓名：doudou，年龄：12
    }
}
