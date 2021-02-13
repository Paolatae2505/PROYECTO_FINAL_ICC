/**
 * Clase Lista para manejar Jugadores
 * @author Vargas Bravo Paola
 * @version 1
 * @see Jugador
 */
public class Lista{
	/////////////ATRIBUTOS//////////
	private Jugador [] jugadoresLista;

/**
* Constructor apartir de un Arreglo de Jugadores
* @param lista -- Arreglo de Jugadores
*/
public Lista(Jugador [] lista ){
	jugadoresLista  = lista;
}

/* * Método que genera numeros aleatorios entre 0 y max. */
private int random(int max) {
	return (int) Math.round(Math.random() * max + 0.5);
}
/**
*Obtiene un arreglo de Jugadores
*@return ---- Arreglo de Jugadores 
*/
public Jugador [] getJugadores(){
	return jugadoresLista;
}
/**
*Asigna un arreglo de Jugadores
*@param jugadores ---- Arreglo de Jugadores 
*/
public void setJugadores(Jugador [] jugadores){
	 jugadoresLista = jugadores;
}
/**
* Mezcla Jugadores
*/
private void mezclarJugadores(){
for (int i = 0; i < jugadoresLista.length;i ++ ) {
	int regresa = random(jugadoresLista.length-1);
	Jugador p1 = jugadoresLista[regresa];
	jugadoresLista[regresa] = jugadoresLista[i];
	jugadoresLista[i] = p1;	
}

}
/**
*Obtiene un jugador apartir de su Clave en el Arreglo de
*Jugadores
*@param claveN  ------ Clave del Jugador
*@return Jugador ----- Jugador dada su clave
*/
public Jugador getJugadorPorString(String claveN){
	Jugador nuevo = null;
	for (int i = 0; i < jugadoresLista.length;i ++ ) {
		if(jugadoresLista[i].getClave().equals(claveN)){
		  nuevo = jugadoresLista[i];
		  break;
		}else{
			nuevo = null;
		}
	}
	return nuevo;
	}
/**
* Marca el estado de cada Partida
*/
public void estadoPartidas(){
	Jugador play1;
	Jugador play2;
	String clave;
		for(int i = 0; i < jugadoresLista.length; i++){
			jugadoresLista[i].jugar();
		}
		for(int i = 0; i < jugadoresLista.length; i++){
			if(jugadoresLista[i].estaJugando() == true){
				if(jugadoresLista[i].getContrincante().equals("Computadora")){
					play1 = jugadoresLista[i];
					if(play1.ganoPartida() == true){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println("COMPUTADORA");
						System.out.println("Ganador : " + play1.getNombre());
						System.out.println("--------------------------------------");
					}else if(play1.ganoPartida() == false){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println("COMPUTADORA");
						System.out.println("Ganador : COMPUTADORA");
						System.out.println("--------------------------------------");
					}
				}else{
					play1 = jugadoresLista[i];
					clave = jugadoresLista[i].getContrincante();
					play2 = getJugadorPorString(clave);
					if(play1.ganoPartida() == true && play2.ganoPartida() == false){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println(play2.getNombre());
						System.out.println("Ganador :" + " " +play1.getNombre());
						System.out.println("--------------------------------------");
					}else if(play1.ganoPartida() == false && play2.ganoPartida() == true){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println(play2.getNombre());
						System.out.println("Ganador :" +" "+ play2.getNombre());
						System.out.println("--------------------------------------");
					}else if(play1.ganoPartida() == true && play2.ganoPartida() == true){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println(play2.getNombre());
						System.out.println("EMPATE");
						System.out.println("--------------------------------------");

					}else if(play1.ganoPartida() == false && play2.ganoPartida() == false){
						System.out.println("--------------------------------------");
						System.out.println("Partida");
						System.out.println(play1.getNombre());
						System.out.println("vs");
						System.out.println(play2.getNombre());
						System.out.println("AMBOS PERDIERON");
						System.out.println("--------------------------------------");
					}
				}
			}
		}
}

/**
*Metodo para obtener a el Jugador con mayor puntaje
*@return ---- String Jugador con mayor puntaje 
*/
public String campeon(){
	int puntos = 0;
	String nombre = "";
	for(int i = 0; i < jugadoresLista.length; i ++){
		if(jugadoresLista[i].getPuntos() > puntos){
           puntos = jugadoresLista[i].getPuntos();
		}
	}
	for(int i = 0; i < jugadoresLista.length; i ++){
		if(jugadoresLista[i].getPuntos() == puntos ){
			puntos = jugadoresLista[i].getPuntos();
			nombre += " " + jugadoresLista[i].getNombre() + "\n Puntos :"+
			" " + jugadoresLista[i].getPuntos() + "\n";
		}		
	}
	return nombre;
}

/**
*Asigna las Parejas de Jugadores 
*/
public void asignarParejas(){
int conta = 0;
int conta2 = 0;
int par = 0;
int longuitud = jugadoresLista.length-1;
 if (jugadoresLista.length % 2 == 0){ ////////LISTA LONGUITUD PAR ////////////////	
	mezclarJugadores();		
	if(jugadoresLista.length == 2){
    par = (int) (jugadoresLista.length/2);
	}else{
	 par = jugadoresLista.length/2;
	}															  
 for(int i = 0 ; i < par ; i++){
	String  c2 = jugadoresLista[i].getClave();
	String c3 = jugadoresLista[longuitud].getClave();
	 this.jugadoresLista[i].contrincante(c3);
	 this.jugadoresLista[longuitud].contrincante(c2);
	 longuitud = longuitud -1;	
 	}///////////////////TERMINA EL FOR /////////////////////////////////////////																   

	}else  if(jugadoresLista.length % 2 == 1){
	String claveCompu = "Computadora";
	int p = (int)(jugadoresLista.length / 2);
	p ++;
	int q = p;
	if(jugadoresLista.length == 1){
     jugadoresLista[0].contrincante(claveCompu);
	}else{  
		mezclarJugadores();
		for (int j = 0;j < p ; j ++) { 
		if(j != q){
			jugadoresLista[j].contrincante(claveCompu);
			String c4 = jugadoresLista[j].getClave();
			String c5 = jugadoresLista[q].getClave();
			jugadoresLista[j].contrincante(c5);
			jugadoresLista[q].contrincante(c4);
			q = q -1;
	
		}else if(j == q){
			jugadoresLista[q].contrincante(claveCompu);
	    }
	////////////TERMINA LONGUITIUD PAR/////////////				 
	  }	
	}
 }

}

/**
 * Imprime la Lista de Parejas
 */
public void imprimirParejas(){
	int longuitud = 0;
	if(jugadoresLista.length % 2 == 1){
		longuitud =(int) (jugadoresLista.length/2);
		longuitud ++;
		System.out.println("--------------    Parejas Participantes    ----------------");
		for(int i = 0; i < longuitud; i++){
			System.out.println("-------------------------------------------------------");
			System.out.println(jugadoresLista[i].getClave());
			System.out.println("VS");
			System.out.println(jugadoresLista[i].getContrincante());
			System.out.println("-------------------------------------------------------");
		}		
	}else{
		System.out.println("-----------------Parejas Participantes ------------");
		for(int i = 0; i < jugadoresLista.length/2; i++){
			System.out.println("-------------------------------------------------------");
			System.out.println(jugadoresLista[i].getClave());
			System.out.println("VS");
			System.out.println(jugadoresLista[i].getContrincante());
			System.out.println("-------------------------------------------------------");
		}
	}
}
/**
 * Imprime los Jugadores del Torneo
 */
  public void participantes(){
	System.out.println("-----------------Participantes del Torneo ------------");
  	for (int i =  0;i <jugadoresLista.length; i++) {
	System.out.println("-------------------------------------------------------");
  	System.out.print((i+1) + ". ");
  	System.out.print(jugadoresLista[i]);
  	System.out.println("");
  	System.out.println("-------------------------------------------------------");	
  	}

  }

}




