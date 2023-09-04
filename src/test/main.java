package test;

import javax.swing.UIManager;

import view.Login;

public class main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Login login = new Login();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
