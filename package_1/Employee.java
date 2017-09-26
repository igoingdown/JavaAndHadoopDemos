package package_1;

import java.util.*;
import java.lang.*;

/**
 * Created by zhaomingxing on 2016/12/22.
 */
public class Employee extends Person implements Comparable<Employee>, Cloneable{
    public Employee(String n, double s, int year, int month, int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public Employee() {
        name = "unknown";
        salary = 0;
        GregorianCalendar calendar = new GregorianCalendar(2000, 1, 1);
        hireDay = calendar.getTime();
    }

    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public int compareTo(Employee other) {
        if (salary < other.salary) {
            return -1;
        } else if (salary > other.salary) {
            return 1;
        }
        return 0;
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();
        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }

    public String toString() {
        return "Employee[\n\tname: " + name + "\n\tsalary: " + salary + "\n\thireDay: " + hireDay + "]";
    }

    public void setHireDay(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        hireDay = calendar.getTime();
    }

    public void raiseSalary(double rate) {
        double raise = salary * rate / 100;
        salary += raise;
    }

    private String name;
    private double salary;
    private Date hireDay;
}
