package cl.emagina.curso.builderstudy;


public class UpCommand implements ICommand{
	
	private Fan ventilador;
	
	public UpCommand(Fan f){
		this.ventilador=f;
	}
	
	public void execute(){
		this.ventilador.rotate();
	}
	
}

