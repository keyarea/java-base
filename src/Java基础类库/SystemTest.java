package Java基础类库;

public class SystemTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String str = "1";
        for (int i = 0; i< 30000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时: " + (end - start));
    }
}
