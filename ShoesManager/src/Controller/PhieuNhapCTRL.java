package Controller;

import java.awt.Dialog;
import java.rmi.Remote;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import org.apache.poi.openxml4j.opc.TargetMode;

import DAO.ConnectionSQL;
import DAO.*;
import GUI.PNHoadonGUI;
import GUI.PNPhieunhapGUI;
import DTO.*;

public class PhieuNhapCTRL {
	List<NhaCCDTO> listNCC = new ArrayList<NhaCCDTO>();
	List<PhieuNhapDTO> listpn = new ArrayList<>();
	PhieuNhapDAO pn = new PhieuNhapDAO();
	NhaCCDAO ncc = new NhaCCDAO();
	DefaultTableModel model = new DefaultTableModel();
	int index = 0;
	ConnectionSQL con = new ConnectionSQL();
	PreparedStatement ps;
	ResultSet rs;


	public void getAll() throws SQLException {
		listpn = pn.select();
		listNCC = ncc.select();

	}

	public void fillcombo() {
		for(NhaCCDTO ncc:listNCC) {
			PNPhieunhapGUI.comManhacungcap.addItem(ncc.getMancc());
		}

	}

	public void fillDataToTable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) PNPhieunhapGUI.tblBangphieunhap.getModel();
		model.setRowCount(0);
		for (PhieuNhapDTO dspn : listpn) {
			Object[] pn = new Object[] { dspn.getMapn(), dspn.getMancc(), dspn.getManv(), dspn.getNgaynhap(),
					dspn.getTongtien() };
			model.addRow(pn);
		}
	}

	public void insert() throws SQLException {
		PhieuNhapDTO pnDTO = getModel();
		pn.insert(pnDTO);
		listpn.clear();
		getAll();
		fillDataToTable();
		JOptionPane.showMessageDialog(null, "Thêm thành công");
	}

	public void update() throws SQLException {
		index = PNPhieunhapGUI.tblBangphieunhap.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn hàng để sửa");

		} else {
			PhieuNhapDTO pnDTO = getModel();
			pn.update(pnDTO);
			listpn.clear();
			getAll();
			fillDataToTable();
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		}
	}

	public void fillDataTextFill() {
		try {
			int index = PNPhieunhapGUI.tblBangphieunhap.getSelectedRow();
			PNPhieunhapGUI.txtMaphieunhap.setText(listpn.get(index).getMapn());
			PNPhieunhapGUI.comManhacungcap.setSelectedItem(listpn.get(index).getMancc());
			PNPhieunhapGUI.txtManhanvien.setText(listpn.get(index).getManv());
			PNPhieunhapGUI.dateNgaynhap.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(listpn.get(index).getNgaynhap()));
			PNPhieunhapGUI.txtTongtien.setText(listpn.get(index).getTongtien());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void Delete() throws SQLException {
		index = PNPhieunhapGUI.tblBangphieunhap.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng tự xóa");
		} else {
			PhieuNhapDTO pnDTO = getModel();
			pn.delete(pnDTO);
			listpn.clear();
//		listpn.remove(index);
			getAll();
			fillDataToTable();
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		}
	}

	public void Lammoi() {
		PNPhieunhapGUI.txtMaphieunhap.setText("");
		PNPhieunhapGUI.txtManhanvien.setText("");
		PNPhieunhapGUI.txtTongtien.setText("");
	}

	public void setModel(PhieuNhapDTO pn) {
		try {
			PNPhieunhapGUI.txtMaphieunhap.setText(pn.getMapn());
			PNPhieunhapGUI.comManhacungcap.setSelectedItem(pn.getMancc());
			PNPhieunhapGUI.txtManhanvien.setText(pn.getManv());
			PNPhieunhapGUI.dateNgaynhap.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pn.getNgaynhap()));
			PNPhieunhapGUI.txtTongtien.setText(pn.getTongtien());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public PhieuNhapDTO getModel() {
		PhieuNhapDTO pn = new PhieuNhapDTO();
		pn.setMapn(PNPhieunhapGUI.txtMaphieunhap.getText());
		pn.setMancc((String) PNPhieunhapGUI.comManhacungcap.getSelectedItem());
		pn.setManv(PNPhieunhapGUI.txtManhanvien.getText());
		Date dt = PNPhieunhapGUI.dateNgaynhap.getDate();
		String fm = new SimpleDateFormat("yyyy-MM-dd").format(dt);
		pn.setNgaynhap(fm);
		pn.setTongtien(PNPhieunhapGUI.txtTongtien.getText());
		return pn;
	}

}
