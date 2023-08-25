package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Controller.TrangCaNhanCTRL;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrameTrangCaNhan {
	
	public static JFrame frame;
	public static JTextField txtMaNV;
	public static JTextField txtHo;
	public static JTextField txtTen;
	public static JTextField txtGioiTinh;
	public static JTextField txtDienThoai;
	public static JTextField txtEmail;
	public static JTextField txtLuong;
	public static JTextField txtChucvu;
	public static JPanel pnThongtin;
	public static JLabel lblTieude;
	public static Component lblMaNV;
	public static JLabel lblHo;
	public static JLabel lblTen;
	public static JLabel lblGT;
	public static JLabel lbldiachi;
	public static JLabel lblDienthoai;
	public static JLabel lblChucvu;
	public static JLabel lblLuong;
	public static JLabel lblEmail;
	public static JTextArea txtDiachi;
	public static JButton btnSua;
	public static JButton btnDoiMK;
	public static JLabel lblPhienBan;
	public static JPanel pnAnh;
	public static JLabel lblanh;
	public static String path;
	TrangCaNhanCTRL ctrl = new TrangCaNhanCTRL();
	public FrameTrangCaNhan() {
		init();
	}
	private void init() {
		frame = new JFrame("Trang cá nhân");
		frame.getContentPane().setLayout(null);
		frame.setSize(820,380);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		pnThongtin = new JPanel();
		pnThongtin.setBackground(new Color(255, 255, 255));
		pnThongtin.setBounds(0, 0, 804, 341);
		frame.getContentPane().add(pnThongtin);
		pnThongtin.setLayout(null);
		
		lblTieude = new JLabel("Thông Tin Cá Nhân");
		lblTieude.setForeground(Color.BLUE);
		lblTieude.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTieude.setBounds(299, 11, 169, 20);
		pnThongtin.add(lblTieude);
		
		lblMaNV = new JLabel("Mã NV");
		lblMaNV.setForeground(new Color(153, 153, 102));
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaNV.setBounds(22, 66, 79, 14);
		pnThongtin.add(lblMaNV);
		
		lblHo = new JLabel("Họ");
		lblHo.setForeground(new Color(153, 153, 102));
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHo.setBounds(22, 105, 73, 20);
		pnThongtin.add(lblHo);
		
		lblTen = new JLabel("Tên");
		lblTen.setForeground(new Color(153, 153, 102));
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTen.setBounds(22, 148, 73, 14);
		pnThongtin.add(lblTen);
		
		lblGT = new JLabel("Giới Tính");
		lblGT.setForeground(new Color(153, 153, 102));
		lblGT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGT.setBounds(22, 193, 79, 14);
		pnThongtin.add(lblGT);
		
		lbldiachi = new JLabel("Địa Chỉ");
		lbldiachi.setForeground(new Color(153, 153, 102));
		lbldiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiachi.setBounds(326, 148, 65, 14);
		pnThongtin.add(lbldiachi);
		
		lblDienthoai = new JLabel("Điện Thoại");
		lblDienthoai.setForeground(new Color(153, 153, 102));
		lblDienthoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDienthoai.setBounds(22, 235, 94, 20);
		pnThongtin.add(lblDienthoai);
		
		lblChucvu = new JLabel("Chức Vụ");
		lblChucvu.setForeground(new Color(153, 153, 102));
		lblChucvu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucvu.setBounds(326, 235, 65, 20);
		pnThongtin.add(lblChucvu);
		
		lblLuong = new JLabel("Lương");
		lblLuong.setForeground(new Color(153, 153, 102));
		lblLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLuong.setBounds(326, 105, 65, 14);
		pnThongtin.add(lblLuong);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(153, 153, 102));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(326, 66, 65, 14);
		pnThongtin.add(lblEmail);
		
		txtMaNV = new JTextField();
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(126, 65, 146, 20);
		pnThongtin.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtHo = new JTextField();
		txtHo.setEnabled(false);
		txtHo.setColumns(10);
		txtHo.setBounds(126, 104, 146, 20);
		pnThongtin.add(txtHo);
		
		txtTen = new JTextField();
		txtTen.setEnabled(false);
		txtTen.setColumns(10);
		txtTen.setBounds(126, 147, 146, 20);
		pnThongtin.add(txtTen);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setEnabled(false);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(126, 192, 146, 20);
		pnThongtin.add(txtGioiTinh);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(126, 234, 146, 20);
		pnThongtin.add(txtDienThoai);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(401, 63, 146, 20);
		pnThongtin.add(txtEmail);
		
		txtLuong = new JTextField();
		txtLuong.setEnabled(false);
		txtLuong.setColumns(10);
		txtLuong.setBounds(401, 102, 146, 20);
		pnThongtin.add(txtLuong);
		
		txtDiachi = new JTextArea();
		txtDiachi.setBounds(401, 143, 140, 64);
		txtDiachi.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnThongtin.add(txtDiachi);
		
		txtChucvu = new JTextField();
		txtChucvu.setEnabled(false);
		txtChucvu.setColumns(10);
		txtChucvu.setBounds(401, 232, 146, 20);
		pnThongtin.add(txtChucvu);
		
		btnSua = new JButton("Sửa TT");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.Update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSua.setBounds(559, 295, 89, 23);
		pnThongtin.add(btnSua);
		
		btnDoiMK = new JButton("Đổi MK");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoiMKGUI();
			}
		});
		btnDoiMK.setBounds(689, 295, 89, 23);
		pnThongtin.add(btnDoiMK);
		
		lblPhienBan = new JLabel("Phiên Bản Beta 0.1.1");
		lblPhienBan.setForeground(Color.RED);
		lblPhienBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhienBan.setBounds(45, 304, 189, 14);
		pnThongtin.add(lblPhienBan);
		
		pnAnh = new JPanel();
		pnAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnAnh.setBounds(625, 66, 115, 145);
		pnThongtin.add(pnAnh);
		pnAnh.setLayout(null);
		
		lblanh = new JLabel("Ảnh");
		lblanh.setBounds(10, 11, 96, 122);
		pnAnh.add(lblanh);
		lblanh.setHorizontalAlignment(SwingConstants.CENTER);
		frame.setVisible(true);
	}
	
}
