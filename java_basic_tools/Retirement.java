/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basic_tools;
import java.util.*;
/**
 *
 * @author 麦子
 */
public class Retirement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Your base:");
        double base = in.nextDouble();
        System.out.println("interest rate:");
        double interestRate = in.nextDouble();
        System.out.println("Your goal:");
        double goal = in.nextDouble();
        
        int year = 0;
        
        while(base < goal)
        {
            base += base * (1 + interestRate)/100;
            year ++;
        }
        System.out.println("After " + year + " you will achieve your goal");
    }
    
}
