package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import DTO.*;

public class KhuyenMaiDAO {

	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public List<KhuyenMaiDTO> select(String sql, Object... args) throws SQLException {
		List<KhuyenMaiDTO> list = new ArrayList<>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			KhuyenMaiDTO km = readData(rs);
			list.add(km);
		}
		return list;
	}

	public void Insert(KhuyenMaiDTO km) {
		String sql = "use qlcuahannggiaydb;insert into tblkhuyenmai values (?,?,?,?,?,?)";
		cn.executeQuery(sql, km.getMaKM(), km.getTenCT(), km.getLoaiCT(), km.getDK(), km.getNgayBD(), km.getNgayKT());
	}

	public void Update(KhuyenMaiDTO km) {
		String sql = "use qlcuahannggiaydb; Update tblkhuyenmai set TenChuongTrinh =?,LoaiChuongTrinh = ?, DieuKien = ?,NgayBatDau = ?,NgayKetThuc = ? where MaKM = ?";
		cn.executeUpdate(sql,  km.getTenCT(), km.getLoaiCT(), km.getDK(), km.getNgayBD(), km.getNgayKT(),km.getMaKM());
	}
	
	public void Delete(KhuyenMaiDTO km) {
		String sql = "use qlcuahanggiaydb;delete from tblkhuyenmai where MaKM = ?";
		cn.executeUpdate(sql, km.getMaKM());
	}
	
	public List<KhuyenMaiDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblkhuyenmai";
		return select(sql);
	}
	
	public KhuyenMaiDTO readData(ResultSet rs) throws SQLException {
		KhuyenMaiDTO km = new KhuyenMaiDTO();
		km.setMaKM(rs.getString(1));
		km.setTenCT(rs.getString(2));
		km.setLoaiCT(rs.getString(3));
		km.setDK(rs.getString(4));
		km.setNgayBD(rs.getString(5));
		km.setNgayKT(rs.getString(6));
		return km;
	}
}
