package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class People {
    private String name = "liming";
    private int age = 20;
    public String eName = "人";

    public People(){}

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    private People(String name){
        this.name = name;
    }

    public void method(String str){
        System.out.println("public修饰的method方法");
    }

    private void method1(){
        System.out.println("private修饰的method1方法");
    }

    String method2(String message){
        System.out.println(message);
        return message;
    }

    protected void  method3(){
        System.out.println("protected 修饰的方法");
    }

    public String geteName() {
        return eName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class Demo {
    public static void main(String[] args){

        /*
        获取类对象
         */

        /*
        第一种方式获取类对象
         */

        // 创建一个对象
        People p = new People();

        // 获取对象的class对象
        Class c = p.getClass();

        // 获取类名称
        System.out.println(c.getName());

        /*
        第二种方式获取类对象
         */

        // 通过静态方法获取类名对应的Class对象
        String className = "反射.People";
        try{
            Class c1 = Class.forName(className);
            System.out.println(c1.getName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        /*
        第三种方式获取类对象
         */
        Class c2 = People.class;
        System.out.println(c2.getName());

        /*
        类对象比较
         */

        if(c == c2){
            System.out.println("两个类对象相同");
        }

        /*
        类对象实例化
         */

        try{
            People p1 = (People) c.newInstance();
            System.out.println(p1.getName());
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }

        /*
        得到类对象的构造方法
         */

        System.out.println("____________得到类对象的所有共有构造方法______________");
        // 得到类对象的所有公用构造方法
        Constructor[] constructors = c.getConstructors();
        for(Constructor constructor: constructors ){
            System.out.println(constructor);
        }

        System.out.println("_______________________得到类对象的所有构造方法____________________________");
        // 得到类对象的所有构造方法
        Constructor[] constructors1 = c.getDeclaredConstructors();
        for(Constructor constructor: constructors1 ){
            System.out.println(constructor);
        }

        System.out.println("_______________________得到类对象的公有无参构造____________________________");
        try{
            Constructor constructor = c.getConstructor(null);
            System.out.println(constructor);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

        System.out.println("_______________________得到类对象的公有有参构造____________________________");
        try{
            Constructor constructor = c.getConstructor(String.class, int.class);
            System.out.println(constructor);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

        System.out.println("_______________________得到类对象的私有有参构造____________________________");
        try {
            Constructor constructor = c.getDeclaredConstructor(String.class);
            System.out.println(constructor);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

        /*
        获取类属性
         */

        System.out.println("_______________________得到类对象的公共字段____________________________");
        Field[] fields = c.getFields();
        for (Field field : fields){
            System.out.println(field);
        }

        System.out.println("_______________________得到类对象的所有字段____________________________");
        Field[] fields1 = c.getDeclaredFields();
        for (Field field : fields1){
            System.out.println(field);
        }


        System.out.println("______________________获取共有字段并使用_____________________________");
        try{
            // 获取指定共有字段
            Field field = c.getField("eName");
            // 获取共有构造方法并实例化
            Object obj = c.getConstructor().newInstance();
            // 为属性设置值
            field.set(obj, "hello");
            // 转型
            People people = (People) obj;

            System.out.println(people.geteName());


        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("______________________获取私有字段并使用_____________________________");
        try{
            // 获取指定私有字段
            Field field = c.getDeclaredField("name");
            // 获取构造方法并实例化
            Object obj = c.getConstructor().newInstance();
            // 暴力反射
            field.setAccessible(true);
            // 给属性设置值
            field.set(obj, "wang");

            People people = (People) obj;
            System.out.println(people.getName());

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("______________________获取public修饰的方法_____________________________");
        try{
            Method[] methods= c.getMethods();
            for (Method method : methods){
                System.out.println(method);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("______________________获取所有的方法_____________________________");
        try{
            Method[] methods= c.getDeclaredMethods();
            for (Method method : methods){
                System.out.println(method);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("______________________获取特定方法(带参数)并使用_____________________________");
        try {
            Method method = c.getMethod("method", String.class);
            System.out.println(method);

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("______________________获取特定方法(不带参数)并使用_____________________________");
        try{
            Method method = c.getDeclaredMethod("method1");
            System.out.println(method);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Method method = c.getDeclaredMethod("method2", String.class);
            // 获取构造方法，实例化一个对象
            Constructor constructor = c.getConstructor();
            Object obj = constructor.newInstance();

            // 给方法传值 调用
            Object invoke = method.invoke(obj,"hello");

            // 调用
            System.out.println(invoke);

        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
