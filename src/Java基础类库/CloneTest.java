package Java基础类库;

public class CloneTest {
    public static void main(String[] args) throws Exception {
        Person p = new Person("王五", 25);
        Person p1 = (Person) p.clone();
        System.out.println(p1);
        System.out.println(p);
    }
}

class Person implements Cloneable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + "]" + "name:" + this.name + " age: " + this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
