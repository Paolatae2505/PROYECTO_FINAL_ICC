/**
 * CLASE CONECTA CUATRO
 * @author Vargas Bravo Paola
 * @version 1
 */
public class ConectaCuatro{
    //////////////ATRIBUTOS///////////////////
    private int turno;
    private String [][] tablero;
    private int columna0 = 3;
    private int columna1 = 3;
    private int columna2 = 3;
    private int columna3 = 3;

    /**
     * Constructor por omisión de Conecta Cuatro
     */
    public ConectaCuatro(){
        tablero = new String [4] [4];
    	for(int i=0; i<tablero.length; i++){
    		for(int j=0; j<tablero[i].length; j++){
    			tablero[i][j]=" ";
     	 	}
		}
    }
    /**
     * Asigna el Turno 
     * @param turno2 -- Turno
     */
    public void setTurno(int turno2){
            turno = turno2;
    }
    /**
     * Asigna  valor columna0
     * @param colum0 --- Valor columna0
     */
    public void setColumna0(int colum0){
        columna0 = colum0;
    }
    /**
     * Asigna  valor columna1
     * @param colum1 --- Valor columna1
     */
    public void setColumna1(int colum1){
        columna1 = colum1;
    }
    /**
     * Asigna  valor columna2
     * @param columna2 --- Valor columna2
     */
    public void setColumna2(int columna2){
        this.columna2  = columna2;
    }
    /**
     * Asigna  valor columna3
     * @param colum3 --- Valor columna3
     */
    public void setColumna3(int colum3){
        columna3 = colum3;
    }
    /**
     * Asigna  valor a el Tablero
     * @param nuevoTablero --- Nuevo valor del Tablero
     */
    public void setTablero(String [][] nuevoTablero){
        tablero = nuevoTablero;
    }
    /**
     * obtiene el valor de la columna0
     * @return --- int Valor de la columna
     */
    public int getColumna0(){
       return columna0;
    }
    /**
     *  obtiene el valor de la columna1
     * @return --- int Valor de la columna
     */
    public int getcolumna1(){
        return columna1;
    }
    /**
     *  obtiene el valor de la columna2
     * @return --- int Valor de la columna
     */
    public int getcolumna2(){
        return columna2;
    }
    /**
     *  obtiene el valor de la columna3
     * @return --- int Valor de la columna
     */
    public int getcolumna3(){
        return columna3;
    }
    /**
     * obtiene  el Tablero
     * @return --- String [][] tablero
     */
    public String [][] getTablero(){
        return tablero;
    }
    /**
     * Obtiene el turno
     * @return --- Turno
     */
    public int getTurno(){
        return turno;
    }
    /**
     * Metodo para saber si una columna esta llena
     * true si esta llena o false no esta llena
     * @param columna -- Columna
     * @return --- Booleano True or False
     * @throws IndexOutOfBoundsException -- Si el numero no es positivo
     */
    public boolean  columnaLLena(int columna){
        int contador = 0;
        if((columna >= 1 || columna <= 4)){
        int colum = columna -1;
            for(int i = 0; i < tablero.length ; i++){
                if(tablero[i][colum].equals("B")|| tablero[i][colum].equals("R") ){
                    contador ++;
                }
            }
            if(contador == 4){
                  return false;
            }else if(contador < 4){
                turno++;
                return true;
            }           
        }
            throw new IndexOutOfBoundsException();
    }
    /**
     * Vacia el tablero (Quita las fichas)
     */
    public void vaciarTablero(){
        for(int i=0; i<tablero.length; i++){
    		for(int j=0; j<tablero[i].length; j++){
                if(tablero[i][j].equals("R")){
                    tablero[i][j]=" ";

                }else if(tablero[i][j].equals("B")){
                    tablero[i][j]=" ";
                }
     	 	}
		}

    }
    /**
     * Coloca la ficha en el tablero
     * @param ficha -- ficha a colocar
     * @param columna- Columna 
     */
    public void colocarFicha(String ficha, int columna){
        int colum = columna -1;
        switch(colum){
            case  0 :         
                if(columna0 >= 0){
                    tablero[columna0][colum] = ficha;
                    columna0 --;
                }else if(columna0 < 0){
                    System.out.println("No puedes tirar en esta fila");
                    System.out.println("Espera a la siguiente");
                    System.out.println("Tu turno se conserva");
                }
          
            break;
            case 1 :
            
                if(columna1 >= 0){
                    tablero[columna1][colum] = ficha;
                    columna1 --;
                    }else if(columna1 < 0){
                        System.out.println("No puedes tirar en esta fila");
                        System.out.println("Espera a la siguiente");
                        System.out.println("Tu turno se conserva");
                    }
            
            break;
            case 2 :
            
                if(columna2 >= 0){
                    tablero[columna2][colum] = ficha;
                    columna2 --;
                   
                    }else if(columna2 < 0){
                        System.out.println("No puedes tirar en esta fila");
                        System.out.println("Espera a la siguiente");
                        System.out.println("Tu turno se conserva");
                    }
            break;
            case 3 :
                if(columna3 >= 0){
                    tablero[columna3][colum] = ficha;
                    columna3 --;
                }else if(columna3 < 0){
                    System.out.println("No puedes tirar en esta fila");
                    System.out.println("Espera a la siguiente");
                    System.out.println("Tu turno se conserva");
                }   
            break;
        }
   }
    
    
   /**
    * Nos dice que ficha es la ganadora 
    * En caso de no haberla regresa NINGUNO
    * EN caso de empate regresa EMPATE
    * @return ficha ganadora
    */
    public String allkill4X4(){
    String  aLLKILL  = "";
     if(turno < 16 ){
        if (tablero[0][0].equals("R") && tablero[1][0].equals("R") && tablero[2][0].equals("R") &&
        tablero[3][0].equals("R")) {
            aLLKILL = "R";
        }else if (tablero[0][0].equals("B") && tablero[1][0].equals("B") && tablero[2][0].equals("B")  &&
        tablero[3][0].equals("B")) {
           aLLKILL= "B";
        }else if (tablero[0][0].equals("R") && tablero[0][1].equals("R") && tablero[0][2].equals("R") &&
        tablero[0][3].equals("R")) {
            aLLKILL = "R";
        }else if (tablero[0][0].equals("B") && tablero[0][1].equals("B") && tablero[0][2].equals("B") &&
        tablero[3][0].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[0][0].equals("R") && tablero[1][1].equals("R") && tablero[2][2].equals("R") &&
        tablero[3][3].equals("R")) {
            aLLKILL = "R";
        }else if (tablero[0][0].equals("B") && tablero[1][1].equals("B") && tablero[2][2].equals("B") &&
        tablero[3][3].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[1][0].equals("R") && tablero[1][1].equals("R") && tablero[1][2].equals("R") &&
        tablero[1][3].equals("R")) {
            aLLKILL = "R";
        }else  if (tablero[1][0].equals("B") && tablero[1][1].equals("B") && tablero[1][2].equals("B") &&
        tablero[1][3].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[0][1].equals("R") && tablero[1][1].equals("R") && tablero[2][1].equals("R") &&
        tablero[3][1].equals("R")) {
            aLLKILL = "R";
        }else if (tablero[0][1].equals("B") && tablero[1][1].equals("B") && tablero[2][1].equals("B") &&
        tablero[3][1].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[2][0].equals("R") && tablero[2][1].equals("R") && tablero[2][2].equals("R") &&
        tablero[2][3].equals("R")) {
            aLLKILL = "R";            
        }else  if (tablero[2][0].equals("B") && tablero[2][1].equals("B") && tablero[2][2].equals("B") &&
        tablero[2][3].equals("B")) {            
           aLLKILL = "B";
        }else   if (tablero[0][2].equals("R") && tablero[1][2].equals("R") && tablero[2][2].equals("R") &&
        tablero[3][2].equals("R") ) {
            aLLKILL = "R";            
        }else   if (tablero[0][2].equals("B") && tablero[1][2].equals("B") && tablero[2][2].equals("B") &&
        tablero[3][2].equals("B")) {  
           aLLKILL = "B";           
        }else  if (tablero[0][3].equals("R") && tablero[1][3].equals("R") && tablero[2][3].equals("R") &&
        tablero[3][3].equals("R")) {       
            aLLKILL = "R";            
        }else    if (tablero[0][3].equals("B") && tablero[1][3].equals("B") && tablero[2][3].equals("B") &&
        tablero[3][3].equals("B")) {        
          aLLKILL = "B";           
        }else   if (tablero[0][3].equals("R") && tablero[1][2].equals("R") && tablero[2][1].equals("R") &&
        tablero[3][0].equals("R")) {       
            aLLKILL = "R";           
        }else    if (tablero[0][2].equals("B") && tablero[1][1].equals("B") && tablero[2][0].equals("B") &&
        tablero[3][0].equals("B")) {           
           aLLKILL = "B";
        }else if(tablero[3][0].equals("R") && tablero[3][1].equals("R") && tablero[3][2].equals("R") &&
        tablero[3][3].equals("R")){
            aLLKILL = "R";
        }else if(tablero[3][0].equals("B") && tablero[3][1].equals("B") && tablero[3][2].equals("B") &&
        tablero[3][3].equals("B")){
            aLLKILL = "B";
        }else{
           aLLKILL = "NINGUNO";
        }
     }
     if(turno == 16 ){
        if (tablero[0][0].equals("R") && tablero[1][0].equals("R") && tablero[2][0].equals("R") &&
        tablero[3][0].equals("R")) {      
            aLLKILL = "R";
        }else if (tablero[0][0].equals("B") && tablero[1][0].equals("B") && tablero[2][0].equals("B")  &&
        tablero[3][0].equals("B")) {
           aLLKILL= "B";
        }else if (tablero[0][0].equals("R") && tablero[0][1].equals("R") && tablero[0][2].equals("R") &&
        tablero[0][3].equals("R")) {
            aLLKILL = "R";     
        }else if (tablero[0][0].equals("B") && tablero[0][1].equals("B") && tablero[0][2].equals("B") &&
        tablero[3][0].equals("B")) {        
           aLLKILL = "B";
        }else if (tablero[0][0].equals("R") && tablero[1][1].equals("R") && tablero[2][2].equals("R") &&
        tablero[3][3].equals("R")) { 
            aLLKILL = "R";
        }else if (tablero[0][0].equals("B") && tablero[1][1].equals("B") && tablero[2][2].equals("B") &&
        tablero[3][3].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[1][0].equals("R") && tablero[1][1].equals("R") && tablero[1][2].equals("R") &&
        tablero[1][3].equals("R")) {
            aLLKILL = "R";
        }else  if (tablero[1][0].equals("B") && tablero[1][1].equals("B") && tablero[1][2].equals("B") &&
        tablero[1][3].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[0][1].equals("R") && tablero[1][1].equals("R") && tablero[2][1].equals("R") &&
        tablero[3][1].equals("R")) {
            aLLKILL = "R";
        }else if (tablero[0][1].equals("B") && tablero[1][1].equals("B") && tablero[2][1].equals("B") &&
        tablero[3][1].equals("B")) {
           aLLKILL = "B";
        }else if (tablero[2][0].equals("R") && tablero[2][1].equals("R") && tablero[2][2].equals("R") &&
        tablero[2][3].equals("R")) {
            aLLKILL = "R";
        }else  if (tablero[2][0].equals("B") && tablero[2][1].equals("B") && tablero[2][2].equals("B") &&
        tablero[2][3].equals("B")) {
           aLLKILL = "B";
        }else   if (tablero[0][2].equals("R") && tablero[1][2].equals("R") && tablero[2][2].equals("R") &&
        tablero[3][2].equals("R") ) {
            aLLKILL = "R";            
        }else   if (tablero[0][2].equals("B") && tablero[1][2].equals("B") && tablero[2][2].equals("B") &&
        tablero[3][2].equals("B")) {
           aLLKILL = "B";
        }else  if (tablero[0][3].equals("R") && tablero[1][3].equals("R") && tablero[2][3].equals("R") &&
        tablero[3][3].equals("R")) {
            aLLKILL = "R";
        }else    if (tablero[0][3].equals("B") && tablero[1][3].equals("B") && tablero[2][3].equals("B") &&
        tablero[3][3].equals("B")) {
           aLLKILL = "B";
        }else   if (tablero[0][3].equals("R") && tablero[1][2].equals("R") && tablero[2][1].equals("R") &&
        tablero[3][0].equals("R")) {
            aLLKILL = "R";           
        }else    if (tablero[0][2].equals("B") && tablero[1][1].equals("B") && tablero[2][0].equals("B") &&
        tablero[3][0].equals("B")) {
           aLLKILL = "B";
        }else if(tablero[3][0].equals("R") && tablero[3][1].equals("R") && tablero[3][2].equals("R") &&
        tablero[3][3].equals("R")){
            aLLKILL = "R";
        }else if(tablero[3][0].equals("B") && tablero[3][1].equals("B") && tablero[3][2].equals("B") &&
        tablero[3][3].equals("B")){
            aLLKILL = "B";
        }else{
           aLLKILL = "EMPATE";
        }
     }
       return aLLKILL; 
    }    

    /**
    *Metodo toString que imprime el tablero
    *@return tablero
    */
    public String toString(){
        String acc = getLinea()+"\n";
      	for(int i=0;i<tablero.length;i++){
        	acc+="| ";
        	for(int j=0;j<tablero[i].length;j++)
        		acc += tablero[i][j]+" | ";
        		acc +="\n"+getLinea()+"\n";
      	}
      	return acc;
    }
     
    /**
    * Metodo Privado Obtien una linea
    *@return linea
    */
    private String getLinea(){
        return "-----------------";
    }
    


}