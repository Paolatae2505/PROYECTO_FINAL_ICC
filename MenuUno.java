import java.util.Scanner;
/**
 * EJECUTABLE MENUUNO
 * @author Vargas Bravo Paola
 * @version 1
 */
public class MenuUno{
     public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      int op;
      int cont2 = 0;
      boolean salir = false;
      Jugador [] concursantes;
      Jugador [] con;
      Jugador [] con1;
      UtilidadJugador util = new UtilidadJugador();
      concursantes = util.leerObjetosLibros("Jugador.txt");
      Lista lista = new Lista (concursantes);
      Lista list;
      // MENU PARA MANEJAR LA INFORMACION DE TORNEO PART 1
      while(salir == false){
            System.out.println("----------------------------------------------");
            System.out.println("--------         INICIO DIA          ---------");
            System.out.println("--------   Bienvenido a el Torneo    ---------");
            System.out.println("1.------   Concursantes Registrados  ---------");
            System.out.println("2.------   Lista de Contrincantes    ---------");
            System.out.println("3.------          SALIR              ---------");
            System.out.println("----------------------------------------------");   
            while(!entrada.hasNextInt()){
			System.out.println("<Da un Numero >");
            entrada.nextLine();
		    }   
            op = entrada.nextInt();
                 switch(op){
                 case 1 :
                 lista.participantes();
                 break;
                 case 2 :
                 if(cont2 == 0){  
                 lista.asignarParejas();
                 con = lista.getJugadores();  // GUARDAR CAMBIOS SERIALIZADOS
                 util.escribirObjetosArchivos("Jugador.txt", con);  
                 con1 = util.leerObjetosLibros("Jugador.txt");
                 list = new Lista( con1);
                 list.imprimirParejas();
                 cont2 ++;                
                 }else if(cont2 > 0 ){  //PARA QUE NO VUELVA A REVOLVER PAREJAS
                     System.out.println("Las parejas ya fueron Vistas");
                 }
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