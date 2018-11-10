package cl.emagina.curso.fakewarehouse;

import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.core.SkuHandler;
import java.io.PrintWriter;
import java.util.Calendar;

public class OldSysoutSkuWriter implements SkuHandler{
		
	private PrintWriter pw;
	
	OldSysoutSkuWriter(PrintWriter pw){
		this.pw=pw;
	}
	
	public void skuStart(){
		this.pw.println("Sku Start");
		this.pw.flush();
	}

    public void takeSku(String sku ){
		this.pw.println("Sku: "+sku);
		this.pw.flush();
	}
		
	
	public void takeLocation( String loc ){
		this.pw.println("Locacion: "+loc);
		this.pw.flush();
	}
	
	

    public void takeUnit( String unit, int items_per_unit ){
		this.pw.println("Unit :"+unit+" & "+"Items per Unit :"+String.valueOf(items_per_unit));
		this.pw.flush();
	}
	
    public void takeQty( int qty ){
		this.pw.println("Cantidad :"+String.valueOf(qty));
		this.pw.flush();
	}
	
    public void skuEnd(){
		this.pw.println("Sku End");
		this.pw.flush();		
	}
	
}
