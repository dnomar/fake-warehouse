package cl.emagina.curso.fakewarehouse;

import java.io.File;
import org.apache.commons.cli.*;

public class FakeWarehouseApp{
	
	public enum InformationSource{
		INVENT,CARTOLA,PLANGER;
	} 	
	
	public static void main (String[] args){
		
		FakeWarehouseApp fwa = new FakeWarehouseApp();
		fwa.init(args);
	}
	
	public boolean init(String[] args){
		
		//Aqui ocurre la magia...
		//Verificando parametros
		verifArgs(args);
		
		return true;
	}
	
	private void verifArgs(String[] args){
		
		if(args.length!=7){
			throw new IllegalArgumentException("Se debe ingresar los 7 parametros requeridos");
		}
		
		//VErifica parametro 1 sea valido
		if(args[0]!=InformationSource.INVENT.toString() && args[0]!=InformationSource.CARTOLA.toString() && args[0]!=InformationSource.PLANGER.toString() ){
			
			throw new IllegalArgumentException("El primer parametro debe ser INVENT, CARTOLA o PLANGER");
		}
		
		//Verifica parametro 2 sea valido
		File file = new File(args[1]);
		if(!file.isFile()){
			throw new IllegalArgumentException("Archivo no existe");
		}
	}
	

}