package cl.emagina.curso.builderstudy;

public class Person{
	
	private String nombre;
	private String apellido;
	private String direccion;
	private String sexo;
	private String edad;
	
	private Person(Builder pb){
		
		this.nombre=pb.nombre;
		this.apellido=pb.apellido;
		this.direccion=pb.direccion;
		this.sexo=pb.sexo;
		this.edad=pb.edad;
	}	

	public void personPrinter(){
		System.out.println("PERSON BUILDER");
		System.out.println("--------------------------------------------------");
		System.out.println("NOMBRE: "+this.nombre+" "+this.apellido);
		System.out.println("EDAD: "+this.edad);
		System.out.println("DIRECCION :"+this.direccion);
		System.out.println("SEXO: "+this.sexo);
		System.out.println("--------------------------------------------------");
	}

	public static class Builder{

		private String nombre;
		private String apellido;
		private String direccion;
		private String edad;
		private String sexo;
	
		public Builder nombre(String nombre){
			this.nombre=nombre;
			return this;
		}
		
		public Builder apellido(String apellido){
			this.apellido=apellido;
			return this;
		}		
		
		public Builder edad(String edad){
			this.edad=edad;
			return this;
		}
		
		public Builder direccion(String direccion){
			this.direccion=direccion;
			return this;
		}
		
		public Builder sexo(String sexo){
			this.sexo=sexo;
			return this;
		}
		
		public Person build(){
			return new Person(this);
			
		}
		
	}
}

