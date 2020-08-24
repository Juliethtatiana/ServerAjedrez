package logica;


import java.awt.Point;
import java.util.ArrayList;

public class Peon extends Ficha {

    private int nombre=6;
    private boolean primerMov = false;

    @Override
     public int getNombre(){
        return nombre;
    }
    
    // función para ponerle a la torre falso desde afuera
    public void setMov(boolean mov){
        primerMov=mov;
    }

    public Peon(Point p,String color){
        this.posicion=p;
        this.color=color;
        posiblesMov = new ArrayList();
    }

    // SACA TODOS LOS POSIBLES MOVIMIENTOS INCLUSO LOS DE ATAQUE

    @Override
    public void movimiento (Tablero tablero) {
        limpiarMovimientos();

       //posiblesMov=null;
        // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
        if(color=="blanco"){
            // MOVIMIENTOS EN LINEA RECTA
            if(primerMov==false){
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
            
        
            if(posicion.x<7){

                if(!tablero.preguntarAliado(new Point(posicion.x+1,posicion.y), color)){

                    if(!tablero.preguntar(new Point(posicion.x+1,posicion.y), color)){
                        posiblesMov.add(new Point(posicion.x+1,posicion.y));
                    }
                }
            }
            
            // MOVIMIENTOS EN DIAGONAL
            // las posiciones del tablero van de 0 a 7 (para concordar con una matriz)
            // validan si la ficha esta en alguna de las dos esquinas (0,7) y (7,7)
            // no era tan necesario validarlo pero bueno
            
            if(posicion.x<7 && posicion.y<7){
                if(tablero.preguntar(new Point(posicion.x+1,posicion.y+1), color)){
                    posiblesMov.add(new Point(posicion.x+1,posicion.y+1));
                }
            }
            if(posicion.x<7 && posicion.y>0){
                if(tablero.preguntar(new Point(posicion.x+1,posicion.y-1), color)){
                    posiblesMov.add(new Point(posicion.x+1,posicion.y-1));
                }
            }
        }else{
            //---------------------------------------------------------------------------------------
            // LO SIGUIENTE ES PARA LAS FICHAS NEGRAS QUE SE DIRIGEN HACIA ABAJO
            // MOVIMIENTOS EN LINEA RECTA
            if(primerMov==false){
                // se habilita el primer movimento de dos casillas
                if(!tablero.preguntarAliado(new Point(posicion.x-2,posicion.y), color)){
                    if(!tablero.preguntarAliado(new Point(posicion.x-1,posicion.y), color)){
                        if(!tablero.preguntar(new Point(posicion.x-2,posicion.y), color)){
                            if(!tablero.preguntar(new Point(posicion.x-1,posicion.y), color)){
                                posiblesMov.add(new Point(posicion.x-2,posicion.y));
                                primerMov=true;
                            }
                         // se habilita el primer movimento de dos casillas si no hay alidos u enemigos alli                       
                        }
                    }   
                }
            }           
            
            
            // posición en Y se le resta 1 posición 
             if(posicion.x>0){
                if(!tablero.preguntarAliado(new Point(posicion.x-1,posicion.y), color)){
                    if(!tablero.preguntar(new Point(posicion.x-1,posicion.y), color)){
                        posiblesMov.add(new Point(posicion.x-1,posicion.y));
                    }
                }
            }
            /*
            // MOVIMIENTO CAPTURA AL PASO.
            // se necesita estar en la fila 3 
            if(posicion.y==3){
                // verifica si hay una ficha del equipo negro al lado de esta ficha
                if(posicion.x>0){
                     // se pregunta si hay un peon en la posición de al lado
                     // se mueve hacia el suroeste hacia el (0,0)
                     if(capturaPaso(new Point(posicion.x-1,posicion.y)==true){
                        posiblesMov.add(new Point(posicion.x-1,posicion.y-1));
                    } 
                }
                // se mueve hacia el sureste hacia el (7,0)
                if(posicion.x<7 && posicion.y>0){                  
                    // se pregunta si hay un peon en la posición de al lado
                    if(capturaPaso(new Point(posicion.x+1,posicion.y)==true){
                        posiblesMov.add(new Point(posicion.x+1,posicion.y-1));
                    } 
                }
                 
            }
            ¨*/

            //  MOVIMIENTOS EN DIAGONAL
            // las posiciones del tablero van de 0 a 7 (para concordar con una matriz)
            // verifica si hay un enemigo en la diagonal
            if(posicion.x>0 && posicion.y>0){
                if(tablero.preguntar(new Point(posicion.x-1,posicion.y-1), color)){
                    posiblesMov.add(new Point(posicion.x-1,posicion.y-1));
                }
            }
            if(posicion.x>0 && posicion.y<7){
                System.out.println("entro");
                if(tablero.preguntar(new Point(posicion.x-1,posicion.y+1), color)){
                   posiblesMov.add(new Point(posicion.x-1,posicion.y+1));
                }
            }
            
            
        }
    }

}