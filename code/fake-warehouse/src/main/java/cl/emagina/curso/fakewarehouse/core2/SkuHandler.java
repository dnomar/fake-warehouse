package cl.emagina.curso.fakewarehouse.core2;


import java.util.Calendar;

/*
* Sku to Handle
*/
public interface SkuHandler {
	void skuStart();
	void takeSkuNr( String nr );
	void takeSkuDesc( String desc );
	void takeSkuQty(String qty);
	void skuEnd();
	/**
	* The invocation sequence is
	* <ol>
	* <li>skuStart
	* <li>Zero to N times invoke the complete sequence of SkuHandler methods
	* (the order is not important except that skuStart() is called first and
	* skuEnd() is called last, on each iteration):
	* </li>
	* <li>skuEnd
	* </ol>
	*/
	public static interface Lot extends SkuHandler {
		void skuLotStart();
		void skuLotEnd();
	}
}