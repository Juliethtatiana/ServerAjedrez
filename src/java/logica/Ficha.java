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
 * @author QBEX
 */
public abstract class Ficha {
    Point posicion;
    String color;
    ArrayList<Point> posiblesMov;
    
    
    public Point getPosicion() {
        return this.posicion;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    
    
    public void setPosicion(Point nPunto){
        this.posicion=nPunto;
    }
    
     public ArrayList<Point> posiblesMovimientos() {
        return posiblesMov;
    }
     
    public void limpiarMovimientos() {
        posiblesMov.clear();
    }
    
      public abstract int getNombre();
      
     public abstract void movimiento ( Tablero  t); 

}
