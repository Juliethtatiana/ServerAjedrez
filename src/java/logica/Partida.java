
package logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Partida {
    private Jugador[] jugadores;
    private Tablero tablero;
    private int numbJugadas; 
    private static Partida instancia;
    
    public Partida(){
        jugadores = new Jugador[2];
        tablero = new Tablero();      
        numbJugadas=1;
    }

    public Tablero getTablero() {
        return tablero;
    }
    
      /*
        DICCIONARIO DE NUMEROS
    1 = REY
    2 = REINA
    3 = ALFIL
    4 = CABALLO
    5 = TORRE
    6 = PEON   
    */ 
     public static Partida getInstancia()
    {
         if (instancia == null) {
             instancia = new Partida();
             instancia.empezar("player1", "player2");
            System.out.println("El objeto ha sido creado");
        }
        else {
            System.out.println("Ya existe el objeto");
        }
         return instancia;
    }
    public void empezar(String player1, String player2){
        // pide los nombres de los jugadores
        definirJugadores(player1,player2);
        //Pone las fichas en el tablero en las posiciones correspondientes
        //también crea las fichas que se utilizarian en una partida normal
        // y les asigna la posición correspondiente
        prepararPartidaNomal();
        //int a =0;
        /*do{
            imprimirTablero();
            turnos();
            imprimirTablero();
            a++;
        }while(a<10); */  
        imprimirTablero();
    }
    
    // se da a los juegadores las fichas con sus posiciones
    public void prepararPartidaNomal(){
        
        ArrayList<Ficha> fichasBlancas = new ArrayList<Ficha>();
        ArrayList<Ficha> fichasNegras = new ArrayList<Ficha>();

        Rey reyb = new Rey(new Point(0,4),"blanco");
        Rey reyn = new Rey(new Point(7,3),"negro");
        
        fichasBlancas.add(reyb);
        fichasNegras.add(reyn);
        tablero.getPosiBlancas()[0][4]=1;
        tablero.getTablero()[0][4]=1;
        tablero.getPosiNegras()[7][3]=1;
        tablero.getTablero()[7][3]=1;
        
        Reina rBlanca = new Reina (new Point (0,3),"blanco");
        Reina rNegra = new Reina (new Point (7,4),"negro");

        fichasBlancas.add(rBlanca);
        fichasNegras.add(rNegra);
        tablero.getPosiBlancas()[0][3]=2;
        tablero.getTablero()[0][3]=2;
        tablero.getPosiNegras()[7][4]=2;
        tablero.getTablero()[7][4]=2;
        
        
        Alfil alfilBlanco1 = new Alfil(new Point(0,2),"blanco");
        Alfil alfilBlanco2 = new Alfil(new Point(0,5),"blanco");
        Alfil alfilNegro1 = new Alfil(new Point(7,2),"negro");
        Alfil alfilNegro2 = new Alfil(new Point(7,5),"negro");
        
        fichasBlancas.add(alfilBlanco1);
        fichasBlancas.add(alfilBlanco2);
        fichasNegras.add(alfilNegro1);
        fichasNegras.add(alfilNegro2);
        
        tablero.getPosiBlancas()[0][2]=3;
        tablero.getPosiBlancas()[0][5]=3;
        tablero.getTablero()[0][2]=3;
        tablero.getTablero()[0][5]=3;
        
 
        tablero.getPosiNegras()[7][2]=3;
        tablero.getPosiNegras()[7][5]=3;
        tablero.getTablero()[7][2]=3;
        tablero.getTablero()[7][5]=3;     
        
        
        Caballo caballoBlanco1 = new Caballo(new Point(0,1),"blanco");
        Caballo caballoBlanco2 = new Caballo(new Point(0,6),"blanco");
        Caballo caballoNegro1 = new Caballo(new Point(7,1),"negro");
        Caballo caballoNegro2 = new Caballo(new Point(7,6),"negro");

        fichasBlancas.add(caballoBlanco1);
        fichasBlancas.add(caballoBlanco2);
        fichasNegras.add(caballoNegro1);
        fichasNegras.add(caballoNegro2);
        
        tablero.getPosiBlancas()[0][1]=4;
        tablero.getPosiBlancas()[0][6]=4;
        tablero.getTablero()[0][6]=4;
        tablero.getTablero()[0][1]=4;
 
        tablero.getPosiNegras()[7][1]=4;
        tablero.getPosiNegras()[7][6]=4;
        tablero.getTablero()[7][6]=4;
        tablero.getTablero()[7][1]=4;
                
           
        Torre torreBlanca1 = new Torre(new Point(0,0), "blanco");
        Torre torreBlanca2 = new Torre(new Point(0,7), "blanco");
        Torre torreNegra1 = new Torre(new Point(7,7), "negro");
        Torre torreNegra2 = new Torre(new Point(7,0), "negro");

        
        fichasBlancas.add(torreBlanca1);
        fichasBlancas.add(torreBlanca2);
        fichasNegras.add(torreNegra1);
        fichasNegras.add(torreNegra2);
          
        tablero.getPosiBlancas()[0][0]=5;
        tablero.getPosiBlancas()[0][7]=5;
        tablero.getTablero()[0][0]=5;
        tablero.getTablero()[0][7]=5;
 
        tablero.getPosiNegras()[7][7]=5;
        tablero.getPosiNegras()[7][0]=5;
        tablero.getTablero()[7][7]=5;
        tablero.getTablero()[7][0]=5;
        
        
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(new Point(1,i),"blanco");
            fichasBlancas.add(peon);
            tablero.getPosiBlancas()[1][i]=6;
            tablero.getTablero()[1][i]=6;
        }
       
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(new Point(6,i),"negro");
            fichasNegras.add(peon);
            tablero.getPosiNegras()[6][i]=6;
            tablero.getTablero()[6][i]=6;
        }
        
        jugadores[0].setFichas(fichasBlancas);
        jugadores[1].setFichas(fichasNegras);
    } 
    
    public void definirJugadores(String player1, String player2){
                jugadores[0]=new Jugador(player1, "blanco");

                jugadores[1]=new Jugador(player2,"negro");
           
    }
    


    // auxiliar
    public void imprimirTablero(){
        tablero.imprimirTablero();
    }
    
    public void turnos(){
        System.out.println("Bienvenido a la jugada n°: "+ numbJugadas);
        if(numbJugadas%2==0){
            System.out.println("Es el turno del jugador: "+ jugadores[1].getNickname());

            System.out.println("qué ficha quiere mover de las siguientes?");
            System.out.println("ingrese la posición en ");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(this.tablero.getPosiNegras()[i][j]!=0){
                        System.out.println("Pocición "+i+" tiene la siguientes posiciones");
                        System.out.println("en X = "+i+" Y= "+j);
                    }
                }
            }
            int x,y;
            System.out.println("Ingrese el valor de la coordenada en X: ");
            Scanner teclado = new Scanner(System.in);
            x = Integer.parseInt(teclado. nextLine());
            System.out.println("Ingrese el valor de la coordenada en Y: ");
            y = Integer.parseInt(teclado. nextLine());
            
            
            verMovimientos(1, new Point(x,y));        
            
        }else{
            System.out.println("Es el turno del jugador: "+ jugadores[0].getNickname());
            System.out.println("qué ficha quiere mover de las siguientes?");
            System.out.println("ingrese la posición en ");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(this.tablero.getPosiBlancas()[i][j]!=0){
                        System.out.println("Pocición "+i+" tiene la siguientes posiciones");
                        System.out.println("en X = "+i+" Y= "+j);
                    }
                }
            }  
            
            //ArrayList<Point> aux = jugadores[0].verMov(new Point(1,0), this.tablero);
            
            //for (int i = 0; i < aux.size(); i++) {
            //    System.out.println(aux.get(i));
            //}
            
            int x,y;
            System.out.println("Ingrese el valor de la coordenada en X: ");
            Scanner teclado = new Scanner(System.in);
            x = Integer.parseInt(teclado. nextLine());
            System.out.println("Ingrese el valor de la coordenada en Y: ");
            y = Integer.parseInt(teclado. nextLine());
            verMovimientos(0, new Point(x,y)); 

        }    
        this.numbJugadas+=1;
    }
    
    // realiza el movimiento de la ficha en el tablero y en la ficha 
    public void realizarMovimiento(int jugador, Point pinicial, Point pfinal, int nombre, Tablero t){
        // se hace el movimiento en el tablero
        t.movimiento(pinicial, pfinal, this.jugadores[jugador].getColor(), nombre);
        // se hace el movimiento en la posición de la ficha
        this.jugadores[jugador].realizarMov(pinicial, pfinal);
    }
    
    
    public ArrayList<Point> verMovimientos(int jugador, Point c){
        ArrayList<Point>  aux = jugadores[jugador].verMov(c, this.tablero);
        return aux;
        
    }
    
    // verifica si alguna ficha está haciendo jaque al rey
    // utiliza el tablero que está hasta el momento
    // devuelve verdadero si existe jaque 
    public boolean verificarJaque(int jugador, Tablero t){
        if(jugador==0){
            // se obtiene la posición del rey del jugador
            Point posiRey=jugadores[0].getPosiRey();
            // se crea un arraylist que va a contener los posibles movimientos de las fichas
            ArrayList<Point> aux = new ArrayList();
            // for que recorrera las fichas enemigas obteniendo sus posibles posiciones y revisando 
            // si alguna puede hacerle jaque al rey del jugador actual
            for (int i = 0; i < jugadores[1].getFichas().size(); i++) {
                // primero se le pide a las fichas que generen sus posibles movimientos segun el tablero que se les pasa
                jugadores[1].getFichas().get(i).movimiento(t);
                // se recogen los posibles movimientos que se generaron en la sentencia anterior
                aux = jugadores[1].getFichas().get(i).posiblesMov;
                // se verifica si alguna de las posibles posiciones de las fichas puede poner en jaque al rey
                for (int j = 0; j < aux.size(); j++) {
                    if(posiRey==aux.get(j)){
                        return true;
                    }
                }
            }
            return false;
            
        }else{
            // se obtiene la posición del rey del jugador
            Point posiRey=jugadores[1].getPosiRey();
            // se crea un arraylist que va a contener los posibles movimientos de las fichas
            ArrayList<Point> aux = new ArrayList();
            // for que recorrera las fichas enemigas obteniendo sus posibles posiciones y revisando 
            // si alguna puede hacerle jaque al rey del jugador actual
            for (int i = 0; i < jugadores[0].getFichas().size(); i++) {
                // primero se le pide a las fichas que generen sus posibles movimientos segun el tablero que se les pasa
                jugadores[0].getFichas().get(i).movimiento(t);
                // se recogen los posibles movimientos que se generaron en la sentencia anterior
                aux = jugadores[0].getFichas().get(i).posiblesMov;
                // se verifica si alguna de las posibles posiciones de las fichas puede poner en jaque al rey
                for (int j = 0; j < aux.size(); j++) {
                    if(posiRey==aux.get(j)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    
    // se verifica la posición puede hacer que alguna ficha del rival
    // pueda atacar al rey
    // es más completo que el de 
    public ArrayList<Point> verificarFuturo(int jugador, Point pinicial, Tablero t){
        // se crea un nuevo tablero que va a ser el imaginario
        Tablero auxTablero = new Tablero();
        // se le pasan las posiciones actuales del tablero
        auxTablero.setTablero(t.getTablero());
        auxTablero.setPosiBlancas(t.getPosiBlancas());
        auxTablero.setPosiNegras(t.getPosiNegras());
        // primero se obtienen los posibles movimientos de la ficha  que se quiere mover y se guardan
        // en un array list para verificar cada una de esas posiciones
        ArrayList<Point> aux = jugadores[jugador].verMov(pinicial, this.tablero);
        // se crea el array list a devolver con los posibles movimientos
        ArrayList<Point> pm = new ArrayList();
        // También se crea un punto para contener las posiciones iniciales que cambian en cada movimiento
        Point auxp = pinicial;
        // se obtiene el "nombre de la ficha" que le se va a cambiar la posición
        int nom=jugadores[jugador].preguntarNombre(pinicial);
        // se verifica que sea el jugador de fichas blancas y que los posibles movimientos en un principio
        // exista y no sean nulos               
        if(!aux.isEmpty()){
            // primero se ejecuta uno de los posibles movimientos en la ficha y el tablero
            for (int i = 0; i < aux.size(); i++) {
                // se reutiliza la función que realiza los movimientos en el tablero y en las fichas
                // del jugador
                realizarMovimiento(jugador, auxp, aux.get(i), nom, auxTablero);
                // como se va a verificar el jaque en el jugador que quiere hacer el movimiento, entonces
                // sera el que se paso por parametro
                // si no hay jaque en el tablero hipotetico
                if(!verificarJaque(jugador, auxTablero)){
                    pm.add(aux.get(i));
                }
                // se necesita la coordenada en la que se mueve la ficha para así quitarla del tablero
                // asi que se utiliza como posición inical del movimiento para la proxima validación
                auxp = aux.get(i);
            }   
            // la ficha vuleve a su posición inicial
            jugadores[jugador].realizarMov(aux.get(aux.size()), pinicial);
            return pm;        
        }
        return null;
    }
    
    // se ingresa el jugador del proximo turno y el tablero como quedo despues del movimiento del jugador
    // actual
    public boolean verificarJaqueMate(int jugador, Tablero t){
        // se obtienen los posibles movimientos del rey
        return verificarFuturo(jugador, jugadores[jugador].getPosiRey(), t).isEmpty(); // el rey todavía puede hacer alguna jugada
        // jaque mates        
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
    
}
