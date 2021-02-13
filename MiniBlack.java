import java.util.Scanner;
/**
* JUEGO MINIBLACK
* @author Vargas Bravo Paola
* @version 1
*/
public class MiniBlack{
	public static void main(String[] arreglo) {
   Scanner on = new Scanner(System.in);
   Jugador [] lista;
   UtilidadJugador jk = new UtilidadJugador();
   lista = jk.leerObjetosLibros("Jugador.txt");
   Lista listaP = new Lista(lista);
   String  p1, p2;
   int op , op1;
   BarajaBlack baraja = new BarajaBlack();
   String compuClave = "Computadora";
   Boolean togheter = false;
   Jugador play1;
   Jugador play2;
   int decisivo1 = 1;
   int decisivo2 = 1;
   Carta carta1, carta2, sacada1, sacada2;
   int puntosPlay1 = 0;
   int  puntosPlay2 = 0;
   int puntosPlay3 = 0;
   int  puntosPlay4 = 0;
   boolean empates = true;
   int intentos = 0;
   if (arreglo.length == 2) {
     p1 = arreglo[0];
     p2= arreglo[1];
     play1 = listaP.getJugadorPorString(p1);
     play2 = listaP.getJugadorPorString(p2);
     if(play1.getContrincante().equals(play2.getClave())){ // VERFIFICA QUE SEA EL CONTRINCANTE
      System.out.println("-----BIENVENIDOS AL JUEGO MINI BLACK-----");
      System.out.println("-----INSTRUCCIONES DEL JUEGO :-----------");
      System.out.println("---AS : VALOR 11 0 1 ESTO ES AL AZAR-----");
      System.out.println("---J,Q,K : VALOR 10----------------------");
      System.out.println("---EL RESTO DE CARTAS CONSERVA SU VALOR--");
      System.out.println("---GANA EL QUE JUNTE 21 PUNTOS O---------");
      System.out.println("---EL MAS CERCANO A EL MISMO ------------");
      System.out.println("---RECUERDEN PUEDEN QUEDARSE SI YA NO----");
      System.out.println("---QUIEREN SACAR MAS CARTAS--------------");
      System.out.println("---EN CASO DE HABER UN EMPATE SE REPITE--");
      System.out.println("---LA PARTIDA SI SE REPITE EL CASO-------");
      System.out.println("---SE GANA LA MITAD DE PUNTOS------------");
      System.out.println("---ES UN JUEGO DE AZAR-------------------");
      System.out.println("--------------¡¡¡ÉXITO!!!----------------");
      System.out.println("NOMBRE : "+ play1.getNombre());
      System.out.println("ALIAS  : " + play1.getAlias());;
      System.out.println("VS");
      System.out.println("NOMBRE : "+ play2.getNombre());
      System.out.println("ALIAS  : " + play2.getAlias());;
      System.out.println("SUERTE !!!!");
      System.out.println("----------------------------------------");
      System.out.println("------------- QUE PIERDA ---------------");
      System.out.println("-------------  EL RIVAL  ---------------");
      System.out.println("------------- MAS DÉBIL  ---------------");
      System.out.println("----------------------------------------");
      while(empates == true){ // CICLO PARA QUE SE REPITA EN CASO DE UN EMPATE 
       puntosPlay1 = 0;
       puntosPlay2 = 0;   // INICIALIZE TODO EN CASO DE EMPATE
       baraja.mixes();
       System.out.println("----------------------------------");
       System.out.println("--------EL JUEGO COMIENZA---------");
       System.out.println("--------  PRIMERA CARTA  ---------");
       System.out.println("----------------------------------");
       System.out.println(play1.getAlias());
       carta1 = baraja.primeraCarta();
       System.out.println("Carta :");                 /// SACA LA PRIMER CARTA CON SUS PUNTOS
       System.out.println(carta1);                    // PARA CADA JUGADOR
       puntosPlay1 += baraja.ValorPuntoPorCarta(carta1);
       System.out.println("PUNTOS"+ " " +play1.getAlias() + " " +":");
       System.out.println(puntosPlay1);
       System.out.println("----------------------------------------");
       System.out.println(play2.getAlias());
       System.out.println("Carta :");
       carta2 = baraja.primeraCarta();
       System.out.println(carta2);
       puntosPlay2 += baraja.ValorPuntoPorCarta(carta2);
       System.out.println("PUNTOS"+" " + play2.getAlias() + " " +":");
       System.out.println(puntosPlay2);
       System.out.println("----------------------------------------");
       play1.jugar();
       play2.jugar();
       do{
         if(play1.estaJugando() == true){
          System.out.println(" ----"+ play1.getAlias() +" "+" PUNTOS --");
          System.out.println("Puntos :" +" "+ puntosPlay1);
          System.out.println("----------------------------------");
 //////////////////////////MOSTRAR PUNTOS PARA SU ELECCION///////////////////////////////////
      System.out.println("¿Quieres quedarte "+play1.getAlias() +"  1.Si / 2.No ?");
      while(!on.hasNextInt()){
      System.out.println("<Da un Numero >");
      on.nextLine();
      }
       op = on.nextInt(); 
      switch(op){               
      case 1 :
      play1.terminarJugar();
      decisivo1 =2 ;
      break;           
      case 2 :
      play1.jugar();
      decisivo1 = 1;
      break;    
      default :
      System.out.println("Esa no es una opcion");
      System.out.println("Por default has decidido quedarte");
      System.out.println(":)");
      play1.terminarJugar();
      decisivo1 = 2;
      break;
     }///////////Swich /////////// 
          ////////SACA LA CARTA EN CASO DE SEGUIR /////////////////
           if(decisivo1 == 1){
               System.out.println(play1.getAlias() +" " + "PIDIO OTRA CARTA");
               System.out.println("--SIGUIENTE CARTA DE :" + " "+ play1.getAlias()+ "--");
               sacada1 = baraja.primeraCarta();
               puntosPlay1 += baraja.ValorPuntoPorCarta(sacada1);
               System.out.println("Carta :");
               System.out.println(sacada1);
               System.out.println("Puntos"+ " " +play1.getAlias() + " " +":");
               System.out.println(puntosPlay1);
               System.out.println("----------------------------------------");
               play1.jugar(); ////////EVALUAR SI SU CARTA ES MAYOR A 21, SI LO ES TERMINA EL JUEGO 
               if(puntosPlay1 >= 21 ){
                   decisivo1 = 25;
                   decisivo2 = 18;
                   System.out.println(play1.getAlias() + " "+ "OFF"); 
                   play1.terminarJugar();
                   play2.terminarJugar();
               }

           }     
             }else if(play1.estaJugando() == false){
              System.out.println(play1.getAlias() + " "+ "Ha decidido quedarse"); 
              decisivo1 = 2 ;         
            }
               ////////////PLay1 TERMINA SU TURNO/////////
               ////////////PLay2 EMPIEZA SU TURNO //////////  
               ////////SE EJECTUTA EL TURNO DEL JUGADOR 2 SI SE QUIERE QUEDAR O NO 
               /////// SOLO SI LA CARTA DEL JUGADOR 1 ES MENOR A 21
            if(play2.estaJugando() == true){
               System.out.println("---"+ play2.getAlias()  +" "+"PUNTOS ---");
               System.out.println("Puntos :" + " "+puntosPlay2);
               System.out.println("----------------------------------");
               ///////DE NUEVO MUESTRA LOS PUNTOS PARA SU ELECCION ///////////
               System.out.println("¿Quieres quedarte "+play2.getAlias() +" 1.Si / 2.No ?");
               while(!on.hasNextInt()){
                System.out.println("<Da un Numero>");
                on.nextLine();
              }
              op1 = on.nextInt();
              switch(op1){
               case 1 :
               play2.terminarJugar();
               decisivo2  = 2;
               break;        
               case 2 :  
               play2.jugar();
               decisivo2  = 1;
               break;
               default :
               System.out.println("Esa no es una opcion");
               System.out.println("Por default has decidido quedarte");
               System.out.println(":) ");
               play2.terminarJugar();
               decisivo2  =2 ;
               break;
                }
               ///////////////////SI DECIDE CONTINUAR SE SACA OTRA CARTA/////////////////////////
              if(decisivo2 == 1){
               System.out.println(play2.getAlias() +" " + "PIDIO OTRA CARTA");
               System.out.println("--SIGUIENTE CARTA DE :" + " "+ play2.getAlias()+ "--");
               sacada2 = baraja.primeraCarta();
               puntosPlay2 += baraja.ValorPuntoPorCarta(sacada2);
               System.out.println("Carta :");
               System.out.println(sacada2);
               System.out.println("Puntos"+ " " +play2.getAlias() + " " +":");
               System.out.println(puntosPlay2);
               System.out.println("----------------------------------------");
               if(puntosPlay2 >= 21){///////////////IGUAL SI SE QUEDA EVALUA QUE SU CARTA NO PASE DE 21   
                decisivo1 = 25;
                decisivo2 = 18;
                play2.terminarJugar();
               }

              }                  
             }else{
               System.out.println(play2.getAlias() + " " + "Ha decidido quedarse");
               decisivo2 =2 ;
             }

             if(decisivo1 == 1 && decisivo2 == 2){
              decisivo2 = 1;
            }else if(decisivo2 == 1 && decisivo1 == 2){   // SIGUE O LO DETIENE EL CICLO
             decisivo1 = 1;                              //EN CASO DE QUE UNO DECIDA QUEDARSE
           }else if(decisivo2 == 2 && decisivo1 == 2){   // Y EL OTRO YA NO 
            decisivo1 =25;
            decisivo2 = 18;
          }
          
        }while( decisivo1 == decisivo2 ); //////PARA REPETIR SACAR CARTA EN CAS DE QUEDARSE
                ///////////////while////////////////
        int resPlay1 = 21 - puntosPlay1;   //AMBOS DE QUEDAN VER QUIEN ES MAS CERCANO A 21
        int resPlay2 = 21 - puntosPlay2;
        if(puntosPlay1 == 21){  ///CONDICIONLAES PARA MARCAR EL GANADOR O PERDEDOR
          empates = false;        // DE ACUERDO A SUS PUNTOS
          play1.ganador();
          play2.perder();
          System.out.println("--------------------------------------------");
          System.out.println("Felicidades !!!" +" " + play1.getAlias());
          System.out.println("Has ganado 10 puntos");
          System.out.println("Perdiste " + " " + play2.getAlias());
          play1.sumarPuntos(10);
          System.out.println("--------------------------------------------");

        }else if(puntosPlay2 ==21){
          empates = false;
          play2.ganador();
          play1.perder();
          System.out.println("--------------------------------------------");
          System.out.println(" Felicidades !!!" + " " + play2.getAlias());
          System.out.println(" Has ganado 10 puntos ");
          System.out.println(" Perdiste " + " "+ play1.getAlias());
          play2.sumarPuntos(10);
          System.out.println("--------------------------------------------");

        }else if(puntosPlay1 > 21){
          empates = false;
          play2.ganador();
          play1.perder();
          System.out.println("--------------------------------------------");
          System.out.println(" Felicidades !!!" + " " + play2.getAlias());
          System.out.println(" Has ganado 10 puntos ");
          System.out.println(" Perdiste " + " "+ play1.getAlias());
          play2.sumarPuntos(10);
          System.out.println("--------------------------------------------");
        }else if(puntosPlay2 > 21){
          empates = false;
          play1.ganador();
          play2.perder();
          System.out.println("--------------------------------------------");
          System.out.println("Felicidades !!!" +" " + play1.getAlias());
          System.out.println("Has ganado 10 puntos");
          System.out.println("Perdiste " + " " + play2.getAlias());
          play1.sumarPuntos(10);
          System.out.println("--------------------------------------------");
        }else if(resPlay1 > resPlay2){
          empates = false;
          play2.ganador();
          play1.perder();
          System.out.println("--------------------------------------------");
          System.out.println("Felicidades !!!"+ " "+ play2.getAlias());
          System.out.println("Has ganado 10 puntos");
          System.out.println("Perdiste " +" "+ play1.getAlias());
          System.out.println("--------------------------------------------");
          play2.sumarPuntos(10);
        }else if(resPlay2 > resPlay1){
          empates = false;
          play1.ganador();
          play2.perder();
          System.out.println("--------------------------------------------");
          System.out.println("Felicidades!!!"+ " "+ play1.getAlias());
          System.out.println("Has ganado 10 puntos");
          System.out.println("Perdiste " + " " +play2.getAlias());
          System.out.println("--------------------------------------------");
          play1.sumarPuntos(10);
        }else if(puntosPlay1 == puntosPlay2 && intentos == 0){
          empates = true;  /// REPETIR EL CICLO PARA OTRA JUGADA/////
          System.out.println("--------------------------------------------");
          System.out.println("Los jugadores quedaron empates");
          System.out.println("Es necesario que se juegue otra ronda");
          System.out.println("--------------------------------------------");
          intentos ++; /// AUMENTA INTENTOS PARA LA SIGUINTE EVALUACION
        }else if(puntosPlay1 == puntosPlay2 && intentos > 0 ){ 
          empates = false;
          play1.ganador();  //// EN EL CASO DE VOLVER A QUEDAR EMPATES
          play2.ganador();   /// ESTO DEPENDE DE LOS INTENTOS
          System.out.println("--------------------------------------------");
          System.out.println("EMPATE DE NUEVO");
          System.out.println("CADA UNO GANA 5 PUNTOS");
          System.out.println(" FELICIDADES A AMBOS !!!!");
          System.out.println("--------------------------------------------");
          play1.sumarPuntos(5);
          play2.sumarPuntos(5);
        }
      }
          for(int j = 0; j< lista.length; j++){
               if(lista[j].getClave() == p1){
                    lista[j] = play1;
               }else if(lista[j].getClave()== p2){
                    lista[j] = play2;
               }                    //GUARDA EL ESTADO DE LOS JUGADORES EN EL ARREGLO SERIALIZABLE
          }
          jk.escribirObjetosArchivos("Jugador.txt", lista); 
     }else{
           System.out.println("Ese no es tu compañero");
     }
/////////////////////////////Termina  2 JUGADORES  /////////////////////
/////////////////////////////Empieza  1 JUGADOR /////////////////////
     /**
      * CON 1 JUGADOR SE MANEJA PARECIDO A DOS JUGADORES 
      * EXCEPTO POR PUNTO  QUE SE RESALTAN  QUE SON EL 
      * MANEJO QUE TOMA LA COMPUTADORA
      */
     }else if (arreglo.length == 1){
          p1 = arreglo[0];
          play1 = listaP.getJugadorPorString(p1);
          if(play1.getContrincante().equals(compuClave)){
          System.out.println("-----BIENVENIDO AL JUEGO MINI BLACK------");
          System.out.println("-----INSTRUCCIONES DEL JUEGO :-----------");
          System.out.println("---AS : VALOR 11 0 1 ESTO ES AL AZAR-----");
          System.out.println("---J,Q,K : VALOR 10----------------------");
          System.out.println("---EL RESTO DE CARTAS CONSERVA SU VALOR--");
          System.out.println("---GANA EL QUE JUNTE 21 PUNTOS O---------");
          System.out.println("---EL MAS CERCANO A EL MISMO ------------");
          System.out.println("---RECUERDA PUEDEN QUEDARSE SI YA NO-----");
          System.out.println("---QUIERES SACAR MAS CARTAS--------------");
          System.out.println("---EN CASO DE HABER UN EMPATE SE REPITE--");
          System.out.println("---LA PARTIDA SI SE REPITE EL CASO-------");
          System.out.println("---SE GANA LA MITAD DE PUNTOS------------");
          System.out.println("---ES UN JUEGO DE AZAR-------------------");
          System.out.println("--------------¡¡¡ÉXITO!!!----------------");
          System.out.println("NOMBRE : "+play1.getNombre());
          System.out.println("ALIAS : " + play1.getAlias());;
          System.out.println("VS");
          System.out.println("COMPUTADORA");
          System.out.println("TE DESEAMOS MUCHA SUERTE");
          System.out.println("----------------------------------------");
          System.out.println("------------- QUE PIERDA ---------------");
          System.out.println("-------------  EL RIVAL  ---------------");
          System.out.println("-------------  MAS DÉBIL ---------------");
          System.out.println("----------------------------------------");
          while(empates == true){
          puntosPlay3 = 0;
          puntosPlay4 = 0;
          baraja.mixes();
          System.out.println("----------------------------------");
          System.out.println("--------EL JUEGO COMIENZA---------");
          System.out.println("--------  PRIMERA CARTA  ---------");
          System.out.println("----------------------------------");
          System.out.println(play1.getAlias());
          carta1 = baraja.primeraCarta();
          System.out.println("Carta : ");
          System.out.println(carta1);
          puntosPlay3 += baraja.ValorPuntoPorCarta(carta1);
          System.out.println("PUNTOS"+ " " +play1.getAlias() + " " +":");
          System.out.println(puntosPlay3);
          System.out.println("----------------------------------------");
          System.out.println("Computadora");
          System.out.println("Carta : ");
          carta2 = baraja.primeraCarta();
          System.out.println(carta2);
          puntosPlay4 += baraja.ValorPuntoPorCarta(carta2);
          System.out.println("PUNTOS COMPUTADORA :");
          System.out.println(puntosPlay4);
          System.out.println("----------------------------------------");
          play1.jugar();
          do{
               if(play1.estaJugando() == true){
                    System.out.println(" ----"+ play1.getAlias() +" "+" PUNTOS --");
                    System.out.println("Puntos :" +" "+ puntosPlay3);
                    System.out.println("----------------------------------");
                    System.out.println("¿Quieres quedarte "+play1.getAlias() +" " +"1.Si / 2.No ?");
                    while(!on.hasNextInt()){
                    System.out.println("<Da un Numero >");
                    on.nextLine();
                    }
                    op = on.nextInt();
                    switch(op){
                    case 1 :
                    play1.terminarJugar();
                    decisivo1 = 2;
                    System.out.println( play1.getAlias() +" DECIDE QUEDARSE");
                    System.out.println("LA COMPUTADORA DECIDE QUEDARSE");
                    break;     
                    case 2 :
                    play1.jugar();
                    decisivo1 = 1;
                    break;
                    default :
                    System.out.println("Esa no es una opcion");
                    System.out.println("Por default has decidido quedarte");
                    System.out.println(":)");
                    play1.terminarJugar();
                    decisivo1 = 2;
                    }///////////Swich//////////////////// 
               if(decisivo1 ==1){
               System.out.println(play1.getAlias() +" " + "PIDIO OTRA CARTA");
               System.out.println("--SIGUIENTE CARTA DE :" + " "+ play1.getAlias()+ "--");
               sacada1 = baraja.primeraCarta();
               puntosPlay3 += baraja.ValorPuntoPorCarta(sacada1);
               System.out.println("Carta :");
               System.out.println(sacada1);
               System.out.println("Puntos"+ " " +play1.getAlias() + " " +":");
               System.out.println(puntosPlay3);
               if(puntosPlay3 >= 21){
                    decisivo1 = 2;
               }
               }
                /**
                 * LA COMPUTADORA SEGUIRA SACANDO FICHAS SIEMPRE Y CUANDO
                 * EL JUGADOR TAMBIEN LO HAGA SI EL SE QUEDA 
                 * LA COMPUTADORA TAMBIEN 
                 */
               }if(decisivo1 == 1){  
                 System.out.println("COMPUTADORA PIDIO OTRA CARTA----");
                 System.out.println("--SIGUIENTE CARTA DE COMPUTADORA--");
                 sacada2 = baraja.primeraCarta();
                 puntosPlay4 += baraja.ValorPuntoPorCarta(sacada2);
                 System.out.println("Carta :");
                 System.out.println(sacada2);
                 System.out.println("Puntos COMPUTADORA:");
                 System.out.println(puntosPlay4);
                 if(puntosPlay4 >= 21){
                    decisivo1 = 2;
                    }
                  }            
               }while(decisivo1 == 1);
               int resPlayOne = 21 - puntosPlay3; 
               int resCompu = 21 - puntosPlay4;
               if(puntosPlay3 ==21){  // CONDICIONAL CON LOS PUNTOS PARA MARCAR A EL GANADOR
                System.out.println("----------------------------------------");
                System.out.println("Felicidades !!!"+" " + play1.getAlias());
                System.out.println("La computadora perdio");
                System.out.println("----------------------------------------");
                play1.ganador(); 
                play1.sumarPuntos(10);
                empates = false;
               }else if(puntosPlay4 == 21){
                System.out.println("----------------------------------------");
                System.out.println("    La computadora Gano !!!!");
                System.out.println("    Perdiste " +" "+ play1.getAlias());
                System.out.println("----------------------------------------");
                play1.perder(); 
                empates = false;
               }else if(puntosPlay3 > 21){
                 System.out.println("----------------------------------------");
                 System.out.println("    La computadora Gano !!!!");
                 System.out.println("   Perdiste " +" "+ play1.getAlias());
                 System.out.println("----------------------------------------");
                 play1.perder(); 
                 empates = false;
               }else if(puntosPlay4 > 21){
                 empates = false;
                 play1.ganador();
                 System.out.println("----------------------------------------");
                 System.out.println("Felicidades !!!"+" " + play1.getAlias());
                 System.out.println("Has ganado 10 puntos");
                 System.out.println("La computadora perdio");
                 System.out.println("----------------------------------------");
                 play1.sumarPuntos(10);
               }else if(resPlayOne > resCompu){
                 System.out.println("----------------------------------------");
                 System.out.println("       La computadora Gano              ");
                 System.out.println("   Perdiste " +" "+ play1.getAlias()     );
                 System.out.println("----------------------------------------");
                 play1.perder(); 
                 empates = false;
               }else if(resCompu > resPlayOne){
                 empates = false;
                 play1.ganador();
                 System.out.println("----------------------------------------");
                 System.out.println("Felicidades !!!"+" " + play1.getAlias());
                 System.out.println("Has ganado 10 puntos");
                 System.out.println("La computadora perdio");
                 System.out.println("----------------------------------------");
                 play1.sumarPuntos(10);
               }else if(puntosPlay3 == puntosPlay4 && intentos == 0){
                 empates = true;
                 System.out.println("----------------------------------------");
                 System.out.println("Los jugadores quedaron empates");
                 System.out.println("Es necesario que se juegue otra ronda");
                 System.out.println("----------------------------------------");
                 intentos ++;
               }else if(puntosPlay3 == puntosPlay4 && intentos > 0){
                 empates = false;
                 play1.ganador();
                 System.out.println("--------------------------------------------");
                 System.out.println("EMPATE DE NUEVO");
                 System.out.println("OBTENDRAS 5 PUNTOS");
                 System.out.println("Felicidades !!!"+" " + play1.getAlias());
                 System.out.println("--------------------------------------------");
                 play1.sumarPuntos(5);
               }

             }
             for(int j = 0; j< lista.length; j++){
              if(lista[j].getClave() == p1){
               lista[j] = play1;
               break;
             }    //GUARDA EL ESTADO DE LOS JUGADORES EN EL ARREGLO SERIALIZABLE
           }
           jk.escribirObjetosArchivos("Jugador.txt", lista); 
         }else{
           System.out.println("Ese no es tu compañero");
         }    
 /////////////////////////////Termina 1 JUGADOR /////////////////////    
       }else if( arreglo.length < 1 ){
        System.out.println("Se requiere por lo menos un jugador");
      }else if( arreglo.length > 2){
        System.out.println("Solo pueden Jugar a lo mas DOS Jugadores");

      }
    }
  }