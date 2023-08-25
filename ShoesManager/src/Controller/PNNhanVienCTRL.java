package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.LoginDAO;
import DAO.NhanVienDAO;

import java.sql.SQLException;
import java.util.*;
import DTO.NhanVienDTO;
import GUI.PNNhanvienGUI;
import GUI.ThemsuaNVGUI;

public class PNNhanVienCTRL {
	List<NhanVienDTO> list = new ArrayList<>();
	NhanVienDAO nv = new NhanVienDAO();
	LoginDAO lg = new LoginDAO();
	
public List<NhanVienDTO> getAll() throws SQLException {
	
	list =nv.select();
	return list;
}

	

	public void insert() throws SQLException{
		
		NhanVienDTO nvDTO = getModel();
		nv.insert(nvDTO);
		lg.Insert(nvDTO.getMaNV());
		list.clear();
		getAll();
		JOptionPane.showMessageDialog(null, "Thêm Nhân Viên Thành Công");
	}
	public void Update() throws SQLException{
		NhanVienDTO nvDTO = getModel();
		nv.Update(nvDTO);
		list.clear();
		getAll();
		JOptionPane.showMessageDialog(null, "Sửa Nhân Viên Thành Công");
	}
	
	public void setModel(NhanVienDTO model) {
		try {
			ThemsuaNVGUI.txtMa.setText(model.getMaNV());
			ThemsuaNVGUI.txtHo.setText(model.getHo());
			ThemsuaNVGUI.txtTen.setText(model.getTen());
			ThemsuaNVGUI.rdoNam.setText(model.getGioiTinh());
			ThemsuaNVGUI.rdoNu.setText(model.getGioiTinh());
			ThemsuaNVGUI.txtDiachi.setText(model.getDiaChi());
			ThemsuaNVGUI.txtDienthoai.setText(model.getDienThoai());
			ThemsuaNVGUI.txtEmail.setText(model.getEmai());
			ThemsuaNVGUI.txtLuong.setText(String.valueOf(model.getLuong()));
			ThemsuaNVGUI.txtChucvu.setText(model.getChucVu());
			ThemsuaNVGUI.path = model.getAnh();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public  NhanVienDTO getModel() {
		NhanVienDTO model = new NhanVienDTO();
		model.setMaNV(ThemsuaNVGUI.txtMa.getText());
		model.setHo(ThemsuaNVGUI.txtHo.getText());
		model.setTen(ThemsuaNVGUI.txtTen.getText());
		model.setGioiTinh(ThemsuaNVGUI.rdoNam.getText());
		model.setGioiTinh(ThemsuaNVGUI.rdoNu.getText());
		model.setDiaChi(ThemsuaNVGUI.txtDiachi.getText());
		model.setDienThoai(ThemsuaNVGUI.txtDienthoai.getText());
		model.setEmai(ThemsuaNVGUI.txtEmail.getText());
		model.setLuong(Integer.parseInt(ThemsuaNVGUI.txtLuong.getText()));
		model.setChucVu(ThemsuaNVGUI.txtChucvu.getText());
		model.setAnh(ThemsuaNVGUI.path);
		return model;
	}
	public void DeleteNV() throws SQLException {
		String ID = JOptionPane.showInputDialog("Nhập Vào Nhân Viên Cần Xóa");
		if(CheckID(ID)==true) {
			nv.DeleNhanvien(ID);
			JOptionPane.showMessageDialog(null, "Xóa Thành Công");
			new PNNhanvienGUI();
		}else {
			JOptionPane.showMessageDialog(null, "Không Có Nhân Viên Trong Danh Sách");
		}
	}
	public Boolean CheckID(String ID) throws SQLException {
		List<NhanVienDTO> list = new ArrayList<>();
		list = nv.FindDataByID(ID);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}

}
