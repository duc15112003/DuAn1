package DTO;

public class NhaCCDTO {
	
	String mancc;
	String tenncc;
	String diachi;
	String email;
	
	public NhaCCDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public NhaCCDTO(String mancc, String tenncc, String diachi, String email) {
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.diachi = diachi;
		this.email = email;
	}



	public String getMancc() {
		return mancc;
	}

	public void setMancc(String mancc) {
		this.mancc = mancc;
	}

	public String getTenncc() {
		return tenncc;
	}

	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
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
