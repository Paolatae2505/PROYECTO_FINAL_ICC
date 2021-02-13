import java.util.Random;
/**
 * Clase para generar Barajas
 * @author  Vargas Bravo Paola
 * @see Carta
 * @version 1
 */

public class BarajaBlack extends Baraja{

/* * Método privado que Mezcla los valores del As*/
private int mezclarAs(){
    int [] numerosAs = {1,11,1,11};
    int regresa = random(numerosAs.length-1);
    int valorAS = numerosAs[regresa];
    return valorAS;
}

/**
*Asigna el valor de las artas para el Juego BlackJack
*@param carat --- Carta 
*@return -------- int Valor de la Carta en el Juego 
*/
public int ValorPuntoPorCarta(Carta carat){
    int valorCarta = carat.obtenerValor();
    if(valorCarta == 11){
        valorCarta = valorCarta -1;

    }else if(valorCarta == 12){
        valorCarta = valorCarta -2;
    }else if(valorCarta == 13){
        valorCarta = valorCarta -3;
    }else if(valorCarta == 1){
        valorCarta = mezclarAs();
    }else{
        valorCarta = carat.obtenerValor();
    }
    return valorCarta;
}
	
}


