package 枚举;

enum Size
{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;

    // 枚举的构造必须由private修饰
    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
}


public class TestDemo {
    public static void main(String[] args){

        // 返回枚举常量名
        System.out.println(Size.SMALL.toString()); // SMALL

        // 将 s 设置成 Size.SMALL
        Size s = Enum.valueOf(Size.class, "SMALL");

        // 返回一个包含全部枚举值的数组
        Size[] values = Size.values();

        for(Size value : values){
            System.out.println(value);
        }

        System.out.println(s.getAbbreviation());


    }
}
