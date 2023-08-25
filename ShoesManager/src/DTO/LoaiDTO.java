package DTO;

public class LoaiDTO {
	
	String maloai;
	String tenloai;
	
	public LoaiDTO() {
		// TODO Auto-generated constructor stub
	}
	public LoaiDTO(String maloai,String tenloai) {
		this.maloai = maloai;
		this.tenloai = tenloai;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
}
