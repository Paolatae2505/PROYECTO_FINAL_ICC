/**
 * Clase para generar Barajas
 * @author Vargas Bravo Paola
 * @see Carta
 * @version 1
 */

public abstract class Baraja{
/////////////////ATRIBUTOS///////////////////
private int tomadas = 1;
private Carta [] cartas;
private int conta = 0;
/**
*
*Constructor que crea por omisión una baraja con 52 cartas.
*/
public Baraja(){
  cartas = new Carta[52];
  for (int i = 1 ; i <= 13 ; i ++) {
  	 cartas[i-1] = new Carta(i,"diamante");
  	 cartas[i +12] = new Carta(i,"trebol");
  	 cartas[i +25] = new Carta(i,"picas");
  	 cartas[i +38] = new Carta(i,"corazon");
  }
}

/**
*Obtiene arreglo de Cartas
*@return --Carta [] un arreglo de cartas
*/
public Carta[] getCartas(){
	return cartas; 
}
/**
*Asigna arreglo de Cartas
*@param carat -- Es un arreglo del tipo Carta 
*/
public void setCartas(Carta [] carat){
	cartas = carat;
}
/**
*Obtiene las cartas Tomadas
*@return -- Numero de Cartas tomadas
*/
public int getTomadas(){
	return tomadas; 
}
/**
*Asigna cartas Tomadas
*@param tomadas -- Cartas Tomadas 
*/
public void setTomadas(int tomadas){
		this.tomadas = tomadas;
}

/**
*Obtiene Contador de cartas
*@return --  Contador
*/
public int getContador(){
	return conta; 
}
/**
*Asigna Contador de Cartas
*@param contador -- Contador
*/
public void setContador(int contador){
		conta = contador;

}
/**
*Saca la primera Carta de la Baraja
*@return Carta -- objeto de tipo Carta 
*/
public Carta primeraCarta(){
   Carta carat1 = cartas[conta];
   conta++;
   return carat1;
}
/**
*True si dos Cartas son iguales y False si no lo son
*@param carta1 ---CARTA A COMPARAR
*@param carta2 ---CARTA A COMPARAR
*@return boolean True son iguales y si es False no son iguales
*/
public boolean iguales(Carta carta1, Carta carta2){

	return(carta1.obtenerValor() == carta2.obtenerValor() || 
	carta1.obtenerFigura() == carta2.obtenerFigura());

	}
/* * Método que genera numeros aleatorios entre 0 y max. */
protected int random(int max) { ///////////////ESTO PROTEGIDO////////////
return (int) Math.round(Math.random() * max + 0.5);
}

/**
*Mezcla las Cartas de la Baraja
*/
public void mixes(){

for (int i = 0; i < cartas.length ;i ++ ) {
	int regresa = random(cartas.length-1);
	Carta cartita = cartas[regresa];
	cartas[regresa] = cartas[i];
	cartas[i] = cartita;	
}
/**
* Asigna valor a las Cartas de acuerdo a el Juego
*/
}
public abstract int ValorPuntoPorCarta(Carta carat);

}