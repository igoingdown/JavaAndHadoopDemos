package java_basic_tools;

/**
 * Created by zhaomingxing on 2016/12/26.
 */

class Student extends Person
{
    public Student(String n, String m)
    {
        super(n);
        major = m;
    }

    public String getDescription()
    {
        return "a student majoring in " + major;
    }

    private String major;
}

