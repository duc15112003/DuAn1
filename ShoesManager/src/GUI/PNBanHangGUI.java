package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.BanHangCTRL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PNBanHangGUI extends JPanel{
	public static JTextField txtTKSP;
	public static JTable tblsanpham;
	public static JTextField txtMaHD;
	public static JTextField txtNgayTao;
	public static JTextField txtMaKH;
	public static JTextField txtHo;
	public static JTextField txtTenKH;
	public static JTextField txtEmail;
	public static JTable tblChiTietHD;
	public static JTextField txtTile;
	public static JTextField txtTongtien;
	public static JTextField txtKhachDua;
	public static JTextField txtTienThua;
	public static JPanel panel;
	public static JComboBox comLoai;
	public static JScrollPane scrollPane;
	public static JPanel panel_1;
	public static JLabel lblMaHD;
	public static JLabel lblNewLabel_1;
	public static JLabel lblMaKH;
	public static JLabel lblTenKH;
	public static JLabel lblNgayTao;
	public static JLabel lblDiachi;
	public static JLabel lblEmail;
	public static JLabel lblHo;
	public static JComboBox comMaNV;
	public static JLabel lblHan;
	public static JPanel panel_1_1;
	public static JPanel panel_1_1_1;
	public static JLabel lblKhuyenMai;
	public static JLabel lblTiLe;
	public static JLabel lblTongTien;
	public static JLabel lblKhachDua;
	public static JLabel lblTienthua;
	public static JButton btnLuu;
	public static JButton btnXuatHD;
	public static JButton btnLammoi;
	public static JButton btnXemDS;
	public static JComboBox comKM;

	BanHangCTRL ctrl = new BanHangCTRL();
	public static JTextField txtGT;
	private JLabel lblgioitinh;
	public static JTextArea txtDiachi;
	
	
	public PNBanHangGUI() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1151, 639);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 340, 628);
		add(panel);
		panel.setLayout(null);
		
		comLoai = new JComboBox();
		comLoai.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		comLoai.setBounds(10, 27, 94, 22);
		comLoai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					String loai = (String) comLoai.getSelectedItem();
					ctrl.FillByLoai(loai);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(comLoai);
		
		txtTKSP = new JTextField();
		txtTKSP.setBounds(156, 28, 174, 20);
		panel.add(txtTKSP);
		txtTKSP.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 320, 519);
		panel.add(scrollPane);
		
		tblsanpham = new JTable();
		tblsanpham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3", "T\u00EAn", "Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(tblsanpham);
		tblsanpham.addMouseListener(new MouseListener() {
			
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
					ctrl.fillFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(350, 11, 801, 207);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblMaHD = new JLabel("Mã HĐ");
		lblMaHD.setForeground(Color.BLUE);
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setBounds(51, 57, 65, 14);
		panel_1.add(lblMaHD);
		
		lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(274, 62, 80, 14);
		panel_1.add(lblNewLabel_1);
		
		lblMaKH = new JLabel("Mã KH");
		lblMaKH.setForeground(Color.BLUE);
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH.setBounds(51, 103, 89, 14);
		panel_1.add(lblMaKH);
		
		lblTenKH = new JLabel("Tên KH");
		lblTenKH.setForeground(Color.BLUE);
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(521, 103, 80, 14);
		panel_1.add(lblTenKH);
		
		lblNgayTao = new JLabel("Ngày Tạo Hóa Đơn");
		lblNgayTao.setForeground(Color.BLUE);
		lblNgayTao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayTao.setBounds(521, 57, 119, 14);
		panel_1.add(lblNgayTao);
		
		lblDiachi = new JLabel("Địa Chỉ");
		lblDiachi.setForeground(Color.BLUE);
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(51, 147, 46, 14);
		panel_1.add(lblDiachi);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(274, 147, 46, 14);
		panel_1.add(lblEmail);
		
		lblHo = new JLabel("Họ KH");
		lblHo.setForeground(Color.BLUE);
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHo.setBounds(274, 103, 80, 14);
		panel_1.add(lblHo);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(141, 56, 86, 20);
		panel_1.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(650, 54, 86, 20);
		panel_1.add(txtNgayTao);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(141, 101, 86, 20);
		panel_1.add(txtMaKH);
		
		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(364, 101, 86, 20);
		panel_1.add(txtHo);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(650, 101, 86, 20);
		panel_1.add(txtTenKH);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(364, 145, 86, 20);
		panel_1.add(txtEmail);
		
		comMaNV = new JComboBox();
		comMaNV.setBounds(364, 58, 86, 22);
		panel_1.add(comMaNV);
		
		lblHan = new JLabel("Hóa Đơn");
		lblHan.setForeground(Color.RED);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHan.setBounds(361, 11, 65, 14);
		panel_1.add(lblHan);
		
		txtDiachi = new JTextArea();
		txtDiachi.setBounds(141, 143, 86, 53);
		panel_1.add(txtDiachi);
		
		lblgioitinh = new JLabel("Giới Tính KH");
		lblgioitinh.setForeground(Color.BLUE);
		lblgioitinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblgioitinh.setBounds(521, 148, 119, 14);
		panel_1.add(lblgioitinh);
		
		txtGT = new JTextField();
		txtGT.setColumns(10);
		txtGT.setBounds(650, 145, 86, 20);
		panel_1.add(txtGT);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(350, 229, 801, 203);
		add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 781, 181);
		panel_1_1.add(scrollPane_1);
		
		tblChiTietHD = new JTable();
		tblChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"M\u00E3 SP", "T\u00EAn SP", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(tblChiTietHD);
		
		panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.setBounds(350, 439, 801, 189);
		add(panel_1_1_1);
		
		lblKhuyenMai = new JLabel("Mã Khuyến Mại");
		lblKhuyenMai.setForeground(Color.BLUE);
		lblKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKhuyenMai.setBounds(10, 40, 109, 14);
		panel_1_1_1.add(lblKhuyenMai);
		
		lblTiLe = new JLabel("Tỉ Lệ KM");
		lblTiLe.setForeground(Color.BLUE);
		lblTiLe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiLe.setBounds(237, 40, 89, 14);
		panel_1_1_1.add(lblTiLe);
		
		lblTongTien = new JLabel("Tổng Tiền");
		lblTongTien.setForeground(Color.BLUE);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongTien.setBounds(461, 40, 89, 14);
		panel_1_1_1.add(lblTongTien);
		
		lblKhachDua = new JLabel("Khách Đưa");
		lblKhachDua.setForeground(Color.BLUE);
		lblKhachDua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKhachDua.setBounds(10, 118, 89, 14);
		panel_1_1_1.add(lblKhachDua);
		
		txtTile = new JTextField("0");
		txtTile.setEnabled(false);
		txtTile.setColumns(10);
		txtTile.setBounds(336, 38, 86, 20);
		panel_1_1_1.add(txtTile);
		
		txtTongtien = new JTextField();
		txtTongtien.setColumns(10);
		txtTongtien.setEnabled(false);
		txtTongtien.setBounds(545, 37, 86, 20);
		panel_1_1_1.add(txtTongtien);
		
		txtKhachDua = new JTextField();
		txtKhachDua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ctrl.tienthua();
			}
		});
		txtKhachDua.setColumns(10);
		txtKhachDua.setBounds(109, 115, 86, 20);
		panel_1_1_1.add(txtKhachDua);
		
		lblTienthua = new JLabel("Tiền thừa");
		
		lblTienthua.setForeground(Color.BLUE);
		lblTienthua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienthua.setBounds(237, 118, 89, 14);

		panel_1_1_1.add(lblTienthua);
		
		txtTienThua = new JTextField();
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(337, 115, 86, 20);
		
		panel_1_1_1.add(txtTienThua);
		
		btnLuu = new JButton("Lưu HĐ");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.Insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLuu.setBounds(702, 11, 89, 23);
		panel_1_1_1.add(btnLuu);
		
		btnXuatHD = new JButton("Xuất HĐ");
		btnXuatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFileChooser fc = new JFileChooser();
				JFileChooser chooser = new JFileChooser();
				int n = chooser.showSaveDialog(btnXuatHD);
				String path = chooser.getSelectedFile().getAbsolutePath();
				ctrl.xuathd(path);
			}
		});
		btnXuatHD.setBounds(702, 55, 89, 23);
		panel_1_1_1.add(btnXuatHD);
		
		btnLammoi = new JButton("Tạo Mới");
		btnLammoi.setBounds(702, 97, 89, 23);
		panel_1_1_1.add(btnLammoi);
		btnLammoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BanHangCTRL bh = new BanHangCTRL();
				bh.clearform();
				
			}
		});
		
		btnXemDS = new JButton("Xem DS");
		btnXemDS.setBounds(702, 141, 89, 23);
		panel_1_1_1.add(btnXemDS);
		
		comKM = new JComboBox();
		comKM.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		comKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String ma = (String) comKM.getSelectedItem();
					ctrl.FillWhenClickComKM(ma);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comKM.setBounds(109, 37, 86, 22);
		panel_1_1_1.add(comKM);
		
		try {
			//ctrl.FillTile();
			ctrl.GetAll();
			ctrl.fill();
			ctrl.FillCombo();
			ctrl.filltable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
