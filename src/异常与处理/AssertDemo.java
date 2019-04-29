package 异常与处理;

public class AssertDemo {
    public static void main(String[] args){
        int num = 0;
        // 中间经过很多步骤，预计num的值变为300
        assert num == 100 : "错误：num的值不为100";
        System.out.println(num);
    }
}
