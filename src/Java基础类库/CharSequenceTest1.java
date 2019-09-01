package Java基础类库;

public class CharSequenceTest1 {
    public static void main(String[] args) {
        CharSequence str = "helloworld";
        CharSequence sub = str.subSequence(5, 10);
        System.out.println(sub); // world
    }
}
