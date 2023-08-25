package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import DTO.*;

public class SanPhamDAO {
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public void Insert(SanPhamDTO sp) {
		String sql = "use qlcuahanggiaydb; insert into tblsanpham values(?,?,?,?,?,?,?,?,?,?,?)";
		cn.executeUpdate(sql, sp.getMaSP(), sp.getTenSP(), sp.getSoluong(), sp.getGia(), sp.getSize(), sp.getDoituong(),
				sp.getChatLieu(), sp.getMaLoai(), sp.getMaxx(), sp.getMamau(), sp.getMaTH());
	}

	public void Delete(SanPhamDTO sp) {
		String sql = "use qlcuahanggiaydb; delete from tblsanpham Where MaGiay = ?";
		cn.executeUpdate(sql, sp.getMaSP());
	}
	
	public void DeleteByMa(String ma) {
		String sql = "use qlcuahanggiaydb; delete from tblsanpham Where MaGiay = ?";
		cn.executeUpdate(sql, ma);
	}
	
	public void Update(SanPhamDTO sp) {
		String sql = "use qlcuahanggiaydb; update tblsanpham set Tengiay = ?,Soluong = ?,Gia =?,Size =?,Doituongsd =?,Chatlieu = ?,Maloai=?,Maxx = ?,Mamau=?,Mathuonghieu=? where MaGiay = ?";
		cn.executeUpdate(sql,sp.getTenSP(),sp.getSoluong(),sp.getGia(),sp.getSize(),sp.getDoituong(),sp.getChatLieu(),sp.getMaLoai(),sp.getMaxx(),sp.getMamau(),sp.getMaTH(),sp.getMaSP());
	}
	
	public List<SanPhamDTO> FillByLoaiDAO(String maloai) throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tblsanpham where Maloai = ?";
		return select(sql,maloai);
	}
	
	public void UpdateSP(int soluong,String id) {
		String sql = "use qlcuahanggiaydb; update tblsanpham set Soluong = ? where MaSP = ?";
		cn.executeUpdate(sql, soluong,id);
	
	}
	
	public List<SanPhamDTO> select(String sql, Object...args) throws SQLException {
		List<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			SanPhamDTO sp = readData(rs);
			list.add(sp);
		}
		return list;
	}
	
	public List<SanPhamDTO> select()throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblsanpham";
		return select(sql);
	}

	public SanPhamDTO readData(ResultSet rs) throws SQLException {
		SanPhamDTO sp = new SanPhamDTO();
		sp.setMaSP(rs.getString(1));
		sp.setTenSP(rs.getString(2));
		sp.setSoluong(Integer.parseInt(rs.getString(3)));
		sp.setGia(Double.parseDouble(rs.getString(4)));
		sp.setSize(Integer.parseInt(rs.getString(5)));
		sp.setDoituong(rs.getString(6));
		sp.setChatLieu(rs.getString(7));
		sp.setMaLoai(rs.getString(8));
		sp.setMaxx(rs.getString(9));
		sp.setMamau(rs.getString(10));
		sp.setMaTH(rs.getString(11));
		return sp;
	}
}
