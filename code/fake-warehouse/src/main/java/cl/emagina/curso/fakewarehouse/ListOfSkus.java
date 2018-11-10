package cl.emagina.curso.fakewarehouse;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.core.*;
import java.io.PrintWriter;

/**
 * Utiliza un Dictionary Handler para imprimir el contenido del Dictionary
 */
public class ListOfSkus {
	
	private PrintWriter pw;
	
	ListOfSkus(PrintWriter pw){
		this.pw=pw;
	}
	
	public SkuHandler lotStart(){	
		this.pw.println("Lot SKus Start");
		return new OldSysoutSkuWriter(pw);
	}	
	
	public void lotEnd(){
		this.pw.println("Lot SKus End");
	}
	
}