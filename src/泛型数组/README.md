# 泛型数组列表

在Java中，允许在运行时确定数组的大小。

```java
public class TestDemo1 {
    public static void main(String[] args){
        int actual = 2;
        String[] staff = new String[actual];

    }
}
```

当然，这段代码并没有完全解决运行时动态更改数组的问题。一旦确定了数组的大小，
改变它就不太容易了。在Java中，解决这个问题最简单的方法就是使用Java中另外一个
被称为`ArrayList`的类。它使用起来有点像数组，但在添加或删除元素时，具有
自动调节数组容量的功能，而不需要为它编写任何代码。

## 创建ArrayList类对象

`ArrayList` 是一个采用类型参数（ type parameter ) 的泛型类generic class )。为了指定数
组列表保存的元素对象类型， 需要用一对尖括号将类名括起来加在后面， 例如`ArrayList
<Employee>`。


下面声明和构造一个保存Employee 对象的数组列表：

```
ArrayList<Employee> staff = new ArrayList<Eniployee>();
```

两边都使用类型参数`Employee`， 这有些繁琐Java SE 7 中， 可以省去右边的类型参数：
```
ArrayList<Employee> staff = new ArrayList()；
```

这被称为“ 菱形” 语法， 因为空尖括号o就像是一个菱形。可以结合new 操作符使用菱形
语法。编译器会检查新值是什么。如果赋值给一个变量， 或传递到某个方法， 或者从某个方
法返回， 编译器会检査这个变量、参数或方法的泛型类型， 然后将这个类型放在`<>`中。在
这个例子中`new ArrayList()` 将赋至一个类型为`ArrayList<Employee>` 的变量， 所以泛型
类型为Employee。

## 添加

使用add 方法可以将元素添加到数组列表中。例如，下面展示了如何将雇员对象添加到
数组列表中的方法：