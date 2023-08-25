package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.LoaiDTO;
import DTO.XuatXuDTO;

public class XuatXuDAO {
	
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public List<XuatXuDTO> select(String sql, Object... args) throws SQLException {
		List<XuatXuDTO> list = new ArrayList<XuatXuDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			XuatXuDTO xuatxu = readData(rs);
			list.add(xuatxu);
		}
		return list;
	}
	
	public String GetXuatXu(String maxx) throws SQLException{
		String s = "";
		String sql = "select tennuoc from tblxuatxu where Maxx = ?";
		rs = cn.executeQuery(sql,maxx);
		while(rs.next()){
			s = rs.getString(1);
		}
		return s;
	}
	
	public List<XuatXuDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblxuatxu";
		return select(sql);
	}

	public XuatXuDTO readData(ResultSet rs) throws SQLException {
		XuatXuDTO xuatxu = new XuatXuDTO();
		xuatxu.setMaxx(rs.getString(1));
		xuatxu.setTennuoc(rs.getString(2));
		return xuatxu;
	}

}
