package Controller;
import GUI.*;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

import DAO.*;
import DTO.*;
public class ThongKeCTRL {
	
	HoaDonDAO hd = new HoaDonDAO();
	PhieuNhapDAO pn = new PhieuNhapDAO();
	HoaDonChiTietDAO hdct = new HoaDonChiTietDAO();
	PhieuNhapChiTietDAO pnct = new PhieuNhapChiTietDAO();
	List<HoaDonDTO> listhd = new ArrayList<HoaDonDTO>();
	List<PhieuNhapDTO> listpn = new ArrayList<PhieuNhapDTO>();
	List<ChiTietHDDTO> listhdct = new ArrayList<ChiTietHDDTO>();
	List<PhieuNhapChiTietDTO> listctpn = new ArrayList<PhieuNhapChiTietDTO>();
	
 	public void getData() throws SQLException {
 		listhd = hd.select();
 		listpn = pn.select();
 		listhdct = hdct.select();
 		listctpn = pnct.select(); 		
	}
 	
	
	public void FillTable() {
		DefaultTableModel model = (DefaultTableModel) PNThongKeGUI.tblbangphieunhap.getModel();
		model.setRowCount(0);
		DefaultTableModel model2 =  (DefaultTableModel) PNThongKeGUI.tblbanghoadon.getModel();
		model2.setRowCount(0);
		for(PhieuNhapDTO pn: listpn) {
			Object[] op = new Object[] {pn.getMapn(),pn.getNgaynhap(),pn.getTongtien()};
			model.addRow(op);
		}
		for(HoaDonDTO hd: listhd) {
			Object[] op1 = new Object[] {hd.getMaHD(),hd.getNgayBan(),hd.getTongTien()};
			model2.addRow(op1);
		}
		
	}
	
	public void SumOfPhieuNhap() {
		Double tongchi = (double) 0;
		for (int i = 0; i < PNThongKeGUI.tblbangphieunhap.getRowCount(); i++) {
			DefaultTableModel model = (DefaultTableModel) PNThongKeGUI.tblbangphieunhap.getModel();
			Double value = Double.parseDouble((String) model.getValueAt(i, 2));
			tongchi = tongchi + value;
		}
		PNThongKeGUI.txttongchi.setText(String.valueOf(tongchi));
	}
	
	public void SumOfHoaDon() {
		Double tongthu = (double) 0;
		for(int i = 0;i<PNThongKeGUI.tblbanghoadon.getRowCount();i++) {
			DefaultTableModel tmodel = (DefaultTableModel) PNThongKeGUI.tblbanghoadon.getModel();
			Double values =  Double.parseDouble(String.valueOf(tmodel.getValueAt(i, 2)));
			tongthu = tongthu + values;
		}
		PNThongKeGUI.txttongthu.setText(String.valueOf(tongthu));
		
	}
	
	public void TongLoiNhuan() {
		double tongchi = Double.parseDouble(PNThongKeGUI.txttongchi.getText());
		double tongthu = Double.parseDouble(PNThongKeGUI.txttongthu.getText());
		double loinhuan = tongthu-tongchi;
		PNThongKeGUI.txtloinhuan.setText(String.valueOf(Math.ceil(loinhuan)));
	}
	
	public void Tinhtrang() {
		Double loinhuan = Double.parseDouble(PNThongKeGUI.txtloinhuan.getText());
		if(loinhuan >0) {
			PNThongKeGUI.txttinhtrang.setText("Có Lời");
		}else if(loinhuan<0) {
			PNThongKeGUI.txttinhtrang.setText("Đang Lỗ");
		}else {
			PNThongKeGUI.txttinhtrang.setText("Huề Vốn");
		}
	}
	
	public void Excel(String path) {

		try { 
			//creating an instance of HSSFWorkbook class  
			HSSFWorkbook workbook = new HSSFWorkbook();  
			//invoking creatSheet() method and passing the name of the sheet to be created   
			HSSFSheet sheet1 = workbook.createSheet("Phiếu Nhập");   
			HSSFSheet sheet2 = workbook.createSheet("Chi Tiết Phiếu Nhập");   
			HSSFSheet sheet3 = workbook.createSheet("Hóa Đơn");   
			HSSFSheet sheet4 = workbook.createSheet("Chi Tiết Hóa Đơn");   
			// excel phiếu nhập 
			HSSFRow rowhead = sheet1.createRow((short)0);  
			rowhead.createCell(0).setCellValue("Mã PN");  
			rowhead.createCell(1).setCellValue("Mã NCC");  
			rowhead.createCell(2).setCellValue("Mã NV");  
			rowhead.createCell(3).setCellValue("Ngày Nhập");  
			rowhead.createCell(4).setCellValue("Tổng Tiền");  
			for(int i = 1;i<=listpn.size();i++) {
				HSSFRow row = sheet1.createRow((short)i);  
				row.createCell(0).setCellValue(listpn.get(i-1).getMapn());  
				row.createCell(1).setCellValue(listpn.get(i-1).getMancc());  
				row.createCell(2).setCellValue(listpn.get(i-1).getManv());  
				row.createCell(3).setCellValue(listpn.get(i-1).getNgaynhap());  
				row.createCell(4).setCellValue(listpn.get(i-1).getTongtien()); 
			}
			HSSFRow row = sheet1.createRow((short)listpn.size()+1);  
			row.createCell(4).setCellValue("Tổng Tiền:");  
			row.createCell(5).setCellValue(PNThongKeGUI.txttongchi.getText()); 
		   

			// excel chi tiết phiếu nhập 
			HSSFRow rowhead1 = sheet2.createRow((short)0);  
			rowhead1.createCell(0).setCellValue("Mã Giày");  
			rowhead1.createCell(1).setCellValue("Mã PN");  
			rowhead1.createCell(2).setCellValue("Số Lượng");  
			rowhead1.createCell(3).setCellValue("Giá Nhập");  
			for(int i = 1;i<=listctpn.size();i++) {
				HSSFRow row1 = sheet2.createRow((short)i);  
				row1.createCell(0).setCellValue(listctpn.get(i-1).getMagiay());  
				row1.createCell(1).setCellValue(listctpn.get(i-1).getMapn());  
				row1.createCell(2).setCellValue(listctpn.get(i-1).getSoluong());  
				row1.createCell(3).setCellValue(listctpn.get(i-1).getGianhap());  

			}
			HSSFRow row1 = sheet2.createRow((short)listctpn.size()+1);  
			row1.createCell(4).setCellValue("Tổng Tiền:");  
			row1.createCell(5).setCellValue(PNThongKeGUI.txttongchi.getText()); 
			
			// hóa đơn
			HSSFRow rowhead2 = sheet3.createRow((short)0);  
			rowhead2.createCell(0).setCellValue("Mã Hóa Đơn");  
			rowhead2.createCell(1).setCellValue("Mã Nhân Viên");  
			rowhead2.createCell(2).setCellValue("Mã Khách Hàng");  
			rowhead2.createCell(3).setCellValue("Mã Khuyến Mại");  
			rowhead2.createCell(4).setCellValue("Ngày Bán");  
			rowhead2.createCell(5).setCellValue("Tổng Tiền");  
			for(int i = 1;i<=listhd.size();i++) {
				HSSFRow row2 = sheet3.createRow((short)i);  
				row2.createCell(0).setCellValue(listhd.get(i-1).getMaHD());  
				row2.createCell(1).setCellValue(listhd.get(i-1).getMaNV());  
				row2.createCell(2).setCellValue(listhd.get(i-1).getMaKH());  
				row2.createCell(3).setCellValue(listhd.get(i-1).getMaKM());  
				row2.createCell(4).setCellValue(listhd.get(i-1).getNgayBan());  
				row2.createCell(5).setCellValue(listhd.get(i-1).getTongTien()); 

			}
			HSSFRow row2 = sheet3.createRow((short)listhd.size()+1);  
			row2.createCell(4).setCellValue("Tổng Tiền:");  
			row2.createCell(5).setCellValue(PNThongKeGUI.txttongthu.getText()); 
			
			// chi tiet hoa don
			HSSFRow rowhead3 = sheet4.createRow((short)0);  
			rowhead3.createCell(0).setCellValue("Mã Giày");  
			rowhead3.createCell(1).setCellValue("Mã HĐ");  
			rowhead3.createCell(2).setCellValue("Số Lượng");  
			rowhead3.createCell(3).setCellValue("Giá Bán");   
			for(int i = 1;i<=listhdct.size();i++) {
				HSSFRow row3 = sheet4.createRow((short)i);  
				row3.createCell(0).setCellValue(listhdct.get(i-1).getMaGiay());  
				row3.createCell(1).setCellValue(listhdct.get(i-1).getMaHD());  
				row3.createCell(2).setCellValue(listhdct.get(i-1).getSoLuong());  
				row3.createCell(3).setCellValue(listhdct.get(i-1).getGiaBan());  
			}
			HSSFRow row3 = sheet4.createRow((short)listhdct.size()+1);  
			row3.createCell(4).setCellValue("Tổng Tiền:");  
			row3.createCell(5).setCellValue(PNThongKeGUI.txttongthu.getText()); 
			
			FileOutputStream fileOut = new FileOutputStream(path);  
			workbook.write(fileOut);  
			//closing the Stream  
			fileOut.close();  
			//closing the workbook  
			workbook.close();  
			//prints the message on the console  
		JOptionPane.showMessageDialog(null, "Tạo Thành Công");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
