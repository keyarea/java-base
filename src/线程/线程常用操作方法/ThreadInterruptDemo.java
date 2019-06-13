package 线程.线程常用操作方法;

public class ThreadInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> {
            System.out.println("午休一下!!");
            try {
                Thread.sleep(100000);
                System.out.println("2点到了,该上班了!!");
            } catch (InterruptedException e) {
                System.out.println("打扰老子睡觉,老子宰了你!");
            }
        });
        thread.start();
        Thread.sleep(1000);

        if(!thread.isInterrupted()) {
            System.out.println("打扰一下,有点急事.");
            thread.interrupt();
        }
    }
}
