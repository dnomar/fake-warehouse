package cl.emagina.curso.fakewarehouse;

import java.io.*;
import java.io.File;
import org.apache.commons.cli.*;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.io.FilenameUtils;



/**
* Recibe los argumentos por linea de comando, consulta los archivos, extrae
* la data necesaria y carga la base de datos con la informacion requerida 
*/
public class FakeWarehouseApp{
	
	private CommandLineParser parser=null;
	private CommandLine cmdLine=null;
	private OutputStream output = null;
	private File file=null;
	private String ext,fph=null;

	public enum InformationSource{
	
	INVENT,
	CARTOLA,
	PLANGER
	}; 
	

	public static void main (String[] args){
		
		FakeWarehouseApp fwa = new FakeWarehouseApp();
		fwa.init(args);
	}
	
	public boolean init(String[] args){
		
		//Configuramos las opciones de entrada
		Options opt = new Options();
		opt.addOption("f","file",true,"Fuente del Archivo INVENT, CARTOLA, PLANGER");
		opt.addOption("path",true," ruta del archivo");
		opt.addOption("bd_user",true,"usuario de la base de datos");
		opt.addOption("bd_pass",true,"password de la base de datos");
		opt.addOption("bd_ip",true,"ip/host de la base de datos");
		opt.addOption("bd_port",true,"puerto de la base de datos");
		opt.addOption("bd_name",true,"Nombre de la base de datos");
		opt.addOption("f_type",true,"tipo archivo CSV"); //Se debera agregar otros fuentes de archivos	
		opt.addOption("h","help",false,"Imprime el mensaje de ayuda");		
		
		
		//Parsea las entradas y salidas
		try{
			
			parser = new BasicParser();
			cmdLine=parser.parse(opt,args);
			
			if(cmdLine.hasOption("h")){
				HelpFormatter formater = new HelpFormatter();
				formater.setOptionComparator(null);
				formater.printHelp(FakeWarehouseApp.class.getCanonicalName(), opt);
				return false;
			}			
		
		}catch (Exception e){
			System.out.println("Excepcion : " + e);
		}
		
		
		verifArgs(args);
		
		/** Original*/
		MyOptions mo=new MyOptions(args);
		//mo.export(new StdOutOptionWritter());
		
		/*ArrayList<String> fileArrayList=ArrayList<String>();
		FileHandler fr=new FileHandler(new BufferedReader());
		fileArrayList=fr.fileExport();
		for(i=0;i<fileArrayList.size();i++){
			DictionaryCsvParser dcp=new DictionaryCsvParser(fileArrayList.get(i));
		}*/
		
		return true;
		
	}
	
	private void verifArgs(String[] args){
		
		//Verifica que esten presentes todos los argumentos
		if(args.length!=8){
			throw new IllegalArgumentException("Se debe ingresar los 8 parametros requeridos");
		}
		
		//Verifica parametro 1 sea valido
		if(!args[0].trim().equals("INVENT") && !args[0].trim().equals("CARTOLA") && !args[0].trim().equals("PLANGER")){
			
			throw new IllegalArgumentException("El primer parametro debe ser INVENT, CARTOLA o PLANGER");
		}
		
		//Verifica parametro 2 sea valido, se busca un archivo que exista.
		file = new File(args[1]);
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
		
		if(!isValidIp(args[4])){
			throw new IllegalArgumentException("La IP ingresada no es valida");
		}

		//Parametroi inicial sea INVENT
		if(args[0].trim().equals("INVENT")){
			
			try{
				file=new File(args[1]);
				fph=file.getCanonicalPath();				
			}catch(Exception e){
				System.out.println("Excepcion :"+e);
			}			
			System.out.println(fph);
			ext=FilenameUtils.getExtension(fph);
			System.out.println(ext);
			if(!ext.equals("txt")){
				throw new IllegalArgumentException("Debe Ingresar Archivo .txt");
			}
		}
		
		//Borrar se debe realizar con extension del archivo cargado
		if(!args[7].trim().equalsIgnoreCase("CSV")){
			
			throw new IllegalArgumentException("CSV es el unico formato soportado");
		}		
		
	}
	
	private boolean isValidIp(String ip){
		InetAddressValidator ipValidator=new InetAddressValidator();
		return ipValidator.isValid(ip);
	}
	
}