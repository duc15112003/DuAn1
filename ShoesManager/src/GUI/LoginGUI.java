package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import DTO.TaiKhoanDTO;
import DAO.*;

import javax.swing.JCheckBox;

public class LoginGUI {
	
	public static JFrame frame;
//	---------- panel------------
	public static JPanel pnleft;
	public static JPanel pnright;
//	---------- lbl------------
	public static JLabel lblLogo;
	public static JLabel lblName;
	public static JLabel lblPass;
	public static JLabel lblSlogant;
	public static JLabel lblLogin;
//	---------- button------------
	public static JButton btnExit;
//	---------- textfield and passfield------------
	public static JTextField tfName;
	public static JPasswordField pfPass;
	private JCheckBox ckSeepass;
	private JLabel lblTitle;
	private JLabel lblNewLabel;
	LoginCTRL ctrl = new LoginCTRL();
	public static JCheckBox checkNMK;
	
	public LoginGUI() {
		init();
	}
	private void init() {	
		
//		---------- khởi tạo frame ------------
		frame = new JFrame();
		frame.setSize(748, 561);
        frame.getContentPane().setLayout(new GridLayout(0, 2));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
		
		
//		---------- khởi tạo phần tử trong panel ------------
		//-----khởi tạo label-----
		lblName = new JLabel();
		lblPass = new JLabel();
		lblLogo = new JLabel(new ImageIcon(getClass().getResource("/Logo.png")));
		lblLogo.setBounds(90, 60, 200, 200);
	    lblLogo.setBackground(Color.BLACK);
	    
	    lblName = new JLabel(new ImageIcon(getClass().getResource("/user.png")));
	    lblPass = new JLabel(new ImageIcon(getClass().getResource("/password.png")));
	    lblName.setBounds(72, 202, 30, 30);
        lblPass.setBounds(72, 269, 30, 30);
        
        lblLogin = new JLabel("Đăng nhập");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        lblLogin.setBounds(72, 364, 248, 40);
        lblLogin.setBackground(new Color(241, 196, 15));
        lblLogin.setOpaque(true);
        lblLogin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					ctrl.Islogin();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        lblSlogant = new JLabel("Uy Tín Làm Nên Thương Hiệu");
        lblSlogant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblSlogant.setBounds(41, 396, 306, 54);
		//-----khởi tạo button-----
		btnExit = new JButton(new ImageIcon(getClass().getResource("/close.png")));
		btnExit.setBounds(350, 1, 24, 24);
		//-----khởi tạo textfield passfield
		tfName = new JTextField();
		tfName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					
					pfPass.requestFocus();
					
				}
			}
		});
		tfName.setBounds(130, 202, 179, 30);
        tfName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        tfName.setOpaque(false);
       
		pfPass = new JPasswordField();
		pfPass.setFont(new Font("Arial", Font.PLAIN, 14));
		pfPass.setBounds(130, 269, 179, 30);
	   
	        pfPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
	        pfPass.setOpaque(false);
	        pfPass.addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent key) {
	                if (key.getKeyCode() == KeyEvent.VK_ENTER) {
	                }
	            }
	        });
	        
	        //------ khởi tạo checkbox và combobox
	        ckSeepass = new JCheckBox("");
	        ckSeepass.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        ckSeepass.setBounds(315, 261, 39, 47);
	        ckSeepass.setBackground(new Color(169,159,160));
		
		
//		---------- khởi tạo panel------------
		pnleft = new JPanel();
		pnleft.setLayout(null);
        pnleft.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black));
        pnleft.setBackground(new Color(255, 255, 255));
        
        pnright = new JPanel();
        pnright.setLayout(null);
        pnright.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        pnright.setBackground(new Color(169,159,160));
        
// 		------ add các phần tử vào ------
        frame.getContentPane().add(pnleft);
        pnleft.add(lblLogo);
        
       
        pnleft.add(lblSlogant);
        frame.getContentPane().add(pnright);
        pnright.add(btnExit);
        pnright.add(lblName);
        pnright.add(lblPass);
        pnright.add(tfName);
        pnright.add(pfPass);
        pnright.add(lblLogin);
        pnright.add(ckSeepass);
        
        lblTitle = new JLabel("Đăng Nhập");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblTitle.setBounds(138, 89, 148, 40);
        pnright.add(lblTitle);
        
        lblNewLabel = new JLabel("Hoặc");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(186, 426, 39, 40);
        pnright.add(lblNewLabel);
        
        checkNMK = new JCheckBox("Nhớ Mật Khẩu");
        checkNMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
        checkNMK.setBackground(new Color(169, 159, 160));
        checkNMK.setBounds(138, 319, 130, 38);
        pnright.add(checkNMK);
        
        JLabel lbllogogoogle = new JLabel("");
        lbllogogoogle.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		try {
        			String email = JOptionPane.showInputDialog("nhập vào email đăng nhập");
        			ctrl.isLoginByEmail(email);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        lbllogogoogle.setIcon(new ImageIcon(getClass().getResource("/google.png")));
        lbllogogoogle.setBounds(119, 426, 39, 40);
        pnright.add(lbllogogoogle);
        
        JLabel lbllogofacebook = new JLabel("");
        lbllogofacebook.setIcon(new ImageIcon(getClass().getResource("/facebook.png")));
        lbllogofacebook.setBounds(247, 426, 39, 40);
        pnright.add(lbllogofacebook);
        
        JLabel lblNewLabel_1 = new JLabel("Quên Mật Khẩu ?");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					ctrl.fogotPass();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(153, 477, 115, 24);
        pnright.add(lblNewLabel_1);
// 		----- viết sự kiện cho các phần tử cần thiết ------
        
        btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
        
        lblLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
					
				
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		// TODO Auto-generated method stub
        		 lblLogin.setBackground(new Color(250, 160, 100));
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		// TODO Auto-generated method stub
        		lblLogin.setBackground(new Color(241, 196, 15));
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// TODO Auto-generated method stub
        		 lblLogin.setBackground(new Color(243, 156, 18));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		// TODO Auto-generated method stub
        		 lblLogin.setBackground(new Color(241, 196, 15));
        	}
		});
        
        ckSeepass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ckSeepass.isSelected()) {
					pfPass.setEchoChar((char)0);
				}else {
					pfPass.setEchoChar('*');
				}
			}
		});
        
//		----- khởi tạo layout
		frame.setVisible(true);
		
		
		
	}
}
