package 线程.线程的同步与死锁;

class SaleThread implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized(this) { // 同步代码快
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
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();

        Thread threadA = new Thread(saleThread, "票贩子1");
        Thread threadB = new Thread(saleThread, "票贩子2");
        Thread threadC = new Thread(saleThread, "票贩子3");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
