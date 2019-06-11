package 多线程编程;

/**
 * 继承Thread类实现多线程
 */

class MyThread extends Thread { // 线程的主体类
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }
}

/**
 * 通过实现Runnable接口实现多线程
 */

class SecondThread implements Runnable { // 线程的主体类
    private String title;
    public SecondThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }

}

public class ThreadDemo {
    public static void main(String[] args) {

        /*
         * 继承Thread类的方式实现多线程
         */

//        new MyThread("线程A").start();
//        new MyThread("线程B").start();
//        new MyThread("线程C").start();

        /*
         * 实现Runnable接口的方式实现多线程
         */

//        Thread threadA = new Thread(new SecondThread("线程A"));
//        Thread threadB = new Thread(new SecondThread("线程B"));
//        Thread threadC = new Thread(new SecondThread("线程C"));
//        threadA.start();
//        threadB.start();
//        threadC.start();

        /*
         * 利用Lambda表达式实现多线程
         */

        /*for(int x = 0; x < 3; x++) {
            String title = "进程" + x;
            Runnable run = () -> {
                for (int y = 0; y < 10; y++){
                    System.out.println(title + "运行, y = " + y);
                }
            };
            new Thread(run).start();
        }*/
        for(int x = 0; x < 3; x++) {
            String title = "进程" + x;
            new Thread(() -> {
                for (int y = 0; y < 10; y++){
                    System.out.println(title + "运行, y = " + y);
                }
            }).start();
        }


    }
}
