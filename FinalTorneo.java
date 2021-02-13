import java.util.Scanner;
/**
* EJECUTABLE FINAL TORNEO
* @author Vargas Bravo Paola
* @version 1
*/
public class FinalTorneo{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Jugador [] concursantes;
		UtilidadJugador jimin = new UtilidadJugador();
		concursantes = jimin.leerObjetosLibros("Jugador.txt");
		Lista lista = new Lista (concursantes);
		String ganador ; 
		ganador = lista.campeon(); //// NOS DICE EL GAANDOR DEL TORNEO
		System.out.println("-----------------------------------------");
		System.out.println("---------  TORNEO FINALIZADO   ----------");
		System.out.println("-----------------------------------------");
		System.out.println("ESPERAMOS DE VERDAD LO HAYAS DISFRUTADO");
		System.out.println("-----------------------------------------");
		System.out.println("");
        System.out.println("-----------------------------------------");
		System.out.println("EL GANADOR DEL TORNEO ES :");
		System.out.println(ganador);
		System.out.println("FELICIDADES !!!!");
		System.out.println("-----------------------------------------");
		System.out.println("");
		System.out.println("PREMIO");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("---------          VIP               -----");
		System.out.println("---------      BTS WORLD TOUR        -----");
		System.out.println("---------     MAP OF THE SEOUL       -----");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("Gran Premio ------------------------ :)   ");
		System.out.println("------------------------------------------");

		

		
		


		
	}
}