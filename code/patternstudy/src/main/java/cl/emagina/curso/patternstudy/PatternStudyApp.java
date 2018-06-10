package cl.emagina.curso.builderstudy;

import java.io.*;
import java.io.File;
import org.apache.commons.cli.*;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.io.FilenameUtils;


/**
* Recibe 2 argumentos el typo de Archivo y la Ruta para poder ser reproducido
*/
public class PatternStudyApp{
	
	

	public static void main (String[] args){

		//Builder Pattern implemented with a static class	
		Person p1=new Person.Builder().nombre("Timmo")
					.apellido("Tolki")
					.direccion("las condes 9402")
					.edad("35")
					.sexo("Male")
					.build();
		p1.personPrinter();
		
		//Commandpattern example
		//
		Fan vent=new Fan();
		ICommand upCom=new UpCommand(vent);
		ICommand downCom=new DownCommand(vent);
		Switch sw=new Switch(upCom,downCom);
		sw.off();
		

	}
	

}