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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Discount {
	public static JFrame dFrame;
	public static JLabel iconLabel, label, discountLabel;
	public static JRadioButton empFed, empArmed,none;
	public static ButtonGroup buttonGroup;
	public static JButton submitButton;
	FileWriter fileWriter;
	
	public void discountClass() throws IOException {
		
		//Icon and images
		ImageIcon img = new ImageIcon("images/toll.png");
    	Icon icon = new ImageIcon("images/check.png");
    	Icon icon2 = new ImageIcon("images/offer.png");
    	
    	//making an object for next class/window to be displayed
    	Discount_menu dm = new Discount_menu();
    	
    	
    	//Frame
		dFrame = new JFrame();
		dFrame.setSize(500,450);
		dFrame.setLayout(null);
                dFrame.setTitle("Toll Plaza Managment");
                dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dFrame.setResizable(false);
                dFrame.setIconImage(img.getImage());
                dFrame.getContentPane().setBackground( new Color(0x214252));

	    
	    //Labels for text and stuff
                iconLabel = new JLabel(icon2);
                iconLabel.setBounds(50, 35, 64, 64);
                dFrame.add(iconLabel);
        
                discountLabel = new JLabel("Discount");
                discountLabel.setFont(new Font("Century Gothic",Font.BOLD, 20));
                discountLabel.setForeground(Color.WHITE);
                discountLabel.setBounds(135, 20, 200, 100);
                dFrame.add(discountLabel);
	    
        label = new JLabel("Select the customer category");
	    label.setFont(new Font("Calibri",Font.BOLD, 16));
	    label.setForeground(Color.WHITE);
	    label.setBounds(105, 125, 200, 30);
	    
	    
	    //Circular buttons for certain categories
	    empFed = new JRadioButton("Federal Employee");
	    empFed.setOpaque(false);
	    empFed.setFocusable(false);
	    empFed.setForeground(Color.WHITE);
	    
	    empArmed = new JRadioButton("Armed Forces");
	    empArmed.setOpaque(false);
	    empArmed.setFocusable(false);
	    empArmed.setForeground(Color.WHITE);
	    
	    none = new JRadioButton("None of above");
	    none.setOpaque(false);
	    none.setFocusable(false);
	    none.setForeground(Color.WHITE);
	    
	    
	    //Setting up, so that the user selects ONLY ONE category for customer
	    buttonGroup = new ButtonGroup();
	    buttonGroup.add(empFed);
	    buttonGroup.add(empArmed);
	    buttonGroup.add(none);
	    
	    
	    //Buttons that do certains things
	    submitButton = new JButton(icon);
        submitButton.setText("Submit");
        submitButton.setBounds(195 ,260 ,100 ,35);
        submitButton.setFocusable(false);
        dFrame.add(submitButton);
	    
        //Setting positions for each circular button
	    empFed.setBounds(100,150,150,30);   
	    empArmed.setBounds(100,180,150,30); 
	    none.setBounds(100,210,150,30); 
	    
	    //Adding them to the frame
	    dFrame.add(label);
	    dFrame.add(empFed);
	    dFrame.add(empArmed);
	    dFrame.add(none);
	    dFrame.add(submitButton);
	    
	    
	    //Setting frame visibility
	    dFrame.setVisible(true);
	    dFrame.setLocation(700,240);
	    
	    //Setting special actions for buttons
	    submitButton.addActionListener(new ActionListener() {
                    @Override
	            public void actionPerformed(ActionEvent ae)
	            {	
	            	if(!(empFed.isSelected() || empArmed.isSelected() || none.isSelected())) {
	                	JOptionPane.showMessageDialog(null ,"Please enter all fields");
	            		}
	          	  	else{
	          	  		if(empFed.isSelected()){
	          	  			
	              	  String empFedStr = empFed.getActionCommand().toString();
	  	              int empFedDisc = 10;
	  	              
	  	              
	  	              File myFile = new File("D:\\TollPlazamain\\files\\empCategory.txt");
                              String info = "Category: " + empFed.getText() + ", Rate Rs. " + empFedDisc + "\n" ;
                              try {
                                  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
                                          info.getBytes(), StandardOpenOption.APPEND);
                                  
                                  
                                  myFile=new File("D:\\TollPlazamain\\files\\empCategory.txt");
                                  FileOutputStream fos = new FileOutputStream(myFile);
                                  Writer wr = new FileWriter(myFile);
                                  wr.append(Integer.toString(empFedDisc) + "\n" + empFedStr);
                                  fos.close();
                                  wr.close();
                                  dFrame.dispose();
                                  dm.generateForm();
                              }catch (IOException et) {
                                  et.printStackTrace();
                              }
	                }
	                
	                else if(empArmed.isSelected())
		                {
		              	  String empArmedStr = empArmed.getActionCommand().toString();
		  	              int empArmedDisc = 15;
		  	              
		  	              File myFile = new File("D:\\TollPlazamain\\files\\empCategory.txt");
		                    try {

		                  	  
		                    	String info = "Category: " + empArmed.getText() + ", Rate Rs. "  + empArmedDisc + "\n" ;
		                        
		                    	  try {
		                    		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
		                    				  info.getBytes(), StandardOpenOption.APPEND);
		                    	  }catch (IOException et) {
		                    	      et.printStackTrace();
		                    	  }
		                  	  
		                    	myFile=new File("D:\\TollPlazamain\\files\\empCategory.txt");
		                    	FileOutputStream fos = new FileOutputStream(myFile);
		                    	Writer wr = new FileWriter(myFile);
		                    	wr.append(new Integer(empArmedDisc).toString() + "\n" + empArmedStr);
		                      fos.close();
		                      wr.close();
		                      dFrame.dispose();
		                      dm.generateForm();
		                      
		                    } catch (FileNotFoundException ex) {
		                        Logger.getLogger(Vehicle_category.class.getName()).log(Level.SEVERE, null, ex);
		                    } catch (IOException ex) {
		                        Logger.getLogger(Vehicle_category.class.getName()).log(Level.SEVERE, null, ex);
		                    }
		                }
	                
	                else if(none.isSelected())
	                {
	              	  String noneStr = "Other";
	  	              int noneDisc = 0;
	  	              
	  	              File myFile = new File("D:\\TollPlazamain\\files\\empCategory.txt");
	                    try {
	                  	  
	                    	String info = "Category: " + none.getText() + ", Rate Rs. " + noneDisc + "\n" ;
	                        
	                    	  try {
	                    		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
	                    				  info.getBytes(), StandardOpenOption.APPEND);
	                    	  } catch (IOException et) {
	                    	      et.printStackTrace();
	                    	  }
	                  	  
	                    	myFile=new File("D:\\TollPlazamain\\files\\empCategory.txt");
	                    	FileOutputStream fos = new FileOutputStream(myFile);
	                    	Writer wr = new FileWriter(myFile);
	                    	wr.append(new Integer(noneDisc).toString() + "\n" + noneStr);
		                      fos.close();
		                      wr.close();
		                      dFrame.dispose();
		                      dm.generateForm();
	                      
	                    } catch (FileNotFoundException ex) {
	                        Logger.getLogger(Vehicle_category.class.getName()).log(Level.SEVERE, null, ex);
	                    } catch (IOException ex) {
	                        Logger.getLogger(Vehicle_category.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                     
	                }
	          	  	
		            }
	            	
	            	}
	   });
	   
	   
	}
}