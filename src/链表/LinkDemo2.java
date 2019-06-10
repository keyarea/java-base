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
