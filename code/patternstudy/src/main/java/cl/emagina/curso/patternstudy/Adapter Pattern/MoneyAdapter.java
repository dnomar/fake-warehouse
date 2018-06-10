package cl.emagina.curso.adapterstudy;

public class MoneyAdapter implements Webpay{
	
	private String pago;
	private String currency;
	private Paypal pp=null;
	private Webpay wp=null;
	
	
	public MoneyAdapter(String pago, String currency){
		this.pago=pago;
		this.currency=currency;
	}
	
	public void enviarPago(){
		if(this.currency.equalsIgnoreCase("CLP")){
			wp=new CarroCompra(this.pago);
			wp.enviarPago();	
		}else if(this.currency.equalsIgnoreCase("USD")){
			pp=new ShopCart(this.pago);
			pp.sendPayment();
		}
	}
	 
}