package DTO;

public class TaiKhoanDTO {
	
	String tendangnhap;
	String matkhau;
	String capbac;
	
	public TaiKhoanDTO() {
		
	}

	public TaiKhoanDTO(String tendangnhap, String matkhau, String capbac) {
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.capbac = capbac;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getCapbac() {
		return capbac;
	}

	public void setCapbac(String capbac) {
		this.capbac = capbac;
	}
	

}
