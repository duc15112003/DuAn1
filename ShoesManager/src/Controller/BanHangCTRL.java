package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.*;
import DTO.*;
import GUI.ChitietSP;
import GUI.PNBanHangGUI;

public class BanHangCTRL {

	List<KhuyenMaiDTO> listkm = new ArrayList<KhuyenMaiDTO>();
	List<HoaDonDTO> listhd = new ArrayList<HoaDonDTO>();
	List<NhanVienDTO> listnv = new ArrayList<NhanVienDTO>();
	List<ChitietKMDTO> listctkm = new ArrayList<ChitietKMDTO>();
	List<SanPhamDTO> listsp = new ArrayList<>();
	List<LoaiDTO> listloai = new ArrayList<>();
	List<KhachHangDTO> listkh = new ArrayList<KhachHangDTO>();

	KhuyenMaiDAO km = new KhuyenMaiDAO();
	HoaDonDAO hd = new HoaDonDAO();
	NhanVienDAO nv = new NhanVienDAO();
	ChiTietKMDAO ctkm = new ChiTietKMDAO();
	SanPhamDAO spdao = new SanPhamDAO();
	LoaiDAO loaidao = new LoaiDAO();
	MauDAO mau = new MauDAO();
	XuatXuDAO xuatxu = new XuatXuDAO();
	HoaDonChiTietDAO hdctdao = new HoaDonChiTietDAO();
	ThuongHieuDAO th = new ThuongHieuDAO();
	KhachHangDAO khdao = new KhachHangDAO();

	public void GetAll() throws SQLException {
		listkm = km.select();
		listnv = nv.select();
		listhd = hd.select();
		listsp = spdao.select();
		listloai = loaidao.select();
	}

	public void InsertKhachHang() throws SQLException {
		KhachHangDTO khdto = getModelKhachHang();
		if (khdto.getTongChiTieu() == (Double.parseDouble(PNBanHangGUI.txtTongtien.getText()))) {
			khdao.insert(khdto);
		} else {
			khdao.Update(khdto);
		}
	}

	public void Insert() throws SQLException {
		InsertKhachHang();
		HoaDonDTO hdDTO = getModel();
		hd.insert(hdDTO);
		int index = PNBanHangGUI.tblChiTietHD.getRowCount();
		for (int i = 0; i < index; i++) {
			String masp = String.valueOf( PNBanHangGUI.tblChiTietHD.getValueAt(i, 0));
			String mahd = String.valueOf( PNBanHangGUI.txtMaHD.getText());
			int soluong = Integer.parseInt(String.valueOf(PNBanHangGUI.tblChiTietHD.getValueAt(i, 2))) ;
			Double giaban = Double.parseDouble(String.valueOf(PNBanHangGUI.tblChiTietHD.getValueAt(i, 3)));
			ChiTietHDDTO cthd = new ChiTietHDDTO(masp, mahd, soluong, giaban);
			hdctdao.Insert(cthd);
		}

		JOptionPane.showMessageDialog(null, "Thêm Thành Công");
	}

	public KhachHangDTO getModelKhachHang() throws SQLException {
		KhachHangDTO khdto = new KhachHangDTO();
		khdto.setMaKH(PNBanHangGUI.txtMaKH.getText());
		khdto.setHo(PNBanHangGUI.txtHo.getText());
		khdto.setTen(PNBanHangGUI.txtTenKH.getText());
		khdto.setGioiTinh(PNBanHangGUI.txtGT.getText());
		khdto.setDiaChi(PNBanHangGUI.txtDiachi.getText());
		khdto.setEmail(PNBanHangGUI.txtEmail.getText());
		khdto.setLoai("thường");
		double tongchi = tongchitieu(khdto.getMaKH());
		khdto.setTongChiTieu(tongchi);
		return khdto;
	}

	public double tongchitieu(String id) throws SQLException {
		double tongchi = 0;
		listkh = khdao.FindByID(id);
		if (listkh.size() == 0) {
			tongchi = Double.parseDouble(PNBanHangGUI.txtTongtien.getText());
		} else {
			tongchi = listkh.get(0).getTongChiTieu() + Double.parseDouble(PNBanHangGUI.txtTongtien.getText());
		}
		return tongchi;
	}

	public void setModel(HoaDonDTO model) {
		try {
			PNBanHangGUI.txtMaHD.setText(model.getMaHD());
			PNBanHangGUI.comMaNV.setSelectedItem(model.getMaNV());
			PNBanHangGUI.txtMaKH.setText(model.getMaKH());
			PNBanHangGUI.comKM.setSelectedItem(model.getMaKM());
			PNBanHangGUI.txtNgayTao.setText(model.getNgayBan());
			PNBanHangGUI.txtTongtien.setText(String.valueOf(model.getTongTien()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HoaDonDTO getModel() {
		HoaDonDTO model = new HoaDonDTO();
		model.setMaHD(PNBanHangGUI.txtMaHD.getText());
		model.setMaNV((String) PNBanHangGUI.comMaNV.getSelectedItem());
		model.setMaKH(PNBanHangGUI.txtMaKH.getText());
		model.setMaKM((String) PNBanHangGUI.comKM.getSelectedItem());
		model.setNgayBan(PNBanHangGUI.txtNgayTao.getText());
		model.setTongTien(Double.parseDouble(PNBanHangGUI.txtTongtien.getText()));
		return model;
	}
	// getModel, setModel của nhân viên

	public void FillCombo() throws SQLException {
		for (NhanVienDTO nv : listnv) {
			PNBanHangGUI.comMaNV.addItem(nv.getMaNV());
		}
		for (KhuyenMaiDTO km : listkm) {
			PNBanHangGUI.comKM.addItem(km.getMaKM());
		}
		for (LoaiDTO loai : listloai) {
			PNBanHangGUI.comLoai.addItem(loai.getMaloai());
		}
	}
	// Filldata cần thiết

	public void FillByLoai(String maloai) throws SQLException {
		listsp.clear();
		listsp = spdao.FillByLoaiDAO(maloai);
		if (listsp.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không có sản phẩm phù hơp");
		} else {
			filltable();
		}
	}

	public void fill() throws SQLException {
		// Fill mã HD tự động

		// Fill Mã Khuyến mại

		// Fill mã nhân viên

		// Fill ngày tự động
		Date dt = new Date();
		String s = new SimpleDateFormat("yyyy-MM-dd").format(dt);
		PNBanHangGUI.txtNgayTao.setText(s);
		// FillCombo();
	}

	public void FillWhenClickComKM(String ma) throws SQLException {

		if (ma.equals("Chọn") && PNBanHangGUI.tblChiTietHD.getRowCount() != 0) {
			PNBanHangGUI.txtTile.setText("0");
			doc();
		} else if (ma.equals("Chọn")) {
			PNBanHangGUI.txtTile.setText("0");
		} else {

			if (PNBanHangGUI.tblChiTietHD.getRowCount() != 0) {
				listctkm = ctkm.FindByID(ma);
				System.out.println(listctkm.size());
				PNBanHangGUI.txtTile.setText(String.valueOf(listctkm.get(0).getTile()));
				doc();
			} else {
				listctkm = ctkm.FindByID(ma);
				System.out.println(listctkm.size());
				PNBanHangGUI.txtTile.setText(String.valueOf(listctkm.get(0).getTile()));
			}
		}
	}

	public void filltable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) PNBanHangGUI.tblsanpham.getModel();
		model.setRowCount(0);
		for (SanPhamDTO sp : listsp) {
			Object[] ob = new Object[] { sp.getMaSP(), sp.getTenSP(), sp.getGia(), sp.getSoluong() };
			model.addRow(ob);
		}
	}

	public void fillFrame() throws SQLException {

		int index = PNBanHangGUI.tblsanpham.getSelectedRow();
		SanPhamDAO spdao = new SanPhamDAO();
		ChitietSP ct = new ChitietSP();
		// ct.setVisible(true);
		ct.lblMaSPTXT.setText(listsp.get(index).getMaSP());
		ct.llblTenSPTXT.setText(listsp.get(index).getTenSP());
		ct.lblSoluongTXT.setText(String.valueOf(listsp.get(index).getSoluong()));
		ct.lblSizeTXT.setText(String.valueOf(listsp.get(index).getSize()));
		ct.lblDoiTuongTXT.setText(listsp.get(index).getDoituong());
		ct.lblchatlieuTXT.setText(listsp.get(index).getChatLieu());
		ct.lblLoaiTXT.setText(loaidao.GetTenLoai(listsp.get(index).getMaLoai()));
		ct.lblxuatxuTXT.setText(xuatxu.GetXuatXu(listsp.get(index).getMaxx()));
		ct.lblThuongHieuTXT.setText(th.GetThuongHieu(listsp.get(index).getMaTH()));
		ct.lblMausacTXT.setText(mau.GetMauSac(listsp.get(index).getMamau()));
		ct.lblGiatienTXT.setText(String.valueOf(listsp.get(index).getGia()));
	}

	public void Filldatahoadon() {
		// TODO Auto-generated method stub

		String maSP = ChitietSP.lblMaSPTXT.getText();
		String tenSP = ChitietSP.llblTenSPTXT.getText();
		String soluongSP = String.valueOf(ChitietSP.spiSoluongMua.getValue());
		String dongiaSP = ChitietSP.lblGiatienTXT.getText();
		String thanhtienSP = ChitietSP.lblThanhtienTXT.getText();

		DefaultTableModel model = (DefaultTableModel) PNBanHangGUI.tblChiTietHD.getModel();
		Vector data = new Vector();
		data.add(maSP);
		data.add(tenSP);
		data.add(soluongSP);
		data.add(dongiaSP);
		data.add(thanhtienSP);

		model.addRow(data);

		double tongtien = 0;
		int sodong = PNBanHangGUI.tblChiTietHD.getColumnCount();

	}

	public void doc() {
		Double tongtien = (double) 0;
		for (int i = 0; i < PNBanHangGUI.tblChiTietHD.getRowCount(); i++) {
			DefaultTableModel model = (DefaultTableModel) PNBanHangGUI.tblChiTietHD.getModel();
			Double value = Double.parseDouble((String) model.getValueAt(i, 4));
			tongtien = tongtien + value;
		}
		double all = tongtien - tongtien * Double.parseDouble(PNBanHangGUI.txtTile.getText());
		PNBanHangGUI.txtTongtien.setText(String.valueOf(all));
		ChitietSP.frame.setVisible(false);

	}

	public void hamtinhtien() {
		ChitietSP ct = new ChitietSP();
		int slm = (int) ChitietSP.spiSoluongMua.getValue();
		int tong = slm * Integer.parseInt(ct.lblGiatienTXT.getText());
		ct.lblThanhtienTXT.setText(String.valueOf(tong));

	}

	public void tinhtien(int so) {
		double dongia = Double.parseDouble(ChitietSP.lblGiatienTXT.getText());
		double tongtien = dongia * so;
		ChitietSP.lblThanhtienTXT.setText(String.valueOf(tongtien));
	}

	public void check() {
		ChitietSP ct = new ChitietSP();
		SanPhamDAO spdao = new SanPhamDAO();
		int slm = (int) ChitietSP.spiSoluongMua.getValue();

		int slk = Integer.parseInt(ct.lblSoluongTXT.getText());
		String masp = ct.lblMaSPTXT.getText();
		if (slm > slk) {
			JOptionPane.showMessageDialog(null, "Không đủ số lượng trong kho");
		} else {
			int conlia = slk - slm;
			spdao.UpdateSP(conlia, masp);

		}

	}

	public void tienthua() {
		double tienthua = 0;
		double khachdua = Double.parseDouble(PNBanHangGUI.txtKhachDua.getText());
		double tongtien = Double.parseDouble(PNBanHangGUI.txtTongtien.getText());
		if (khachdua > tongtien) {
			tienthua = khachdua - tongtien;
			PNBanHangGUI.txtTienThua.setText(String.valueOf(Math.abs(Math.ceil(tienthua))));
		}

	}

	public void clearform() {
		PNBanHangGUI.txtMaHD.setText("");
		PNBanHangGUI.comMaNV.setSelectedIndex(0);
//	Panel.lblNgayTao.setText("");
		PNBanHangGUI.txtMaKH.setText("");
		PNBanHangGUI.txtHo.setText("");
		PNBanHangGUI.txtTenKH.setText("");
//	Panel.txtDi.setText("");
		PNBanHangGUI.txtEmail.setText("");
		PNBanHangGUI.comKM.setSelectedIndex(0);
		PNBanHangGUI.txtTile.setText("");
		PNBanHangGUI.txtTienThua.setText("");
		PNBanHangGUI.txtKhachDua.setText("");

	}

	public void xuathd(String path) {
		Document document = new Document(PageSize.A4, 50, 50, 50,10);
		try {

			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream(path));

			// Mở file để thực hiện ghi
			document.open();

			PdfPTable t = new PdfPTable(5);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("ID"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Name"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("Count of Product"));
			t.addCell(c3);
			PdfPCell c4 = new PdfPCell(new Phrase("Price"));
			t.addCell(c4);
			PdfPCell c5 = new PdfPCell(new Phrase("Total"));
			t.addCell(c5);
			
			int index = PNBanHangGUI.tblChiTietHD.getRowCount();
			for (int i = 0; i < index; i++) {
				String masp = (String) PNBanHangGUI.tblChiTietHD.getValueAt(i, 0);
				String tensp = (String) PNBanHangGUI.tblChiTietHD.getValueAt(i, 1);
				String soluong =  (String) PNBanHangGUI.tblChiTietHD.getValueAt(i, 2);
				String giaban = (String) PNBanHangGUI.tblChiTietHD.getValueAt(i, 3);
				String thanhtien = (String) PNBanHangGUI.tblChiTietHD.getValueAt(i, 4);
				t.addCell(masp);
				t.addCell(tensp);
				t.addCell(soluong);
				t.addCell(giaban);
				t.addCell(thanhtien);
			}
			

			document.add(t);
			document.add(new Paragraph("Discount : "+ PNBanHangGUI.txtTile.getText()));
			document.add(new Paragraph("Total All: "+ PNBanHangGUI.txtTongtien.getText()));
			document.close();
			
			JOptionPane.showMessageDialog(null, "Đã Xuất Hóa Đơn: Vui Lòng Tìm Kiếm Trong Thư Mục");
		} catch (FileNotFoundException | DocumentException e) {
			JOptionPane.showMessageDialog(null, "Có Lỗi, Vui Lòng Kiểm Tra Lại Thông Tin");
		}
	}

}
