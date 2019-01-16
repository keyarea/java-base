package annotation;

class Channel{
    public void content(){
        System.out.println("*********** Channel *************");
    }
}

class DatabaseChannel extends Channel{
    public void content(){
        System.out.println("************ DatabaseChannel ************");
    }
}

public class TestDemo {
    public static void main(String[] args){
        new DatabaseChannel().content();
    }
}
