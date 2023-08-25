package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.*;

public class ChiTietKMDAO {
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();
	
	public List<ChitietKMDTO> FindByID(String ID) throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblchitietkm where MaKM = ?";
		return select(sql,ID);
	}
	
	public List<ChitietKMDTO> FindTileByMa(String ma) throws SQLException{
		String sql = "use qlcuahanggiaydb; select TiLeKM from tblchitietkm where MaKM =?";
		return select(sql,ma);
	}
	
	public List<ChitietKMDTO> select(String sql,Object...args) throws SQLException{
		List<ChitietKMDTO> list = new ArrayList<ChitietKMDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			ChitietKMDTO ctkm = readData(rs);
			list.add(ctkm);
		}
		return list;
	}
	
	public ChitietKMDTO readData(ResultSet rs) throws SQLException {
		ChitietKMDTO ctkm = new ChitietKMDTO();
		ctkm.setMagiay(rs.getString(1));
		ctkm.setMakm(rs.getString(2));
		ctkm.setTile(rs.getDouble(3));
		return ctkm;
	}
	
}
