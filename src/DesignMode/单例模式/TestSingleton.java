package DesignMode.单例模式;

// 饿汉式单例设计

class Singleton {
    // 在类的内部是允许访问私有的结构的，所以可以在类的内部产生实例化对象
    private final static Singleton INSTANCE = new Singleton(); // 内部产生实例化对象

    public static Singleton getInstance(){
        return INSTANCE;
    }

    private Singleton(){}  // 任何方法都可以使用那四种权限

    public void print(){
        System.out.println("Hello World");
    }
}

public class TestSingleton {
    public static void main(String[] args){
        Singleton singleton = null; // 声明一个变量
        // singleton = new Singleton(); // 实例化对象
        // singleton.print();
        singleton = Singleton.getInstance(); // 实例化对象
        singleton.print();
    }
}
