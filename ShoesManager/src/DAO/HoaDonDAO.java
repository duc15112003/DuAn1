package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.HoaDonDTO;

public class HoaDonDAO{
	ResultSet rs;
	String MaHD;
    String MaNV;
    String MaKH;
    String MaKM;
    String NgayBan;
    double tongTien;
    PreparedStatement ps;
    ConnectionSQL cn = new ConnectionSQL();
	
	public void insert(HoaDonDTO hd) {
		String sql = "use qlcuahanggiaydb;insert into tblhoadon values (?,?,?,?,?,?)";
		cn.executeUpdate(sql, hd.getMaHD(),hd.getMaNV(),hd.getMaKH(),hd.getMaKM(),hd.getNgayBan(),hd.getTongTien());
	}
	public List<HoaDonDTO> select(String sql, Object...args) throws SQLException{
		List<HoaDonDTO> list = new ArrayList<>();
		rs =  cn.executeQuery(sql, args);
		while (rs.next()) {
			HoaDonDTO hd = readFromResultSet(rs);
			list.add(hd);	
		}
		return list;
	}
	
	
	public void Update(HoaDonDTO hd) {
		String query = "use qlcuahanggiaydb; Update tblhoadon set MaNV =?,MaKH=?,MaKM =?, NgayBan = ?,TongTien=? where MaHD = ?";
		cn.executeUpdate(query,hd.getMaNV(), hd.getMaKH(),hd.getMaKM(),hd.getNgayBan(),hd.getTongTien(),hd.getMaHD());
	}
	
	
	public void delete(HoaDonDTO hd) {
		String query = "use qlcuahanggiaydb; delete from tblhoadon where MaHD = ?";
		String query2 = "use qlcuahanggiaydb; delete from tblchitiethd where MaHD = ?";
		cn.executeUpdate(query, hd.getMaHD());
		cn.executeUpdate(query2, hd.getMaHD());
	}
	
	public List<HoaDonDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblhoadon";
		return select(sql);
	}
	
	private HoaDonDTO readFromResultSet(ResultSet rs) throws SQLException{
		HoaDonDTO hd =new HoaDonDTO();
		hd.setMaHD(rs.getString(1));
		hd.setMaNV(rs.getString(2));
		hd.setMaKH(rs.getString(3));
		hd.setMaKM(rs.getString(4));
		hd.setNgayBan(rs.getString(5));
		hd.setTongTien(rs.getDouble(6));
		return hd;
	}

}
