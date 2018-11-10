package cl.emagina.curso.fakewarehouse;

import java.sql.*;
import java.lang.Exception;

/**
 * Make a connection to a Mysql Database
 */

class MysqlConnection implements IDbConnection{
	
	private String conecStr;
	private Connection connection=null;
	
	public MysqlConnection(String conecStr){
		this.conecStr=conecStr;
	}
	
	public Connection makeConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(this.conecStr);
			return connection;
		}catch(SQLException e){
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
			//return null;
	}
	
}