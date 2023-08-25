package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.DoiMKCTRL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DoiMKGUI {
	
	public static JFrame frame;
	public static  JTextField txtMKHT;
	public static  JTextField txtNewPass;
	public static  JTextField txtConfirm;
	public static  JPanel panel;
	public static  JLabel lblTieuDe;
	public static  JLabel lblMKHT;
	public static  JLabel lblMKM;
	public static  JLabel lblNLMK;
	public static  JButton btnChange;

	DoiMKCTRL ctrl = new DoiMKCTRL();
	
	public DoiMKGUI() {
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		frame = new JFrame();
		frame.setSize(432, 292);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 416, 258);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTieuDe = new JLabel("Đổi Mật Khẩu");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTieuDe.setBounds(154, 21, 138, 19);
		panel.add(lblTieuDe);
		
		lblMKHT = new JLabel("Mật Khẩu Hiện Tại");
		lblMKHT.setForeground(Color.BLUE);
		lblMKHT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMKHT.setBounds(10, 69, 154, 32);
		panel.add(lblMKHT);
		
		lblMKM = new JLabel("Mật Khẩu Mới");
		lblMKM.setForeground(Color.BLUE);
		lblMKM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMKM.setBounds(10, 119, 111, 19);
		panel.add(lblMKM);
		
		lblNLMK = new JLabel("Nhập Lại Mật Khẩu");
		lblNLMK.setForeground(Color.BLUE);
		lblNLMK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNLMK.setBounds(10, 168, 154, 19);
		panel.add(lblNLMK);
		
		txtMKHT = new JTextField();
		txtMKHT.setBounds(196, 77, 210, 20);
		panel.add(txtMKHT);
		txtMKHT.setColumns(10);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(196, 120, 210, 20);
		panel.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		txtConfirm = new JTextField();
		txtConfirm.setBounds(196, 169, 210, 20);
		panel.add(txtConfirm);
		txtConfirm.setColumns(10);
		
		btnChange = new JButton("Đổi Mật Khẩu");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.check();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChange.setBounds(10, 211, 396, 23);
		panel.add(btnChange);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new DoiMKGUI();
	}

}
