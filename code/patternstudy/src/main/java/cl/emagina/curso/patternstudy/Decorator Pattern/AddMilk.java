package cl.emagina.curso.decoratorstudy;


public class AddMilk extends Beverage{
	
	private Beverage bv;
	
	AddMilk(Beverage b){
		this.bv=b;
	}
	
	@Override
	public String description(){
		return this.bv.description()+ " con leche";
	}
	
	@Override
	public  int valor(){
		return this.bv.valor()+500;
	}
	

}