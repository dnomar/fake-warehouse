package cl.emagina.curso.fakewarehouse;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;

/**
 * Imprime el sku y desc en la pantalla
 */
public class PrintingDictionaryHandler implements DictionaryHandler {
		
	private PrintWriter pw;
	
	public PrintingDictionaryHandler(Writer w){
		this(new PrintWriter(w));
	}
	
	public PrintingDictionaryHandler(PrintWriter pw){
		this.pw=pw;
	}
	
	public void dictionaryStart(){
		this.pw.println("Start dictionary");
	}
	
    public void takeSku(String skuStr){
		this.pw.println("sku:"+skuStr);
	}
	
    public void takeSkuDesc(String skuDesc){
		this.pw.println("desc:"+skuDesc);		
	}
	
    public void dictionaryEnd(){
		this.pw.println("End dictionary");
		this.pw.flush();
		

		
	}
	
}

