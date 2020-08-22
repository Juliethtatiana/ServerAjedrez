
package logica;

import java.awt.Point;


public class Ajedrez {

    public Tablero tablero;
    private Jugador jugadores[];
    private GestorMovimientos gestor;
    public Ajedrez(){
        jugadores = new Jugador[2];
        jugadores[0]= new Jugador(true,"blanco");
        jugadores[1]= new Jugador(false,"negro");
        
    }

    
    public void iniciarPartida(){
        tablero= new Tablero(jugadores[0],jugadores[1]);
        tablero.imprimirTablero();
        gestor= new GestorMovimientos(this);
    }
    public boolean hacerMovimiento(int jugador, int x1, int y1,int x2, int y2){
        return gestor.moverFicha(jugadores[jugador],new Point(x1, y1),new Point(x2, y2));
        //tablero.moverFicha(jugador,new Point(x1, y1),new Point(x2, y2));
        
    }
    
    public boolean CalcularMovimiento(int jugador, int x1, int y1){
        return gestor.calcularPosMov(jugadores[jugador],new Point(x1, y1));
        //tablero.moverFicha(jugador,new Point(x1, y1),new Point(x2, y2));
        
    }
    
    
//    public void calcularPosMov(int x, int y){
//       
//       gestor.calcularPosMov(0, new Point(x, y));
//    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}
