package GUI;

import java.awt.Color;
import java.awt.Component;
import Controller.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PNHoadonGUI extends JPanel {
	public static JTextField txtMahoadon;
	public static JTextField txtManhanvien;
	public static JTextField txtTongtien;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	public static JTextField txtMaspchitiet;
	public static JTextField txtMaHDchitiet;
	public static JTextField txtSoluongchitiet;
	public static JTextField txtGiabanchitiet;
	public static JTextField txtMaSPtimkiem;
	public static JTextField txtSoluongbatdau;
	public static JTextField txtSoluongketthuc;
	public static final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static JPanel panel;
	public static JLabel lblNewLabel;
	public static JLabel lblNewLabel_1;
	public static JPanel panel_2;
	public static JLabel lblMahoadon;
	public static JLabel lblMakhachhang;
	public static JLabel lblManhanvien;
	public static JLabel lblMakhuyenmai;
	public static JLabel lblTongtien;
	public static JButton btnThem;
	public static JButton btnSua;
	public static JButton btnXoa;
	public static JPanel pnBanghoadon;
	public static JPanel panel_1;
	public static JLabel lblTieude;
	public static JLabel lblMaSPchitiet;
	public static JLabel lblMaHDchitiet;
	public static JLabel lblSoluongchitiet;
	public static JLabel lblGiabanchitiet;
	public static JButton btnThemchitiet;
	public static JButton btnXoachitiet;
	public static JButton btnSuachitiet;
	public static JButton btnLammoichitiet;
	public static JLabel lblMaSPtimkiem;
	public static JLabel lblSoluongtimkiem;
	public static JButton btnTimchitiet;
	public static JButton btnHuy;
	public static JButton btnLammoitimkiem;
	public static JLabel lblNewLabel_11;
	public static JRadioButton rdoTangdan;
	public static JRadioButton rdoGiamdan;
	public static JPanel pnBangchitiethoadon;
	public static JButton btnLammoi;
	public static JComboBox comMakhachhang;
	public static JComboBox comMakhuyenmai;
	public static Component lblNgayban;
	public static JDateChooser dateNgayban;
	public static JTable tblhoadon;
	public static JTable tblhoadonCT;

	PNHoadonCTRL ctrl = new PNHoadonCTRL();
	public PNHoadonGUI()  {

		setSize(1151, 639);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.RED, 3));
		panel.setBounds(21, 11, 413, 617);
		add(panel);
		panel.setLayout(null);
		lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("/thongtinne.png")));
		lblNewLabel.setBounds(32, 56, 95, 48);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("/searchlbl.png")));
		lblNewLabel_1.setBounds(244, 56, 112, 48);
		panel.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 115, 393, 230);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblMahoadon = new JLabel("Mã Hóa Đơn");
		lblMahoadon.setBounds(10, 11, 94, 14);
		panel_2.add(lblMahoadon);
		
		lblMakhachhang = new JLabel("Mã Khách Hàng");
		lblMakhachhang.setBounds(10, 36, 94, 14);
		panel_2.add(lblMakhachhang);
		
		lblManhanvien = new JLabel("Mã Nhân Viên");
		lblManhanvien.setBounds(10, 61, 94, 14);
		panel_2.add(lblManhanvien);
		
		lblMakhuyenmai = new JLabel("Mã Khuyến Mại ");
		lblMakhuyenmai.setBounds(10, 90, 94, 14);
		panel_2.add(lblMakhuyenmai);
		
		lblTongtien = new JLabel("Tổng Tiền");
		lblTongtien.setBounds(10, 140, 94, 14);
		panel_2.add(lblTongtien);
		
		txtMahoadon = new JTextField();
		txtMahoadon.setBounds(139, 8, 135, 20);
		panel_2.add(txtMahoadon);
		txtMahoadon.setColumns(10);
		
		txtManhanvien = new JTextField();
		txtManhanvien.setBounds(139, 58, 135, 20);
		panel_2.add(txtManhanvien);
		txtManhanvien.setColumns(10);
		
		txtTongtien = new JTextField();
		txtTongtien.setBounds(139, 137, 135, 20);
		panel_2.add(txtTongtien);
		txtTongtien.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ctrl.Insert();
					ctrl.New();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kiểm tra lại các thông tin có thể đang trống thông tin nào đó");
				}
			}
		});
		btnThem.setBounds(10, 185, 74, 23);
		panel_2.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.Update();
					ctrl.New();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin cập nhật có thể đang trống");
				}
			}
		});
		btnSua.setBounds(94, 185, 74, 23);
		panel_2.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.DeleteHDCTAll();
					ctrl.Delete();
					ctrl.filltoTable();
					ctrl.New();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(null, "Kiểm tra thông tin cần xóa");
				}
			}
		});
		btnXoa.setBounds(178, 185, 74, 23);
		panel_2.add(btnXoa);
		
		btnLammoi = new JButton("Làm Mới");
		btnLammoi.setBounds(264, 185, 89, 23);
		panel_2.add(btnLammoi);
		btnLammoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrl.New();
			}
		});
		
		comMakhachhang = new JComboBox();
		comMakhachhang.setBounds(139, 32, 135, 22);
		panel_2.add(comMakhachhang);
		
		comMakhuyenmai = new JComboBox();
		comMakhuyenmai.setBounds(139, 82, 135, 22);
		panel_2.add(comMakhuyenmai);
		
		lblNgayban = new JLabel("Ngày Bán");
		lblNgayban.setBounds(10, 115, 94, 14);
		panel_2.add(lblNgayban);
		
		dateNgayban = new JDateChooser();
		dateNgayban.setDateFormatString("yyyy-MM-dd");
		dateNgayban.setBounds(139, 109, 135, 20);
		panel_2.add(dateNgayban);
		
		pnBanghoadon = new JPanel();
		pnBanghoadon.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Bảng Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnBanghoadon.setBounds(10, 376, 393, 230);
		panel.add(pnBanghoadon);
		pnBanghoadon.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 26, 373, 193);
		pnBanghoadon.add(scrollPane_1);
		
		tblhoadon = new JTable();
		tblhoadon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ctrl.fillwhenClickedHoaDon();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kiểm tra lại kết nối");
				}
			}
		});
		scrollPane_1.setViewportView(tblhoadon);
		tblhoadon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u0110", "M\u00E3 KH", "M\u00E3 NV", "M\u00E3 KM", "Ng\u00E0y", "T\u1ED5ng"
			}
		));
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.RED, 3));
		panel_1.setBounds(444, 11, 707, 617);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblTieude = new JLabel("Chi Tiết Hóa Đơn");
		lblTieude.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblTieude.setBounds(272, 45, 223, 30);
		panel_1.add(lblTieude);
		
		lblMaSPchitiet = new JLabel("Mã Sản Phẩm");
		lblMaSPchitiet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblMaSPchitiet.setBounds(27, 130, 111, 14);
		panel_1.add(lblMaSPchitiet);
		
		lblMaHDchitiet = new JLabel("Mã Hóa Đơn");
		lblMaHDchitiet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblMaHDchitiet.setBounds(27, 183, 111, 14);
		panel_1.add(lblMaHDchitiet);
		
		lblSoluongchitiet = new JLabel("Số Lượng");
		lblSoluongchitiet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblSoluongchitiet.setBounds(27, 231, 96, 14);
		panel_1.add(lblSoluongchitiet);
		
		lblGiabanchitiet = new JLabel("Giá Bán");
		lblGiabanchitiet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblGiabanchitiet.setBounds(27, 278, 79, 14);
		panel_1.add(lblGiabanchitiet);
		
		txtMaspchitiet = new JTextField();
		txtMaspchitiet.setBounds(148, 124, 266, 30);
		panel_1.add(txtMaspchitiet);
		txtMaspchitiet.setColumns(10);
		
		txtMaHDchitiet = new JTextField();
		txtMaHDchitiet.setColumns(10);
		txtMaHDchitiet.setBounds(148, 177, 266, 30);
		panel_1.add(txtMaHDchitiet);
		
		txtSoluongchitiet = new JTextField();
		txtSoluongchitiet.setColumns(10);
		txtSoluongchitiet.setBounds(148, 225, 266, 30);
		panel_1.add(txtSoluongchitiet);
		
		txtGiabanchitiet = new JTextField();
		txtGiabanchitiet.setColumns(10);
		txtGiabanchitiet.setBounds(148, 272, 266, 30);
		panel_1.add(txtGiabanchitiet);
		
		btnThemchitiet = new JButton("Thêm");
		btnThemchitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.InsertHDCT();
					ctrl.New();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kiểm tra lại các thông tin có thể đang trống thông tin nào đó");
				}
			}
		});
		btnThemchitiet.setBounds(27, 329, 89, 23);
		panel_1.add(btnThemchitiet);
		
		btnXoachitiet = new JButton("Xóa");
		btnXoachitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ctrl.DeleHDCT();
					ctrl.New();
				} catch (Exception E) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kiểm tra thông tin cần xóa");
				}
				
			}
		});
		btnXoachitiet.setBounds(126, 329, 89, 23);
		panel_1.add(btnXoachitiet);
		
		btnSuachitiet =  new JButton("Sửa");
		btnSuachitiet.setBounds(224, 329, 89, 23);
		panel_1.add(btnSuachitiet);
		
		btnLammoichitiet = new JButton("Làm Mới");
		btnLammoichitiet.setBounds(323, 329, 89, 23);
		panel_1.add(btnLammoichitiet);
		
		lblMaSPtimkiem = new JLabel("Mã Sản Phẩm");
		lblMaSPtimkiem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblMaSPtimkiem.setBounds(449, 130, 123, 14);
		panel_1.add(lblMaSPtimkiem);
		
		lblSoluongtimkiem = new JLabel("Số Lượng");
		lblSoluongtimkiem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblSoluongtimkiem.setBounds(449, 183, 123, 14);
		panel_1.add(lblSoluongtimkiem);
		
		btnTimchitiet = new JButton("Tìm");
		btnTimchitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.FindHD();
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin cần tìm");
				}
			}
		});
		btnTimchitiet.setBounds(449, 329, 71, 23);
		panel_1.add(btnTimchitiet);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(530, 329, 71, 23);
		panel_1.add(btnHuy);
		
		btnLammoitimkiem = new JButton("Làm Mới");
		btnLammoitimkiem.setBounds(611, 329, 89, 23);
		panel_1.add(btnLammoitimkiem);
		
		txtMaSPtimkiem = new JTextField();
		txtMaSPtimkiem.setColumns(10);
		txtMaSPtimkiem.setBounds(577, 124, 123, 30);
		panel_1.add(txtMaSPtimkiem);
		
		txtSoluongbatdau = new JTextField();
		txtSoluongbatdau.setColumns(10);
		txtSoluongbatdau.setBounds(449, 215, 100, 30);
		panel_1.add(txtSoluongbatdau);
		
		txtSoluongketthuc = new JTextField();
		txtSoluongketthuc.setColumns(10);
		txtSoluongketthuc.setBounds(589, 215, 111, 30);
		panel_1.add(txtSoluongketthuc);
		
		lblNewLabel_11 = new JLabel("==>");
		lblNewLabel_11.setBounds(559, 225, 29, 14);
		panel_1.add(lblNewLabel_11);
		
		rdoTangdan = new JRadioButton("Tăng Dần");
		buttonGroup_1.add(rdoTangdan);
		rdoTangdan.setBackground(new Color(255, 255, 255));
		rdoTangdan.setBounds(449, 276, 109, 23);
		panel_1.add(rdoTangdan);
		
		rdoGiamdan = new JRadioButton("Giảm Dần");
		buttonGroup_1.add(rdoGiamdan);
		rdoGiamdan.setBackground(Color.WHITE);
		rdoGiamdan.setBounds(577, 276, 109, 23);
		panel_1.add(rdoGiamdan);
		
		pnBangchitiethoadon = new JPanel();
		pnBangchitiethoadon.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Bảng Chi Tiết Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnBangchitiethoadon.setBackground(Color.WHITE);
		pnBangchitiethoadon.setBounds(27, 377, 673, 229);
		panel_1.add(pnBangchitiethoadon);
		pnBangchitiethoadon.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 653, 196);
		pnBangchitiethoadon.add(scrollPane);
		
		tblhoadonCT = new JTable();
		tblhoadonCT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ctrl.fillwhenClickedHoaDonCT();
				
			}
		});
		scrollPane.setViewportView(tblhoadonCT);
		tblhoadonCT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 SP", "M\u00E3 H\u0110", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 B\u00E1n"
			}
		));
		try {
        	ctrl.getAll();
        	ctrl.getAllKH();
        	ctrl.filltoTable();
        	ctrl.fillToComHoaDon();
        	ctrl.fillToComHoaDonKM();
        	ctrl.getFullList();
        	ctrl.FilltoTable();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
}
