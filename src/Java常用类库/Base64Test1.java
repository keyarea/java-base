package Java常用类库;

import java.util.Base64;

public class Base64Test1 {
    public static void main(String[] args) {
        String salt = "jfidsj";

        String str = "www.qipo.net" + salt; // 要进行加密的内容

        // 加密操作
        String enStr = new String(Base64.getEncoder().encode(str.getBytes()));
        System.out.println(enStr); // 加密之后的字符串

        // 解密操作
        String deStr = new String(Base64.getDecoder().decode(enStr));
        System.out.println(deStr); // 解密之后的字符串
    }
}
