package 泛型数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo1 {
    public static void main(String[] args){
        // 数组
        int actual = 2;
        // 新建一个固定容量的数组
        String[] staff = new String[actual];
        // 这时创建的数组会有2个空位置可以用

        for(String item : staff){
            // 此时会输出两个null
            System.out.println(item);
        }

        // ArrayList
        // 新建一个容量为100的数组列表
        ArrayList<String> list = new ArrayList<>(100);

        // 添加一个元素
        list.add("hello");

        for(String i : list){
            // 此时会输出hello
            System.out.println(i);
        }
        // 数组列表的容量和数组的大小有非常重要的区别。
        // 从上面的输出可以看出，数组的大小代表着这个数组有多少个空位置可以使用
        // 而数组列表容量为多少只代表这个数组列表有保存这个数量的潜力，完成初始化构造之后，数组列表根本就不包含任何元素。

        // 返回数组列表的大小
        System.out.printf("数组列表的大小：%d \n",list.size());

        // 设置位置为0的元素的值
        list.set(0, "world");

        // 得到位置为0的元素的值
        System.out.printf("位置为0的值为：%s \n", list.get(0));

        // 添加几个值
        list.add("ni");
        list.add("hao");

        printList(list);

        // 在指定位置添加一个值
        list.add(0, "hello");

        printList(list);

        // 在指定位置删除一个元素
        list.remove(2);

        printList(list);

        // 确定容量之后，调用该方法将多余空间回收
        list.trimToSize();

        // 将数组列表转化为数组
        String[] message =  list.toArray(new String[0]);
        // 上面的方法在新版本中更快
        //String[] message =  list.toArray(new String[list.size()]);

        // 将一个数组转化为数组列表
        // List为ArrayList的接口
        List<String> group = Arrays.asList(staff);

    }

    private static void printList(ArrayList<String> list){
        System.out.print("数组列表元素：");
        for(String item : list){
            System.out.print(item+";");
        }
        System.out.println();
    }
}
