package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.PNNhanVienCTRL;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemsuaNVGUI{
	
	public static JFrame frame;
	public static  JTextField txtMa;
	public static  JTextField txtHo;
	public static  JTextField txtTen;
	public static  JTextField txtDienthoai;
	public static  JTextField txtEmail;
	public static  JTextField txtLuong;
	public static  JTextField txtChucvu;
	public static  JButton btnThem;
	public static  JButton btnSua;
	public static  JLabel lblMa;
	public static  JLabel lblNewLabel_1;
	public static  JLabel lblTen;
	public static  JLabel lblGT;
	public static  JLabel lblDiachi;
	public static  JLabel lblDienThoai;
	public static  JLabel lblEmail;
	public static  JLabel lblChucVu;
	public static  JLabel lblLuong;
	public static  JRadioButton rdoNam;
	public static  JRadioButton rdoNu;
	public static  JTextArea txtDiachi;
	public static  JButton btnChoose;
	public static  JPanel pnAnh;
	public static  JLabel lblAnhText;
	public static  JLabel lblokeanh;
	public  static String path;
	
	PNNhanVienCTRL ctrl = new PNNhanVienCTRL();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public ThemsuaNVGUI() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
	
		frame.setSize(753, 372);
		frame.getContentPane().setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.insert();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Đang thiếu thông tin thành phần");
				}
				
				
			}
		});
		btnThem.setBounds(175, 278, 89, 23);
		frame.getContentPane().add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.Update();
					
				} catch (Exception e2) {
						// TODO: handle exception//
					e2.printStackTrace();
				}
				
			}
		});
		btnSua.setBounds(369, 278, 89, 23);
		frame.getContentPane().add(btnSua);
		
		lblMa = new JLabel("Mã NV");
		lblMa.setBounds(37, 73, 65, 14);
		frame.getContentPane().add(lblMa);
		
		lblNewLabel_1 = new JLabel("Họ");
		lblNewLabel_1.setBounds(37, 118, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblTen = new JLabel("Tên");
		lblTen.setBounds(37, 167, 65, 14);
		frame.getContentPane().add(lblTen);
		
		lblGT = new JLabel("Giới Tính");
		lblGT.setBounds(32, 215, 70, 14);
		frame.getContentPane().add(lblGT);
		
		lblDiachi = new JLabel("Đ.Chỉ");
		lblDiachi.setBounds(278, 73, 46, 14);
		frame.getContentPane().add(lblDiachi);
		
		lblDienThoai = new JLabel("Điện Thoại");
		lblDienThoai.setBounds(278, 153, 70, 14);
		frame.getContentPane().add(lblDienThoai);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(278, 215, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setBounds(528, 118, 65, 14);
		frame.getContentPane().add(lblChucVu);
		
		lblLuong = new JLabel("Lương");
		lblLuong.setBounds(528, 73, 65, 14);
		frame.getContentPane().add(lblLuong);
		
		rdoNam = new JRadioButton("Nam");
		buttonGroup.add(rdoNam);
		rdoNam.setBackground(Color.WHITE);
		rdoNam.setBounds(115, 211, 56, 23);
		frame.getContentPane().add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		buttonGroup.add(rdoNu);
		rdoNu.setBackground(Color.WHITE);
		rdoNu.setBounds(194, 211, 56, 23);
		frame.getContentPane().add(rdoNu);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMa.setForeground(Color.WHITE);
		txtMa.setBackground(Color.LIGHT_GRAY);
		txtMa.setBounds(115, 68, 101, 22);
		frame.getContentPane().add(txtMa);
		txtMa.setColumns(10);
		
		txtHo = new JTextField();
		txtHo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHo.setForeground(Color.WHITE);
		txtHo.setBackground(Color.LIGHT_GRAY);
		txtHo.setColumns(10);
		txtHo.setBounds(115, 112, 101, 23);
		frame.getContentPane().add(txtHo);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setForeground(Color.WHITE);
		txtTen.setBackground(Color.LIGHT_GRAY);
		txtTen.setColumns(10);
		txtTen.setBounds(115, 161, 101, 23);
		frame.getContentPane().add(txtTen);
		
		txtDiachi = new JTextArea();
		txtDiachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiachi.setForeground(Color.WHITE);
		txtDiachi.setBackground(Color.LIGHT_GRAY);
		txtDiachi.setBounds(358, 68, 129, 64);
		frame.getContentPane().add(txtDiachi);
		
		txtDienthoai = new JTextField();
		txtDienthoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDienthoai.setForeground(Color.WHITE);
		txtDienthoai.setBackground(Color.LIGHT_GRAY);
		txtDienthoai.setColumns(10);
		txtDienthoai.setBounds(358, 150, 129, 23);
		frame.getContentPane().add(txtDienthoai);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(358, 212, 129, 20);
		frame.getContentPane().add(txtEmail);
		
		txtLuong = new JTextField();
		txtLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLuong.setForeground(Color.WHITE);
		txtLuong.setBackground(Color.LIGHT_GRAY);
		txtLuong.setColumns(10);
		txtLuong.setBounds(603, 70, 86, 20);
		frame.getContentPane().add(txtLuong);
		
		txtChucvu = new JTextField();
		txtChucvu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChucvu.setForeground(Color.WHITE);
		txtChucvu.setBackground(Color.LIGHT_GRAY);
		txtChucvu.setColumns(10);
		txtChucvu.setBounds(603, 115, 86, 20);
		frame.getContentPane().add(txtChucvu);
		
		btnChoose = new JButton("Choose");
		
		btnChoose.setBounds(603, 262, 89, 23);
		frame.getContentPane().add(btnChoose);
		
		pnAnh = new JPanel();
		pnAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnAnh.setBounds(612, 153, 77, 98);
		frame.getContentPane().add(pnAnh);
		pnAnh.setLayout(null);
		
		lblAnhText = new JLabel("77 x 98");
		lblAnhText.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhText.setBounds(0, 0, 77, 98);
		pnAnh.add(lblAnhText);
		
		lblokeanh = new JLabel("Ảnh");
		lblokeanh.setBounds(528, 153, 65, 14);
		
		
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new FileNameExtensionFilter(
                    "Image (jpg, jpeg, png, bmp, gif)", 
                    "jpg", "jpeg", "png", "bmp", "gif"
                ));
                int n = fc.showOpenDialog(null);
                if(n == JFileChooser.APPROVE_OPTION)
                path = fc.getSelectedFile().getAbsolutePath();
                lblAnhText.setIcon(new ImageIcon(path));
                System.out.println(path);
			}
		});
		frame.getContentPane().add(lblokeanh);
		
		JLabel lblNewLabel = new JLabel("Bảng Thông Tin Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(221, 11, 303, 25);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
