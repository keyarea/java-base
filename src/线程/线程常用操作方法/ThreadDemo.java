package 线程.线程常用操作方法;


class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "线程A").start();
//        new Thread(mt).start();
//        new Thread(mt, "线程B").start();
        mt.run();
    }
}
