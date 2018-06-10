package cl.emagina.curso.adapterstudy;

public class CarroCompra implements Webpay{
	
	private String montoCLP;
	private Webpay wbp=null;
	private String monea="CLP";
	private MoneyAdapter madp;
	
	public CarroCompra(String montoCLP){
		this.montoCLP=montoCLP;
	}
	
	public CarroCompra(String montoCLP, String monea){
		this.montoCLP=montoCLP;
		this.monea=monea;
	}
	
	public void enviarPago(){
		if(this.monea.equalsIgnoreCase("USD")){
			madp=new MoneyAdapter(montoCLP,monea);
			madp.enviarPago();			
		}else{

			System.out.println("Se ha enviado un pago por el monto de $"+ montoCLP+"(CLP)");
		}

	}
}