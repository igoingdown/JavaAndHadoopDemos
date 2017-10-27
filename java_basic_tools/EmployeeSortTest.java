/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;
import java.util.Arrays;

/**
 *
 * @author 麦子
 */
public class EmployeeSortTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Mingxing", 200000, 1999, 1, 2);
        staff[1] = new Employee("Xiaoqiang", 10000, 2000, 4, 1);
        staff[2] = new Employee("Youjiang", 20000, 1957, 1, 2);

        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }
    }
}

