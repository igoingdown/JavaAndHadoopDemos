/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basic_tools;

/**
 *
 * @author 麦子
 */
public class StaticClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] d = new double[20];
        for(int i = 0; i < 20; i ++)
            d[i] = 100 * Math.random();
        
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        
        System.out.println("the min num is:" + p.getFirst());
        System.out.println("the max num is:" + p.getSecond());
    }
    
}

class ArrayAlg
{
    public static class Pair
    {
        public Pair(double f, double s)
        {
            first = f;
            second = s;
        }
        
        public double getFirst()
        {
            return first;
        }
        
        public double getSecond()
        {
            return second;
        }
        
        private double first;
        private double second;
    }
    
    public static Pair minmax(double[] values)
    {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        for(double d : values)
        {
            if(min > d)
                min = d;
            if(max < d)
                max = d;
        }
        return new Pair(min, max);
    }
    
}