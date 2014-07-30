/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author brandan
 */
public class Portfolio extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new Portfolio();
        frame.setVisible(true);
    }
    
    public Portfolio(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setTitle("Portfolio");
        setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setBackground(Color.WHITE);
        intComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((screenSize.width  - FRAME_WIDTH)  / 2,
                              (screenSize.height - FRAME_HEIGHT) / 2));
        d = new Driver();
        programs = d.getData();
    }
    
    public void intComponents(){
        d = new Driver();
        programs = d.getData();
        String[] s = d.getProgramStrings(programs);
        listBox = new JList(s);
        okButton = new JButton("Launch");
        
        okButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    d.launchProgram(programs[listBox.getSelectedIndex()]);
                    dispose();
                }
                catch(Exception e){
                    System.out.println("Please Select a program");
                }
            }});
        
        
        add(listBox, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);
    }
    
    private JList listBox;
    private JButton okButton;
    private Program[] programs;
    Driver d;
    private final int FRAME_HEIGHT = 600;
    private final int FRAME_WIDTH = 400;
}
