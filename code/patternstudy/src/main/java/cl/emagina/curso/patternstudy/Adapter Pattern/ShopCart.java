package cl.emagina.curso.adapterstudy;

public class ShopCart implements Paypal{
	
	private String montoUSD;
	
	public ShopCart(String montoUSD){
		this.montoUSD=montoUSD;
	}
	
	public void sendPayment(){
		System.out.println("Se ha enviado un pago por el monto de US$"+ montoUSD+"(USD)");
	}
	
}