package Object类;

class Person{

}

class Message{

}

public class TestDemo {

    public static void main(String[] args){
        fun(new Message());
        fun(new Person());
    }

    public static void fun(Object obj){
        System.out.println(obj);
    }
}
