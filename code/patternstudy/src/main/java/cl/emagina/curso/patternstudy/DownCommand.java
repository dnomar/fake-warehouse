package cl.emagina.curso.builderstudy;


public class DownCommand implements ICommand{
	
	private Fan ventilador;
	
	public DownCommand(Fan f){
		this.ventilador=f;
	}
	
	public void execute(){
		ventilador.stop();
	}
	
}

