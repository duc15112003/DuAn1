package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DTO.*;

public class LoaiDAO {

	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public List<LoaiDTO> select(String sql, Object... args) throws SQLException {
		List<LoaiDTO> list = new ArrayList<LoaiDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			LoaiDTO loai = readData(rs);
			list.add(loai);
		}
		return list;
	}
	
	public String GetTenLoai(String maloai) throws SQLException{
		String s = "";
		String sql = "select tenloai from tblloai where maloai = ?";
		rs = cn.executeQuery(sql,maloai);
		while(rs.next()){
			s = rs.getString(1);
		}
		return s;
	} 

	
	public List<LoaiDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblloai";
		return select(sql);
	}

	public LoaiDTO readData(ResultSet rs) throws SQLException {
		LoaiDTO loai = new LoaiDTO();
		loai.setMaloai(rs.getString(1));
		loai.setTenloai(rs.getString(2));
		return loai;
	}



}
