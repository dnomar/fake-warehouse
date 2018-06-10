package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import cl.emagina.curso.fakewarehouse.parsers.DictionaryCsvParser;
import java.io.ByteArrayOutputStream;

public class TestDictionaryCsvParser{
	
	/*
	 Test File;
	 
	 #
	 # Kind, SKU, Desc
	 #
	 SKU Spec, 11-222-33, Block 100 pages
	 SKU Spec, 42-222-33, Block 50 pages
	 
	 Debe Retornar:
	 SKU Spec, 11-222-33, Block 100 pages
	 SKU Spec, 42-222-33, Block 50 pages
	 
	 
	 */
	@Test
	public void no_debe_considerar_lineas_que_comiencen_con_gato(){
		
		//Dado------------------------------------------------------------------
		String auxStr="#\n# Kind, SKU, Desc\n#\nSKU Spec, 11-222-33, Block 100 pages\nSKU Spec, 42-222-33, Block 50 pages";
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ByteArrayOutputStream boutTest=new ByteArrayOutputStream();
		
		//Code------------------------------------------------------------------
		ConcreteListOfThings clot=new ConcreteListOfThings(new PrintWriter(bout));
		DictionaryCsvParser dcsvp=new DictionaryCsvParser(new StringReader(auxStr));
		dcsvp.exportTo(clot);
		
		
		//Resultado Esperado----------------------------------------------------
		PrintWriter pwTest= new PrintWriter(boutTest);
		pwTest.println("Lot Start");
		pwTest.println("Start dictionary");
		pwTest.println("sku: 11-222-33");
		pwTest.println("desc: Block 100 pages");
		pwTest.println("End dictionary");
		pwTest.println("Start dictionary");
		pwTest.println("sku: 42-222-33");
		pwTest.println("desc: Block 50 pages");
		pwTest.println("End dictionary");
		pwTest.println("Lot End");
		System.out.println(boutTest.toString());
		pwTest.close();
		
		
		
		//Test------------------------------------------------------------------
		assertEquals(boutTest.toString(),bout.toString());
	}
	

}