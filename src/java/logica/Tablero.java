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
public class Tablero {
    public  char tablero[][]; //tablero de chars para imprimir en consola
    public Ficha tableroFichas[][]; //tablero de fichas para saber como estan organizadas en el tablero
    ArrayList<Ficha> fichasblancas;
    ArrayList<Ficha> fichasnegras;
    Ficha reyBlanco;
    Ficha reyNegro;
    public Tablero(Jugador player1, Jugador player2){
        fichasblancas = player1.getFichas();
        fichasnegras = player2.getFichas();
        PonerFichas();
    }
    public void PonerFichas(){
        tablero = new char[8][8];
        tableroFichas = new Ficha[8][8];
        int aux=15;
        ArrayList<Ficha> fichas= this.fichasblancas;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                tablero[i][j]= fichas.get(aux).getTipo();
                fichas.get(aux).setCoordenada(new Point(i, j));
                tableroFichas[i][j]= fichas.get(aux);
               if(i>5){
                   if(fichas.get(aux).getTipo() == 'K'){reyNegro = fichas.get(aux);}
                    aux++;
                  
               }else{
                   if(fichas.get(aux).getTipo() == 'K'){reyBlanco = fichas.get(aux);}
                   aux--;
               }
               
               
            }
            if(i==1){
                i=5;
                fichas=this.fichasnegras;
                aux=0;
            }
        }
       // System.out.print("la posicion del rey blanco es: " + reyBlanco.getCoordenada() + " la posicion del rey negro es: "+ reyNegro.getCoordenada());
        
    }
    public void imprimirTablero(){
        for (int x= tablero.length-1; x>=0; x--) {
            System.out.print("||");
            for (int y=0; y < tablero[x].length; y++) {
                System.out.print (tablero[x][y]);
                if (y!=tablero[x].length-1) System.out.print("\t");
            }
            System.out.println("||");
        }
    }
    public void moverFicha(int jugador,Point ini,Point destino){
        System.out.println("la ficha que se va a mover es: "+tableroFichas[ini.x][ini.y].getTipo());
                 ArrayList<Ficha> fichasEnemigas;
                 Ficha reyEnemigo;
                 ArrayList<Point> pm = tableroFichas[ini.x][ini.y].posiblesMovimientos(this);
                if(pm.isEmpty()){
                    System.err.println("ESTA FICHA NO  SE PUEDE MOVER");
                }else{
                    if(pm.contains(destino)){
                        if(jugador==0){
                          fichasEnemigas= fichasnegras;
                          reyEnemigo= reyNegro;
                        }else{
                          fichasEnemigas = fichasblancas;
                          reyEnemigo= reyBlanco;
                        }
                        if(verificarJaque(fichasEnemigas, reyEnemigo.getCoordenada()) &&  tableroFichas[ini.x][ini.y].getTipo() != 'K'){
                            System.out.println("Esta ficha no se puede mover porque el rey esta en jaque");
                        }else{
                            tableroFichas[ini.x][ini.y].setCoordenada(destino);
                            tableroFichas[destino.x][destino.y]=  tableroFichas[ini.x][ini.y];
                            tableroFichas[ini.x][ini.y]=null;
                            System.out.println(" -------------------");
                            tablero[ini.x][ini.y]=' ';
                            tablero[destino.x][destino.y]=tableroFichas[destino.x][destino.y].getTipo();
                        }
                        
                    }else{
                        System.err.println("MOVIMIENTO  NO PERMITIDO");
                    }
                
            
                }
                
                
    }
    public void calcularPosMov(int  jugador,Point pos){  
        tableroFichas[pos.x][pos.y].posiblesMovimientos(this);
        System.out.println("Los posibles movimientos que puedes hacer con la ficha: "+ tableroFichas[pos.x][pos.y].getTipo()+ " de color : "+tableroFichas[pos.x][pos.y].getColor()+" son: ");
        tableroFichas[pos.x][pos.y].imprimirPosMov();
    }
    public char[][] getTablero() {
        return tablero;
    }
    //-----------------------FUNCIONES NECESARIAS-------------------------------------
    // FUNCION NECESARIA PARA CALCULAR MOVIMIIENTOS
    public boolean preguntarAliado(Point pVerifiar, String color) {
            // verifica si exite otra ficha del equipo contrario en esa posiciÃ³n.
            if(tableroFichas[pVerifiar.x][pVerifiar.y]==null ){
                // false es que no hay nada
                return false;
            }else{
                if(color=="blanco"){
                 if(tableroFichas[pVerifiar.x][pVerifiar.y]==null && tableroFichas[pVerifiar.x][pVerifiar.y].getColor()=="negro")
                return false;
             }else{
                if(color=="negro"){
                    if(tableroFichas[pVerifiar.x][pVerifiar.y]==null && tableroFichas[pVerifiar.x][pVerifiar.y].getColor()=="blanco")
                    return false;
                    
                }
                return true;
                }
                
            }
            return true;
           }
            
        
    

    // FUNCIÃ“N NECESARIA PARA CALULAR MOVIMIENTOS
    //verifica si en la posiciÃ³n indicada se encuentra una ficha del equipo contrario
    public boolean preguntar(Point pVerifiar, String color ){
           if(color=="blanco"){
            // verifica si exite otra ficha del equipo contrario en esa posiciÃ³n.
            if(tableroFichas[pVerifiar.x][pVerifiar.y]==null){
                // false es que no hay nada
                return false;
            }else{
                return true;
            }
        }else{
            // verifica si exite otra ficha del equipo contrario en esa posiciÃ³n.
            if(tableroFichas[pVerifiar.x][pVerifiar.y]==null){
                return false;
            }else{
                return true;
            }
        }
    
    }
    
    public boolean verificarJaque(ArrayList<Ficha> fichasEnemigas, Point posRey){
        ArrayList<Point> pmEnemigo = new ArrayList<Point>();
        for(int i=0; i<fichasEnemigas.size();i++){
            pmEnemigo.addAll(fichasEnemigas.get(i).posiblesMovimientos(this));
        }
        if(pmEnemigo.contains(posRey)){
            System.out.print("El rey esta en jaque");
            return true;
        }
       return false; 
    }
    

}
