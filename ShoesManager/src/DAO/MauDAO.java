package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.LoaiDTO;
import DTO.MauDTO;

public class MauDAO {
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public List<MauDTO> select(String sql, Object... args) throws SQLException {
		List<MauDTO> list = new ArrayList<MauDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			MauDTO mau = readData(rs);
			list.add(mau);
		}
		return list;
	}
	
	public String GetMauSac(String mamau) throws SQLException{
		String s = "";
		String sql = "select tenmau from tblmausac where Mamau = ?";
		rs = cn.executeQuery(sql,mamau);
		while(rs.next()){
			s = rs.getString(1);
		}
		return s;
	}
	
	public List<MauDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblmausac";
		return select(sql);
	}

	public MauDTO readData(ResultSet rs) throws SQLException {
		MauDTO mau = new MauDTO();
		mau.setMamau(rs.getString(1));
		mau.setTenmau(rs.getString(2));
		return mau;
	}
}
