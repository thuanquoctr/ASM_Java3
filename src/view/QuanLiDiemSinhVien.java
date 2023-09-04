package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.controller_quanlidiemsinhvien;

public class QuanLiDiemSinhVien extends JFrame {
	public JLabel title, lblmasv, tblhotensv, tblmasv1, tbltienganh, tbltinhoc, tblgiaoductc, tbldiemtb,
			tbldiemtbdouble, threesvdiemcao;
	public JPanel p1, p2;
	public JTextField txtmasv, txtmasv1, txthotensv, txttienganh, txttinhoc, txtgiaoductc;
	public JButton btnsearch, btnnew, btnsave, btndelete, btnupdate, btndau, btncuoi, btntien, btnlui;
	public DefaultTableModel model;
	public JTable tb;
	public JFrame frame;
	private controller_quanlidiemsinhvien qldsv;

	public QuanLiDiemSinhVien() {
		GUI();
	}

	public void GUI() {
		frame = new JFrame();
		frame.setTitle("QUẢN LÍ ĐIỂM SINH VIÊN");
		frame.setSize(750, 750);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		title = new JLabel("QUẢN LÍ ĐIỂM SINH VIÊN");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setBounds(120, 10, 700, 70);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1.setBounds(70, 85, 600, 70);
		lblmasv = new JLabel("Mã SV:");
		lblmasv.setFont(new Font("Serif", Font.BOLD, 20));
		lblmasv.setBounds(15, 8, 70, 50);
		p1.add(lblmasv);
		txtmasv = new JTextField();
		txtmasv.setPreferredSize(new Dimension(340, 35));
		txtmasv.setFont(new Font("Serif", Font.BOLD, 20));
		txtmasv.setBounds(100, 15, 345, 40);
		p1.add(txtmasv);
		ImageIcon icsearch = new ImageIcon(
				new ImageIcon("D:\\search.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnsearch = new JButton("Search", icsearch);
		btnsearch.setFont(new Font("Serif", Font.BOLD, 20));
		btnsearch.setBounds(460, 15, 132, 40);
		p1.add(btnsearch);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		p2.setBounds(70, 170, 445, 251);
		tblhotensv = new JLabel("Họ Tên SV:");
		tblhotensv.setBounds(10, 10, 100, 30);
		tblhotensv.setFont(new Font("Serif", Font.BOLD, 20));

		tblmasv1 = new JLabel("Mã SV:");
		tblmasv1.setBounds(10, 60, 100, 30);
		tblmasv1.setFont(new Font("Serif", Font.BOLD, 20));

		tbltienganh = new JLabel("Tiếng Anh:");
		tbltienganh.setBounds(10, 110, 100, 30);
		tbltienganh.setFont(new Font("Serif", Font.BOLD, 20));

		tbltinhoc = new JLabel("Tin Học:");
		tbltinhoc.setBounds(10, 160, 100, 30);
		tbltinhoc.setFont(new Font("Serif", Font.BOLD, 20));

		tblgiaoductc = new JLabel("Giáo Dục TC:");
		tblgiaoductc.setBounds(10, 210, 120, 30);
		tblgiaoductc.setFont(new Font("Serif", Font.BOLD, 20));

		tbldiemtb = new JLabel("Điểm TB:");
		tbldiemtb.setBounds(345, 110, 120, 30);
		tbldiemtb.setFont(new Font("Serif", Font.BOLD, 20));

		tbldiemtbdouble = new JLabel("");
		tbldiemtbdouble.setForeground(Color.red);
		tbldiemtbdouble.setBounds(370, 140, 120, 30);
		tbldiemtbdouble.setFont(new Font("Serif", Font.BOLD, 20));

		p2.add(tblhotensv);
		p2.add(tblmasv1);
		p2.add(tbltienganh);
		p2.add(tbltinhoc);
		p2.add(tblgiaoductc);
		p2.add(tbldiemtb);
		p2.add(tbldiemtbdouble);

		txthotensv = new JTextField();
		txthotensv.setEditable(false);
		txthotensv.setPreferredSize(new Dimension(200, 35));
		txthotensv.setFont(new Font("Serif", Font.BOLD, 20));
		txthotensv.setBounds(130, 7, 205, 40);
		p2.add(txthotensv);

		txtmasv1 = new JTextField();
		txtmasv1.setPreferredSize(new Dimension(200, 35));
		txtmasv1.setFont(new Font("Serif", Font.BOLD, 20));
		txtmasv1.setBounds(130, 57, 205, 40);
		p2.add(txtmasv1);

		txttienganh = new JTextField();
		txttienganh.setPreferredSize(new Dimension(200, 35));
		txttienganh.setFont(new Font("Serif", Font.BOLD, 20));
		txttienganh.setBounds(130, 107, 205, 40);
		p2.add(txttienganh);

		txttinhoc = new JTextField();
		txttinhoc.setPreferredSize(new Dimension(200, 35));
		txttinhoc.setFont(new Font("Serif", Font.BOLD, 20));
		txttinhoc.setBounds(130, 157, 205, 40);
		p2.add(txttinhoc);

		txtgiaoductc = new JTextField();
		txtgiaoductc.setPreferredSize(new Dimension(200, 35));
		txtgiaoductc.setFont(new Font("Serif", Font.BOLD, 20));
		txtgiaoductc.setBounds(130, 207, 205, 40);
		p2.add(txtgiaoductc);

		ImageIcon icnew = new ImageIcon(
				new ImageIcon("D:\\newasmm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnnew = new JButton("New", icnew);
		btnnew.setFont(new Font("Serif", Font.BOLD, 20));
		btnnew.setBounds(530, 171, 132, 40);

		ImageIcon icsave = new ImageIcon(
				new ImageIcon("D:\\saveasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnsave = new JButton("Save", icsave);
		btnsave.setFont(new Font("Serif", Font.BOLD, 20));
		btnsave.setBounds(530, 241, 132, 40);

		ImageIcon icdelete = new ImageIcon(
				new ImageIcon("D:\\deleteasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btndelete = new JButton("Delete", icdelete);
		btndelete.setFont(new Font("Serif", Font.BOLD, 20));
		btndelete.setBounds(530, 311, 132, 40);

		ImageIcon icupdate = new ImageIcon(
				new ImageIcon("D:\\updateasm.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		btnupdate = new JButton("Update", icupdate);
		btnupdate.setFont(new Font("Serif", Font.BOLD, 20));
		btnupdate.setBounds(530, 381, 132, 40);

		ImageIcon lui = new ImageIcon(
				new ImageIcon("D:\\lui.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		btnlui = new JButton(lui);
		btnlui.setBounds(200, 430, 70, 40);

		ImageIcon tien = new ImageIcon(
				new ImageIcon("D:\\tien.png").getImage().getScaledInstance(33, 33, java.awt.Image.SCALE_SMOOTH));
		btntien = new JButton(tien);
		btntien.setBounds(322, 430, 70, 40);

		ImageIcon dau = new ImageIcon(
				new ImageIcon("D:\\dau.png").getImage().getScaledInstance(33, 33, java.awt.Image.SCALE_SMOOTH));
		btndau = new JButton(dau);
		btndau.setBounds(70, 430, 70, 40);

		ImageIcon cuoi = new ImageIcon(
				new ImageIcon("D:\\cuoi.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		btncuoi = new JButton(cuoi);
		btncuoi.setBounds(445, 430, 70, 40);

		threesvdiemcao = new JLabel("# 3 Sinh Viên Có Điểm Cao Nhất :");
		threesvdiemcao.setForeground(Color.RED);
		threesvdiemcao.setFont(new Font("Serif", Font.BOLD, 20));
		threesvdiemcao.setBounds(70, 480, 290, 30);

		String[] colunm = { "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB" };
		Object[][] data = { { "1", "thuan", "9", "9", "9", "9" } };
		model = new DefaultTableModel(data, colunm);
		tb = new JTable(model);
		tb.setFont(new Font("Serif", Font.BOLD, 17));
		JTableHeader header = tb.getTableHeader();
		Font font = new Font("Serif", Font.BOLD, 20);
		header.setFont(font);
		header.setForeground(Color.BLUE);
		tb.setPreferredScrollableViewportSize(new Dimension(700, 170));
		JScrollPane scrollPane = new JScrollPane(tb);
		scrollPane.setBounds(18, 520, 700, 175);

		ActionListener ac = new controller_quanlidiemsinhvien(this);
		btnsearch.addActionListener(ac);
		btnnew.addActionListener(ac);
		btnsave.addActionListener(ac);
		btndelete.addActionListener(ac);
		btnupdate.addActionListener(ac);
		btntien.addActionListener(ac);
		btnlui.addActionListener(ac);
		btndau.addActionListener(ac);
		btncuoi.addActionListener(ac);
		frame.add(title);
		frame.add(p1);
		frame.add(p2);
		frame.add(btnnew);
		frame.add(btnsave);
		frame.add(btndelete);
		frame.add(btnupdate);
		frame.add(btnlui);
		frame.add(btntien);
		frame.add(btndau);
		frame.add(btncuoi);
		frame.add(threesvdiemcao);
		frame.add(scrollPane);
		frame.setVisible(true);
	}

}
