package Java常用类库;



public class OptionalTest {
    public static void main(String[] args) {
        print(null);
    }

    private static void print(String str){
        if(str != null){
            System.out.println(str.toString());
        }
    }
}
