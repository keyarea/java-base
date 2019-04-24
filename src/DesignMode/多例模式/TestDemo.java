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
