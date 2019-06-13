package 线程.线程常用操作方法;

public class ThreadDemo1 {
    public static void main(String[] args) {
        System.out.println("任务一");
        System.out.println("任务二");
//        int temp = 0;
//        for(int i = 0; i< Integer.MAX_VALUE; i++) {
//            temp+=i;
//        }
        new Thread(() -> {
            int temp = 0;
            for(int i = 0; i< Integer.MAX_VALUE; i++) {
                temp+=i;
            }
        }).start();
        System.out.println("任务N");
    }
}
