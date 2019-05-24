package Lambda;

@FunctionalInterface
interface IMath{
    int add(int x, int y);
}

public class ArgsDemo {
    public static void main(String[] args){
//        IMath math = (x, y)->{
//            return x + y;
//        };
        IMath math = (x, y)->x +y;

        System.out.println(math.add(10, 20));
    }
}
