/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Tatiana
 */
public class Jugador {
    private ArrayList<Ficha> fichas;
    private ArrayList<Ficha> fichasMuertas;
    private boolean turno;
    private  String color;
    
    public Jugador(boolean turno, String color){
        this.turno=turno;
        this.color=color;
        crearFichas();
        
    }
    public void moverFicha(Ficha ficha, int coordenadas[]){
    }
    private void mirarMov(int posMov[][]){
    }

    private void crearFichas(){
        fichas = new ArrayList<Ficha>();
        fichasMuertas = new ArrayList<Ficha>();
        int i=0;
        for(int j=0; j<8;j++){
            Peon peon = new Peon(this.color);
            fichas.add(peon);
        }
        i=0;
        do{
            if(i==0 || i==7){
                fichas.add(new Torre(this.color));
            }
            if(i==1 || i==6){
                fichas.add(new Caballo(this.color));
            }
            if(i==2 || i==5){
                fichas.add(new Alfil(this.color));
            }
            if(i==3){
                if(this.color=="blanco"){
                    fichas.add(new Rey(this.color));
                }else{
                    fichas.add(new Reina(this.color));
                }
                
            }
            if(i==4){
                  if(this.color=="blanco"){
                    fichas.add(new Reina(this.color));
                }else{
                    fichas.add(new Rey(this.color));
                }
            }
            i++;
        }while(i<8);
      
        
    }
    public void AnadirFichaMuerta( Ficha  ficha){
        
        fichasMuertas.add(ficha);
        fichas.remove(ficha);
        
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public String getColor() {
        return color;
    }
   
    
}
