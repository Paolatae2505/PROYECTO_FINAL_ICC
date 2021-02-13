import java.util.Scanner;
import java.util.InputMismatchException;
/**
* JUEGO CONECTA CUATRO
* @author Vargas Bravo Paola
* @version 1
*/
public class JuegoConectaCuatro{
    /**
     * True si la computadora esta jugando y False si no es asi
     * @param compuJuega --Variable del estado de la Computadora
     * @return -- True or False
     */
    public static boolean compuEstaJugando(boolean compuJuega){
        if(compuJuega == true){
            return true;
        }else{
           return false;
        }
    }
    /**
     * Random de numeros
     * @param max
     * @return numero aleatorio
     */
    public static int random(int max){
        return (int) Math.round(Math.random() * max + 0.5);
    }
    /**
     * Mezcla un arreglo de numeros
     * @param numeros arreglo
     * @return Arreglo de numeros
     */
    public static int []  mixes(int [] numeros){
        int [] nuevo = new int [numeros.length];
        for (int i = 0; i < numeros.length ;i ++ ) {
            int regresa = random(numeros.length-1);
            int numerito = numeros[regresa];
            numeros[regresa] = numeros[i];
            numeros[i] = numerito;
            
        }
        nuevo = numeros;
        return nuevo;
    } //////////////CONTADOR EN 0   /////////////////////
    /**
     * Toma el primer elemento de un arreglo de numeros
     * @param numeros --Arreglo de numeros
     * @param contador -- contador
     * @return --- el numero en la posicion cero
     */
    public static int primerNumero(int [] numeros, int contador){
        int numero = numeros[contador];
        return numero;     
    }

    public static void main(String[] arreglo) {
        Scanner on = new Scanner(System.in);
        Jugador [] listaPlayers;
        UtilidadJugador hobbi = new UtilidadJugador();
        listaPlayers = hobbi.leerObjetosLibros("Jugador.txt");
        Lista listaP = new Lista(listaPlayers);
        String  p1, p2;
        Jugador play1;
        Jugador play2;
        boolean compuJuega = true;
        boolean empates = true;
        int ganado = 0;
        String fichaRoja = "R";
        String fichaAzul = "B";
        int puntosR = 0;
        int puntosB = 0;
        int puntosE = 0;
        int columna = 0;
        int puntosE1 = 0;
        int puntosR1 = 0;
        int puntosB1 = 0;
        int columna1 = 0;
        int intento = 0;
        int contar = 0;
        int [] numeros = {1,2,3,4};
        int [] numbers ;
        String compuClave = "Computadora";
        boolean estaLlena = true;
        String allKill;
        String allKill2;
        ConectaCuatro juego = new ConectaCuatro();
        ConectaCuatro juego2 = new ConectaCuatro();
        if(arreglo.length == 2){
            p1 = arreglo[0];
            p2= arreglo[1];
            play1 = listaP.getJugadorPorString(p1);
            play2 = listaP.getJugadorPorString(p2);
            if(play1.getContrincante().equals(play2.getClave())){// VERFIFICA QUE SEA EL CONTRINCANTE
                System.out.println("-----BIENVENIDOS AL JUEGO CONECTA CUATRO---");
                System.out.println("-----INSTRUCCIONES DEL JUEGO :-------------");
                System.out.println("---GANA QUIEN CONECTE CUATRO FICHAS--------");
                System.out.println("---DE MANERA :-----------------------------");
                System.out.println("---VERICAL, HORIZONTAL O DIAGONAL----------");
                System.out.println("EN CASO DE QUEDAR EMPATE SE DARA OTRA RONDA");
                System.out.println("---SI SE REPITE EL CASO DE NUEVO-----------");
                System.out.println("---SE GANA LA MITAD DE PUNTOS--------------");
                System.out.println("----------------");
                System.out.println("--------------¡¡ÉXITO!!!-------------------");
                System.out.println("NOMBRE : "+ play1.getNombre());
                System.out.println("ALIAS  : " + play1.getAlias());;
                System.out.println("VS");
                System.out.println("NOMBRE : "+ play2.getNombre());
                System.out.println("ALIAS  : " + play2.getAlias());;
                System.out.println("SUERTE !!!!");
                System.out.println("----------------------------------------");
                System.out.println("------------- QUE PIERDA ---------------");
                System.out.println("-------------  EL RIVAL  ---------------");
                System.out.println("------------- MAS DÉBIL ----------------");
                System.out.println("----------------------------------------");
                /**
                 * SI LA PARTIDA SE REPITE SE CREA UN NUEVO JUEGO ES POR ELLO 
                 * QUE DEPENDE DE LAS VARIABLES DE INTENTOS SEA DISTINTA DE 0
                 * YA QUE ESTA SE CONSIDERSA UN INTENTO DIFERENTE
                 */
                while(empates == true){  // AMBOS QUEDEN EMPATES SE REPITE 
                play1.jugar();                /// NUEVA PARTIDA
                play2.jugar();
                System.out.println("----------------------------------");
                System.out.println("--------EL JUEGO COMIENZA---------");
                System.out.println("----------------------------------");
                
                while(ganado == 0){ /// SE REPITA EL CICLO DE SACAR FICHA
                    if(play1.estaJugando() == true){
                        System.out.println("----------------------------------");
                        System.out.println("FICHA : " + fichaRoja);
                        System.out.println("TURNO TIRAR FICHA DE :" + play1.getAlias());
                        System.out.println("----------------------------------");
                        int contador = 0;
                        if(intento == 0){
                            do{ /// EN EL CASO DE QUE LA COLUMNA ESTE LLENA
                                System.out.println(juego);
                                System.out.println("COLUMNA");
                                while(!on.hasNextInt()){
                                    System.out.println("<Da un Numero >");
                                    on.nextLine();
                                    }     
                                        columna = on.nextInt();    
                                try{
                                estaLlena = juego.columnaLLena(columna);
                                }catch(IndexOutOfBoundsException e){
                                    System.out.println("Tu numero se sale del Tablero");
                                    System.out.println("Pierdes tu Turno");
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                }while(estaLlena == false);
                                juego.colocarFicha(fichaRoja, columna);
                        }else if(intento > 0){  /// PARA EL JUEGO 2 EN CASO DE EMPATE
                            do{ /// EN EL CASO DE QUE LA COLUMNA ESTE LLENA
                            System.out.println(juego2);
                            System.out.println("COLUMNA"); 
                            while(!on.hasNextInt()){
                                System.out.println("<Da un Numero >");
                                on.nextLine();
                                }   
                            columna = on.nextInt();
                            try{
                            estaLlena = juego2.columnaLLena(columna);
        
                            }catch(IndexOutOfBoundsException  e){
                                System.out.println("Tu numero se sale del Tablero");
                                System.out.println("Pierdes tu Turno");
                                System.out.println(e);
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            }while(estaLlena == false);
    
                            juego2.colocarFicha(fichaRoja, columna);

                        }  
                    }else{
                        System.out.println(play1.getAlias()+ " "+ "OFF!!!!");
                    }

///////////////////////////////////////////////////////////////////
//////////////////VE SI SE CUMPLE UN CONECTA 4 (ALLKILL4) EL JUGADOR 1///////////////
                    if(intento == 0){
                    allKill = juego.allkill4X4();
                    if(allKill.equals("R")){
                    puntosR = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill.equals("B")){
                    puntosB = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill.equals("EMPATE")){
                    puntosE = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill.equals("NINGUNO")){
                    ganado = 0;
                    play1.jugar();
                    play2.jugar();
        
                     }
                    } else if(intento == 1){
                    allKill2 = juego2.allkill4X4();
                    if(allKill2.equals("R")){
                    puntosR1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill2.equals("B")){
                    puntosB1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill2.equals("EMPATE")){
                    puntosE1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    play2.terminarJugar();
                    }else if(allKill2.equals("NINGUNO")){
                     ganado = 0;
                     play1.jugar();
                    play2.jugar();
                    }

                    }

                    ////////COLOCAR FICHA JUGADOR 2///////////
                    ////////////////////////////////////////////////
                    if(play2.estaJugando() == true){
                        System.out.println("----------------------------------");
                        System.out.println("FICHA : " + fichaAzul);
                        System.out.println("TURNO TIRAR FICHA DE :" + play2.getAlias());
                        System.out.println("----------------------------------");
                        if(intento == 0){
                            do{ /// EN EL CASO DE QUE LA COLUMNA ESTE LLENA
                                System.out.println(juego);
                                System.out.println("COLUMNA");
                                while(!on.hasNextInt()){
                                    System.out.println("<Da un Numero >");
                                    on.nextLine();
                                    }  
                                columna1 = on.nextInt();
                                try{
                                estaLlena = juego.columnaLLena(columna1);
        
                                }catch(IndexOutOfBoundsException  e){
                                    System.out.println("Tu numero se sale del Tablero");
                                    System.out.println("Pierdes tu Turno");
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                }while(estaLlena == false);
                                juego.colocarFicha(fichaAzul, columna1);

                        }else if(intento > 0){ /// PARA EL JUEGO 2 EN CASO DE EMPATE
                            do{
                                System.out.println(juego2);
                                System.out.println("COLUMNA");
                                while(!on.hasNextInt()){
                                    System.out.println("<Da un Numero >");
                                    on.nextLine();
                                    }  
                                columna1 = on.nextInt();
                                try{
                                estaLlena = juego2.columnaLLena(columna1);
                                }catch(IndexOutOfBoundsException e){
                                    System.out.println("Tu numero se sale del Tablero");
                                    System.out.println("Pierdes tu Turno");
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                }while(estaLlena == false);
                                juego2.colocarFicha(fichaAzul, columna1);
                            }
                    }else{
                        System.out.println(play2.getAlias()+ " "+ "OFF!!!!");

                    }    
                    //////VERIFICA QUE SE CUMPLA UN ALLKILL 4 JUGADOR 2////////
                    if(intento == 0){
                        allKill = juego.allkill4X4();
                        if(allKill.equals("R")){
                            puntosR = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            play2.terminarJugar();
                        }else if(allKill.equals("B")){
                            puntosB = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            play2.terminarJugar();
                        }else if(allKill.equals("EMPATE")){
                             puntosE = 10;
                             ganado = 1;
                             play1.terminarJugar();
                             play2.terminarJugar();
                        }else if(allKill.equals("NINGUNO")){
                            ganado = 0;
                            play1.jugar();
                            play2.jugar();
                        }
                    }else if(intento == 1){
                        allKill2 = juego2.allkill4X4();
                        if(allKill2.equals("R")){
                            puntosR1 = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            play2.terminarJugar();
                        }else if(allKill2.equals("B")){
                            puntosB1 = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            play2.terminarJugar();
                        }else if(allKill2.equals("EMPATE")){
                             puntosE1 = 10;
                             ganado = 1;
                             play1.terminarJugar();
                             play2.terminarJugar();
                        }else if(allKill2.equals("NINGUNO")){
                            ganado = 0;
                            play1.jugar();
                            play2.jugar();
                        }

                    }
                        

                } ////////////WHILE OK ///////////////
                /**
                 * EVALUA EL GANADOR O PERDEDRO CON TODAS LAS POSIBILIDADES POSIBLES
                 * Y ESTE DEPENDE DE LOS INTENTOS SI NO SON 0 ENTONCES SE REPITIO LA
                 * PARTIDA 
                 */
                if(puntosR == 10 && puntosB == 0 & puntosE == 0 && intento == 0){ 
                        empates = false;
                        play1.ganador();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play2.getAlias());
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                }else if(puntosR == 0 && puntosB == 10 & puntosE == 0 && intento == 0 ){
                    empates = false;
                    play1.perder();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    play2.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }else if(puntosR == 0 && puntosB == 0 & puntosE == 10 && intento == 0){
                   empates = true;
                   System.out.println("--------------------------------------------");
                   System.out.println("Los jugadores quedaron empates");
                   System.out.println("Es necesario que se juegue otra ronda");
                   System.out.println("--------------------------------------------");
                   intento ++;
                   ganado = 0;
                }else if(puntosR1 == 0 && puntosB1 == 0 & puntosE1 == 10 && intento == 1){
                    empates = false;
                    play1.ganador();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println("EMPATE DE NUEVO");
                    System.out.println("CADA UNO GANA 5 PUNTOS");
                    System.out.println(" FELICIDADES A AMBOS !!!!");
                    System.out.println("--------------------------------------------");
                    play1.sumarPuntos(5);
                    play2.sumarPuntos(5);

                }else if(puntosR1 == 10 && puntosB1 == 0 & puntosE1 == 0 && intento == 1){
                    empates = false;
                    play1.ganador();
                    play2.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play2.getAlias());
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");

                }else if(puntosR1 == 0 && puntosB1 == 10 & puntosE1 == 0 && intento == 1){
                    empates = false;
                    play1.perder();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    play2.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }

                }
                for(int j = 0; j< listaPlayers.length; j++){
                    if(listaPlayers[j].getClave() == p1){
                       listaPlayers[j] = play1;
                    }else if(listaPlayers[j].getClave()== p2){
                         listaPlayers[j] = play2;   ////////GUARDA LA INFO PARA QUE LA SERIALIZE
                    }
               }
                hobbi.escribirObjetosArchivos("Jugador.txt",listaPlayers); 


            }else{
               System.out.println("Ese no es tu compañero");
            }
          /////////////////////////////Termina  2 JUGADORES  /////////////////////
        /////////////////////////////Empieza  1 JUGADOR /////////////////////
            /**
             *  EN EL CASO DE JUGADOR 1 ES UN PARECIDO A DOS JUGADORES
             * SALVO UNOS DETALLES QUE ES COMO SE MANEJA LA COMPUTADORA
             */
        }else if(arreglo.length == 1){
            p1 = arreglo[0];
            play1 = listaP.getJugadorPorString(p1);
            if(play1.getContrincante().equals(compuClave)){
            System.out.println("-----BIENVENIDOS AL JUEGO CONECTA CUATRO---");
            System.out.println("-----INSTRUCCIONES DEL JUEGO :-------------");
            System.out.println("---GANA QUIEN CONECTE CUATRO FICHAS--------");
            System.out.println("---DE MANERA :-----------------------------");
            System.out.println("---VERICAL, HORIZONTAL O DIAGONAL----------");
            System.out.println("EN CASO DE QUEDAR EMPATE SE DARA OTRA RONDA");
            System.out.println("---SI SE REPITE EL CASO DE NUEVO-----------");
            System.out.println("---SE GANA LA MITAD DE PUNTOS--------------");
            System.out.println("--------------¡¡ÉXITO!!!-------------------");
            System.out.println("NOMBRE : "+ play1.getNombre());
            System.out.println("ALIAS  : "+ play1.getAlias());;
            System.out.println("VS");
            System.out.println("COMPUTADORA");
            System.out.println("SUERTE !!!!");
            System.out.println("----------------------------------------");
            System.out.println("------------- QUE PIERDA ---------------");
            System.out.println("-------------  EL RIVAL  ---------------");
            System.out.println("-------------  MAS DEBIL ---------------");
            System.out.println("----------------------------------------");
            while(empates == true){
                play1.jugar();
                System.out.println("----------------------------------");
                System.out.println("--------EL JUEGO COMIENZA---------");
                System.out.println("----------------------------------");
                
                while(ganado == 0){ /// CICLO PARA TIRAR FICHA
                    if(play1.estaJugando() == true){
                        System.out.println("----------------------------------");
                        System.out.println("FICHA : " + fichaRoja);
                        System.out.println("TURNO TIRAR FICHA DE :" + play1.getAlias());
                        System.out.println("----------------------------------");
                        int contador = 0;
                        if(intento == 0){
                            do{
                                System.out.println(juego);
                                System.out.println("COLUMNA");
                                while(!on.hasNextInt()){
                                    System.out.println("<Da un Numero >");
                                    on.nextLine();
                                    }  
                                columna = on.nextInt();
                                try{
                                estaLlena = juego.columnaLLena(columna);
                              
                                }catch(IndexOutOfBoundsException  e){
                                    System.out.println("Tu numero se sale del Tablero");
                                    System.out.println("Pierdes tu Turno");
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                               
                                }while(estaLlena == false);
        
                                juego.colocarFicha(fichaRoja, columna);

                        }else if(intento > 0){  //NUEVO JUEGO
                            do{
                            System.out.println(juego2);
                            System.out.println("COLUMNA");
                            while(!on.hasNextInt()){
                                System.out.println("<Da un Numero >");
                                on.nextLine();
                                }  
                            columna = on.nextInt();
                            try{
                            estaLlena = juego2.columnaLLena(columna);
        
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Tu numero se sale del Tablero");
                                System.out.println("Pierdes tu Turno");
                                System.out.println(e);
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            }while(estaLlena == false);
    
                            juego2.colocarFicha(fichaRoja, columna);

                        }  
                    }else{
                        System.out.println(play1.getAlias()+ " "+ "OFF!!!!");
                    }

////////////////////////////////COMPUTADORA /////////////////////////////////////////
/////////////////////////EVALUA UN ALLKILL 4 //////////////
                    if(intento == 0){
                    allKill = juego.allkill4X4();
                    if(allKill.equals("R")){
                    puntosR = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill.equals("B")){
                    puntosB = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill.equals("EMPATE")){
                    puntosE = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill.equals("NINGUNO")){
                    ganado = 0;
                    play1.jugar();
                    compuJuega = true;
                    }
                    }else if(intento == 1){
                    allKill2 = juego2.allkill4X4();
                    if(allKill2.equals("R")){
                    puntosR1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill2.equals("B")){
                    puntosB1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill2.equals("EMPATE")){
                    puntosE1 = 10;
                    ganado = 1;
                    play1.terminarJugar();
                    compuJuega = false;
                    }else if(allKill2.equals("NINGUNO")){
                     ganado = 0;
                    play1.jugar();
                    compuJuega = true;
                    }

                }
                /**
                 * LA COMPUTADORA TIRARA FICHAS AL AZAR SIN FIJARSE POR LO QUE 
                 * ES MAS DE AZAR EL HECHO DE QUE EL JUGADOR PIERDA A GANE
                 */
                    if(compuEstaJugando(compuJuega) == true){ 
                        System.out.println("----------------------------------");
                        System.out.println("FICHA : " + fichaAzul);
                        System.out.println("TURNO TIRAR FICHA DE : COMPUTADORA" );
                        System.out.println("----------------------------------");
                        if(intento == 0){
                            do{
                                numbers = mixes(numeros);  //// METODO PARA ELEGIR NUMERO AL AZAR
                                columna1 = primerNumero(numbers, contar);

                                System.out.println(juego);
                                
                                try{
                                estaLlena = juego.columnaLLena(columna1);
        
                                }catch(IndexOutOfBoundsException  e ){
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                }while(estaLlena == false);
                                juego.colocarFicha(fichaAzul, columna1);

                        }else if(intento > 0){
                            do{
                                numbers = mixes(numeros);
                                columna1 = primerNumero(numbers, contar);
                                try{
                                estaLlena = juego2.columnaLLena(columna1);
                                }catch(IndexOutOfBoundsException  e){
                                    System.out.println(e);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                }while(estaLlena == false);
                                juego2.colocarFicha(fichaAzul, columna1);
                            }
                    }else{
                        System.out.println("COMPUTADORA"+ " "+ "OFF!!!!");

                    } 
    ////////////////////////////////COMPUTADORA /////////////////////////////////////////   
    ////EVALUA UN ALL KILL 4 ///////////////
                    if(intento == 0){
                        allKill = juego.allkill4X4();
                        if(allKill.equals("R")){
                            puntosR = 10;
                            ganado = 1;
                            play1.terminarJugar();
                           compuJuega = false;
                        }else if(allKill.equals("B")){
                            puntosB = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            compuJuega = false;
                        }else if(allKill.equals("EMPATE")){
                             puntosE = 10;
                             ganado = 1;
                             play1.terminarJugar();
                             compuJuega = false;
                        }else if(allKill.equals("NINGUNO")){
                            ganado = 0;
                            play1.jugar();
                            compuJuega = true;
                        }
                    }else if(intento == 1){
                        allKill2 = juego2.allkill4X4();
                        if(allKill2.equals("R")){
                            puntosR1 = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            compuJuega = false;
                        }else if(allKill2.equals("B")){
                            puntosB1 = 10;
                            ganado = 1;
                            play1.terminarJugar();
                            compuJuega = false;
                        }else if(allKill2.equals("EMPATE")){
                             puntosE1 = 10;
                             ganado = 1;
                             play1.terminarJugar();
                             compuJuega = false;
                        }else if(allKill2.equals("NINGUNO")){
                            ganado = 0;
                            play1.jugar();
                            compuJuega = true;
                        }

                    }
                        

                } ////////////WHILE OK ///////////////
                ///EVALUA  A EL GANADOR O PERDEDOR///////////
                if(puntosR == 10 && puntosB == 0 & puntosE == 0 && intento == 0){
                        empates = false;
                        play1.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" PERDIO LA COMPUTADORA");
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                }else if(puntosR == 0 && puntosB == 10 & puntosE == 0 && intento == 0 ){
                    empates = false;
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" GANO LA COMPUTADORA !!!");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                }else if(puntosR == 0 && puntosB == 0 & puntosE == 10 && intento == 0){
                   empates = true;
                   System.out.println("--------------------------------------------");
                   System.out.println("Los jugadores quedaron empates");
                   System.out.println("Es necesario que se juegue otra ronda");
                   System.out.println("--------------------------------------------");
                   intento ++;
                   ganado = 0;
                }else if(puntosR1 == 0 && puntosB1 == 0 & puntosE1 == 10 && intento == 1){
                    empates = false;
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println("EMPATE DE NUEVO");
                    System.out.println("GANAS 5 PUNTOS");
                    System.out.println(" FELICIDADES !!!!");
                    System.out.println("--------------------------------------------");
                    play1.sumarPuntos(5);

                }else if(puntosR1 == 10 && puntosB1 == 0 & puntosE1 == 0 && intento == 1){
                    empates = false;
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdio LA COMPUTADORA");
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");

                }else if(puntosR1 == 0 && puntosB1 == 10 & puntosE1 == 0 && intento == 1){
                    empates = false;
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" GANO LA COMPUTADORA!!!");
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                }

                }

                for(int j = 0; j< listaPlayers.length; j++){
                    if(listaPlayers[j].getClave() == p1){
                       listaPlayers[j] = play1;
                       break;   /// GUARDA INFO PARA SERIALIZARLA
                    }
               }
               hobbi.escribirObjetosArchivos("Jugador.txt", listaPlayers);
            
            }else{
                System.out.println("Ese no es tu Compañero"); 
            }
        }else if(arreglo.length < 1){
            System.out.println("Se requiere por lo menos un jugador");

        }else if(arreglo.length > 2){
            System.out.println("Solo pueden Jugar a lo mas DOS Jugadores");

        }
        
    }
}