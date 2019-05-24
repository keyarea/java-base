package Lambda;

@FunctionalInterface //函数式接口
interface IMessage {
    void send(String str);
}


public class Demo {
    public static void main(String[] args){
        IMessage message = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println("消息发送：" + str);
            }
        };
        message.send("hello world");
    }
}
