package Java基础类库;


import 包的定义及使用.message.Message;

public class AutoCloseableTest {
    public static void main(String[] args) {
        try(IMessage msg = new NetMessage("hello")) {
            msg.send();
        }catch (Exception e) {

        }
    }
}

interface IMessage extends AutoCloseable{
    public void send();
}

class NetMessage implements IMessage {
    private String msg;

    public NetMessage(String msg) {
        this.msg = msg;
    }

    private boolean open() {
        System.out.println("[open]获取消息发送链接资源");
        return true;
    }

    public void close() {
        System.out.println("[close]关闭消息发送链接资源");
    }


    @Override
    public void send() {
        if (this.open()) {
            System.out.println("[send]发送消息" + this.msg);
        }
    }
}
