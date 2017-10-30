package java_basic_tools;

import java.util.Scanner;

/**
 * Created by zhaomingxing on 2017/1/2.
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:\n(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size s = Enum.valueOf(Size.class, input);
        System.out.println("size= " + s);
        System.out.println("abbreviation = " + s.getAbbreviation());
        if (s == Size.EXTRA_LARGE) {
            System.out.println("Good job, you paid attention to the _.");
        }
    }


}

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private Size(String s) {
        this.abbreviation = s;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    private String abbreviation;
}