package model;

public class grade {
	private int id, tienganh, tinhoc, gdtc;
	private student masv;

	public grade() {
	}
	public grade(int id, int tienganh, int tinhoc, int gdtc, student masv) {
		this.id = id;
		this.tienganh = tienganh;
		this.tinhoc = tinhoc;
		this.gdtc = gdtc;
		this.masv = masv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTienganh() {
		return tienganh;
	}

	public void setTienganh(int tienganh) {
		this.tienganh = tienganh;
	}

	public int getTinhoc() {
		return tinhoc;
	}

	public void setTinhoc(int tinhoc) {
		this.tinhoc = tinhoc;
	}

	public int getGdtc() {
		return gdtc;
	}

	public void setGdtc(int gdtc) {
		this.gdtc = gdtc;
	}

	public student getMasv() {
		return masv;
	}

	public void setMasv(student masv) {
		this.masv = masv;
	}

}
