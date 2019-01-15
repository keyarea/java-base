package 匿名内部类;

/**
 * 在抽象类中使用匿名内部类
 */
abstract class Product{
    public abstract String getInfo();

    public void print(){
        System.out.println(this.getInfo());
    }

}

public class TestDemo2 {
    public static void main(String[] args){
        Product pro = new Product() { // 匿名内部类
            public String getInfo(){
                return "hello world";
            }
        };

        fun(pro);
    }

    public static void fun(Product pro){
        pro.print();
    }
}
