package DTO;

public class NhanVienDTO {
	
	String MaNV;
	String Ho;
	String Ten;
	String GioiTinh;
	String DiaChi;
	String DienThoai;
	String Emai;
	int Luong;
	String ChucVu;
	String Anh;
	
	public NhanVienDTO() {
		
	}

	public NhanVienDTO(String maNV, String ho, String ten, String gioiTinh, String diaChi, String dienThoai,String emai, int luong, String chucVu, String anh) {
		this.MaNV = maNV;
		this.Ho = ho;
		this.Ten = ten;
		this.GioiTinh = gioiTinh;
		this.DiaChi = diaChi;
		this.DienThoai = dienThoai;
		this.Emai = emai;
		this.Luong = luong;
		this.ChucVu = chucVu;
		this.Anh = anh;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHo() {
		return Ho;
	}

	public void setHo(String ho) {
		Ho = ho;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getDienThoai() {
		return DienThoai;
	}

	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}

	public String getEmai() {
		return Emai;
	}

	public void setEmai(String emai) {
		Emai = emai;
	}

	public int getLuong() {
		return Luong;
	}

	public void setLuong(int luong) {
		Luong = luong;
	}

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}
	
}
