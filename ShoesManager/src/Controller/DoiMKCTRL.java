package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAO.*;
import DTO.*;
import GUI.*;

public class DoiMKCTRL {
	LoginDAO lg = new LoginDAO();
	public void check() throws SQLException {
		String mkht = DoiMKGUI.txtMKHT.getText();
		String mkm = DoiMKGUI.txtNewPass.getText();
		String cf = DoiMKGUI.txtConfirm.getText();

		if (mkht.equals(mkm)) {
			JOptionPane.showMessageDialog(null, "Không được trùng");
		} else if (!mkht.equals(QuanLyGUI.lblMkan.getText())) {
			JOptionPane.showMessageDialog(null,"Mật khẩu hiện tại đang sai");
		}else if(!mkm.equals(cf)) {
			JOptionPane.showMessageDialog(null, "Mật khẩu mới không trùng với mục nhập lại mật khẩu");
		}else {
			String id = QuanLyGUI.lblidAn.getText();
			lg.UpdateMK(mkm,id);
			JOptionPane.showMessageDialog(null, "Thành Công");
			DoiMKGUI.frame.setVisible(false);
		}
	}

}
