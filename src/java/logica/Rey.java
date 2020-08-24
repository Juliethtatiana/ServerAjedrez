
package logica;

import java.awt.Point;
import java.util.ArrayList;


public class Rey extends Ficha {
    
    
    private int nombre=1;
    private boolean primerMov = false;
    
    @Override
    public int getNombre(){
        return nombre;
    }
    
    
    public boolean getPriMov(){
        return primerMov;
    }
    
    
    public Rey(Point p, String color){
        this.posicion= p;
        this.color = color;
        posiblesMov = new ArrayList();
    }
/*
    COMO ESTARÍA EL TABLERO EN LA MATRIZ
    Y   7|PN|PN|PN|PN|PN|PN|PN|PN|
        6|TN|CN|AN|RN|RN|AN|CN|TN|
        5|  |  |  |  |  |  |  |  |
        4|  |  |  |  |  |  |  |  |
        3|  |  |  |  |  |  |  |  |
        2|  |  |  |  |  |  |  |  |
        1|PB|PB|PB|PB|PB|PB|PB|PB|
        0|TB|CB|AB|RB|RB|AB|CB|TB|
            0  1  2  3  4  5  6  7
                                X
*/
    @Override
    public void movimiento(Tablero tablero) {
        // se limpian los movimientos
        limpiarMovimientos();

        
        // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
        /*
        // MOVIMIENTOS EN LINEA RECTA
        if (primerMov == false) {
            if(){
                
            }
       
                if(!tablero.preguntarAliado(new Point(posicion.x+2,posicion.y), color)){
                    if(!tablero.preguntarAliado(new Point(posicion.x+1,posicion.y), color)){
                        if(!tablero.preguntar(new Point(posicion.x+2,posicion.y), color)){
                            if(!tablero.preguntar(new Point(posicion.x+1,posicion.y), color)){
                                posiblesMov.add(new Point(posicion.x+2,posicion.y));
                                primerMov=true;
                            }
                         // se habilita el primer movimento de dos casillas si no hay alidos u enemigos alli                       
                        }
                    }   
                }  
             
        }
        */  
        // posición en Y se le suma 1 posición en el eje y
        // verifica si hay un aliado en la casilla siguiente
        // si esta no puede moverse alli
        //-------------MOVIMIENTOS EN LINEA RECTA-------------------------------
        // DERECHA
        if (posicion.x + 1 <= 7) {
            // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí) 
            System.out.println("111111");
            if (!tablero.preguntarAliado(new Point(posicion.x + 1, posicion.y), this.color)) {
                            System.out.println("11222222222222222222");
                //si no hay ninguna fihca enemiga en la posición
                if (!tablero.preguntar(new Point(posicion.x + 1, posicion.y), this.color)) {
                    posiblesMov.add(new Point(posicion.x + 1, posicion.y));
                                System.out.println("133333333333333333331");
                } else {
                    // hay un enemigo ahí, se añade la posición y termina el bucle.
                    posiblesMov.add(new Point(posicion.x + 1, posicion.y));
                }
            }
        }
        // IZQUIERDA

        if (posicion.x - 1 >= 0) {
            // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
            if (!tablero.preguntarAliado(new Point(posicion.x - 1, posicion.y), this.color)) {
                //si no hay ninguna fihca enemiga en la posición
                if (!tablero.preguntar(new Point(posicion.x - 1, posicion.y), color)) {
                    posiblesMov.add(new Point(posicion.x - 1, posicion.y));
                } else {
                    // hay un enemigo ahí, se añade la posición y termina el bucle.
                    posiblesMov.add(new Point(posicion.x - 1, posicion.y));                  
                }
            }              
        } 
    
        if (posicion.y - 1 >= 0) {
            // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
            if (!tablero.preguntarAliado(new Point(posicion.x, posicion.y - 1), color)) {
                //si no hay ninguna fihca enemiga en la posición
                if (!tablero.preguntar(new Point(posicion.x, posicion.y - 1), color)) {
                    posiblesMov.add(new Point(posicion.x, posicion.y - 1));
                } else {
                    // hay un enemigo ahí, se añade la posición y termina el bucle.
                    posiblesMov.add(new Point(posicion.x, posicion.y - 1));
                }
            } 
        }
        
        if (posicion.y + 1 <= 7) {
            // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
            if (!tablero.preguntarAliado(new Point(posicion.x, posicion.y + 1), color)) {
                //si no hay ninguna fihca enemiga en la posición
                if (!tablero.preguntar(new Point(posicion.x, posicion.y + 1), color)) {
                    posiblesMov.add(new Point(posicion.x, posicion.y + 1));
                } else {
                    // hay un enemigo ahí, se añade la posición y termina el bucle.
                    posiblesMov.add(new Point(posicion.x, posicion.y + 1));
                }
            } 
        }
    
         
    }
}
