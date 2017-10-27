/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;
import java.util.*;

/**
 *
 * @author 麦子
 */
public class EmployeeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee[] staff = new Employee[3];
        for(int i = 0; i < 3; i++)
        {
            staff[i] = new Employee("Baker", 13000, 1998, 5, 12);
        }
        
        double rate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inlut rising rate:");
        rate = scanner.nextDouble();
        for(int i = 0; i < 3; i++)
        {
            staff[i].raiseSalary(rate);
            System.out.println(staff[i].getSalary());
        }
    }
    
}

