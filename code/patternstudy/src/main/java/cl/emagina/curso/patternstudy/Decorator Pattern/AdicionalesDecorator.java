package cl.emagina.curso.decoratorstudy;


abstract class AdicionalesDecorator implements ISandwich{
	protected ISandwich sw;
	
	AdicionalesDecorator(ISandwich sndwch){
		this.sw=sndwch;
	}
	public void description(){
		this.sw.description();
	}
	public int cost(){
		return this.sw.cost();
	}

}