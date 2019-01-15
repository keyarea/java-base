# JAVA特点

高级语言类型：
1. 编译型
2. 解释型

Java是以上两种语言的结合。.java先编译生成.class文件，Java解释器负责Java虚拟机的代码在特定的平台上运行

## Java的主要特点：

- Java语言具有可移植型
- Java开发足够简单
- java是为数不多的多线程编程语言
- Java支持自动的垃圾收集处理
- java是一门面向对象的编程语言。

# JAVA开发环境

- JRE： Java Runtime Environment
- JDK：Java Development Kit

JRE顾名思义是java运行时环境，包含了java虚拟机，java基础类库。是使用java语言编写的程序运行所需要的软件环境，是提供给想运行java程序的用户使用的。

JDK顾名思义是java开发工具包，是程序员使用java语言编写java程序所需的开发工具包，是提供给程序员使用的。JDK包含了JRE，同时还包含了编译java源码的编译器javac，还包含了很多java程序调试和分析的工具：jconsole，jvisualvm等工具软件，还包含了java程序编写所需的文档和demo例子程序。

如果你需要运行java程序，只需安装JRE就可以了。如果你需要编写java程序，需要安装JDK。

因此，需要先安装jdk的开发包，其中包括了jre。[点此下载](https://www.java.com/zh_CN/download)。

> jdk安装之前先把电脑的防火墙关闭，不然可能会发生不可测的后果。

> 只安装jre会导致你编写的.java程序不能编译为.class文件，即javac命令找不到。

> 安装之后要进行环境变量的配置。在path中添加java/bin所在的绝对路径，新的环境属性必须在重启之后才会生效。

# 第一个java程序

所有java程序必须是`.java`文件名后缀。

实例：

```java
public class Hello{
  public static void main(String args[]){
    System.out.println('hello world!!');
  }
}
```

以上是一个最简单的java程序,它会输出`hello world!!`.

## 执行步骤

1. 编译源代码文件,生成编译后的文件`*.class`文件.在命令行执行`javac Hello.java`就会在这个文件夹生成`Hello.class`文件.
2. 解释java文件.在命令行执行`java Hello`就会执行该程序.

> 注意：其中的类名必须与文件名保持一致，不然就会报“类HelloWorld是公共的，应在名为HelloWorld.java的文件中声明”的编译错误。

## 分解程序

### 程序类

```java
public class Hello{}
```

类是java中的基本单位,所有的java程序都是以类的形式存在的,在程序中对于类的定义有两种语法:

1. `public class 类名称{}`:其中类名称必须和文件名保持一致,一般类名称首字母大写.
2. `class 类名称{}`:文件名称可以和类名称不同,生成的字节码文件就是类名称.class,在一个*.java中可以用class定义多个不同的类,并且在编译之后形成不同的`*.class`文件.

> 类名的首字母一般大写

> 在java的学习中可能会在一个*.java文件中定义多个类，主要是方便浏览，但是在实际的开发当中，几乎每一个java文件只会定义一个类。

### 主方法

```java
public static void main(String args[]){
  System.out.println('hello world!!');
}
```

主方法是一切的起点，也就是说所有的程序都是通过主方法开始执行的。

主方法编写的代码才是你整个程序该执行的程序逻辑。主程序所在的类称之为主类，而主类一般使用`public class`进行声明。

### 信息输出

```java
System.out.println('hello world!!');
```

指的是在 屏幕上进行信息的打印操作，而信息输出有以下两类语法：

- 输出后换行：System.out.println(内容)；
- 输出后不换行：System.out.print(内容)；