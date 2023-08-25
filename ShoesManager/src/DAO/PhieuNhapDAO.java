package DAO;

import java.sql.*;
import java.util.*;
import DTO.PhieuNhapDTO;
import GUI.PNPhieunhapGUI;



public class PhieuNhapDAO {
	ConnectionSQL con = new ConnectionSQL();
	PreparedStatement ps;
	ResultSet rs;


	public void insert(PhieuNhapDTO pn) {
		String sql = "use qlcuahanggiaydb; INSERT INTO tblphieunhap (MaPN, MaNCC ,MaNV, NgayNhap,TongTien) VALUES ( ?, ?, ?, ?,?)";
		con.executeUpdate(sql,  pn.getMapn(), pn.getMancc(), pn.getManv(), pn.getNgaynhap(), pn.getTongtien());
		
	}

	//  delete---
	public void delete(PhieuNhapDTO pn) {
		String sql = "Delete from tblphieunhap where MaPN = ?";
		con.executeUpdate(sql, pn.getMapn());
	}
//	update
	
	public void update(PhieuNhapDTO pn) {
		String sql  = " use qlcuahanggiaydb ; UPDATE  tblphieunhap SET MaNCC = ? ,MaNV = ? , NgayNhap = ? , TongTien=?  WHERE MaPN=? ";
		con.executeUpdate(sql, pn.getMancc(), pn.getManv(), pn.getNgaynhap(), pn.getTongtien(), pn.getMapn());	
	}
// fill tất cả
	public List<PhieuNhapDTO> select() throws SQLException {
		String sql = "select * from tblphieunhap";
		return select(sql);
	}
//	hàm trả về
	public List<PhieuNhapDTO> select(String sql, Object... args) throws SQLException {
		List<PhieuNhapDTO> listpn = new ArrayList<>();
		rs = con.executeQuery(sql, args);
		while (rs.next()) {
			PhieuNhapDTO pn = ReadData(rs);
			listpn.add(pn);
		}
		return listpn;
	}

	
//	 tìm kiếm
	
	    public List<PhieuNhapDTO> findyId(String mapn) throws SQLException {
		List<PhieuNhapDTO> list = new ArrayList<>();
		String sql = "select * from tblphieunhap where MaPN = ?";
		list = select(sql,mapn);
		return list;
	} 
	    
//	đọc dự liệu
	public PhieuNhapDTO ReadData(ResultSet rs) throws SQLException {
		PhieuNhapDTO pn = new PhieuNhapDTO();
		pn.setMapn(rs.getString(1));
		pn.setMancc(rs.getString(2));
		pn.setManv(rs.getString(3));
		pn.setNgaynhap(rs.getString(4));
		pn.setTongtien(rs.getString(5));	
		return pn;
	}
	
	
	

}
