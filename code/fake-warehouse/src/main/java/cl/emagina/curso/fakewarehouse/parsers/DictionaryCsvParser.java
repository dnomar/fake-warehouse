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
 * {@link cl.justcodeit.warehouse.core.DictionaryHandler DictionaryHandler}
 * <p></p>
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
     * Parses the CSV associated to this parser into the specified <tt>dest</tt>.
     */
    public void exportTo( Lot<DictionaryHandler> lotDh ) {
		
		Scanner scn=new Scanner(this.rdr);
		String arr,gato;
		String[] los;
		DictionaryHandler dict;
		
		dict=lotDh.lotStart();
		//Recorre el Scanner verticalmente
		while(scn.hasNextLine()==true){
			//Verifica que la linea no comience con #
			gato=scn.findInLine("#");
			if(!"#".equals(gato)){
				dict.dictionaryStart();				
				arr=scn.nextLine();
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
	
}
