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


public class TestShipmentProducer{

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
	public void deberia_retornar_ShipmentForm_al_ejecutar_exportTo(){
		
		//Dado ----------------------------------------------------------------	
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		PrintWriter pww=new PrintWriter(outStream); 
		
		/**
		pww.println("#");
		pww.println("# Header");
		pww.println("#");
		pww.println("Shipment, Dock Door, 5");
		pww.println("Shipment, Dock Time, 2018-03-25 18:34");
		pww.println("Shipment, In/Out , Inbound");	
		pww.println("#");
		pww.println("# Kind, Location, SKU, Unit, Qty");
		pww.println("#");
		pww.println("Item, 11-222-33, Each , 4");
		pww.println("Item, 42-222-33, Each , 30");
		pww.println("Item, 42-222-33, Box (4 ct) , 5");
		pww.println("Item, 75-323-44, Wrap (15 ct) , 1");
		pww.println("Item, 75-323-44, Each , 45");
		pww.close();
		*/
		
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Shipment Lot Start");
		pww2.println("Shipment Start");
		pww2.println("Door: 5");
		pww2.println("When: 2018-03-25 18:34");
		pww2.println("InOut: Inbound");
		
		pww2.println("Sku Lot Start");
		
		pww2.println("Sku Start");
		pww2.println("Sku: 11-222-33");
		pww2.println("Desc: Each");
		pww2.println("Cantidad: 4");
		pww2.println("Sku End");
		
		pww2.println("Sku Start");
		pww2.println("Sku: 42-222-33");
		pww2.println("Desc: Each");
		pww2.println("Cantidad: 30");
		pww2.println("Sku End");	

		pww2.println("Sku Start");
		pww2.println("Sku: 42-222-33");
		pww2.println("Desc: Box (4 ct)");
		pww2.println("Cantidad: 5");
		pww2.println("Sku End");	

		pww2.println("Sku Start");
		pww2.println("Sku: 75-323-44");
		pww2.println("Desc: Wrap (15 ct)");
		pww2.println("Cantidad: 1");
		pww2.println("Sku End");

		pww2.println("Sku Start");
		pww2.println("Sku: 75-323-44");
		pww2.println("Desc: Each");
		pww2.println("Cantidad: 45");
		pww2.println("Sku End");			
		
		pww2.println("Sku Lot End");
		
		pww2.println("Shipment End");
		pww2.println("Shipment Lot End");		
		pww2.close();
		

		//ByteArrayOutputStream outStream3 = new ByteArrayOutputStream();
		//PrintWriter pww3=new PrintWriter(outStream3); 

		
		//Test Code------------------------------------------------------------
		String path="c:\\Users\\Owner\\documents\\curso ybl 2018\\fake-warehouse\\code";
		path=path+"\\fake-warehouse\\src\\test\\java\\cl\\emagina\\curso\\fakewarehouse\\input-text.txt";		
		try{
			ShipmentProducer shPrd=new ShipmentProducer(new FileReader(path));
			shPrd.exportTo(new SysoutShipmentWriter(pww));
			//System.out.println(pww);
			
		}catch(Exception e){
			e.printStackTrace();
		}
				

		//Test-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}
	
}