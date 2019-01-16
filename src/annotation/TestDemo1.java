package annotation;

class Person{
    public void say(){
        System.out.println("我是一个人");
    }
}

class Man extends Person{
    @Override  // 明确标识这是一个覆写操作
    public void say(){
        System.out.println("我是一个男人");
    }
}

public class TestDemo1 {
    public static void main(String[] args){
        new Man().say();  // 我是一个男人
    }
}
