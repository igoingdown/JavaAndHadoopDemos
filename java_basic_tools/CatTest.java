package java_basic_tools;

/**
 * Created by zhaomingxing on 2017/5/13.
 */
public class CatTest {
    public static void main(String[] args) {
        Cat aCat = new Cat(1, "hello");
        System.out.println(aCat.name);
        Cat myCat = new Cat();
        System.out.println(myCat.getName());
    }
}

class Cat {
    int age;
    String name;
    String color;

    public Cat() {
        name = "mingjiang";
        age = 1;
    }

    public Cat(int a, String b) {
        name = b;
        age = a;
    }

    public Cat(String s) {
        name = s;
        age = 1;
    }

    public String getName() {
        return name;
    }
}
