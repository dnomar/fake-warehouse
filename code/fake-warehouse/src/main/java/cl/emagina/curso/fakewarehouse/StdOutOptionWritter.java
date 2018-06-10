package cl.emagina.curso.fakewarehouse;

public class StdOutOptionWritter implements IOptionsHandler{
		
	@Override
	public void optionsStart(){
		System.out.println("---------------------------------------------");
		System.out.println("Comienza la exportacion de datos");
		System.out.println("---------------------------------------------");
	}
	
	@Override
	public void takeFileOrigin(String fOrigin){
		
		System.out.println("File Origin: "+fOrigin);
	}
	
	@Override
	public void takeFilePath(String fPath){
		System.out.println("File Path: "+fPath);
	}
	
	@Override
	public void takeBdUserPass(String bdUser, String bdPass){
		System.out.println("User: "+bdUser+" Pass: "+bdPass);
	}
	
	@Override
	public void takeBdIpPortSchema(String ip, String port, String schema){
		System.out.println("Ip: "+ip+" Port: "+port+" Schema: "+schema);
	}
	
	@Override
	public void optionsEnd(){
		System.out.println("---------------------------------------------");
		System.out.println("Fin de la exportacion de datos");
		System.out.println("---------------------------------------------");
	}
}
