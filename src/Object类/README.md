# Object类

Object类是java默认提供的一个类，可以这么说，java里面除了Object类之外，所有的类都是存在有继承关系的。
默认会继承Object父类，也就说以下的两种类的定义最终效果是完全相同的：

```java
class Message{
    
}
```

```java
class Message extends Object{
    
}
```

那么也就证明所有类的对象都可以使用Object进行接收。

范例：[用Object进行接收](TestDemo.java)

```java
class Person{

}

class Message{

}

public class TestDemo {

    public static void main(String[] args){
        fun(new Message());
        fun(new Person());
    }

    public static void fun(Object obj){
        System.out.println(obj);
    }
}
```

所以在开发之中，Object类是参数的最高统一类型。本身Object类本身也具备有一些定义的方法：
 

## Object本身的方法
 
| NO. | 方法名称 | 类型 | 描述 |
|:----:|:----:|:----:|:----:|
|1| `public Object()` | 构造 | 无参构造主要是为子类提供服务的 |
|2| `public String toString()` | 普通| 取得对象信息 |
|3| `public boolean equals(Object obj)`| 普通 | 对象的比较 |


### 取得对象信息

在使用对象直接输出的时候发现默认情况下输出的是一个地址编码。但是如果说现在使用的是一个String类，该类对象直接输出的时候就是内容，主要的原因就是这个`toString()`方法；

范例：[观察String类对象的输出](TestDemo1.java)

```java
class Produce{
    private int age;
    private String name;
    public Produce(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class TestDemo1 {
    public static void main(String[] args){

        // String是Object类的子类
        fun("helloworld");      // helloworld

        // 自定义对象
        fun(new Produce("kyle", 24));  // Object类.Produce@61bbe9ba

        print("helloworld");  //  helloworld
        print(new Produce("kyel", 24)); // Object类.Produce@610455d6
    }

    // 默认输出，对象调用的就是toString()方法
    public static void fun(Object obj){
        System.out.println(obj);
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}
```

现在就发现了默认情况下Object类中提供的toString()方法只能够得到一个对象的地址（而这是所有对象都共同具备的特征）。而现在如果觉得默认给出的toString()功能不足，就建议在需要的子类上覆写toString()方法。

范例：[覆写toString()方法](TestDemo2.java)

```java
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }


    // 覆写Object中的toString()方法
    @Override
    public String toString(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
}

public class TestDemo2 {
    public static void main(String[] args){
        print("hello");  // hello
        print(new Dog("doudou", 12)); // 姓名：doudou，年龄：12
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
```

所以toString()方法的目的在于取得对象信息。相当于替换了之前简单java类中getInfo()方法的功能。

> String是作为信息输出的重要的数据类型，在java中所有的数据类型只要遇见了String，并且执行了`+`这种连接操作，
那么都要求将其变为字符串后连接，而所有对象要想变为字符串就默认使用toString()方法。

范例: [执行`+`操作](TestDemo3.java)

```java
class Animal{
    private String name;
    private int age;

    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
}

public class TestDemo3 {
    public static void main(String[] args){
        String result = "hello," + new Animal("doudou",12);
        System.out.println(result); // hello,姓名：doudou，年龄：12
    }
}
```


### 对象比较

String类内容的比较使用的是equals()方法，实际上这个equals()方法就是String类覆写的Object类的方法。

> String类中的equals()方法:`public boolean equals(Object obj)`

以后在编写对象的比较处理，不要再使用之前的compare()，统一更换为equals()。

范例：[实现对象比较](TestDemo4.java)

```java

class Student{
    private String name;
    private int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject == null){
            return false;
        }

        if(anObject == this){
            return true;
        }

        // 必须先判断这个，不然转型失败就会出现ClassCastException错误
        if(!(anObject instanceof Student)){
            return false;
        }

        // 必须将Obejct类型变为Person类型后才能调用name，age属性
        Student stu = (Student) anObject;
        return this.name.equals(stu.name) && this.age == stu.age;
    }

}

public class TestDemo4 {
    public static void main(String[] args){
        Student stu1 = new Student("张三", 24);
        Student stu2 = new Student("张三", 24);
        System.out.println(stu1.equals(stu2)); // true
        
        System.out.println(stu1.equals("hello")); // false
    }
}
```

> 注意：`public boolean equals(Student anObject)`由于Object类equals方法中使用的参数是Object，所以以上的方法严格来讲已经不是覆写了，是重载。

### Object接收引用数据类型

在之前已经分析了Object可以接收任意的对象，因为从定义的结构上来讲，Object是所有类的父类，
但是Object的概念并不仅仅局限于此，他可以接收所有的引用数据类型，包括：数组、接口。

范例：[使用Object接收数组对象](TestDemo5.java)

```java
public class TestDemo5 {
    public static void main(String[] args){
        // 利用Object接收数组，向上转型
        Object arr = new int[]{1, 2, 3};
        // 向下转型，需要强制类型转换
        int[] result = (int[]) arr;

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]+ "、");
        }

    }
}
```

而Object可以接收接口更是java中的强制性要求，因为接口本身是不可能继承任何类的，所以这种类型的接收就是自己的规定。

范例：[接口向Object转型](TestDemo6.java)

```java
interface IMessage{

}

class MessageImpl implements IMessage{
    @Override
    public String toString(){ // 覆写Object方法
        return "hello";
    }
}

public class TestDemo6 {
    public static void main(String[] args){
        // 子类向父接口转型
        IMessage mes = new MessageImpl();
        // 接口向Object转型
        Object obj = mes;
        System.out.println(obj);

    }
}
```

Object真正达到了参数的统一，如果一个类希望可以接收所有的数据类型，就使用Object完成。





