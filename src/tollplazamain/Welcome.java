/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tollplazamain;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Welcome {
	
	public static JFrame screen;
	public static JLabel welcomeText, tagline, bg, top;
	public static JButton getStarted;
	
	
	
	public void Welcome() 
        {
		
		//icons and images
		ImageIcon img = new ImageIcon("images/toll.png");
		ImageIcon bgp = new ImageIcon("images/toll01E.jpg");
                Icon icon = new ImageIcon("images/check.png");
    	
    	//frame
    	screen = new JFrame();
    	screen.setLayout(null);
    	screen.setSize(1200,800);
    	screen.setTitle("Toll Plaza Management System");
    	screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	screen.setResizable(false);
    	screen.setIconImage(img.getImage());
    	screen.getContentPane().setBackground(new Color(0x214252));
    	
    	//label
    	welcomeText = new JLabel("Welcome to Toll Plaza Management System");
    	welcomeText.setFont(new Font("Century Gothic",Font.BOLD, 30));
    	welcomeText.setForeground(Color.WHITE);
    	welcomeText.setBounds(263 ,230 , 800, 200);
    	screen.add(welcomeText);
    	
    	tagline = new JLabel("PROVE YOURSRLF A GOOD CITIZEN AND PAY YOUR TOLL");
    	tagline.setFont(new Font("Century Gothic",Font.BOLD, 25));
    	tagline.setForeground(new Color(0xf4f3ee));
    	tagline.setBounds(245 ,275 , 800, 200);
    	screen.add(tagline);
    	
    	//button
    	getStarted = new JButton(icon);
    	getStarted.setText("Get Started");
        getStarted.setBounds(515 ,410 ,150 ,35);
        getStarted.setFocusable(false);
        screen.add(getStarted);
        
        //background picture
        bg = new JLabel("",bgp,JLabel.CENTER);
    	bg.setBounds(0, 0, 1200, 800);
        screen.add(bg);
        
        //action for buttons
        getStarted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	screen.dispose();
            	
//            	JOptionPane.showMessageDialog(null,"Setting up logging screen...");
            	login lg = new login();
            	lg.login();
            }
        });
        
        //visibility
    	screen.setVisible(true);
        screen.setLocation(400, 150);
	}
}