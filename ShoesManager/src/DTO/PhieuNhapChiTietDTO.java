package DTO;

public class PhieuNhapChiTietDTO {

	String magiay;
	String mapn;
	String soluong;
	String gianhap;

	public PhieuNhapChiTietDTO() {

	}

	public PhieuNhapChiTietDTO(String magiay, String mapn, String soluong, String gianhap) {

		this.magiay = magiay;
		this.mapn = mapn;
		this.soluong = soluong;
		this.gianhap = gianhap;
	}

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getMapn() {
		return mapn;
	}

	public void setMapn(String mapn) {
		this.mapn = mapn;
	}

	public String getSoluong() {
		return soluong;
	}

	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}

	public String getGianhap() {
		return gianhap;
	}

	public void setGianhap(String gianhap) {
		this.gianhap = gianhap;
	}

}
