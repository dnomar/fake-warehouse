package cl.emagina.curso.fakewarehouse.parsers;

import cl.emagina.curso.fakewarehouse.DictionaryHandler;
import java.io.*;
import java.io.PrintWriter;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import cl.emagina.curso.fakewarehouse.utils.*;
import cl.emagina.curso.fakewarehouse.*;

/**
 * Parses a SKU dictionary CSV into a
 * {@link cl.emagina.curso.fakewarehouse.DictionaryHandler DictionaryHandler}
 * <b>Format</b>
 * <pre>{@code
#
# Kind, SKU, Desc
#
SKU Spec, 11-222-33, Block 100 pages
SKU Spec, 42-222-33, Block 50 pages
 * }</pre>
 */
public class DictionaryCsvParser {
	
	private Reader rdr;
	

    //--------------------------------------------------------------------------
    // constructors
    //--------------------------------------------------------------------------

    public DictionaryCsvParser( Reader rdr ) {
		this.rdr=rdr;
    }


    //--------------------------------------------------------------------------
    // methods
    //--------------------------------------------------------------------------


    /**
     * Parses the CSV associated to this parser into the specified <tt>dest</tt>
	 *
	 * @param lotDh collection of DictionaryHandler to handle the exportation
     */
    public void exportTo( Lot<DictionaryHandler> lotDh ) {
		
		Scanner scn=new Scanner(this.rdr);
		String arr,scnStr;
		String[] los;
		DictionaryHandler dict;
		
		dict=lotDh.lotStart();
		//Recorre el Scanner verticalmente
		while(scn.hasNextLine()==true){
			//Verifica que la linea no comience con #
			//gato=scn.findInLine("#");
			dict.dictionaryStart();				
			arr=scn.nextLine();
			arr=catLikeComment(arr);
			System.out.println(arr);
			if(arr!=null){
				//System.out.println("Linea de Archivo: "+ arr);
				los=arr.split(",");
				dict.takeSku(los[1]);
				dict.takeSkuDesc(los[2]);
				dict.dictionaryEnd();
			}else{
				scn.nextLine();
			}
		}
		lotDh.lotEnd();
    }
	/**
	 * Split a String in # char into 2 strings and return the left side of the 
	 * original string
	 * Example:
	 * text1#text2 returns text1
	 * 
	 * param rawStr is a string whitout processing
	 * return  Processed string
	 */
	
	private String catLikeComment(String rawStr){
		String[] arr; 
		
		if(rawStr.matches("[#]+")){
			return null;
		}else{
			arr=rawStr.split("[#]+");
			return arr[0];
		}
		
	}
	
}
