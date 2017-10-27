package package_1;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by zhaomingxing on 2016/12/22.
 */
public class ArrayListTest {
    public static void  main(String args[]) {
        ArrayList<Employee> staff = new ArrayList<Employee>();
        if (staff.isEmpty()) {
            System.out.println("staff is empty!");
        }
        boolean empty = false;
        if (!empty) {
            System.out.println(empty);
        }
        int a = 10;
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        intArr.add(a);
        System.out.println(intArr.get(0));
        int b = intArr.get(0);
        double c = intArr.get(0).doubleValue();
        System.out.println(c);
        System.out.println(b);
        System.out.println(staff.size());
        if (b == c) {
            System.out.println("b and c equal!");
        }
        staff.add(new Employee("Zhao", 1000, 1999, 10, 1));
        System.out.println(staff.size());
        staff.add(new Employee("Cheng", 10000, 2012, 8, 2));
        System.out.println(staff.size());
        staff.add(new Employee("Su", 20000, 2006, 9, 1));
        System.out.println(staff.size());
        for (Employee e : staff) {
            e.raiseSalary(2);
        }
        for (Employee e: staff) {
            System.out.println("name = " + e.getName() + " salary = " + e.getSalary() + " hireDay = " + e.getHireDay());
        }

        Employee e = staff.get(0);
        System.out.println(e.getClass());
        System.out.println(Employee.class);
        try {
            Employee x = Employee.class.newInstance();
            System.out.println(x.getName());
        } catch (Exception un_e) {
            System.out.println("Exception happened when creating a new instance of Employee");
        }

        try {
            String s = "java.util.Dat";
            Object d = Class.forName(s).newInstance();
            System.out.println(d.toString());
        } catch (Exception exc) {
            System.out.println("name error");
        }

        System.out.println(int[].class.getName());
        System.out.println(double[].class.getName());
        System.out.println(Integer[].class.getName());
        System.out.println(Double[].class.getName());
        System.out.println(Boolean[].class.getName());

        System.out.println(getMax(staff.get(0).getSalary(), staff.get(1).getSalary(), staff.get(2).getSalary()));
    }

    public static double getMax(double ...values) {
        double m = Double.MIN_VALUE;
        for (double d : values) {
            if (d > m) {
                m = d;
            }
        }
        return m;
    }
}
