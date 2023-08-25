package DAO;

import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import DTO.PhieuNhapChiTietDTO;

public class PhieuNhapChiTietDAO {
	
	ConnectionSQL con = new ConnectionSQL();
	PreparedStatement ps;
	ResultSet rs;
	

	
	public void insert(PhieuNhapChiTietDTO pnct) {
		String sql = "use qlcuahanggiaydb ;INSERT INTO tblchitietpn  (MaGiay, MaPN , SoLuong,GiaNhap) VALUES ( ?, ?, ?, ?)";
		con.executeUpdate(sql, pnct.getMagiay(), pnct.getMapn(),pnct.getSoluong(),pnct.getGianhap());
		
	}
	public void  update(PhieuNhapChiTietDTO pnct) {
		String sql =" use  qlcuahanggiaydb ; UPDATE  tblchitietpn set  MaPN =? , SoLuong =? , GiaNhap =? where MaGiay =? ";
		con.executeUpdate(sql,pnct.getMapn(),pnct.getSoluong(),pnct.getGianhap(), pnct.getMagiay());
		
	}
	
	public void DeleteByID(String id) {
		String sql = "use qlcuahanggiaydb; Delete from tblchitietpn where MaGiay =? ";
		con.executeUpdate(sql, id);
	}
	
	public void Xoa(PhieuNhapChiTietDTO pnct ) {
		String sql = "Delete from tblchitietpn where MaGiay =? ";
		con.executeUpdate(sql, pnct.getMagiay());
		
	}
	
	
	 public List<PhieuNhapChiTietDTO> timkiemsoluong(int soluongdau , int soluongcuoi) throws SQLException {
		 String sql  = "select * from tblchitietpn where SoLuong BETWEEN  ?  and   ?";
		 return select(sql,soluongdau, soluongcuoi);
	 }
	 
	 
	
	
	
	public List<PhieuNhapChiTietDTO> timkiemid(String magiay) throws SQLException { 
		List<PhieuNhapChiTietDTO> list = new ArrayList<>();
		String sql = "select * from tblchitietpn where MaGiay = ?";
		list = select(sql,magiay);
		return list;
	}
		

	
//	Fill all dữ liệu lên bảng
	public List<PhieuNhapChiTietDTO> select() throws SQLException{
		String sql = "select * from tblchitietpn";
		return select(sql);
		
	}
//	 hàm trả về
	
	public List<PhieuNhapChiTietDTO> select(String sql , Object ...args) throws SQLException{
		List<PhieuNhapChiTietDTO> listpnct  = new ArrayList<>();
		rs= con.executeQuery(sql, args);
		while (rs.next()) {
			PhieuNhapChiTietDTO pnct= ReadData(rs);
			listpnct.add(pnct);
		}
		return listpnct;
	}
//	 đọc dữ liệu
	public PhieuNhapChiTietDTO ReadData(ResultSet rs) throws SQLException {
		PhieuNhapChiTietDTO pnct = new PhieuNhapChiTietDTO();
		pnct.setMagiay(rs.getString(1));
		pnct.setMapn(rs.getString(2));
		pnct.setSoluong(rs.getString(3));
		pnct.setGianhap(rs.getString(4));
		return pnct;
	}
	

}
