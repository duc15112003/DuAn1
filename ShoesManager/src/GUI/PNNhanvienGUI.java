package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.PNNhanVienCTRL;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class PNNhanvienGUI extends JPanel{
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtGioiTinh;
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JTextField txtEmail;
	private JTextField txtLuong;
	JPanel panel;
	NhanVienDAO dt = new NhanVienDAO();
	PNNhanVienCTRL ctrl = new PNNhanVienCTRL();
	List<NhanVienDTO> list = new ArrayList();
	public PNNhanvienGUI() throws SQLException {
		// TODO Auto-generated constructor stub
		setBackground(Color.WHITE);
		setSize(1151,639);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(1, 56, 1151,620);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		
		hamtao();
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 21, 1151,620);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 1136, 21);
		add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1136, 22);
		panel_1.add(menuBar);
		
		JMenu MenuCongcu = new JMenu("Công Cụ");
		MenuCongcu.setIcon(new ImageIcon(getClass().getResource("/tools.png")));
		menuBar.add(MenuCongcu);
		
		JMenuItem ItemThem = new JMenuItem("Thêm");
		ItemThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemsuaNVGUI nv = new ThemsuaNVGUI();
				nv.btnSua.setEnabled(false);
				nv.frame.setLocationRelativeTo(null);
			}
		});
		ItemThem.setIcon(new ImageIcon(getClass().getResource("/add.png")));
		MenuCongcu.add(ItemThem);
		
		JMenuItem ItemSua = new JMenuItem("Sửa");
		ItemSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemsuaNVGUI nv = new ThemsuaNVGUI();
				nv.btnThem.setEnabled(false);
				nv.frame.setLocationRelativeTo(null);
				
				try {
					panel.removeAll();
					panel.revalidate();
					hamtao();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
		});
		ItemSua.setIcon(new ImageIcon(getClass().getResource("/updated.png")));
		MenuCongcu.add(ItemSua);
		
		JMenuItem ItemXoa = new JMenuItem("Xóa");
		ItemXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.DeleteNV();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ItemXoa.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
		MenuCongcu.add(ItemXoa);
		
		JMenu MenuTimkiem = new JMenu("Tìm Kiếm");
		MenuTimkiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String intput = JOptionPane.showInputDialog("Nhập Mã Nhân Viên Cần Tìm");
					TK(intput);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MenuTimkiem.setIcon(new ImageIcon(getClass().getResource("/find.png")));
		menuBar.add(MenuTimkiem);
		
		JMenu MenuLamMoi = new JMenu("Làm Mới");
		MenuLamMoi.setIcon(new ImageIcon(getClass().getResource("/reload.png")));
		menuBar.add(MenuLamMoi);
		
		JMenuItem ItemLammoi = new JMenuItem("Làm Mới");
		ItemLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					panel.removeAll();
					panel.revalidate();
					hamtao();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		ItemLammoi.setIcon(new ImageIcon(getClass().getResource("/reload.png")));
		MenuLamMoi.add(ItemLammoi);
		
	}
	
	public void TK(String input) throws SQLException {
		if(input.equals("")) {
			panel.removeAll();
			panel.revalidate();
			hamtao();
		}else {
			list.clear();
			list = dt.FindDataByID(input);
			panel.removeAll();
			panel.revalidate();
			for (int i = 0; i < list.size(); i++) {
	            JPanel panel1 = createPanel(i); // Tạo một JPanel mới
	            panel1.setPreferredSize(new Dimension(1106, 153)); // Đặt kích thước cho JPanel
	            panel.add(panel1); // Thêm JPanel vào JFrame
	            
	     }
		}
	}
	
	public void hamtao() throws SQLException {
		list.clear();
		list = dt.select();
		for (int i = 0; i < list.size(); i++) {
            JPanel panel1 = createPanel(i); // Tạo một JPanel mới
            panel1.setPreferredSize(new Dimension(1106, 153)); // Đặt kích thước cho JPanel
            panel1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
            panel.add(panel1); // Thêm JPanel vào JFrame
            
     }
	}
	 public JPanel createPanel(int index) throws SQLException {
		 JPanel pnNhanvien = new JPanel();
			pnNhanvien.setBackground(new Color(255, 255, 255));
			pnNhanvien.setBorder(new LineBorder(Color.RED, 1, true));
			pnNhanvien.setBounds(35, 32, 1106, 153);
			pnNhanvien.setLayout(null);
			
			JPanel pnAnh = new JPanel();
			pnAnh.setBounds(10, 11, 128, 132);
			pnAnh.setBackground(Color.white);
			pnNhanvien.add(pnAnh);
			
			JLabel lblAnh = new JLabel();
			pnAnh.add(lblAnh);
			lblAnh.setIcon(new ImageIcon(list.get(index).getAnh()));
			
			JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
			lblMaNV.setBounds(148, 24, 91, 24);
			pnNhanvien.add(lblMaNV);
			
			JLabel lblSoDT = new JLabel("Số Điện Thoại:");
			lblSoDT.setBounds(148, 75, 91, 24);
			pnNhanvien.add(lblSoDT);
			
			JLabel lblHo = new JLabel("Họ:");
			lblHo.setBounds(345, 24, 39, 24);
			pnNhanvien.add(lblHo);
			
			JLabel txtMa = new JLabel("new lbl");
			txtMa.setForeground(new Color(0, 0, 255));
			txtMa.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtMa.setBounds(249, 21, 86, 31);
			txtMa.setText(list.get(index).getMaNV());
			pnNhanvien.add(txtMa);
			
			JLabel txtHo = new JLabel("new lbl");
			txtHo.setForeground(new Color(0, 0, 255));
			txtHo.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtHo.setBounds(381, 21, 109, 31);
			txtHo.setText(list.get(index).getHo());
			pnNhanvien.add(txtHo);
			
			JLabel lblTen = new JLabel("Tên:");
			lblTen.setBounds(500, 22, 31, 29);
			pnNhanvien.add(lblTen);
			
			JLabel txtTen = new JLabel("new lbl");
			txtTen.setForeground(new Color(0, 0, 255));
			txtTen.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtTen.setBounds(541, 21, 109, 31);
			txtTen.setText(list.get(index).getTen());
			pnNhanvien.add(txtTen);
			
			JLabel lblGioiTinh = new JLabel("Giới Tính:");
			lblGioiTinh.setBounds(685, 13, 59, 47);
			pnNhanvien.add(lblGioiTinh);
			
			JLabel txtGioiTinh = new JLabel("new lbl");
			txtGioiTinh.setForeground(new Color(0, 0, 255));
			txtGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtGioiTinh.setBounds(755, 17, 69, 31);
			txtGioiTinh.setText(list.get(index).getGioiTinh());
			pnNhanvien.add(txtGioiTinh);
			
			JLabel lblDiachi = new JLabel("Địa Chỉ:");
			lblDiachi.setBounds(866, 11, 50, 47);
			pnNhanvien.add(lblDiachi);
			
			JLabel txtDiaChi = new JLabel("new lbl");
			txtDiaChi.setForeground(new Color(0, 0, 255));
			txtDiaChi.setVerticalAlignment(SwingConstants.TOP);
			txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtDiaChi.setBounds(926, 28, 170, 57);
			txtDiaChi.setText(list.get(index).getDiaChi());
			pnNhanvien.add(txtDiaChi);
			
			JLabel txtSoDT = new JLabel("new lbl");
			txtSoDT.setForeground(new Color(0, 0, 255));
			txtSoDT.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtSoDT.setBounds(247, 73, 152, 31);
			txtSoDT.setText(list.get(index).getDienThoai());
			pnNhanvien.add(txtSoDT);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(453, 75, 39, 24);
			pnNhanvien.add(lblEmail);
			
			JLabel txtEmail = new JLabel("new lbl");
			txtEmail.setForeground(new Color(0, 0, 255));
			txtEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtEmail.setBounds(502, 72, 211, 31);
			txtEmail.setText(list.get(index).getEmai());
			pnNhanvien.add(txtEmail);
			
			JLabel lblLuong = new JLabel("Lương:");
			lblLuong.setBounds(723, 75, 50, 24);
			pnNhanvien.add(lblLuong);
			
			JLabel txtLuong = new JLabel("new lbl");
			txtLuong.setForeground(new Color(0, 0, 255));
			txtLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtLuong.setBounds(771, 73, 134, 31);
			txtLuong.setText(String.valueOf(list.get(index).getLuong()));
			pnNhanvien.add(txtLuong);
			
			JLabel lblChucVu = new JLabel("Chức Vụ:");
			lblChucVu.setBounds(148, 119, 59, 24);
			pnNhanvien.add(lblChucVu);
			
			JLabel lblWriteChucvu = new JLabel("Quản Lý");
			lblWriteChucvu.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblWriteChucvu.setForeground(new Color(0, 0, 255));
			lblWriteChucvu.setBounds(246, 120, 304, 24);
			lblWriteChucvu.setText(list.get(index).getChucVu());
			pnNhanvien.add(lblWriteChucvu);
			
			pnNhanvien.addMouseListener(new MouseListener() {
				
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
					// TODO Auto-generated method stu
					JOptionPane.showMessageDialog(null, "Mã Nhân Viên" + list.get(index).getMaNV());
				
				}
			});

			
	        return pnNhanvien;
	    }
	
}
