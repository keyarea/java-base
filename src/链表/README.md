# 链表

链表的本质是一个动态的对象数组,他可以实现若干个对象的存储.

## 链表的基本定义

在实际的开发之中对象数组是一项非常实用的技术,并且利用其可以描述出"多"方的概念,例如:一个人有
多本书,则在人的类里面一定要提供有一个对象数组保存书的信息,但是传统的对象数组依赖于数组的概念,所以
数组里面最大的缺点在于:长度是固定的,正是因为如此所以在实际的开发之中,传统的数组应用是非常有限的(数组的接受
以及循环使用),但是如果要想进行灵活的数据保存,那么就必须自己来实现结构.

传统对象数组的开发操作依赖于脚标(索引)的控制,如果要想实现内容的动态维护,那么难度太高了,而且复杂度
攀升,所以现在可以发现,对于一成不动的数据可以使用对象数组来实现,但是对于可能随时变化的数据,就必须
实现一个可以动态扩充的对象数组.

所谓的链表实质性的本质是利用引用的逻辑关系来实现类似数组的数据处理操作,以一种保存"多"方数据的形式,
实现数组类似的功能. 

如果先要实现链表的处理,那么需要有一个公共的结构,这个结构可以实现数据的保存以及下一个链接的指向,
为了描述这样的逻辑,可以把每一个存储理解为一个节点,所以此时应该准备出一个节点类,但是这个节点类里面可以
保存各种数据类型的数据.

![](http://imgs.loong.io/image/linkedlist/linkedList.jpg)

虽然已经清楚了需要通过Node节点来进行数据的保存,但是毕竟这里面需要牵扯到节点的引用处理关系,那么这个引用处理关系
是由使用者控制吗?这样肯定的不可能,所以应该有一个专门的类来进行节点的引用关系的配置.

范例:直接操作Node很麻烦

```java
package 链表;

class Node<E> {
    private E data;
    private Node next;
    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkDemo {
    public static void main(String[] args) {
        Node<String> n1 = new Node<>("火车头");
        Node<String> n2 = new Node<>("车厢1");
        Node<String> n3 = new Node<>("车厢2");
        Node<String> n4 = new Node<>("车厢4");
        Node<String> n5 = new Node<>("车厢5");
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        print(n1);
    }

    public static void print(Node<?> node) {
        if(node != null) {// 有节点
            System.out.println(node.getData());
            print(node.getNext()); // 递归调用
        }
    }
}
```

> 这样肯定不可能,所以应该有一个专门的类进行节点的引用关系的配置.因为真实的使用者关心的
只是数据的存储与获取,所以现在应该对我们的Node类进行包装处理.

![](http://imgs.loong.io/image/linkedlist/linkedListStructure.jpg)

## 数据增加

通过之前的分析可以发现在进行链表操作的过程之中为了避免转型的异常应该使用泛型,同时也应该
设计一个链表的标准接口,同时具体实现该接口的时候还应该通过Node类做出节点的关系描述.

```java
package 链表;

interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e);
}

class LinkImpl<E> implements ILink<E> {
    private class Node { // 保存的节点的数据关系
        private E data; //保存的数据
        private Node next; // 保存的下一个引用
        public Node (E data) {  // 有数据的情况下才有意义
            this.data = data;
        }
    }
    // ---------------以下为Link类中定义的结构-----------------
    
    @Override
    public void add(E e) {
    }
}
```

在现在所定义的Node类之中并没有出现有setter与getter方法,是因为内部类中的私有属性与方便外类类
直接访问.

```java
package 链表;

interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e);
}

class LinkImpl<E> implements ILink<E> {
    private class Node { // 保存的节点的数据关系
        private E data; //保存的数据
        private Node next; // 保存的下一个引用
        public Node (E data) {  // 有数据的情况下才有意义
            this.data = data;
        }
        // 第一次调用: this = LinkImpl.root;
        // 第二次调用: this = LinkImpl.root.next;
        // 第三次调用: this = LinkImpl.root.next.next;
        public void addNode (Node newNode) { // 保存新的Node数据集
            if(this.next == null){  // 当前节点的下一个节点为null
                this.next = newNode; // 保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }

    }
    // ---------------以下为Link类中定义的成员-----------------
    private Node root;  // 根节点
    // ---------------以下为Link类中定义的方法-----------------
    @Override
    public void add(E e) {
        // 数据本身不具有关联特性,只有Node节点有,那么要实现关联就必须将数据包装在Node类中
        Node node = new Node(e); // 创建一个新的节点
        if(root == null) { // 现在没有根节点
            this.root = node; // 第一个节点作为根节点
        }else{
            this.root.addNode(node); // 将新节点保存在合适的位置
        }
    }
}

public class LinkDemo2 {
    public static void main(String args[]) {
        ILink<String> all = new LinkImpl<>();
        all.add("Hello");
        all.add("World");
    }
}
```

Link类只是负责数据的操作与节点的处理,而所有后续节点的处理都是由Node类负责完成的.

## 获取集合个数

在链表之中往往需要保存有大量的数据,那么这些数据往往需要进行数据个数的统计操作,所以应该在
LinkImpl里面追加有数据统计信息,同时当增加或删除数据时,有应该对个数进行修改.

> 1.在ILink接口里面追加有一个获取数据个数的方法;

```java
interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e); // 增加数据
    public int size(); // 获取数据的个数
}
```

> 2.在LinkImpl子类里里里面追加一个个数统计的属性;

```
private int count; // 保存数据的个数
```

> 3.在add()方法里面进行数据个数的追加

```
  @Override
     public void add(E e) {
         // 数据本身不具有关联特性,只有Node节点有,那么要实现关联就必须将数据包装在Node类中
         Node node = new Node(e); // 创建一个新的节点
         if(root == null) { // 现在没有根节点
             this.root = node; // 第一个节点作为根节点
         }else{
             this.root.addNode(node); // 将新节点保存在合适的位置
         }
         this.count ++;
     }
```

> 4.需要在LinkImpl子类里面来返回数据的个数

```
@Override
public int size() {
    return this.count;
}
```

> 完整代码

```java
package 链表;

interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e); // 增加数据
    public int size(); // 获取数据的个数
}

class LinkImpl<E> implements ILink<E> {
    private class Node { // 保存的节点的数据关系
        private E data; //保存的数据
        private Node next; // 保存的下一个引用
        public Node (E data) {  // 有数据的情况下才有意义
            this.data = data;
        }
        // 第一次调用: this = LinkImpl.root;
        // 第二次调用: this = LinkImpl.root.next;
        // 第三次调用: this = LinkImpl.root.next.next;
        public void addNode (Node newNode) { // 保存新的Node数据集
            if(this.next == null){  // 当前节点的下一个节点为null
                this.next = newNode; // 保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }

    }
    // ---------------以下为Link类中定义的成员-----------------
    private Node root;  // 根节点
    private int count; // 保存数据的个数
    // ---------------以下为Link类中定义的方法-----------------
    @Override
    public void add(E e) {
        // 数据本身不具有关联特性,只有Node节点有,那么要实现关联就必须将数据包装在Node类中
        Node node = new Node(e); // 创建一个新的节点
        if(root == null) { // 现在没有根节点
            this.root = node; // 第一个节点作为根节点
        }else{
            this.root.addNode(node); // 将新节点保存在合适的位置
        }
        this.count ++;
    }

    @Override
    public int size() {
        return this.count;
    }
}

public class LinkDemo2 {
    public static void main(String args[]) {
        ILink<String> all = new LinkImpl<>();
        System.out.println("[增加之前]数据的个数:" + all.size());
        all.add("Hello");
        all.add("World");
        System.out.println("[增加之后]数据的个数:" + all.size());
    }
}
```

## 空集合判断

链表里面可以保存有若干个数据,如果说现在链表还没有保存数据,则表示是一个空集合,则应该提供有一个空的判断.

> 1.在ILink接口里面追加判断方法;

```
public boolean isEmpty(); // 判断是否为空集合
```

> 2.在LinkImpl中腹泻此方法;

```
@Override
public boolean isEmpty() {
    // return this.root == null;
    return this.count == 0;
}
```

使用根节点或者长度判断其本质是一样的.

> 完整代码

```java
package 链表;

interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e); // 增加数据
    public int size(); // 获取数据的个数
    public boolean isEmpty(); // 判断是否为空集合
}

class LinkImpl<E> implements ILink<E> {
    private class Node { // 保存的节点的数据关系
        private E data; //保存的数据
        private Node next; // 保存的下一个引用
        public Node (E data) {  // 有数据的情况下才有意义
            this.data = data;
        }
        // 第一次调用: this = LinkImpl.root;
        // 第二次调用: this = LinkImpl.root.next;
        // 第三次调用: this = LinkImpl.root.next.next;
        public void addNode (Node newNode) { // 保存新的Node数据集
            if(this.next == null){  // 当前节点的下一个节点为null
                this.next = newNode; // 保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }

    }
    // ---------------以下为Link类中定义的成员-----------------
    private Node root;  // 根节点
    private int count; // 保存数据的个数
    // ---------------以下为Link类中定义的方法-----------------
    @Override
    public void add(E e) {
        // 数据本身不具有关联特性,只有Node节点有,那么要实现关联就必须将数据包装在Node类中
        Node node = new Node(e); // 创建一个新的节点
        if(root == null) { // 现在没有根节点
            this.root = node; // 第一个节点作为根节点
        }else{
            this.root.addNode(node); // 将新节点保存在合适的位置
        }
        this.count ++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        // return this.root == null;
        return this.count == 0;
    }
}

public class LinkDemo2 {
    public static void main(String args[]) {
        ILink<String> all = new LinkImpl<>();
        System.out.println("[增加之前]数据的个数:" + all.size());
        System.out.println("是否为空集合:" + all.isEmpty());
        all.add("Hello");
        all.add("World");
        System.out.println("[增加之后]数据的个数:" + all.size());
        System.out.println("是否为空集合:" + all.isEmpty());
    }
}
```

## 返回集合数据

链表本身就属于一个动态的对象数组,那么既然是一个对象数组,那么就应该可以把所哦有的数据以
数组的形式返回来,那么这个时候就可以定义一个toArray()方法,但是这个时候只能够返回Object型的数组.


![](http://imgs.loong.io/image/linkedlist/toArray.jpg)

> 1.在ILink接口里面追加新的处理方法;

```
public Object[] toArray(); // 将集合元素以数组的形式返回
```

> 2.在LinkImpl里面追加有两个属性;

```
private int foot; // 描述的是操作数组的脚标
private Object [] returnData; // 返回的数据
```

> 3.在Node类中递归获取数据

```
public void toArrayNode () {
    LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
    if(this.next != null) { // 还有下一个数据
        this.next.toArrayNode();
    }
}
```


> 4.在进行数据返回的时候一定要先判断是否为空集合;

```
@Override
public Object[] toArray() {
    // 判断是否为空
    if(this.root == null){
        return null;
    }
    this.foot = 0; //脚标清零
    this.returnData =  new Object[this.count]; // 根据已有的长度新建一个数组
    this.root.toArrayNode(); // 利用Node类进行递归获取数据
    return this.returnData;
}
```

> 完整代码

```java
package 链表;

interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e); // 增加数据
    public int size(); // 获取数据的个数
    public boolean isEmpty(); // 判断是否为空集合
    public Object[] toArray(); // 将集合元素以数组的形式返回
}

class LinkImpl<E> implements ILink<E> {
    private class Node { // 保存的节点的数据关系
        private E data; //保存的数据
        private Node next; // 保存的下一个引用
        public Node (E data) {  // 有数据的情况下才有意义
            this.data = data;
        }
        // 第一次调用: this = LinkImpl.root;
        // 第二次调用: this = LinkImpl.root.next;
        // 第三次调用: this = LinkImpl.root.next.next;
        public void addNode (Node newNode) { // 保存新的Node数据集
            if(this.next == null){  // 当前节点的下一个节点为null
                this.next = newNode; // 保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode () {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) { // 还有下一个数据
                this.next.toArrayNode();
            }
        }

    }
    // ---------------以下为Link类中定义的成员-----------------
    private Node root;  // 根节点
    private int count; // 保存数据的个数
    private int foot; // 描述的是操作数组的脚标
    private Object [] returnData; // 返回的数据
    // ---------------以下为Link类中定义的方法-----------------
    @Override
    public void add(E e) {
        // 数据本身不具有关联特性,只有Node节点有,那么要实现关联就必须将数据包装在Node类中
        Node node = new Node(e); // 创建一个新的节点
        if(root == null) { // 现在没有根节点
            this.root = node; // 第一个节点作为根节点
        }else{
            this.root.addNode(node); // 将新节点保存在合适的位置
        }
        this.count ++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        // return this.root == null;
        return this.count == 0;
    }

    @Override
    public Object[] toArray() {
        // 判断是否为空
        if(this.root == null){
            return null;
        }
        this.foot = 0; //脚标清零
        this.returnData =  new Object[this.count]; // 根据已有的长度新建一个数组
        this.root.toArrayNode(); // 利用Node类进行递归获取数据
        return this.returnData;


    }

}

public class LinkDemo2 {
    public static void main(String args[]) {
        ILink<String> all = new LinkImpl<>();
        System.out.println("[增加之前]数据的个数:" + all.size());
        System.out.println("是否为空集合:" + all.isEmpty());
        all.add("Hello");
        all.add("World");
        System.out.println("[增加之后]数据的个数:" + all.size());
        System.out.println("是否为空集合:" + all.isEmpty());

        Object[] result = all.toArray();
        for (Object obj : result) {
            System.out.println(obj);
        }
    }
}
```

集合的数据一般如果要返回肯定要以对象数组的形式返回.

## 获取指定索引数据

链表可以像数组一样进行处理,所以也应该可以像数组一样进行索引数据的获取,在这样的情况下就可以继续利用
递归的形式来完成.