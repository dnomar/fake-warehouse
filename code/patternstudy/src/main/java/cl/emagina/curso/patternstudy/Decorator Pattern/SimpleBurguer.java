package cl.emagina.curso.decoratorstudy;


public class SimpleBurguer implements ISandwich{
	
	public void description(){
		System.out.println("Pan, hamburguesa de vacuno");
	}
	public int cost(){
		return 1000;
	}

}