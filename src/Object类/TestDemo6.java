package Object类;

interface IMessage{

}

class MessageImpl implements IMessage{
    @Override
    public String toString(){ // 覆写Object方法
        return "hello";
    }
}

public class TestDemo6 {
    public static void main(String[] args){
        // 子类向父接口转型
        IMessage mes = new MessageImpl();
        // 接口向Object转型
        Object obj = mes;
        System.out.println(obj);

    }
}
