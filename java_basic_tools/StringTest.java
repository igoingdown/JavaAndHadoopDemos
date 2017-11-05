package java_basic_tools;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("hello world");
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1, 2));

        String a=  "hh";
        String b = "hh";
        System.out.println(a == b);
        System.out.println(s.substring(1));
    }
}
