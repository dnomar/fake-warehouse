package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;



public class TestFakeWarehouseApp{

	private String ruta="C:\\Users\\Owner\\Documents\\curso ybl 2018\\fake-warehouse\\test.txt";
	private String valid_ip="192.168.2.34";
	private String valid_port="34567";
	private File arch=null;
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_Retornar_IllegalArgumentException_1_Params_Cuando_Espera_7(){
		
		//Cuando
		String[] args = {"uno"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_Retornar_IllegalArgumentException_Si_No_Recibe_Params(){
		
		//Cuando
		String[] args = {""};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_Retornar_IllegalArgumentException_Si_Recibe_8_Params_Cuando_Espera_7(){
		
		//Cuando
		String[] args = {"uno","uno","2","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	/*
	@Test
	public void correct_number_of_params(){
		
		//Cuando
		String[] args = {"INVENT",ruta,"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		assertTrue(mn.init(args));
	}*/

	@Test (expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Param_1_No_Es_INVENT_o_CARTOLA_o_PLANGER(){
		//Cuando
		String[] args = {"uno","2","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	/*
	@Test
	public void retorna_TRUE_si_param_1_es_INVENT(){
		//Cuando
		String[] args = {"INVENT",ruta,"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		assertTrue(mn.init(args));
	}
	
	@Test
	public void retorna_TRUE_si_param_1_es_CARTOLA(){
		//Cuando
		String[] args = {"CARTOLA",ruta,"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		assertTrue(mn.init(args));
	}
	
	@Test
	public void retorna_TRUE_si_param_1_es_PLANGER(){
		//Cuando
		String[] args = {"PLANGER",ruta,"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		assertTrue(mn.init(args));
	}
	*/
	@Test (expected = IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Param_2_No_Es_Archivo(){
		
		//Dado
		try{
			arch=File.createTempFile("test_",null);
			//System.out.println(arch.getPath());
		}catch(Exception e){
			System.out.println("Excepcion :"+e);
		}
		
		String[] args = {"PLANGER","bla.por","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		mn.init(args);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_SI_Param_5_No_ES_IP_Valido(){
		
		//Dado
		try{
			arch=File.createTempFile("test_",null);
			//System.out.println(arch.getPath());
		}catch(Exception e){
			System.out.println("Excepcion :"+e);
		}
		
		String[] args = {"PLANGER",arch.getPath(),"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
		
		
	}
	
	@Test(expected=NumberFormatException.class)
	public void retorna_IllegalArgumentException_Si_Param_6_No_ES_Un_Puerto_Valido_Al_Recibir_String(){

		//Dado
		try{
			arch=File.createTempFile("test_",null);
			//System.out.println(arch.getPath());
		}catch(Exception e){
			System.out.println("Excepcion :"+e);
		}
		
		String[] args = {"PLANGER",arch.getPath(),"3","4","5","bla","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Param_6_Es_Menor_Que_0(){

		//Dado
		try{
			arch=File.createTempFile("test_",null);
			//System.out.println(arch.getPath());
		}catch(Exception e){
			System.out.println("Excepcion :"+e);
		}
		
		String[] args = {"PLANGER",arch.getPath(),"3","4","5","-1","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
		
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Param_6_Es_Mayor_Que_65535(){

		//Dado
		try{
			arch=File.createTempFile("test_",null);
			//System.out.println(arch.getPath());
		}catch(Exception e){
			System.out.println("Excepcion :"+e);
		}
		
		String[] args = {"PLANGER",arch.getPath(),"3","4","5","65536","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
		
	}		
	
	@Test(expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Conexion_a_BD_No_Cumple_Con_Formato(){}
	
	@Test(expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_Si_Tipo_de_Archivo_No_Es_Coherente_Con_Parametro_1(){}
	
	

}