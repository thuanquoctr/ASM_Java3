package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.Login;
import view.QuanLiSinhVien;

public class controller_quanlisinhvien implements ActionListener {
	private QuanLiSinhVien qlsv;
	String duongdan = "";

	public controller_quanlisinhvien(QuanLiSinhVien qlsv) {
		this.qlsv = qlsv;
		filll();
		qlsv.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Thoát",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					qlsv.frame.dispose();
					Login l = new Login();
				}
			}
		});
		qlsv.tb.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = qlsv.tb.getSelectedRow();
				String ma = qlsv.tb.getValueAt(index, 0).toString();
				String ten = qlsv.tb.getValueAt(index, 1).toString();
				String email = qlsv.tb.getValueAt(index, 2).toString();
				String sdt = qlsv.tb.getValueAt(index, 3).toString();
				String gioitinh = qlsv.tb.getValueAt(index, 4).toString();
				if (gioitinh.equals("1")) {
					qlsv.nam.setSelected(true);
				} else {
					qlsv.nu.setSelected(true);
				}
				String dchi = qlsv.tb.getValueAt(index, 5).toString();
				String img = qlsv.tb.getValueAt(index, 6).toString();
				qlsv.txtmasv.setText(ma);
				qlsv.txthoten.setText(ten);
				qlsv.txtemail.setText(email);
				qlsv.txtsdt.setText(sdt);
				qlsv.txtdiachi.setText(dchi);
				if(img != null) {
					ImageIcon icupdate = new ImageIcon(
							new ImageIcon(img).getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
					qlsv.lblanh.setIcon(icupdate);
				}
				

			}
		});
	}

	public void filll() {
		qlsv.model.setRowCount(0);
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "select * from students";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String masv = rs.getString("masv");
				String hoten = rs.getString("hoten");
				String email = rs.getString("email");
				String sdt = rs.getString("sodt");
				int gt = rs.getInt("gioitinh");
				String dc = rs.getString("diachi");
				String hinh = rs.getString("hinh");
				Object[] datanew = { masv, hoten, email, sdt, gt, dc, hinh };
				qlsv.model.addRow(datanew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checknull() {
		if (qlsv.txtmasv.getText().trim().equals("")) {
			return false;
		}
		if (qlsv.txthoten.getText().trim().equals("")) {
			return false;
		}
		if (qlsv.txtemail.getText().trim().equals("")) {
			return false;
		}
		if (qlsv.txtsdt.getText().trim().equals("")) {
			return false;
		}
		if (qlsv.txtdiachi.getText().trim().equals("")) {
			return false;
		}
		if (!qlsv.nam.isSelected() && !qlsv.nu.isSelected()) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Save")) {
			if (checknull()) {
				try {
					Connection connection = JDBCUtil.getConnection();
					String sql = "insert into students" + " values(?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, qlsv.txtmasv.getText());
					statement.setString(2, qlsv.txthoten.getText());
					statement.setString(3, qlsv.txtemail.getText());
					statement.setString(4, qlsv.txtsdt.getText());

					int gt = -1;
					if (qlsv.nam.isSelected()) {
						gt = 1;
					}
					if (qlsv.nu.isSelected()) {
						gt = 0;
					}
					statement.setInt(5, gt);
					statement.setString(6, qlsv.txtdiachi.getText());
					statement.setString(7, duongdan);
					int kq = statement.executeUpdate();
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Save thành công !");
						filll();
					} else {
						JOptionPane.showMessageDialog(null, "Save không thành công !");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "MaSV ton tai , vui long dien MaSV khac !");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin !");
			}
		}
		if (event.equals("New")) {
			qlsv.txtmasv.setText("");
			qlsv.txthoten.setText("");
			qlsv.txtemail.setText("");
			qlsv.txtsdt.setText("");
			qlsv.gr1.clearSelection();
			qlsv.txtdiachi.setText("");

		}
		if (event.equals("Delete")) {
			if (!qlsv.txtmasv.getText().equals("")) {
				try {
					Connection connection = JDBCUtil.getConnection();
					String sql = "delete from students where masv = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, qlsv.txtmasv.getText());
					int kq = statement.executeUpdate();
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Delete thanh cong !");
						filll();
						qlsv.txtmasv.setText("");
						qlsv.txthoten.setText("");
						qlsv.txtemail.setText("");
						qlsv.txtsdt.setText("");
						qlsv.gr1.clearSelection();
						qlsv.txtdiachi.setText("");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "Delete that bai !");
						return;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Delete that bai !");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui long chon MaSV muon xoa !");
				return;
			}
		}

		if (event.equals("Update")) {
			if (!qlsv.txtmasv.getText().equals("")) {
				try {
					Connection connection = JDBCUtil.getConnection();
					String sql = "update students set hoten = ? , email = ? ,sodt = ? ,gioitinh = ? ,diachi = ? ,hinh = ? where masv = ?";
					PreparedStatement statement = connection.prepareStatement(sql);

					statement.setString(1, qlsv.txthoten.getText());
					statement.setString(2, qlsv.txtemail.getText());
					statement.setString(3, qlsv.txtsdt.getText());

					int gt = -1;
					if (qlsv.nam.isSelected()) {
						gt = 1;
					}
					if (qlsv.nu.isSelected()) {
						gt = 0;
					}
					statement.setInt(4, gt);
					statement.setString(5, qlsv.txtdiachi.getText());
					statement.setString(6, duongdan);
					statement.setString(7, qlsv.txtmasv.getText());
					int kq = statement.executeUpdate();
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Update thành công !");
						filll();
					} else {
						JOptionPane.showMessageDialog(null, "Update không thành công !");
						return;
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Update that bai !");
					return;
				}
			}

		}
		if (event.equals("Đính Kèm")) {
			try {
				JFileChooser f = new JFileChooser("D:\\");
				f.setDialogTitle("Mở file");
				f.showOpenDialog(null);
				f.setForeground(Color.red);
				File ftenanh = f.getSelectedFile();
				duongdan = ftenanh.getAbsolutePath();

				ImageIcon icupdate = new ImageIcon(
						new ImageIcon(duongdan).getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
				qlsv.lblanh.setIcon(icupdate);
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}
}
