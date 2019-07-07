package 线程.多线程相关案例;

import java.util.function.Predicate;

class Computer {
   private static int count = 0;
   private String name;
   private double price;

   public Computer(String name,double price) {
       this.name = name;
       this.price = price;
       count++;
   }

    @Override
    public String toString() {
       return "第" + count + "台电脑,电脑名字: " + this.name + ", 电脑价格: " + this.price;
    }
}

class Asset {
    private Computer computer;

    public synchronized void make() throws Exception{
        while (this.computer != null) {
            super.wait();
        }
        this.computer = new Computer("浪潮", 1200.00);
        System.out.println("生产电脑:" + this.computer);
        super.notifyAll();
    }

    public synchronized void get() throws Exception {
        while (this.computer == null) {
           super.wait();
        }
        System.out.println("搬运电脑:" + this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

class Producer implements Runnable{
    private Asset asset;

    public Producer(Asset asset) {
        this.asset = asset;
    }

    @Override
    public void run() {
        for (int x = 0 ; x < 50 ; x++) {
            try {
                this.asset.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Asset asset;

    public Consumer(Asset asset) {
        this.asset = asset;
    }

    @Override
    public void run() {
        for (int x = 0 ; x < 100 ; x ++) {
            try {
                this.asset.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadDemo1 {
    public static void main(String[] args) {
        Asset asset = new Asset();
        Producer pt = new Producer(asset);
        Consumer ct = new Consumer(asset);

        new Thread(pt, "生产电脑-1").start();
        new Thread(pt, "生产电脑-2").start();
        new Thread(ct, "搬运电脑-1").start();
        new Thread(ct, "搬运电脑-2").start();
    }
}
