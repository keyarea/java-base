package 异常与处理;

public class ThrowException {
    public static void main(String[] args){
        try{
            throw new Exception("一个异常"); // 抛出一个异常
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
