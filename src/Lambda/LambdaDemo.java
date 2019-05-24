package Lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        IMessage message = str -> {
            System.out.println("发送消息：" + str);
        };
        message.send("hello world");
    }
}
