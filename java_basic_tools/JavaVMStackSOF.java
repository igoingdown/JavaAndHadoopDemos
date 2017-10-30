package java_basic_tools;

/**
 * Created by zhaomingxing on 2017/1/10.
 */
public class JavaVMStackSOF {
    public static void main(String[] args) {
        JavaVMStackSOF j = new JavaVMStackSOF();
        try {
            j.stackLeak();
        } catch (Exception e) {
            System.out.println(j.stackLength + "\n\n");
            System.exit(1);
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    private int stackLength = 1;
}
