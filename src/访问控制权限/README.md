[toc]

在之前学到的`private`就属于一种访问控制权限，而这种访问控制权限只是封装的一部分，在java中提供有四种访问控制权限：`private` `default` `protected` `public`，而这四种访问控制权限定义如下：


| No. | 范围 | private | default | protected | public |
| --- | --- | --- | --- | --- | --- |
| 1 | 同一包中的同一类 | ✅ | ✅ | ✅ | ✅ |
| 2 | 同一包中的不同类 | ❌ | ✅ | ✅ | ✅ |
| 3 | 不同包中的子类 | ❌ | ❌ | ✅ | ✅ |
| 4 | 不同包中的非子类 | ❌ | ❌ | ❌ | ✅ |

> 实际上public永远都可以访问，但是对于封装而言主要是由三个权限：`private`、`default`、`protected`。

范例：观察protected访问权限

```java
package 访问控制权限.package1;

public class Info {
    // 此时出现的是一个protected访问控制权限
    protected String str = "keyarea";
}
```

范例：定义另外一个包进行该类的继承

```java
package 访问控制权限.package2;  // 不同包
import 访问控制权限.package1.Info;

// 不同包的子类

public class SubInfo extends Info{ // Info的子类
    public void priint(){
        System.out.println(super.str); // 在父类中属于protected权限
    }
}
```

范例：定义一个测试类

```java
package 访问控制权限.test;

import 访问控制权限.package2.SubInfo;

public class TestInfo {
    public static void main(String[] args){
        SubInfo subInfo = new SubInfo();
        subInfo.priint();  // keyarea
    }
}
```

现在SubInfo虽然与Info属于不同的开发包，但是毕竟是其子类，所以可以访问，但是反过来，要想在TestInfo中直接使用Info类（非子类）则就会出现错误。

范例：错误的程序

```java
package 访问控制权限.test;

import 访问控制权限.package1.Info;
import 访问控制权限.package2.SubInfo;

public class TestInfo {
    public static void main(String[] args){
//        SubInfo subInfo = new SubInfo();
//        subInfo.priint();  // keyarea
        System.out.println(new Info().str);
    }
}
```

`str`是`protected`权限，所以此处一定无法访问。

> 结论：关于权限的选择
> - 对于封装的描述90%使用的都是`private`，只有10%的情况下会使用`protected`，这两个都叫封装；
> - 属性都使用`private`，方法都使用`public`。


> 封装性指的就是`private`、`default`、`protected`三个权限的使用。