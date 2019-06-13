package 线程.多线程编程;

/**
 * 卖票程序
 */

class ThirdThread implements Runnable {
    private int ticket = 5;
    @Override
    public void run() {
        for(int x = 0; x < 100; x++){
            if(this.ticket > 0) {
                System.out.println("现在的票数为:" + this.ticket--);
            }
        }
    }
}

public class SaleOfTickets {
    public static void main(String[] args) {
        Runnable run = new ThirdThread();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}
