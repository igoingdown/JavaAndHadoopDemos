/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author 麦子
 */
public class InnerClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TalkingClock c = new TalkingClock(100, true);
        c.start();
        
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
    
}

class TalkingClock
{
    public TalkingClock(int interval, boolean beep)
    {
        this.beep = beep;
        this.interval = interval;
    }
    
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
    
    private int interval;
    private boolean beep;
    
    private class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Date now = new Date();
            System.out.println("At this tone, the time is:" + now);
            if(beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
    
}