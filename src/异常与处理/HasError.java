package 异常与处理;

public class HasError {
    public static void main(String[] args){
        System.out.println("[1] 数学计算前");
        System.out.println("[2] 数学计算中：result = " + (10 / 0)); // 错误 分母不能为0
        System.out.println("[3] 数学计算后");
    }
}
