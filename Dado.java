/**
 * Clase Dado
 * @author Vargas Bravo Paola
 * @version 1
 */
public class Dado implements AzarApplicable{
   /////////////////ATRIBUTOS //////////////////
   private int [] numeros = {1,2,3,4,5,6};
   private int conta = 0;

   /**
   * Constructor por omision de Dado
   */
   public Dado(){
   }
   /* * Método que genera numeros aleatorios entre 0 y max. */
   private int random(int max) { 
   	return (int) Math.round(Math.random() * max + 0.5);
   }
    /**
	* Asigna Arreglo de numeros (Valor de el Dado)
	* @param numero --- Arreglo Asignado
	*/
   public void setNumeros(int [] numero ){
      numeros = numero;
   }
   /**
	* Asigna Contador
	* @param contador --- Numero Asignado
	*/
	public void setContador(int contador){
			conta = contador;
	}
   /**
    * Obtener el arreglo de numeros
    * @return arreglo de numeros
    */
   public int [] getNumeros(){
       return numeros;
   }
   /**
    * Obtener el contador
    * @return contador
    */
   public int getContador(){
      return conta;
   }
   /**
    * Lanza un Dado (Mezcla)
    */
   public void lanzar(){     
   for (int i = 0; i < numeros.length ;i ++ ) {
	int regresa = random(numeros.length-1);
	int numerito = numeros[regresa];
	numeros[regresa] = numeros[i];
	numeros[i] = numerito;	
      }
   }
   /**
    *Obtiene el Valor de la Cara superior del dado
    *@return -- int cara Superior
    */
   public int caraArriba(){
      int  cara = numeros[conta];
      return cara;
   }

}