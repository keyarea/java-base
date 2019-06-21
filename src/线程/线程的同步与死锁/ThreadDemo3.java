package 线程.线程的同步与死锁;

class TicketThread implements Runnable {
    private int ticket = 100;
    public synchronized boolean sale() {
        if(this.ticket > 0) {
            try {
                Thread.sleep(100); // 模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票, 还有票" + this.ticket --);
            return true;
        }else{
            System.out.println("票已经卖光了!!");
            return false;
        }
    }
    @Override
    public void run() {
        while (this.sale()) {
            ;
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable run = new TicketThread();
        new Thread(run, "票贩子1").start();
        new Thread(run, "票贩子2").start();
        new Thread(run, "票贩子3").start();
    }
}
