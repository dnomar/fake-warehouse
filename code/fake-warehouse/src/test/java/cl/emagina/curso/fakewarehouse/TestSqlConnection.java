package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.sql.*;


//testear con mockup
public class TestSqlConnection{

	
	
	public void debe_conectar_a_la_base_de_datos(){
		
		Connection conn=null;
		
		IDbConnectionStringBuilder idb=new MysqlConnectionStringWriter();
		idb.dbStart();
		idb.takeJDBC("localhost");
		idb.takePort("3306");
		idb.takeDatabase("FakeWarehouseDB");
		idb.takeUser("testuser");
		idb.takePassword("TUtu2018");
		
		
		
		IDbConnection con=new MysqlConnection(idb.dbEnd());
		conn=con.makeConnection();
		
		
		Statement stmt = null;
		String query =
			"select * from clientes";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()!=false) {
				String Razon_Social = rs.getString(2);
				String rut = rs.getString(3);
				String nombre_contacto = rs.getString(4);
				String direccion = rs.getString(5);
				String fono = rs.getString(6);
				System.out.println(Razon_Social + "\t" + rut +
								   "\t" + nombre_contacto + "\t" + direccion +
								   "\t" + fono);
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { 
				try{
					stmt.close();
				}catch(Exception ey){
					ey.printStackTrace();
				}
			}		
		}
		
		//try{conn.close();}catch(Exception ey){
		//	ey.printStackTrace();
		//}
		
		
		//Dado
		//Test----------------------------------------------------------------	
		assertTrue(false);
		
	}
	
}