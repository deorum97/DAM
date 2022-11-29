import java.io.*;
public class EscribirObj {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Persona persona; //Creacion de persona para futuro uso
		
		File fichero = new File("/home/alumno/acceso_datos/1/pruebas/FichPersona.txt");
		
		ObjectOutputStream dataos; //Creacion de escritura de objetos sin new para poder usarlo mas tarde
		
		
		//Creacion de arrays para poner en el objeto persona
		String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
                "Julio","Antonio","Maria Jesus"}; 
		
		int edades[] = {14,15,13,15,16,12,16,14,13};
		
		//comprobacion de si el fichero existe o no para usar un ecritor u otro
		if(!fichero.exists()) {
			
			FileOutputStream fileout = new FileOutputStream(fichero);
			dataos=new ObjectOutputStream(fileout); //apertura del escritor de objetos por defecto
			
		}else {
			
			dataos=new MiObjectOutputStream(new FileOutputStream(fichero,true)); //apertura del escritor de objetos modificado 
			//se puede usar asi de la misma forma de arriba del else 
			
		}
		
		//Creacion de los objetos y escritura de los objetos en el echivo
		for (int i=0; i<edades.length;i++) {
			
			persona = new Persona(nombres[i],edades[i]);
			dataos.writeObject(persona);
			
		}
		dataos.close();
	}

}
