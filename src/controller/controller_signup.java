package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.userDAO;
import model.user;
import view.Login;
import view.SignUp;

public class controller_signup implements ActionListener {
	private SignUp sgu;

	public controller_signup(SignUp sgu) {
		this.sgu = sgu;
	}

	public boolean checknull() {
		if (sgu.txttaikhoan.getText().trim().equals("")) {
			return false;
		}
		if (sgu.txtmatkhau.getText().trim().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Create")) {
			if (checknull()) {
				user us = new user(sgu.txttaikhoan.getText(), sgu.txtmatkhau.getText(), sgu.cbx.getSelectedItem() + "");
				int kq = userDAO.getUserDAO().insert(us);
				if (kq > 0) {
					JOptionPane.showMessageDialog(null, "Tạo thành công !");
					sgu.frame.dispose();
					Login l = new Login();
				} else {
					JOptionPane.showMessageDialog(null, "Tạo không thành công !");
					sgu.txttaikhoan.setText("");
					sgu.txtmatkhau.setText("");
					sgu.cbx.setSelectedIndex(0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin ! ");
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
