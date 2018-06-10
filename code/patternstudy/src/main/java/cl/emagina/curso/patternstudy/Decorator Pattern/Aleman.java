package cl.emagina.curso.decoratorstudy;


public class Aleman extends AdicionalesDecorator{
	
	Aleman(ISandwich snd){
		super(snd);
	}
	@Override
	public void description(){
		super.description();
		System.out.println("Mostaza, Chucrut");
	}
	@Override
	public int cost(){
		return super.cost()+450;
	}

}