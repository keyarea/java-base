package Java常用类库;

import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "定时任务启动, 当前时间为: " + System.currentTimeMillis());
    }
}

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer(); // 定时任务
        // 定义间隔任务,1000毫秒之后开始执行,1000毫秒执行一次
        timer.scheduleAtFixedRate(new MyTask(), 1000, 1000);
//        timer.schedule(new MyTask(), 1000); // 1000毫秒之后开始执行
    }
}
