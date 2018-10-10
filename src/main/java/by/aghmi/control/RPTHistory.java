package by.aghmi.control;

import by.aghmi.utils.DBUtils;
import by.aghmi.model.Employee;
import by.aghmi.model.RetType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RPTHistory implements Mapper{
	
	public void create(Employee from, Employee to){
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String sql = "INSERT into retailer.reports_history (EMPL_FROM_ID , EMPL_TO_ID, REPORT_TS) "
				+ "VALUES ( ? , ?, CURRENT_TIMESTAMP );";
		conn = DBUtils.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, from.getEmployeeNumber());
			pstmt.setInt(2, to.getEmployeeNumber());
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				System.out.println("RPT_HISTORY INSERTED .( FOR "
							+from.getEmployeeNumber()
							+ " TO "+to.getEmployeeNumber()+")");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, null, null, pstmt);
		}
		
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
