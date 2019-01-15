package 匿名内部类;

interface Message{
    public void print();
}

public class TestDemo1 {
    public static void main(String[] args) {
        Message msg = new Message(){ // 匿名内部类
            public void print(){
                System.out.println("hello world!!");
            }
        };

        fun(msg);

    }

    public static void fun(Message msg){
        msg.print();
    }
}
