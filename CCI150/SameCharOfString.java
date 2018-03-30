package CCI150;


public class SameCharOfString {
    public static void main(String[] args) {
        String str = new String("aab");
        if (sameCharacters(str)) System.out.println(str + " all same");
        else System.out.println(str + " not all same");
    }

    public static boolean sameCharacters(String s) {
        if (s.length() == 0) return false;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) return false;
        }
        return true;
    }
}
