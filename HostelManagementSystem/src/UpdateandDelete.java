import java.awt.Color;

import java.sql.*;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UpdateandDelete extends JFrame {

    private JPanel contentPane4;
private  DefaultTableModel tableModel;
    private JTextField txf21;
    private JTextField txf23;
    private JTextField txf24;
    private JTextField txf25;
    private JTextField txf26;
    private JTextField txf27;
    private JTextField txf28;
    private JTextField txf29;
    private JTextField txf30;
    private JCheckBox chckbx2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UpdateandDelete frame = new UpdateandDelete();
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

    public UpdateandDelete() {
        setUndecorated(true); // Undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 550);
        
        contentPane4 = new JPanel();
        contentPane4.setBackground(new Color(255, 182, 193)); // Light pink background color
        setContentPane(contentPane4);
        contentPane4.setLayout(null);
        
        String path7 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png"; //  button image path
        ImageIcon icon7 = new ImageIcon(path7);
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn7.setBounds(590, 5, 90, 41); // position and size
        btn7.setIcon(icon7);
        contentPane4.add(btn7);
        
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ManageRoom window
            }
        });
        
        JLabel lbl20 = new JLabel("UPDATE & DELETE FORM "); // Use JLabel instead of JButton for label
        lbl20.setFont(new Font("Algerian", Font.BOLD, 20));
        lbl20.setBounds(200, 40, 250, 41); // position and size
        contentPane4.add(lbl20);

        JLabel lbl21 = new JLabel("Unique ID "); // Use JLabel instead of JButton for label
        lbl21.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl21.setBounds(30, 80, 320, 41); // position and size
        contentPane4.add(lbl21);
        
        txf21 = new JTextField();
        txf21.setBounds(180, 90, 200, 19);
        contentPane4.add(txf21);
        txf21.setColumns(10);
        
        String path22 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\search.png"; //  button image path
        ImageIcon icon22 = new ImageIcon(path22);
        JButton btn22 = new JButton("Search");
        btn22.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn22.setBounds(420, 80, 110, 31); // position and size
        btn22.setIcon(icon22);
        contentPane4.add(btn22);
        btn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
					 int uid = Integer.parseInt(txf21.getText());
					  pst =con.prepareStatement("select * from newstudent where Unique_ID=?");
					  pst.setInt(1,uid);
					  rs=pst.executeQuery();
					  if(rs.next())
					  {
						  txf23.setText(rs.getString("Name"));
						  txf24.setText(rs.getString("Father_Name"));
						  txf25.setText(rs.getString("Mother_Name"));
						txf26.setText(String.format("%s", rs.getInt("Telephone_Number")));
						txf27.setText(rs.getString("Email"));
						txf28.setText(rs.getString("Permenant_Address"));
						txf29.setText(rs.getString("University_Name"));
						txf30.setText(rs.getString("Room_Number"));
						comboBox.setSelectedItem(rs.getString("Living_Status"));
						
						  
					  }
					  else {
						  JOptionPane.showMessageDialog(null, "No record found with the specified Unique ID.");
					  }
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			
                 
            	
            }
        });

        

        JLabel lbl23 = new JLabel("Name "); // Use JLabel instead of JButton for label
        lbl23.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl23.setBounds(30, 120, 320, 41); // position and size
        contentPane4.add(lbl23);
        
        txf23 = new JTextField();
        txf23.setBounds(180, 130, 200, 19);
        contentPane4.add(txf23);
        txf23.setColumns(10);
        
        JLabel lbl24 = new JLabel("Father Name ");
        lbl24.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl24.setBounds(30, 160, 320, 41);
        contentPane4.add(lbl24);
        
        txf24 = new JTextField();
        txf24.setBounds(180, 170, 200, 19);
        contentPane4.add(txf24);
        txf24.setColumns(10);
        

        JLabel lbl25 = new JLabel("Mother Name ");
        lbl25.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl25.setBounds(30, 200, 320, 41);
        contentPane4.add(lbl25);
        
        txf25 = new JTextField();
        txf25.setBounds(180, 210, 200, 19);
        contentPane4.add(txf25);
        txf25.setColumns(10);
        

        JLabel lbl26 = new JLabel("Telephone Number"); // Use JLabel instead of JButton for label
        lbl26.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl26.setBounds(30, 240, 320, 41); // position and size
        contentPane4.add(lbl26);
        
        txf26 = new JTextField();
        txf26.setBounds(180, 250, 200, 19);
        contentPane4.add(txf26);
        txf26.setColumns(10);
        

        JLabel lbl27 = new JLabel("Email "); // Use JLabel instead of JButton for label
        lbl27.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl27.setBounds(30, 280, 320, 41); // position and size
        contentPane4.add(lbl27);
        
        txf27 = new JTextField();
        txf27.setBounds(180, 290, 200, 19);
        contentPane4.add(txf27);
        txf27.setColumns(10);
        

        JLabel lbl28 = new JLabel("Permenant Address"); // Use JLabel instead of JButton for label
        lbl28.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl28.setBounds(30, 320, 320, 41); // position and size
        contentPane4.add(lbl28);
        
        txf28 = new JTextField();
        txf28.setBounds(180, 330, 200, 19);
        contentPane4.add(txf28);
        txf28.setColumns(10);
        

        JLabel lbl29 = new JLabel("University Name "); // Use JLabel instead of JButton for label
        lbl29.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl29.setBounds(30, 360, 320, 41); // position and size
        contentPane4.add(lbl29);
        
        txf29 = new JTextField();
        txf29.setBounds(180, 370, 200, 19);
        contentPane4.add(txf29);
        txf29.setColumns(10);
        

        JLabel lbl30 = new JLabel("Room Number "); // Use JLabel instead of JButton for label
        lbl30.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl30.setBounds(30, 400, 360, 41); // position and size
        contentPane4.add(lbl30);
        
        txf30 = new JTextField();
        txf30.setBounds(180, 410, 200, 19);
        contentPane4.add(txf30);
        txf30.setColumns(10);
        
        JLabel lbl31 = new JLabel("Living Status ");
        lbl31.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl31.setBounds(30, 440, 360, 41); // position and size
        contentPane4.add(lbl31);

        
     // Inside your constructor
        comboBox = new JComboBox();
        comboBox.addItem("");
        comboBox.addItem("Yes");
        comboBox.addItem("No");
        comboBox.setBounds(180, 450, 200, 19); // Adjust the position and size as needed
        contentPane4.add(comboBox);


        String path30 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\20.png"; //  button image path
        ImageIcon icon30 = new ImageIcon(path30);
        JButton btn30 = new JButton("Update");
        btn30.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn30.setBounds(200, 510, 110, 31); // position and size
        btn30.setIcon(icon30);
        contentPane4.add(btn30);
        
        btn30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "");
                    
                    int uid = Integer.parseInt(txf21.getText());
                    String name = txf23.getText();
                    String fatherName = txf24.getText();
                    String motherName = txf25.getText();
                    int telephoneNumber = Integer.parseInt(txf26.getText());
                    String email = txf27.getText();
                    String permanentAddress = txf28.getText();
                    String universityName = txf29.getText();
                    String roomNumber = txf30.getText();
                    String status = (String) comboBox.getSelectedItem();

                    pst = con.prepareStatement("UPDATE newstudent SET Name=?, Father_Name=?, Mother_Name=?, Telephone_Number=?, Email=?, Permenant_Address=?, University_Name=?, Room_Number=? , Living_Status=? WHERE Unique_ID=?");
                    
                    pst.setString(1, name);
                    pst.setString(2, fatherName);
                    pst.setString(3, motherName);
                    pst.setInt(4, telephoneNumber);
                    pst.setString(5, email);
                    pst.setString(6, permanentAddress);
                    pst.setString(7, universityName);
                    pst.setString(8, roomNumber);  
                    
                    pst.setString(9, status); 
                    pst.setInt(10,uid);
                    
                    int rowsUpdated = pst.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update record.");
                    }
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        
        
        
        String path31 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\d1.png"; //  button image path
        ImageIcon icon31 = new ImageIcon(path31);
        JButton btn31 = new JButton("Delete");
        btn31.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn31.setBounds(350, 510, 110, 31); // position and size
        btn31.setIcon(icon31);
        contentPane4.add(btn31);
        
        btn31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "");
                    int uid = Integer.parseInt(txf21.getText());
                    pst = con.prepareStatement("DELETE FROM newstudent WHERE Unique_ID = ?");
                    pst.setInt(1, uid);
                    int rowsDeleted = pst.executeUpdate();
                    
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                        txf23.setText("");
                        txf24.setText("");
                        txf25.setText("");
                        txf26.setText("");
                        txf27.setText("");
                        txf28.setText("");
                        txf29.setText("");
                        txf30.setText("");
                        comboBox.setSelectedItem("");
                    } 
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        

        String path32 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\clear.png"; //  button image path
        ImageIcon icon32 = new ImageIcon(path32);
        JButton btn32 = new JButton("Clear");
        btn32.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn32.setBounds(500, 510, 110, 31); // position and size
        btn32.setIcon(icon32);
        contentPane4.add(btn32);
        
        btn32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txf23.setText("");
            	txf24.setText("");
            	txf25.setText("");
            	txf26.setText("");
            	txf27.setText("");
            	txf28.setText("");
            	txf29.setText("");
            	comboBox.setSelectedItem("");
                
            }
        });
        
    }
}
