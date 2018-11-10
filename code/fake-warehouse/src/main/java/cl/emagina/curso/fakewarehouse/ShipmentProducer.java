package cl.emagina.curso.fakewarehouse;

import cl.emagina.curso.fakewarehouse.core2.ShipmentHandler;
import cl.emagina.curso.fakewarehouse.core2.SkuHandler;
import cl.emagina.curso.fakewarehouse.utils.*;
import java.util.Scanner;
import java.util.function.Consumer;
import java.io.FileReader;


public class ShipmentProducer {

	// I am a push producer. A client asks me to produce a shipment by invoking
	// this ’exportTo’ method and passing me the handler into which to push
	// the produced items. 
	// To produce a collection of SKUs (takeSkuLot method) I will ask
	// the consumer to provide me an SkuHandler.Lot into which to produce
	// the lot of SKUs. For that purpose there is a handshake where I pass
	// pass the consumer a Consumer< SkuHandler.Lot > where he can pass me back
	// the SkuHandler.Lot instance into which I will produce the lot of SKUs.
	
	private FileReader rdr;
	private Consumer<SkuHandler.Lot> cons;
	private Scanner sc;
	
	ShipmentProducer(FileReader rdr){
		this.rdr=rdr;
		this.cons = new MySkuLotProducer();
	}
	
	public void exportTo( ShipmentHandler.Lot consumer ) {
		this.sc= new Scanner( rdr );
		consumer.shipmentLotStart();
		consumer.shipmentStart();
		sc.nextLine();
		sc.nextLine();
		sc.nextLine();
		consumer.takeDockDoor( sc.nextLine());
		consumer.takeTime(sc.nextLine());
		consumer.takeInOut( sc.nextLine());
		sc.nextLine();
		sc.nextLine();
		sc.nextLine();
		consumer.takeSkuLot(this.cons);
		consumer.shipmentEnd();
		consumer.shipmentLotEnd();
	}
	
	
	private class MySkuLotProducer implements Consumer<SkuHandler.Lot> {
		@Override 
		public void accept( SkuHandler.Lot sku_lot ) {
			sku_lot.skuLotStart();
			//for ( String line = sc.nextLine(); line != null; line = sc.nextLine()){
			while(sc.hasNextLine()==true){
				String line=sc.nextLine();
				String[] tok = line.split( "," );
				sku_lot.skuStart();
				sku_lot.takeSkuNr(tok[1]);
				sku_lot.takeSkuDesc(tok[2]);
				sku_lot.takeSkuQty(tok[3]);
				sku_lot.skuEnd();
			}
			sku_lot.skuLotEnd();
		}
	}
	
}
