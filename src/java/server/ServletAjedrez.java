    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ficha;
import logica.Jugador;
import logica.Partida;
import logica.Tablero;

/**
 *
 * @author juliethriano
 */
@WebServlet(name = "ServletAjedrez", urlPatterns = {"/ServletAjedrez"})
public class ServletAjedrez extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/:json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String comando = request.getParameter("player1");
            out.println("{");
            out.println("\"comando\":\""+comando+"\"");
            out.println("}");
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/:json;charset=UTF-8");
       
         String res = request.getParameter("res");
         Partida mipartida =Partida.getInstancia();
                int x ;
                int y;
                int jugador;
                    if(res.equals("posMov")) {
                  jugador = Integer.parseInt(request.getParameter("jugador"));
                    x = Integer.parseInt(request.getParameter("x"));
                    y = Integer.parseInt(request.getParameter("y"));
              
                    Point c= new Point(x, y);
                    
                   
                    ArrayList<Point> movimientos=mipartida.verMovimientos(jugador,c); //usar el  patron singleton
                //     System.out.println("jbhds--------------------------*********"+movimientos.get(0).x);
                    
                   try (PrintWriter out = response.getWriter()) {
                       if(!movimientos.isEmpty()){
                        out.println("{");
                        for(int i=0;i<movimientos.size();i++){
                            out.println("\""+i+"\":{");    
                            out.println("\"x\":"+movimientos.get(i).x+",");
                            out.println("\"y\":"+movimientos.get(i).y+"");
                            if(i!=(movimientos.size()-1)){
                                out.println("},");
                            }else{
                                out.println("}");
                            }
                            
                            
                        }
                        out.println("}");
                   
                       }
                       }
                        //System.out.print("llego hasta  aqui");}
                }else  if(res.equals("Mov")){
                    System.out.print("Mov");
                   jugador = Integer.parseInt(request.getParameter("jugador"));
                    x = Integer.parseInt(request.getParameter("x"));
                    y = Integer.parseInt(request.getParameter("y"));
              
                    int xf = Integer.parseInt(request.getParameter("xf"));
                    int yf = Integer.parseInt(request.getParameter("yf"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Point pinicial = new Point(x,y);
                    Tablero t= mipartida.getTablero();
                    mipartida.realizarMovimiento(jugador,pinicial, new Point(xf,yf),id,t); 
                    Jugador jugadores[] = mipartida.getJugadores();
                    ArrayList<Ficha> blanco = jugadores[0].getFichas();
                    ArrayList<Ficha> negro = jugadores[1].getFichas();
                    
                    try (PrintWriter out = response.getWriter()) {
                        out.println("{");
                            out.println("\"x\":"+xf+",");
                            out.println("\"y\":"+yf+",");
                            out.println("\"jugador\":"+jugador+",");
                            out.println("\"ficha\":"+t.getTablero()[xf][yf]);
                        out.println("}");
                       System.out.print("llego hasta  aqui");
                    }
                    System.out.print("Mov");
                  }else  if(res.equals("Consficha")){
                    Jugador jugadores[] = mipartida.getJugadores();
                    ArrayList<Ficha> blanco = jugadores[0].getFichas();
                    ArrayList<Ficha> negro = jugadores[1].getFichas();
                    try (PrintWriter out = response.getWriter()) {
                 
                        out.println("{");
                        out.println("\""+0+"\":{"); 
                        for(int i=0;i<16;i++){
                           
                             out.println("\""+i+"\":{");    
                             out.println("\"x\":"+blanco.get(i).getPosicion().x+",");
                             out.println("\"y\":"+blanco.get(i).getPosicion().y+",");
                             out.println("\"id\":"+blanco.get(i).getNombre());
                            if(i!=15){
                                out.println("},");
                            }else{
                                out.println("}");
                            }
                          
                        }
                         out.println("},"); 
                        
                         out.println("\""+1+"\":{"); 
                        for(int i=0;i<16;i++){
                           
                             out.println("\""+i+"\":{");    
                             out.println("\"x\":"+negro.get(i).getPosicion().x+",");
                             out.println("\"y\":"+negro.get(i).getPosicion().y+",");
                             out.println("\"id\":"+negro.get(i).getNombre());
                             
                             if(i!=15){
                                out.println("},");
                            }else{
                                out.println("}");
                            }
                        }
                        out.println("}");
                        out.println("}");
                        }
                   
            } 
                
               /*try (PrintWriter out = response.getWriter()) {
                 
                        out.println("{");
                        for(int i=0;i<=1;i++){
                            out.println("\""+i+"\":{");    
                            out.println("\"x\":"+1+",");
                            out.println("\"y\":"+0+"");
                            if(i!=1){
                                out.println("},");
                            }else{
                                out.println("}");
                            }
                            
                            
                        }
                        out.println("}");
                        System.out.print("llego hasta  aqui");
            }*/
                
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String player1 = request.getParameter("player1");
         String player2 = request.getParameter("player2");
         
        
         Partida mipartida =Partida.getInstancia();
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
