## Lambda表达式

从JDK1.8开始为了简化使用者进行代码的开发，专门提供有Lambda表达式的支持，利用此操作形式可以实现函数式的编程。利用函数式的编程可以避免掉面向对象编程之中的一些繁琐的处理问题。

面向对象在其长期的发展的过程之中，一直有一部分的反对者，这些反对者认为面向对象的设计过于复杂了，并且过于繁琐了。

以一个最简单的程序为例：

范例：观察传统开发中的问题

```java
package Lambda;

@FunctionalInterface // 函数式接口
interface IMessage {
    void send(String str);
}


public class Demo {
    public static void main(String[] args){
        IMessage message = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println("消息发送：" + str);
            }
        };
        message.send("hello world");
    }
}
```

在这样一个程序里面，实际上核心的功能只有一条语句`System.out.println("消息发送：" + str);`
但是为了这一条核心语句依然需要按照完整的面向对象给出的设计结构进行开发。

于是这些问题随着技术的不断发展也是越来越突出了。

范例：使用Lambda表达式实现与之前完全一样的功能

```java
package Lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        IMessage message = str -> {
            System.out.println("发送消息：" + str);
        };
        message.send("hello world");
    }
}
```

利用这种形式就避免了复杂的面向对象结构化的要求。

> Lambda表达式如果要想使用，那么就必须有一个重要的实现要求：ASM（Single Abstract Method），
只有一个抽象方法，以之前IMessage接口为例，在这个接口里面发现只是提供有一个send()方法，
除此之外没有任何的其他方法的定义，所以这样的接口又被称之为函数式接口，而只有函数式的接口才可以
被Lambda表达式所使用。

```java
package Lambda;

@FunctionalInterface // 函数式接口注解
interface IMessage {
    void send(String str);
}

public class LambdaDemo {
    public static void main(String[] args) {
        IMessage message = str -> {
            System.out.println("发送消息：" + str);
        };
        message.send("hello world");
    }
}
```

对于Lambda表达式而言，提供有如下的几种格式：

- 方法没有参数: `()->{};`
- 方法有参数：`(参数,参数)->{};`
- 如果现在只有一行语句返回：`(参数,参数)->语句;`

范例：定义没有参数的方法

```java
package Lambda;

@FunctionalInterface
interface IPrint{
    void print();
}

public class NoArgumentsDemo {
    public static void main(String[] args){
        IPrint print = ()->{
            System.out.println("hello world!!");
        };
        print.print();
    }
}
```

范例：定义有参数的处理形式

```java
package Lambda;

@FunctionalInterface
interface IMath{
    int add(int x, int y);
}

public class ArgsDemo {
    public static void main(String[] args){
        IMath math = (x, y)->{
            return x + y;
        };

        System.out.println(math.add(10, 20));
    }
}
```

以上的表达式之中你会发现只有一行语句，这个时候也可以进一步简化。

范例：简化Lambda操作

```java
package Lambda;

@FunctionalInterface
interface IMath{
    int add(int x, int y);
}

public class ArgsDemo {
    public static void main(String[] args){
//        IMath math = (x, y)->{
//            return x + y;
//        };
        IMath math = (x, y)->x +y;

        System.out.println(math.add(10, 20));
    }
}
```
利用Lambda表达式的确可以摆脱传统面向对象之中关于结构的限制，使得代码更加的简便。


## 方法引用