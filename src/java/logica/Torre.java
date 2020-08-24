package logica;

import java.awt.Point;
import java.util.ArrayList;

public class Torre extends Ficha {

    private int nombre=5;
    private boolean primerMov = false;

    @Override
    public int getNombre(){
        return nombre;
    }
    
     // función para ponerle a la torre falso desde afuera
    public void setMov(boolean mov){
        primerMov=mov;
    }
    
    public Torre(Point p, String color){   
        this.posicion=p;
        this.color=color;
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

      // SACA TODOS LOS POSIBLES MOVIMIENTOS INCLUSO LOS DE ATAQUE
      
    @Override
    public void movimiento (Tablero tablero) {
            limpiarMovimientos();

    
          // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
            // verifica si hay un aliado en la casilla siguiente
            // si esta no puede moverse alli
            // no esta en ningun borde del tablero
            
            //---------------------SE DIRIGE hacia  LA DERECHA
            for(int i =1 ; i<8;i++){
                if(posicion.x+i<=7){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x+i,posicion.y),this.color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x+i,posicion.y),this.color )){
                                posiblesMov.add(new Point(posicion.x+i,posicion.y));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x+i,posicion.y));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
     
            }
             
           
             
            //se dirige hacia la izquierda
            for(int i =1 ; i<8;i++){
                if(posicion.x-i>=0){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x-i,posicion.y),this.color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x-i,posicion.y),color )){
                                posiblesMov.add(new Point(posicion.x-i,posicion.y));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x-i,posicion.y));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }   
        
        //---------------------SE DIRIGE hacia abajo
            //se le RESTA a Y
            for(int i =1 ; i<8;i++){
                if(posicion.y-i>=0){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x,posicion.y-i),color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x,posicion.y-i),color )){
                                posiblesMov.add(new Point(posicion.x,posicion.y-i));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x,posicion.y-i));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }  

             //---------------------SE DIRIGE A haci ARRIBA
            //se le RESTA a Y y SUMA a X

            for(int i =1 ; i<8;i++){
               // se mueve EN LA DIRECCIÓN DE +Y
               if(posicion.y+i<=7){
                // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                if(!tablero.preguntarAliado(new Point(posicion.x,posicion.y+i),color)){
                    //si no hay ninguna fihca enemiga en la posición
                    if(!tablero.preguntar(new Point(posicion.x,posicion.y+i),color )){
                            posiblesMov.add(new Point(posicion.x,posicion.y+i));
                    }else{
                        // hay un enemigo ahí, se añade la posición y termina el bucle.
                            posiblesMov.add(new Point(posicion.x,posicion.y+i));
                            break;
                    }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }  
    }



}
  

