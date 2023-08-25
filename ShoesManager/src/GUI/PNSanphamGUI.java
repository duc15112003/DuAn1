package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.SanPhamCTRL;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class  PNSanphamGUI extends JPanel {
	public static JTable tblsanpham;
	public static JTextField txtMagiay;
	public static JTextField txtTengiay;
	public static JTextField txtSoluong;
	public static JTextField txtGia;
	public static JTextField txtSize;
	public static JTextField txtDoituong;
	public static JTextField txtChatlieu;
	public static JTextField txtTKTengiay;
	public static JPanel pnsanpham;
	public static JPanel pnthongtin;
	public static JLabel lblMagiay;
	public static JLabel lblTengiay;
	public static JLabel lblSoluong;
	public static JLabel lblGia;
	public static JLabel lblSize;
	public static JLabel lblMamau;
	public static JLabel lblMathuonghieu;
	public static JLabel lblXuatxu;
	public static JLabel lblMaloai;
	public static JLabel lblChatlieu;
	public static JButton btnAdd;
	public static JButton btnUpdate;
	public static JButton btnReset;
	public static JLabel lbldoituong;
	public static JComboBox comMaloai;
	public static JComboBox comMaxx;
	public static JComboBox comMamau;
	public static JComboBox comMaTT;
	public static JPanel pntimkiem;
	public static JLabel lblTKtengiay;
	public static JLabel lblTKMaloai;
	public static JLabel lblTKMaxx;
	public static JLabel lblTKMamau;
	public static JLabel lblTKMathuonghieu;
	public static JComboBox comTKMaloai;
	public static JComboBox comTKMaxx;
	public static JComboBox comTKMamau;
	public static JComboBox comTKMaTT;
	public static JButton btnFind;

	private JButton btnHuyTK;
	private JScrollPane scrollPane;
	SanPhamCTRL ctrl = new SanPhamCTRL();
	public PNSanphamGUI() {
		setBackground(Color.WHITE);
		setSize(1151, 639);
		setLayout(null);
		
		pnsanpham = new JPanel();
		pnsanpham.setBackground(Color.WHITE);
		pnsanpham.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnsanpham.setBounds(15, 12, 1126, 312);
		add(pnsanpham);
		pnsanpham.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 1106, 280);
		pnsanpham.add(scrollPane);
		
		tblsanpham = new JTable();
		tblsanpham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ctrl.setModel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tblsanpham);
		tblsanpham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Gi\u00E0y", "T\u00EAn Gi\u00E0y", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Size", "\u0110TSD", "Ch\u1EA5t Li\u1EC7u", "M\u00E3 Lo\u1EA1i", "M\u00E3 X.X\u1EE9", "M\u00E3 M\u00E0u", "M\u00E3 T.hi\u1EC7u"
			}
		));
		
		pnthongtin = new JPanel();
		pnthongtin.setBackground(Color.WHITE);
		pnthongtin.setLayout(null);
		pnthongtin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnthongtin.setBounds(15, 331, 581, 297);
		add(pnthongtin);
		
		lblMagiay = new JLabel("Mã Giày");
		lblMagiay.setBounds(22, 73, 63, 14);
		pnthongtin.add(lblMagiay);
		
		lblTengiay = new JLabel("Tên Giày");
		lblTengiay.setBounds(22, 107, 63, 14);
		pnthongtin.add(lblTengiay);
		
		lblSoluong = new JLabel("Số Lượng");
		lblSoluong.setBounds(22, 145, 63, 14);
		pnthongtin.add(lblSoluong);
		
		lblGia = new JLabel("Giá");
		lblGia.setBounds(22, 181, 46, 14);
		pnthongtin.add(lblGia);
		
		lblSize = new JLabel("Size");
		lblSize.setBounds(22, 218, 46, 14);
		pnthongtin.add(lblSize);
		
		lblMamau = new JLabel("Mã Màu");
		lblMamau.setBounds(242, 181, 75, 14);
		pnthongtin.add(lblMamau);
		
		lblMathuonghieu = new JLabel("Mã Thương Hiệu");
		lblMathuonghieu.setBounds(242, 218, 97, 14);
		pnthongtin.add(lblMathuonghieu);
		
		lblXuatxu = new JLabel("Mã Xuất Xứ");
		lblXuatxu.setBounds(242, 145, 97, 14);
		pnthongtin.add(lblXuatxu);
		
		lblMaloai = new JLabel("Mã Loại");
		lblMaloai.setBounds(242, 107, 75, 14);
		pnthongtin.add(lblMaloai);
		
		lblChatlieu = new JLabel("Chất Liệu");
		lblChatlieu.setBounds(242, 73, 75, 14);
		pnthongtin.add(lblChatlieu);
		
		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(466, 69, 89, 23);
		pnthongtin.add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(466, 103, 89, 23);
		pnthongtin.add(btnUpdate);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.reset();
			}
		});
		btnReset.setBounds(466, 137, 89, 23);
		pnthongtin.add(btnReset);
		
		lbldoituong = new JLabel("Đối Tượng SD");
		lbldoituong.setBounds(22, 257, 89, 14);
		pnthongtin.add(lbldoituong);
		
		txtMagiay = new JTextField();
		txtMagiay.setBounds(118, 70, 86, 20);
		pnthongtin.add(txtMagiay);
		txtMagiay.setColumns(10);
		
		txtTengiay = new JTextField();
		txtTengiay.setColumns(10);
		txtTengiay.setBounds(118, 104, 86, 20);
		pnthongtin.add(txtTengiay);
		
		txtSoluong = new JTextField();
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(118, 142, 86, 20);
		pnthongtin.add(txtSoluong);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(118, 178, 86, 20);
		pnthongtin.add(txtGia);
		
		txtSize = new JTextField();
		txtSize.setColumns(10);
		txtSize.setBounds(118, 215, 86, 20);
		pnthongtin.add(txtSize);
		
		txtDoituong = new JTextField();
		txtDoituong.setColumns(10);
		txtDoituong.setBounds(118, 254, 86, 20);
		pnthongtin.add(txtDoituong);
		
		txtChatlieu = new JTextField();
		txtChatlieu.setColumns(10);
		txtChatlieu.setBounds(342, 70, 86, 20);
		pnthongtin.add(txtChatlieu);
		
		comMaloai = new JComboBox();
		comMaloai.setBounds(342, 103, 86, 22);
		pnthongtin.add(comMaloai);
		
		comMaxx = new JComboBox();
		comMaxx.setBounds(342, 141, 86, 22);
		pnthongtin.add(comMaxx);
		
		comMamau = new JComboBox();
		comMamau.setBounds(342, 177, 86, 22);
		pnthongtin.add(comMamau);
		
		comMaTT = new JComboBox(); 
		comMaTT.setBounds(342, 214, 86, 22);
		pnthongtin.add(comMaTT);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = txtMagiay.getText();
					ctrl.deleteByma(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(466, 172, 89, 23);
		pnthongtin.add(btnXoa);
		
		pntimkiem = new JPanel();
		pntimkiem.setBackground(Color.WHITE);
		pntimkiem.setLayout(null);
		pntimkiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pntimkiem.setBounds(625, 331, 516, 297);
		add(pntimkiem);
		
		lblTKtengiay = new JLabel("Tên Giày");
		lblTKtengiay.setBounds(60, 79, 78, 14);
		pntimkiem.add(lblTKtengiay);
		
		lblTKMaloai = new JLabel("Mã Loại");
		lblTKMaloai.setBounds(60, 111, 78, 14);
		pntimkiem.add(lblTKMaloai);
		
		lblTKMaxx = new JLabel("Mã Xuất Xứ");
		lblTKMaxx.setBounds(60, 149, 97, 14);
		pntimkiem.add(lblTKMaxx);
		
		lblTKMamau = new JLabel("Mã Màu");
		lblTKMamau.setBounds(60, 185, 66, 14);
		pntimkiem.add(lblTKMamau);
		
		lblTKMathuonghieu = new JLabel("Mã Thương Hiệu");
		lblTKMathuonghieu.setBounds(60, 222, 97, 14);
		pntimkiem.add(lblTKMathuonghieu);
		
		comTKMaloai = new JComboBox();
		comTKMaloai.setBounds(198, 107, 129, 22);
		pntimkiem.add(comTKMaloai);
		
		comTKMaxx = new JComboBox();
		comTKMaxx.setBounds(198, 145, 129, 22);
		pntimkiem.add(comTKMaxx);
		
		comTKMamau = new JComboBox();
		comTKMamau.setBounds(198, 181, 129, 22);
		pntimkiem.add(comTKMamau);
		
		comTKMaTT = new JComboBox();
		comTKMaTT.setBounds(198, 218, 129, 22);
		pntimkiem.add(comTKMaTT);
		
		txtTKTengiay = new JTextField();
		txtTKTengiay.setColumns(10);
		txtTKTengiay.setBounds(198, 76, 129, 20);
		pntimkiem.add(txtTKTengiay);
		
		btnFind = new JButton("Tìm Kiếm");
		btnFind.setBounds(387, 75, 89, 23);
		pntimkiem.add(btnFind);
		
		btnHuyTK = new JButton("Hủy Tìm Kiếm");
		btnHuyTK.setBounds(377, 110, 113, 23);
		pntimkiem.add(btnHuyTK);
		
		try {
			ctrl.getAll();
			ctrl.fillcomboBox();
			ctrl.filltable();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
