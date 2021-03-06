# 函数式编程

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

引用数据类型最大的特点是可以进行内存的指向处理,但是在传统的开发之中一直使用的只是对象引用操作,
而jdk1.8之后也提供有方法的引用,即:不同的方法名称可以描述同一个方法.如果要进行方法的引用在Java
里面提供有如下的四种形式:

- 引用静态方法: `类名称::static 方法名称;`
- 引用某个实例对象: `实例化对象 :: 普通方法;`
- 应用特定类型的方法: `特定类 :: 普通方法;`
- 引用构造方法: `类名称 :: new;`

### 引用静态方法

范例: 引用静态方法

> 在`String`类里面提供有`String.valueOf()`方法,这个方法就属于静态方法.
>> 方法定义: `public static String valueOf(int i)`,该方法有参数,并且还有返回值.

```java
package Lambda;


// P描述的是参数,R描述的是返回值
@FunctionalInterface // 函数式接口
interface IFunction<P,R>{
    public R change(P p);
}

public class MethodReferenceDemo {
    public static void main(String[] args){
        IFunction<Integer, String> fun = String :: valueOf;
        String str = fun.change(100);
        System.out.println(str.length());
    }
}
```

> 利用方法引用这一概念可以为一个方法定义多个名字,但是要求必须是函数式接口.

### 引用实例化对象的方法

范例:引用实例化对象中的方法

> 在`String`类里面有一个转大写的方法: `public String toUpperCase();`
>> 这个方法是必须在有实例化对象提供的情况下才可以调用;

```java
package Lambda;


@FunctionalInterface // 函数式接口
interface IMethod<R> {
    public R upper();
}

public class MethodReferenceDemo {
    public static void main(String[] args){
        // 方法引用,实例化对象方法
        IMethod<String> method = "hello world" :: toUpperCase;
        String upperStr = method.upper();
        System.out.println(upperStr);
    }
}
```

### 应用特定类型的方法

在进行方法的引用的时候也可以引用特定类中的一些操作方法, 在String类里面提供有一个字符串大小
关系的比较;

> 比较大小: `public int compareTo(String anotherString);`

这是一个普通方法,如果要引用普通方法,则往往都需要实例化对象,但是如果说现在你不想给出实力化
对象,只是想引用这个方法,则就可以使用特定类进行引用处理.

范例: 引用指定类中的方法

```java
package Lambda;

@FunctionalInterface //函数式接口
interface ICompare<P> {
    public int compare(P p1, P p2);
}

public class MethodReferenceDemo {
    public static void main(String[] args){
        // 引用特定类中方法
        ICompare<String> function = String::compareTo;
        int num = function.compare("A", "a");
        System.out.println(num);
    }
}
```

### 构造方法的引用

范例:引用构造方法

```java
package Lambda;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名:" + this.name + ", 年龄: " + this.age;
    }
}

@FunctionalInterface
interface ICreate<R> {
    public R create(String name, int age);
}

public class MethodReferenceDemo {
    public static void main(String[] args){

        // 引用构造方法
        ICreate<Person> f = Person::new;
        System.out.println(f.create("王五", 23));
    }
}
```

提供方法引用的概念更多的情况下也只是弥补了对于引用的支持功能.

## 内建函数式接口

在JDK1.8之中提供有 Lambda表达式也提供有方法引用,但是你会发现如果由开发者自己定义
函数式接口,往往都需要使用`@FunctionInterface`注解来进行大量声明,于是很多的情况下
如果为了方便则可以引用系统中提供的函数式接口.

在系统之中专门提供有一个`java.util.function`的开发包,里面可以直接使用函数式接口.
在这个包下面一共有如下的几个核心接口供我们使用:

### 功能性函数式接口

#### 接口定义

```java
@FunctionalInterface
public interface Function<T,R> {
    public R apply(T t);
}
```
#### 接口的使用

```java
package Lambda;
import java.util.function.*;

public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // 功能性函数式接口
        Function<String, Boolean> fun = "**Hello"::startsWith;
        System.out.println(fun.apply("**"));
    }
}
```

### 消费性函数式接口

> 只能供进行数据的处理操作,而没有任何的返回;
>> 在进行系统数据输出的时候使用的是:`System.out.println();`

#### 接口的定义

```java
@FunctionalInterface
public interface Consumer<T>{
    public void accept(T t);
}
```

#### 接口的使用

```java
package Lambda;
import java.util.function.*;

public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // 消费性函数式接口
        Consumer<String> con = System.out::println;
        con.accept("hello world");
    }
}
```

### 供给型函数式接口

> 在`String`类中提供有转小写的方法,这个方法没有接收参数,但是有返回值;
>> 方法: `public String toLowerCase()`

#### 接口的定义

```java
@FunctionalInterface
public interface Supplier<T> {
    public T get();
}
```

#### 接口的使用

```java
package Lambda;
import java.util.function.*;

public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // 供给性函数式接口
        Supplier<String> supplier = "HELLO"::toLowerCase;
        String str = supplier.get();
        System.out.println(str);
    }
}
```

### 断言性函数式接口

> 进行判断处理
>> 在`String`类中有一个`equalsIgnoreCase()`方法

#### 接口的定义

```java
@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T t);
}
```

#### 接口的使用

```java
package Lambda;
import java.util.function.*;

public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // 断言性函数式接口
        Predicate<String> predicate = "hello"::equalsIgnoreCase;
        System.out.println(predicate.test("HELLO"));
    }
}
```

> 以后对于实际项目开发之中,如果JDK本身提供的函数式接口可以被我们所使用,那么就没有必要重新定义了.



















