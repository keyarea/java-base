package Java基础类库;

//import java.lang.ref.*;
//
//class Example implements Runnable{
//    public Example (){
//        System.out.println("该类被创建了");
//    }
//
//    @Override
//    public void run() {
//        System.out.println("我还活着");
//    }
//}
//
//class ExampleCleaner implements AutoCloseable {
//    private static final Cleaner cleaner = Cleaner.create();
//    private static Example example;
//    private Cleanable cleanable;
//
//    public ExampleCleaner () {
//        this.example = new Example(); // 创建新对象
//        this.cleanable = this.cleaner.register(this, this.example); // 注册使用的对象
//    }
//    @Override
//    public void close() throws Exception {
//        this.cleanable.clean(); // 启动多线程
//    }
//}

public class CleanerTest {
    public static void main(String[] args) {

//        try(ExampleCleaner ec = new ExampleCleaner()) {
//            // 执行相关代码
//        }catch (Exception e){}
    }
}
