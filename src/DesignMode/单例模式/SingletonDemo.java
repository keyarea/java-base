package DesignMode.单例模式;

// 懒汉式单例

class Message {
    private static Message instance = null;

    public static Message getInstance(){
        if(instance == null) {
            instance = new Message();
        }
        return instance;
    }

    private Message(){};  // 构造函数私有化， 外部无法实例化

    public void print(){
        System.out.println("Hello Wolrd!!");
    }
}

public class SingletonDemo {
    public static void main(String[] args){
        Message message = null; // 声明一个对象
        message = Message.getInstance();
        message.print();
    }
}
