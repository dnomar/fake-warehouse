package cl.emagina.curso.fakewarehouse;

import java.io.*;
import java.io.File;
import org.apache.commons.cli.*;


/**
* Recibe los argumentos por linea de comando, consulta los archivos, extrae
* la data necesaria y carga la base de datos con la informacion requerida 
*/
public class FakeWarehouseApp{
	
	private CommandLineParser parser=null;
	private CommandLine cmdLine=null;
	private OutputStream output = null;
	private File file=null;
	
	public enum InformationSource{
		INVENT,CARTOLA,PLANGER;
	} 	
	

	public static void main (String[] args){
		
		FakeWarehouseApp fwa = new FakeWarehouseApp();
		fwa.init(args);
	}
	
	public boolean init(String[] args){
		


		//Verificando parametros
		verifArgs(args);
		
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
		
		
		return true;
	}
	
	private void verifArgs(String[] args){
		
		//Verifica que esten presentes todos los argumentos
		if(args.length!=7){
			throw new IllegalArgumentException("Se debe ingresar los 7 parametros requeridos");
		}
		
		//Verifica parametro 1 sea valido
		if(args[0]!=InformationSource.INVENT.toString() && args[0]!=InformationSource.CARTOLA.toString() && args[0]!=InformationSource.PLANGER.toString() ){
			
			throw new IllegalArgumentException("El primer parametro debe ser INVENT, CARTOLA o PLANGER");
		}
		
		//Verifica parametro 2 sea valido, se busca un archivo que exista.
		file = new File(args[1]);
		System.out.println(file.getPath());
		if(!file.isFile()||!file.exists()){
			throw new IllegalArgumentException("Archivo no existe");
		}
		
		//Verifica parametro 6 sea valido, arroja excepcion si argumento no es Integer.
		try{
			Integer.valueOf(args[5]);
		}catch(NumberFormatException e){
			throw new NumberFormatException("Archivo no existe");
		}
		
		//Verifica parametro 6 sea valido, Integer debe ser mayor que 0 y Menor que 65535.
		if(Integer.valueOf(args[5])<0 || Integer.valueOf(args[5]) > 65535){
			throw new IllegalArgumentException("Puerto debe ser mayor que 0 y menor o igual que 65535");
		}
		
		
	}
	

}