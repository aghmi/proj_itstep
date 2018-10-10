package by.aghmi.control;

import by.aghmi.utils.DBUtils;
import by.aghmi.model.Office;
import by.aghmi.model.RetType;

import java.sql.*;

public class OfficeMapper implements Mapper {

	private static final String COLUMNS = " officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory, LAST_UPDATED ";
	private static final String TABLE = "offices";
	private static final String DB = "retailer";
	private static final String DB_TABLE = DB + "." +TABLE;
	
	private static final String SELECT_BY_ID = "SELECT  " + COLUMNS 
			+ "FROM " + DB_TABLE + " WHERE officeCode = ?;";
	
	@Override
	public void create(RetType rtype) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Office office = (Office)rtype;	
		String sql = "INSERT INTO " + DB + "." + TABLE + " (" + COLUMNS + ") "
				+ "VALUES ("
				+ office.getOfficeCode()+", "
				+ "'"+office.getCity()+"', "
				+ "'"+office.getPhone()+"',"
				+ " '"+office.getAddressLine1()+"',"
				+ " '"+office.getAddressLine2()+"',"
				+ " '"+office.getState()+"',"
				+ " '"+office.getCountry()+"',"
				+ " '"+office.getPostalCode()+"',"
				+ " '"+office.getTerritory()+"',"
				+ " '"+office.getLastUpdated()+"')";
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			if(result == 1){
				System.out.println("Office ["+ office.getOfficeCode() + "] inserted.");
			} else if (result == 0){
				System.out.println("Office ["+ office.getOfficeCode() + "] was not inserted.");
				throw new Exception("result = 0");
			} else {
				System.out.println("something goes wrong in create() impl method"); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, null, stmt , null);
		}
	}

	@Override
	public void update(RetType rtype) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		Office officeToUpdate = (Office)rtype;
		String sql = "UPDATE retailer.offices "
				+ "SET city = ?,"
				+ " phone = ?,"
				+ " addressLine1 = ?,"
				+ " addressLine2 = ?,"
				+ " state = ?,"
				+ " country = ?,"
				+ " postalCode = ?,"
				+ " territory = ?,"
				+ " LAST_UPDATED = ?"
				+ " WHERE officeCode = ?";
		conn = DBUtils.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, officeToUpdate.getCity());
			pstmt.setString(2, officeToUpdate.getPhone());
			pstmt.setString(3, officeToUpdate.getAddressLine1());
			pstmt.setString(4, officeToUpdate.getAddressLine2());
			pstmt.setString(5, officeToUpdate.getState());
			pstmt.setString(6, officeToUpdate.getCountry());
			pstmt.setString(7, officeToUpdate.getPostalCode());
			pstmt.setString(8, officeToUpdate.getTerritory());
			pstmt.setTimestamp(9, officeToUpdate.getLastUpdated());
			pstmt.setInt(10, officeToUpdate.getOfficeCode());
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				System.out.println("Office ["+ officeToUpdate.getOfficeCode() + "] UPDATED.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, null, null, pstmt);
		}
		
		
		
	}

	@Override
	public RetType getByID(RetType rtype) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Office o = (Office)rtype;
		
		conn = DBUtils.getConnection();
		try {
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, o.getOfficeCode());
			rs = pstmt.executeQuery();
			if(rs.next()){
				//phone, addressLine1, addressLine2, state, country, postalCode, territory, LAST_UPDATED
				o.setOfficeCode(rs.getInt(1));
				o.setCity(rs.getString(2));
				o.setPhone(rs.getString(3));
				o.setAddressLine1(rs.getString(4));
				o.setAddressLine2(rs.getString(5));
				o.setState(rs.getString(6));
				o.setCountry(rs.getString(7));
				o.setPostalCode(rs.getString(8));
				o.setTerritory(rs.getString(9));
				o.setLastUpdated(rs.getTimestamp(10));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, rs, null, pstmt);
		}

		return o;
		
		
		
		
	}

	@Override
	public void delete(RetType rtype) {
		// TODO Auto-generated method stub
		
	}

}
