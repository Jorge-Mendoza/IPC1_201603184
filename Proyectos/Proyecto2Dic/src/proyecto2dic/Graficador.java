/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2dic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgi
 */
public class Graficador {

    public void CrearDot(String nombre, Lista lista, String a) {
        FileWriter writer = null;
        PrintWriter pw = null;

        try {
            writer = new FileWriter(nombre + ".dot");
            pw = new PrintWriter(writer);
            pw.println("digraph lista{");
            pw.println("rankdir=LR");
            pw.println("node [margin=0 fontcolor=blue fontsize=20 width=0.5 shape=box style=filled]");
            pw.println(lista.generarDot(a));
            pw.println("\n}");
            pw.close();
        } catch (IOException es) {

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void generarImagen(String direccionDot, String direccionPng) {
        try {
            //Ejecuta el proceso
            String dotPath = "C:\\Program Files (x86)\\Graphviz\\release\\bin\\dot.exe";
            String cmd = dotPath + " -Tpng " + direccionDot + " -o " + direccionPng;
            System.out.println(cmd);
            Runtime.getRuntime().exec(cmd);
            // pbuilder.start();     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void crearDot(String nombre, Lista lista, String a) {
        FileWriter writer = null;
        PrintWriter pw = null;

        try {
            writer = new FileWriter(nombre + ".dot");
            pw = new PrintWriter(writer);
            pw.println("digraph lista{");
            pw.println("rankdir=LR");
            pw.println("node [margin=0 fontcolor=blue fontsize=20 width=0.5 shape=box style=filled]");
            pw.println(lista.GenerarDot(a));
            pw.println("\n}");
            pw.close();
        } catch (IOException es) {

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
