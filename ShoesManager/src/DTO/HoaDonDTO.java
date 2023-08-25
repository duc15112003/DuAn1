package DTO;

public class HoaDonDTO {
	String MaHD;
	String MaNV;
	String MaKH;
	String MaKM;
	String NgayBan;
	double tongTien;

	public HoaDonDTO() {
		// TODO Auto-generated constructor stub
	}

	public HoaDonDTO(String maHD, String maNV, String maKH, String maKM, String ngayBan, double tongTien) {
		MaHD = maHD;
		MaNV = maNV;
		MaKH = maKH;
		MaKM = maKM;
		NgayBan = ngayBan;
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getMaKM() {
		return MaKM;
	}

	public void setMaKM(String maKM) {
		MaKM = maKM;
	}

	public String getNgayBan() {
		return NgayBan;
	}

	public void setNgayBan(String ngayBan) {
		NgayBan = ngayBan;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
