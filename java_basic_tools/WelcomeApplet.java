/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basic_tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 *
 * @author 麦子
 */
public class WelcomeApplet extends JApplet
{
    public void init()
    {
        setLayout(new BorderLayout());
        
        JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 18));
        add(label, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        
        JButton baiduButton = new JButton("Baidu");
        baiduButton.addActionListener(makeURLActionListener("www.baidu.com"));
        panel.add(baiduButton);
    
        JButton byrButton = new JButton("BYRBT");
        byrButton.addActionListener(makeURLActionListener("bt.byr.cn"));
        panel.add(byrButton);
        
        add(panel, BorderLayout.SOUTH);
    }
    /**
     * @param args the command line arguments
     */
    private ActionListener makeURLActionListener(final String u)
    {
        return new ActionListener() {
            public void actionPerformed(ActionEvent event)
            {
                try {
                    getAppletContext().showDocument(new URL(u));
                } catch(MalformedURLException e)
                {
                    e.printStackTrace();
                }
            
            }
        };
    
    }
    
}
