package cl.emagina.curso.fakewarehouse;

import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.core2.SkuHandler;
import java.io.PrintWriter;
import java.util.Calendar;

public class SysoutSkuWriter implements SkuHandler.Lot{
		
	private PrintWriter pw;
	
	SysoutSkuWriter(PrintWriter pw){
		this.pw=pw;
	}
	
	public void skuStart(){
		this.pw.println("Sku Start");
		this.pw.flush();
	}

    public void takeSkuNr( String sku ){
		this.pw.println("Sku: "+sku.trim());
		this.pw.flush();
	}
	
	public void takeSkuDesc(String desc){
		this.pw.println("Desc: "+desc.trim());
		this.pw.flush();
	}
	
	public void takeSkuQty(String qty){
		this.pw.println("Cantidad: "+qty.trim());
		this.pw.flush();
	}	
	
    public void skuEnd(){
		this.pw.println("Sku End");
		this.pw.flush();		
	}
	
	public void skuLotStart(){
		this.pw.println("Sku Lot Start");
		this.pw.flush();		
	}
	
	public void skuLotEnd(){
		this.pw.println("Sku Lot End");
		this.pw.flush();		
	}
		
}
