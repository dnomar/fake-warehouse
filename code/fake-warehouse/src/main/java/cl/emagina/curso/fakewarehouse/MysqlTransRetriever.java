package cl.emagina.curso.fakewarehouse;

import java.sql.*;

/**
 * Allow to insert transactions of the Warehouse in the DataBase  
 *
 */

class MysqlTransRetriever implements IDbTransRetriever{
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	MysqlTransRetriever(Connection conn){
		this.conn=conn;
	}
	
	public void start() throws SQLException{
		stmt=this.conn.prepareStatement("select * from movimientos");		
	}
	public void pushTrans()throws SQLException{
		
	}
	public void end()throws SQLException{
		rs=stmt.executeQuery();

		
		while(rs.next()==true){
			System.out.println(rs.getString("idmovimiento")+"\t"+rs.getInt("id_cliente")+"\t"+rs.getString("fecha")+"\t"+rs.getString("hora")+"\t"+rs.getString("id_producto")+"\t"+rs.getInt("cantidad")+"\t"+rs.getString("tipo_movimiento"));
		}
		stmt.close();
		this.conn.close();
	}
}