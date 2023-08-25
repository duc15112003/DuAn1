package DTO;

public class MauDTO {
	
	String mamau;
	String tenmau;
	
	public MauDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MauDTO(String mamau,String tenmau) {
		this.mamau = mamau;
		this.tenmau = tenmau;
	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public String getTenmau() {
		return tenmau;
	}

	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
}
