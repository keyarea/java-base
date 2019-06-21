package 线程.线程的同步与死锁;

class SaleTicket implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
        while (true) {
            if(this.ticket > 0) {
                try {
                    Thread.sleep(100); // 模拟网络延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票, 还有票" + this.ticket --);
            }else{
                System.out.println("票已经卖光了!!");
                break;
            }
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();
        new Thread(st, "票贩子1").start();
        new Thread(st, "票贩子2").start();
        new Thread(st, "票贩子3").start();

    }

}
