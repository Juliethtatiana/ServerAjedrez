
package logica;

import java.awt.Point;
import java.util.ArrayList;


public class Reina extends Ficha {
    
    private int nombre=2;

    @Override
    public int getNombre(){
        return nombre;
    }

    public Reina(Point p, String color){
        this.posicion= p;
        this.color = color;
        posiblesMov = new ArrayList();
    }
    
    
    @Override
    public void movimiento (Tablero tablero) {
        limpiarMovimientos();


        // MOVIMIENTOS DE LA TORRE    
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
            
       // MOVIMIENTOS DEL ALFIL
        for(int i =1 ; i<8;i++){
                if(posicion.x+i<=7 && posicion.y+i<=7){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x+i,posicion.y+i), color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x+i,posicion.y+i),color )){
                                posiblesMov.add(new Point(posicion.x+i,posicion.y+i));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x+i,posicion.y+i));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        
            //---------------------SE DIRIGE A LA ESQUINA SUPERIOR IZQUIERDA
            //se le suma a y y resta a x
            for(int i =1 ; i<8;i++){
                System.out.println("llegamos");
                if(posicion.x-i>=0 && posicion.y+i<=7){
                    System.out.println("se llego");
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x-i,posicion.y+i),color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x-i,posicion.y+i),color )){
                                posiblesMov.add(new Point(posicion.x-i,posicion.y+i));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x-i,posicion.y+i));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }   

        //---------------------SE DIRIGE A LA ESQUINA INFERIOR IZQUIERDA
            //se le RESTA a Y y RESTA a X
            for(int i =1 ; i<8;i++){
                if(posicion.x-i>=0 && posicion.y-i>=0){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x-i,posicion.y-i), color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x-i,posicion.y-i),color )){
                                posiblesMov.add(new Point(posicion.x-i,posicion.y-i));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x-i,posicion.y-i));
                                break;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }  


             //---------------------SE DIRIGE A LA ESQUINA INFERIOR DERECHA
            //se le RESTA a Y y SUMA a X

            for(int i =1 ; i<8;i++){
                if(posicion.x+i<=7 && posicion.y-i>=0){
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x+i,posicion.y-i), color)){
                        //si no hay ninguna fihca enemiga en la posición
                        if(!tablero.preguntar(new Point(posicion.x+i,posicion.y-i),color )){
                                posiblesMov.add(new Point(posicion.x+i,posicion.y-i));
                        }else{
                            // hay un enemigo ahí, se añade la posición y termina el bucle.
                                posiblesMov.add(new Point(posicion.x+i,posicion.y-i));
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
