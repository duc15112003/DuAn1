package DTO;

public class KhachHangDTO {
	
	public String MaKH, Ho, Ten, GioiTinh, DiaChi, Email, Loai;
	Double TongChiTieu;

	public KhachHangDTO(String maKH, String ho, String ten, String gioiTinh, String diaChi, String email, String loai,
			Double tongChiTieu) {
		MaKH = maKH;
		Ho = ho;
		Ten = ten;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		Email = email;
		Loai = loai;
		TongChiTieu = tongChiTieu;
	}

	public KhachHangDTO() {

	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLoai() {
		return Loai;
	}

	public void setLoai(String loai) {
		Loai = loai;
	}

	public Double getTongChiTieu() {
		return TongChiTieu;
	}

	public void setTongChiTieu(Double tongChiTieu) {
		TongChiTieu = tongChiTieu;
	}

}
