# Java基础类库

## StringBuffer类

String类是项目开发之中一定会使用到的一个功能类，并且这个类拥有如下的特点：

- 每一个字符串常量都属于一个String类的匿名对象，并且不可更改；
- String有两个常量池：静态常量池、运行时常量池；
- String类对象的实例化建议使用直接赋值的形式完成，这样可以直接将对象保存在对象池之中以方便下次重用；

虽然String类很好用，但是如果认真去思考也会发现其最大的弊端：内容不允许修改，虽然大部分情况下都不会涉及到字符串内容的频繁修改，但是依然可能会出现这样的情况，所以为了解决此问题，所以专门提供了StringBuffer类，
可以实现字符串内容的修改处理。

StringBuffer并不像String类那样拥有两种对象实例化方式，StringBuffer必须像普通类对象那样首先进行对象的实例化，而后才可以调用方法去执行，而这个时候
可以考虑使用StringBuffer类中的如下方法：

- 构造方法：public StringBuffer()
- 构造方法：public StringBuffer(String str) ,接收初始化字符串内容
- 数据追加: public StringBuffer append(数据类型 变量): 相当于字符串的加操作；

范例：观察String与StringBuffer的对比

```java
package Java基础类库;

/**
 * String类的引用传递
 */

public class JavaApiDemo {
    public static void main(String[] args) {
        String hello = "Hello";
        change(hello);
        System.out.println(hello); // hello字符串并没有发生改变
    }

    public static void change(String temp) {
        temp += " World";
    }
}
```

实际上大部分情况下，很少会出现字符串内容的改变，这种改变并不是针对于静态常量池的改变。

范例： 分析一下已有问题

```java
package Java基础类库;

public class JavaApiDemo2 {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "Hello " + "World";
        System.out.println(str1 == str2); // true
    }
}
```

> 这个时候的str2并不算是改变，或者更加严格的意义上来讲，对于现在str2当程序编译之后会变为如下的形式：

```
StringBuffer bug = new StringBuffer();
buf,append("Hello ").append("World"):
```

所有的”+“方法在编译之后都变为了StringBuffer中的append()方法，并且在程序之中StringBuffer与String类对象之间本来就可以直接互相转换：

- String类对象变为StringBuffer类对象可以依靠StringBuffer类的构造方法或者使用append方法；
- 所有的类对象都可以通过toString()方法将其变为String类型。

在StringBuffer类里面除了可以支持有字符串内容的修改之外，实际上也提供有String类所不具备的方法：

- 插入数据： public  StringBuffer insert(int offset, 数据类型 b);
- 删除指定范围的数据： public StringBuffer delete(int start, int end);
- 字符串反转： public StringBuffer reverse();

实际上还有一个与StringBuffer类类似的功能类：StringBuilder类，这个类是在jdk1.5之后提供的。该类与StringBuffer类提供的功能相同，最大的区别在于StringBuffer类
中的方法属于线程安全的，全部使用了synchronized关键字进行标注，而StringBuilder属于非线程安全的。

- String类是字符串的首选类型，其最大的特点是不允许修改；
- StringBuffer和StringBuilder类的内容允许修改；
- StringBuffer是在JDK1.0的时候提供的，属于线程安全的操作，而StringBuilder是在JDK1.5之后提供的，属于非线程安全的操作。
