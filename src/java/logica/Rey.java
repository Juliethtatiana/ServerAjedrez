/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Tatiana
 */
public class Rey extends Ficha{

    private boolean primerMov = false;
    private boolean jaque=false;
    
    public Rey(String color) {
        super(color,'K');
    }

  public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
        primerMov = true;
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero tablero) {
        pm.clear();
        // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA

        // MOVIMIENTOS EN LINEA RECTA
        if (primerMov== false) {
            /*
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
             */
        }

        // posiciÃ³n en Y se le suma 1 posiciÃ³n en el eje y
        // verifica si hay un aliado en la casilla siguiente
        // si esta no puede moverse alli
        //-------------MOVIMIENTOS EN LINEA RECTA-------------------------------
        // DERECHA
        if (coordenada.x + 1 <= 7) {
            // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­) 
            //System.out.println("111111");
            if (!tablero.preguntarAliado(new Point(coordenada.x + 1, coordenada.y), this.color)) {
                           // System.out.println("11222222222222222222");
                //si no hay ninguna fihca enemiga en la posiciÃ³n
                if (!tablero.preguntar(new Point(coordenada.x + 1, coordenada.y), this.color)) {
                    pm.add(new Point(coordenada.x + 1, coordenada.y));
                             //   System.out.println("133333333333333333331");
                } else {
                    // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                    pm.add(new Point(coordenada.x + 1, coordenada.y));
                }
            }
        }
        // IZQUIERDA

        if (coordenada.x - 1 >= 0) {
            // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
            if (!tablero.preguntarAliado(new Point(coordenada.x - 1, coordenada.y), this.color)) {
                //si no hay ninguna fihca enemiga en la posiciÃ³n
                if (!tablero.preguntar(new Point(coordenada.x - 1, coordenada.y), color)) {
                    pm.add(new Point(coordenada.x - 1, coordenada.y));
                } else {
                    // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                    pm.add(new Point(coordenada.x - 1, coordenada.y));                  
                }
            }              
        } 
    
        if (coordenada.y - 1 >= 0) {
            // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
            if (!tablero.preguntarAliado(new Point(coordenada.x, coordenada.y - 1), color)) {
                //si no hay ninguna fihca enemiga en la posiciÃ³n
                if (!tablero.preguntar(new Point(coordenada.x, coordenada.y - 1), color)) {
                    pm.add(new Point(coordenada.x, coordenada.y - 1));
                } else {
                    // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                    pm.add(new Point(coordenada.x, coordenada.y - 1));
                }
            } 
        }
        
        if (coordenada.y + 1 <= 7) {
            // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
            if (!tablero.preguntarAliado(new Point(coordenada.x, coordenada.y + 1), color)) {
                //si no hay ninguna fihca enemiga en la posiciÃ³n
                if (!tablero.preguntar(new Point(coordenada.x, coordenada.y + 1), color)) {
                    pm.add(new Point(coordenada.x, coordenada.y + 1));
                } else {
                    // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                    pm.add(new Point(coordenada.x, coordenada.y + 1));
                }
            } 
        }
        return pm;
    }

    @Override
    public void EjecutaranimacionMatar(String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EjecutaranimacionMover(String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrimerMov() {
        this.primerMov =true;
    }
    
}
