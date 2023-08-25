package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DAO.*;
import GUI.*;
import DTO.*;
public class SanPhamCTRL {
	
	List<SanPhamDTO> listsp = new ArrayList<SanPhamDTO>();
	List<MauDTO> listmau = new ArrayList<MauDTO>();
	List<XuatXuDTO> listxx = new ArrayList<XuatXuDTO>();
	List<ThuongHieuDTO> listth = new ArrayList<ThuongHieuDTO>();
	List<LoaiDTO> listloai = new ArrayList<LoaiDTO>();
	
	SanPhamDAO sp = new SanPhamDAO();
	MauDAO mau = new MauDAO();
	XuatXuDAO xuatxu = new XuatXuDAO();
	ThuongHieuDAO th = new ThuongHieuDAO();
	LoaiDAO loai = new LoaiDAO();
	
	public void getAll() throws SQLException{
		listsp = sp.select();
		listmau = mau.select();
		listxx = xuatxu.select();
		listth = th.select();
		listloai = loai.select();
	}
	
	
	public void insert() throws SQLException {
		SanPhamDTO spDTO =getModel();
		sp.Insert(spDTO);
		listsp.clear();
		listsp = sp.select();
		filltable();
	}
	public void deleteByma(String ma) throws SQLException {
		sp.DeleteByMa(ma);
		listsp.clear();
		listsp = sp.select();
		filltable();
	}
	public void update() throws SQLException {
		SanPhamDTO spDTO =getModel();
		sp.Update(spDTO);
		listsp.clear();
		listsp = sp.select();
		filltable();
	}
	
	public void filltable() throws SQLException{
		DefaultTableModel model = (DefaultTableModel) PNSanphamGUI.tblsanpham.getModel();
		model.setRowCount(0);
		for(SanPhamDTO sp:listsp) {
			Object[] op = new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getSoluong(),sp.getGia(),sp.getSize(),sp.getDoituong(),sp.getChatLieu(),sp.getMaLoai(),sp.getMaxx(),sp.getMamau(),sp.getMaTH()};
			model.addRow(op);
		}
	}
	
	
	public void fillcomboBox() throws SQLException {
		for(MauDTO mau:listmau) {
			PNSanphamGUI.comMamau.addItem(mau.getMamau());
			PNSanphamGUI.comTKMamau.addItem(mau.getMamau());
		}
		for(XuatXuDTO xuatxu:listxx) {
			PNSanphamGUI.comMaxx.addItem(xuatxu.getMaxx());
			PNSanphamGUI.comTKMaxx.addItem(xuatxu.getMaxx());
		}
		for(ThuongHieuDTO th:listth) {
			PNSanphamGUI.comMaTT.addItem(th.getMathuonghieu());
			PNSanphamGUI.comTKMaTT.addItem(th.getMathuonghieu());
		}
		for(LoaiDTO loai:listloai) {
			PNSanphamGUI.comMaloai.addItem(loai.getMaloai());
			PNSanphamGUI.comTKMaloai.addItem(loai.getMaloai());
		}

	}
	
	public void reset() {
		PNSanphamGUI.txtMagiay.setText("");
		PNSanphamGUI.txtTengiay.setText("");
		PNSanphamGUI.txtSoluong.setText("");
		PNSanphamGUI.txtGia.setText("");
		PNSanphamGUI.txtSize.setText("");
		PNSanphamGUI.txtDoituong.setText("");
		PNSanphamGUI.txtChatlieu.setText("");
		PNSanphamGUI.comMaloai.setSelectedIndex(0);
		PNSanphamGUI.comMaxx.setSelectedIndex(0);
		PNSanphamGUI.comMamau.setSelectedIndex(0);
		PNSanphamGUI.comMaTT.setSelectedIndex(0);
	}
	
	public void setModel() throws SQLException {
		int index = PNSanphamGUI.tblsanpham.getSelectedRow();
		listsp.clear();
		listsp = sp.select();
		PNSanphamGUI.txtMagiay.setText(listsp.get(index).getMaSP());
		PNSanphamGUI.txtTengiay.setText(listsp.get(index).getTenSP());
		PNSanphamGUI.txtSoluong.setText(String.valueOf(listsp.get(index).getSoluong()));
		PNSanphamGUI.txtGia.setText(String.valueOf(listsp.get(index).getGia()));
		PNSanphamGUI.txtSize.setText(String.valueOf(listsp.get(index).getSize()));
		PNSanphamGUI.txtDoituong.setText(listsp.get(index).getDoituong());
		PNSanphamGUI.txtChatlieu.setText(listsp.get(index).getChatLieu());
		PNSanphamGUI.comMaloai.setSelectedItem(listsp.get(index).getMaLoai());
		PNSanphamGUI.comMaxx.setSelectedItem(listsp.get(index).getMaxx());
		PNSanphamGUI.comMamau.setSelectedItem(listsp.get(index).getMamau());
		PNSanphamGUI.comMaTT.setSelectedItem(listsp.get(index).getMaTH());
	}
	
	public SanPhamDTO getModel() {
		SanPhamDTO sp = new SanPhamDTO();
		sp.setMaSP(PNSanphamGUI.txtMagiay.getText());
		sp.setTenSP(PNSanphamGUI.txtTengiay.getText());
		sp.setSoluong(Integer.parseInt(PNSanphamGUI.txtSoluong.getText()));
		sp.setGia(Double.parseDouble(PNSanphamGUI.txtGia.getText()));
		sp.setSize(Integer.parseInt(PNSanphamGUI.txtSize.getText()));
		sp.setDoituong(PNSanphamGUI.txtDoituong.getText());
		sp.setChatLieu(PNSanphamGUI.txtChatlieu.getText());
		sp.setMaLoai((String) PNSanphamGUI.comMaloai.getSelectedItem());
		sp.setMaxx((String) PNSanphamGUI.comMaxx.getSelectedItem());
		sp.setMamau((String) PNSanphamGUI.comMamau.getSelectedItem());
		sp.setMaTH((String) PNSanphamGUI.comMaTT.getSelectedItem());
		return sp;
	}
	
}
