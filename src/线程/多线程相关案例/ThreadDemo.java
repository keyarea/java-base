package 线程.多线程相关案例;

class Resource {
    private int num = 0;
    private boolean flag = true;
    // flag为true可以执行加法操作,不可以执行减法操作
    // flag为false可以执行减法操作,不可以执行加法操作
    public synchronized void add() throws Exception {
       while (!this.flag) { // flag为false只能执行减法操作
           super.wait(); // 需要等待
       }
       Thread.sleep(100);
        this.num++;
        System.out.println(Thread.currentThread().getName() + "运行, num = " + this.num);
        this.flag = false; // 可以进行减法操作
        super.notifyAll(); // 唤醒其他线程
    }
    public synchronized void sub() throws Exception {
        while(this.flag) { // flag为true只能进行加法操作,减法操作需要等待
            super.wait();
        }
        Thread.sleep(100);
        this.num--;
        System.out.println(Thread.currentThread().getName() + "运行, num = " + this.num);
        this.flag = true    ; // 可以进行加法操作
        super.notifyAll(); // 唤醒其他线程
    }
}

class AddThread implements Runnable {
    private Resource res;

    public AddThread(Resource res) {
        this.res = res;
    }
    @Override
    public void run() {
        for (int i = 0 ; i < 50 ; i++) {
            try {
                this.res.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable {
    private Resource res;

    public SubThread(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 50 ; i++) {
            try {
                this.res.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Resource res = new Resource();
        AddThread at = new AddThread(res);
        SubThread st = new SubThread(res);

        new Thread(at, "加法操作-1").start();
        new Thread(at, "加法操作-2").start();

        new Thread(st, "减法操作-1").start();
        new Thread(st, "减法操作-2").start();
    }
}
