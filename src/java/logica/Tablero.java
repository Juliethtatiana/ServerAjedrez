package logica;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tablero {
    
    
    
    //------------------------TABLEROS QUE SE VAN A UTILZIAR----------------------------
    // TABLERO CON TODAS LA FICHAS
    private int[][] tablero;

    // TABLERO CON LAS FICHAS BLANCAS
    private int [][] posiBlancas;
    // TABLERO CON LAS FICHAS NEGRAS
    private int [][] posiNegras;
    
    /*
    // ----------------VARIABLES QUE DEBEN IR EN OTRA CLASE (JUGADOR)-----------------------
    private Peon [] peonesBlancos;
    private Peon [] peonesNegros;

    private Torre [] torreBlancos;
    private Torre [] torreNegros;

    private Alfil [] alfilBlanco;
    private Alfil [] alfilNegro;
    
    private Caballo [] caballoBlanco;
    private Caballo [] caballoNegro;
    
    private Reina reinaBlanco;
    private Reina reinaNegro;
    
    private Rey reyBlanco;
    private Rey reyNegro;
    
    
/* SIN IMPLEMENTAR
    //guarda los puntos de los peones que allan dado dos posas en su primer movimiento
    // es necesario para la captura al paso del peón
    // el peon anterior debio haberse movido dos pasos
    // esta lista debe limpiarse al final de cada turno,
    // despues de ejecutado el movimiento del jugador en turno
    private Point capPaso;
    */

// CONSTRUCTOR
    public Tablero () {
        // se instacian las dimensiones de todos los tableros
        tablero= new int[8][8];
        posiBlancas= new int[8][8];
        posiNegras= new int[8][8];
    }

    ///------------getters
    public int[][] getTablero (){
            return tablero;
    }

    public int[][] getPosiBlancas() {
        return posiBlancas;
    }
    
    public int[][] getPosiNegras() {
        return posiNegras;
    }
    
    //--------------------------setters

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public void setPosiBlancas(int[][] posiBlancas) {
        this.posiBlancas = posiBlancas;
    }

    public void setPosiNegras(int[][] posiNegras) {
        this.posiNegras = posiNegras;
    }
    

// --------------------FUNCIONES QUE DEBER IR EN OTRO LADO Y SON NECESARIAS-----------------------------------------------------
// se instancian las fichas, se le asignan posiciones, y se guardan esas
// posiciones en los diferentes tableros
/*

    public void ponerPeones() {
        // iniciando los peones blancos
        peonesBlancos = new Peon[8];
        peonesNegros = new Peon[8];
        
        for (int i = 0; i < 8; i++) {
           // peonesBlancos[i] = new Peon(1,i,"blanco");
            posiBlancas[1][i]=1;
            tablero[1][i]=1;
        }
        
        // iniciando los peones negros
        for (int i = 0; i < 8; i++) {
            //peonesNegros[i] = new Peon(6,i,"negro");
            posiNegras[6][i]=1;
            tablero[6][i]=1;
        }
    }
    
    
public void ponerTorres (){
     // iniciando las torres blancas
    torreBlancos = new Torre[2];
    torreNegros = new Torre[2];

   
    torreBlancos[0] = new Torre(0,0,"blanco");
    torreBlancos[1] = new Torre(0,7,"blanco");
    
    posiBlancas[0][0]=1;
    posiBlancas[0][7]=1;

    tablero[0][0]=1;
    tablero[0][7]=1;

    
    
    // iniciando los peones negros
   
    torreNegros[0] = new Torre(7,7,"negro");
    torreNegros[1] = new Torre(7,0,"negro");
    
    posiNegras[7][7]=1;
    posiNegras[7][0]=1;

    tablero[7][7]=1;
    tablero[7][0]=1;

}


public void ponerAlfiles (){
     
    alfilBlanco = new Alfil[2];
    alfilNegro = new Alfil[2];

   // iniciando los peones blancos
    alfilBlanco[0] = new Alfil(0,2,"blanco");
    alfilBlanco[1] = new Alfil(0,5,"blanco");
    
    posiBlancas[0][2]=1;
    posiBlancas[0][5]=1;

    tablero[0][2]=1;
    tablero[0][5]=1;

    
    
    // iniciando los peones negros
   
    alfilNegro[0] = new Alfil(7,2,"negro");
    alfilNegro[1] = new Alfil(7,5,"negro");
    
    posiNegras[7][2]=1;
    posiNegras[7][5]=1;

    tablero[7][2]=1;
    tablero[7][5]=1;

}
   
public void ponerCaballos (){
     
    caballoBlanco = new Caballo[2];
    caballoNegro = new Caballo[2];

   // iniciando los caballos blancos
    caballoBlanco[0] = new Caballo(0,1,"blanco");
    caballoBlanco[1] = new Caballo(0,6,"blanco");
    
    posiBlancas[0][1]=1;
    posiBlancas[0][6]=1;

    tablero[0][1]=1;
    tablero[0][6]=1;

    
    
    // iniciando los caballos negros
   
    caballoNegro[0] = new Caballo(7,1,"negro");
    caballoNegro[1] = new Caballo(7,6,"negro");
    
    posiNegras[7][1]=1;
    posiNegras[7][6]=1;

    tablero[7][1]=1;
    tablero[7][6]=1;

}

public void ponerReinas (){
     
    
    // reina blanca
    
    reinaBlanco = new Reina(0,3,"blanco");
    
    posiBlancas[0][3]=1;

    tablero[0][3]=1;

    
    
    // iniciando los peones negros
    
    reinaNegro = new Reina(7,4,"negro");   
    
    posiNegras[7][4]=1;
    
    tablero[7][4]=1;

}

public void ponerReyes (){
     
    
    // reina blanca
    
    reyBlanco = new Rey(0,4,"blanco");
    
    posiBlancas[0][4]=1;

    tablero[0][4]=1;

    
    
    // iniciando los peones negros
    
    reyNegro = new Rey(7,3,"negro");   
    
    posiNegras[7][3]=1;
    
    tablero[7][3]=1;

}
    */
//---------------------------------------------------------------------------------------------


//FUNCIONES DE TESTEO

// FUNCIÓN AUXILIAR para que se impriman todos los tablero

public void imprimirTablero(){
     // imprimir
    System.out.println("-------------TABLERO---------------------");
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
            System.out.print(tablero[i][j]);
            System.out.print("    ");
        }
        System.out.println(" ");
    }
   
    System.out.println("----------------POSIBLANCAS--------------------------");
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
            System.out.print(posiBlancas[i][j]);
            System.out.print("    ");
        }
        System.out.println(" ");
    }
      System.out.println("----------------POSINEGRAS--------------------------");
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
            System.out.print(posiNegras[i][j]);
            System.out.print("    ");
        }
        System.out.println(" ");
    }
  
}


// FUNCIÓN AUXILIAR para que imprima las posiciones posibles a moverse   
public void imprimirPosi(ArrayList<Point> p){
    //moverFicha(peonesBlancos[0].getPosi(), new Point(5,2),"blanco",0);
    //moverFicha(peonesNegros[0].getPosi(), new Point(4,1),"negro",0);

    //moverFicha(peonesNegros[1].getPosi(), new Point(2,1),"negro",1);
    //moverFicha(reyBlanco.getPosi(), new Point(5,1),"blanco",1);
    
    //moverFicha(caballoBlanco[1].getPosi(), new Point(5,5),"blanco",1);   

    Point aux;
    int [][] auxTablero = new int[8][8];
    auxTablero=tablero;
    for (int i = 0; i < p.size(); i++) {
        aux=p.get(i);
        auxTablero[aux.x][aux.y]=2;
    }
    
      
        System.out.println("-------------POSIBLES POSICIONES---------------------");
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
            System.out.print(auxTablero[i][j]);
            System.out.print("    ");
        }
        System.out.println(" ");
    }
    
}


//------------------FUNCIONES PROPUESTAS
/*
public void enroque(String color){
    if(color=="blanco"){
        if(!reyBlanco.getPriMov()){
            if(!torreBlancos[0].getPriMov()){
                if(diferenciaFichas(torreBlancos[0].getPosi(), reyBlanco.getPosi(), "blanco")){
                    reyBlanco.setPosicion(new Point(0,2));
                }
            }
            if(!torreBlancos[1].getPriMov()){
                if(diferenciaFichas(torreBlancos[1].getPosi(), reyBlanco.getPosi(), "blanco")){
                    reyBlanco.setPosicion(new Point(0,6));
                }
            }
        }
    }       
}
*/
// se revisa si hay fichas entre dos fichas
// true si no hay nada
// false si existe algo
// revisa solo horizontalmente
public boolean diferenciaFichas(Point pInicial, Point pFinal, String color){
    if (pInicial.y>pFinal.y){
        System.out.println("se entro la de la torre es"+pInicial.y+"la del rey es;"+pFinal.y);
        for (int i = 1; pFinal.y+i < pInicial.y; i++) {
            // pregunta si no hay ningun aliado entre las dos fichas
            if(!preguntarAliado(new Point(pFinal.x,pFinal.y+i), color)){
                // pregunta si existe un enemigo entre las dos fichas
                if(preguntar(new Point( pFinal.x, pFinal.y+i), color)){  
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }else{
        for (int i = 1; pInicial.y+i < pFinal.y; i++) {
            System.out.println("se entro la de la torre es"+pInicial.y+"la del rey es;"+pFinal.y);
            // pregunta si no hay ningun aliado entre las dos fichas
            if(!preguntarAliado(new Point(pInicial.x, pInicial.y+i), color)){
                // pregunta si existe un enemigo entre las dos fichas
                if(preguntar(new Point( pInicial.x, pInicial.y+i), color)){  
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}



//-----------------------FUNCIONES NECESARIAS-------------------------------------
    // FUNCIÓN NECESARIA PARA CALCULAR MOVIMIIENTOS
    public boolean preguntarAliado(Point pVerifiar, String color) {
        if(color=="negro"){
            // verifica si exite otra ficha del equipo contrario en esa posición.
            if(posiNegras[pVerifiar.x][pVerifiar.y]==0){
                // false es que no hay nada
                return false;
            }else{
                return true;
            }
        }else{
            // verifica si exite otra ficha del equipo contrario en esa posición.
            if(posiBlancas[pVerifiar.x][pVerifiar.y]==0){
                return false;
            }else{
                return true;
            }
        }
    }

    // FUNCIÓN NECESARIA PARA CALULAR MOVIMIENTOS
    //verifica si en la posición indicada se encuentra una ficha del equipo contrario
    public boolean preguntar(Point pVerifiar, String color ){
        if(color=="blanco"){
            // verifica si exite otra ficha del equipo contrario en esa posición.
            if(posiNegras[pVerifiar.x][pVerifiar.y]==0){
                // false es que no hay nada
                return false;
            }else{
                return true;
            }
        }else{
            // verifica si exite otra ficha del equipo contrario en esa posición.
            if(posiBlancas[pVerifiar.x][pVerifiar.y]==0){
                return false;
            }else{
                return true;
            }
        }
    }
    
    // MANEJA LO DE HACER UN MOVIMIENTO
    public void movimiento(Point inicio,Point llegada, String color, int nomFicha){
        
        /*if(this.tablero[inicio.x][inicio.y]==0){
            JOptionPane.showMessageDialog(null, "no hay nada en esa posición");
        }*/
        
        this.tablero[inicio.x][inicio.y]=0;
        this.tablero[llegada.x][llegada.y]=nomFicha;
        if (color=="blanco"){
            this.posiBlancas[inicio.x][inicio.y]=0;
            this.posiBlancas[llegada.x][llegada.y]=nomFicha;
            this.posiNegras[llegada.x][llegada.y]=0;
        }else{
            this.posiNegras[inicio.x][inicio.y]=0;
            this.posiNegras[llegada.x][llegada.y]=nomFicha;
            this.posiBlancas[llegada.x][llegada.y]=0;
        }

    }
    
//-----------------------------------------------------------------------------------
    

    /*
    códigos numericos de los arreglos que contiene las posiciones de las fichas de cada equipo
    0   <= esta vacia la posición
    1   <= la casilla esta ocupada por una ficha
    */
  

    
    /*
    // el metodo recive la posición en la que se encuentra actualmente la ficha que se va a mover
    // el segundo parametro es la posición a la que se quiere revisar si se puede mover
    // el tercer parametro es el color al que corresponde la ficha a moverse
    public boolean revisarPosicion(int [][] posiAnterior, int[][] posiNueva, String color) {
         // metodo que verifica que al mover la ficha no se ponga en jaque el rey
         if(verficarJaque(color)== false){
             return false;
         }
    }
    

    // metodo que verifica que al mover la ficha no se ponga en jaque el rey
    public boolean verficarJaque(String color) {
        
    }

    // le pide a todas las fichas del equipo contrario sus nuevas posiciones para verificar si alguna puede
    // atacar al rey
    public boolean pedirNuevasPosiciones(int [][] posiAnterior, int[][] posiNueva, String color) {
        // se crea un nuevo tablero
        int tableroAux = new int[8][8];
        // se copia el tablero
        tableroAux= this.tablero;
        if(color=="blanco"){
            // se crea un tablero con las posiciones de las fichas del equipo que se va a mover
            tableroAux=this.posiBlancas
            // se quita la ficha de esa posición
            this.posiBlancas[posiAnterior[0][0],posiAnterior[0][1]]=0;
            // se pone la ficha en la nueva posición
            this.posiBlancas[posiNueva[0][0], posiNueva[0][1]]=1;
            // se le piden las nuevas posiciones a las fichas del equipo contrario con el nuevo tablero hipotetico que se obtuvo
            //---------
        }else{
            // se crea un tablero con las posiciones de las fichas del equipo que se va a mover
            tableroAux=this.posiNegras
            // se quita la ficha de esa posición
            this.posiNegras[posiAnterior[0][0],posiAnterior[0][1]]=0;
            // se pone la ficha en la nueva posición
            this.posiNegras[posiNueva[0][0], posiNueva[0][1]]=1;
            // se le piden las nuevas posiciones a las fichas del equipo contrario con el nuevo tablero hipotetico que se obtuvo
            //---------
        }
        // la posición
        tablero 
    }

      // le indica a cada ficha del equipo contrario las posiciones que se puede mover despues moverse una
    public boolean verificarNuevasPosiciones() {
        
    }

    
    
    
    
    
    
    // verifica si hubo algun peon que se movio dos posiciones el anterior turno y toma su posición
    // y lo compara con la que le lleguen
    public boolean capturaPaso(Point pVerifiar) {
        // verifica si ambos puntos son iguales.
        if(pVerifiar==capPaso){
            return true;
        }
        return false;
    }
*/

    
}