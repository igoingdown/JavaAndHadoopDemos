package java_basic_tools;

/**
 * Created by zhaomingxing on 2016/12/26.
 */

abstract class Person
{
    public Person() {
        name = "unknow";
    }

    public Person(String s) {
        name = s;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    private String name;
}
