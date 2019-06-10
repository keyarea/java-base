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
