package 线程.多线程深入;

public class ThreadDemo {
    public static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            long num = 0;
            while (flag) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行, num = " + num++);
            }

        }, "运行线程").start();
        Thread.sleep(200); // 运行200ms
        flag = false; // 停止线程
    }
}
