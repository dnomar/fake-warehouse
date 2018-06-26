package cl.emagina.curso.fakewarehouse.core;

import cl.emagina.curso.fakewarehouse.utils.Lot;
import java.util.Calendar;


public interface ShipmentHandler {
    void shipmentStart();
    void takeTime( Calendar when );
    void takeDockDoor( String door );
    void takeInOut( InOut how );
    /** Note: Shipment will not handle SkuHandler's takeLocation. */
    Lot<SkuHandler> takeItems();
    void shipmentEnd();
}
