package DTO;

public class SanPhamDTO {
	String MaSP;
	String TenSP;
	int Soluong;
	Double Gia;
	int Size;
	String Doituong;
	String ChatLieu;
	String MaLoai;
	String Maxx;
	String Mamau;
	String MaTH;
	
	public SanPhamDTO() {
		// TODO Auto-generated constructor stub
	}

	public SanPhamDTO(String maSP, String tenSP, int soluong, Double gia, int size, String doituong,
			String chatLieu, String maLoai, String maxx, String mamau, String maTH) {
		MaSP = maSP;
		TenSP = tenSP;
		Soluong = soluong;
		Gia = gia;
		Size = size;
		Doituong = doituong;
		ChatLieu = chatLieu;
		MaLoai = maLoai;
		Maxx = maxx;
		Mamau = mamau;
		MaTH = maTH;
	}

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public int getSoluong() {
		return Soluong;
	}

	public void setSoluong(int soluong) {
		Soluong = soluong;
	}

	public Double getGia() {
		return Gia;
	}

	public void setGia(Double gia) {
		Gia = gia;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public String getDoituong() {
		return Doituong;
	}

	public void setDoituong(String doituong) {
		Doituong = doituong;
	}

	public String getChatLieu() {
		return ChatLieu;
	}

	public void setChatLieu(String chatLieu) {
		ChatLieu = chatLieu;
	}

	public String getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}

	public String getMaxx() {
		return Maxx;
	}

	public void setMaxx(String maxx) {
		Maxx = maxx;
	}

	public String getMamau() {
		return Mamau;
	}

	public void setMamau(String mamau) {
		Mamau = mamau;
	}

	public String getMaTH() {
		return MaTH;
	}

	public void setMaTH(String maTH) {
		MaTH = maTH;
	}
	
	
}
