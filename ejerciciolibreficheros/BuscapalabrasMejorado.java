package ejerciciolibreficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuscapalabrasMejorado {
  public static void main (String[]args) {

	  Scanner s = new Scanner(System.in);
	  ArrayList<Integer> a = new ArrayList<>();
	  ArrayList<String> b = new ArrayList<>();
	  
	try {
	  System.out.println("¿Qué palabra buscas?");
	  String respuesta = (s.nextLine());
	  
	  BufferedReader br1 = new BufferedReader(new FileReader("algunas_palabras.txt"));
	  
	  String linea;
	  int contador = 0;
	  int cuentaLineas = 0;
	  
	  do {
		cuentaLineas++;
		linea = br1.readLine();
		b.add(linea);
		if(linea != null) {
		  if(linea.contains(respuesta)) {
		    contador++;
		    a.add(cuentaLineas);
		  }
		}
	  } while(linea != null);
	  br1.close();
	  
	  if(b.contains(respuesta)) {
	    System.out.println("Existen " + contador + " palabras así dentro de este fichero");
	    System.out.print("Más concretamente, en las siguientes líneas:");
	  
	    for(int i=0; i < a.size(); i++) {
	      System.out.print(a.get(i) + " ");
	    }
	  } else {
		System.out.println("Esa palabra no existe en este fichero.");
	  }
	  
	  
	} catch(FileNotFoundException f){
	  System.out.println("No se puede encontrar alguno de los ficheros");
			
	} catch (IOException ioe) {
	  System.out.println("Existen problemas de lectura y/o escritura en algún fichero");
	}
  }
}
