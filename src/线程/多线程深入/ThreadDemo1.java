package 线程.多线程深入;

public class ThreadDemo1 {
    public static void main(String[] args) {

        Thread userThread = new Thread(() -> {
            for (int x = 0 ; x < 10 ; x++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行, x = " + x);
            }
        }, "用户线程");

        Thread daemonThread = new Thread(() -> {
            for (int x = 0 ; x < Integer.MAX_VALUE; x++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行, x = " + x);
            }
        }, "守护线程");

        daemonThread.setDaemon(true); // 设置为守护线程
        userThread.start();
        daemonThread.start();

    }
}
