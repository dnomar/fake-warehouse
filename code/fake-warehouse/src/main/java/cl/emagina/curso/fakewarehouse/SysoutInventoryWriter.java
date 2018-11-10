package cl.emagina.curso.fakewarehouse;

import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.core.*;
import java.io.PrintWriter;
import java.util.Calendar;

public class SysoutInventoryWriter implements InventoryHandler{
		
	private PrintWriter pw;
	
	SysoutInventoryWriter(PrintWriter pw){
		this.pw=pw;
	}
	
	public void inventoryStart(){
		this.pw.println("Inventory Start");
		this.pw.flush();
	}
	
    public void takeDate( Calendar when ){
		this.pw.println("Date: "+ when.toString());
		this.pw.flush();
	}
	
    public void takeSupervisorName( String name ){
		this.pw.println("Name: "+name);
		this.pw.flush();
	}
	
    //public Lot<SkuHandler> takeItems(){
		//return new ListOfSkus(pw);
	//}
	
    public void inventoryEnd(){
		this.pw.println("Inventory End");
		this.pw.flush();
	}
}
