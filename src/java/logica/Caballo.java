
package logica;

import java.awt.Point;
import java.util.ArrayList;


public class Caballo extends Ficha {
    
    private int nombre=4;

    @Override
    public int getNombre(){
        return nombre;
    }
    
    public Caballo(Point p, String color){
        this.posicion=p;
        this.color=color;
        posiblesMov = new ArrayList();
    }
    
    @Override
    public void movimiento(Tablero tablero) {
        limpiarMovimientos();

        if(posicion.y-2>=0){
            if(posicion.x+1<=7){
                if(!tablero.preguntarAliado(new Point(posicion.x + 1, posicion.y - 2), this.color)){
                    posiblesMov.add(new Point(posicion.x + 1, posicion.y-2));
                }
            }
            if(posicion.x-1>=0){
                if(!tablero.preguntarAliado(new Point(posicion.x - 1, posicion.y - 2), this.color)){
                    posiblesMov.add(new Point(posicion.x - 1, posicion.y-2));
                }
            }
                       
        }
        
        if(posicion.y+2<=7){
            if(posicion.x+1<=7){
                if(!tablero.preguntarAliado(new Point(posicion.x + 1, posicion.y + 2), this.color)){
                    posiblesMov.add(new Point(posicion.x + 1, posicion.y+2));
                }
            }
            if(posicion.x-1>=0){
                if(!tablero.preguntarAliado(new Point(posicion.x - 1, posicion.y + 2), this.color)){
                    posiblesMov.add(new Point(posicion.x - 1, posicion.y+2));
                }
            }
                       
        } 
       
        if(posicion.x+2<=7){
            if(posicion.y+1<=7){
                if(!tablero.preguntarAliado(new Point(posicion.x + 2, posicion.y + 1), this.color)){
                    posiblesMov.add(new Point(posicion.x + 2, posicion.y+1));
                }
            }
            if(posicion.y-1>=0){
                if(!tablero.preguntarAliado(new Point(posicion.x + 2, posicion.y - 1), this.color)){
                    posiblesMov.add(new Point(posicion.x + 2, posicion.y - 1));
                }

            }           
        }
        
         if(posicion.x-2>=0){
            if(posicion.y+1<=7){
                if(!tablero.preguntarAliado(new Point(posicion.x - 2, posicion.y + 1), this.color)){
                    posiblesMov.add(new Point(posicion.x - 2, posicion.y + 1));
                }
            }
            if(posicion.y-1>=0){
                if(!tablero.preguntarAliado(new Point(posicion.x - 2, posicion.y - 1), this.color)){
                    posiblesMov.add(new Point(posicion.x - 2, posicion.y - 1));
                }
            }
        }
        
    }
}
