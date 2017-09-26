/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;
import java.lang.reflect.*;
import java.util.*;

/**
 *
 * @author 麦子
 */
public class ProxyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object[] elements = new Object[1000];
        
        for (int i = 0; i < elements.length; i++)
        {
            Integer value = i + 1;
            Class[] interfaces = value.getClass().getInterfaces();
            InvocationHandler handler = new TraceHandler(value);
            
            Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
            elements[i] = proxy;
        }
        
        Integer key = new Random().nextInt(elements.length) + 1;
        
        int result = Arrays.binarySearch(elements, key);
        if(result > 0)
            System.out.println(elements[result]);
    }
    
}

class TraceHandler implements InvocationHandler
{
    public TraceHandler(Object t)
    {
        target = t;
    }
    
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        System.out.print(target);
        System.out.print("." + m.getName() + "(");
        if(args != null)
        {
            for(int i = 0; i < args.length; i ++)
            {
                System.out.print(args[i]);
                if(i == args.length - 1)
                    System.out.print(", ");
            }
        }
        System.out.println(")");
        return m.invoke(target, args);
    }
    
    private Object target;
}