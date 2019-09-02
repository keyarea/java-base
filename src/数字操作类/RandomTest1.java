package 数字操作类;

import java.util.Arrays;
import java.util.Random;

public class RandomTest1 {
    public static void main(String[] args) {
        int[] data = new int[7]; // 开辟一个能存放7个值的数组
        Random random = new Random();
        int foot = 0; // 脚标
        while (foot < 7){
            int flag = random.nextInt(37);
            if(isUse(flag, data)) {
                data[foot++] = flag;
            }
        }

        System.out.println(Arrays.toString(data));
    }

    public static boolean isUse(int flag, int[] data) {
        if(flag == 0) {
            return false;
        }

        for(int i = 0 ; i < data.length ; i ++) {
            if(flag == data[i]) {
                return false;
            }
        }
        return true;
    }


}
