package CCI150;

public class IsRotateString {
    public static void main(String[] args) {
        String str1 = "waterbottle", str2 = "erbottlewat";
        if (isRotateString(str1, str2)) System.out.println("Y");
        else System.out.println("N");
    }

    public static boolean isRotateString(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str1);
        stringBuilder.append(str1);
        return stringBuilder.toString().contains(str2);
    }
}
