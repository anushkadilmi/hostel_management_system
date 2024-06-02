import java.awt.Color;
import java.sql.*;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class StudentPayment extends JFrame {

    private JPanel contentPane5;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txf40;
    private JTextField txf42;
    private JTextField txf43;
    private JTextField txf44;
    private JTextField txf45;
    private JTextField txf46;
   

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	StudentPayment  frame = new StudentPayment ();
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
   
    
    public StudentPayment () {
        setUndecorated(true); // Undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 550);
        
        contentPane5 = new JPanel();
        contentPane5.setBackground(new Color(255, 182, 193)); // Light pink background color
        setContentPane(contentPane5);
        contentPane5.setLayout(null);
        
        String path7 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png"; //  button image path
        ImageIcon icon7 = new ImageIcon(path7);
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn7.setBounds(590, 5, 90, 41); // position and size
        btn7.setIcon(icon7);
        contentPane5.add(btn7);
        
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ManageRoom window
            }
        });
        
        JLabel lbl20 = new JLabel("STUDENT PAYMENT "); // Use JLabel instead of JButton for label
        lbl20.setFont(new Font("Algerian", Font.BOLD, 20));
        lbl20.setBounds(200, 40, 250, 41); // position and size
        contentPane5.add(lbl20);

        JLabel lbl40 = new JLabel("Unique ID "); // Use JLabel instead of JButton for label
        lbl40.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl40.setBounds(30, 80, 320, 41); // position and size
        contentPane5.add(lbl40);
        
        txf40 = new JTextField();
        txf40.setBounds(180, 90, 200, 19);
        contentPane5.add(txf40);
        txf40.setColumns(10);
        
        String path41 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\search.png"; //  button image path
        ImageIcon icon41 = new ImageIcon(path41);
        JButton btn41 = new JButton("Search");
        btn41.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn41.setBounds(420, 80, 110, 31); // position and size
        btn41.setIcon(icon41);
        contentPane5.add(btn41);
        
        btn41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
					 int uid = Integer.parseInt(txf40.getText());
					  pst =con.prepareStatement("select * from newstudent where Unique_ID=?");
					  pst.setInt(1,uid);
					  rs=pst.executeQuery();
					  if(rs.next())
					  {
						  txf42.setText(rs.getString("Name"));
						txf43.setText(rs.getString("Email"));
						txf44.setText(rs.getString("Room_Number"));
						
						  
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
        
       
        
        JLabel lbl42 = new JLabel("Name "); // Use JLabel instead of JButton for label
        lbl42.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl42.setBounds(30, 120, 320, 41); // position and size
        contentPane5.add(lbl42);
        
        txf42 = new JTextField();
        txf42.setBounds(180, 130, 200, 19);
        contentPane5.add(txf42);
        txf42.setColumns(10);
        
        JLabel lbl43 = new JLabel("Email ");
        lbl43.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl43.setBounds(30, 160, 320, 41);
        contentPane5.add(lbl43);
        
        txf43 = new JTextField();
        txf43.setBounds(180, 170, 200, 19);
        contentPane5.add(txf43);
        txf43.setColumns(10);
        

        JLabel lbl44 = new JLabel("Room Number ");
        lbl44.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl44.setBounds(30, 200, 320, 41);
        contentPane5.add(lbl44);
        
        txf44 = new JTextField();
        txf44.setBounds(180, 210, 200, 19);
        contentPane5.add(txf44);
        txf44.setColumns(10);
        

        JLabel lbl45 = new JLabel("Month"); // Use JLabel instead of JButton for label
        lbl45.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl45.setBounds(30, 240, 320, 41); // position and size
        contentPane5.add(lbl45);
        
        txf45 = new JTextField();
        txf45.setBounds(180, 250, 200, 19);
        contentPane5.add(txf45);
        txf45.setColumns(10);
        

        JLabel lbl46 = new JLabel("Amount to be pay "); // Use JLabel instead of JButton for label
        lbl46.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbl46.setBounds(30, 280, 320, 41); // position and size
        contentPane5.add(lbl46);
        
        txf46 = new JTextField();
        txf46.setBounds(180, 290, 200, 19);
        contentPane5.add(txf46);
        txf46.setColumns(10);
    
        String path47 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\save.png"; //  button image path
        ImageIcon icon47 = new ImageIcon(path47);
        JButton btn47 = new JButton("Save");
        btn47.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn47.setBounds(350, 330, 110, 31); // position and size
        btn47.setIcon(icon47);
        contentPane5.add(btn47);
       
        btn47.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "");
                    int uid = Integer.parseInt(txf40.getText());
                    String name = txf42.getText();
                    String email = txf43.getText();
                    String room = txf44.getText();
                    int month = Integer.parseInt(txf45.getText());
                    int amount = Integer.parseInt(txf46.getText());

                    String sql = "INSERT INTO psyment (Unique_ID, Name, Email, Room_Number, Month, Amount) VALUES (?, ?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(sql);
                    pst.setInt(1, uid);
                    pst.setString(2, name);
                    pst.setString(3, email);
                    pst.setString(4, room);
                    pst.setInt(5, month);
                    pst.setInt(6, amount);

                    int i = pst.executeUpdate();
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "Data added successfully");
                        // After saving, update the table with the new data
                        updateTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data couldn't be added successfully");
                    }
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        
        
        
        
        String path48 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\clear.png"; //  button image path
        ImageIcon icon48 = new ImageIcon(path48);
        JButton btn48 = new JButton("Clear");
        btn48.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn48.setBounds(550, 330, 110, 31); // position and size
        btn48.setIcon(icon48);
        contentPane5.add(btn48);
        
        btn48.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txf42.setText("");
            	txf43.setText("");
            	txf44.setText("");
            	txf45.setText("");
            	txf46.setText("");
          
                
            }
        });
        
        
        
        
        String path49 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\989.png"; //  button image path
        ImageIcon icon49 = new ImageIcon(path49);
        JButton btn49 = new JButton("Recipt");
        btn49.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn49.setBounds(150, 330, 110, 31); // position and size
        btn49.setIcon(icon49);
        contentPane5.add(btn49);
        
        JLabel lbl49= new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------"); // Use JLabel instead of JButton for label
        lbl49.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lbl49.setBounds(10, 350, 700, 41); // position and size
        contentPane5.add(lbl49);
   
        // Create a table with a default table model
        tableModel = new DefaultTableModel();

        // Define table columns and add them to the model
        tableModel.addColumn("Unique_ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Room_Number");
        tableModel.addColumn("Month");
        tableModel.addColumn("Amount");
        

        // Create the table with the model
        table = new JTable(tableModel);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 390, 680, 150); // position and size for the table
        contentPane5.add(scrollPane);

        // Add some sample data
        addSampleData();
    }

    private void addSampleData() {
        // Add sample rows to the table
        tableModel.addRow(new Object[]{"", "", ""});
        tableModel.addRow(new Object[]{"","",""});
     
    
    }
    private void updateTable() {
        try {
            // Clear the existing data in the table
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }

            // Fetch data from the database and add it to the table
            String sql = "SELECT * FROM psyment";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] rowData = {
                        rs.getInt("Unique_ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Room_Number"),
                        rs.getInt("Month"),
                        rs.getInt("Amount")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    }

    

    
