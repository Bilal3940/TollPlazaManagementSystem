
package tollplazamain;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class login {
    public static JFrame Frame;
    public static JTextField usernameTextField, passwordField;
    public static JLabel usernameLabel, passwordLabel, success, iconLabel, adminLabel;
    FileWriter fileWriter;

    String name= "amir";
    String password ="ali";

    public void login(){
        
    	//icons and images
    	ImageIcon img = new ImageIcon("images//toll.png");
    	Icon icon = new ImageIcon("images//check.png");
    	Icon icon2 = new ImageIcon("images//man.png");
    	
    	//frames+layout
        Frame = new JFrame();
        Frame.setLayout(null);
        Frame.setSize(500,450);
        Frame.setTitle("Toll Plaza Management System");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setIconImage(img.getImage());
        Frame.getContentPane().setBackground( new Color(0x214252));
     
        
        //labels
        iconLabel = new JLabel(icon2);
        iconLabel.setBounds(50, 35, 64, 64);
        Frame.add(iconLabel);
        
        adminLabel = new JLabel("Admin Login");
        adminLabel.setFont(new Font("Century Gothic",Font.BOLD, 20));
        adminLabel.setForeground(Color.WHITE);
        adminLabel.setBounds(135, 20, 150, 100);
        Frame.add(adminLabel);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50 , 100 ,100,100);
        usernameLabel.setForeground(Color.WHITE);
        Frame.add(usernameLabel);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50 , 170 ,100,100);
        passwordLabel.setForeground(Color.WHITE);
        Frame.add(passwordLabel);
        
        success = new JLabel();
        success.setBounds(138 ,285 ,200 ,100);
        success.setForeground(Color.RED);
        Frame.add(success);


        //Text fields
        usernameTextField = new JTextField();
        usernameTextField.setBounds(150,135,235,35);
        Frame.add(usernameTextField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,205,235,35);
        Frame.add(passwordField);

        //buttons
        JButton submitButton = new JButton(icon);
        submitButton.setText("Submit");
        submitButton.setBounds(175 ,275 ,100 ,35);
        submitButton.setFocusable(false);
        Frame.add(submitButton);
        
        
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = usernameTextField.getText();
                String password = passwordField.getText();
                if (user.equals("Hammad") && password.equals("071") || user.equals("Bilal") && password.equals("043") ) 
                {
                    try {
						fileWriter = new FileWriter("D:\\TollPlazamain\\files\\Operator.txt");
						fileWriter.write(usernameTextField.getText());
	                    fileWriter.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,e1+"");
					}

                    Frame.dispose();

                    User_details ud = new User_details();
                    ud.userdetailsClass();
                  
                }
                else{
                    success.setText("Invalid Username or Password");
                }
                
                
            }
        });
    	Frame.setLocation(700,240);
        Frame.setVisible(true);
    }

}