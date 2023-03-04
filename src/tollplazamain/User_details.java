
package tollplazamain;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class User_details {
	public static JFrame userFrame = new JFrame();
	public static JTextField username, cnic, phone_num;
	public static  JLabel unamelabel, cniclabel, phlabel, success, iconLabel, userDLabel, 
	invalidn, invalidc, invalidp;
	public static JButton submitButton;
	FileWriter file1;

    public void userdetailsClass(){
    	
    	//Setting images and icons
    	ImageIcon img = new ImageIcon("images/toll.png");
    	Icon icon = new ImageIcon("images/check.png");
    	Icon icon2 = new ImageIcon("images/customer1.png");
    	
    	
    	//Frame
        userFrame = new JFrame();
        userFrame.setLayout(null);
        userFrame.setSize(500,450);
        userFrame.setTitle("Toll Plaza Managment");
        userFrame.setDefaultCloseOperation(userFrame.EXIT_ON_CLOSE);
        userFrame.setResizable(false);
        userFrame.setIconImage(img.getImage());
        userFrame.getContentPane().setBackground( new Color(0x214252));
        
        
        //Labels for text and stuff
        iconLabel = new JLabel(icon2);
        iconLabel.setBounds(50, 35, 64, 64);
        userFrame.add(iconLabel);
        
        userDLabel = new JLabel("User Details");
        userDLabel.setFont(new Font("Century Gothic",Font.BOLD, 20));
        userDLabel.setForeground(Color.WHITE);
        userDLabel.setBounds(180, 20, 150, 100);
        userFrame.add(userDLabel);
        
        unamelabel = new JLabel("Name:");
        unamelabel.setBounds(50 , 100 ,100,100);
        unamelabel.setForeground(Color.WHITE);
        userFrame.add(unamelabel);
        
        
        invalidn = new JLabel();
        invalidn.setBounds(175,165,150,35);
        invalidn.setForeground(Color.RED);
        userFrame.add(invalidn);

        cniclabel = new JLabel("CNIC:");
        cniclabel.setBounds(50 , 170 ,100,100);
        cniclabel.setForeground(Color.WHITE);
        userFrame.add(cniclabel);
        
        invalidc = new JLabel();
        invalidc.setBounds(175,235,150,35);
        invalidc.setForeground(Color.RED);
        userFrame.add(invalidc);

        phlabel = new JLabel("Phone Number:");
        phlabel.setBounds(50 ,240 ,100 ,100);
        phlabel.setForeground(Color.WHITE);
        userFrame.add(phlabel);
        
        invalidp = new JLabel();
        invalidp.setBounds(175,305,150,35);
        invalidp.setForeground(Color.RED);
        userFrame.add(invalidp);

        //Text fields with validation
        username = new JTextField();
        username.setBounds(175,135,235,35);
        userFrame.add(username);
        username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isLetter(c)) && !(Character.isSpace(c))) {
					e.consume();
					invalidn.setText("Enter letters only");
				}
				else {
					invalidn.setVisible(false);
				}
			}
		});
 
        cnic = new JTextField();
        cnic.setBounds(175,205,235,35);
        userFrame.add(cnic);
        cnic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
					invalidc.setText("Enter numbers only");
				}
				else {
					invalidc.setVisible(false);
				}
			}
		});

        phone_num = new JTextField();
        phone_num.setBounds(175,275,235,35);
        userFrame.add(phone_num);
        phone_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
					invalidp.setText("Enter numbers only");
				}
				else {
					invalidp.setVisible(false);
				}
			}
		});

        
        //Buttons for specific actions
        submitButton = new JButton(icon);
        submitButton.setText("Submit");
        submitButton.setBounds(200 ,345 ,100 ,35);
        submitButton.setFocusable(false);
        userFrame.add(submitButton);
        
        //Setting visibility of frame
        userFrame.setVisible(true);
        userFrame.setLocation(700,240);
        
        
        //Setting certains actions for buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	
                	if(username.getText().isEmpty() || cnic.getText().isEmpty() || phone_num.getText().isEmpty()) {
                    	JOptionPane.showMessageDialog(null ,"Please enter all fields");
                	}
                	
                	else {
                	String info = "\n" + unamelabel.getText()  + username.getText()+ "\n" + cniclabel.getText() + cnic.getText()+ "\n" + phlabel.getText() + phone_num.getText() + "\n";
                    
                	  try {
//                                FileWriter f = new FileWriter("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt");
//                                f.append((CharSequence) info.chars());
                		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),info.getBytes(), StandardOpenOption.APPEND);
                	  }
                          catch (IOException et) {
                	      et.printStackTrace();
                	  }
                	
                    file1 = new FileWriter("D:\\TollPlazamain\\files\\CurrentCustomer.txt");
                    file1.write(username.getText()+"\n");
                    file1.write(cnic.getText()+"\n");
                    file1.write(phone_num.getText());
                    file1.close();
                    
                    
                    userFrame.dispose();
                    Vehicle_details vd = new Vehicle_details();
                    vd.vDetailsClass();
                    
                }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex+"");
                }
                
                
            }
        });
        
    }
}
