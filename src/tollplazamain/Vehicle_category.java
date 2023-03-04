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
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.*;

public class Vehicle_category{
	
	public static JFrame vCFrame;
	public static JLabel iconLabel,label, vCLabel,showsucc;
	public static JButton submitButton;
	public static JRadioButton truckButton, carButton, busButton, ddeckerButton;
	public static ButtonGroup buttonGroup;
	File myFile;

	public void vCategoryClass() throws IOException{
		//icons and images
		ImageIcon img = new ImageIcon("images/toll.png");
                Icon icon = new ImageIcon("images/check.png");
                Icon icon2 = new ImageIcon("images/delivery.png");
    	
    	//object for next class
                Discount dc = new Discount();
    	
    	//frame
            vCFrame = new JFrame();
	    vCFrame.setSize(500,450);
	    vCFrame.setLayout(null);
	    vCFrame.setTitle("Toll Plaza Managment");
	    vCFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    vCFrame.setResizable(false);
	    vCFrame.setIconImage(img.getImage());
	    vCFrame.getContentPane().setBackground( new Color(0x214252));
	    
	    //labels
	    iconLabel = new JLabel(icon2);
            iconLabel.setBounds(50, 35, 64, 64);
            vCFrame.add(iconLabel);
        
            vCLabel = new JLabel("Vehicle Category");
            vCLabel.setFont(new Font("Century Gothic",Font.BOLD, 20));
            vCLabel.setForeground(Color.WHITE);
            vCLabel.setBounds(135, 20, 200, 100);
            vCFrame.add(vCLabel);
	    
	    label = new JLabel("Select the car category");
	    label.setFont(new Font("Calibri",Font.BOLD, 16));
	    label.setForeground(Color.WHITE);
	    label.setBounds(105, 125, 200, 30);
	        
	    //circular buttons
	    truckButton = new JRadioButton("Truck");
	    truckButton.setOpaque(false);
	    truckButton.setFocusable(false);
	    truckButton.setForeground(Color.WHITE);
	    
	    carButton = new JRadioButton("Car");
	    carButton.setOpaque(false);
	    carButton.setFocusable(false);
	    carButton.setForeground(Color.WHITE);
	    
	    busButton = new JRadioButton("Bus");
	    busButton.setOpaque(false);
	    busButton.setFocusable(false);
	    busButton.setForeground(Color.WHITE);
	    
	    ddeckerButton = new JRadioButton("Double Decker");
	    ddeckerButton.setOpaque(false);
	    ddeckerButton.setFocusable(false);
	    ddeckerButton.setForeground(Color.WHITE);
	    
	    //Setting up, so that the user selects ONLY ONE category for customer
	    buttonGroup = new ButtonGroup();
	    buttonGroup.add(truckButton);
	    buttonGroup.add(carButton);
	    buttonGroup.add(busButton);
	    buttonGroup.add(ddeckerButton);
	    
	    //buttons
	    submitButton = new JButton(icon);
            submitButton.setText("Submit");
            submitButton.setBounds(195 ,280 ,100 ,35);
            submitButton.setFocusable(false);
            vCFrame.add(submitButton);
	    
        //setting up circular buttons
	    truckButton.setBounds(100,150,100,30);   
	    carButton.setBounds(100,180,100,30); 
	    busButton.setBounds(100,210,100,30); 
	    ddeckerButton.setBounds(100,240,150,30); 
	    
	    //adding them to frame
	    vCFrame.add(label);
	    vCFrame.add(truckButton);
	    vCFrame.add(carButton);
	    vCFrame.add(busButton);
	    vCFrame.add(ddeckerButton);
	    vCFrame.add(submitButton);
	    vCFrame.setVisible(true);
            vCFrame.setLocation(700,240);
	    
	    //actions for buttons
	    submitButton.addActionListener(new ActionListener(){
                
          public void actionPerformed(ActionEvent ae)
          {
              showsucc = new JLabel();
        	  
        	  if(!(truckButton.isSelected() || carButton.isSelected() || busButton.isSelected()
        			  || ddeckerButton.isSelected())) {
              	JOptionPane.showMessageDialog(null ,"Please select any one field");
          		}
        	  else {
	        	  if(truckButton.isSelected())
	              {
	            	  String truckStr = "Truck";
		              int truckRate = 100;

		              
		              
                              String info = "Category: " + truckButton.getText() + " Rs." + truckRate + "\n" ;
                              try {
                                  FileWriter fw = new FileWriter("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt");
//	                  		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
//	                  				  info.getBytes(), StandardOpenOption.APPEND);
                                fw.write(info);
                                myFile=new File("D:\\TollPlazamain\\files\\vCategory1.txt");
                                FileWriter wr = new FileWriter(myFile);
                                wr.append(Integer.toString(truckRate) + "\n" + truckStr);
                                wr.close();
                                vCFrame.dispose();
                                dc.discountClass();
                              }
                              catch (IOException et) {
                                  et.printStackTrace();
                              }
	              }
	              
	              else if(carButton.isSelected())
	              {
	            	  String carStr ="Car";
		              int carRate = 50;
	                  try {
	                	  
	                    	String info =  "Category: " + carButton.getText() + " Rs. " + carRate + "\n";
	                    		  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
	                    				  info.getBytes(), StandardOpenOption.APPEND);
	                    	myFile=new File("D:\\TollPlazamain\\files\\vCategory1.txt");
	                        Writer wr = new FileWriter(myFile);
	                        wr.append(new Integer(carRate).toString() + "\n" + carStr);
	                        wr.close();
	                        vCFrame.dispose();
	                        dc.discountClass();  
                                  } 
                          catch (IOException ex) {
                                  Logger.getLogger(Vehicle_category.class.getName()).log(Level.SEVERE, null, ex);
                              }
	              }
	              
	              else if(busButton.isSelected())
	              {
	            	  String busStr = "Bus";
		              int busRate = 80;
		              
		              
                              String info = "Category: " + busButton.getText() + "Rs. " + busRate + "\n";
                              try {
                                  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
                                          info.getBytes(), StandardOpenOption.APPEND);
                                  
                                  
                                  myFile=new File("D:\\TollPlazamain\\files\\vCategory1.txt");
                                  Writer wr = new FileWriter(myFile);
                                  wr.append(new Integer(busRate).toString() + "\n" + busStr);
                                  
                                  wr.close();
                                  vCFrame.dispose();
                                  dc.discountClass();
                              }catch (IOException et) {
                                  et.printStackTrace();
                              }
	              }
	              
	              else if(ddeckerButton.isSelected())
	              {
	            	  String ddeckerStr = "DoubleDecker";
		              int ddeckerRate = 200;
		              
		              
                              String info = "Category: " + ddeckerButton.getText() + ",Rate Rs. " + ddeckerRate + "\n";
                              try {
                                  Files.write(Paths.get("D:\\TollPlazamain\\files\\CustomerInfo-DB.txt"),
                                          info.getBytes(), StandardOpenOption.APPEND);
                                  
                                  
                                  
                                  myFile=new File("D:\\TollPlazamain\\files\\vCategory1.txt");
                                  
                                  Writer wr = new FileWriter(myFile);
                                  wr.append(new Integer(ddeckerRate).toString() + "\n" + ddeckerStr);
                                  wr.close();
                                  vCFrame.dispose();
                                  dc.discountClass();
                              }catch (IOException et) {
                                  et.printStackTrace();
                              }
	              }
 
          }
          }
         
      });

	}
}
