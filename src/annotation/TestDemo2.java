package annotation;

class Women{
    @Deprecated // 过期的方法，不建议使用
    public void say(){
        System.out.println("你好");
    }

    public String speak(){
        return "hello";
    }
}


public class TestDemo2 {
    //@SuppressWarnings({"deprecation"})
    public static void main(String[] args){
        new Women().say();
    }

}
