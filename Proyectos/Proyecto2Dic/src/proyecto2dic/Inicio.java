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
public class Inicio extends javax.swing.JFrame {

    int turno = 1;
    int idPasajero;
    int pasajeros;
    int desabordaje;
    int mantenimiento;
    int NoAviones;
    int NoEscritorios;
    int NoEstaciones;
    int NoMaletas;
    String texto = "";
    Graficador graph = new Graficador();
    boolean acceso = false;

    Lista listaAviones = new Lista();
    Lista colaPasajeros = new Lista();
    Lista maletero = new Lista();
    Lista escritorios = new Lista();
    Lista estaciones = new Lista();
    Lista colaEstaciones = new Lista();

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        //llegadaAviones();
    }

    public void llegadaAviones() {

        Avion avion;
        while (NoAviones > 0) {

            listaAviones.insertarAlFinal(avion = new Avion());
            pasajeros = avion.getPasajeros();

            System.out.println(pasajeros);
            NoAviones--;
        }

        while (NoEscritorios > 0) {
            Escritorio escritorio;
            escritorios.insertarFrente(escritorio = new Escritorio());
            NoEscritorios--;
        }
        while (NoEstaciones > 0) {
            Estacion estacion;
            estaciones.insertarFrente(estacion = new Estacion());
            NoEstaciones--;
        }
//        graph.CrearDot("ListAviones", listaAviones,"Avion");
//        graph.generarImagen("ListAviones.dot", "Aviones.png");
//        
//        graph.CrearDot("ListEscritorios", escritorios,"Escritorio");
//        graph.generarImagen("ListEscritorios.dot", "Escritorios.png");
//        
//        graph.CrearDot("ListEstaciones", estaciones,"Estacion");
//        graph.generarImagen("ListEstaciones.dot", "Estaciones.png");

        graph.CrearDot("ListAviones" + turno, listaAviones, "Avion");
        graph.generarImagen("ListAviones" + turno + ".dot", "Aviones" + turno + ".png");

        graph.crearDot("ListEscritorios", escritorios, "Escritorio");
        graph.generarImagen("ListEscritorios.dot", "Escritorios.png");

        graph.crearDot("ListEstaciones", estaciones, "Estacion");
        graph.generarImagen("ListEstaciones.dot", "Estaciones.png");
    }

    public void colaPasajeros() {

        while (pasajeros > 0) {
            Pasajero pasajero;
            colaPasajeros.insertarFrente(pasajero = new Pasajero());
            NoMaletas += pasajero.getNoMaletas();
            System.out.println(NoMaletas);
            pasajeros--;
        }
        graph.crearDot("ColaPasajeros", colaPasajeros, "Pasajero");
        graph.generarImagen("ColaPasajeros.dot", "Pasajeros.png");

    }

    public void maletero() {
        while (NoMaletas > 0) {
            Maleta maleta;
            maletero.insertarDeFrente("Maleta");
        }
    }

    public void funcionamiento() {
        texto += "|||||| turno :" + turno + "||||||\n";

        System.out.println();
        Avion avion;
        if (!listaAviones.estaVacio()) {
            avion = (Avion) listaAviones.inicio.getDato();
            if ((Avion) listaAviones.inicio.getDato() != null) {
                texto += "Llegada avion: " + avion.hashCode() + "\n";
                texto += "Desaborda avion: " + avion.hashCode() + "\n";
                pasajeros = avion.getPasajeros();
                System.out.println();
                System.out.println("****Los turnos son *****" + avion.getTurnDes());

                colaPasajeros();
                avion.pasajeros = 0;
                avion.turnDes--;
                if (avion.turnDes <= 0) {
                    colaEstaciones.insertarAlFinal(listaAviones.removerFrente());
                    acceso = true;
                }
                turno++;
                Graficador grapho = new Graficador();
                grapho.crearDot("ColaEstaciones", colaEstaciones, "Avion");
                grapho.generarImagen("ColaEstaciones.dot", "ColaEstaciones.png");

            } else {
                System.out.println("Ya no hay aviones");

            }
        }
//        } else {
//
//            if (listaAviones.inicio == listaAviones.fin) {
//                listaAviones.inicio = listaAviones.inicio.getSiguiente();
//            }
//            //texto+= "********No se tienen aviones**********"+"\n";
//        }
        colaPasajeros();
        // avion.pasajeros = 0;
        //maletero();
        escritorios();
        if (acceso == true) {
            colaEstacion();
        }
        graph.CrearDot("ListAviones" + turno, listaAviones, "Avion");
        graph.generarImagen("ListAviones" + turno + ".dot", "Aviones" + turno + ".png");

        graph.CrearDot("ListEscritorios", escritorios, "Escritorio");
        graph.generarImagen("ListEscritorios.dot", "Escritorios.png");

        graph.CrearDot("ListEstaciones", estaciones, "Estacion");
        graph.generarImagen("ListEstaciones.dot", "Estaciones.png");
    }

    public void colaEstacion() {
        //try {
 
        Nodo aux = estaciones.inicio;
        Estacion estacion = (Estacion) aux.getDato();
        Avion avion;
        while (aux != null) {
            if (!colaEstaciones.estaVacio()) {
                if (estacion != null) {
                    aux = estaciones.inicio;
                    estacion = (Estacion) aux.getDato();
                    if (estacion.getEstado().equals("Libre")) {
                        estacion.estado = "Ocupado";

                        avion = (Avion) colaEstaciones.removerFrente();

                        if (avion != null) {
                            estacion.avion = avion.hashCode();
                            estacion.turnos = avion.turnMant;
                            System.out.println("####################################");
                            System.out.println(estacion.avion + "    " + estacion.turnos);
                            System.out.println("####################################");
                        }

                    } else {
                        if (estacion.turnos > 0) {
                            estacion.estado = "Ocupado";
                            estacion.turnos--;
                        } else {
                            estacion.estado = "Libre";
                        }
                    }
                    texto += "----------------------- " + "\n";
                    texto += "Estacion " + estacion.hashCode() + " estado: " + estacion.estado + "\n";
                    texto += "  >>> Avion en mantenimiento: " + estacion.avion + "\n";
                    texto += "  >>> Turnos restantes: " + estacion.turnos + "\n";
                    texto += "++++++++++++++++++++++++++++" + "\n";
                    texto += "((((((( Fin de Turno ))))))" + "\n";
                } else {
                    aux = aux.siguiente;
                }
                
            }
            aux = aux.siguiente;
        }
//        } catch (Exception e) {
//            System.out.println("Encontramos un Null");
//            return;
//        }
    }

    public void escritorios() {
        texto += "##########Escritorios de registro###############" + "\n";
        Escritorio escritorio;
        Nodo aux = escritorios.inicio;
        escritorio = (Escritorio) aux.getDato();
        escritorio.colaVacia();
        while (aux != null) {
            if (escritorio.contador < 10) {
                while (escritorio.contador <= 10) {
                    if (colaPasajeros.estaVacio()) {
                        System.out.println("Saldré");
                        break;
                    } else {
                        System.out.println("Agregué");
                        escritorio.cola.insertarFinal(colaPasajeros.removerFinal());
                        escritorio.contador++;

                    }
                }

            }
            escritorio.turnoEscritorio();
            System.out.println("Escritorio " + escritorio.hashCode() + " atiende: pasajero " + escritorio.cliente);
            texto += "Escritorio : " + escritorio.hashCode() + "está :" + escritorio.state + "\n";
            texto += "   >> Atendiendo a pasajero : " + escritorio.cliente + "\n";
            texto += "   >> Número de documentos : " + escritorio.NoDoc + "\n";
            texto += "   >> Turnos restantes : " + escritorio.getTurnos() + "\n";
            aux = aux.siguiente;
            if (aux != null) {
                escritorio = (Escritorio) aux.getDato();
            }
        }

    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asigna No.de aviones");

        jLabel2.setText("Asigna No. de escritorios");

        jLabel3.setText("Asigna No. de estaciones");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Automático");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(76, 76, 76))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do {
            funcionamiento();
            Consola consola = new Consola();
            consola.jTextPane1.setText(texto);
            consola.setImagenes();
            consola.setVisible(true);

        } while (!listaAviones.estaVacio()/*&&!escritorios.estaVacio()&&!estaciones.estaVacio()*/);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        funcionamiento();
        Consola consola = new Consola();
        consola.jTextPane1.setText(texto);
        consola.setImagenes();
        consola.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        NoAviones = Integer.parseInt(jTextField1.getText());
        NoEscritorios = Integer.parseInt(jTextField2.getText());
        NoEstaciones = Integer.parseInt(jTextField3.getText());
        llegadaAviones();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
