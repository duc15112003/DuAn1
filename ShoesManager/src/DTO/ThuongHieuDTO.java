package DTO;

public class ThuongHieuDTO {
	
	String mathuonghieu;
	String tenthuonghieu;
	String diachi;
	String email;
	
	public ThuongHieuDTO() {
		// TODO Auto-generated constructor stub
	}

	public ThuongHieuDTO(String mathuonghieu, String tenthuonghieu, String diachi, String email) {
		this.mathuonghieu = mathuonghieu;
		this.tenthuonghieu = tenthuonghieu;
		this.diachi = diachi;
		this.email = email;
	}

	public String getMathuonghieu() {
		return mathuonghieu;
	}

	public void setMathuonghieu(String mathuonghieu) {
		this.mathuonghieu = mathuonghieu;
	}

	public String getTenthuonghieu() {
		return tenthuonghieu;
	}

	public void setTenthuonghieu(String tenthuonghieu) {
		this.tenthuonghieu = tenthuonghieu;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
