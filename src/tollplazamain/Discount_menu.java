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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Discount_menu {
	
	public static JFrame formFrame;
	public static JTextArea areaText;
	public static JLabel label, totalPrice, discountRate, netPayable, saving, cashRecieved, changeAmount;
	public static JTextField displayPrice, displayDiscount, displayNetPayable, displaySaving, displaycashRecieved, displaychangeAmount;
	public static JButton submitButton, clearAll, generateSlip, printSlip, exitButton, logout;
	public static SimpleDateFormat timeFormat, dateFormat;
	public static File file1;
	
	public void generateForm() throws FileNotFoundException {
		
		//Icons and images
		ImageIcon img = new ImageIcon("images/toll.png");
		ImageIcon icon = new ImageIcon("images/check.png");
		
		
		//Files scanning
		file1 = new File("D:\\TollPlazamain\\files\\empCategory.txt");
		Scanner empCategory = new Scanner(file1);
		File file2 = new File("D:\\TollPlazamain\\files\\vDetails.txt");
		Scanner vehicleDetails = new Scanner(file2);
		File file3 = new File("D:\\TollPlazamain\\files\\vCategory1.txt");
		Scanner vehicleRate = new Scanner(file3);
		File file4 = new File("D:\\TollPlazamain\\files\\Operator.txt");
		Scanner operator = new Scanner(file4);
		File file5 = new File("D:\\TollPlazamain\\files\\CurrentCustomer.txt");
		Scanner currentCustomer = new Scanner(file5);
		
		

                //Date and time
//                Time time = new Time();
		Date date = new Date();
		timeFormat = new SimpleDateFormat("h:mm:ss a");
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String currentTime = timeFormat.format(date).toString();
		String currentDate = dateFormat.format(date).toString();
		
		
		//Calculations
		String actualamount = vehicleRate.nextLine(); //actual amount
		double actualamountD = Double.valueOf(actualamount);
		String rateDiscount = empCategory.nextLine();		//discount on employee category
		double rateDiscountD = Double.valueOf(rateDiscount);
		double disc = actualamountD * rateDiscountD/100;
		double toPay = actualamountD - disc;
		double savings = actualamountD - toPay;
		
		
		//Frame
		formFrame = new JFrame();
		formFrame.setSize(1000,630);
		formFrame.setLayout(null);
	    formFrame.setTitle("Toll Plaza Managment");
	    formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    formFrame.setResizable(false);
	    formFrame.setIconImage(img.getImage());
	    formFrame.getContentPane().setBackground( new Color(0x214252));
	    
	    
	    //TextArea for slip
	    areaText = new JTextArea();
		areaText.setFont(new Font(null, Font.BOLD, 12));
		areaText.setEditable(false);
		areaText.setBounds(439, 11, 535, 569);
		formFrame.add(areaText);
	    
		
		//Labels for text and stuff
		label = new JLabel("Slip Generation Form");
	    label.setFont(new Font("Century Gothic",Font.BOLD, 20));
	    label.setForeground(Color.WHITE);
	    label.setBounds(130, 35, 250, 40);
	    formFrame.add(label);

	    totalPrice = new JLabel("Actual Price");
		totalPrice.setFont(new Font(null, Font.BOLD, 14));
		totalPrice.setBounds(50 , 50 ,100,100);
		totalPrice.setForeground(Color.WHITE);
		formFrame.add(totalPrice);
		
		discountRate= new JLabel("Discout Rate");
		discountRate.setFont(new Font(null, Font.BOLD, 14));
		discountRate.setBounds(50 , 100 ,100,100);
		discountRate.setForeground(Color.WHITE);
		formFrame.add(discountRate);
			
		netPayable = new JLabel("Net Payable");
		netPayable.setFont(new Font(null, Font.BOLD, 14));
		netPayable.setBounds(50 , 150 ,100,100);
		netPayable.setForeground(Color.WHITE);
		formFrame.add(netPayable);
		
		saving = new JLabel("You saved");
		saving.setFont(new Font(null, Font.BOLD, 14));
		saving.setBounds(50 , 200 ,100,100);
		saving.setForeground(Color.WHITE);
		formFrame.add(saving);
		
		cashRecieved = new JLabel("Cash Recieved");
		cashRecieved.setFont(new Font(null, Font.BOLD, 14));
		cashRecieved.setBounds(50 , 280 ,120,35);
		cashRecieved.setForeground(Color.WHITE);
		formFrame.add(cashRecieved);
		
		changeAmount = new JLabel("Change");
		changeAmount.setFont(new Font(null, Font.BOLD, 14));
		changeAmount.setBounds(50 , 325 ,150,35);
		changeAmount.setForeground(Color.WHITE);
		formFrame.add(changeAmount);
		
		
		//Text fields for entering and displaying data
		displayPrice = new JTextField();
		displayPrice.setEditable(false);
		displayPrice.setText(" Rs. " + actualamount);
		displayPrice.setFont(new Font(null, Font.BOLD, 14));
		displayPrice.setBounds(170,90,235,25);
		formFrame.add(displayPrice);

		displayDiscount = new JTextField();
		displayDiscount.setEditable(false);
		displayDiscount.setText(" " + rateDiscountD + "%");
		displayDiscount.setFont(new Font(null, Font.BOLD, 14));
		displayDiscount.setBounds(170,140,235,25);
		formFrame.add(displayDiscount);

		displayNetPayable = new JTextField();
		displayNetPayable.setEditable(false);
		displayNetPayable.setText(" Rs. " + toPay);
		displayNetPayable.setFont(new Font(null, Font.BOLD, 14));
		displayNetPayable.setBounds(170,190,235,25);
		formFrame.add(displayNetPayable);

		displaySaving = new JTextField();
		displaySaving.setEditable(false);
		displaySaving.setText(" Rs. " + String.format("%.2f", savings));
		if (savings > 0) {
			displaySaving.setForeground(new Color(0x2ec4b6));
		}
		else {
			displaySaving.setForeground(new Color(0xd62828));
		}
		displaySaving.setFont(new Font(null, Font.BOLD, 14));
		displaySaving.setBounds(170,240,235,25);
		formFrame.add(displaySaving);

		displaycashRecieved = new JTextField();
		displaycashRecieved.setFont(new Font(null, Font.BOLD, 14));
		displaycashRecieved.setBounds(170,285,235,25);
		formFrame.add(displaycashRecieved);

		displaychangeAmount = new JTextField();
		displaychangeAmount.setEditable(false);
		displaychangeAmount.setFont(new Font(null, Font.BOLD, 14));
		displaychangeAmount.setBounds(170,330,235,25);
		formFrame.add(displaychangeAmount);
		
		
		//Buttons that do certain actions
		submitButton = new JButton(icon);
        submitButton.setText("Calculate");
        submitButton.setBounds(90 ,375 ,130 ,35);
        submitButton.setFocusable(false);
        submitButton.setBackground(new Color(0x2ec4b6));
        formFrame.add(submitButton);
        
       
        generateSlip = new JButton(icon);
        generateSlip.setText("Generate Slip");
        generateSlip.setBounds(260 ,375 ,130 ,35);
        generateSlip.setFocusable(false);
        formFrame.add(generateSlip);

        
        exitButton = new JButton(icon);
        exitButton.setText("Exit");
        exitButton.setBounds(90 ,435 ,130 ,35);
        exitButton.setFocusable(false);
        formFrame.add(exitButton);
        
        
        logout = new JButton(icon);
        logout.setText("Logout");
        logout.setBounds(260 ,435 ,130 ,35);
        logout.setFocusable(false);
        logout.setBackground(new Color(0x2ec4b6));
        formFrame.add(logout);
        
        printSlip = new JButton(icon);
        printSlip.setText("Print Slip");
        printSlip.setBounds(180 ,480 ,130 ,35);
        printSlip.setFocusable(false);
        formFrame.add(printSlip);
        
        
        //Actions for certain buttons
        submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((displaycashRecieved.getText().isEmpty())) {
                	JOptionPane.showMessageDialog(null ,"Please enter recieved text field");
            	} 
				else {
				String cashR = displaycashRecieved.getText();
				double dcashR = Double.parseDouble(cashR);
				double displayChange = dcashR - toPay;
				displaychangeAmount.setText(" Rs. " + String.format("%.2f", displayChange));
				submitButton.setEnabled(false);
			}
			}
		});
  
        generateSlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((displaycashRecieved.getText().isEmpty())) {
                	JOptionPane.showMessageDialog(null ,"Please enter recieved text field");
            	} 
				else{
//                                    Reference on line 87
            	areaText.setText("");
				areaText.setText(areaText.getText() + "     ________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     _________________________TOLL PLAZA MANAGEMENT_________________________\n");
				areaText.setText(areaText.getText() + "     ________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     Date: \t" + currentDate + "\t\t\n");
				areaText.setText(areaText.getText() + "     Time: \t" + currentTime + "\t\tOperator: " + operator.nextLine() + "\n");
				areaText.setText(areaText.getText() + "     ________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     ___________________________CUSTOMER DETAILS____________________________\n");
				areaText.setText(areaText.getText() + "     Name: \t" + currentCustomer.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     CNIC: \t" + currentCustomer.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     Phone: \t" + currentCustomer.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     Category: \t" + empCategory.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     ________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     ____________________________VEHICLE DETAILS______________________________\n");
				areaText.setText(areaText.getText() + "     Name: \t" + vehicleDetails.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     Number: \t" + vehicleDetails.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     Model: \t" + vehicleDetails.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     Category: \t" + vehicleRate.nextLine() + "           \n");
				areaText.setText(areaText.getText() + "     ________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     _____________________________BILLING DETAILS______________________________\n");
				areaText.setText(areaText.getText() + "     Total Amount: \t\t" + displayPrice.getText() + "           \n");
				areaText.setText(areaText.getText() + "     Discounted Amount: \t" + displayNetPayable.getText() + "           \n");
				areaText.setText(areaText.getText() + "     Amount Recieved:  \t " + "Rs." + displaycashRecieved.getText() + "           \n");
				areaText.setText(areaText.getText() + "     Change: \t\t" + displaychangeAmount.getText() + "           \n");
				areaText.setText(areaText.getText() + "     You saved: \t\t" + displaySaving.getText() + "           \n");
				areaText.setText(areaText.getText() + "     _________________________________________________________________________\n");
				areaText.setText(areaText.getText() + "     ___________________________THANKS FOR VISITING____________________________\n");
				areaText.setText(areaText.getText() + "     __________________________HAVE A GOOD JOURNEY!!___________________________\n");
				generateSlip.setEnabled(false);
				}
			}
		});
        

        
        logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formFrame.dispose();
				
				JOptionPane.showMessageDialog(null ,"Loging you out...");
				
				login lg = new login();
				lg.login();
			}
		});
        
        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(null ,"System exiting");
                                JOptionPane.showMessageDialog(areaText, "Syatem Existing");
				System.exit(0);
			}
		});
        printSlip.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					areaText.print();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null ,"Error occured");
				}
			}
		});
        
        
        //Setting frame visibility to TRUE
        formFrame.setVisible(true);
        formFrame.setLocation(500,240);
	}
}