package by.aghmi.control;

import by.aghmi.utils.CryptoUtils;
import by.aghmi.utils.DBUtils;
import by.aghmi.model.RetType;
import by.aghmi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper {

	private String select = "SELECT UID, NAME, LAST_NAME, PASSWORD, EMAIL FROM USERS WHERE EMAIL = ? AND PASSWORD = ?;";
	public RetType findUser(String email, String pass){
		CryptoUtils cutils = null;
		try {
			 cutils = new CryptoUtils();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, email);
			pstmt.setString(2, cutils.encrypt(pass));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, rs, null, pstmt);
		}
		return user;
	}
	
	@Override
	public void create(RetType rtype) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RetType rtype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RetType getByID(RetType rtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RetType rtype) {
		// TODO Auto-generated method stub
		
	}

}
