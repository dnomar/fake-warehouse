package cl.emagina.curso.fakewarehouse;

import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.core2.ShipmentHandler;
import cl.emagina.curso.fakewarehouse.core2.SkuHandler;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.function.Consumer;

public class SysoutShipmentWriter implements ShipmentHandler.Lot{
		
	private PrintWriter pw;
	
	SysoutShipmentWriter(PrintWriter pw){
		this.pw=pw;
	}
	
	public void shipmentStart(){
		this.pw.println("Shipment Start");
		this.pw.flush();
	}
	
	public void takeDockDoor( String door ){
		String[] auxDoor=door.split(",");
		this.pw.println("Door: "+auxDoor[2].trim());
		this.pw.flush();		
	}
	
	public void takeTime( String when ){
		String[] auxTime=when.split(",");
		this.pw.println("When: "+auxTime[2].trim());
		this.pw.flush();
	}

	public void takeInOut( String how ){
		String[] auxInOut=how.split(",");
		this.pw.println("InOut: "+auxInOut[2].trim());
		this.pw.flush();		
	}
	
	//this.lot_cons = new SysoutShipmentWriter(...);
	
	public void takeSkuLot( Consumer<SkuHandler.Lot> lot_cons){
		
		lot_cons.accept( new SysoutSkuWriter(this.pw));
		
	}
	
	public void shipmentEnd(){
		this.pw.println("Shipment End");
		this.pw.flush();
	}
	
	public void shipmentLotStart(){
		this.pw.println("Shipment Lot Start");
		this.pw.flush();
	}
	
	public void shipmentLotEnd(){
		this.pw.println("Shipment Lot End");
		this.pw.flush();			
	}	
	
}
