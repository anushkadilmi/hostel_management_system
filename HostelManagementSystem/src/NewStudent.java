import java.awt.Color;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NewStudent extends JFrame {

    private JPanel contentPane3;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txf10;
    private JTextField txf11;
    private JTextField txf12;
    private JTextField txf13;
    private JTextField txf14;
    private JTextField txf15;
    private JTextField txf16;
    private JTextField txf17;
    private JCheckBox chckbx2;
    private JComboBox comboBox;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewStudent frame = new NewStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public NewStudent() {
        setUndecorated(true); // Undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 520);
        
        contentPane3 = new JPanel();
        contentPane3.setBackground(new Color(255, 182, 193)); // Light pink background color
        setContentPane(contentPane3);
        contentPane3.setLayout(null);
        
        String path7 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png"; //  button image path
        ImageIcon icon7 = new ImageIcon(path7);
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn7.setBounds(590, 5, 90, 41); // position and size
        btn7.setIcon(icon7);
        contentPane3.add(btn7);
        
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ManageRoom window
            }
        });
        
        JLabel lbl20 = new JLabel("REGISTRATION FORM "); // Use JLabel instead of JButton for label
        lbl20.setFont(new Font("Algerian", Font.BOLD, 20));
        lbl20.setBounds(200, 30, 250, 41); // position and size
        contentPane3.add(lbl20);

        JLabel lbl10 = new JLabel("Unique ID "); // Use JLabel instead of JButton for label
        lbl10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl10.setBounds(30, 70, 320, 41); // position and size
        contentPane3.add(lbl10);
        
        txf10 = new JTextField();
        txf10.setBounds(180, 80, 200, 19);
        contentPane3.add(txf10);
        txf10.setColumns(10);
        
        

        JLabel lbl12 = new JLabel("Name "); // Use JLabel instead of JButton for label
        lbl12.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl12.setBounds(30, 110, 320, 41); // position and size
        contentPane3.add(lbl12);
        
        txf11 = new JTextField();
        txf11.setBounds(180, 120, 200, 19);
        contentPane3.add(txf11);
        txf11.setColumns(10);
        

        JLabel lbl13 = new JLabel("Father Name "); // Use JLabel instead of JButton for label
        lbl13.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl13.setBounds(30, 150, 320, 41); // position and size
        contentPane3.add(lbl13);
        
        txf12 = new JTextField();
        txf12.setBounds(180, 160, 200, 19);
        contentPane3.add(txf12);
        txf12.setColumns(10);
        

        JLabel lbl14 = new JLabel("Mother Name "); // Use JLabel instead of JButton for label
        lbl14.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl14.setBounds(30, 190, 320, 41); // position and size
        contentPane3.add(lbl14);
        
        txf13 = new JTextField();
        txf13.setBounds(180, 200, 200, 19);
        contentPane3.add(txf13);
        txf13.setColumns(10);
        

        JLabel lbl15 = new JLabel("Telephone Number"); // Use JLabel instead of JButton for label
        lbl15.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl15.setBounds(30, 230, 320, 41); // position and size
        contentPane3.add(lbl15);
        
        txf14 = new JTextField();
        txf14.setBounds(180, 240, 200, 19);
        contentPane3.add(txf14);
        txf14.setColumns(10);
        

        JLabel lbl16 = new JLabel("Email "); // Use JLabel instead of JButton for label
        lbl16.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl16.setBounds(30, 270, 320, 41); // position and size
        contentPane3.add(lbl16);
        
        txf15 = new JTextField();
        txf15.setBounds(180, 280, 200, 19);
        contentPane3.add(txf15);
        txf15.setColumns(10);
        

        JLabel lbl17 = new JLabel("Permenant Address"); // Use JLabel instead of JButton for label
        lbl17.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl17.setBounds(30, 310, 320, 41); // position and size
        contentPane3.add(lbl17);
        
        txf16 = new JTextField();
        txf16.setBounds(180, 320, 200, 19);
        contentPane3.add(txf16);
        txf16.setColumns(10);
        

        JLabel lbl18 = new JLabel("University Name "); // Use JLabel instead of JButton for label
        lbl18.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl18.setBounds(30, 350, 320, 41); // position and size
        contentPane3.add(lbl18);
        
        txf17 = new JTextField();
        txf17.setBounds(180, 360, 200, 19);
        contentPane3.add(txf17);
        txf17.setColumns(10);
        

        JLabel lbl19 = new JLabel("Room Number "); // Use JLabel instead of JButton for label
        lbl19.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl19.setBounds(30, 390, 360, 41); // position and size
        contentPane3.add(lbl19);
        
     // Inside your constructor
        comboBox = new JComboBox();
        comboBox.addItem("");
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.setBounds(180, 400, 200, 19); // Adjust the position and size as needed
        contentPane3.add(comboBox);

        
        JLabel lbl80 = new JLabel("Living Status "); // Use JLabel instead of JButton for label
        lbl80.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl80.setBounds(30, 430, 360, 41); // position and size
        contentPane3.add(lbl80);
        
     // Inside your constructor
     // Inside your constructor
        comboBox1 = new JComboBox(); // Initialize comboBox1
        comboBox1.addItem("");
        comboBox1.addItem("Yes");
        comboBox1.addItem("No");

        comboBox1.setBounds(180, 440, 200, 19); // Adjust the position and size as needed
        contentPane3.add(comboBox1);

        
        
        
        String path20 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\save.png"; //  button image path
        ImageIcon icon20 = new ImageIcon(path20);
        JButton btn20 = new JButton("Save");
        btn20.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn20.setBounds(350, 480, 110, 31); // position and size
        btn20.setIcon(icon20);
        contentPane3.add(btn20);
        
        btn20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
        			
        			String name = txf11.getText();
        			String father_name = txf12.getText();
        			String mother_name = txf13.getText();
        			int tel = Integer.parseInt(txf14.getText());
        			String email = txf15.getText();
        			String address = txf16.getText();
        			String university= txf17.getText();
        			String  room = (String) comboBox.getSelectedItem();
        			String status = (String) comboBox1.getSelectedItem();
        			
        			if(name.trim().equals("")) // check the name 
        	         {
        	             JOptionPane.showMessageDialog(null, "Please enter a Name", "Error", JOptionPane.ERROR_MESSAGE);
        	             return;
        	         }
        			if(father_name.trim().equals("")) // check the name 
       	         {
       	             JOptionPane.showMessageDialog(null, "Please enter a Father Name", "Error", JOptionPane.ERROR_MESSAGE);
       	             return;
       	         }
        			if(mother_name.trim().equals("")) // check the name 
       	         {
       	             JOptionPane.showMessageDialog(null, "Please enter a  Mother Name", "Error", JOptionPane.ERROR_MESSAGE);
       	             return;
       	         }
       	          
       	          
        	          
        	          
        	          if(email.trim().equals("")) //check the email
        	          {
        	               JOptionPane.showMessageDialog(null, "Please enter a email", "Error", JOptionPane.ERROR_MESSAGE);
        	             return;
        	          }
        	          
        	          if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$",txf15.getText()))) //check the email
        	{
        	            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
        	            return;
        	            }
        	          if(address.trim().equals("")) // check the name 
         	         {
         	             JOptionPane.showMessageDialog(null, "Please enter a Address", "Error", JOptionPane.ERROR_MESSAGE);
         	             return;
         	         }
        	          
        	          if(university.trim().equals("")) // check the name 
         	         {
         	             JOptionPane.showMessageDialog(null, "Please enter a University", "Error", JOptionPane.ERROR_MESSAGE);
         	             return;
         	         }
        	          if(room.trim().equals("")) // check the name 
         	         {
         	             JOptionPane.showMessageDialog(null, "Please Select a Room Number", "Error", JOptionPane.ERROR_MESSAGE);
         	             return;
         	         }
        			
        			 String sql = "insert into newstudent(Name ,Father_Name, Mother_Name,Telephone_Number,Email,Permenant_Address,University_Name,Room_Number,Living_Status) values(?,?,?,?,?,?,?,?,?)";
        			 pst=con.prepareStatement(sql);
        			 pst.setString(1, name);
        			 pst.setString(2, father_name);
        			 pst.setString(3, mother_name);
        			 pst.setInt(4, tel);
        			 pst.setString(5, email);
        			 pst.setString(6, address);
        			 pst.setString(7, university);
        			 pst.setString(8, room);
        			pst.setString(9, status);
        			 
        			 int i =pst.executeUpdate();
        			 if(i==1)
        			 {
        				   JOptionPane.showMessageDialog(null, "data added successfully");
        			 }
        			 else
        			 {
        				 JOptionPane.showMessageDialog(null, "data can't be Added");
        			 }
        			 
        			 
        			 
        			 

        		} catch (ClassNotFoundException x) {
        			// TODO Auto-generated catch block
        			x.printStackTrace();
        		} catch (SQLException ex) {
        			// TODO Auto-generated catch block
        			ex.printStackTrace();
        		}
            	catch(NumberFormatException ex)
            	{
            		JOptionPane.showMessageDialog(null, "Please enter a telephone number", "Error", JOptionPane.ERROR_MESSAGE);
    	             
            	}
            	
            }
        });
        
        
        



        String path21 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\clear.png"; //  button image path
        ImageIcon icon21 = new ImageIcon(path21);
        JButton btn21 = new JButton("Clear");
        btn21.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn21.setBounds(500, 480, 110, 31); // position and size
        btn21.setIcon(icon21);
        contentPane3.add(btn21);
        btn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txf11.setText("");
            	txf12.setText("");
            	txf13.setText("");
            	txf14.setText("");
            	txf15.setText("");
            	txf16.setText("");
            	txf17.setText("");
            	comboBox.setSelectedItem("");
            	comboBox1.setSelectedItem("");
                
            }
        });

        
        
    }
}
