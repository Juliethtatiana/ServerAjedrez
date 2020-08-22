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
public class Peon extends Ficha{
    private boolean primerMov = false;
    public Peon(String color) {
        super(color,'P');
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero tablero) {
         pm.clear();
          // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
        if(color=="blanco"){
            // MOVIMIENTOS EN LINEA RECTA
            if(primerMov==false){
                if(!tablero.preguntarAliado(new Point(coordenada.x+2,coordenada.y), color)){
                    if(!tablero.preguntarAliado(new Point(coordenada.x+1,coordenada.y), color)){
                        if(!tablero.preguntar(new Point(coordenada.x+2,coordenada.y), color)){
                            if(!tablero.preguntar(new Point(coordenada.x+1,coordenada.y), color)){
                                pm.add(new Point(coordenada.x+2,coordenada.y));
                                
                            }
                         // se habilita el primer movimento de dos casillas si no hay alidos u enemigos alli                       
                        }
                    }   
                }  
            }          
            
            // MOVIMIENTO CAPTURA AL PASO.
            // se necesita estar en la fila 4 (Empieza a contar desde 0)
            /*
            if(posicion.y==4){
                // verifica si hay una ficha del equipo negro al lado de esta ficha
                if(posicion.x<7){
                    // se pregunta si hay un peon en la posiciÃ³n de al lado
                    // se dirige a la esquina derecha
                    if(capturaPaso(new Point(posicion.x+1,posicion.y))){
                        posiblesMov.add(new Point(posicion.x+1,posicion.y+1));
                    } 
                }
                if(posicion.x>0){
                    // se pregunta si hay un peon en la posiciÃ³n de al lado
                    // se dirige en la direcciÃ³n (0,7) esquina izquierda
                    if(capturaPaso(new Point(posicion.x-1,posicion.y)==true){
                        posiblesMov.add(new Point(posicion.x-1,posicion.y+1));
                    }  
                }                    
            }
             */ 
           
            // posiciÃ³n en Y se le suma 1 posiciÃ³n en el eje y
            // verifica si hay un aliado en la casilla siguiente
            // si esta no puede moverse alli
            if(coordenada.x<7){
                               // System.out.println("entro 1");
                if(!tablero.preguntarAliado(new Point(coordenada.x+1,coordenada.y), color)){
                                                     //   System.out.println("entro 2");

                    if(!tablero.preguntar(new Point(coordenada.x+1,coordenada.y), color)){
                                                       //          System.out.println("entro 3");

                        pm.add(new Point(coordenada.x+1,coordenada.y));
                    }
                }
            }
            
            // MOVIMIENTOS EN DIAGONAL
            // las posiciones del tablero van de 0 a 7 (para concordar con una matriz)
            // validan si la ficha esta en alguna de las dos esquinas (0,7) y (7,7)
            // no era tan necesario validarlo pero bueno
            if(coordenada.x<7 && coordenada.y<7){
                if(tablero.preguntar(new Point(coordenada.x+1,coordenada.y+1), color)){
                    pm.add(new Point(coordenada.x+1,coordenada.y+1));
                }
            }
            if(coordenada.x>0 && coordenada.y<7){
                if(tablero.preguntar(new Point(coordenada.x+1,coordenada.y), color)){
                    pm.add(new Point(coordenada.x+1,coordenada.y-1));
                }
            }
              
        }else{
            //---------------------------------------------------------------------------------------
            // LO SIGUIENTE ES PARA LAS FICHAS NEGRAS QUE SE DIRIGEN HACIA ABAJO
            // MOVIMIENTOS EN LINEA RECTA
            if(primerMov==false){
                // se habilita el primer movimento de dos casillas
                if(!tablero.preguntarAliado(new Point(coordenada.x-2,coordenada.y), color)){
                    if(!tablero.preguntarAliado(new Point(coordenada.x-1,coordenada.y), color)){
                        if(!tablero.preguntar(new Point(coordenada.x-2,coordenada.y), color)){
                            if(!tablero.preguntar(new Point(coordenada.x-1,coordenada.y), color)){
                                pm.add(new Point(coordenada.x-2,coordenada.y));
                               
                            }
                         // se habilita el primer movimento de dos casillas si no hay alidos u enemigos alli                       
                        }
                    }   
                }
            }           
            
            
            // posiciÃ³n en Y se le resta 1 posiciÃ³n 
             if(coordenada.x>0){
                if(!tablero.preguntarAliado(new Point(coordenada.x-1,coordenada.y), color)){
                    if(!tablero.preguntar(new Point(coordenada.x-1,coordenada.y), color)){
                        pm.add(new Point(coordenada.x-1,coordenada.y));
                    }
                }
            }
            /*
            // MOVIMIENTO CAPTURA AL PASO.
            // se necesita estar en la fila 3 
            if(posicion.y==3){
                // verifica si hay una ficha del equipo negro al lado de esta ficha
                if(posicion.x>0){
                     // se pregunta si hay un peon en la posiciÃ³n de al lado
                     // se mueve hacia el suroeste hacia el (0,0)
                     if(capturaPaso(new Point(posicion.x-1,posicion.y)==true){
                        posiblesMov.add(new Point(posicion.x-1,posicion.y-1));
                    } 
                }
                // se mueve hacia el sureste hacia el (7,0)
                if(posicion.x<7 && posicion.y>0){                  
                    // se pregunta si hay un peon en la posiciÃ³n de al lado
                    if(capturaPaso(new Point(posicion.x+1,posicion.y)==true){
                        posiblesMov.add(new Point(posicion.x+1,posicion.y-1));
                    } 
                }
                 
            }
            Â¨*/

            //  MOVIMIENTOS EN DIAGONAL
            // las posiciones del tablero van de 0 a 7 (para concordar con una matriz)
            // verifica si hay un enemigo en la diagonal
            if(coordenada.x>0 && coordenada.y>0){
                if(tablero.preguntar(new Point(coordenada.x-1,coordenada.y-1), color)){
                    pm.add(new Point(coordenada.x-1,coordenada.y-1));
                }
            }
            if(coordenada.x>0 && coordenada.y<7){
                System.out.println("entro");
                if(tablero.preguntar(new Point(coordenada.x-1,coordenada.y+1), color)){
                   pm.add(new Point(coordenada.x-1,coordenada.y+1));
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
        this.primerMov=true;
    }
}
