/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Mari
 */
public class Recorrido extends javax.swing.JFrame {
    Grafo hormiguero;
    int hormigas;
    int contador;
    ArrayList <ArrayList<Arista>> aristasRecorridas = new ArrayList<ArrayList<Arista>>();;
            
    /**
     * Creates new form Recorrido
     */
    public Recorrido(Grafo g, int hormigas, int contador) {
        initComponents();
        this.setTitle("Comienza el recorrido");       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*Toolkit mipantalla = Toolkit.getDefaultToolkit(); //UBICACION DE LA VENTANA
        Dimension tamano=mipantalla.getScreenSize();
        int alturaP = tamano.height;
        int anchoP = tamano.width;
        setLocation(anchoP/3,alturaP/4);*/
        this.hormiguero = g;
        this.hormigas = hormigas;
        this.contador = contador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Recorrido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Haga clic para mostrar un nuevo recorrido de la iteración");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //MOSTRAR EL FRAME CON EL RECORRIDO
        ArrayList<Vertice> noVisitados = new ArrayList<Vertice>();
        ArrayList<Arista> visitada = new ArrayList<Arista>();
        Vertice[][] maze = new Vertice[21][20];
        
        for(int row = 0; row < maze.length; row++) {
            for(int col = 0; col < maze[0].length; col++) {
                maze[row][col] = new Vertice(0);
                System.out.print("1");
            }
            System.out.println();
        }
        
        int pos = 9;
        int contador = 0;
        for(int i = 0; i<hormiguero.getNumeroVertices();i++){
            maze[pos][contador+1].setColor(1);
            maze[pos][contador+2].setColor(3);
            contador = contador + 2;
        }
        maze[pos][contador].setColor(0);
        for(Vertice v: hormiguero.getVertices()){
            Vertice aux = v;
            noVisitados.add(aux);
        }
        
        //System.out.println(this.contador);
        
        if(this.contador<this.hormigas){
            Random ram = new Random();
            int random = ram.nextInt((hormiguero.getNumeroVertices()-1)+1);
            Vertice temp = noVisitados.get(random);
            Vertice inicial = temp;
            hormiguero.feromonasIniciales();
            visitada = hormiguero.recorridoGrafo(temp);
            //hormiguero.feromonasRecorrido(visitada);
            //System.out.println(visitada);
            this.contador++;
            //FRAMEEEEEEEE
            //noVisitados.add(temp);
            String recor = " ";
            Double distancia = 0.0;
            for(Arista a: visitada){
                recor = recor + a.getExtremo1().getId() + " - " + a.getExtremo2() + "\n" + " ";
                distancia = distancia + a.getPeso();
            }
            String total = String.valueOf(distancia);
            //System.out.println(visitada);
            //caja de informacion del recorrdio
            JOptionPane.showMessageDialog(null,"Este es el recorrido numero: " + this.contador + "\n"+ "En este recorrido una de las " + this.hormigas + " hormigas partió de: " + inicial.getId() + "\n" + "Su recorrido fue por los caminos: "+ "\n" + recor + "\n" + " Su distancia recorrida fue de: " + total );
            //Labyrinth recorriendo = new Labyrinth(maze);
            //recorriendo.setVisible(true);
            //this.dispose();
        }if(this.contador == this.hormigas){
            hormiguero.feromonasEvaporadas();
            //INFORMACION DEL MEJOR CAMINO FINAL
            new Opciones(this.hormiguero).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
