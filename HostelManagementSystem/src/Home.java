import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class Home extends JFrame {

    private JPanel contentPane1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1000, 600);
       
       
        contentPane1 = new JPanel(); // Initialize contentPane1
        setContentPane(contentPane1);
        contentPane1.setLayout(null);
        // Create a content pane to hold the buttons
        BackgroundPanel1 backgroundPanel1 = new BackgroundPanel1();
        setContentPane(backgroundPanel1);
        backgroundPanel1.setLayout(null);
        
        JLabel lbl = new JLabel("NAVIGATION BAR");
        lbl.setFont(new Font("Algerian", Font.BOLD, 25));
        lbl.setBounds(50, 40, 1000, 30);
        lbl.setVisible(true);
        backgroundPanel1.add(lbl);
        
        // Button 1
        String path1 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\lm2.png"; //  button image path
        ImageIcon icon1 = new ImageIcon(path1);
        JButton btn1 = new JButton("  Manage Room");
        btn1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn1.setBounds(10, 100, 290, 41); //position and size
        btn1.setIcon(icon1);
        backgroundPanel1.add(btn1);

   
                

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn1.setForeground(Color.RED); // Change the text color to green when clicked
                openManageRoom(); 
            }
        });

        // Button 2
        String path2 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\ln.png"; //  button image path
        ImageIcon icon2 = new ImageIcon(path2);
        JButton btn2 = new JButton("  New Student");
        btn2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn2.setBounds(10, 170, 290,41); //position and size
        btn2.setIcon(icon2);
        backgroundPanel1.add(btn2);

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn2.setForeground(Color.RED); // Change the text color to green when clicked
                openNewStudent();
            }
        });
        
        // Button 3
        String path3 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\lu.png"; //  button image path
        ImageIcon icon3 = new ImageIcon(path3);
        JButton btn3 = new JButton("  Update & Delete Student");
        btn3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn3.setBounds(10, 240, 290, 41); //  position and size
        btn3.setIcon(icon3);
        backgroundPanel1.add(btn3);
        
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn3.setForeground(Color.RED); // Change the text color to green when clicked
                openUpdateandDelete();
            }
        });
        
        // Button 4
        String path4 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\ip.png"; //  button image path
        ImageIcon icon4 = new ImageIcon(path4);
        JButton btn4 = new JButton("  Student Payments");
        btn4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn4.setBounds(10, 310, 290, 41); // position and size
        btn4.setIcon(icon4);
        backgroundPanel1.add(btn4);
        
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn4.setForeground(Color.RED); // Change the text color to green when clicked
                openStudentPayment();
            }
        });
        
        // Button 5
        String path5 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\liv.png"; // button image path
        ImageIcon icon5 = new ImageIcon(path5);
        JButton btn5 = new JButton("  All Student Living");
        btn5.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn5.setBounds(10, 380, 290, 41); //  position and size
        btn5.setIcon(icon5);
        backgroundPanel1.add(btn5);
        
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn5.setForeground(Color.RED); // Change the text color to green when clicked
                openAllStudentLiving();
            }
        });
        
        // Button 6
        String path6 = "C:\\Users\\ASUS\\Desktop\\EAD PRO\\leaved.png"; //  button image path
        ImageIcon icon6 = new ImageIcon(path6);
        JButton btn6 = new JButton("  Leaved Students");
        btn6.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn6.setBounds(10, 450, 290, 41); //  position and size
        btn6.setIcon(icon6);
        backgroundPanel1.add(btn6);
        
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn6.setForeground(Color.RED); // Change the text color to green when clicked
                openLeavedStudent();
            }
        });
    }
        
        private void openManageRoom() {
            ManageRoom manageRoom = new ManageRoom();
            manageRoom.setVisible(true);
        }     
            private void openNewStudent() {
            	NewStudent newstudent = new NewStudent();
            	newstudent.setVisible(true);
               
        
    }
            
            private void openUpdateandDelete() {
            	UpdateandDelete updateanddelete= new UpdateandDelete();
            	updateanddelete.setVisible(true);
            } 
            
            private void openStudentPayment() {
            	 StudentPayment studentPayment= new StudentPayment();
            	 studentPayment.setVisible(true);
            } 
        
            private void openAllStudentLiving() {
            	AllStudentLiving allStudentLiving= new AllStudentLiving();
            	allStudentLiving.setVisible(true);
           }  
       
            private void openLeavedStudent() {
            	LeavedStudent leavedStudent= new LeavedStudent();
            	leavedStudent.setVisible(true);
           }  
            class BackgroundPanel1 extends JPanel {
                private Image backgroundImage;

                public BackgroundPanel1() {
                    // Load your background image here
                    backgroundImage = new ImageIcon("C:\\Users\\ASUS\\Desktop\\EAD PRO\\pic7.jpg").getImage();
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                
            }
           
        }