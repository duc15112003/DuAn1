package DAO;
import javax.mail.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.ExtendedSSLSession;
import javax.swing.JOptionPane;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

public class LoginDAO {
	
	 String name;
	 String pass;
	 String loai;
	 PreparedStatement ps;
	 ResultSet rs;
	 int index = 0;
	 
	ConnectionSQL cn = new ConnectionSQL();
	List<TaiKhoanDTO> list = new ArrayList<>();
	
	
	public List<TaiKhoanDTO> select(String sql,Object...args) throws SQLException{
		List<TaiKhoanDTO> list = new ArrayList<>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			TaiKhoanDTO tk = readdata(rs);
			list.add(tk);
		}
		return list;
		
	}
	
	public void Insert(String ma) {
		String sql = "use qlcuahanggiaydb; insert tbltaikhoan values(?,?,?)";
		cn.executeUpdate(sql, ma,"123","NV");
	}
	
	public void Update(TaiKhoanDTO tk) {
		String sql = "use qlcuahanggiaydb; update tblnhanvien set matkhau = ? where tendangnhap = ?";
		cn.executeQuery(sql,tk.getMatkhau(),tk.getTendangnhap());
	}
	
	public TaiKhoanDTO findTK(String user,String pass) throws SQLException{
		String sql = "use qlcuahanggiaydb;select * from tbltaikhoan where tendangnhap = ? and matkhau = ?";
		List<TaiKhoanDTO> tk = select(sql, user,pass);
		return list.size()>0 ? list.get(0):null;
	}
	
	public void UpdateMK(String mk,String tendangnhap) throws SQLException {
		String sql = "use qlcuahanggiaydb; Update tbltaikhoan set matkhau = ? where tendangnhap = ?";
		cn.executeUpdate(sql, mk,tendangnhap);
	}
	
	public TaiKhoanDTO readdata(ResultSet rs) throws SQLException {
		TaiKhoanDTO tk = new TaiKhoanDTO();
		tk.setTendangnhap(rs.getString(1));
		tk.setMatkhau(rs.getString(2));
		tk.setCapbac(rs.getString(3));
		return tk;
	}
	public int codePass(String email) {
		boolean ret = true;
		int so1 = (int)(Math.random() * 999999);
		try {
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", 587);
			final String accountName = "phuctphps26443@fpt.edu.vn";
			final String accountPassword = "mkvbkkclysiiniam";
			String textsubject ="Thay Đổi Mật Khẩu Tài Khoản";
			String textcontent = "Bạn Đang Yêu Cầu đổi mật khẩu cho tài khoản gán email "+email+" Mã code kích hoạt thay đổi là: "+ so1;
			Session s = Session.getInstance(p,
					new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(accountName, accountPassword);
					}
					});
			Message msg = new MimeMessage(s);
			try {
				msg.setFrom(new InternetAddress(accountName));//laays email từ input dialog
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));// nhận từ inputdialog
				msg.setSubject("CC");
				msg.setText(textcontent);
				Transport.send(msg);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return so1;
		
	}
	
	public boolean isCode(int codeNhap,int codeEmail) {
		boolean ret = false;
		if(codeNhap == codeEmail) {
			ret = true;
		}else {
			ret = false;
		}
		return ret;
	}
}
