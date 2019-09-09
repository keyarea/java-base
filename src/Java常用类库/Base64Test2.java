package Java常用类库;

import java.util.Base64;

class StringUtil{
    private static final int REPEAT = 5; // 加密次数
    private static final String SALT = "qipo"; // 盐值
    private StringUtil(){}

    /**
     * 加密处理
     * @param str 需要加密的字符串
     * @return 加密后的数据
     */
    public static String encode(String str) { // 加密处理
        String temp =   str + "{" + SALT + "}"; // 盐值不对外公布
        byte[] data = temp.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }

    /**
     * 解密处理
     * @param str 需要进行解密的字符串
     * @return 解密之后的数据
     */
    public static String decode(String str) {
        byte[] data = str.getBytes();
        for (int i = 0; i < REPEAT ; i++) {
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replaceAll("\\{\\w+\\}", "");
    }
}

public class Base64Test2 {
    public static void main(String[] args) {
        String temp = "www.qipo.net";

        String encodeStr = StringUtil.encode(temp);
        System.out.println(encodeStr);
        String decodeStr = StringUtil.decode(encodeStr);
        System.out.println(decodeStr);
    }
}
