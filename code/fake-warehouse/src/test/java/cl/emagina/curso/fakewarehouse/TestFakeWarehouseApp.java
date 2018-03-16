package cl.emagina.curso.fakewarehouse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;



public class TestFakeWarehouseApp{

	private String ruta="C:\\Users\\Owner\\Documents\\curso ybl 2018\\fake-warehouse\\test.txt";
	private String valid_ip="192.168.2.34";
	private String valid_port="34567";
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_retornar_IllegalArgumentException_6_params(){
		
		//Cuando
		String[] args = {"uno"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_retornar_IllegalArgumentException_without_params(){
		
		//Cuando
		String[] args = {""};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deberia_retornar_IllegalArgumentException_8_params(){
		
		//Cuando
		String[] args = {"uno","uno","2","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
	@Test
	public void correct_number_of_params(){
		
		//Cuando
		String[] args = {"INVENT",ruta,"3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		assertTrue(mn.init(args));
	}

	@Test (expected=IllegalArgumentException.class)
	public void retorna_IllegalArgumentException_si_param_1_no_es_INVENT_o_CARTOLA_o_PLANGER(){
		//Cuando
		String[] args = {"uno","2","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		mn.init(args);
	}
	
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
	
	@Test (expected = IllegalArgumentException.class)
	public void retorna_illegalargumentexception_si_param_2_no_es_archivo(){
		//Dado
		String[] args = {"PLANGER","2","3","4","5","6","7"};
		
		FakeWarehouseApp mn=new FakeWarehouseApp();
		
		//mn.init(args);
		
		assertTrue(mn.init(args));
	}

}