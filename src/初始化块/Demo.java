package 初始化块;

import java.util.regex.Pattern;

class GrandPatent {
    static {
        System.out.println("父类静态初始化块");
    }
    {
        System.out.println("父类初始化块");
    }
    public GrandPatent() {
        System.out.println("父类构造函数");
    }
}

class Parent extends GrandPatent {
    static {
        System.out.println("子类静态初始化块");
    }
    {
        System.out.println("子类初始化块");
    }
    public Parent(){
        System.out.println("子类的构造函数");
    }
}

public class Demo{
    public static void main(String[] args){
        new Parent();
        /*
        父类静态初始化块
        子类静态初始化块
        父类初始化块
        父类构造函数
        子类初始化块
        子类的构造函数
        */
    }
}
