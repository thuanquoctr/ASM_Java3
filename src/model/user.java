package model;

public class user {
	private String usernamee, passwordd, rolee;

	public user() {
	}

	public user(String usernamee, String passwordd, String rolee) {
		this.usernamee = usernamee;
		this.passwordd = passwordd;
		this.rolee = rolee;
	}

	public String getUsernamee() {
		return usernamee;
	}

	public void setUsernamee(String usernamee) {
		this.usernamee = usernamee;
	}

	public String getPasswordd() {
		return passwordd;
	}

	public void setPasswordd(String passwordd) {
		this.passwordd = passwordd;
	}

	public String getRolee() {
		return rolee;
	}

	public void setRolee(String rolee) {
		this.rolee = rolee;
	}

}
