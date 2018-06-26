package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import cl.emagina.curso.fakewarehouse.parsers.DictionaryCsvParser;
import java.io.PrintWriter;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TestSysoutInventoryWriter{

	//# 
	//# Header 
	//# 
	//Inventory, Date , 2018-03-18 
	//Inventory, Supervisor, John Smith 
	//# 
	//# Kind, Location, SKU, Unit, Qty 
	//#
	//Item, A-3-4-1, 11-222-33, Each , 4 
	//Item, A-3-4-2, 42-222-33, Each , 30 
	//Item, C-4-2-1, 42-222-33, Box (4 ct) , 5 
	//Item, D-2-1-1, 75-323-44, Wrap (15 ct) , 1 
	//Item, D-2-3-1, 75-323-44, Each , 45
	
	
	@Test
	public void deberia_retornar_texto_en_InventoryStart(){
		
		//Dado ----------------------------------------------------------------
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		
		PrintWriter pww=new PrintWriter(outStream); 
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Inventory Start");
		/*pww2.println("sku:"+sku);
		pww2.println("desc:"+desc);
		pww2.println("End dictionary");	*/	
		pww2.close();
		
		//Test Code------------------------------------------------------------
		
		SysoutInventoryWriter sysoutInvWrt=new SysoutInventoryWriter(pww);
		sysoutInvWrt.inventoryStart();
				

		//Test-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}
	
	@Test
	public void deberia_retornar_date_en_takedate(){
		
		//Dado ----------------------------------------------------------------
		
		Calendar when = new GregorianCalendar(2018,06,15,0,0);
			
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		
		PrintWriter pww=new PrintWriter(outStream); 
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Date: "+when.toString());
		/*pww2.println("sku:"+sku);
		pww2.println("desc:"+desc);
		pww2.println("End dictionary");	*/	
		pww2.close();
		
		//Test Code------------------------------------------------------------
		
		SysoutInventoryWriter sysoutInvWrt=new SysoutInventoryWriter(pww);
		sysoutInvWrt.takeDate(when);
				

		//Test-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}
	
	@Test
	public void deberia_retornar_name_en_takeSupervisorName(){
		
		//Dado ----------------------------------------------------------------
		
		String testSupervisorName="Juan Derrepente";
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		
		PrintWriter pww=new PrintWriter(outStream); 
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Name: "+testSupervisorName);
		/*pww2.println("sku:"+sku);
		pww2.println("desc:"+desc);
		pww2.println("End dictionary");	*/	
		pww2.close();
		
		//Test Code------------------------------------------------------------
		
		SysoutInventoryWriter sysoutInvWrt=new SysoutInventoryWriter(pww);
		sysoutInvWrt.takeSupervisorName(testSupervisorName);
				

		//Test-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}	

	@Test
	public void deberia_retornar_texto_en_InventoryEnd(){
		
		//Dado ----------------------------------------------------------------
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		
		PrintWriter pww=new PrintWriter(outStream); 
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Inventory End");
		/*pww2.println("sku:"+sku);
		pww2.println("desc:"+desc);
		pww2.println("End dictionary");	*/	
		pww2.close();
		
		//Test Code------------------------------------------------------------
		
		SysoutInventoryWriter sysoutInvWrt=new SysoutInventoryWriter(pww);
		sysoutInvWrt.inventoryEnd();
				

		//Test-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}
	
	
}