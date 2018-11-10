package cl.emagina.curso.fakewarehouse;

import java.sql.*;

/**
 * Make a connection to a Database
 */

interface IDbConnection{
	
	Connection makeConnection();
	
}