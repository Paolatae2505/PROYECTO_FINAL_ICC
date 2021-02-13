import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * EJECUTABLE REGISTRO
 * @author Vargas Bravo Paola
 * @version 1
 */
public class Registro{
	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	Scanner on = new Scanner(System.in);
	boolean salir = false;
	String nombre,sexo,alias,carrera;
	int edad = -1;
	Jugador [] list = new Jugador [0];
	UtilidadJugador tae  = new UtilidadJugador();
	Jugador p;
	   while(salir == false){  /// MENU PARA RESGITRAR JUGADORES
		System.out.println("--------------------------------------------------");
		System.out.println("----------TORNEO FACULTAD DE CIENCIAS-------------");
		System.out.println("-----------  Dia 1 : MINI BLACK JACK--------------");
		System.out.println("-----------  Dia 2 : DADOS          --------------");
		System.out.println("-----------  Dia 3 : CONECTA 4      --------------");
		System.out.println("----------- ¿QUIERES REGISTRARTE?   --------------");
		System.out.println("-----------         1.Si            --------------");
		System.out.println("-----------         2.No            --------------");
		System.out.println("--------------------------------------------------");
		while(!entrada.hasNextInt()){
			System.out.println("<Da un Numero >");
            entrada.nextLine();
		}
		int op = entrada.nextInt();
		switch(op){
			case 1 :
			System.out.println("NOMBRE : ");
			nombre = on.nextLine();
			System.out.println("SEXO F o M : ");
			sexo = on.nextLine();
			System.out.println("EDAD :");
			do{ 
				try{
				edad = entrada.nextInt(); 
				}catch(InputMismatchException ex){
					System.out.println("ESE NO ES UN NUMERO");
				   System.out.println(ex);
				   entrada.nextLine();
				}
				 if (edad < 0) {
					System.out.println("Ingrese un numero Mayor a 0");
				 }
				 }while(edad < 0 );
			System.out.println("ALIAS : ");
			alias = on.nextLine();
			System.out.println("CARRERA :");
			carrera = on.nextLine();
			p = new Jugador(nombre,sexo,edad,alias,carrera);
			list = tae.agregarArregloJugador(p);   /// GUARDA EN UN ARREGLO SERIALIZADO
			System.out.println("Gracias por tu registro");
			System.out.println("TE DESEAMOS MUCHA SUERTE");
			break;			
			case 2 :
			System.out.println("HASTA LUEGO !!!");
			tae.escribirObjetosArchivos("Jugador.txt", list);
			salir = true;
			break;
			default :
			System.out.println("Esa no es una opción");
			break;
		 }
	   }
	}
}