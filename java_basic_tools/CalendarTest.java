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
public class CalendarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GregorianCalendar calendar = new GregorianCalendar();
        
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        for(int i = Calendar.SUNDAY; i < weekday; i++)
        {
            System.out.println("    ");
        }
        
        do
        {
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            
            if(day == today)
                System.out.print("*");
            else
                System.out.print(" ");
            
            if(weekday == Calendar.SATURDAY)
                System.out.println();
            
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            weekday = calendar.get(Calendar.DAY_OF_WEEK);
            
        }
        while(calendar.get(Calendar.MONTH) == month);
        
        if(weekday == Calendar.SUNDAY)
            System.out.println();
    }
    
}
