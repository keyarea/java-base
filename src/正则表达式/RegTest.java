package 正则表达式;

public class RegTest {
    public static void main(String[] args) {
//        String str = "sdf";
        String str = "123";
        if(str.matches("\\d+")){
            int num = Integer.parseInt(str);
            System.out.println(num * 2);
        }
    }
}
