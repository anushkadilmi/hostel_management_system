import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.sql.*;

public class LOGIN extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JCheckBox chckbxNewCheckBox;
    private JButton btnNewButton;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                    LOGIN frame = new LOGIN();
                   
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
  
    
    public LOGIN()
    {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1366, 768);
        
        // Create a background panel to display the image
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

      
        String path60 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\lus1.png"; // Replace with your button image path
        ImageIcon icon60 = new ImageIcon(path60);
        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setBounds(485, 362, 1000, 19);
        lblNewLabel.setVisible(true);
        lblNewLabel.setIcon(icon60);
        backgroundPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(485, 396, 250, 19);
        backgroundPanel.add(textField);
        textField.setColumns(10);

        String path61 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\lp.png"; // Replace with your button image path
        ImageIcon icon61 = new ImageIcon(path61);
        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1.setBounds(485, 430, 1000, 21);
        lblNewLabel_1.setVisible(true);
        lblNewLabel_1.setIcon(icon61);
        backgroundPanel.add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setBounds(485, 464, 250, 19);
        backgroundPanel.add(passwordField);

        chckbxNewCheckBox = new JCheckBox("Show Password");
        chckbxNewCheckBox.setBounds(485, 510, 200, 21);
        chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
        backgroundPanel.add(chckbxNewCheckBox);

        String path = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\l29.png"; // Replace with your button image path
        ImageIcon icon = new ImageIcon(path);
        btnNewButton = new JButton("LOGIN");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.setBounds(485, 580, 165, 41);
        btnNewButton.setIcon(icon);
        backgroundPanel.add(btnNewButton);

        // Add action listener to the checkbox
        chckbxNewCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxNewCheckBoxActionPerformed(evt);
            }
        });

        // Add action listener to the login button
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
                
            }
        });
    }

    private void chckbxNewCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (chckbxNewCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
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
    	
    	
       String username=   textField.getText();
       String password = passwordField.getText();
       
       try {
    	   pst  = con.prepareStatement("SELECT * FROM admin");
           rs = pst.executeQuery();
           
           while(rs.next())
           {
        	   String uname=rs.getString("username");
               String pword=rs.getString("password");
               
               
               if(username.equals(uname) && password.equals(pword))
               {
                   new Home().setVisible(true);
                    this.setVisible(false);
                
                
                    
               }
               else
               {
            	   JOptionPane.showMessageDialog(this,"username or password incorrect");

               }


           }



	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

    // BackgroundPanel class to display the background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Load your background image here
            backgroundImage = new ImageIcon("C:\\Users\\ASUS\\Desktop\\EAD PRO\\pic13.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        
    }
}
