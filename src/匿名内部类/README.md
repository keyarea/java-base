# 匿名内部类

在研究匿名内部类之前，首先来看以下的一段程序。

观察程序的问题：

[程序](TestDemo.java)

```java
interface IMessage{ // 定义了一个接口
    public void print();

}

class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("hello world!!");
    }
}

public class TestDemo {
    public static void main(String[] args){
        IMessage msg = new MessageImpl();
        fun(msg);
    }

    public static void fun(IMessage temp) {
        temp.print();
    }
}
```

如果说现在MessageImpl子类只使用一次。还有必要将其定义为单独的一个类吗？

很明显，这就很浪费。

那么此时就可以利用匿名内部类的概念来解决。

[程序](TestDemo1.java)

```java
interface Message{
    public void print();
}

public class TestDemo1 {
    public static void main(String[] args) {
        Message msg = new Message(){ // 匿名内部类
            public void print(){
                System.out.println("hello world!!");
            }
        };
        
        fun(msg);

    }

    public static void fun(Message msg){
        msg.print();
    }
}
```

通过这样的程序可以得出一个结论：基本上搞匿名内部类都应该是在接口或者抽象类的形式上完成的。

范例：[在抽象类中使用匿名内部类](TestDemo2.java)

```java
abstract class Product{
    public abstract String getInfo();

    public void print(){
        System.out.println(this.getInfo());
    }

}

public class TestDemo2 {
    public static void main(String[] args){
        Product pro = new Product() { // 匿名内部类
            public String getInfo(){
                return "hello world";
            }
        };

        fun(pro);
    }

    public static void fun(Product pro){
        pro.print();
    }
}
```

> 强调：一个普通类尽量不要再去有子类继承，能够继承的只是抽象类或者接口，所以虽然可以在普通类上继续使用匿名内部类的形式来定义子类，
但是从正常的开发逻辑上这些事错误的。


范例：[尽量回避的操作](TestDemo3.java)

```java
class Person{
    public void print(){
        System.out.println("hello world!!");
    }
}

public class TestDemo3 {
    public static void main(String[] args){
        Person per = new Person() { // 匿名内部类
            public void print(){
                System.out.println("ni hao!!");
            }
        };
        fun(per);
    }

    public static void fun(Person per){
        per.print();
    }
}
```

> 强调：对于匿名内部类暂时不要过多的花费精力，能看懂即可，不要作为你现在的首选。

> JDK1.8 匿名内部类有个改进。