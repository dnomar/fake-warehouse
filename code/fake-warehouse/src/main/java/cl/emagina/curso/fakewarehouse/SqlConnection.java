package cl.emagina.curso.fakewarehouse;

import java.sql.*;

/**
 * Make a connection to a Database
 */

class SqlConnection implements IDbConnection{
	
	private String connectionString;
	private Connection connection;
	
	SqlConnection(String connectionString){
		this.connectionString=connectionString;
	}
	
	public Connection makeConnection(){
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection=DriverManager.getConnection(this.connectionString);
			return this.connection;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}