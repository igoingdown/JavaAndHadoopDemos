package package_1;

/**
 * Created by zhaomingxing on 2017/1/9.
 */
public class Manager extends Employee{
    public Manager(String str, double s, int y, int m, int d) {
        super(str, s, y, m, d);
        bonus = 0;
    }

    public Manager() {
        super();
        bonus = 0;
    }

    public double getSalary() {
        double s = super.getSalary();
        return s + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    private double bonus;
}
