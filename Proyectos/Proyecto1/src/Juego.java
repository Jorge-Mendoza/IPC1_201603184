

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
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
public class Juego extends javax.swing.JFrame {
    JLabel [][]BMatriz;
    int tam;
    int vida1=5;
    int vida2=5;
    boolean turno;
    Timer t;
    int h,m,s,cs;
    /**
     * Creates new form Juego
     */
    
    public Juego(int tam){
        initComponents();
        this.tam=tam;
        jLabel13.setText(String.valueOf(vida1));
        jLabel14.setText(String.valueOf(vida1));
       turno=true;
       getTablero();
       per1=0;
       per2=3;
       t=new Timer(10,accion);
       h=0;
       boolean salida=false;
    }
    Eleccion eleccion=new Eleccion();
    ActionListener accion=new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            cs++;
            if(cs==100){
                cs=0;
                ++s;
            }
            if(s==60){
                s=0;
                ++m;
            }
            if(m==5){
                m=0;
                ++h;
            }
        }
        
    };
    public void actualiza(){
        String tiempo=(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        jTextField3.setText(tiempo);
    }
    
    
    public Juego(){
        jLabel13.setText(String.valueOf(vida1));
        jLabel14.setText(String.valueOf(vida2));
        
    }
    
    public void jugar(){
        int posx;
        int posy;
        
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setPreferredSize(new java.awt.Dimension(430, 354));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Tiempo");

        jLabel2.setBackground(new java.awt.Color(204, 0, 51));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jugador 1");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 204, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jugador 2");
        jLabel3.setOpaque(true);

        jLabel4.setText("Personajes");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("Personajes");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Tirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Arriba");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Izquierda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Abajo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Derecha");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)))
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(turno==true){
        hilo=new Hilo(numero,this,x1,y1,4,turno);
        hilo.start();
         x1=hilo.x;
        y1=hilo.y;
        turno=false;
        this.BMatriz=hilo.juego.BMatriz;
        return;
        }
        if(turno==false){
        hilo=new Hilo(numero,this,x2,y2,4,turno);
        hilo.start();
        x2=hilo.x;
        y2=hilo.y;
        turno=true;
        this.BMatriz=hilo.juego.BMatriz;
        return;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        lanzaDado();
    }//GEN-LAST:event_jButton1ActionPerformed
Hilo hilo=null;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(turno==true){
        hilo=new Hilo(numero,this,x1,y1,1,turno);
        hilo.start();
         x1=hilo.x;
        y1=hilo.y;
        turno=false;
        this.BMatriz=hilo.juego.BMatriz;
        vida1=hilo.juego.vida1;
        return;
        }
        if(turno==false){
        hilo=new Hilo(numero,this,x2,y2,1,turno);
        hilo.start();
        x2=hilo.x;
        y2=hilo.y;
        turno=true;
        this.BMatriz=hilo.juego.BMatriz;
        vida2=hilo.juego.vida2;
        return;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(turno==true){
        hilo=new Hilo(numero,this,x1,y1,2,turno);
        hilo.start();
         x1=hilo.x;
        y1=hilo.y;
        turno=false;
         
        this.BMatriz=hilo.juego.BMatriz;
        vida1=hilo.juego.vida1;
        return;
        }
        if(turno==false){
        hilo=new Hilo(numero,this,x2,y2,2,turno);
        hilo.start();
        x2=hilo.x;
        y2=hilo.y;
        turno=true;
        this.BMatriz=hilo.juego.BMatriz;
        vida2=hilo.juego.vida2;
        return;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(turno==true){
        hilo=new Hilo(numero,this,x1,y1,3,turno);
        hilo.start();
         x1=hilo.x;
        y1=hilo.y;
        turno=false;
        this.BMatriz=hilo.juego.BMatriz;
        vida1=hilo.juego.vida1;
        per1++;
        return;
        }
        if(turno==false){
        hilo=new Hilo(numero,this,x2,y2,3,turno);
        hilo.start();
        x2=hilo.x;
        y2=hilo.y;
        turno=true;
        this.BMatriz=hilo.juego.BMatriz;
        vida2=hilo.juego.vida2;
        per2++;
        return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    int numero=0;
    public void lanzaDado(){
        
        ImageIcon dado=new ImageIcon();
        numero=(int)Math.floor(Math.random()*(6-1+1)+(1));
        if(numero==1){
           dado= new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado1.jpg");
           System.out.println(numero);
        }else if(numero==2){
            dado=new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado2.jpg");
            System.out.println(numero);
        }else if(numero==3){
            dado=new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado3.png");
            System.out.println(numero);
        }else if(numero==4){
            dado=new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado4.png");
            System.out.println(numero);
        }
        else if(numero==5){
            dado=new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado5.jpg");
            System.out.println(numero);
        }
        else if(numero==6){
            dado=new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\dado6.jpg");
            System.out.println(numero);
        }
        Icon imagen=new ImageIcon(dado.getImage().getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_AREA_AVERAGING));
        jLabel12.setIcon(imagen);
        this.jLabel12.repaint();
    }
    
    public void temporizador(){
        
    }
    String []personajes1=new String[3];
    String []personajes2=new String[3];
    String []direcciones=new String[6];
    
    public void asignarPersonajes(String []a,String []b,String []c){
        
        personajes1[0]=a[0];
        jLabel5.setText(a[0]);
        personajes1[1]=a[1];
        jLabel6.setText(a[1]);
        personajes1[2]=a[2];
        jLabel7.setText(a[2]);
        personajes2[0]=a[3];
        jLabel9.setText(a[3]);
        personajes2[1]=a[4];
        jLabel10.setText(a[4]);
        personajes2[2]=a[5];
        jLabel11.setText(a[5]);
        jTextField1.setText(b[0]);
        jTextField2.setText(b[1]);
        direcciones=c;
    }
    
    int x1,y1,x2,y2,per1,per2;
    
    
    public void creaItems(int tamaño) {
        int cantidad = tamaño * tamaño;
        int minas = (int) (cantidad * 0.1);
        int vidas = (int) (cantidad * 0.05);
        
        for (int k = 0; k < minas; k++) {
            int fila = (int) Math.floor(Math.random() * ((tamaño-1) - 0 + 1) + (0));
            int columna = (int) Math.floor(Math.random() * ((tamaño-1) - 0 + 1) + (0));
            
                ImageIcon im = new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\bomba.jpg");
                Icon icono = new ImageIcon(im.getImage().getScaledInstance(BMatriz[fila][columna].getWidth(), BMatriz[fila][columna].getHeight(), Image.SCALE_AREA_AVERAGING));
                
                BMatriz[fila][columna].setIcon(icono);
                BMatriz[fila][columna].setName("bomba");
                this.BMatriz[fila][columna].repaint();
                
            
        }
        
        for (int k = 0; k < vidas; k++) {
            int fila = (int) Math.floor(Math.random() * ((tamaño-1) - 0 + 1) + (0));
            int columna = (int) Math.floor(Math.random() * ((tamaño-1) - 0 + 1) + (0));
            
                ImageIcon im = new ImageIcon("C:\\Users\\jorgi\\Desktop\\Repositorios\\IPC1_201603184\\Proyectos\\Proyecto1\\src\\Imagenes\\vida.png");
                Icon icono = new ImageIcon(im.getImage().getScaledInstance(BMatriz[fila][columna].getWidth(), BMatriz[fila][columna].getHeight(), Image.SCALE_AREA_AVERAGING));
                BMatriz[fila][columna].setIcon(icono);
                BMatriz[fila][columna].setName("vida");
                this.BMatriz[fila][columna].repaint();
                
            
        }
        int contador=0;
        while(contador<2){
          System.out.println("Entramos al while");
        int fila=(int)Math.floor(Math.random()*((tamaño-1)-0+1)+(0));
        int columna=(int)Math.floor(Math.random()*((tamaño-1)-0+1)+(0));
        
        if(contador==0){
            ImageIcon ima=new ImageIcon(direcciones[per1]);
            Icon icono=new ImageIcon(ima.getImage().getScaledInstance(BMatriz[fila][columna].getWidth(),BMatriz[fila][columna].getHeight() , Image.SCALE_AREA_AVERAGING));
            BMatriz[fila][columna].setIcon(icono);
            BMatriz[fila][columna].setBorder(new LineBorder(Color.RED));
            BMatriz[fila][columna].setName("jugador1");
            this.BMatriz[fila][columna].repaint();
            x1=fila;
            y1=columna;
            contador++;
        }else if(contador==1){
            ImageIcon ima=new ImageIcon(direcciones[per2]);
            Icon icono=new ImageIcon(ima.getImage().getScaledInstance(BMatriz[fila][columna].getWidth(),BMatriz[fila][columna].getHeight() , Image.SCALE_AREA_AVERAGING));
            BMatriz[fila][columna].setIcon(icono);
            BMatriz[fila][columna].setBorder(new LineBorder(Color.GREEN));
            BMatriz[fila][columna].setName("jugador2");
            this.BMatriz[fila][columna].repaint();
            x2=fila;
            y2=columna;
            contador++;
        }
           
        }
    }
    
    public void getTablero(){
        
        System.out.println(tam);
        //tam=8;
        BMatriz=new Label[tam][tam];
        int tambloquex=430/tam;
        int tambloquey=354/tam;
        
        //fondo.setLayout(new GridLayout(tam,tam));
        for (int j=0; j< tam;j++) {   
            for (int i=0; i<tam;i++) { 
                
                BMatriz[i][j] = new Label(); 
                BMatriz[i][j].setBounds(j*tambloquex,i*tambloquey,tambloquex,tambloquey);
                BMatriz[i][j].setText(":V");
                BMatriz[i][j].setBorder(new LineBorder(Color.BLACK));
                
                BMatriz[i][j].setOpaque(false);
                this.fondo.add(BMatriz[i][j]);
        }
        }
    }
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
