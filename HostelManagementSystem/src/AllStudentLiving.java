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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class AllStudentLiving extends JFrame {

    private JPanel contentPane6;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection con;
    private ResultSet rs;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AllStudentLiving frame = new AllStudentLiving();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AllStudentLiving() {
        setUndecorated(true); // Undecorated
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 550);

        contentPane6 = new JPanel();
        contentPane6.setBackground(new Color(255, 182, 193)); // Light pink background color
        setContentPane(contentPane6);
        contentPane6.setLayout(null);

        String path7 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png"; // button image path
        ImageIcon icon7 = new ImageIcon(path7);
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn7.setBounds(590, 5, 90, 41); // position and size
        btn7.setIcon(icon7);
        contentPane6.add(btn7);

        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ManageRoom window
            }
        });

        JLabel lbl50 = new JLabel("ALL STUDENT LIVING "); // Use JLabel instead of JButton for label
        lbl50.setFont(new Font("Algerian", Font.BOLD, 20));
        lbl50.setBounds(200, 40, 250, 41); // position and size
        contentPane6.add(lbl50);

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
        contentPane6.add(scrollPane);

        // Connect to the database
        connect();

        // Add some sample data
        addSampleData();

        // Show records from the database
        showRecord();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void showRecord() {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM newstudent WHERE Living_Status='Yes'");
            rs = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void addSampleData() {
        // Add sample rows to the table
        tableModel.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});
        tableModel.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});

        String path51 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\989.png"; // button image path
        ImageIcon icon51 = new ImageIcon(path51);
        JButton btn51 = new JButton("Report");
        btn51.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn51.setBounds(500, 500, 110, 31); // position and size
        btn51.setIcon(icon51);
        contentPane6.add(btn51);
    }
}
