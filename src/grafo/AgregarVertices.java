
package grafo;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Maria Gabriela Cafarelli
 */

public class AgregarVertices extends javax.swing.JFrame {
    private Grafo g;
    private int numeroCiudades;
    private int contador;
    
    public AgregarVertices(Grafo g, int numeroCiudades, int contador) {
        initComponents();
        this.setTitle("Agregar Ciudades");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit mipantalla = Toolkit.getDefaultToolkit(); 
        Dimension tamano=mipantalla.getScreenSize();
        int alturaP = tamano.height;
        int anchoP = tamano.width;
        setLocation(anchoP/3,alturaP/4);
        this.setResizable(false);
        this.g=g;
        this.numeroCiudades = numeroCiudades;
        this.contador=contador;
        this.jTextField1.setText(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre de la ciudad:");

        jLabel2.setText("(asigne un nombre con una sola palabra. Ejemplo: Caracas)");

        jTextField1.setText("jTextField1");

        jLabel3.setText("Especifique el nombre de las ciudades que participan en la simulación");

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel3)
                .addGap(0, 83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        System.out.println(this.numeroCiudades);
        
        if(this.contador<numeroCiudades){
            System.out.println("entra");
            
            String stringCiudades = jTextField1.getText();
            Vertice v = new Vertice(stringCiudades.toLowerCase());
            g.agregarVertice(v);
            this.contador = this.contador + 1;
            System.out.println(this.contador + " " + numeroCiudades);
            new AgregarVertices(g,this.numeroCiudades, this.contador).setVisible(true);
            this.dispose();
            
        } 
        if (this.contador == this.numeroCiudades){
            int numeroCaminos = (((this.numeroCiudades - 1)* this.numeroCiudades)/2);
            System.out.println("aqui" + numeroCaminos);
            
                new AgregarAristas(g,numeroCaminos, 0).setVisible(true);
                this.setVisible(false);
                this.dispose();
                    
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
