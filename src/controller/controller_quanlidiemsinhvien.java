package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.Login;
import view.QuanLiDiemSinhVien;

public class controller_quanlidiemsinhvien implements ActionListener {
	private QuanLiDiemSinhVien qldsv;
	private int indexx;

	public controller_quanlidiemsinhvien(QuanLiDiemSinhVien qldsv) {
		this.qldsv = qldsv;
		fill();
		qldsv.tb.addMouseListener(new MouseListener() {

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
				int index = qldsv.tb.getSelectedRow();
				String ma = qldsv.tb.getValueAt(index, 0).toString();
				String ten = qldsv.tb.getValueAt(index, 1).toString();
				String ta = qldsv.tb.getValueAt(index, 2).toString();
				String th = qldsv.tb.getValueAt(index, 3).toString();
				String gd = qldsv.tb.getValueAt(index, 4).toString();
				qldsv.txtmasv1.setText(ma);
				qldsv.txthotensv.setText(ten);
				qldsv.txttienganh.setText(ta);
				qldsv.txttinhoc.setText(th);
				qldsv.txtgiaoductc.setText(gd);
				double dtb = (Double.parseDouble(qldsv.txttienganh.getText())
						+ Double.parseDouble(qldsv.txttinhoc.getText())
						+ Double.parseDouble(qldsv.txtgiaoductc.getText())) / 3;
				String dtbnew = String.format("%.2f", dtb);
				qldsv.tbldiemtbdouble.setText(dtbnew);

			}
		});

		qldsv.frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Thoát",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					qldsv.frame.dispose();
					Login l = new Login();
				}
			}
		});
	}

	public void fill() {
		qldsv.model.setRowCount(0);
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = " SELECT * FROM grade as g join students as s on g.masv = s.masv ORDER BY (tienganh + tinhoc + gdtc) DESC LIMIT 3 ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String masv = rs.getString("masv");
				String hoten = rs.getString("s.hoten");
				int ta = rs.getInt("g.tienganh");
				int th = rs.getInt("g.tinhoc");
				int gd = rs.getInt("g.gdtc");
				Object[] datanew = { masv, hoten, ta, th, gd, (ta + th + gd) / 3 };
				qldsv.model.addRow(datanew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checknull() {
		if (qldsv.txtmasv1.getText().trim().equals("")) {
			return false;
		}
		if (qldsv.txttienganh.getText().trim().equals("")) {
			return false;
		}
		if (qldsv.txttinhoc.getText().trim().equals("")) {
			return false;
		}
		if (qldsv.txtgiaoductc.getText().trim().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Search")) {
			try {
				Connection connection = JDBCUtil.getConnection();
				String sql = "select t.hoten, t.masv,g.tienganh,g.tinhoc,g.gdtc from students as t left join grade as g on g.masv = t.masv where t.masv = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, qldsv.txtmasv.getText());
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					String masvv = rs.getString("t.masv");
					String hotenn = rs.getString("t.hoten");
					int taa = rs.getInt("g.tienganh");
					int thh = rs.getInt("g.tinhoc");
					int gdd = rs.getInt("g.gdtc");
					qldsv.txthotensv.setText(hotenn);
					qldsv.txtmasv1.setText(masvv);
					qldsv.txttienganh.setText(String.valueOf(taa));
					qldsv.txttinhoc.setText(String.valueOf(thh));
					qldsv.txtgiaoductc.setText(String.valueOf(gdd));
					double dtbb = (Double.parseDouble(qldsv.txttienganh.getText())
							+ Double.parseDouble(qldsv.txttinhoc.getText())
							+ Double.parseDouble(qldsv.txtgiaoductc.getText())) / 3;
					String dtbneww = String.format("%.2f", dtbb);
					qldsv.tbldiemtbdouble.setText(dtbneww);
				} else {
					JOptionPane.showMessageDialog(null, "Mã SV này chưa tồn tại !");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (event.equals("New")) {
			qldsv.txthotensv.setText("");
			qldsv.txthotensv.requestFocus();
			qldsv.txtmasv1.setText("");
			qldsv.txttienganh.setText("");
			qldsv.txttinhoc.setText("");
			qldsv.txtgiaoductc.setText("");
		}
		if (event.equals("Update")) {
			double avtam = Double.parseDouble(qldsv.txttienganh.getText());
			double thtam = Double.parseDouble(qldsv.txttinhoc.getText());
			double gttam = Double.parseDouble(qldsv.txtgiaoductc.getText());
			if (avtam > 10 || thtam > 10 || gttam > 10) {
				JOptionPane.showMessageDialog(null, "Điểm không hợp lệ !");
				return;
			} else {
				try {
					Connection connection = JDBCUtil.getConnection();
					Statement statement = connection.createStatement();
					String sql = "update grade set tienganh =" + Integer.parseInt(qldsv.txttienganh.getText()) + ","
							+ " tinhoc =" + Integer.parseInt(qldsv.txttinhoc.getText()) + "," + "gdtc = "
							+ Integer.parseInt(qldsv.txtgiaoductc.getText()) + " where masv ='"
							+ qldsv.txtmasv1.getText() + "'";
					int kq = statement.executeUpdate(sql);
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Updae thành công !");
						fill();
						return;
					} else {
						JOptionPane.showMessageDialog(null, "Khong duoc Update MaSV !");
						return;
					}
				} catch (SQLException exx) {
					// TODO Auto-generated catch block
					exx.printStackTrace();
				}
			}

		}
		if (event.equals("Save")) {
			if (checknull()) {
				try {
					double avtam = Double.parseDouble(qldsv.txttienganh.getText());
					double thtam = Double.parseDouble(qldsv.txttinhoc.getText());
					double gttam = Double.parseDouble(qldsv.txtgiaoductc.getText());
					if (avtam > 10 || thtam > 10 || gttam > 10) {
						JOptionPane.showMessageDialog(null, "Điểm không hợp lệ !");
						return;
					}
					Connection connection = JDBCUtil.getConnection();
					String sql = "insert into grade(masv,tienganh,tinhoc,gdtc) values(?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, qldsv.txtmasv1.getText());
					statement.setString(2, qldsv.txttienganh.getText());
					statement.setString(3, qldsv.txttinhoc.getText());
					statement.setString(4, qldsv.txtgiaoductc.getText());
					int kq = statement.executeUpdate();
					fill();
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Save thành công !");

					} else {
						JOptionPane.showMessageDialog(null, "Save không thành công !");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Vui long chon sinh vien muon them diem !");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin !");
			}
		}
		if (event.equals("Delete")) {
			if (!qldsv.txtmasv1.getText().equals("")) {
				try {
					Connection connection = JDBCUtil.getConnection();
					String sql = "delete from grade where masv = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, qldsv.txtmasv1.getText());
					int kq = statement.executeUpdate();
					if (kq > 0) {
						JOptionPane.showMessageDialog(null, "Delete thanh cong !");
						fill();
						qldsv.txtmasv1.setText("");
						qldsv.txthotensv.setText("");
						qldsv.txttienganh.setText("");
						qldsv.txttinhoc.setText("");
						qldsv.txtgiaoductc.setText("");
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
		if (e.getSource() == qldsv.btntien) {
			try {
				indexx = qldsv.tb.getSelectedRow() + 1;
				if (indexx > 2) {
					indexx = 0;
				}
				qldsv.tb.setRowSelectionInterval(indexx, indexx);
				Connection cnss = JDBCUtil.getConnection();
				String sqll = "select st.hoten,g.masv,g.tienganh,g.tinhoc,g.gdtc from grade as g join students as st on st.masv = g.masv where g.masv = ?";
				PreparedStatement stt = cnss.prepareStatement(sqll);
				stt.setString(1, String.valueOf(qldsv.tb.getValueAt(indexx, 0)));
				ResultSet rss = stt.executeQuery();
				while (rss.next()) {
					qldsv.txthotensv.setText(rss.getString("st.hoten"));
					qldsv.txtmasv1.setText(rss.getString("g.masv"));
					qldsv.txttienganh.setText(rss.getString("g.tienganh"));
					qldsv.txttinhoc.setText(rss.getString("g.tinhoc"));
					qldsv.txtgiaoductc.setText(rss.getString("g.gdtc"));
					double dtb = (Double.parseDouble(qldsv.txttienganh.getText())
							+ Double.parseDouble(qldsv.txttinhoc.getText())
							+ Double.parseDouble(qldsv.txtgiaoductc.getText())) / 3;
					String dtbnew = String.format("%.2f", dtb);
					qldsv.tbldiemtbdouble.setText(dtbnew);
				}
			} catch (SQLException e2) {

			}
		}

		if (e.getSource() == qldsv.btnlui) {
			try {
				Connection cns = JDBCUtil.getConnection();
				String sql = "select count(*) from grade";
				PreparedStatement st = cns.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					int length = Integer.parseInt(rs.getString("count(*)"));
					indexx = qldsv.tb.getSelectedRow() - 1;
					if (indexx < 0) {
						indexx = 2;
					}
					qldsv.tb.setRowSelectionInterval(indexx, indexx);
					Connection cnss = JDBCUtil.getConnection();
					String sqll = "select st.hoten,g.masv,g.tienganh,g.tinhoc,g.gdtc from grade as g join students as st on st.masv = g.masv where g.masv = ?";
					PreparedStatement stt = cnss.prepareStatement(sqll);
					stt.setString(1, String.valueOf(qldsv.tb.getValueAt(indexx, 0)));
					ResultSet rss = stt.executeQuery();
					while (rss.next()) {
						qldsv.txthotensv.setText(rss.getString("st.hoten"));
						qldsv.txtmasv1.setText(rss.getString("g.masv"));
						qldsv.txttienganh.setText(rss.getString("g.tienganh"));
						qldsv.txttinhoc.setText(rss.getString("g.tinhoc"));
						qldsv.txtgiaoductc.setText(rss.getString("g.gdtc"));
						double dtb = (Double.parseDouble(qldsv.txttienganh.getText())
								+ Double.parseDouble(qldsv.txttinhoc.getText())
								+ Double.parseDouble(qldsv.txtgiaoductc.getText())) / 3;
						String dtbnew = String.format("%.2f", dtb);
						qldsv.tbldiemtbdouble.setText(dtbnew);
					}
				}
			} catch (SQLException e2) {

			}
		}

		if (e.getSource() == qldsv.btndau) {
			indexx = 0;
			qldsv.txtmasv1.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 1)));
			qldsv.tblhotensv.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 0)));
			qldsv.txttienganh.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 2)));
			qldsv.txttinhoc.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 3)));
			qldsv.txtgiaoductc.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 4)));
			qldsv.tbldiemtbdouble.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 5)));
			qldsv.tb.setRowSelectionInterval(indexx, indexx);
		}
		if (e.getSource() == qldsv.btncuoi) {
			try {
				indexx = 2;
				qldsv.txtmasv1.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 1)));
				qldsv.tblhotensv.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 0)));
				qldsv.txttienganh.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 2)));
				qldsv.txttinhoc.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 3)));
				qldsv.txtgiaoductc.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 4)));
				qldsv.tbldiemtbdouble.setText(String.valueOf(qldsv.tb.getValueAt(indexx, 5)));
				qldsv.tb.setRowSelectionInterval(indexx, indexx);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
