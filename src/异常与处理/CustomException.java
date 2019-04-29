package 异常与处理;

class AddException extends Exception{
    public AddException(String msg){
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args)
    throws Exception{
        int x = 10;
        int y = 20;
        if((x+y) == 30){
            throw new AddException("错误的相加操作");
        }
    }

}
