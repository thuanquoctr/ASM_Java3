package model;

public class student {
	private String masv, hoten, email, sodt, diachi, hinh;
	private boolean gioitinh;

	public student() {
	}

	public student(String masv, String hoten, String email, String sodt, String diachi, String hinh, boolean gioitinh) {
		this.masv = masv;
		this.hoten = hoten;
		this.email = email;
		this.sodt = sodt;
		this.diachi = diachi;
		this.hinh = hinh;
		this.gioitinh = gioitinh;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

}
