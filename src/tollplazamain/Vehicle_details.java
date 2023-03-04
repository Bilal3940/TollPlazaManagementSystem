/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Vehicle_details {

        public static JFrame vDetailFrame;
        public static  JLabel vNameLabel ,vModelLabel,vNumPlateLabel, iconLabel, vDLabel, invalidn, invalidm;
        public static JTextField vNumberPlate, vModel, vName;
        public static JButton submitButton;
        FileWriter fileWriter;
        
        public void vDetailsClass(){
           
        	//Icons and images
        	ImageIcon img = new ImageIcon("images/toll.png");
        	Icon icon = new ImageIcon("images/check.png");
        	Icon icon2 = new ImageIcon("images/car.png");
        	
        	
        	//Setting up frame
            vDetailFrame = new JFrame();
            vDetailFrame.setLayout(null);
            vDetailFrame.setSize(500,450);
            vDetailFrame.setTitle("Toll Plaza Managment");
            vDetailFrame.setDefaultCloseOperation(vDetailFrame.EXIT_ON_CLOSE);
            vDetailFrame.setResizable(false);
            vDetailFrame.setIconImage(img.getImage());
            vDetailFrame.getContentPane().setBackground( new Color(0x214252));


            //Labels
            iconLabel = new JLabel(icon2);
            iconLabel.setBounds(50, 35, 64, 64);
            vDetailFrame.add(iconLabel);
            
            vDLabel = new JLabel("Vehicle Details");
            vDLabel.setFont(new Font("Century Gothic",Font.BOLD, 20));
            vDLabel.setForeground(Color.WHITE);
            vDLabel.setBounds(135, 20, 150, 100);
            vDetailFrame.add(vDLabel);
            
            vNameLabel = new JLabel("Vehicle Name: ");
            vNameLabel.setBounds(50 , 100 ,100,100);
            vNameLabel.setForeground(Color.WHITE);
            vDetailFrame.add(vNameLabel);
            
            invalidn = new JLabel();
            invalidn.setBounds(175,165,150,35);
            invalidn.setForeground(Color.RED);
            vDetailFrame.add(invalidn);

            vNumPlateLabel = new JLabel("Vehicle Number: ");
            vNumPlateLabel.setBounds(50 , 170 ,100,100);
            vNumPlateLabel.setForeground(Color.WHITE);
            vDetailFrame.add(vNumPlateLabel);
 
            vModelLabel = new JLabel("Vehicle Model: ");
            vModelLabel.setBounds(50 , 240 ,100,100);
            vModelLabel.setForeground(Color.WHITE);
            vDetailFrame.add(vModelLabel);

            invalidm = new JLabel();
            invalidm.setBounds(175,305,150,35);
            invalidm.setForeground(Color.RED);
            vDetailFrame.add(invalidm);

            //Textfields for entering data with validation
            vName = new JTextField();
            vName.setBounds(175,135,235,35);
            vDetailFrame.add(vName);
            vName.addKeyListener(new KeyAdapter() {
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
            
            vNumberPlate = new JTextField();
            vNumberPlate.setBounds(175,205,235,35);
            vDetailFrame.add(vNumberPlate);

            vModel = new JTextField();
            vModel.setBounds(175,275,235,35);
            vDetailFrame.add(vModel);
            vModel.addKeyListener(new KeyAdapter() {
    			@Override
    			public void keyTyped(KeyEvent e) {
    				char c = e.getKeyChar();
    				if(!(Character.isDigit(c))) {
    					e.consume();
    					invalidm.setText("Only numbers are allowed");
    				}
    				else {
    					invalidm.setVisible(false);
    				}
    			}
    		});

            //Buttons for specific actions
            submitButton = new JButton(icon);
            submitButton.setText("Submit");
            submitButton.setBounds(195 ,345 ,100 ,35);
            submitButton.setFocusable(false);
            vDetailFrame.add(submitButton);
            
            //Visibility setting
            vDetailFrame.setVisible(true);
            vDetailFrame.setLocation(700,240);
            
            //Button actions with writing and append of text
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                    	
                    	if(vName.getText().isEmpty() || vNumberPlate.getText().isEmpty() || vModel.getText().isEmpty()) {
                        	JOptionPane.showMessageDialog(null,"Please enter all fields");
                    	}
                    	
                    	else {
                    	String info = vNameLabel.getText() + vName.getText() + "\n" + vNumPlateLabel.getText() + 
                    			vNumberPlate.getText()+"\n" + vModelLabel.getText() + vModel.getText()+ "\n";
                        
                    	  try {
                    		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
                    				  info.getBytes(), StandardOpenOption.APPEND);
                    	  }
                          catch (IOException et) {
                    	      et.printStackTrace();
                    	  }
                        
                        fileWriter = new FileWriter("D:\\TollPlazamain\\files\\vDetails.txt");
                        fileWriter.write(vName.getText() + "\n");
                        fileWriter.write(vNumberPlate.getText()+"\n");
                        fileWriter.write(vModel.getText());
                        fileWriter.close();
                        vDetailFrame.dispose();
                        
                        //Object for next class
                        Vehicle_category vc = new Vehicle_category();
                        vc.vCategoryClass();
                    }
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex+"");
                    }
                }
            }
            );

        }
    }
