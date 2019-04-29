package 异常与处理;

public class ExceptionHandle {
    public static void main(String[] args){
        System.out.println("[1] 数学计算前");
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("[2] 数学计算中：result = " + (x / y));
        } catch (ArithmeticException e){
            // System.out.println("[catch] 异常已经被处理！");
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("[finally] 不管是否有异常都一定执行此语句。");
        }
        System.out.println("[3] 数学计算后");
    }
}
