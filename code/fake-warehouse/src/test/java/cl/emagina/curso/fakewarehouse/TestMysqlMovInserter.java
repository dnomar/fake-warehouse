package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.sql.*;
import java.time.LocalTime;
import java.time.LocalDate;


//testear con moockup
public class TestMysqlMovInserter{

	
	
	public void debe_insertar_valor_en_db(){
		
		Connection conn=null;
		IDbTransInsert newMov=null;
		
		IDbConnectionStringBuilder idb=new MysqlConnectionStringWriter();
		idb.dbStart();
		idb.takeJDBC("localhost");
		idb.takePort("3306");
		idb.takeDatabase("FakeWarehouseDB");
		idb.takeUser("testuser");
		idb.takePassword("TUtu2018");
		
		IDbConnection con=new MysqlConnection(idb.dbEnd());
		conn=con.makeConnection();		
		

			newMov=new MysqlTransInserter(conn);
		try{			
			newMov.start();
			newMov.pullType("CrossDock");
			newMov.pullClient(5);
			newMov.pullDate(LocalDate.now().toString());
			newMov.pullTime(LocalTime.now().toString());
			newMov.pullProduct(-3);
			newMov.pullProdQty(-80);
			newMov.end();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//try{connection.close();}catch(Exception e){}
		//Test----------------------------------------------------------------	
		assertTrue(false);
		
	}
	
}