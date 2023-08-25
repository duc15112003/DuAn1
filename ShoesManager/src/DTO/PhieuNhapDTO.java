package DTO;

public class PhieuNhapDTO {
	public String mapn, mancc, manv, ngaynhap, tongtien;

	public PhieuNhapDTO(String mapn, String mancc, String manv, String ngaynhap, String tongtien) {

		this.mapn = mapn;
		this.manv = manv;
		this.ngaynhap = ngaynhap;
		this.tongtien = tongtien;
		this.mancc = mancc;
	}

	public PhieuNhapDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getMapn() {
		return mapn;
	}

	public void setMapn(String mapn) {
		this.mapn = mapn;
	}

	public String getMancc() {
		return mancc;
	}

	public void setMancc(String mancc) {
		this.mancc = mancc;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public String getTongtien() {
		return tongtien;
	}

	public void setTongtien(String tongtien) {
		this.tongtien = tongtien;
	}
}
