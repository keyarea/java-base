package 线程.多线程深入;

class Ticket_sale implements Runnable {
    private volatile int ticket = 5;
    @Override
    public void run() {
        synchronized (this) {
            while (this.ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票, 现在票数为 " + this.ticket--);
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        Ticket_sale ts = new Ticket_sale();
        new Thread(ts, "票贩子1").start();
        new Thread(ts, "票贩子2").start();
        new Thread(ts, "票贩子3").start();
    }
}
