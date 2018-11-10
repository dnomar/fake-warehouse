package cl.emagina.curso.fakewarehouse;

import java.sql.*;

public interface IDbConnectionStringBuilder{
	
	void dbStart();
	void takeJDBC(String jdbc);
	void takePort(String port);	
	void takeDatabase(String db);
	void takeUser(String user);
	void takePassword(String psw);
	String dbEnd();
			
}
