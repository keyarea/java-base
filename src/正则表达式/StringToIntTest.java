package 正则表达式;

public class StringToIntTest {
    public static void main(String[] args) {
        String str = "123213";
        if(isNumber(str)) {
            int num = Integer.parseInt(str);
            System.out.println(num * 2);
        }
    }


    public static boolean isNumber(String str) {
        char[] list = str.toCharArray();
        for (int i = 0 ; i < list.length ; i++) {
            if(list[i] > '9' || list[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
