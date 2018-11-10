package cl.emagina.curso.fakewarehouse.core2;

import cl.emagina.curso.fakewarehouse.utils.Lot;
import cl.emagina.curso.fakewarehouse.core.InOut;
import java.util.Calendar;
import java.util.function.Consumer;

public interface ShipmentHandler {
	void shipmentStart();
	void takeTime( String when );
	void takeDockDoor( String door );
	void takeInOut( String how );
	void takeSkuLot( Consumer < SkuHandler.Lot > lot);
	void shipmentEnd();

	/**
	* The invocation sequence is
	* <ol>
	* <li>shipmentStart
	* <li>Zero to N times invoke the complete sequence of ShipmentHandler methods
	* (the order is not important except that shipmentStart() is called first
	* and shipmentEnd() is called last, on each iteration):
	* </li>
	* <li>shipmentEnd
	* </ol>
	*/
	public static interface Lot extends ShipmentHandler {
		void shipmentLotStart();
		void shipmentLotEnd();
	}
}