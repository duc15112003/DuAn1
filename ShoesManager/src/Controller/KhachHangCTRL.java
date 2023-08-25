package Controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.*;
import DTO.*;
import GUI.*;
import java.sql.*;

public class KhachHangCTRL {
	
	List<KhachHangDTO> listkh = new ArrayList<>();
	KhachHangDAO kh = new KhachHangDAO();
	DefaultTableModel model = new DefaultTableModel();
	ConnectionSQL con = new ConnectionSQL();
	PreparedStatement ps;
	ResultSet rs;
	int index = 0;

	public void getAll() throws SQLException {
		listkh = kh.select();
	}

	public void KH_fillDataToTable() throws SQLException {
		model = (DefaultTableModel) PNQuanLyKhachHangGUI.table_Bangkhachhang.getModel();
		model.setRowCount(0);
		for (KhachHangDTO dskh : listkh) {
			Object[] kh = new Object[] { dskh.getMaKH(), dskh.getHo(), dskh.getTen(), dskh.getGioiTinh(),
					dskh.getDiaChi(), dskh.getEmail(), dskh.getLoai(), dskh.getTongChiTieu() };
			model.addRow(kh);
		}

	}

	public void KH_fillDataTextFill() throws SQLException {
		try {
			index = PNQuanLyKhachHangGUI.table_Bangkhachhang.getSelectedRow();
			PNQuanLyKhachHangGUI.txtThongtin_maKH.setText(listkh.get(index).getMaKH());
			PNQuanLyKhachHangGUI.txtThongtin_Ho.setText(listkh.get(index).getHo());
			PNQuanLyKhachHangGUI.txtThongtin_Ten.setText(listkh.get(index).getTen());
			PNQuanLyKhachHangGUI.txtThongtin_Gioitinh.setText(listkh.get(index).getGioiTinh());
			PNQuanLyKhachHangGUI.txtThongtin_Diachi.setText(listkh.get(index).getDiaChi());
			PNQuanLyKhachHangGUI.txtThongtin_Email.setText(listkh.get(index).getEmail());
			PNQuanLyKhachHangGUI.txtThongtin_Loai.setText(listkh.get(index).getLoai());
			PNQuanLyKhachHangGUI.txtThongtin_Tongct.setText(String.valueOf(listkh.get(index).getTongChiTieu()));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void KH_insert() throws SQLException {
		try {
			KhachHangDTO khDTO = getModel();
			kh.insert(khDTO);
			listkh.clear();
			getAll();
			KH_fillDataToTable();
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi truy vấn");
		}

	}

	public void KH_update() {
		index = PNQuanLyKhachHangGUI.table_Bangkhachhang.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn hàng để sửa");
		} else {
			try {
				KhachHangDTO khDTO = getModel();
				kh.Update(khDTO);
				listkh.clear();
				getAll();
				KH_fillDataToTable();
				JOptionPane.showMessageDialog(null, "Sửa thành công");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Lỗi truy vấn");
			}
		}
	}

	public void Lammoi_thongtin() {
		PNQuanLyKhachHangGUI.txtThongtin_maKH.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Ho.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Ten.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Gioitinh.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Diachi.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Email.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Loai.setText("");
		PNQuanLyKhachHangGUI.txtThongtin_Tongct.setText("");

	}

	public void Lammoi_timkiem() {
		PNQuanLyKhachHangGUI.txtTimkiemMaKH.setText("");
		PNQuanLyKhachHangGUI.txtTimkiem_Loai.setText("");
		PNQuanLyKhachHangGUI.txtTimkiem_Tongct1.setText("");
		PNQuanLyKhachHangGUI.txtTimkiemTongCT2.setText("");

	}

	public void KH_Xoa() throws SQLException {
		index = PNQuanLyKhachHangGUI.table_Bangkhachhang.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn hàng để xóa");

		} else {
			KhachHangDTO khDTO = getModel();
			kh.Delete(khDTO);
			listkh.clear();
			getAll();
			KH_fillDataToTable();
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		}
	}

	public void timkiem() throws SQLException {
		String timkiem1 = PNQuanLyKhachHangGUI.txtTimkiemMaKH.getText();
		String timkiem2 = PNQuanLyKhachHangGUI.txtTimkiem_Loai.getText();
		String timkiem3 = PNQuanLyKhachHangGUI.txtTimkiem_Tongct1.getText();
		String timkiem4 = PNQuanLyKhachHangGUI.txtTimkiemTongCT2.getText();
		if (timkiem1.equals("") && timkiem2.equals("") && timkiem3.equals("") && timkiem4.equals("")) {
			JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm");

		} else if (timkiem1.equals("") && timkiem2.equals("") && !timkiem3.equals("") && !timkiem4.equals("")) {
			String tong1 = (timkiem3);
			String tong2 = (timkiem4);
			listkh = kh.timkiemtongchitieu(tong1, tong2);
			KH_fillDataToTable();

		} else if (!timkiem1.equals("") && timkiem2.equals("") && timkiem3.equals("") && timkiem4.equals("")) {
			listkh = kh.TimkiemID(timkiem1);
			KH_fillDataToTable();

		} else if (timkiem1.equals("") && !timkiem2.equals("") && timkiem3.equals("") && timkiem4.equals("")) {
			listkh = kh.Timkiemloai(timkiem2);
			KH_fillDataToTable();
			
		} else if (!timkiem1.equals("") && !timkiem2.equals("") && timkiem3.equals("") && timkiem4.equals("")) {
			listkh = kh.TimkiemTen_Loai(timkiem1, timkiem2);
			KH_fillDataToTable();

			
		} else if (!timkiem1.equals("") && !timkiem3.equals("") && !timkiem4.equals("")) {
			String s1 = (timkiem3);
			String s2 = (timkiem4);
			listkh = kh.timkiemMakh_tongct(timkiem1, s1, s2);
			KH_fillDataToTable();
			
		} else if (!timkiem2.equals("") && !timkiem3.equals("") && !timkiem4.equals("")) {
			String s1 = (timkiem3);
			String s2 = (timkiem4);
			listkh = kh.timkiemvip_tongct(timkiem2, s1, s2);
			KH_fillDataToTable();
			
			
		}else if (  !timkiem1.equals("")  &&  !timkiem2.equals("") && !timkiem3.equals("") && !timkiem4.equals("")) {
			String s1 = (timkiem3);
			String s2 = (timkiem4);
			listkh = kh.timkiemAll(timkiem1 , timkiem2 , s1, s2);
			KH_fillDataToTable();
	}
	};
	public void huytimkiem() throws SQLException {
		getAll();
		KH_fillDataToTable();

	}

	public void setModel(KhachHangDTO kh) {
		try {
			PNQuanLyKhachHangGUI.txtThongtin_maKH.setText(kh.getMaKH());
			PNQuanLyKhachHangGUI.txtThongtin_Ho.setText(kh.getHo());
			PNQuanLyKhachHangGUI.txtThongtin_Ten.setText(kh.getTen());
			PNQuanLyKhachHangGUI.txtThongtin_Diachi.setText(kh.getDiaChi());
			PNQuanLyKhachHangGUI.txtThongtin_Email.setText(kh.getEmail());
			PNQuanLyKhachHangGUI.txtThongtin_Loai.setText(kh.getLoai());
			PNQuanLyKhachHangGUI.txtThongtin_Tongct.setText(String.valueOf(kh.getTongChiTieu()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public KhachHangDTO getModel() {
		KhachHangDTO kh = new KhachHangDTO();
		kh.setMaKH(PNQuanLyKhachHangGUI.txtThongtin_maKH.getText());
		kh.setHo(PNQuanLyKhachHangGUI.txtThongtin_Ho.getText());
		kh.setTen(PNQuanLyKhachHangGUI.txtThongtin_Ten.getText());
		kh.setGioiTinh(PNQuanLyKhachHangGUI.txtThongtin_Gioitinh.getText());
		kh.setDiaChi(PNQuanLyKhachHangGUI.txtThongtin_Diachi.getText());
		kh.setEmail(PNQuanLyKhachHangGUI.txtThongtin_Email.getText());
		kh.setLoai(PNQuanLyKhachHangGUI.txtThongtin_Loai.getText());
		kh.setTongChiTieu(Double.parseDouble(PNQuanLyKhachHangGUI.txtThongtin_Tongct.getText()));
		return kh;

	}

}
