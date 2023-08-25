package DTO;

public class XuatXuDTO {
	
	String Maxx;
	String tennuoc;
	
	public XuatXuDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public XuatXuDTO(String Maxx,String tennuoc) {
		this.Maxx = Maxx;
		this.tennuoc = tennuoc;
	}

	public String getMaxx() {
		return Maxx;
	}

	public void setMaxx(String maxx) {
		Maxx = maxx;
	}

	public String getTennuoc() {
		return tennuoc;
	}

	public void setTennuoc(String tennuoc) {
		this.tennuoc = tennuoc;
	}

}
