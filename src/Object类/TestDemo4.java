package Object类;

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
