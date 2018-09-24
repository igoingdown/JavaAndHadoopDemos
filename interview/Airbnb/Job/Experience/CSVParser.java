package interview.Airbnb.Job.Experience;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            for (String str : parse(in.nextLine())) System.out.println(str);
        }
    }

    private static List<String> parse(String str) {
        List<String> ans = new LinkedList<>();
        boolean inQuote = false;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (inQuote) {
                if (str.charAt(i) == '\"') {
                    if (i + 1 < str.length() && str.charAt(i + 1) == '\"') {
                        buffer.append(str.charAt(i));
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    buffer.append(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    ans.add(buffer.toString());
                    buffer.setLength(0);
                } else {
                    buffer.append(str.charAt(i));
                }
            }
        }
        if (buffer.length() > 0) {
            ans.add(buffer.toString());
            buffer.setLength(0);
        }
        return ans;
    }
}
