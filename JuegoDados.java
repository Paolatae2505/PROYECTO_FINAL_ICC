/**
* EJECUTABLE JUEGO DADOS
* @author Vargas Bravo Paola
* @version 1
*/
public class JuegoDados{
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
    public static void main(String[] arreglo) {
        String p1 ,p2;
        Jugador [] listaJugadores;
        UtilidadJugador nam = new UtilidadJugador();
        listaJugadores = nam.leerObjetosLibros("Jugador.txt");
        Lista listaP = new Lista(listaJugadores);
        Jugador play1;
        Jugador play2;
        boolean empates = true;
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int puntosPlay1 = 0;
        int  puntosPlay2 = 0;
        int puntosPlay1_1= 0;
        int  puntosPlay2_2= 0;
        int caraUno =0;
        int caraDos = 0;
        int decisivo1  = 0;
        int decisivo2  = 1;
        int intentos = 0;
        int intentos1 = 0;
        //////////////////////////////COMPU ///////////////////
        int decisivo1_1  = 0;
        int decisivo2_2  = 1;
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        int puntosJugador1_1 = 0;
        int puntosJugador2_2 = 0;
        String compuClave = "Computadora";
        int inte = 0;
        int inte1 = 0;
        boolean together = true;
        boolean together2 = true;
        boolean compuJuega = true;
        if(arreglo.length == 2){
         p1 = arreglo[0];
         p2 = arreglo[1];
            play1 = listaP.getJugadorPorString(p1);
            play2 = listaP.getJugadorPorString(p2);        
         if(play1.getContrincante().equals(play2.getClave())){ // VERFIFICA QUE SEA EL CONTRINCANTE
            System.out.println("-----BIENVENIDOS AL JUEGO DE DADOS ----");
            System.out.println("-----INSTRUCCIONES DEL JUEGO :----------");
            System.out.println("-----GANAS : 7 O 11           ----------");
            System.out.println("-----PIERDES : 2,3 O 12       ----------");
            System.out.println("-----VUELVES A LANZAR : 4,5,6,8,9,10----");
            System.out.println("-OJO SI VULEVES A LANZAR GANAS SI SACAS-");
            System.out.println("-LA PUNTUACION ANTERIOR DE LOS CONTRARIO");
            System.out.println("-PIERDES                       ---------");
            System.out.println("----EMPATE : AMBOS JUGADORES OBTIENEN---");
            System.out.println("----11 O 7 SE VOLVERA A JUGAR HASTA QUE-");
            System.out.println("------UNO DE LOS DOS GANE, PIERDA-------");
            System.out.println("RECUERDA QUE AMBOS PUEDEN PERDER PERO NO");
            System.out.println("                 GANAR                  ");
            System.out.println("--------------¡¡¡ÉXITO!!!---------------");
            System.out.println("NOMBRE : "+ play1.getNombre());
            System.out.println("ALIAS  : " + play1.getAlias());;
            System.out.println("VS");
            System.out.println("NOMBRE : "+ play2.getNombre());
            System.out.println("ALIAS  : " + play2.getAlias());;
            System.out.println("SUERTE !!!!");
            System.out.println("----------------------------------------");
            System.out.println("------------- QUE PIERDA ---------------");
            System.out.println("-------------  EL RIVAL  ---------------");
            System.out.println("-------------  MAS DÉBIL ---------------");
            System.out.println("----------------------------------------");
            /**
             * WHILE SOLO PARA CUANDO AMBOS GANAN SE REPITE TODA LA PARTIDA
             * PERO EL CASO DE QUE AMBOS VUELVAN A TIRAR SE REPITE EL DO
             * Y NO EL WHILE YA QUE DE ELLOS EL GANAR DEPENDE DE SU PUNTUACION 
             * PASADA, EN CONCLUSION DE MANEJAN DIFERENTE
             */
            while(empates == true){ //EN CASO DE AMBOS GANAR ES EMPATE 
                intentos = 0;
                intentos1 = 0;
                play1.jugar();
                play2.jugar();
                puntosPlay1 = 0;
                puntosPlay2 = 0;
                System.out.println("----------------------------------");
                System.out.println("--------EL JUEGO COMIENZA---------");
                System.out.println("----------------------------------");
                do{    ///////TIRA DADOS  EL JUGADOR1//////7
                System.out.println("----------------------------------");
                System.out.println("TURNO TIRAR DADOS DE :" + play1.getAlias());
                System.out.println("----------------------------------");
                if(play1.estaJugando() == true){
                    dado1.lanzar();
                    dado2.lanzar();
                    caraUno = dado1.caraArriba();
                    caraDos = dado2.caraArriba();
                    System.out.println("CARA DADO 1 :"+ " " + caraUno);
                    System.out.println("CARA DADO 2 :"+ " " + caraDos);
                    puntosPlay1 = caraUno + caraDos;
                    System.out.println("PUNTOS :" + puntosPlay1 );
                    System.out.println("----------------------------------");
                }else{
                    System.out.println("Ya no puede tirar");
                    play1.terminarJugar();
                }
                if(play2.estaJugando() == true){
                    System.out.println("----------------------------------");
                    System.out.println("TURNO TIRAR DADOS DE :" + play2.getAlias());
                    System.out.println("----------------------------------");
                    dado1.lanzar();
                    dado2.lanzar();
                    caraUno = dado1.caraArriba();
                    caraDos = dado2.caraArriba();
                    System.out.println("CARA DADO 1 :"+ " " + caraUno);
                    System.out.println("CARA DADO 2 :"+ " " + caraDos);
                    puntosPlay2 = caraUno + caraDos;
                    System.out.println("PUNTOS :" + puntosPlay2 );
                    System.out.println("----------------------------------");
                }else{
                    System.out.println("Ya no puede tirar");
                    play2.terminarJugar();
                }
                /**
                 *DIVIDIDO EN INTENTOS 0 E INTENTOS 1 ESTO ES POR QUE 
                 * SI EL JUAGDOR VUELVE A TIRAR LA MANERA DE MANEJAR EL JUEGO
                 * ES DISTINTA 
                 */
                if(intentos == 0 && intentos1 == 0 ){
                    if(puntosPlay1 == 4 || puntosPlay1 == 5 || puntosPlay1 == 6 ){
                        decisivo1 = 1;
                        play1.jugar();                                  
                    }else if(puntosPlay1 == 8 || puntosPlay1 == 9 || puntosPlay1 == 10){
                        decisivo1 = 1;
                        play1.jugar();
                    }else if(puntosPlay1 == 2 || puntosPlay1 == 3 || puntosPlay1 ==  12){
                        decisivo1 = 2;
                        play1.terminarJugar();
                    }else if(puntosPlay1 == 7  || puntosPlay1 ==  11){
                        decisivo1 = 2;
                        play1.terminarJugar();
                    }
                    if(puntosPlay2 == 4 || puntosPlay2 == 5 || puntosPlay2 == 6){
                            decisivo2 = 1;
                            play2.jugar();                                    
                    }else if(puntosPlay2 == 8 || puntosPlay2 == 9 || puntosPlay2 == 10){
                            decisivo2 = 1;
                            play2.jugar();                      
                    }else if(puntosPlay2 == 2 || puntosPlay2 == 3 || puntosPlay2 ==  12){
                        decisivo2 = 2;
                        play2.terminarJugar();
                    }else if(puntosPlay2 == 7  || puntosPlay2 ==  11){
                        decisivo2 = 2;
                        play2.terminarJugar();
                    }
                /**
                 * DEPENDE EL DECISIVO SE VE LA FORMA DE CONTINUAR
                 * CON 1 CONTINUA CON 2 TERMINA PERO LAS FORMAS DE TERMINAR 
                 * DE PENDEN SI ES POR QUE GANO UNO O PERDIO UNO O AMBOS
                 */
                    if(decisivo1 == 1 && decisivo2 == 2){
                        decisivo1 =25;
                        decisivo2 = 18;  ///////////////////////PRIMERA MANERA DE TERMINAR ////
                        play1.terminarJugar(); //////////O GANO O PERDIO EL PLAY 2/////////////
                        play2.terminarJugar();
    
                    }else if(decisivo1 == 2 && decisivo2 == 1){
                        decisivo1 =25;
                        decisivo2 = 18;  ///////////////////////SEGUNDA  MANERA DE TERMINAR ////
                        play1.terminarJugar(); //////////O GANO O PERDIO EL PLAY 1/////////////
                        play2.terminarJugar();
                       
                    }else if(decisivo2 == 2 && decisivo1 == 2){
                        decisivo1 =25;
                        decisivo2 = 18;  ////////TERCERA FORMA O AMBOS GANARON O AMBOS PERDIERON////
                        play1.terminarJugar(); //////////////// AMBOS GANARON /////////////
                        play2.terminarJugar();
                    }else if(decisivo2 == 1 && decisivo1 == 1){
                        decisivo1 = 1;
                        decisivo2 = 1;  //// AMBOS VULVEN A TIRAR LOS DADOS//////
                        intentos++;     /// SE AUMENTAN LOS INTENTOS YA QUE SE EVALUA DIFERENTE 
                        puntosPlay1_1 = puntosPlay1;
                        intentos1++;
                        puntosPlay2_2 = puntosPlay2;
                        play2.jugar();  
                        play1.jugar();     
                    }


                }else if(intentos == 1 && intentos1 == 1 ){
                    if(puntosPlay1 == puntosPlay1_1){   // EVALUA SI LOS PUNTOS DE LA PARTIDA NUEVA SON 
                         together = true;               // LOS MISMOS A LA PASADA
                    }else if(puntosPlay1 != puntosPlay1_1){
                         together = false;
                    }

                    if(puntosPlay2 == puntosPlay2_2){
                         together2 = true;
                    }else if(puntosPlay2 != puntosPlay2_2){
                     together2 = false;
                    }
                    decisivo1 =25;
                    decisivo2 = 18;
                }          
                }while(decisivo1 == decisivo2); //CICLO PARA REPETIR PARTIDA EN CASO DE SER NECESARIO

                if(intentos == 0 && intentos1 == 0 ){
                 /**
                  * SE EVALUAN LOS PUNTOS DE CAUERDO A LA PUNTUACION 
                  * CON TODOS LOS CASOS POSIBLES A SACAR EN EL CASO 
                  * DE QUE LOS INTENTOS SEAN 0 SI NO SOLO DEPENDE
                  * DE LA PUNTUACION ANTERIOR
                  */
                    if((puntosPlay1 == 7 || puntosPlay1 == 11) &&
                    (puntosPlay2 == 2 || puntosPlay2 == 3 || puntosPlay2 == 12) ){
                        empates = false;  
                        play1.ganador();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play2.getAlias());
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else if( (puntosPlay1 == 2 || puntosPlay1 == 3 || puntosPlay1 == 12)&&
                    (puntosPlay2 == 7 || puntosPlay2 == 11)){
                        empates = false;     
                        play2.ganador();
                        play1.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play1.getAlias());
                        play2.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else if((puntosPlay1 == 7 || puntosPlay1 == 11) &&
                    (puntosPlay2 == 7 || puntosPlay2 == 11)){
                        empates = true;
                        System.out.println("--------------------------------------------");
                        System.out.println("Los jugadores quedaron empates");
                        System.out.println("Es necesario que se juegue otra ronda");
                        System.out.println("--------------------------------------------");
                    }else  if((puntosPlay1 == 7 || puntosPlay1 == 11) && 
                    (puntosPlay2 == 4 || puntosPlay2 == 5 || puntosPlay2 == 6) ){
                        empates = false;  
                        play1.ganador();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play2.getAlias());
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                   }else if((puntosPlay1 == 7 || puntosPlay1 == 11) && 
                   (puntosPlay2 == 8 ||  puntosPlay2 == 9 || puntosPlay2 == 10 ) ){
                        empates = false;  
                        play1.ganador();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play2.getAlias());
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else  if((puntosPlay1 == 4 || puntosPlay1 == 5 || puntosPlay1 == 6) && 
                    (puntosPlay2 == 7 || puntosPlay2 == 11)){
                        empates = false;      
                        play1.perder();
                        play2.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play1.getAlias());
                        System.out.println("--------------------------------------------");
                        play2.sumarPuntos(10);
                }else if(( puntosPlay1 == 8 || puntosPlay1 == 9 || puntosPlay1 == 10 ) && 
                (puntosPlay2 == 7 || puntosPlay2 == 11)){ 
                    empates = false;      
                    play1.perder();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                    play2.sumarPuntos(10);
                }else if((puntosPlay1 == 2 || puntosPlay1 == 3 || puntosPlay1 == 12) &&
                (puntosPlay2 == 4 || puntosPlay2 == 5 || puntosPlay2 == 6)){
                    empates = false;      
                    play1.perder();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                    play2.sumarPuntos(10);
                }else if((puntosPlay1 == 2 || puntosPlay1 == 3 || puntosPlay1 == 12) &&
                (puntosPlay2 == 8 ||  puntosPlay2 == 9 || puntosPlay2 == 10 ) ){
                    empates = false;      
                    play1.perder();
                    play2.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                    play2.sumarPuntos(10);
                }else if((puntosPlay1 == 4 || puntosPlay1 == 5 || puntosPlay1 == 6)&&
                (puntosPlay2 == 2 || puntosPlay2 == 3 || puntosPlay2 == 12)){
                    empates = false;  
                    play1.ganador();
                    play2.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play2.getAlias());
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }else if( (puntosPlay1 == 8 ||  puntosPlay1 == 9 || puntosPlay1 == 10 ) &&
                (puntosPlay2 == 2 || puntosPlay2 == 3 || puntosPlay2 == 12) ){
                    empates = false;  
                    play1.ganador();
                    play2.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste " + " "+ play2.getAlias());
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }else if((puntosPlay1 == 2 || puntosPlay1 == 3 || puntosPlay1 == 12) &&
                (puntosPlay2 == 2 || puntosPlay2 == 3 || puntosPlay2 == 12) ){
                    empates = false;
                    play1.perder();
                    play2.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println("AMBOS PERDIERON  ");
                    System.out.println(" OBTIENEN NINGUN PUNTO  ");
                    System.out.println("--------------------------------------------");
                }
                }else if(intentos == 1 && intentos1 == 1 ){ /// EVALUA EN CASO DE REPETIR PARTIDA
                    if(together == true && together2 == false ){  // LA PUNTUACION ANTERIOR
                        empates = false;
                        play1.ganador();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play2.getAlias());
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else if(together2 == true && together == false){
                        empates = false;
                        play2.ganador();
                        play1.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play2.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" Perdiste " + " "+ play1.getAlias());
                        play2.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else if(together2 == true && together == true){
                        empates = false;
                        play1.ganador();
                        play2.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println("AMBOS SACARON LA MISMA PUNTUACION QUE LA ");
                        System.out.println(" PARTIDA PASADA AMBOS GANAN 5 PUNTOS ");
                        System.out.println("--------------------------------------------");
                        play2.sumarPuntos(5);
                        play1.sumarPuntos(5);
                    }else if(together2 == false && together == false){
                        empates = false;
                        play1.perder();
                        play2.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" NINGUNO DE LOS DOS SACARON LA PUNTUACION  ");
                        System.out.println(" DE LA PARTIDA PASADA AMBOS OBTIENE  ");
                        System.out.println(" NINGUN PUNTO ");
                        System.out.println("--------------------------------------------");
                    }
                }
           
            }
            for(int j = 0; j< listaJugadores.length; j++){
                if(listaJugadores[j].getClave() == p1){
                   listaJugadores[j] = play1;        //GUARDA EL ESTADO DE LOS JUGADORES EN EL ARREGLO SERIALIZABLE
                }else if(listaJugadores[j].getClave()== p2){
                     listaJugadores[j] = play2;
                }
           }
            nam.escribirObjetosArchivos("Jugador.txt",listaJugadores ); 
         }else{
             System.out.println("Ese no es tu Compañero");
         }

         /////////////////////////////Termina  2 JUGADORES  /////////////////////
        /////////////////////////////Empieza  1 JUGADOR /////////////////////
     /**
      * CON 1 JUGADOR SE MANEJA PARECIDO A DOS JUGADORES 
      * EN ESTE CASO LA COMPUTADORA SE MANEJA IGUAL A UN JUGADOR
      */
        }else if(arreglo.length == 1){
            p1 = arreglo[0];
            play1 = listaP.getJugadorPorString(p1);
            if(play1.getContrincante().equals(compuClave)){
            System.out.println("-----BIENVENIDOS AL JUEGO DE DADOS ----");
            System.out.println("-----INSTRUCCIONES DEL JUEGO :----------");
            System.out.println("-----GANAS : 7 O 11           ----------");
            System.out.println("-----PIERDES : 2,3 O 12       ----------");
            System.out.println("-----VUELVES A LANZAR : 4,5,6,8,9,10----");
            System.out.println("-OJO SI VULEVES A LANZAR GANAS SI SACAS-");
            System.out.println("-LA PUNTUACION ANTERIOR DE LOS CONTRARIO");
            System.out.println("-PIERDES                       ---------");
            System.out.println("----EMPATE : AMBOS JUGADORES OBTIENEN---");
            System.out.println("----11 O 7 SE VOLVERA A JUGAR HASTA QUE-");
            System.out.println("------UNO DE LOS DOS GANE, PIERDA-------");
            System.out.println("RECUERDA QUE AMBOS PUEDEN PERDER PERO NO");
            System.out.println("                 GANAR                  ");
            System.out.println("--------------¡¡¡ÉXITO!!!---------------");
            System.out.println("NOMBRE : "+ play1.getNombre());
            System.out.println("ALIAS  : "+ play1.getAlias());;
            System.out.println("VS");
            System.out.println("COMPUTADORA");
            System.out.println("SUERTE !!!!");
            System.out.println("----------------------------------------");
            System.out.println("------------- QUE PIERDA ---------------");
            System.out.println("-------------  EL RIVAL  ---------------");
            System.out.println("-------------  MAS DÉBIL ---------------");
            System.out.println("----------------------------------------");
            while(empates == true){ // CICLO REPETIR EN CASO DE AMBOS GANAR
////////////////////////////////////////////CONTRA COMPUTADORA /////////////////////////////////////////
              inte = 0;
              inte1 = 0;
              play1.jugar();
              compuJuega = true;
              System.out.println("----------------------------------");
              System.out.println("--------EL JUEGO COMIENZA---------");
              System.out.println("----------------------------------");
              do{
                System.out.println("----------------------------------");
                System.out.println("TURNO TIRAR DADOS DE :" + play1.getAlias());
                System.out.println("----------------------------------");
                if(play1.estaJugando() == true){
                    dado1.lanzar();
                    dado2.lanzar();
                    caraUno = dado1.caraArriba();
                    caraDos = dado2.caraArriba();
                    System.out.println("CARA DADO 1 :"+ " " + caraUno);
                    System.out.println("CARA DADO 2 :"+ " " + caraDos);
                    puntosJugador1= caraUno + caraDos;
                    System.out.println("PUNTOS :" + puntosJugador1);
                    System.out.println("----------------------------------");
                }else{
                    System.out.println("Ya no puede tirar");
                    play1.terminarJugar();
                }
                if(compuEstaJugando(compuJuega) == true){
                    System.out.println("----------------------------------");
                    System.out.println("TURNO TIRAR DADOS DE : COMPUTADORA");
                    System.out.println("----------------------------------");
                    dado1.lanzar();
                    dado2.lanzar();
                    caraUno = dado1.caraArriba();
                    caraDos = dado2.caraArriba();
                    System.out.println("CARA DADO 1 :"+ " " + caraUno);
                    System.out.println("CARA DADO 2 :"+ " " + caraDos);
                    puntosJugador2 = caraUno + caraDos;
                    System.out.println("PUNTOS :" + puntosJugador2);
                    System.out.println("----------------------------------");
                }else{
                    System.out.println("Ya no puede tirar");
                    compuJuega = false;
                }
        
                if(inte == 0 && inte1 == 0  ){
                    if(puntosJugador1 == 4 | puntosJugador1== 5 || puntosJugador1 == 6 ){
                        decisivo1_1 = 1;
                        play1.jugar();   
                                
                    }else if(puntosJugador1 == 8 || puntosJugador1== 9 || puntosJugador1 == 10){
                            decisivo1_1 = 1;
                            play1.jugar();
                    }else if(puntosJugador1 == 2 || puntosJugador1 == 3 || puntosJugador1 ==  12){
                        decisivo1_1 = 2;
                        play1.terminarJugar();
                    }else if(puntosJugador1 == 7  || puntosJugador1 ==  11){
                        decisivo1_1 = 2;
                        play1.terminarJugar();
                    }

                    if(puntosJugador2 == 4 || puntosJugador2  == 5 || puntosJugador2 == 6){
                            decisivo2_2 = 1;
                           compuJuega = true;

                    }else if(puntosJugador2 == 8 || puntosJugador2 == 9 || puntosJugador2 == 10){
                            decisivo2_2  = 1;
                            compuJuega = true;                   
                    }else if(puntosJugador2 == 2 || puntosJugador2 == 3 || puntosJugador2 ==  12){
                        decisivo2_2  = 2;
                        compuJuega = false;

                    }else if(puntosJugador2 == 7  || puntosJugador2 ==  11){
                        decisivo2_2  = 2;
                        compuJuega = false;
                    }
    
                    if(decisivo1_1 == 1 && decisivo2_2 == 2){
                        decisivo1_1 =25;
                        decisivo2_2 = 18;  ///////////////////////PRIMERA MANERA DE TERMINAR ////
                        play1.terminarJugar(); //////////O GANO O PERDIO EL PLAY 2/////////////
                        compuJuega = false;

                    }else if(decisivo1_1 == 2 && decisivo2_2 == 1){
                        decisivo1_1 =25;
                        decisivo2_2 = 18;  ///////////////////////SEGUNDA  MANERA DE TERMINAR ////
                        play1.terminarJugar(); //////////O GANO O PERDIO EL PLAY 1/////////////
                        compuJuega = false;
                       
                    }else if(decisivo2_2 == 2 && decisivo1_1 == 2){
                        decisivo1_1 =25;
                        decisivo2_2 = 18; ///////////////////////TERCERA FORMA O AMBOS GANARON O AMBOS PERDIERON////
                        play1.terminarJugar(); //////////////// AMBOS GANARON /////////////
                        compuJuega = false;
                    }else if(decisivo2_2 == 1 && decisivo1_1 == 1){
                        inte ++;
                        inte1 ++;
                        puntosJugador1_1 = puntosJugador1;
                        puntosJugador2_2 = puntosJugador2;
                        compuJuega = true; 
                        play1.jugar();     
                    }

                }else if(inte  == 1 && inte1 == 1 ){
                    if(puntosJugador1 == puntosJugador1_1  ){
                         together = true;
                    }else if(puntosJugador1 !=  puntosJugador1_1 ){
                         together = false;
                    }

                     if(puntosJugador2 == puntosJugador2_2){
                         together2 = true;
                    }else if(puntosJugador2 != puntosJugador2_2 ){
                     together2 = false;
                    }

                    decisivo1_1 =25;
                    decisivo2_2 = 18;
                        ///////////////////////NO IMPARTA QUE SAQUEN ///////
                               //////////////////// SI NO ES LO MISMO A LA VEZ PASADA PIERDEN///////
                }          
                
              }while(decisivo1_1 == decisivo2_2);///////////EVALUA AL GANADOR O PERDEDOR///
              if(inte == 0 && inte1 == 0 ){
                if((puntosJugador1 == 7 || puntosJugador1 == 11) &&
                    (puntosJugador2 == 2 || puntosJugador2 == 3 || puntosJugador2 == 12) ){
                        empates = false;  
                        play1.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" La COMPUTADORA PERDIO " );
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else if( (puntosJugador1 == 2 || puntosJugador1 == 3 || puntosJugador1 == 12)&&
                    (puntosJugador2 == 7 || puntosJugador2 == 11)){
                        empates = false;      
                        play1.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println("LA COMPUTADORA GANO");
                        System.out.println(" Perdiste " + " "+ play1.getAlias());
                        System.out.println("--------------------------------------------");
                    }else if((puntosJugador1 == 7 || puntosJugador1 == 11) &&
                    (puntosJugador2 == 7 || puntosJugador2 == 11)){
                        empates = true;
                        System.out.println("--------------------------------------------");
                        System.out.println("Los jugadores quedaron empates");
                        System.out.println("Es necesario que se juegue otra ronda");
                        System.out.println("--------------------------------------------");
                    }else  if((puntosJugador1 == 7 || puntosJugador1 == 11) && 
                    (puntosJugador2 == 4 || puntosJugador2 == 5 || puntosJugador2 == 6) ){
                        empates = false;  
                        play1.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" La COMPUTADORA PERDIO " );
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                   }else if((puntosJugador1 == 7 || puntosJugador1 == 11) && 
                   (puntosJugador2 == 8 ||  puntosJugador2 == 9 || puntosJugador2 == 10 ) ){
                        empates = false;  
                        play1.ganador();
                        System.out.println("--------------------------------------------");
                        System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                        System.out.println(" Has ganado 10 puntos ");
                        System.out.println(" La COMPUTADORA PERDIO " );
                        play1.sumarPuntos(10);
                        System.out.println("--------------------------------------------");
                    }else  if((puntosJugador1 == 4 || puntosJugador1 == 5 || puntosJugador1 == 6) && 
                    (puntosJugador2 == 7 || puntosJugador2 == 11)){
                        empates = false;      
                        play1.perder();
                        System.out.println("--------------------------------------------");
                        System.out.println(" LA COMPUTADORA GANO");
                        System.out.println(" Perdiste " + " "+ play1.getAlias());
                        System.out.println("--------------------------------------------");
                }else if(( puntosJugador1 == 8 || puntosJugador1 == 9 || puntosJugador1 == 10 ) && 
                (puntosJugador2 == 7 || puntosJugador2 == 11)){ 
                    empates = false;      
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" LA COMPUTADORA GANO");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                }else if((puntosJugador1 == 2 || puntosJugador1 == 3 || puntosJugador1 == 12) &&
                (puntosJugador2 == 4 || puntosJugador2 == 5 || puntosJugador2 == 6)){
                    empates = false;      
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" LA COMPUTADORA GANO");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                }else if((puntosJugador1 == 2 || puntosJugador1 == 3 || puntosJugador1 == 12) &&
                (puntosJugador2 == 8 || puntosJugador2 == 9 || puntosJugador2 == 10 ) ){
                    empates = false;      
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" LA COMPUTADORA GANO");
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");
                }else if((puntosJugador1 == 4 || puntosJugador1 == 5 || puntosJugador1 == 6)&&
                (puntosJugador2 == 2 || puntosJugador2 == 3 || puntosJugador2 == 12)){
                    empates = false;  
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" La COMPUTADORA PERDIO " );
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }else if( (puntosJugador1 == 8 ||  puntosJugador1 == 9 || puntosJugador1 == 10 ) &&
                (puntosJugador2 == 2 || puntosJugador2 == 3 || puntosJugador2 == 12) ){
                    empates = false;  
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" La COMPUTADORA PERDIO " );
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");
                }else if((puntosJugador1 == 2 || puntosJugador1 == 3 || puntosJugador1 == 12) &&
                (puntosJugador2 == 2 || puntosJugador2 == 3 || puntosJugador2 == 12) ){
                    empates = false;
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" AMBOS PERDIERON  ");
                    System.out.println(" OBTIENEN NINGUN PUNTO  ");
                    System.out.println("--------------------------------------------");

                }

            }else if(inte == 1 && inte1 == 1 ){
                if(together == true && together2 == false ){
                    empates = false;
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" Felicidades !!!" + " " + play1.getAlias());
                    System.out.println(" Has ganado 10 puntos ");
                    System.out.println(" Perdiste COMPUTADORA" );
                    play1.sumarPuntos(10);
                    System.out.println("--------------------------------------------");

                }else if(together2 == true && together == false){
                    empates = false;
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" La COMPUTADORA GANO " );
                    System.out.println(" Perdiste " + " "+ play1.getAlias());
                    System.out.println("--------------------------------------------");

                }else if(together2 == true && together == true){
                    empates = false;
                    play1.ganador();
                    System.out.println("--------------------------------------------");
                    System.out.println(" AMBOS SACARON LA MISMA PUNTUACION QUE LA ");
                    System.out.println(" OBTIENES 5 PUNTOS ");
                    System.out.println("--------------------------------------------");
                    play1.sumarPuntos(5);
                }else if(together2 == false && together == false){
                    empates = false;
                    play1.perder();
                    System.out.println("--------------------------------------------");
                    System.out.println(" NINGUNO DE LOS DOS SACARON LA PUNTUACION  ");
                    System.out.println(" DE LA PARTIDA PASADA AMBOS OBTIENE  ");
                    System.out.println(" NINGUN PUNTO, SIN EMBARGO POR DEFAUL ");
                    System.out.println(" TU PIERDES Y LA COMPUTADORA GANA ");
                    System.out.println("--------------------------------------------");
                }
            }
           
            } ////////////while //////////////////
            for(int j = 0; j< listaJugadores.length; j++){
                if(listaJugadores[j].getClave() == p1){
                   listaJugadores[j] = play1;
                   break;           // GUARDA LA INFO EN EL ARREGLO SERIALIZADO ...
                }
           }
           nam.escribirObjetosArchivos("Jugador.txt", listaJugadores); 

            }else{
                System.out.println("Ese no es tu Compañero"); 
            }
        /////////////////////////////Termina 1 JUGADOR ///////////////////// 
        }else if(arreglo.length < 1){
            System.out.println("Se requiere por lo menos un jugador");
        }else if(arreglo.length > 2){
            System.out.println("Solo pueden Jugar a lo mas DOS Jugadores");

        }    
    }
}