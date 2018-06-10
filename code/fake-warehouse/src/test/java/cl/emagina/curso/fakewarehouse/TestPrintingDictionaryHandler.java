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

public class TestPrintingDictionaryHandler{

	@Test
	public void deberia_retornar_sku_y_desc(){
		
		//Dado ----------------------------------------------------------------
		
		String sku="11-222-33";
		String desc="Block 100 pages";
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayOutputStream outStream2 = new ByteArrayOutputStream();
		
		PrintWriter pww=new PrintWriter(outStream); 
		PrintWriter pww2=new PrintWriter(outStream2); 
		
		pww2.println("Start dictionary");
		pww2.println("sku:"+sku);
		pww2.println("desc:"+desc);
		pww2.println("End dictionary");		
		pww2.close();
		
		//Test Code------------------------------------------------------------
		
		PrintingDictionaryHandler cd=new PrintingDictionaryHandler(pww);
		cd.dictionaryStart();
		cd.takeSku(sku);
		cd.takeSkuDesc(desc);
		cd.dictionaryEnd();		

		//TEst-----------------------------------------------------------------
		
		assertEquals(outStream2.toString(),outStream.toString());
		
	}
	

}