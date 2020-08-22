/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;


public class Caballo extends Ficha {
    
    public Caballo(String color) {
        super(color,'C');
    }

    
    public ArrayList<Point> posiblesMovimientos(Tablero tablero) {
        pm.clear();
        if(coordenada.y-2>=0){
            if(coordenada.x+1<=7){
                if(!tablero.preguntarAliado(new Point(coordenada.x + 1, coordenada.y - 2), this.color)){
                    pm.add(new Point(coordenada.x + 1, coordenada.y-2));
                }
            }
            if(coordenada.x-1>=0){
                if(!tablero.preguntarAliado(new Point(coordenada.x - 1, coordenada.y - 2), this.color)){
                    pm.add(new Point(coordenada.x - 1, coordenada.y-2));
                }
            }
                       
        }
        
        if(coordenada.y+2<=7){
            if(coordenada.x+1<=7){
                if(!tablero.preguntarAliado(new Point(coordenada.x + 1, coordenada.y + 2), this.color)){
                    pm.add(new Point(coordenada.x + 1, coordenada.y+2));
                }
            }
            if(coordenada.x-1>=0){
                if(!tablero.preguntarAliado(new Point(coordenada.x - 1, coordenada.y + 2), this.color)){
                    pm.add(new Point(coordenada.x - 1, coordenada.y+2));
                }
            }
                       
        } 
       
        if(coordenada.x+2<=7){
            if(coordenada.y+1<=7){
                if(!tablero.preguntarAliado(new Point(coordenada.x + 2, coordenada.y + 1), this.color)){
                    pm.add(new Point(coordenada.x + 2, coordenada.y+1));
                }
            }
            if(coordenada.y-1>=0){
                if(!tablero.preguntarAliado(new Point(coordenada.x + 2, coordenada.y - 1), this.color)){
                    pm.add(new Point(coordenada.x + 2, coordenada.y - 1));
                }

            }           
        }
        
         if(coordenada.x-2>=0){
            if(coordenada.y+1<=7){
                if(!tablero.preguntarAliado(new Point(coordenada.x - 2, coordenada.y + 1), this.color)){
                    pm.add(new Point(coordenada.x - 2, coordenada.y + 1));
                }
            }
            if(coordenada.y-1>=0){
                if(!tablero.preguntarAliado(new Point(coordenada.x - 2, coordenada.y - 1), this.color)){
                    pm.add(new Point(coordenada.x - 2, coordenada.y - 1));
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
        
    }
}
