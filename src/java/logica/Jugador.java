
package logica;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Jugador {
    private String nickname;
    private String color;
    
    //-------------------ATRIBUTOS
    
    private ArrayList<Ficha> fichas;

    //---------------GETTERS

    public String getNickname() {
        return nickname;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    //-------------------CONSTRUCCTOR
    
    public Point getPosiRey (){
        return this.fichas.get(0).posicion;
    }

    public Jugador(String nickname, String color){
        this.nickname=nickname;
        this.color=color;
    }
    
    
    
    //se pasa una coordenada con la posición de la ficha
    // para ver sus movimientos
    public ArrayList<Point> verMov(Point p, Tablero t){
       // System.out.println("la posición pasada es :"+p.x +" "+p.y);
        /*
        for (int i = 0; i < fichas.size(); i++) {
            if(fichas.get(i).posicion.equals(p)){
                System.out.println("una ficha tiene esa posición");
                fichas.get(i).movimiento(t);
                return fichas.get(i).posiblesMovimientos();
            }
        }*/


        for(int i =0;i<fichas.size();i++){
            //System.out.println("Posición "+i+fichas.get(i).getPosicion());
           if(fichas.get(i).getPosicion().equals(p)){
                //System.out.println("se encontro una ficha con la misma posición");
                // se calcula las posibles posiciones
                fichas.get(i).movimiento(t);
                return fichas.get(i).posiblesMovimientos();
           }
        }
        return null;
    }
    
    //Cambia la posición de la ficha con la posición
    // que se le pase
    public void realizarMov(Point pinicio, Point pfinal){
        for (int i = 0; i < fichas.size(); i++) {
            if(fichas.get(i).posicion.equals(pinicio)){
                //System.out.println("el punto de inicio es "+ pinicio);
                //System.out.println("el punto de inicio es "+ pfinal);
                fichas.get(i).setPosicion(pfinal);
                //System.out.println("la nueva posición de la ficha ya puesta es: ");
                //System.out.println(fichas.get(i).getPosicion());
                break;
            }
        }
    }
    
    // pide el nombre de la ficha segun una poscición
    public int preguntarNombre(Point c) {
        for (int i = 0; i < fichas.size(); i++) {
            if(fichas.get(i).posicion.equals(c)){
                //System.out.println("el punto de inicio es "+ pinicio);
                //System.out.println("el punto de inicio es "+ pfinal);
                return fichas.get(i).getNombre();
                //System.out.println("la nueva posición de la ficha ya puesta es: ");
                //System.out.println(fichas.get(i).getPosicion());
            }
        }
        return 1;
    }
/*    
    public void  turno(Tablero t){  
        ArrayList<Point> posiblesMov;
        boolean a =false;
        String[] fichas = { "Rey", "Reina", "Alfil", "Caballo","torre","peon"};
        
        String[] nub1 = {"0","1","2","3","4","5","6","7"};
        String[] nub2 = {"0","1"};
        
        Point posiIni=null;
        int fNombre=0;
        
        do{
            posiblesMov=null;
            System.out.println("///////////SE FORMATEO");
             String input = (String) JOptionPane.showInputDialog(null, "Elige la ficha para ver sus movientos",
            "Verificador de jugadas", JOptionPane.QUESTION_MESSAGE, null, fichas,fichas[0]);
             if(input=="Rey"){
                 posiblesMov=rey.posiblesMovimientos(t);
                 mostarMov(posiblesMov, t);
                 posiIni=rey.getPosi();
                 fNombre=rey.getNombre();
                  a=hacerMov(t, posiblesMov, posiIni, 1);
             }else if(input=="Reina"){
                 posiblesMov=reina.posiblesMovimientos(t);
                  mostarMov(posiblesMov, t);
                   posiIni=reina.getPosi();
                   fNombre=reina.getNombre();
                    a=hacerMov(t, posiblesMov, posiIni, 2);
             }else if(input=="Alfil"){
                int input2 = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Elige la ficha para ver sus movientos",
                "Verificador de jugadas", JOptionPane.QUESTION_MESSAGE, null, nub2,nub2[0]));   
                posiblesMov=alfil[input2].posiblesMovimientos(t);
                 
                mostarMov(posiblesMov, t);
                posiIni=alfil[input2].getPosi();
                fNombre=alfil[input2].getNombre();
                 a=hacerMov(t, posiblesMov, posiIni, 3);
             }else if(input=="Caballo"){
                int input2 = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Elige la ficha para ver sus movientos",
                "Verificador de jugadas", JOptionPane.QUESTION_MESSAGE, null, nub2,nub2[0]));
                posiblesMov=caballo[input2].posiblesMovimientos(t);
                mostarMov(posiblesMov, t);
                posiIni=caballo[input2].getPosi();
                fNombre=caballo[input2].getNombre();
                 a=hacerMov(t, posiblesMov, posiIni, 4);
             }else if(input=="torre"){
                int input2 = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Elige la ficha para ver sus movientos",
                "Verificador de jugadas", JOptionPane.QUESTION_MESSAGE, null, nub2,nub2[0]));
                posiblesMov=torre[input2].posiblesMovimientos(t);
                 mostarMov(posiblesMov, t);
                 posiIni=torre[input2].getPosi();
                 fNombre=torre[input2].getNombre();
                  a=hacerMov(t, posiblesMov, posiIni, 5);
             }else if(input == "peon"){
                int input2 = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Elige la ficha para ver sus movientos",
                "Verificador de jugadas", JOptionPane.QUESTION_MESSAGE, null, nub1,nub1[0]));
                JOptionPane.showMessageDialog(null, "El valor enviado es: "+String.valueOf(input2));
                posiblesMov=peones[input2].posiblesMovimientos(t);
                mostarMov(posiblesMov, t);
                posiIni=peones[input2].getPosi();
                fNombre=peones[input2].getNombre();
                 a=hacerMov(t, posiblesMov, posiIni, 6);
             }        
        }while(a==false);
  
    }
    public void mostarMov(ArrayList<Point> posiblesMov, Tablero t){
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(t.getTablero()[i][j]);
                System.out.print("    ");
            }
        System.out.println(" ");
        }

        Point aux;
        int [][] auxTablero = new int[8][8];
        
        auxTablero= t.getTablero();        
        
        //String [] movimientos= new String[posiblesMov.size()+1];
        for (int i = 0; i < posiblesMov.size(); i++) {
                aux=posiblesMov.get(i);
                auxTablero[aux.x][aux.y]=9;
          //      movimientos[i]=String.valueOf(aux.x)+" "+String.valueOf(aux.y);
        }  
                         System.out.println("salio-----------");

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(t.getTablero()[i][j]);
                System.out.print("    ");
            }
        System.out.println(" ");
        }
        System.out.println("////////////-asdfjlñaksjd");
        //------LOS POSIBLES MOVIMIENTOS SE VEN A CONTINUACIÓN
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(auxTablero[i][j]);
                System.out.print("    ");
            }
            System.out.println(" ");
        }   
        
    }
    
    public boolean hacerMov(Tablero t,ArrayList<Point> posiblesMov ,Point pIni,int nombFicha ){
        int respuesta = JOptionPane.showConfirmDialog(null, "desea hacer algun movimiento con la ficha seleccionada?", 
                "¿Desea hacer algun movimiento con la ficha?", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            int [] respues= new int[posiblesMov.size()];
            for (int i = 0; i < posiblesMov.size(); i++) {
                respues[i]=i;
                System.out.println("Movimiento: "+i+" = "+String.valueOf(posiblesMov.get(i).x)+" "+
                        String.valueOf(posiblesMov.get(i).y));
            }
            int a =Integer.parseInt(JOptionPane.showInputDialog("ingrese el indice del movimiento, "
                    + "sino quiere hacer ningun movimiento ingrese -1"));
            if(a==-1){
                return false;
            }else{
                t.movimiento(pIni, posiblesMov.get(a), color, nombFicha);
                return true;
            }
        }
        else {
           return false;
        }     
    }
    
    
    //public ArrayList<Point> movFichas(){
    //    ArrayList<Point> mov;
    //    mov=reina.get
    //}
    */

   
}
    

