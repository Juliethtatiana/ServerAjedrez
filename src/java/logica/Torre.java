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
public class Torre extends Ficha{

    public Torre(String color) {
        super(color,'T');
    }



    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero tablero) {
        pm.clear();
        /*
        COMO LOS ALFILES VAN EN TODAS LAS DIRECCIONES NO ES NECESARIO CAMBIAR LOS MÃ‰TODOS SEGUN SU COLOR
       
        if (primerMov==false){
            
        }
        
        
         */ 
        
          // SE SUPONE QUE LAS BLANCAS VAN DE ABAJO HACIA ARRIBA
            // verifica si hay un aliado en la casilla siguiente
            // si esta no puede moverse alli
            // no esta en ningun borde del tablero
            
            //---------------------SE DIRIGE hacia  LA DERECHA
            for(int i =1 ; i<8;i++){
                if(coordenada.x+i<=7){
                   // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
                    if(!tablero.preguntarAliado(new Point(coordenada.x+i,coordenada.y),color)){
                        //si no hay ninguna fihca enemiga en la posiciÃ³n
                        if(!tablero.preguntar(new Point(coordenada.x+i,coordenada.y),color )){
                                pm.add(new Point(coordenada.x+i,coordenada.y));
                        }else{
                            // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                                pm.add(new Point(coordenada.x+i,coordenada.y));
                           
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
                if(coordenada.x-i>=0){
                   // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
                    if(!tablero.preguntarAliado(new Point(coordenada.x-i,coordenada.y),color)){
                        //si no hay ninguna fihca enemiga en la posiciÃ³n
                        if(!tablero.preguntar(new Point(coordenada.x-i,coordenada.y),color )){
                                pm.add(new Point(coordenada.x-i,coordenada.y));
                        }else{
                            // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                                pm.add(new Point(coordenada.x-i,coordenada.y));       
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
                if(coordenada.y-i>=0){
                   // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
                    if(!tablero.preguntarAliado(new Point(coordenada.x,coordenada.y-i),color)){
                        //si no hay ninguna fihca enemiga en la posiciÃ³n
                        if(!tablero.preguntar(new Point(coordenada.x,coordenada.y-i),color )){
                                pm.add(new Point(coordenada.x,coordenada.y-i));
                        }else{
                            // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                                pm.add(new Point(coordenada.x,coordenada.y-i));
                               
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
               // se mueve EN LA DIRECCIÃ“N DE +Y
               if(coordenada.y+i<=7){
                // no hay ninguna ficha aliada en la posiciÃ³n  (devuelve true si hay alguna ficha ahÃ­)                     
                if(!tablero.preguntarAliado(new Point(coordenada.x,coordenada.y+i),color)){
                    //si no hay ninguna fihca enemiga en la posiciÃ³n
                    if(!tablero.preguntar(new Point(coordenada.x,coordenada.y+i),color )){
                            pm.add(new Point(coordenada.x,coordenada.y+i));
                    }else{
                        // hay un enemigo ahÃ­, se aÃ±ade la posiciÃ³n y termina el bucle.
                            pm.add(new Point(coordenada.x,coordenada.y+i));
                            
                    }
                    }else{
                        break;
                    }
                }else{
                    break;
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
