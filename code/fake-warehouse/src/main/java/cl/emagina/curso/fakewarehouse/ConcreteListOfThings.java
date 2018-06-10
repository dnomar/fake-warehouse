package cl.emagina.curso.fakewarehouse;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import cl.emagina.curso.fakewarehouse.utils.*;
import java.io.PrintWriter;

/**
 * Utiliza un Dictionary Handler para imprimir el contenido del Dictionary
 */
public class ConcreteListOfThings implements Lot<DictionaryHandler> {
	
	private PrintWriter pw;
	
	public ConcreteListOfThings(PrintWriter pw){
		this.pw=pw;
	}
	
	public DictionaryHandler lotStart(){
		this.pw.println("Lot Start");		
		return new PrintingDictionaryHandler(pw);
	}	
	
	public void lotEnd(){
		this.pw.println("Lot End");
		this.pw.close();
	}
	
}