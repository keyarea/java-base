package Lambda;

@FunctionalInterface
interface IPrint{
    void print();
}

public class NoArgumentsDemo {
    public static void main(String[] args){
        IPrint print = ()->{
            System.out.println("hello world!!");
        };
        print.print();
    }
}
