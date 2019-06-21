package 线程.线程常用操作方法;

/**
 * 线程礼让
 */

public class ThreadYield {
    public static void main(String[] args) throws Exception{
        Thread mainThread = Thread.currentThread();
        Thread th = new Thread(()-> {
            for (int x = 0; x < 100; x++) {

                if(x % 3 == 0) {
                    Thread.yield();
                    System.out.println("子线程礼让");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "线程运行了, x = " + x);
            }
        });
        th.start();

        for (int y = 0; y < 100; y++) {
            System.out.println("main线程运行, y=" + y );
            Thread.sleep(100);
        }
    }
}
