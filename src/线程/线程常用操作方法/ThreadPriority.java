package 线程.线程常用操作方法;

/**
 * 线程优先级
 */

public class ThreadPriority {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int x = 0; x < 10; x++) {
                System.out.println(Thread.currentThread().getName()+ "执行");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread threadA = new Thread(run, "线程A");
        Thread threadB = new Thread(run, "线程B");
        Thread threadC = new Thread(run, "线程C");
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadC.setPriority(Thread.MIN_PRIORITY);

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
