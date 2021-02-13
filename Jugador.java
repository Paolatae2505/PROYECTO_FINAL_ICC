import java.io.Serializable;
/**
 * Clase Jugador
 * @author Vargas Bravo Paola
 * @version 1
 */
public class Jugador implements Serializable {
   //////////////////Atributos//////////////
   private static int cont = 0;
   private String nombre;
   private String sexo;
   private int edad;
   private String alias;
   private int puntos = 0;
   private boolean jugando = true;
   private String contrincante;
   private String clave;
   private boolean ganador = true;
   private String carrera;
    /**
    * Constructor de un Jugador apartir de su nombre,sexo,edad,alias
    * @param nombre - Nombre del Jugador
    * @param sexo --- Sexo del Jugador
    * @param edad --- Edad del Jugador
    * @param alias -- Alias del Jugador
	* @param carrera -Carrera del Jugador
    */
    public Jugador(String nombre, String sexo, int edad, String alias, String carrera){
    	this.nombre = nombre;
    	this.sexo = sexo;
    	this.edad = edad;
    	this.alias = alias;
    	this.carrera = carrera;
    	cont ++;
    	clave = "Jugador" + cont;
    }
    /**
    * Constructor de Copia apartir de un Jugador
    * @param play1 -- Jugador
    */
    public Jugador(Jugador play1){
		this.nombre = play1.nombre;
		this.sexo = play1.sexo;
		this.edad = play1.edad;
		this.alias = play1.alias;
		this.carrera = play1.carrera;
	}
	/**
	* Indica que el Jugador esta Jugando
	*/
	public void jugar(){
		jugando = true;
	}
	/**
	* Indica que el Jugador termino de Jugar
	*/
	public void terminarJugar(){
		jugando = false;
	}
	/**
	* Indicar que el Jugador Gano la Partida
	*/
	public void ganador(){
		ganador = true;
	}
	/**
	* Indicar que el Jugador Perdio la Partida
	*/
	public void perder(){
		ganador = false;
	}
	/**
	* Obtiene True si un Jugador Gano y False si perdio la Partida
	* @return boolean --- estado del Jugador
	*/   
	public boolean ganoPartida() {
		if (ganador == false){
			return false;
		}else{
			return true;
		}
	}
	/**
	* Obtiene True el Jugador Juega y False no esta Jugando
	* @return boolean --- estado del Jugador
	*/   
	public boolean estaJugando() {
		if (jugando == true){
			return true;
		}else{
			return false;
		}
	}

	/**
	* Asigna  un contrincante al Jugador
	* @param contrincante --- contrincante asigndo
	*/
	public void contrincante(String contrincante){
		this.contrincante = contrincante;
	}
	/**
	* Asigna  un Nombre al Jugador
	* @param nom --- Nombre asigndo
	*/
	public void setNombre(String nom){
		nombre  = nom;
	}
	/**
	* Asigna  un Sexo al Jugador
	* @param sexo --- contrincante asigndo
	*/
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	/**
	* Asigna una Edad al Jugador
	* @param edad --- Edad asigndo
	*/
	public void setEdad(int edad){
			this.edad = edad;
	}
	/**
	* Asigna  Carrera al Jugador
	* @param carrera --- Carrera asignada
	*/
	public void setCarrera(String carrera){
		this.carrera = carrera;
	}
	/**
	* Asigna  Puntos al Jugador
	* @param puntos --- Puntos asignados
	*/
	public void setPuntos(int puntos){
		this.puntos = puntos;
	}
	/**
	* Asigna Clave al Jugador
	* @param clave --- Clave asiganada
	*/
	public void setClave(String clave){
		this.clave = clave;
	}
	/**
	* Asigna Alias al Jugador
	* @param alias --- Alias asignados
	*/
	public void setAlias(String alias){
		this.alias = alias;
	}
	/**
	* Asigna numero de Jugador
	* @param numero --- Numero Asignado
	*/
	public void setNumero(int  numero){
			cont = numero;
	}
	/**
	* Suma los puntos acumulados
	* @param puntosganados --- Puntos ganados 
	*/
	public void sumarPuntos(int puntosganados){
			puntos += puntosganados;
		
	}
	/**
	* Obtiene el contrincante del Jugador
	*  @return String  --- contrincante
	*/
	public String getContrincante(){
		return contrincante;
	}
	/**
	*  Obtiene los puntos del Jugador
	*  @return int --- Puntos
	*/
	public int getPuntos(){
		return puntos;
	}
	/**
	* Obtiene el nombre del jugador 
	* @return String ---- nombre del jugador
	*/
	public String getNombre(){
		return nombre;
	}
	/**
	* Obtiene el Alias del jugador 
	* @return String ---- nombre del jugador
	*/
	public String getAlias(){
		return alias;
	}
	/**
	* Obtiene la clave del Jugador 
	* @return String ---- Clave del Jugador
	*/
	public String  getClave(){
		return clave;
	}
	/**
	* Obtiene el sexo del Jugador
	* @return String ---- Sexo del Jugador
	*/
	public String  getSexo(){
		return sexo;
	}
	/**
	* Obtiene la Edad del Jugador
	* @return int ---- Edad del Jugador
	*/
	public int  getEdad(){
		return edad;
	}
	/**
	* Obtiene el Numero del Jugador 
	* @return int ---- Numero del Jugador
	*/
	public int  getNumeroJugador(){
		return cont;

	}
	/**
	* Obtiene el Carrera del Jugador 
	* @return String ---- Carrera del Jugador
	*/
	public String  getCarrera(){
		return carrera;

	}
	/**
	* Metodo Strng 
	* @return String ---- representacion en cadena del Jugador
	*/
	public String toString(){
		String cadena = " ";
		cadena = "Nombre : " + " " + nombre + " \n"+  "Alias :" + alias +" \n"+
		"\n  Clave :"+" "+ clave;
		return cadena;
	}

}