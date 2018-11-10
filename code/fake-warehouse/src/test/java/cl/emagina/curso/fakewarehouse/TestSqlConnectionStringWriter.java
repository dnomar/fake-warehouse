package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.sql.*;



public class TestSqlConnectionStringWriter{

	
	@Test
	public void debe_generar_string_para_conectar_a_la_base_de_datos(){
		
		Connection connection=null;
		
		IDbConnectionStringBuilder idb=new MysqlConnectionStringWriter();
		idb.dbStart();
		idb.takeJDBC("localhost");
		idb.takePort("3306");
		idb.takeDatabase("FakeWarehouseDB");
		idb.takeUser("testuser");
		idb.takePassword("TUtu2018");
		
		//Dado ----------------------------------------------------------------	
		String testConnStr="jdbc:mysql://localhost:3306/FakeWarehouseDB?useSSL=false&user=testuser&password=TUtu2018";

		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(testConnStr);
			//return connection;
		}catch(Exception e){
			e.printStackTrace();
			//return null;
		}finally{
			if(connection!=null)try{connection.close();}catch(Exception e){}
			//return null;
		}
		
		
		//try{connection.close();}catch(Exception e){}
		//Test----------------------------------------------------------------	
		assertEquals(testConnStr,idb.dbEnd());
		
	}
	
}