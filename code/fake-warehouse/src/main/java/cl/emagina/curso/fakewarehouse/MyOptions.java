package cl.emagina.curso.fakewarehouse;

public class MyOptions{
	
	private String[] args;
	
	public MyOptions(String[] args){
		this.args=args;
	}
	
	public void export(IOptionsHandler ioh){
		
		ioh.optionsStart();
		ioh.takeFilePath(args[1]);
		ioh.takeFileOrigin(args[0]);
		ioh.takeBdUserPass(args[2],args[3]);
		ioh.takeBdIpPortSchema(args[4],args[5],args[6]);
		ioh.optionsEnd();
	}
	
}