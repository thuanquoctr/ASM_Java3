package DAO;

import java.util.ArrayList;

import model.student;

public class studentDAO implements DAOinterface<student> {
	public static studentDAO getStudentDAO() {
		return new studentDAO();
	}

	@Override
	public int insert(student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(student t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
