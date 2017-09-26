/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package package_1;
import java.util.*;
import java.text.*;

/**
 *
 * @author 麦子
 */
public class PersonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person [] people = new Person[2];
        people[0] = new Employee("Scott Mayers",10000.0, 1993, 8, 2);
        people[1] = new Student("Zhao Mingxing", "Computer Science");
        
        for(Person p : people)
            System.out.println(p.getDescription());
    }
    
}


