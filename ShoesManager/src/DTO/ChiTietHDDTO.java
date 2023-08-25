package DTO;

public class ChiTietHDDTO {
     String MaGiay, MaHD;
    int SoLuong;
    double GiaBan;
//    private 

   public ChiTietHDDTO() {
	// TODO Auto-generated constructor stub
}
    public ChiTietHDDTO(String MaGiay, String MaHD, int SoLuong, double GiaBan) {
       this.MaGiay = MaGiay;
       this.MaHD = MaHD;
       this.SoLuong = SoLuong;
       this.GiaBan = GiaBan;
    }

    
    
    public String getMaGiay() {
		return MaGiay;
	}

	public void setMaGiay(String maGiay) {
		MaGiay = maGiay;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public Double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}
}
