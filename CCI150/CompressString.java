package CCI150;

public class CompressString {
    public static void main(String[] args) {
        String s = "ahfueh";
        System.out.println(compressString(s));
    }

    public static String compressString(String str) {
        if (str.length() == 0) return str;
        StringBuffer stringBuffer = new StringBuffer();
        int begin = 0, end = 0;
        while (begin<= end && end < str.length()) {
            while (end < str.length() && str.charAt(begin) == str.charAt(end)) ++end;
            Integer count = end - begin;
            stringBuffer.append(count).append(str.charAt(begin));
            begin = end;
        }
        String s = stringBuffer.toString();
        return s.length() < str.length() ? s : str;
    }
}
