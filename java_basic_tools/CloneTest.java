package package_1;

/**
 * Created by zhaomingxing on 2017/1/4.
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee e = new Employee("zhao", 1000, 1999, 1, 2);
            e.setHireDay(2000, 1, 1);
            Employee c = e.clone();
            c.raiseSalary(10);
            e.raiseSalary(20);
            System.out.println(c);
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
