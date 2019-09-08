package Java常用类库;

class Message {
    private String meg;

    public String getMeg() {
        return meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }
}

class Channel {
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<>();
    private Channel(){}
    public static void setMessage(Message m) {
        THREAD_LOCAL.set(m);
    }

    public static void send() {
        System.out.println("[发送消息]" + Thread.currentThread().getName() + "-" + THREAD_LOCAL.get().getMeg());
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Message msg = new Message();
            msg.setMeg("线程A的消息");
            Channel.setMessage(msg);
            Channel.send();
        }, "线程A").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setMeg("线程B的消息");
            Channel.setMessage(msg);
            Channel.send();
        }, "线程B").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setMeg("线程C的消息");
            Channel.setMessage(msg);
            Channel.send();
        }, "线程C").start();

    }
}
