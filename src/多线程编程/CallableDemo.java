package 多线程编程;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class FourthThread implements Callable<String> {
    @Override
    public String call() {
        for (int i = 0; i < 10; i++){
            System.out.println("线程执行, i=" + i);
        }
        return "线程执行结束";
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<>(new FourthThread());
        new Thread(task).start();
        System.out.println("线程返回数据:" + task.get());
    }
}
