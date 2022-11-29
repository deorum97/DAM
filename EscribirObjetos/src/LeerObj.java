import java.io.*;

public class LeerObj {
	public static void main(String[] args) throws IOException, ClassNotFoundException{//hacen falta los dos controladores de errores

		Persona persona;
		
		File fichero = new File("/home/alumno/acceso_datos/1/pruebas/FichPersona.txt");
		
		FileInputStream filein = new FileInputStream(fichero);
		
		ObjectInputStream datain = new ObjectInputStream(filein);
		
		try {
			while(true) {
				
				persona= (Persona)datain.readObject();
				System.out.printf("Nombre: %s, edad: %d %n",persona.getNombre(),persona.getEdad());
				
			}
		}catch(EOFException eo) {
			
			System.out.println("Fin de lectura");
			
		}
		
		datain.close();
	}
}
