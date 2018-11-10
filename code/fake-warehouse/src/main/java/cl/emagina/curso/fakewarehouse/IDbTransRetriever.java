package cl.emagina.curso.fakewarehouse;

import java.sql.*;

/**
 * Allow to insert transactions of the Warehouse in the DataBase  
 *
 */

interface IDbTransRetriever{
	
	void start() throws SQLException;
	void pushTrans()throws SQLException;
	void end()throws SQLException;
}
