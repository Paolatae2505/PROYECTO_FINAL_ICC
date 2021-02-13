import java.util.Scanner;
/**
* EJECUTABLE MENUDOS
* @author Vargas Bravo Paola
* @version 1
*/
public class MenuDos{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int op;
		int cont2 = 0;
		boolean salir = false;
		Jugador [] concursantes;
		Jugador [] con;
		Jugador [] con1;
		UtilidadJugador v = new UtilidadJugador();
		concursantes = v.leerObjetosLibros("Jugador.txt");
		Lista lista = new Lista (concursantes);
		Lista list;   /// MENU PARA MANEJAR LA INFO DEL TORNEO PARTE 2
		while(salir == false){
            System.out.println("----------------------------------------------");
            System.out.println("--------        DIA FINALIZAD        ---------");
            System.out.println("1.------   PARTIDAS REGISTRADAS      ---------");
            System.out.println("2.------          CAMPEON            ---------");
            System.out.println("3.------          SALIR              ---------");
            System.out.println("----------------------------------------------"); 
			while(!entrada.hasNextInt()){
				System.out.println("<Da un Numero>");
				entrada.nextLine();
			}  
            op = entrada.nextInt();
                 switch(op){
				 case 1 :   /// SE EJECUTAN LOS METODOS DE LISTA PARA LA INFO
				 System.out.println("RECUERDA - Si jugaste contra la computadora");
				 System.out.println("Hubo un empate tu eres el GANADOR");
				 System.out.println("--------------------------------------");
				 System.out.println("------   ESTADO PARTIDAS     ---------");
				 lista.estadoPartidas();				 
                 break;
				 case 2 :
				 System.out.println("---------CAMPEON-----------");
                 System.out.println(lista.campeon());
                 break;
                 case 3 :
                 salir = true;           
                 break;
                 default :
                 System.out.println("No existe esa opcion"); 
                 break;
                 }
      }
     
		
	}
}