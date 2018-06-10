package cl.emagina.curso.decoratorstudy;


abstract class AddonDecorator extends Beverage{
	
	protected Beverage bv;
	
	AddonDecorator(Beverage b){
		this.bv=b;
	}
	
	@Override
	public String description(){
		return(this.bv.description());
	}
	
	@Override
	public int valor(){
		return this.bv.valor();
	}
	

}