package 线程.线程常用操作方法;

/**
 * 多个线程休眠
 */
public class MultiThreadSleepDemo {
    public static void main(String[] args) {
        for (int x = 0; x < 5; x++) {
            Runnable run = ()-> {
                for(int y = 0; y < 10; y++){
                    System.out.println(Thread.currentThread().getName() + ", y = " + y);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(run, "线程-"+ x).start();
        }
    }
}
