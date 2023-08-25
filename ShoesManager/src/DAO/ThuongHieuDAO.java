package DAO;

import java.sql.*;
import java.util.*;
import DTO.*;

public class ThuongHieuDAO {
	
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public List<ThuongHieuDTO> select(String sql, Object... args) throws SQLException {
		List<ThuongHieuDTO> list = new ArrayList<ThuongHieuDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			ThuongHieuDTO loai = readData(rs);
			list.add(loai);
		}
		return list;
	}
	
	public List<ThuongHieuDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblthuonghieu";
		return select(sql);
	}
	
	public String GetThuongHieu(String maTH) throws SQLException{
		String s = ""; 
		String sql = "select tenthuonghieu from tblthuonghieu where Mathuonghieu = ?";
		rs = cn.executeQuery(sql,maTH);
		while(rs.next()){
			s = rs.getString(1);
		}
		return s;
	}
	
	public ThuongHieuDTO readData(ResultSet rs) throws SQLException {
		ThuongHieuDTO th = new ThuongHieuDTO();
		th.setMathuonghieu(rs.getString(1));
		th.setTenthuonghieu(rs.getString(2));
		th.setDiachi(rs.getString(3));
		th.setEmail(rs.getString(4));
		return th;
	}

}
