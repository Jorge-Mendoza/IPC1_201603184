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
public class Avion {

    int tipo;
    int pasajeros;
    int turnDes;
    int turnMant;

    public int getTipo() {
        return tipo;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public int getTurnDes() {
        return turnDes;
    }

    public int getTurnMant() {
        return turnMant;
    }

    public Avion() {
        creaAleatorio();
    }

    public void creaAleatorio() {
        tipo = (int) Math.floor(Math.random() * (3 - 1 + 1) + (1));
        if (tipo == 1) {
            pasajeros = (int) Math.floor(Math.random() * (10 - 5 + 1) + (5));
            turnDes = tipo;
            turnMant = (int) Math.floor(Math.random() * (3 - 1 + 1) + (1));
        }
        if (tipo == 2) {
            pasajeros = (int) Math.floor(Math.random() * (25 - 15 + 1) + (15));
            turnDes = tipo;
            turnMant = (int) Math.floor(Math.random() * (4 - 2 + 1) + (2));
        }
        if (tipo == 3) {
            pasajeros = (int) Math.floor(Math.random() * (40 - 30 + 1) + (30));
            turnDes = tipo;
            turnMant = (int) Math.floor(Math.random() * (6 - 3 + 1) + (3));

        }
    }

}
