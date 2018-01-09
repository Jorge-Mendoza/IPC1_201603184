/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2dic;

/**
 *
 * @author jorgi
 */
public class Pasajero {
    
    int id;
    int NoMaletas;
    int NoDoc;
    int NoTurn;
    
    public void creaAleatorio(){
        id=this.hashCode();
        NoMaletas=(int)Math.floor(Math.random()*(4-1+1)+(1));
        NoDoc=(int)Math.floor(Math.random()*(10-1+1)+(1));
        NoTurn=(int)Math.floor(Math.random()*(3-1+1)+(1));
    }

    public int getId() {
        return id;
    }

    public int getNoMaletas() {
        return NoMaletas;
    }

    public int getNoDoc() {
        return NoDoc;
    }

    public int getNoTurn() {
        return NoTurn;
    }
    
    public Pasajero(){
        creaAleatorio();
    }
    
}
