package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.Login;
import view.QuanLiDiemSinhVien;
import view.QuanLiSinhVien;
import view.SignUp;

public class controller_login implements ActionListener{
	private Login lg;
	
	public controller_login(Login lg) {
		this.lg = lg;
	}
	
	public boolean checknull() {
		if (lg.txttaikhoan.getText().trim().equals("")) {
			return false;
		}
		if (lg.txtmatkhau.getText().trim().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Sign Up")) {
			lg.frame.dispose();
			SignUp signup = new SignUp();
		}
		if (event.equals("Login")) {
			if (checknull()) {
				try {
					Connection connection = JDBCUtil.getConnection();
					String sql = "SELECT * FROM users WHERE usernamee = ? AND passwordd = ? AND rolee = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, lg.txttaikhoan.getText());
					statement.setString(2, lg.txtmatkhau.getText());
					statement.setString(3, lg.cbx.getSelectedItem() + "");
					ResultSet rs = statement.executeQuery();
					if (rs.next()) {
						if (rs.getString("rolee").equals("Giảng Viên")) {
							lg.frame.dispose();
							JOptionPane.showMessageDialog(null, "Login Succesfully");
							QuanLiDiemSinhVien ql = new QuanLiDiemSinhVien();
						}
						if (rs.getString("rolee").equals("Cán Bộ Đào Tạo")) {
							lg.frame.dispose();
							JOptionPane.showMessageDialog(null, "Login Succesfully");
							QuanLiSinhVien ql = new QuanLiSinhVien();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin !");
			}
		}
		if (event.equals("Cancel")) {
			int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Thoát",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

}
