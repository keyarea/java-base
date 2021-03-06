多例的对象的类实际上在生活中也经常出现，例如：要求描述一周时间数的类，只能有七个对象，描述性别类的对象只能够有两个，这些都属于多例设计模式。

所谓的多例只是比单例追加了更多个内部实例化对象的产生而已。

范例： 现在定义一个表示性别的多例类

```java
package DesignMode.多例模式;

class Sex {
    public final static int MAN_FLAG = 1;
    public final static int WOMEN_FLAG = 2;
    public final static Sex MAN = new Sex("男");
    public final static Sex WOMEN = new Sex("女");
    private String title;

    public static Sex getInstance(int flag){
        switch (flag){
            case MAN_FLAG:
                return MAN;
            case WOMEN_FLAG:
                return WOMEN;
                default:
                    return null;
        }
    }

    private Sex(String title){
        this.title = title;
    }

    public String toString(){
        return this.title;
    }


}

public class TestDemo {
    public static void main(String[] args){
        Sex sex = Sex.getInstance(Sex.MAN_FLAG);
        System.out.println(sex);
    }
}
```

> 不管是多例还是单例特点很明显：
> - 构造方法私有化；
> - 类内部一定会提供有一个static方法用户取得类的实例化对象。