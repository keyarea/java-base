package 匿名内部类;

interface IMessage{ // 定义了一个接口
    public void print();

}

class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("hello world!!");
    }
}

public class TestDemo {
    public static void main(String[] args){
        IMessage msg = new MessageImpl();
        fun(msg);
    }

    public static void fun(IMessage temp) {
        temp.print();
    }
}
