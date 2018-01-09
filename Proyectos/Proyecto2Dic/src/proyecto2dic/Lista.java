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
public class Lista {

    public Nodo inicio;
    public Nodo fin;

    public Lista() {

    }

    public boolean estaVacio() {
        if (inicio == null && fin == null) {
            return true;
        } else {
            return false;
        }
    }

    public Object recorre() {
        Nodo aux = inicio;
        if (estaVacio()) {
            System.out.println("La lista esta vacía");
            return null;
        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            return aux;
        }
    }

    public void insertarFrente(Object dato) {//Inserta dato para lista simples
        if (estaVacio()) {
            inicio = fin = new Nodo(dato);
        } else {
            inicio = new Nodo(dato, inicio);
        }
    }

    public void insertarFinal(Object dato) {//inserta dato para listas simples
        if (estaVacio()) {
            inicio = fin = new Nodo(dato);
        } else {
            fin = fin.siguiente = new Nodo(dato);
        }
    }

    public Object removerFrente() {//Elimina para listas simples y dobles
        Object eliminado = inicio.getDato();
        if (estaVacio()) {
            eliminado = null;
            return eliminado;
        } else {
            if (inicio == fin) {
                eliminado=inicio.getDato();
                inicio = fin = null;
                return eliminado;
            } else {
                eliminado = inicio.getDato();
                inicio = inicio.siguiente;
                System.out.println(eliminado);
                return eliminado;
            }
        }

    }

    public Object removerFinal() {//Elimina para listas simples y dobles
        Object eliminado = fin.getDato();
        if (estaVacio()) {
            eliminado = null;
            return eliminado;
        } else {
            if (inicio == fin) {
                inicio = fin = null;
                return null;
            } else {
                Nodo aux = inicio;
                while (aux.siguiente != fin) {
                    aux = aux.siguiente;
                }

                eliminado = fin.getDato();
                fin = aux;
                //fin.siguiente = null;
                return eliminado;
            }
        }
    }

    public void imprimir() {
        if (estaVacio()) {
            System.out.println("Está vacia  la lista");
            return;
        }
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.siguiente;
        }
        System.out.println();
    }

    //Esta seccion es para metodos que tienen
    //un nodo anterior
    //***************************************************************
    public void insertarAlFrente(Object dato) {//Inserta dato para lista simples
        if (estaVacio()) {
            inicio = fin = new Nodo(dato);
        } else {
            inicio = new Nodo(dato, inicio);
            inicio.siguiente.anterior = inicio;
        }
    }

    public void insertarAlFinal(Object dato) {//inserta dato para listas simples
        if (estaVacio()) {
            inicio = fin = new Nodo(dato);
        } else {
            fin = fin.siguiente = new Nodo(dato, null, fin);

        }
    }

    public void imprimirDeAtras() {
        if (estaVacio()) {
            System.out.println("Está vacia  la lista");
            return;
        }
        Nodo aux = fin;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.anterior;
        }
        System.out.println();
    }

    // Metodos para poder
    // insertar nodos en una lista circular
    //**************************************************************
    public void insertarDeFrente(Object dato) {//Inserta dato para lista circulares
        if (estaVacio()) {
            inicio = fin = new Nodo(dato, inicio, fin);
        } else {
            //inicio=new Nodo(dato,inicio,inicio);
            inicio = fin.siguiente = inicio.anterior = new Nodo(dato, inicio, fin);
        }
    }

    public void insertarDeFinal(Object dato) {//inserta dato para listas circulares
        if (estaVacio()) {
            inicio = fin = new Nodo(dato, inicio, fin);
        } else {
            //fin=fin.siguiente=new Nodo(dato);
            fin = inicio.anterior = fin.siguiente = new Nodo(dato, inicio, fin);
        }
    }

    public String generarDot(String a) {
        String cadena = "";
        String nombre = a;
        if (!estaVacio()) {
            Nodo aux = inicio;
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + inicio.nombre + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            aux = aux.siguiente;
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + nombre + ": " + aux.hashCode() + "\"];\n";
                cadena += anterior + "->" + "nodo" + aux.hashCode() + ";\n";
                cadena += "nodo" + aux.hashCode() + "->" + anterior + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.siguiente;
            }
        }
        return cadena;
    }

    public String GenerarDot(String a) {
        String cadena = "";
        String nombre = a;
        if (!estaVacio()) {
            Nodo aux = inicio;
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + inicio.nombre + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            aux = aux.siguiente;
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + nombre + ": " + aux.hashCode() + "\"];\n";
                cadena += anterior + "->" + "nodo" + aux.hashCode() + ";\n";
//                cadena+="nodo" + aux.hashCode()+"->"+anterior+";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.siguiente;
            }
        }
        return cadena;
    }

}
