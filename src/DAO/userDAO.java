package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.user;

public class userDAO implements DAOinterface<user> {

	public static userDAO getUserDAO() {
		return new userDAO();
	}

	@Override
	public int insert(user t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO users(usernamee,passwordd,rolee)" + "values('" + t.getUsernamee() + "','"
					+ t.getPasswordd() + "','" + t.getRolee() + "')";
			kq = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(user t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(user t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
