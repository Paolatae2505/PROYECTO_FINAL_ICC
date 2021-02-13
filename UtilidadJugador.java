import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * CLASE MANEJA SERIALIZACION DE JUGADOR
 * @author Vargas Bravo Paola
 * @version 1
 * @see Jugador
 */
public class UtilidadJugador{
/////////////////////////ATRIBUTOS/////////////////////////////
	Jugador [] arreglo = new Jugador[0];

/**
 * Agrega un Jugador a un Arreglo
 * @param p1 --- Jugador
 * @return -- Arreglo de Jugadores
 */
public Jugador [] agregarArregloJugador(Jugador p1){
	Jugador [] nuevo = new Jugador [arreglo.length+1];
	for (int i = 0;i < arreglo.length ;i ++) {
		nuevo[i] = arreglo[i];
		
	}
	nuevo[nuevo.length-1] = p1;
	arreglo = nuevo;
	return arreglo;

}
/**
 * Guarda Objetos de Tipo Jugador en Archivo
 * @param rutaArchivo Ruta de destino 
 * @return --- Arreglo de Jugadores
 */
public Jugador [] leerObjetosLibros(String rutaArchivo){
    ObjectInputStream lect = null;

    try{
    	lect = new ObjectInputStream(new FileInputStream(rutaArchivo));
        Object objeto;
        do{
        	objeto = lect.readObject();
        	if (objeto != null) {
        		agregarArregloJugador((Jugador) objeto);
        	}
        }while(objeto != null);

    }catch(java.lang.ClassNotFoundException e){

    }catch(java.io.EOFException e){

    }catch(IOException e){
    	System.out.println("Lectura fallida :" + e);
    }finally{
    	if (lect != null) {
    		try { lect.close();}catch(IOException e){}
    	}
    }
   return arreglo;

 }
/**
 * Escribe Onjetos de Tipo Jugador en el arhivo de destino
 * @param rutaArchivo Ruta de destino 
 * @param arreglo --- Arreglo que se desea Escribir
 */
 public void escribirObjetosArchivos(String rutaArchivo, Object[] arreglo){
	ObjectOutputStream escritor = null;
	try{
     escritor = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
     for (int i = 0; i <arreglo.length ; i++) {
           escritor.writeObject(arreglo[i]);     	
     }
	}catch(IOException e){
		System.out.println("Error en la grabacion"+ e);
	}finally{
		try{escritor.close();}catch(IOException e){}
	}
}

}