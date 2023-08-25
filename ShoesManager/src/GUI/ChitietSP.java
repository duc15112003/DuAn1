package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import Controller.*;

import javax.swing.event.ChangeEvent;

public class ChitietSP {
	BanHangCTRL ctrl = new BanHangCTRL();
	public static JFrame frame;
	public static JLabel lblMaSP;
	public static JLabel lblTen;
	public static JLabel lblSoluong;
	public static JLabel lblSize;
	public static JLabel lblDT;
	public static JLabel lblLoai;
	public static JLabel lblMaXX;
	public static JLabel lblthuonghieu;
	public static JLabel lblmausac;
	public static JLabel lblChatlieu;
	public static JPanel panel;
	public static JLabel lblGiatien;
	public static JLabel lblSoluongmua;
	public static JButton btnHuy;
	public static JButton btnMua;
	public static JSpinner spiSoluongMua;
	public static JLabel lblThanhTien;
	public static JLabel lblThanhtienTXT;
	public static JLabel lblGiatienTXT;
	public static JLabel lblMaSPTXT;
	public static JLabel llblTenSPTXT;
	public static JLabel lblSoluongTXT;
	public static JLabel lblSizeTXT;
	public static JLabel lblDoiTuongTXT;
	public static JLabel lblchatlieuTXT;
	public static JLabel lblLoaiTXT;
	public static JLabel lblxuatxuTXT;
	public static JLabel lblThuongHieuTXT;
	public static JLabel lblMausacTXT;


	
	public ChitietSP() {
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(960,407);
		frame.setLocationRelativeTo(null);
		lblMaSP = new JLabel("Mã SP:");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMaSP.setBounds(10, 26, 96, 14);
		frame.getContentPane().add(lblMaSP);
		
		lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTen.setBounds(10, 63, 96, 14);
		frame.getContentPane().add(lblTen);
		
		lblSoluong = new JLabel("Số Lượng:");
		lblSoluong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSoluong.setBounds(10, 108, 96, 14);
		frame.getContentPane().add(lblSoluong);
		
		lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSize.setBounds(10, 151, 96, 14);
		frame.getContentPane().add(lblSize);
		
		lblDT = new JLabel("Đối Tượng:");
		lblDT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDT.setBounds(10, 188, 96, 14);
		frame.getContentPane().add(lblDT);
		
		lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLoai.setBounds(10, 278, 96, 14);
		frame.getContentPane().add(lblLoai);
		
		lblMaXX = new JLabel("Xuất Xứ:");
		lblMaXX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMaXX.setBounds(338, 26, 83, 14);
		frame.getContentPane().add(lblMaXX);
		
		lblthuonghieu = new JLabel("T.Hiệu:");
		lblthuonghieu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblthuonghieu.setBounds(338, 63, 83, 14);
		frame.getContentPane().add(lblthuonghieu);
		
		lblmausac = new JLabel("Màu Sắc:");
		lblmausac.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblmausac.setBounds(338, 108, 83, 14);
		frame.getContentPane().add(lblmausac);
		
		lblChatlieu = new JLabel("Chất Liệu:");
		lblChatlieu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblChatlieu.setBounds(10, 234, 96, 14);
		frame.getContentPane().add(lblChatlieu);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(609, 11, 325, 346);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblGiatien = new JLabel("Giá Tiền");
		lblGiatien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblGiatien.setBounds(22, 60, 121, 14);
		panel.add(lblGiatien);
		
		lblSoluongmua = new JLabel("Số Lượng Mua");
		lblSoluongmua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSoluongmua.setBounds(22, 120, 121, 14);
		panel.add(lblSoluongmua);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(226, 259, 89, 23);
		panel.add(btnHuy);
		
		btnMua = new JButton("Mua");
		btnMua.setBounds(95, 259, 89, 23);
		btnMua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrl.Filldatahoadon();
				ctrl.doc();
			}
		});
		panel.add(btnMua);
		
		spiSoluongMua = new JSpinner();
		spiSoluongMua.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int so = (int) spiSoluongMua.getValue();
				ctrl.tinhtien(so);
				//System.out.println(so);
			}
		});
		
		spiSoluongMua.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spiSoluongMua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		spiSoluongMua.setBounds(162, 114, 101, 30);
		panel.add(spiSoluongMua);
		
		lblThanhTien = new JLabel("Thành Tiền");
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblThanhTien.setBounds(22, 184, 121, 14);
		panel.add(lblThanhTien);
		
		lblThanhtienTXT = new JLabel("0");
		lblThanhtienTXT.setForeground(Color.BLUE);
		lblThanhtienTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblThanhtienTXT.setBounds(162, 184, 153, 14);
		panel.add(lblThanhtienTXT);
		
		lblGiatienTXT = new JLabel("500");
		lblGiatienTXT.setForeground(Color.BLUE);
		lblGiatienTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGiatienTXT.setBounds(162, 60, 153, 14);
		panel.add(lblGiatienTXT);
		
		lblMaSPTXT = new JLabel("New label");
		lblMaSPTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMaSPTXT.setForeground(Color.BLUE);
		lblMaSPTXT.setBounds(134, 26, 167, 14);
		frame.getContentPane().add(lblMaSPTXT);
		
		llblTenSPTXT = new JLabel("New label");
		llblTenSPTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		llblTenSPTXT.setForeground(Color.BLUE);
		llblTenSPTXT.setBounds(134, 63, 167, 14);
		frame.getContentPane().add(llblTenSPTXT);
		
		lblSoluongTXT = new JLabel("New label");
		lblSoluongTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSoluongTXT.setForeground(Color.BLUE);
		lblSoluongTXT.setBounds(134, 108, 167, 14);
		frame.getContentPane().add(lblSoluongTXT);
		
		lblSizeTXT = new JLabel("New label");
		lblSizeTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSizeTXT.setForeground(Color.BLUE);
		lblSizeTXT.setBounds(134, 151, 167, 14);
		frame.getContentPane().add(lblSizeTXT);
		
		lblDoiTuongTXT = new JLabel("New label");
		lblDoiTuongTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDoiTuongTXT.setForeground(Color.BLUE);
		lblDoiTuongTXT.setBounds(134, 188, 167, 14);
		frame.getContentPane().add(lblDoiTuongTXT);
		
		lblchatlieuTXT = new JLabel("New label");
		lblchatlieuTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblchatlieuTXT.setForeground(Color.BLUE);
		lblchatlieuTXT.setBounds(134, 234, 167, 14);
		frame.getContentPane().add(lblchatlieuTXT);
		
		lblLoaiTXT = new JLabel("New label");
		lblLoaiTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLoaiTXT.setForeground(Color.BLUE);
		lblLoaiTXT.setBounds(134, 278, 167, 14);
		frame.getContentPane().add(lblLoaiTXT);
		
		lblxuatxuTXT = new JLabel("New label");
		lblxuatxuTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblxuatxuTXT.setForeground(Color.BLUE);
		lblxuatxuTXT.setBounds(448, 26, 151, 14);
		frame.getContentPane().add(lblxuatxuTXT);
		
		lblThuongHieuTXT = new JLabel("New label");
		lblThuongHieuTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblThuongHieuTXT.setForeground(Color.BLUE);
		lblThuongHieuTXT.setBounds(448, 63, 151, 14);
		frame.getContentPane().add(lblThuongHieuTXT);
		
		lblMausacTXT = new JLabel("New label");
		lblMausacTXT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMausacTXT.setForeground(Color.BLUE);
		lblMausacTXT.setBounds(448, 108, 151, 14);
		frame.getContentPane().add(lblMausacTXT);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new ChitietSP();
	}
}
