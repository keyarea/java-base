# Java多线程编程

## 进程与线程

在Java语言中最大的特点就是支持多线程的开发（也是为数不多支持多线程的编程语言），所以在整个Java技术的学习里面，如果你不能够对多线程的概念有一个全面并且细致的了解，则在以后进行一些
项目的设计过程之中尤其并发访问设计的过程之中就会出现严重的技术缺陷。

如果想要理解线程，那么首先就要了解一下进程的概念，在传统的DOS系统的时代，其本身有一个特征：如果你电脑上出现了病毒，那么所有的程序将无法执行，因为传统的DOS采用的就是单进程处理，而
单进程处理的最大特点就是：在同一时间段上只允许一个程序在执行。

那么后来到了Windows时代就开启了多进程，于是就表示在一个时间段上可以同时运行多个程序，并且这些程序将进行资源的轮流抢占，所以在同一个时间段上会有多个程序依次执行，但是在同一个时间点上只会有一个
进程执行，而后来到了多核的CPU，由于可以处理的CPU多了，那么即便有再多的进程出现，也可以比单核CPU处理的速度有所提升。

线程是在进程基础之上划分的更小的程序单元，线程是在进程的基础上创建并且使用的，所以线程依赖于进程的支持，但是线程的启动速度要比进程快许多，所以当使用多线程进行并发处理的时候，其执行的性能
要高于进程。

Java是多线程的编程语言，所以Java在进行并发访问处理的时候可以得到更高的处理性能。

## Java多线程的实现

如果要想在Java之中实现多线程的定义，那么就需要有一个专门的线程主体类进行线程的执行任务的定义，而这个主体类的定义是有要求的，必须实现特定的接口或者继承特定的父类才可以完成。

### 继承Thread类实现多线程

Java里面提供有一个java.lang.Thread的程序类，那么一个类只要继承了此类就表示这个类为线程的主体类，但是并不是说这个类就可以实现多线程处理了，因为还需要覆写Thread类中提供的run()方法，而这个方法就属于线程的主方法。

范例：多线程主体类

```java
package 多线程编程;

class MyThread extends Thread { // 线程的主体类
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }
}

public class ThreadDemo {
}
```

多线程要执行的功能都应该在run()方法中定义。需要说明的是：在正常情况下如果要想使用一个类中的方法，那么肯定要产生实例化对象，而后去调用类中提供的方法，但是run()方法是不能够被直接调用的，
因为这里面牵扯到一个操作系统的调度问题，所以要想启动多线程必须使用start()方法完成。

范例：多线程启动

```java
package 多线程编程;

class MyThread extends Thread { // 线程的主体类
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}
```

通过此时的调用，你可以发现，虽然调用了start()方法,但是最终执行的是run()方法，并且所有的线程对象都是交替执行的。

> 疑问：为什么多线程的启动不直接使用run()方法而必须使用Thread类中的start()方法呢？
>> 如果要想清楚这个问题，最好的做法是查看一下start()方法的实现操作，可以直接通过源代码观察。

```
public synchronized void start() {
    if (threadStatus != 0)
        throw new IllegalThreadStateException();  // 抛出了一个异常
    group.add(this);

    boolean started = false;
    try {
        start0();  // 在start()方法里面调用了start0()这个方法
        started = true;
    } finally {
        try {
            if (!started) {
                group.threadStartFailed(this);
            }
        } catch (Throwable ignore) {
     
        }
    }
}
 private native void start0(); // 只定义了方法名称并没有实现
```

会发现start()方法里面会抛出一个`IllegalThreadStateException`异常类对象，但是整个程序并没有使用throws或者明确的try...catch处理，因为该异常一定是RuntimeException的子类，每一个
线程类的对象只允许启动一次，如果重复启动则就抛出此异常,例如下面的代码：

```java
package 多线程编程;

class MyThread extends Thread { // 线程的主体类
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread th = new MyThread("线程A");
        th.start();
        th.start(); //  重复进行了线程的启动 
    }
}
```

在Java程序的执行过程儿之中，考虑到对于不同层次开发者的需求，所以其支持有本地的操作系统函数调用，而这项技术就被称为JNI技术，但是Java开发之中并不推荐这样使用，利用这项技术
可以使用一些操作系统提供的底层函数进行一些特殊处理，而在Thread类里面提供的start0()就表示需要将此方法依赖于不同的操作系统实现。

![](http://imgs.loong.io/image/Thread/ThreadStart0.jpg)

任何情况下,只要定义了多线程,多线程的启动永远只有一种方案:Thread类中的start()方法.

## 基于Runnable接口实现多线程

虽然可以通过Thread类的继承来实现多线程的定义,但是在Java程序里面对于继承永远都是存在有单继承局限的,所以在Java里面又提供有第二种多线程的主题结构定义形式:实现java.lang.Runnable接口,
此接口定义如下:

```
@FunctionalInterface
public interface Runnable { // 从jdk1.8引入Lambda表达式之后就变为了函数式接口
    public void run();
}
```

范例: 通过Runnable实现多线程的主体类

```
/**
 * 通过实现Runnable接口实现多线程
 */

class SecondThread implements Runnable { // 线程的主体类
    private String title;
    public SecondThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }
    
}
```

但是此时由于不再继承Thread父类了,那么对于此时的SecondThread类中也不再支持有start()这个继承的方法,可是如果不使用start()方法是无法进行多线程启动的,
那么这个时候就需要观察一下Thread类提供的构造方法:

> 构造方法:`public Thread(Runnable target);`

范例: 启动多线程

```java
/**
 * 通过实现Runnable接口实现多线程
 */

class SecondThread implements Runnable { // 线程的主体类
    private String title;
    public SecondThread(String title){
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        for( int x =0; x < 10; x++) {
            System.out.println(this.title + "运行， x = "  + x);
        }
    }

}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread threadA = new Thread(new SecondThread("线程A"));
        Thread threadB = new Thread(new SecondThread("线程B"));
        Thread threadC = new Thread(new SecondThread("线程C"));
        threadA.start(); // 启动多线程
        threadB.start(); // 启动多线程
        threadC.start(); // 启动多线程
    }
}
```

这个时候的多线程实现里面可以发现,由于只是实现了Runnable接口对象,所以此时线程主体类上就不再有单继承的局限了,那么这样的设计才是一个标准性的设计.

可以发现从jdk1.8开始,Runnable使用了函数式接口定义,所以也可以直接利用Lambda表达式进行线程类的实现.

范例: 利用Lambda实现多线程定义

```java
public class ThreadDemo {
    public static void main(String[] args) {
        /*
         * 利用Lambda表达式实现多线程
         */

        for(int x = 0; x < 3; x++) {
            String title = "进程" + x;
            Runnable run = () -> {
                for (int y = 0; y < 10; y++){
                    System.out.println(title + "运行, y = " + y);
                }
            };
            new Thread(run).start();
        }

    }
}
```

在以后的开发之中对于多线程的实现,优先考虑的就是Runnable接口实现,并且永恒都是通过Thread类对象启动多线程.