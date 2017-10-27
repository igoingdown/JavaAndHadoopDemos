/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousinnerclasstest;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author 麦子
 */
public class AnonymousInnerClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TalkingClock c = new TalkingClock();
        c.start(1000, true);
        
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
        
    }
    
}

class TalkingClock
{
    public void start(int interval, final boolean beep)
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if(beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        };
        
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
