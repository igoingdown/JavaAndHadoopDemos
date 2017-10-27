/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;
import javax.swing.*;
/**
 *
 * @author 麦子
 */
public class DialogTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name = JOptionPane.showInputDialog("What's your name?");
        String strAge = JOptionPane.showInputDialog("How old are you?");
        int age = Integer.parseInt(strAge);
        System.out.println("Hello," + name +"!\n" +"Your age is " + age +".\n");
        if(strAge.equals("dd"))
            System.out.println("yeah!");
        else
            System.out.println("Not equal!");
        System.exit(0);
    }
    
}
