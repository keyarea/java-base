package 匿名内部类;

class Person{
    public void print(){
        System.out.println("hello world!!");
    }
}

public class TestDemo3 {
    public static void main(String[] args){
        Person per = new Person() { // 匿名内部类
            public void print(){
                System.out.println("ni hao!!");
            }
        };
        fun(per);
    }

    public static void fun(Person per){
        per.print();
    }
}
