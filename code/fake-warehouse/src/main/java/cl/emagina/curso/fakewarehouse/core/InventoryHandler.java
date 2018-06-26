package cl.emagina.curso.fakewarehouse.core;


import java.util.Calendar;
import cl.emagina.curso.fakewarehouse.utils.*;

/*
* Inventory to Handle
*/
public interface InventoryHandler {
    void inventoryStart();
    void takeDate( Calendar when );
    void takeSupervisorName( String name );
    Lot<SkuHandler> takeItems();
    void inventoryEnd();
}