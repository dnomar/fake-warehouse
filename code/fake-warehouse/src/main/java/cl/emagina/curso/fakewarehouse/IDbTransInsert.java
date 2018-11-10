package cl.emagina.curso.fakewarehouse;

import java.sql.*;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Allow to insert transactions of the Warehouse in the DataBase  
 *
 */

interface IDbTransInsert{
	
	void start() throws SQLException;
	void pullType(String movType)throws SQLException;
	void pullClient(int clientId)throws SQLException;
	void pullDate(String date)throws SQLException;
	void pullTime(String time)throws SQLException;
	void pullProduct(int prodId)throws SQLException;
	void pullProdQty(int prodQty)throws SQLException;
	void end()throws SQLException;
}
