package DTO;

public class KhuyenMaiDTO {
	
	String MaKM;
	String TenCT;
	String LoaiCT;
	String DK;
	String NgayBD;
	String NgayKT;
	
	public KhuyenMaiDTO() {
		// TODO Auto-generated constructor stub
	}

	public KhuyenMaiDTO(String maKM, String tenCT, String loaiCT, String dK, String ngayBD, String ngayKT) {
		this.MaKM = maKM;
		this.TenCT = tenCT;
		this.LoaiCT = loaiCT;
		this.DK = dK;
		this.NgayBD = ngayBD;
		this.NgayKT = ngayKT;
	}

	public String getMaKM() {
		return MaKM;
	}

	public void setMaKM(String maKM) {
		MaKM = maKM;
	}

	public String getTenCT() {
		return TenCT;
	}

	public void setTenCT(String tenCT) {
		TenCT = tenCT;
	}

	public String getLoaiCT() {
		return LoaiCT;
	}

	public void setLoaiCT(String loaiCT) {
		LoaiCT = loaiCT;
	}

	public String getDK() {
		return DK;
	}

	public void setDK(String dK) {
		DK = dK;
	}

	public String getNgayBD() {
		return NgayBD;
	}

	public void setNgayBD(String ngayBD) {
		NgayBD = ngayBD;
	}

	public String getNgayKT() {
		return NgayKT;
	}

	public void setNgayKT(String ngayKT) {
		NgayKT = ngayKT;
	}
	
	
	

}
