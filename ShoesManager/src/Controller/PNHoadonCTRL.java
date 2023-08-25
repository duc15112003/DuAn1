package Controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.HoaDonChiTietDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.KhuyenMaiDAO;
import DTO.*;
import GUI.PNHoadonGUI;
 
public class PNHoadonCTRL {

	List<HoaDonDTO> list = new ArrayList<>();
	List<KhachHangDTO> listkh = new ArrayList<>();
	List<KhuyenMaiDTO> listkm = new ArrayList<>();
	List<ChiTietHDDTO> listct = new ArrayList<>();
	HoaDonChiTietDAO cthd = new HoaDonChiTietDAO();
	HoaDonDAO hd = new HoaDonDAO();
	KhachHangDAO kh = new KhachHangDAO();
	KhuyenMaiDAO km = new KhuyenMaiDAO();

	// ------- hóa đơn----------//

	public List<HoaDonDTO> getAll() throws SQLException {
		list = hd.select();
		return list;
	}

	public List<KhachHangDTO> getAllKH() throws SQLException {
		listkh = kh.select();
		return listkh;
	}

	public void filltoTable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) PNHoadonGUI.tblhoadon.getModel();
		model.setRowCount(0);
		for (HoaDonDTO hd : list) {
			Object[] ob = new Object[] { hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getMaKM(), hd.getNgayBan(),
					hd.getTongTien() };
			model.addRow(ob);
		}
	}

	public void fillToComHoaDonKM() {
		try {
			listkm = km.select();
			for (KhuyenMaiDTO km : listkm) {
				PNHoadonGUI.comMakhuyenmai.addItem(km.getMaKM());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillToComHoaDon() {
		for (KhachHangDTO kh : listkh) {
			PNHoadonGUI.comMakhachhang.addItem(kh.getMaKH());
		}
	}

	public void Insert() throws SQLException {
		HoaDonDTO hdDTO = getModel();
		hd.insert(hdDTO);
		list.clear();
		list = hd.select();
		filltoTable();
	}

	public void Update() throws SQLException {
		HoaDonDTO hdDTO = getModel();
		hd.Update(hdDTO);
		list.clear();
		list = hd.select();
		filltoTable();
	}

	public void fillwhenClickedHoaDon() {
		try {
			getAll();
			int index = PNHoadonGUI.tblhoadon.getSelectedRow();
			PNHoadonGUI.txtMahoadon.setText(list.get(index).getMaHD());
			PNHoadonGUI.comMakhachhang.setSelectedItem(list.get(index).getMaKH());
			PNHoadonGUI.txtManhanvien.setText(list.get(index).getMaNV());
			PNHoadonGUI.comMakhuyenmai.setSelectedItem(list.get(index).getMaKM());
			PNHoadonGUI.txtTongtien.setText(String.valueOf(list.get(index).getTongTien()));
			PNHoadonGUI.dateNgayban.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(list.get(index).getNgayBan()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteHDCTAll() throws SQLException {
		String id = PNHoadonGUI.txtMahoadon.getText();
		cthd.DeleteAllByID(id);
		listct.clear();
		getFullList();
		FilltoTable();
	}

	public void Delete() throws SQLException {
		HoaDonDTO hdDonDTO = getModel();
		hd.delete(hdDonDTO);
		list.clear();
		list = hd.select();
		filltoTable();
	}

	public void New() {
		try {
			PNHoadonGUI.txtMahoadon.setText("");
			PNHoadonGUI.txtManhanvien.setText("");
			PNHoadonGUI.comMakhachhang.setSelectedItem("KH1");
			Date dt = new Date();
			String s = new SimpleDateFormat("yyyy-MM-dd").format(dt);
			PNHoadonGUI.comMakhuyenmai.setSelectedItem("KM1");
			PNHoadonGUI.dateNgayban.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(s));
			PNHoadonGUI.txtTongtien.setText("");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public HoaDonDTO getModel() {
		HoaDonDTO model = new HoaDonDTO();
		model.setMaHD(PNHoadonGUI.txtMahoadon.getText());
		model.setMaNV(PNHoadonGUI.txtManhanvien.getText());
		model.setMaKH((String) PNHoadonGUI.comMakhachhang.getSelectedItem());
		model.setMaKM((String) PNHoadonGUI.comMakhuyenmai.getSelectedItem());
		Date dt = PNHoadonGUI.dateNgayban.getDate();
		String fm = new SimpleDateFormat("yyyy-MM-dd").format(dt);
		model.setNgayBan(fm);
		model.setTongTien(Double.parseDouble(PNHoadonGUI.txtTongtien.getText()));

		return model;
	}

	// ------- chi tiết hóa đơn----------//

	public List<ChiTietHDDTO> getFullList() throws SQLException {
		listct = cthd.select();
		return listct;
	}

	public void InsertHDCT() throws SQLException {
		ChiTietHDDTO CthdDTO = getModel1();
		cthd.Insert(CthdDTO);
		listct.clear();
		getFullList();
		FilltoTable();
	}

	public void UpdateHDCT() throws SQLException {
		ChiTietHDDTO CthdDTO = getModel1();
		cthd.Update(CthdDTO);
		listct.clear();
		getFullList();
		FilltoTable();
	}

	public void DeleHDCT() throws SQLException {
		ChiTietHDDTO CthdDTO = getModel1();
		cthd.Delete(CthdDTO);
		listct.clear();
		getFullList();
		FilltoTable();
	}

	public void fillwhenClickedHoaDonCT() {
		try {
			getFullList();
			int index = PNHoadonGUI.tblhoadonCT.getSelectedRow();
			PNHoadonGUI.txtMaspchitiet.setText(listct.get(index).getMaGiay());
			PNHoadonGUI.txtMaHDchitiet.setText(listct.get(index).getMaHD());
			PNHoadonGUI.txtSoluongchitiet.setText(String.valueOf(listct.get(index).getSoLuong()));
			PNHoadonGUI.txtGiabanchitiet.setText(String.valueOf(listct.get(index).getGiaBan()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void FindHD() throws SQLException {
		String condition1 = PNHoadonGUI.txtMaSPtimkiem.getText();
		String condition2 = PNHoadonGUI.txtSoluongbatdau.getText();
		String condition2_1 = PNHoadonGUI.txtSoluongketthuc.getText();
		if (condition1.equals("") && condition2.equals("") && condition2_1.equals("")) {
			JOptionPane.showMessageDialog(null, "chưa điền điều kiện tìm kiếm");
		} else if (condition1.equals("") && !condition2.equals("") && !condition2_1.equals("")) {
			int s1 = Integer.parseInt(condition2);
			int s2 = Integer.parseInt(condition2_1);
			listct = cthd.FindProductbyCount(s1, s2);
			FilltoTable();
		} else if (!condition1.equals("") && condition2.equals("") && condition2_1.equals("")) {
			listct = cthd.FindbyID(condition1);
			FilltoTable();
		} else if (!condition1.equals("") && !condition2.equals("") && !condition2_1.equals("")) {
			int s1 = Integer.parseInt(condition2);
			int s2 = Integer.parseInt(condition2_1);
			listct = cthd.FindByIDandCount(condition1, s1, s2);
			FilltoTable();
		}
	}

	public void FilltoTable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) PNHoadonGUI.tblhoadonCT.getModel();
		model.setRowCount(0);
		for (ChiTietHDDTO cthd : listct) {
			Object[] ob = new Object[] { cthd.getMaGiay(), cthd.getMaHD(), cthd.getSoLuong(), cthd.getGiaBan() };
			model.addRow(ob);
		}
	}

	public void setModel(ChiTietHDDTO model) {
		try {
			PNHoadonGUI.txtMaspchitiet.setText(model.getMaGiay());
			PNHoadonGUI.txtMaHDchitiet.setText(model.getMaHD());
			PNHoadonGUI.txtSoluongchitiet.setText(String.valueOf(model.getSoLuong()));
			PNHoadonGUI.txtGiabanchitiet.setText(String.valueOf(model.getGiaBan()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ChiTietHDDTO getModel1() {
		ChiTietHDDTO model = new ChiTietHDDTO();
		model.setMaGiay(PNHoadonGUI.txtMaspchitiet.getText());
		model.setMaHD(PNHoadonGUI.txtMaHDchitiet.getText());
		model.setSoLuong(Integer.parseInt(PNHoadonGUI.txtSoluongchitiet.getText()));
		model.setGiaBan(Integer.parseInt(PNHoadonGUI.txtGiabanchitiet.getText()));
		return model;
	}

}
