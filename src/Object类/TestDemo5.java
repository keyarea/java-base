package Object类;

public class TestDemo5 {
    public static void main(String[] args){
        // 利用Object接收数组，向上转型
        Object arr = new int[]{1, 2, 3};
        // 向下转型，需要强制类型转换
        int[] result = (int[]) arr;

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]+ "、");
        }

    }
}
