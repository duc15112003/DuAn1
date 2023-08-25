package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.*;
import DTO.NhaCCDTO;
public class NhaCCDAO {
	
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();
	
	public List<NhaCCDTO> select(String sql,Object...args) throws SQLException{
		List<NhaCCDTO> list = new ArrayList<NhaCCDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			NhaCCDTO ncc = readData(rs);
			list.add(ncc);
		}
		return list;
	}
	
	public List<NhaCCDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblnhacungcap";
		return select(sql);
	}
	
	public NhaCCDTO readData(ResultSet rs) throws SQLException{
		NhaCCDTO ncc = new NhaCCDTO();
			ncc.setMancc(rs.getString(1));
			ncc.setTenncc(rs.getString(2));
			ncc.setDiachi(rs.getString(3));
			ncc.setEmail(rs.getString(4));
		return ncc;
	}

}
