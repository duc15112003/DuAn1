package DAO;

import DTO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class NhanVienDAO {
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();

	public void insert(NhanVienDTO nv) {
		String sql = "use qlcuahanggiaydb;insert into tblnhanvien values(?,?,?,?,?,?,?,?,?,?)";
		cn.executeUpdate(sql, nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getDienThoai(),
				nv.getEmai(), nv.getLuong(), nv.getChucVu(), nv.getAnh());
	}

	public void Update(NhanVienDTO nv) {
		String sql = "use qlcuahanggiaydb;Update tblnhanvien set Ho = ?,Ten = ?,GioiTinh=?,DiaChi= ? ,DienThoai = ?, Email = ?, Luong = ?, ChucVu = ?, Anh = ? where MaNV =? and Luong <> 0";
		cn.executeUpdate(sql, nv.getHo(), nv.getTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getDienThoai(), nv.getEmai(),
				nv.getLuong(), nv.getChucVu(), nv.getAnh(), nv.getMaNV());
	}

	public void DeleNhanvien(String ID) {
		String sql = "use qlcuahanggiaydb;update tblnhanvien set Luong = 0 where MaNV = ?";
		String sql2 = "use qlcuahanggiaydb; delete from tbltaikhoan where tendangnhap = ?";
		cn.executeUpdate(sql, ID);
		cn.executeUpdate(sql2, ID);
	}
	
	public NhanVienDTO findById(String manv) throws SQLException{
		 String sql="use qlcuahanggiaydb;SELECT * FROM tblnhanvien WHERE MaNV=?";
		 List<NhanVienDTO> list = select(sql, manv);
		 return list.size() > 0 ? list.get(0) : null;
	}

	public List<NhanVienDTO> select(String sql, Object... args) throws SQLException {
		List<NhanVienDTO> list = new ArrayList<>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			NhanVienDTO nv = readData(rs);
			list.add(nv);
		}
		return list;
	}

	public List<NhanVienDTO> select() throws SQLException {
		String sql = "use qlcuahanggiaydb;select * from tblnhanvien where Luong <> 0";
		return select(sql);
	}

	public List<NhanVienDTO> FindDataByEmail(String email) throws SQLException {
		String sql = "use qlcuahanggiaydb;select * from tblnhanvien where Email = ?";
		List<NhanVienDTO> list = select(sql, email);
		return list;
	}
	
	public String selectAnh(String id) throws SQLException {
		String path = "";
		String sql = "select Anh from tblnhanvien where MaNV=?";
		rs = cn.executeQuery(sql, id);
		while (rs.next()) {
			path = rs.getString(1);			
		}
		return path;
	}

	public List<NhanVienDTO> FindDataByID(String id) throws SQLException {
		String sql = "use qlcuahanggiaydb;select * from tblnhanvien where MaNV = ? and Luong <> 0";
		return select(sql, id);
	}

	public NhanVienDTO readData(ResultSet rs) throws SQLException {
		NhanVienDTO nv = new NhanVienDTO();
		nv.setMaNV(rs.getString(1));
		nv.setHo(rs.getString(2));
		nv.setTen(rs.getString(3));
		nv.setGioiTinh(rs.getString(4));
		nv.setDiaChi(rs.getString(5));
		nv.setDienThoai(rs.getString(6));
		nv.setEmai(rs.getString(7));
		nv.setLuong(rs.getInt(8));
		nv.setChucVu(rs.getString(9));
		nv.setAnh(rs.getString(10));
		return nv;
	}

}
