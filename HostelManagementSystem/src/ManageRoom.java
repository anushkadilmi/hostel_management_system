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

public class ManageRoom extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldRoomNumber;
    private JCheckBox checkBoxActivate;
    private DefaultTableModel tableModel;
     String checkBoxValue ; 
     private JComboBox comboBox5;
     private JComboBox comboBox6;
    		
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageRoom frame = new ManageRoom();
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
  
    public ManageRoom() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 700, 500);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String pathClose = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\close.png";
        ImageIcon iconClose = new ImageIcon(pathClose);
        JButton btnClose = new JButton("");
        btnClose.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnClose.setBounds(590, 5, 90, 41);
        btnClose.setIcon(iconClose);
        contentPane.add(btnClose);

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
       
        JLabel lblAddNewRoom = new JLabel("ADD NEW ROOM");
        lblAddNewRoom.setFont(new Font("Algerian", Font.BOLD, 20));
        lblAddNewRoom.setBounds(10, 50, 200, 41);
        contentPane.add(lblAddNewRoom);

        JLabel lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblRoomNumber.setBounds(10, 80, 200, 41);
        contentPane.add(lblRoomNumber);

        textFieldRoomNumber = new JTextField();
        textFieldRoomNumber.setBounds(100, 90, 100, 19);
        contentPane.add(textFieldRoomNumber);
        textFieldRoomNumber.setColumns(10);

        JLabel lblActivateDeactivate = new JLabel("Activate ");
        lblActivateDeactivate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblActivateDeactivate.setBounds(220, 80, 200, 41);
        contentPane.add(lblActivateDeactivate);

        comboBox5 = new JComboBox();
        comboBox5.addItem("");
        comboBox5.addItem("Yes");
        comboBox5.addItem("No");
        comboBox5.setBounds(310,90, 150, 19); // Adjust the position and size as needed
        contentPane.add(comboBox5);


        // Add an ActionListener to the JCheckBox
    

        String pathSave = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\save.png";
        ImageIcon iconSave = new ImageIcon(pathSave);
        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnSave.setBounds(490, 90, 110, 31);
        btnSave.setIcon(iconSave);
        contentPane.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
					int rid= Integer.parseInt(textFieldRoomNumber.getText());
					String  activate = (String) comboBox5.getSelectedItem();
					 String sql = "insert into  rooms(rid ,actiavtion) values(?,?)";
					 pst=con.prepareStatement(sql);
        			 pst.setInt(1, rid);
      		   		 pst.setString(2, activate); 
        			 int i =pst.executeUpdate();
        			 if(i==1)
        			 {
        				   JOptionPane.showMessageDialog(null, "data added successfully");
        			 }
        			 else
        			 {
        				 JOptionPane.showMessageDialog(null, "data can't be Added");
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
        
       
        JLabel lblSeparator1 = new JLabel(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        lblSeparator1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblSeparator1.setBounds(10, 110, 700, 41);
        contentPane.add(lblSeparator1);

        JLabel lblUpdateDeleteRoom = new JLabel("UPDATE & DELETE ROOM");
        lblUpdateDeleteRoom.setFont(new Font("Algerian", Font.BOLD, 20));
        lblUpdateDeleteRoom.setBounds(10, 130, 280, 41);
        contentPane.add(lblUpdateDeleteRoom);

        JLabel lblSearchRoomNumber = new JLabel("Room Number");
        lblSearchRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblSearchRoomNumber.setBounds(10, 170, 200, 41);
        contentPane.add(lblSearchRoomNumber);

        JTextField textFieldSearch = new JTextField();
        textFieldSearch.setBounds(100, 180, 100, 19);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        String pathSearch = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\search.png";
        ImageIcon iconSearch = new ImageIcon(pathSearch);
        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnSearch.setBounds(230, 170, 110, 31);
        btnSearch.setIcon(iconSearch);
        contentPane.add(btnSearch);
        
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
					int uid = Integer.parseInt(textFieldSearch.getText());
					  pst =con.prepareStatement("select * from rooms where rid=?");
					  pst.setInt(1,uid);
					  rs=pst.executeQuery();
					  if(rs.next())
					  {
						  
						  comboBox6.setSelectedItem(rs.getString("actiavtion"));
						  	  }
					  else {
						  JOptionPane.showMessageDialog(null, "No record found with the specified room ID.");
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

        JLabel lblActivateDeactivateUpdate = new JLabel("Activate");
        lblActivateDeactivateUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblActivateDeactivateUpdate.setBounds(380, 170, 200, 41);
        contentPane.add(lblActivateDeactivateUpdate);

        comboBox6= new JComboBox();
        comboBox6.addItem("");
        comboBox6.addItem("Yes");
        comboBox6.addItem("No");
        comboBox6.setBounds(510, 175,150,19); // Adjust the position and size as needed
        contentPane.add(comboBox6);

        String pathUpdate = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\20.png";
        ImageIcon iconUpdate = new ImageIcon(pathUpdate);
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnUpdate.setBounds(380, 225, 110, 31);
        btnUpdate.setIcon(iconUpdate);
        contentPane.add(btnUpdate);
        

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
						int uid=Integer.parseInt(textFieldSearch.getText());
						String activate = (String) comboBox6.getSelectedItem();
						 pst = con.prepareStatement("UPDATE rooms SET actiavtion=? WHERE rid=?");
						 pst.setString(1, activate); 
		                    pst.setInt(2,uid);
		                    int rowsUpdated = pst.executeUpdate();

		                    if (rowsUpdated > 0) {
		                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Failed to update record.");
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
        

        String pathDelete = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\d1.png";
        ImageIcon iconDelete = new ImageIcon(pathDelete);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnDelete.setBounds(550, 225, 110, 31);
        btnDelete.setIcon(iconDelete);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	   try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "");
					
					 int uid = Integer.parseInt(textFieldSearch.getText());
	                    pst = con.prepareStatement("DELETE FROM rooms WHERE rid = ?");
	                    pst.setInt(1, uid);
	                    int rowsDeleted = pst.executeUpdate();
	                    if (rowsDeleted > 0) {
	                        JOptionPane.showMessageDialog(null, "Record deleted successfully.");
	                        textFieldSearch.setText("");
	                        comboBox6.setSelectedItem("");
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
        
        
        JLabel lblSeparator2 = new JLabel(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        lblSeparator2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblSeparator2.setBounds(10, 245, 700, 41);
        contentPane.add(lblSeparator2);

        JLabel lblAllRooms = new JLabel("All Rooms");
        lblAllRooms.setFont(new Font("Algerian", Font.BOLD, 18));
        lblAllRooms.setBounds(250, 270, 200, 41);
        contentPane.add(lblAllRooms);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Number");
        tableModel.addColumn("Activate");
        
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 330, 680, 100);
        contentPane.add(scrollPane);

        addSampleData();
        showrecprd();
    }


    private void showrecprd() 
    {
		// TODO Auto-generated method stub
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","");
						 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM rooms");
	            rs = pstmt.executeQuery();
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void addSampleData() {
        tableModel.addRow(new Object[]{""});
        tableModel.addRow(new Object[]{""});
       
    }
}

