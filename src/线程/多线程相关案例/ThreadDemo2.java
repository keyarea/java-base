package 线程.多线程相关案例;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<String> {
    private boolean flag = false;
    @Override
    public String call() throws Exception {
        synchronized (this) {
            if (!this.flag) {
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功!";
            }else{
                return Thread.currentThread().getName() + "抢答失败!";
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<String> task1 = new FutureTask<>(myThread);
        FutureTask<String> task2 = new FutureTask<>(myThread);
        FutureTask<String> task3 = new FutureTask<>(myThread);

        new Thread(task1, "竞赛者A").start();
        new Thread(task2, "竞赛者B").start();
        new Thread(task3, "竞赛者C").start();

        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());

    }
}
