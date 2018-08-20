package interview.Alibaba.Internship.Round2;

import java.util.Scanner;

public class SortRGB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(sortRGB(in.nextLine()));
        }
    }

    private static String sortRGB(String str) {
        StringBuffer buffer = new StringBuffer(str);
        int rIndex = 0, gIndex = 1, bIndex = 2;
        for (int i = 0; i < str.length(); i++) {
            while ((i % 3 == 0 && buffer.charAt(i) != 'R') || (i % 3 == 1 && buffer.charAt(i) != 'G') || (i % 3 == 2 && buffer.charAt(i) != 'B')) {
                char c = buffer.charAt(i);
                if (c == 'R') {
                    buffer.setCharAt(i, buffer.charAt(rIndex));
                    buffer.setCharAt(rIndex, c);
                    rIndex += 3;
                } else if (c == 'G') {
                    buffer.setCharAt(i, buffer.charAt(gIndex));
                    buffer.setCharAt(gIndex, c);
                    gIndex += 3;
                } else {
                    buffer.setCharAt(i, buffer.charAt(bIndex));
                    buffer.setCharAt(bIndex, c);
                    bIndex += 3;
                }
            }
        }
        return buffer.toString();
    }
}
