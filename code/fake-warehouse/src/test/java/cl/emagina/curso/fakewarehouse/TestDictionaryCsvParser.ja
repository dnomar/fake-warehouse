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
		String auxStr="#\n# Kind, SKU, Desc\n#\nSKU Spec, 11-222-33, Block 100";
		auxStr=auxStr+" pages\nSKU Spec, 42-222-33, Block 50 pages";
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
		//System.out.println(boutTest.toString());
		System.out.println("auxStr: \n"+auxStr);
		pwTest.close();
		
		//Test------------------------------------------------------------------
		assertEquals(boutTest.toString(),bout.toString());
	}
	
	/*
	 Test File;
	 
	 #
	 # Kind, SKU, Desc
	 #
	 SKU Spec, 11-222-33, Block 100 pages #Este es un comentario
	 SKU Spec, 42-222-33, Block 50 pages
	 
	 Debe Retornar:
	 SKU Spec, 11-222-33, Block 100 pages
	 SKU Spec, 42-222-33, Block 50 pages
	 */	
	//@Test
	public void no_debe_considerar_el_texto_despues_del_gato(){
		
		//Dado------------------------------------------------------------------
		String auxStr="#\n# Kind, SKU, Desc\n#\nSKU Spec, 11-222-33, Block 100";
		auxStr=auxStr+"pages  #Este es un comentario\nSKU Spec, 42-222-33, ";
		auxStr=auxStr+"Block 50 pages";
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
	
	/**
	//@Test
	public void retorna_null_si_tiene_solo_gatos(){
		
		//Dado------------------------------------------------------------------
		String auxStr="##";
		
		//Code------------------------------------------------------------------
		DictionaryCsvParser dcsvp=new DictionaryCsvParser(new StringReader(auxStr));
		
		assertEquals(null,dcsvp.catLikeComment(auxStr));
	}
	
	//@Test
	public void retorna_subtexto_izquierdo_si_tiene_gatos_entremedio(){
		
		//Dado------------------------------------------------------------------
		String auxStr="texto1#texto2";
		
		//Code------------------------------------------------------------------
		DictionaryCsvParser dcsvp=new DictionaryCsvParser(new StringReader(auxStr));
		
		assertEquals("texto1",dcsvp.catLikeComment(auxStr));
	}
	*/
}