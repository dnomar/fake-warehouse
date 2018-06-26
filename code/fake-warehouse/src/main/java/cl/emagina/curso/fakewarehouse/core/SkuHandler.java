package cl.emagina.curso.fakewarehouse.core;


import java.util.Calendar;

/*
* Sku to Handle
*/
public interface SkuHandler {
    void skuStart();
    void takeLocation( String loc );
    void takeSku( String sku );
    void takeUnit( String unit, int items_per_unit );
    void takeQty( int qty );
    void skuEnd();
}