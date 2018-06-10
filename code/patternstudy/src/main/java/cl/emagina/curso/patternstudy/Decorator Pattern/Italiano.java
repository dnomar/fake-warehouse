package cl.emagina.curso.decoratorstudy;


public class Italiano extends AdicionalesDecorator{
	
	Italiano(ISandwich snd){
		super(snd);
	}
	@Override
	public void description(){
		super.description();
		System.out.println("Tomate, Palta, Mayonesa");
	}
	@Override
	public int cost(){
		return super.cost()+1000;
	}

}