package CCI150;

public class FloatBinaryPresentation {
    public static void main(String[] args) {
        System.out.println(printNum(0.75));
    }

    public static String printNum(double x) {
        if (x <= 0 && x >= 1) return "ERROR";
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (x > 0) {
            if (binary.length() >= 32) return "ERROR";
            x *= 2;
            if (x >= 1) {
                    binary.append(1); x -= 1;
            } else binary.append(0);
        }
        return binary.toString();
    }
}
