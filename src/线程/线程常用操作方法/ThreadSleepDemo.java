package 线程.线程常用操作方法;

public class ThreadSleepDemo {
    public static void main(String[] args) {
        new Thread(()-> {
            for (int x = 0; x < 10; x++) {
                System.out.println(Thread.currentThread().getName() + ", x = " + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
    }
}
