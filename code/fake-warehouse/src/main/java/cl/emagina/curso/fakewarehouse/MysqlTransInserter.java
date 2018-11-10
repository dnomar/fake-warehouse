package cl.emagina.curso.fakewarehouse;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Allow to insert transactions of the Warehouse in the DataBase  
 *
 */

class MysqlTransInserter implements IDbTransInsert {
	
	private Connection conn;
	private PreparedStatement stmt;
	
	MysqlTransInserter(Connection conn){
		this.conn=conn;
	}
	
	public void start() throws SQLException{
		stmt=this.conn.prepareStatement("insert into movimientos (tipo_movimiento,id_cliente,fecha,hora,id_producto,cantidad) values (?,?,?,?,?,?)");
	}
	public void pullType(String movType)throws SQLException{
		stmt.setString(1,movType);
	}
	public void pullClient(int clientId)throws SQLException{
		stmt.setInt(2,clientId);
	}
	public void pullDate(String date)throws SQLException{
		stmt.setString(3,date);
	}
	public void pullTime(String time)throws SQLException{
		stmt.setString(4,time);
	}
	public void pullProduct(int prodId)throws SQLException{
		stmt.setInt(5,prodId);
	}
	public void pullProdQty(int prodQty)throws SQLException{
		stmt.setFloat(6,prodQty);
	}
	public void end() throws SQLException{
		stmt.executeUpdate();
		stmt.close();
		this.conn.close();
	}
}