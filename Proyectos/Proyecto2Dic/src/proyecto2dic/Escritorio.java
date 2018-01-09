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
public class Escritorio {

    int cliente;
    String estado;
    boolean state;
    int NoDoc;
    int turnos;
    Lista cola = new Lista();
    Lista pila = new Lista();

    public Escritorio() {
        state = false;
        turnos = 0;
        cliente = 0;

    }

    public boolean isState() {
        return state;
    }

    public int getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public int getNoDoc() {
        return NoDoc;
    }

    public int getTurnos() {
        return turnos;
    }

//    public Object escritorioVacio(){
//        
//    }
    int contador;

    public void colaVacia() {
        Nodo aux = cola.inicio;
        contador = 1;
        if (cola.estaVacio()) {
            System.out.println("La lista esta vacía");
            contador = 0;

        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
                contador++;
                if (contador == 10) {
                    return;
                }

            }

        }
    }

    public void turnoEscritorio() {

        Nodo aux = cola.inicio;
        Pasajero pasajero = new Pasajero();
        //try{

        if (!cola.estaVacio()) {
//            
            if (state == false) {
                if (aux.getDato() != null) {

                   
                    pasajero = (Pasajero) cola.removerFrente();
                    
                    if (pasajero!=null) {
                        cliente = pasajero.getId();
                        turnos = pasajero.getNoTurn();
                        NoDoc = pasajero.getNoDoc();
                        System.out.println("El escritorio esta atendiendo a " + cliente + "y su turno " + turnos);
                        state = true;
                        pilaDoc(NoDoc);
                        
                    }
                else{
                   cliente=0;
                   turnos=0;
                   NoDoc=0;
                   state=false;
                }  
                }
            } else {
                if (turnos > 0) {
                    turnos--;
                    state = true;
                } else {
                    state = false;
                }
            }
        }
//   
Graficador graph=new Graficador();
graph.crearDot("PilaDoc", pila, "Documento "+this.hashCode());
        graph.generarImagen("PilaDoc.dot", "Documentos.png");
    }
    public void pilaDoc(int a){
        int doc=a;
        
        while(doc>0){
            pila.insertarFrente("Documento");
            doc--;
        }
    }

}
