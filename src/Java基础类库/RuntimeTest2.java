package Java基础类库;

public class RuntimeTest2 {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println("[1]MAX_MEMORY: " + run.maxMemory());
        System.out.println("[1]TOTAL_MEMORY: " + run.totalMemory());
        System.out.println("[1]FREE_MEMORY: " + run.freeMemory());

        String str = "";
        for (int i = 0;i < 2000; i++) {
            str += i;
        }

        System.out.println("[2]MAX_MEMORY: " + run.maxMemory());
        System.out.println("[2]TOTAL_MEMORY: " + run.totalMemory());
        System.out.println("[2]FREE_MEMORY: " + run.freeMemory());

        run.gc();

        System.out.println("[3]MAX_MEMORY: " + run.maxMemory());
        System.out.println("[3]TOTAL_MEMORY: " + run.totalMemory());
        System.out.println("[3]FREE_MEMORY: " + run.freeMemory());
    }
}
