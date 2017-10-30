/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basic_tools;
import java.math.*;
import java.util.*;

/**
 *
 * @author 麦子
 */
public class BigIntegerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        
        BigInteger a = BigInteger.valueOf(1);
        for(int i = 1; i <= k; i++)
        {
            a = a.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println(a);
    }
    
}
