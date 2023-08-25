package Controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.*;
import DTO.*;
import GUI.*;

public class TrangCaNhanCTRL {
	NhanVienDAO nvDao = new NhanVienDAO();
	
	public void Find() throws SQLException {
		String ID = QuanLyGUI.lblidAn.getText();
		NhanVienDTO nv = nvDao.findById(ID);
		if(nv!=null) {
			setModel(nv);
		}
	}
	
	public void Update() throws SQLException {
		NhanVienDTO nv = getModel();
		nvDao.Update(nv);
		JOptionPane.showMessageDialog(null, "Update Thành Công");
		Find();
	}

	public void setModel(NhanVienDTO model) {
		FrameTrangCaNhan.txtMaNV.setText(model.getMaNV());
		FrameTrangCaNhan.txtHo.setText(model.getHo());
		FrameTrangCaNhan.txtTen.setText(model.getTen());
		FrameTrangCaNhan.txtGioiTinh.setText(model.getGioiTinh());
		FrameTrangCaNhan.txtDiachi.setText(model.getDiaChi());
		FrameTrangCaNhan.txtDienThoai.setText(model.getDienThoai());
		FrameTrangCaNhan.txtEmail.setText(model.getEmai());
		FrameTrangCaNhan.txtLuong.setText(String.valueOf(model.getLuong()));
		FrameTrangCaNhan.txtChucvu.setText(model.getChucVu());
		FrameTrangCaNhan.lblanh.setIcon(new ImageIcon(model.getAnh()));
		FrameTrangCaNhan.path = model.getAnh();
	}

	public NhanVienDTO getModel() {
		NhanVienDTO model = new NhanVienDTO();
		model.setMaNV(FrameTrangCaNhan.txtMaNV.getText());
		model.setHo(FrameTrangCaNhan.txtHo.getText());
		model.setTen(FrameTrangCaNhan.txtTen.getText());
		model.setGioiTinh(FrameTrangCaNhan.txtGioiTinh.getText());
		model.setDiaChi(FrameTrangCaNhan.txtDiachi.getText());
		model.setDienThoai(FrameTrangCaNhan.txtDienThoai.getText());
		model.setEmai(FrameTrangCaNhan.txtEmail.getText());
		model.setLuong(Integer.parseInt(FrameTrangCaNhan.txtLuong.getText()));
		model.setChucVu(FrameTrangCaNhan.txtChucvu.getText());
		model.setAnh(FrameTrangCaNhan.path);
		return model;
	}
}
