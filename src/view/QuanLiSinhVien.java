package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.controller_quanlisinhvien;
import test.main;

public class QuanLiSinhVien extends JFrame {
	public JFrame frame;
	public JLabel lbltitle, lblmasv, lblhoten, lblemail, lblsodt, lblgioitinh, lbldiachi, lblanh;
	public JTextField txtmasv, txthoten, txtemail, txtsdt;
	public JRadioButton nam, nu;
	public ButtonGroup gr1;
	public JTextArea txtdiachi;
	public JScrollPane diachi;
	public JButton btnnew, btnsave, btndelete, btnupdate, btnchonanh;
	public JTableHeader header;
	public JTable tb;
	public DefaultTableModel model;
	public JPanel anh;

	public QuanLiSinhVien() {
		GUI();
	}

	public void GUI() {
		frame = new JFrame();
		frame.setTitle("QUẢN LÍ SINH VIÊN");
		frame.setSize(750, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLayout(null);
		lbltitle = new JLabel("QUẢN LÍ SINH VIÊN");
		lbltitle.setFont(new Font("Serif", Font.BOLD, 40));
		lbltitle.setBounds(170, 10, 700, 70);
		lblmasv = new JLabel("Mã SV:");
		lblmasv.setFont(new Font("Serif", Font.BOLD, 20));
		lblmasv.setBounds(40, 100, 100, 30);

		lblhoten = new JLabel("Họ Tên:");
		lblhoten.setFont(new Font("Serif", Font.BOLD, 20));
		lblhoten.setBounds(40, 150, 100, 30);

		lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Serif", Font.BOLD, 20));
		lblemail.setBounds(40, 200, 100, 30);

		lblsodt = new JLabel("Số ĐT:");
		lblsodt.setFont(new Font("Serif", Font.BOLD, 20));
		lblsodt.setBounds(40, 250, 100, 30);

		lblgioitinh = new JLabel("Giới Tính:");
		lblgioitinh.setFont(new Font("Serif", Font.BOLD, 20));
		lblgioitinh.setBounds(40, 300, 100, 30);

		lbldiachi = new JLabel("Địa Chỉ:");
		lbldiachi.setFont(new Font("Serif", Font.BOLD, 20));
		lbldiachi.setBounds(40, 350, 100, 30);

		txtmasv = new JTextField();
		txtmasv.setPreferredSize(new Dimension(250, 35));
		txtmasv.setFont(new Font("Serif", Font.BOLD, 20));
		txtmasv.setBounds(150, 97, 255, 40);

		txthoten = new JTextField();
		txthoten.setPreferredSize(new Dimension(250, 35));
		txthoten.setFont(new Font("Serif", Font.BOLD, 20));
		txthoten.setBounds(150, 147, 255, 40);

		txtemail = new JTextField();
		txtemail.setPreferredSize(new Dimension(250, 35));
		txtemail.setFont(new Font("Serif", Font.BOLD, 20));
		txtemail.setBounds(150, 197, 255, 40);

		txtsdt = new JTextField();
		txtsdt.setPreferredSize(new Dimension(250, 35));
		txtsdt.setFont(new Font("Serif", Font.BOLD, 20));
		txtsdt.setBounds(150, 247, 255, 40);

		nam = new JRadioButton("Nam");
		nam.setFont(new Font("Serif", Font.BOLD, 20));
		nam.setBounds(160, 295, 80, 40);

		nu = new JRadioButton("Nữ");
		nu.setFont(new Font("Serif", Font.BOLD, 20));
		nu.setBounds(250, 295, 80, 40);

		gr1 = new ButtonGroup();
		gr1.add(nam);
		gr1.add(nu);

		txtdiachi = new JTextArea(10, 0);
		txtdiachi.setFont(new Font("Serif", Font.BOLD, 20));
		txtdiachi.setLineWrap(true);
		diachi = new JScrollPane(txtdiachi);
		diachi.setBounds(150, 350, 255, 120);

		ImageIcon icnew = new ImageIcon(
				new ImageIcon("D:\\newasmm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnnew = new JButton("New", icnew);
		btnnew.setFont(new Font("Serif", Font.BOLD, 20));
		btnnew.setBounds(420, 350, 132, 40);

		ImageIcon icsave = new ImageIcon(
				new ImageIcon("D:\\saveasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnsave = new JButton("Save", icsave);
		btnsave.setFont(new Font("Serif", Font.BOLD, 20));
		btnsave.setBounds(560, 350, 132, 40);

		ImageIcon icdelete = new ImageIcon(
				new ImageIcon("D:\\deleteasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btndelete = new JButton("Delete", icdelete);
		btndelete.setFont(new Font("Serif", Font.BOLD, 20));
		btndelete.setBounds(420, 429, 132, 40);

		ImageIcon icupdate = new ImageIcon(
				new ImageIcon("D:\\updateasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnupdate = new JButton("Update", icupdate);
		btnupdate.setFont(new Font("Serif", Font.BOLD, 20));
		btnupdate.setBounds(560, 429, 132, 40);

		String[] colunm = { "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình" };
		Object[][] data = { { "1", "thuan", "thuan@123", "12345678", "Nam", "Long An", "D:\\iconbg.png" } };
		model = new DefaultTableModel(data, colunm);
		tb = new JTable(model);
		tb.setFont(new Font("Serif", Font.BOLD, 17));
		JTableHeader header = tb.getTableHeader();
		Font font = new Font("Serif", Font.BOLD, 20);
		header.setFont(font);
		header.setForeground(Color.BLUE);
		tb.setPreferredScrollableViewportSize(new Dimension(700, 170));
		JScrollPane scrollPane = new JScrollPane(tb);
		scrollPane.setBounds(18, 500, 700, 195);

		anh = new JPanel();
		anh.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		anh.setBounds(480, 117, 150, 150);
		lblanh = new JLabel();
		anh.add(lblanh);

		btnchonanh = new JButton("Đính Kèm");
		btnchonanh.setFont(new Font("Serif", Font.BOLD, 20));
		btnchonanh.setBounds(480, 270, 150, 40);

		ActionListener ac = new controller_quanlisinhvien(this);
		btnnew.addActionListener(ac);
		btnsave.addActionListener(ac);
		btndelete.addActionListener(ac);
		btnupdate.addActionListener(ac);
		btnchonanh.addActionListener(ac);
		frame.add(lbltitle);
		frame.add(lblmasv);
		frame.add(lblhoten);
		frame.add(lblemail);
		frame.add(lblsodt);
		frame.add(lblgioitinh);
		frame.add(lbldiachi);
		frame.add(txtmasv);
		frame.add(txthoten);
		frame.add(txtemail);
		frame.add(txtsdt);
		frame.add(nam);
		frame.add(nu);
		frame.add(diachi);
		frame.add(btnnew);
		frame.add(btnsave);
		frame.add(btndelete);
		frame.add(btnupdate);
		frame.add(scrollPane);
		frame.add(anh);
		frame.add(btnchonanh);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		QuanLiSinhVien q = new QuanLiSinhVien();
	}
}
