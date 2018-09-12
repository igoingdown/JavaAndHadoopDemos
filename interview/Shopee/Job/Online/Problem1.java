package interview.Shopee.Job.Online;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        // AC 45%!!
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = Long.parseLong(in.nextLine());
            StringBuffer buffer = new StringBuffer();
            String str = Long.toString(n);
            if (str.charAt(0) == '-') {
                buffer.append('-');
                str = str.substring(1);
            } else if (str.charAt(0) == '+') {
                buffer.append('+');
                str = str.substring(1);
            }

            int l = str.length();
            if (l % 3 == 1) {
                buffer.append(str.substring(0, 1));
                str = str.substring(1);
            } else if (l % 3 == 2) {
                buffer.append(str.substring(0, 2));
                str = str.substring(2);
            }
            while (str.length() > 0) {
                if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) != '-' && buffer.charAt(buffer.length() - 1) != '+') buffer.append(',');
                buffer.append(str.substring(0, 3));
                str = str.length() > 3 ? buffer.substring(3) : "";
            }
            System.out.println(buffer.toString());
        }
    }
}
