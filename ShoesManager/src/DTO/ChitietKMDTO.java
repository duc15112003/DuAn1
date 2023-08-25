package DTO;

public class ChitietKMDTO {
	
	String magiay;
	String makm;
	Double tile;
	
	public ChitietKMDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChitietKMDTO(String magiay, String makm, Double tile) {
		this.magiay = magiay;
		this.makm = makm;
		this.tile = tile;
	}

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public Double getTile() {
		return tile;
	}

	public void setTile(double d) {
		this.tile = d;
	}

}
