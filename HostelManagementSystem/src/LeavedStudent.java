
import java.awt.Color;
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
import java.sql.Statement;

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

import net.proteanit.sql.DbUtils;

public class LeavedStudent extends JFrame {

    private JPanel contentPane7;
    private JTable table;
    private DefaultTableModel tableModel;
   
   

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	LeavedStudent  frame = new LeavedStudent();
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
    Statement stmt;
    public LeavedStudent () {
        setUndecorated(true); // Undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 550);
        
        contentPane7 = new JPanel();
        contentPane7.setBackground(new Color(255, 182, 193)); // Light pink background color
        setContentPane(contentPane7);
        contentPane7.setLayout(null);
        
        String path7 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png"; //  button image path
        ImageIcon icon7 = new ImageIcon(path7);
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn7.setBounds(590, 5, 90, 41); // position and size
        btn7.setIcon(icon7);
        contentPane7.add(btn7);
        
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ManageRoom window
            }
        });
        
        JLabel lbl60 = new JLabel("LEAVED STUDENTS "); // Use JLabel instead of JButton for label
        lbl60.setFont(new Font("Algerian", Font.BOLD, 20));
        lbl60.setBounds(200, 40, 250, 41); // position and size
        contentPane7.add(lbl60);
        
        // Create a table with a default table model
        tableModel = new DefaultTableModel();

        // Define table columns and add them to the model
        tableModel.addColumn("Unique ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Father Name");
        tableModel.addColumn("Mother Name");
        tableModel.addColumn("Mobile Number");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");
        tableModel.addColumn("University");
        tableModel.addColumn("Room Number");
        

        // Create the table with the model
        table = new JTable(tableModel);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 680, 350); // position and size for the table
        contentPane7.add(scrollPane);

        // Add some sample data
        connect();
        addSampleData();
        showrecord();
    }

    private void connect() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

    private void showrecord() {
        try {
            stmt = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM newstudent WHERE Living_Status='No'");
            rs = stmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private void addSampleData() {
        // Add sample rows to the table
        tableModel.addRow(new Object[]{"", "", ""});
        tableModel.addRow(new Object[]{"","",""});
     
        String path61 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\989.png"; //  button image path
        ImageIcon icon61 = new ImageIcon(path61);
        JButton btn61 = new JButton("Report");
        btn61.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn61.setBounds(500, 500, 110, 31); // position and size
        btn61.setIcon(icon61);
        contentPane7.add(btn61);
    
        
    }
}