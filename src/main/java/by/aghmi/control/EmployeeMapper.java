package by.aghmi.control;

import by.aghmi.utils.DBUtils;
import by.aghmi.model.Employee;
import by.aghmi.model.RetType;

import java.sql.*;

public class EmployeeMapper implements Mapper{
    @Override
    public void create(RetType rtype) {
        Connection conn=null;
        Statement stmt = null;

        Employee employee = (Employee) rtype;
        String sql = "INSERT INTO `retailer`.`employees` (`employeeNumber`, `lastName`, `firstName`, `extension`, `email`, `officeCode`, `reportsTo`, `jobTitle`, `LAST_UPDATED`)" 
        //String sql = "INSERT INTO `retailer`.`offices` (`officeCode`, `city`, `phone`, `addressLine1`, `addressLine2`, `state`, `country`, `postalCode`, `territory`, `LAST_UPDATED`) "
                + "VALUES ("
                + employee.getEmployeeNumber() + "," 
                + " '" + employee.getLastName() + "'," 
                + " '" + employee.getFirstName()+ "',"
                + " '" + employee.getExtension() + "'," 
                + " '" + employee.getEmail() + "'," 
                + " '"+ employee.getOfficeCode() + "'," 
                 + employee.getReportsTo() + "," 
                + " '" + employee.getJobTitle() + "',"
                + " '" + employee.getLastUpdated() + "');";
        
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            
            if (result == 1) {
                System.out.println("Employee["+ employee.getEmployeeNumber() +"] inserted.");
            } else if (result == 0){
                System.out.println("Employee ["+ employee.getEmployeeNumber() + "] was not inserted.");
            } else {
                System.out.println("something goes wrong in create() impl method"); 
            }

            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, null, stmt,null);
        }
        
    }
        


    @Override
    public void update(RetType rtype) {
        Connection conn = null;
        Statement stmt = null;
        Employee employee = (Employee) rtype;
        String sql = "UPDATE `retailer`.`employees` SET `officeCode` = "+ " '" 
                + employee.getOfficeCode() + "' WHERE `employeeNumber` ="  +  employee.getEmployeeNumber()+";";           
        
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            
            if (result == 1) {
                System.out.println("Employee["+ employee.getEmployeeNumber() +"] updated.");
            } else if (result == 0){
                System.out.println("Employee ["+ employee.getEmployeeNumber() + "] was not updated.");
            } else {
                System.out.println("something goes wrong in update() impl method"); 
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, null, stmt,null);
        }
        
    }
        
    

    @Override
    public RetType getByID(RetType rtype) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Employee employee = (Employee) rtype;
        try {
            String sql = "select * from retailer.employees where employeeNumber = '" + employee.getEmployeeNumber()+"';";
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	employee.setEmployeeNumber(rs.getInt(1));
            	employee.setLastName(rs.getString(2));
            	employee.setFirstName(rs.getString(3));
            	employee.setExtension(rs.getString(4));
            	employee.setEmail(rs.getString(5));
            	employee.setOfficeCode(rs.getInt(6));
            	employee.setReportsTo(rs.getInt(7));
            	employee.setJobTitle(rs.getString(8));
            	employee.setLastUpdated(rs.getTimestamp(9));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, rs, stmt,null);
        }


        return employee;
    }
    
    public RetType getByEmail(RetType rtype) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Employee employee = (Employee) rtype;
        try {
            String sql = "select * from retailer.employees where email = '" + employee.getEmail()+"';";
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	employee.setEmployeeNumber(rs.getInt(1));
            	employee.setLastName(rs.getString(2));
            	employee.setFirstName(rs.getString(3));
            	employee.setExtension(rs.getString(4));
            	employee.setEmail(rs.getString(5));
            	employee.setOfficeCode(rs.getInt(6));
            	employee.setReportsTo(rs.getInt(7));
            	employee.setJobTitle(rs.getString(8));
            	employee.setLastUpdated(rs.getTimestamp(9));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, rs, stmt,null);
        }


        return employee;
    }

    @Override
    public void delete(RetType rtype) {
        Connection conn=null;
        Statement stmt = null;
        Employee employee = (Employee) rtype;
        String sql = "DELETE FROM `retailer`.`employees`  WHERE `employeeNumber` ="  +  employee.getEmployeeNumber()+";";           
        
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            
            if (result == 1) {
                System.out.println("Employee["+ employee.getEmployeeNumber() +"] deleted.");
            } else if (result == 0){
                System.out.println("Employee ["+ employee.getEmployeeNumber() + "] was not deleted.");
            } else {
                System.out.println("something goes wrong in delete() impl method"); 
            }

            
        } catch (SQLException e) {
    
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, null, stmt,null);
        }
        
    }
    
    public void deleteByEmployeeNumber (int employeeNumber){
        Connection conn = null;
        Statement stmt = null;
        String sql = "DELETE FROM `retailer`.`employees`  WHERE `employeeNumber` ="  +  employeeNumber+";"; 
        
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            
            if (result == 1) {
                System.out.println("Employee["+ employeeNumber +"] deleted.");
            } else if (result == 0){
                System.out.println("Employee ["+ employeeNumber + "] was not deleted.");
            } else {
                System.out.println("something goes wrong in delete() impl method"); 
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, null, stmt,null);
        }
        
    }
    
    public void deleteByOfficeCode (int officeCode){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM `retailer`.`employees`  WHERE `officeCode` = ?"; 
        
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, officeCode);
            int result = pstmt.executeUpdate();
            
            if (result == 1) {
                System.out.println("Employee["+ officeCode +"] deleted.");
            } else if (result == 0){
                System.out.println("Employee ["+ officeCode + "] was not deleted.");
            } else {
                System.out.println("something goes wrong in delete() impl method"); 
            }

        } catch (SQLException e) {
        
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, null,null, pstmt);
        }
        
    }
    
    
        public static void main(String[] args) {
        	
        	Employee empl = new Employee();
        	empl.setEmail("dmurphy@classicmodelcars.com");
			
        	System.out.println(new EmployeeMapper().getByEmail(empl));
		}
        
    }


