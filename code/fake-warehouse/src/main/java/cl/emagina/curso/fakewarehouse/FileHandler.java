package cl.emagina.curso.fakewarehouse;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;

/**
* Recibe un Reader y devuelve un ArrayList con las lineas del archivo
* original 
*/
public class FileHandler{
	
	private BufferedReader rdr;
	private String auxStr;
	private ArrayList<String> rowList;
	
	public FileHandler(BufferedReader buffRdr){
		this.rdr=buffRdr;
	}
	
	public List<String> fileExport(){
		
		this.rowList=new ArrayList<String>();
		
		try{
			this.auxStr=this.rdr.readLine();
			
			while(this.auxStr!=null){
				
				this.rowList.add(this.auxStr);
				this.auxStr=this.rdr.readLine();
		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rowList;
		
	}
	
}