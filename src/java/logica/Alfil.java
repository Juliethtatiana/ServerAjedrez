package logica;

import java.awt.Point;
import java.util.ArrayList;

public class Alfil extends Ficha {

    private int nombre=3;

    @Override
    public int getNombre(){
        return this.nombre;
    }

    public Alfil(Point p, String color){
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

    @Override
    public void movimiento (Tablero tablero) {
        limpiarMovimientos();

        /*
        COMO LOS ALFILES VAN EN TODAS LAS DIRECCIONES NO ES NECESARIO CAMBIAR LOS MÉTODOS SEGUN SU COLOR
        */
          // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
            // verifica si hay un aliado en la casilla siguiente
            // si esta no puede moverse alli
            // no esta en ningun borde del tablero
            //---------------------SE DIRIGE A LA ESQUINA SUPERIOR DERECHA
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
            System.out.println("la posición es: ");
            System.out.println(posicion);
            for(int i =1 ; i<8;i++){
                System.out.println("llegamos");
                if(posicion.x-i>=0 && posicion.y+i<=7){
                    System.out.println("se llego");
                   // no hay ninguna ficha aliada en la posición  (devuelve true si hay alguna ficha ahí)                     
                    if(!tablero.preguntarAliado(new Point(posicion.x-i,posicion.y+i),color)){
                        System.out.println("falla");
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

            System.out.println("los posibles movimientos son");
                 for (int i = 0; i < posiblesMov.size(); i++) {
                     System.out.println(posiblesMov.get(i));
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
  

