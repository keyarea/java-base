package 线程.生产者与消费者模型;

class Message {
    private String title;
    private String content;
    private boolean flag = true;
    // flag 为true,代表着允许生产,不允许消费
    // flag 为false,代表着允许消费,不允许生产
    public synchronized void set (String title, String content) {
        if (!this.flag) { // 还未消费,等待消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        this.content = content;
        this.flag = false; // 生产完成了
        this.notify(); // 唤醒等待的线程
    }

    public synchronized String get () {
        if (this.flag) { // 还未生产,等待生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title + " -  " + this.content;
        }finally {
            this.flag = true; // 继续生产
            super.notify(); // 唤醒等待的线程
        }
    }

}

class Producer implements Runnable {
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0 ; x < 100 ; x ++) {
            if (x % 2 == 0) {
                msg.set("王五", "王家第五子");
            } else {
                msg.set("赵六", "赵家第六字");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg;

    public Consumer (Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0 ; x < 100 ; x ++) {
            System.out.println(msg.get());
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
