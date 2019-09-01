package Java基础类库;

public class FinalizeTest {
    public static void main(String[] args) {
        Member m = new Member();
        m = null; // 成为垃圾
        System.gc();
        System.out.println("照常运行");
    }
}

class Member {
    public Member() {
        System.out.println("类诞生了!");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("类回收");
        throw new Exception("我还活着");
    }
}
