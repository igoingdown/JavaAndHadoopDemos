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
public class InputTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Input your name:");
        String name = in.nextLine();
        
        System.out.println("Input your age:");
        int age = in.nextInt();
        
        System.out.println("Hello, " + name +"! \n");
        System.out.println("Your age is " + age + ".\n");
        
    }
    
}
