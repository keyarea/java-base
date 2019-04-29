package 异常与处理;

class MyMath{

    // 如果该方法不进行异常的处理，一定要使用throw进行抛出
    public static int div(int x, int y)
    throws Exception{
        int result = 0;
        System.out.println("除法计算前");
        try{
            result = x / y; // 此处有异常，后面不进行处理
        }
//        catch (Exception e){
//            throw e; // 将错误抛出去
//        }
        finally {
            System.out.println("除法计算后");
        }

        return result;
    }
}

public class TestDemo {
    public static void main(String[] args){
        try {
            System.out.println(MyMath.div(10, 0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
