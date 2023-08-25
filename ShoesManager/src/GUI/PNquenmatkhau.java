package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;



import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import Controller.*;

public class PNquenmatkhau {
	public static JFrame frame;
	public static JTextField txtMatKhauMoi;
	public static JTextField txtDoiLaiMK;
	public static JPanel pnDoiMK;
	public static JLabel lblNewLabel;
	public static JLabel lblMatKhauMoi;
	public static JLabel lblNhapLai;
	public static JButton btnDoi;
	public static JLabel lblidAnQuenMK;
	LoginCTRL ctrl = new LoginCTRL();
	public PNquenmatkhau() {
		init();
	}
	private void init() {
		 frame = new JFrame();
		 frame.getContentPane().setBackground(Color.WHITE);
		 frame.setSize(439,267);
		 frame.getContentPane().setLayout(null);
		 frame.setLocationRelativeTo(null);
		 
		 pnDoiMK = new JPanel();
		 pnDoiMK.setBackground(Color.WHITE);
		 pnDoiMK.setBounds(0, 0, 427, 234);
		 frame.getContentPane().add(pnDoiMK);
		 pnDoiMK.setLayout(null);
		 
		 lblNewLabel = new JLabel("Đổi Mật Khẩu");
		 lblNewLabel.setForeground(Color.BLUE);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel.setBounds(167, 11, 126, 21);
		 pnDoiMK.add(lblNewLabel);
		 
		 lblMatKhauMoi = new JLabel("Mật Khẩu Mới:");
		 lblMatKhauMoi.setForeground(Color.RED);
		 lblMatKhauMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lblMatKhauMoi.setBounds(27, 73, 102, 14);
		 pnDoiMK.add(lblMatKhauMoi);
		 
		 lblNhapLai = new JLabel("Nhập Lại Mật Khẩu:");
		 lblNhapLai.setForeground(Color.RED);
		 lblNhapLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lblNhapLai.setBounds(27, 134, 138, 14);
		 pnDoiMK.add(lblNhapLai);
		 
		 txtMatKhauMoi = new JTextField();
		 txtMatKhauMoi.setBounds(167, 71, 221, 20);
		 pnDoiMK.add(txtMatKhauMoi);
		 txtMatKhauMoi.setColumns(10);
		 
		 txtDoiLaiMK = new JTextField();
		 txtDoiLaiMK.setColumns(10);
		 txtDoiLaiMK.setBounds(167, 128, 221, 20);
		 pnDoiMK.add(txtDoiLaiMK);
		 
		 btnDoi = new JButton("Đổi Mật Khẩu");
		 btnDoi.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			ctrl.ChangeFogotPass();
				} catch (Exception e2) {
					// TODO: handle exception
				}
		 	}
		 });
		 btnDoi.setBounds(27, 189, 361, 23);
		 pnDoiMK.add(btnDoi);
		 
		 lblidAnQuenMK = new JLabel("New label");
		 lblidAnQuenMK.setBounds(336, 46, 46, 14);
		 frame.getContentPane().add(lblidAnQuenMK);
		 frame.setVisible(true);
	 }
	
}
