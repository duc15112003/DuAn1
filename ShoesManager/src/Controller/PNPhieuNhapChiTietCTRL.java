package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DTO.PhieuNhapChiTietDTO;
import DTO.PhieuNhapDTO;
import GUI.PNPhieunhapGUI;
import DAO.ConnectionSQL;
import DAO.PhieuNhapChiTietDAO;

public class PNPhieuNhapChiTietCTRL {

	DefaultTableModel model = new DefaultTableModel();
	List<PhieuNhapChiTietDTO> listpnct = new ArrayList<>();
	PhieuNhapChiTietDAO pnct = new PhieuNhapChiTietDAO();
	int index = 0;
	PreparedStatement ps;
	Statement st;

	public List<PhieuNhapChiTietDTO> PNCT_getAll() throws SQLException {
		listpnct = pnct.select();
		return listpnct;

	}

	public void PNCT_fillDataToTable() {
		DefaultTableModel model = (DefaultTableModel) PNPhieunhapGUI.tblBangphieunhapchitiet.getModel();
		model.setRowCount(0);
		try {

			for (PhieuNhapChiTietDTO dspnct : listpnct) {
				Object[] pnct = new Object[] { dspnct.getMagiay(), dspnct.getMapn(), dspnct.getSoluong(),
						dspnct.getGianhap() };
				model.addRow(pnct);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void PNCT_fillDataTextFlied() {
		try {
			int index = PNPhieunhapGUI.tblBangphieunhapchitiet.getSelectedRow();
			PNPhieunhapGUI.txtChitietmasanpham.setText(listpnct.get(index).getMagiay());
			PNPhieunhapGUI.txtChitietmapn.setText(listpnct.get(index).getMapn());
			PNPhieunhapGUI.txtChitietsoluong.setText(listpnct.get(index).getSoluong());
			PNPhieunhapGUI.txtChitietgianhap.setText(listpnct.get(index).getGianhap());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void PNCT_Insert() throws SQLException {
		PhieuNhapChiTietDTO pnctDTO = getModel();
		pnct.insert(pnctDTO);
		listpnct.clear();
		PNCT_getAll();
		PNCT_fillDataToTable();
	}

	public void PNCT_Update() throws SQLException {
		int index = PNPhieunhapGUI.tblBangphieunhapchitiet.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột để sửa");
		} else {
			PhieuNhapChiTietDTO pnctDTO = getModel();
			pnct.update(pnctDTO);
			listpnct.clear();
			PNCT_getAll();
			PNCT_fillDataToTable();
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		}
	}

	public void PNCT_xoa() throws SQLException {
		int index = PNPhieunhapGUI.tblBangphieunhapchitiet.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột để xóa");
		} else {
			PhieuNhapChiTietDTO pnctDTO = getModel();
			pnct.Xoa(pnctDTO);
			listpnct.remove(index);
			listpnct.clear();
			PNCT_getAll();
			PNCT_fillDataToTable();
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		}
	}
	
	public void PNCT_XoaByID() {
		String id = PNPhieunhapGUI.txtMaphieunhap.getText();
		pnct.DeleteByID(id);
	}

	public void PNCT_timkiem() throws SQLException {
		String timkiem1 = PNPhieunhapGUI.txtMasanphamtimkiem.getText();
		String timkiem2 = PNPhieunhapGUI.txtSoluongdau.getText();
		String timkiem3 = PNPhieunhapGUI.txtSoluongcuoi.getText();
		if (timkiem1.equals("") && timkiem2.equals("") && timkiem3.equals("")) {
			JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm");
		} else if (timkiem1.equals("") && !timkiem2.equals("") && !timkiem3.equals("")) {
			int soluong1 = Integer.parseInt(timkiem2);
			int soluong2 = Integer.parseInt(timkiem3);
			listpnct = pnct.timkiemsoluong(soluong1, soluong2);
			PNCT_fillDataToTable();
		} else if (!timkiem1.equals("") && timkiem2.equals("") && timkiem3.equals("")) {
			listpnct = pnct.timkiemid(timkiem1);
			PNCT_fillDataToTable();

		}
	}

	public void PNCT_huytimkiem() throws SQLException {
		PNCT_getAll();
		PNCT_fillDataToTable();
		PNCT_lammoi();
		PNCT_lammoitimkiem();

	}

	public void PNCT_lammoitimkiem() {
		PNPhieunhapGUI.txtSoluongdau.setText("");
		PNPhieunhapGUI.txtSoluongcuoi.setText("");
		PNPhieunhapGUI.txtMasanphamtimkiem.setText("");
	}

	public void PNCT_lammoi() {
		PNPhieunhapGUI.txtChitietmasanpham.setText("");
		PNPhieunhapGUI.txtChitietmapn.setText("");
		PNPhieunhapGUI.txtChitietsoluong.setText("");
		PNPhieunhapGUI.txtChitietgianhap.setText("");

	}

	public void setModel(PhieuNhapChiTietDTO pnct) {
		try {
			PNPhieunhapGUI.txtChitietmasanpham.setText(pnct.getMagiay());
			PNPhieunhapGUI.txtChitietmapn.setText(pnct.getMapn());
			PNPhieunhapGUI.txtChitietsoluong.setText(pnct.getSoluong());
			PNPhieunhapGUI.txtChitietgianhap.setText(pnct.getGianhap());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public PhieuNhapChiTietDTO getModel() {
		PhieuNhapChiTietDTO pnct = new PhieuNhapChiTietDTO();
		pnct.setMagiay(PNPhieunhapGUI.txtChitietmasanpham.getText());
		pnct.setMapn(PNPhieunhapGUI.txtChitietmapn.getText());
		pnct.setSoluong(PNPhieunhapGUI.txtChitietsoluong.getText());
		pnct.setGianhap(PNPhieunhapGUI.txtChitietgianhap.getText());
		return pnct;
	}
}
