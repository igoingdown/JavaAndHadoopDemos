/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basic_tools;
import java.util.*;
import java.lang.reflect.*;

/**
 *
 * @author 麦子
 */
public class ReflectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for(int i = 1; i <= 5; i++)
            System.out.println(new ObjectAnalyzer().toString(squares));
    }
    
}

