package cl.emagina.curso.builderstudy;

public class Switch{
	
	private ICommand upCommand, downCommand;
	
	public Switch(ICommand comUp, ICommand comDown){
		this.upCommand=comUp;
		this.downCommand=comDown;
	}
	
	public void on(){
		upCommand.execute();
	}
	
	public void off(){
		
		downCommand.execute();
	}
	
}

