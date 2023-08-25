package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import Controller.ThongKeCTRL;
import DAO.ConnectionSQL;


import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

public class PNThongKeGUI extends JPanel {

	public static JTable tblbanghoadon;
	public static  JTable tblbangphieunhap;
	public static  JTextField txthdmax;
	public static  JTextField txthdtrungbinh;
	public static  JTextField txtpnmax;
	public static JTextField txtpntb;
	 public int current = 0;
	 public static JLabel txtloinhuan;
	 public static  JTextField txtDoanhthutb;
	 public static  JLabel lblloinhuan;
	public static  JLabel lbltongthu;
	public static  JLabel lbltongchi;
	public static  JLabel txttongthu;
	public static  JLabel txttongchi;
	public static  JButton btnxuatTKe;
	ThongKeCTRL ctrl = new ThongKeCTRL();
	private JLabel lblTinhtrang;
	public static JLabel txttinhtrang;
	public PNThongKeGUI() {
		setLayout(null);
		setSize(1151,639);
		
		JLabel lblNewLabel_1 = new JLabel("Bảng Hóa Đơn (Tiền Thu)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(477, 70, 308, 27);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(457, 107, 382, 160);
		add(scrollPane_1);
		
		tblbanghoadon = new JTable();
		scrollPane_1.setViewportView(tblbanghoadon);
		tblbanghoadon.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		tblbanghoadon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 H\u0110", "Ng\u00E0y B\u00E1n", "Ti\u1EC1n B\u00E1n"
			}
		));
		
		JLabel lblNewLabel_1_1 = new JLabel("Bảng Phiếu Nhập (Tiền Chi)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(70, 70, 308, 27);
		add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)), "Qu\u1EA3n L\u00FD Xu\u1EA5t", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(24, 351, 327, 249);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.setBounds(147, 202, 107, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Từ Ngày");
		lblNewLabel_2.setBounds(24, 31, 90, 27);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser JDateChooser11 = new JDateChooser();
		JDateChooser11.setBounds(147, 31, 107, 27);
		panel_1.add(JDateChooser11);
		
		JLabel lblNewLabel_2_1 = new JLabel("Đến Ngày");
		lblNewLabel_2_1.setBounds(24, 71, 90, 27);
		panel_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser JDateChooser12 = new JDateChooser();
		JDateChooser12.setBounds(147, 71, 107, 27);
		panel_1.add(JDateChooser12);
		
		JLabel lblNewLabel_4 = new JLabel("Tiền cao nhất:");
		lblNewLabel_4.setBounds(24, 122, 95, 21);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txthdmax = new JTextField();
		txthdmax.setEnabled(false);
		txthdmax.setBounds(146, 122, 108, 20);
		panel_1.add(txthdmax);
		txthdmax.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tiền trung bình:");
		lblNewLabel_3.setBounds(24, 158, 95, 27);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txthdtrungbinh = new JTextField();
		txthdtrungbinh.setEnabled(false);
		txthdtrungbinh.setBounds(147, 161, 107, 20);
		panel_1.add(txthdtrungbinh);
		txthdtrungbinh.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)), "Qu\u1EA3n L\u00FD Nh\u1EADp", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(388, 351, 327, 249);
		add(panel_1_1);
		
		JButton btnTimkiemxuat = new JButton("Tìm Kiếm");
		
		btnTimkiemxuat.setBounds(157, 200, 104, 23);
		panel_1_1.add(btnTimkiemxuat);
		
		JLabel lblNewLabel_2_2 = new JLabel("Từ Ngày");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(24, 35, 90, 27);
		panel_1_1.add(lblNewLabel_2_2);
		
		JDateChooser JDateChooser21 = new JDateChooser();
		JDateChooser21.setBounds(157, 35, 104, 27);
		panel_1_1.add(JDateChooser21);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Đến Ngày");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(24, 73, 90, 27);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JDateChooser JDateChooser22 = new JDateChooser();
		JDateChooser22.setBounds(158, 73, 103, 27);
		panel_1_1.add(JDateChooser22);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tiền cao nhất:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(19, 125, 95, 21);
		panel_1_1.add(lblNewLabel_4_1);
		
		txtpnmax = new JTextField();
		txtpnmax.setEnabled(false);
		txtpnmax.setColumns(10);
		txtpnmax.setBounds(157, 125, 104, 20);
		panel_1_1.add(txtpnmax);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tiền trung bình:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(19, 157, 95, 27);
		panel_1_1.add(lblNewLabel_3_1);
		
		txtpntb = new JTextField();
		txtpntb.setEnabled(false);
		txtpntb.setColumns(10);
		txtpntb.setBounds(157, 156, 104, 20);
		panel_1_1.add(txtpntb);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)), "Qu\u1EA3n L\u00FD Doanh Thu", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_4.setBounds(754, 351, 368, 249);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Từ Ngày");
		lblNewLabel_2_2_1.setBounds(22, 37, 67, 34);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblNewLabel_2_2_1);
		
		JDateChooser JDateChooser21_1 = new JDateChooser();
		JDateChooser21_1.setBounds(139, 44, 104, 27);
		panel_4.add(JDateChooser21_1);
		
		JDateChooser JDateChooser21_2 = new JDateChooser();
		JDateChooser21_2.setBounds(139, 97, 104, 27);
		panel_4.add(JDateChooser21_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Đến Ngày");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(23, 97, 66, 27);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Doanh thu trung bình:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setBounds(22, 148, 143, 27);
		panel_4.add(lblNewLabel_3_1_1);
		
		txtDoanhthutb = new JTextField();
		txtDoanhthutb.setEnabled(false);
		txtDoanhthutb.setColumns(10);
		txtDoanhthutb.setBounds(196, 151, 104, 20);
		panel_4.add(txtDoanhthutb);
		
		JButton btnTimkiemdoanhthu = new JButton("Tìm Kiếm");
		btnTimkiemdoanhthu.setBounds(196, 203, 104, 23);
		panel_4.add(btnTimkiemdoanhthu);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ");
		lblNewLabel.setBounds(417, 11, 368, 59);
		add(lblNewLabel);
		lblNewLabel.setForeground(new Color(165, 42, 42));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbltongthu = new JLabel("Tổng Thu:");
		lbltongthu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltongthu.setForeground(Color.BLUE);
		lbltongthu.setBounds(882, 105, 105, 17);
		add(lbltongthu);
		
		lbltongchi = new JLabel("Tổng Chi:");
		lbltongchi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltongchi.setForeground(Color.BLUE);
		lbltongchi.setBounds(882, 160, 105, 17);
		add(lbltongchi);
		
		txttongthu = new JLabel("New label");
		txttongthu.setFont(new Font("Tahoma", Font.BOLD, 16));
		txttongthu.setForeground(Color.RED);
		txttongthu.setBounds(986, 108, 155, 14);
		add(txttongthu);
		
		txttongchi = new JLabel("New label");
		txttongchi.setFont(new Font("Tahoma", Font.BOLD, 16));
		txttongchi.setForeground(Color.RED);
		txttongchi.setBounds(986, 161, 155, 14);
		add(txttongchi);
		
		btnxuatTKe = new JButton("Xuất Thống Kê");
		btnxuatTKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser chooser = new JFileChooser();
					chooser.addChoosableFileFilter(new FileNameExtensionFilter("Excel (xls)", "xls"));
					int n = chooser.showSaveDialog(null);
					String path = chooser.getSelectedFile().getAbsolutePath();
					ctrl.Excel(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnxuatTKe.setBounds(883, 297, 205, 23);
		add(btnxuatTKe);
		
		lblloinhuan = new JLabel("Lợi Nhuận:");
		lblloinhuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblloinhuan.setForeground(Color.BLUE);
		lblloinhuan.setBounds(882, 212, 105, 17);
		add(lblloinhuan);
		
		txtloinhuan = new JLabel("New label");
		txtloinhuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtloinhuan.setForeground(Color.RED);
		txtloinhuan.setBounds(986, 213, 155, 14);
		add(txtloinhuan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 107, 381, 159);
		add(scrollPane);
		
		tblbangphieunhap = new JTable();
		scrollPane.setViewportView(tblbangphieunhap);
//				tblbangphieunhap.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						ThongKeDAO tkd = new ThongKeDAO();
//						try {
//							tkd.ShowAll2();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						
//					}
//				});
				tblbangphieunhap.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
				tblbangphieunhap.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
					},
					new String[] {
						"M\u00E3 PN", "N.Nh\u1EADp", "Th\u00E0nh Ti\u1EC1n"
					}
				));
				
				lblTinhtrang = new JLabel("Tình Trạng:");
				lblTinhtrang.setForeground(Color.BLUE);
				lblTinhtrang.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblTinhtrang.setBounds(882, 260, 105, 17);
				add(lblTinhtrang);
				
				txttinhtrang = new JLabel("New label");
				txttinhtrang.setForeground(Color.RED);
				txttinhtrang.setFont(new Font("Tahoma", Font.BOLD, 16));
				txttinhtrang.setBounds(986, 251, 155, 39);
				add(txttinhtrang);

				try {
					ctrl.getData();
					ctrl.FillTable();
					ctrl.SumOfHoaDon();
					ctrl.SumOfPhieuNhap();
					ctrl.TongLoiNhuan();
					ctrl.Tinhtrang();
				} catch (Exception e) {
					// TODO: handle exception
				}
	}
}
