package cl.emagina.curso.fakewarehouse;


import java.sql.*;
//import com.microsoft.sqlserver.jdbc.*;


/**
 * Class which form Connection String to connect SQL Database with 
 * User and password authentication
 */
public class SqlConnectionStringWriter implements IDbConnectionStringBuilder{//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
	
	
	private String connectionString=null;
	private Connection connection=null;
	
	public void dbStart(){
		connectionString="jdbc:sqlserver://";
	}
	public void takeJDBC(String jdbc){
		connectionString=connectionString+jdbc;
	}
	public void takePort(String port){
		connectionString=connectionString+":"+port+";";
	}
	public void takeDatabase(String db){
		connectionString=connectionString+"database="+db+";";
	}
	public void takeUser(String user){
		connectionString=connectionString+"user="+user+";";
	}
	public void takePassword(String psw){
		connectionString=connectionString+"password="+psw+";";
	}
	
	public String dbEnd(){
		return connectionString;
	}

	/*
	public Connection dbEnd(){
		connectionString=connectionString+"\"";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection=DriverManager.getConnection(connectionString);
			return connection;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null)try{connection.close();}catch(Exception e){}
			return null;
		}
	}*/
			
}
