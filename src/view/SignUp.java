package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.controller_signup;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
	public JFrame frame;
	public JPanel p1, p2;
	public JLabel tieude, taikhoan, matkhau, quyendangnhap;
	public JTextField txttaikhoan;
	public JPasswordField txtmatkhau;
	public JLabel hacker, icuser, icpass;
	public JButton btncreate, btncancel;
	public JComboBox cbx;

	public SignUp() {
		GUI();
	}

	public void GUI() {
		frame = new JFrame();
		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon iconhacker = new ImageIcon(
				new ImageIcon("D:\\iconbg.png").getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
		hacker = new JLabel(iconhacker);
		p1 = new JPanel();
		p1.setLayout(null);
		hacker.setBounds(40, 0, 350, 450);
		p1.setBackground(new Color(25, 118, 211));
		p1.add(hacker);
		p2 = new JPanel();
		p2.setLayout(null);
		tieude = new JLabel("Create Account");
		tieude.setBounds(55, 10, 400, 100);
		tieude.setFont(new Font("Serif", Font.BOLD, 50));
		p2.add(tieude);
		taikhoan = new JLabel("Username:");
		taikhoan.setFont(new Font("Serif", Font.BOLD, 20));
		matkhau = new JLabel("Password:");
		matkhau.setFont(new Font("Serif", Font.BOLD, 20));
		quyendangnhap = new JLabel("Login với quyền:");
		quyendangnhap.setFont(new Font("Serif", Font.BOLD, 20));
		taikhoan.setBounds(10, 135, 100, 50);
		matkhau.setBounds(10, 215, 100, 50);
		quyendangnhap.setBounds(10, 295, 150, 50);
		p2.add(taikhoan);
		p2.add(matkhau);
		p2.add(quyendangnhap);
		txttaikhoan = new JTextField();
		txttaikhoan.setPreferredSize(new Dimension(220, 40));
		txttaikhoan.setFont(new Font("Serif", Font.BOLD, 20));
		txtmatkhau = new JPasswordField();
		txtmatkhau.setPreferredSize(new Dimension(220, 50));
		txtmatkhau.setFont(new Font("Serif", Font.BOLD, 20));
		txttaikhoan.setBounds(165, 130, 225, 45);
		txtmatkhau.setBounds(165, 210, 225, 45);
		txttaikhoan.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		txtmatkhau.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		p2.add(txttaikhoan);
		p2.add(txtmatkhau);
		p2.setBackground(Color.WHITE);
		String[] quyen = { "Giảng Viên", "Cán Bộ Đào Tạo" };
		cbx = new JComboBox(quyen);
		cbx.setBounds(180, 295, 180, 50);
		cbx.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(cbx);
		ImageIcon icusername = new ImageIcon(
				new ImageIcon("D:\\iconuser.jpeg").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		ImageIcon iconpassword = new ImageIcon(
				new ImageIcon("D:\\iconpass.jpeg").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		icuser = new JLabel(icusername);
		icpass = new JLabel(iconpassword);
		icuser.setBounds(120, 147, 30, 30);
		icpass.setBounds(120, 225, 30, 30);
		p2.add(icuser);
		p2.add(icpass);

		btncreate = new JButton("Create");
		btncreate.setBounds(100, 360, 132, 40);
		btncreate.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(btncreate);

		btncancel = new JButton("Cancel");
		btncancel.setBounds(250, 360, 132, 40);
		btncancel.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(btncancel);
		ActionListener ac = new controller_signup(this);
		btncreate.addActionListener(ac);
		btncancel.addActionListener(ac);

		frame.setLayout(new GridLayout(1, 2));
		frame.add(p1);
		frame.add(p2);
		frame.setVisible(true);
	}
}
