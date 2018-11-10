package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.sql.*;
import java.time.LocalTime;
import java.time.LocalDate;


//testear con moockup
public class TestMysqlMovUpdater{

	
	
	public void debe_insertar_valor_en_db(){
		
		Connection conn=null;
		IDbTransUpdater newMov=null;
		
		IDbConnectionStringBuilder idb=new MysqlConnectionStringWriter();
		idb.dbStart();
		idb.takeJDBC("localhost");
		idb.takePort("3306");
		idb.takeDatabase("FakeWarehouseDB");
		idb.takeUser("testuser");
		idb.takePassword("TUtu2018");
		
		IDbConnection con=new MysqlConnection(idb.dbEnd());
		conn=con.makeConnection();		
		

			newMov=new MysqlTransUpdater(conn);
		try{			
			newMov.start();
			newMov.pullType("CrossDock");
			newMov.pullClient(5);
			newMov.pullDate(LocalDate.now().toString());
			newMov.pullTime(LocalTime.now().toString());
			newMov.pullProduct(-10);
			newMov.pullProdQty(69);
			newMov.pullId(5);
			newMov.end();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//try{connection.close();}catch(Exception e){}
		//Test----------------------------------------------------------------	
		assertTrue(false);
		
	}
	
}