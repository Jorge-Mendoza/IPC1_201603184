
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgi
 */
public class Hilo extends Thread{
    int x;
    int y;
    int cantidad;
    Juego juego;
    int source;
    boolean turno;
    
    public Hilo(int cantidad,Juego juego,int x,int y,int source,boolean turno){
        this.cantidad=cantidad;
        this.juego=juego;
        this.x=x;
        this.y=y;
        this.source=source;
        this.turno=turno;
    }
    
    public void mover(int cantidad){ 
       if(source==1){
        try { 
            
            while(cantidad>0){
            if(x-1<0){
                
                return;
            }
            else{
//                if(juego.BMatriz[x-1][y-1].getName().equalsIgnoreCase("bomba")&&juego.BMatriz[x][y].getName().equals("jugador1")){
//                    juego.vida1--;
//                }
//                if(juego.BMatriz[x-1][y-1].getName().equalsIgnoreCase("vida")&&juego.BMatriz[x][y].getName().equals("jugador1")){
//                    juego.vida1++;
//                }
//                if(juego.BMatriz[x-1][y-1].getName().equalsIgnoreCase("bomba")&&juego.BMatriz[x][y].getName().equals("jugador2")){
//                    juego.vida2--;
//                }
//                if(juego.BMatriz[x-1][y-1].getName().equalsIgnoreCase("vida")&&juego.BMatriz[x][y].getName().equals("jugador2")){
//                    juego.vida2++;
//                }
            juego.BMatriz[x-1][y].setIcon(juego.BMatriz[x][y].getIcon());
            juego.BMatriz[x-1][y].setBorder(juego.BMatriz[x][y].getBorder());
            juego.BMatriz[x][y].setIcon(null);
            juego.BMatriz[x][y].setBorder(new LineBorder(Color.BLACK));
            //juego.getTablero();
            x=x-1;
//            
            cantidad--;
            Thread.sleep(500);
           // mover(cantidad);
            }
            }
            if(turno==true){
                juego.x1=x;
            }else{
                juego.x2=x;
            }
            return;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } 
       }
       if(source==2){
           moverAbajo(cantidad);
       }
       if(source==3){ 
           moverIzquierda(cantidad);
       }
       if(source==4){
           moverDerecha(cantidad);
       }
    }
    public void moverAbajo(int cantidad){
        try { 
//          
            while(cantidad>0){
            if(x+1>juego.tam){
                
                return;
            }
            else{
            juego.BMatriz[x+1][y].setIcon(juego.BMatriz[x][y].getIcon());
            juego.BMatriz[x+1][y].setBorder(juego.BMatriz[x][y].getBorder());
            juego.BMatriz[x][y].setIcon(null);
            juego.BMatriz[x][y].setBorder(new LineBorder(Color.BLACK));
            //juego.getTablero();
            x=x+1;
//            
            cantidad--;
            Thread.sleep(500);
           // mover(cantidad);
            }
            }
            if(turno==true){
                juego.x1=x;
            }else{
                juego.x2=x;
            }
            return;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void moverIzquierda(int cantidad){
        try { 
//          
            while(cantidad>0){
            if(y-1<0){
                
                return;
            }
            else{
            juego.BMatriz[x][y-1].setIcon(juego.BMatriz[x][y].getIcon());
            juego.BMatriz[x][y-1].setBorder(juego.BMatriz[x][y].getBorder());
            juego.BMatriz[x][y].setIcon(null);
            juego.BMatriz[x][y].setBorder(new LineBorder(Color.BLACK));
            //juego.getTablero();
            y=y-1;
//            
            cantidad--;
            Thread.sleep(500);
           // mover(cantidad);
            }
            }
            if(turno==true){
                juego.y1=y;
            }else{
                juego.y2=y;
            }
            
            return;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void moverDerecha(int cantidad){
        try { 
//          
            while(cantidad>0){
            if(y+1>juego.tam){
                
                return;
            }
            else{
            juego.BMatriz[x][y+1].setIcon(juego.BMatriz[x][y].getIcon());
            juego.BMatriz[x][y+1].setBorder(juego.BMatriz[x][y].getBorder());
            juego.BMatriz[x][y].setIcon(null);
            juego.BMatriz[x][y].setBorder(new LineBorder(Color.BLACK));
            //juego.getTablero();
            y=y+1;
//            
            cantidad--;
            Thread.sleep(500);
           // mover(cantidad);
            }
            }
            if(turno==true){
                juego.y1=y;
            }else{
                juego.y2=y;
            }
            return;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        
        mover(cantidad);
    }
    
}
