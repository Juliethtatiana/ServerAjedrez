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
 * @author Admin
 */
public class GestorMovimientos {
    private boolean turno = true; // truepara fichas blancas y false para fichas negras
    private int numJugadas = 0;
    Ajedrez ajedrez;

    public GestorMovimientos(Ajedrez aj) {
        this.ajedrez=aj;
    }
    
    
  
    
     public boolean moverFicha(Jugador jugador,Point ini,Point destino){
         //System.out.print(ajedrez.tablero.tableroFichas[ini.x][ini.y].getColor());
         
          if(turno && jugador.getFichas().contains(ajedrez.tablero.tableroFichas[ini.x][ini.y])){
             System.out.println("la ficha que se va a mover es: "+ajedrez.tablero.tableroFichas[ini.x][ini.y].getTipo());
                 
                 ArrayList<Point> pm = ajedrez.tablero.tableroFichas[ini.x][ini.y].posiblesMovimientos( ajedrez.tablero);
       
                if(pm.isEmpty()){
                    System.out.println("ESTA FICHA NO  SE PUEDE MOVER");
                    return false;
                    
                }else{
                    if(pm.contains(destino)){
                        if(ajedrez.tablero.tableroFichas[destino.x][destino.y]!=null && "negro".equals(ajedrez.tablero.tableroFichas[destino.x][destino.y].getColor())){
                            System.out.println("MATAR FICHA COLOR NEGRO");
                            ajedrez.getJugadores()[1].AnadirFichaMuerta( ajedrez.tablero.tableroFichas[destino.x][destino.y]);
                        }
                        ajedrez.tablero.tableroFichas[ini.x][ini.y].setCoordenada(destino);
                        ajedrez.tablero.tableroFichas[destino.x][destino.y]=  ajedrez.tablero.tableroFichas[ini.x][ini.y];
                        ajedrez.tablero.tableroFichas[ini.x][ini.y]=null;
                        System.out.println(" -------------------");
                        ajedrez.tablero.tablero[ini.x][ini.y]=' ';
                        ajedrez.tablero.tableroFichas[destino.x][destino.y].setPrimerMov();
                        ajedrez.tablero.tablero[destino.x][destino.y]=ajedrez.tablero.tableroFichas[destino.x][destino.y].getTipo();
                        numJugadas++;
                        turno=false;
                        ajedrez.tablero.imprimirTablero();
                        System.out.print("***TURNO  CAMBIADO A  FICHAS NEGRAS**");
                    }else{
                        System.out.println("MOVIMIENTO  NO PERMITIDO");
                        return false;
                    }
                
            
                }
             
        }else{
            if(jugador.getFichas().contains(ajedrez.tablero.tableroFichas[ini.x][ini.y])){
                 System.out.println("la ficha que se va a mover es: "+ajedrez.tablero.tableroFichas[ini.x][ini.y].getTipo());
               
                 ArrayList<Point> pm = ajedrez.tablero.tableroFichas[ini.x][ini.y].posiblesMovimientos( ajedrez.tablero);
                if(pm.isEmpty()){
                    System.out.println("ESTA FICHA NO  SE PUEDE MOVER");
                    
                }else{
                    
                    if(pm.contains(destino)){
                        if(ajedrez.tablero.tableroFichas[destino.x][destino.y]!=null && "blanco".equals(ajedrez.tablero.tableroFichas[destino.x][destino.y].getColor())){
                            System.out.println("MATAR FICHA COLOR BLANCO");
                            ajedrez.getJugadores()[0].AnadirFichaMuerta( ajedrez.tablero.tableroFichas[destino.x][destino.y]);
                        }
                            ajedrez.tablero.tableroFichas[ini.x][ini.y].setCoordenada(destino);
                            ajedrez.tablero.tableroFichas[destino.x][destino.y]=  ajedrez.tablero.tableroFichas[ini.x][ini.y];
                            ajedrez.tablero.tableroFichas[ini.x][ini.y]=null;
                            System.out.println(" -------------------");
                            ajedrez.tablero.tablero[ini.x][ini.y]=' ';
                            ajedrez.tablero.tablero[destino.x][destino.y]=ajedrez.tablero.tableroFichas[destino.x][destino.y].getTipo();
                            ajedrez.tablero.imprimirTablero();
                            numJugadas++;
                            turno=true;
                            System.out.print("***TURNO  CAMBIADO A  FICHAS BLANCAS**");
                        
                        
                    }else{
                        System.out.println("MOVIMIENTO  NO PERMITIDO");
                    }
                
            
                }
               
            }  
//              System.out.println("##Movimiento incorrecto  intente de nuevo ##");
        }
       return true;
                
                
    }
    public boolean calcularPosMov(Jugador  jugador,Point pos){ 
        if(jugador.getFichas().contains(ajedrez.tablero.tableroFichas[pos.x][pos.y])){
            ajedrez.tablero.tableroFichas[pos.x][pos.y].posiblesMovimientos(ajedrez.tablero);
            System.out.println("Los posibles movimientos que puedes hacer con la ficha: "+  ajedrez.tablero.tableroFichas[pos.x][pos.y].getTipo()+ " de color :"+ ajedrez.tablero.tableroFichas[pos.x][pos.y].getColor()+" son: ");
            ajedrez.tablero.tableroFichas[pos.x][pos.y].imprimirPosMov();
            return true;
        }else{
            System.out.println("LA FICHA NO  ES DEL EQUIPO");
            return false;
        }
        
    }
   
    
}
