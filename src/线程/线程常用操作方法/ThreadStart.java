package 线程.线程常用操作方法;

public class ThreadStart {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(()-> {
            for(int x = 0; x < 100; x++ ) {
                if(x == 4) {
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "线程运行, x = " + x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程对象");
        thread.start();
        for (int y = 0; y < 100; y++) {
            System.out.println("main线程运行, y=" + y );
            Thread.sleep(100);
        }
    }
}
