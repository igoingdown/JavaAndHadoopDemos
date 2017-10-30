package java_basic_tools;

import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<Integer> aList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            aList.add(i);
            System.out.println(i);
        }
        for (int i = 0; i < aList.size(); i++) {
            Integer m = aList.get(i);
            m++;
            aList.set(i, m);
            System.out.println(m);
        }
    }
}
