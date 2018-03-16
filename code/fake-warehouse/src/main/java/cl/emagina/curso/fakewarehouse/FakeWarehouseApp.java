package cl.emagina.curso.fakewarehouse;

import java.io.*;
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
		
		CommandLineParser parser=null;
		CommandLine cmdLine=null;
		OutputStream output = null;
		
		//Configurtamos las opciones de entrada
		Options opt = new Options();
		opt.addOption("f",true," Fuente del Archivo INVENT, CARTOLA, PLANGER");
		opt.addOption("path",true," ruta del archivo");
		opt.addOption("bd_user",true,"usuario de la base de datos");
		opt.addOption("bd_pass",true,"password de la base de datos");
		opt.addOption("bd_ip",true,"ip/host de la base de datos");
		opt.addOption("bd_port",true,"puerto de la base de datos");
		opt.addOption("bd_name",true,"Nombre de la base de datos");
		opt.addOption("h","help",false,"Imprime el mensaje de ayuda");
		
		
		//Parsea las entradas y salidas
		try{
			
			parser = new BasicParser();
			cmdLine=parser.parse(opt,args);
			
			if(cmdLine.hasOption("h")){
				new HelpFormatter().printHelp(FakeWarehouseApp.class.getCanonicalName(), opt);
				return false;
			}			
		
		}catch (Exception e){
			
	
		}
		
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