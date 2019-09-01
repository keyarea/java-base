package Java基础类库;

public class RuntimeTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime(); // 获取实例化对象
        System.out.println(run.availableProcessors()); // 12
    }
}
