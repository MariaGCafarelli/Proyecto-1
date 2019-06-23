
package grafo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela Cafarelli
 * @author John Erice
 */

public class Recorrido extends javax.swing.JFrame {
    Grafo hormiguero;
    int hormigas;
    int contador;
    ArrayList <Double> recorridos = new ArrayList<Double>();
    ArrayList <ArrayList<Arista>> listaDeRecorridos = new ArrayList<ArrayList<Arista>>();
            

    public Recorrido(Grafo g, int hormigas, int contador) {
        initComponents();
        this.setTitle("Recorrido");       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit mipantalla = Toolkit.getDefaultToolkit(); //UBICACION DE LA VENTANA
        Dimension tamano=mipantalla.getScreenSize();
        int alturaP = tamano.height;
        int anchoP = tamano.width;
        setLocation(anchoP/2,alturaP/2);
        this.hormiguero = g;
        this.hormigas = hormigas;
        this.contador = contador;
    }

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

        jLabel1.setText("Mostrar un nuevo recorrido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArrayList<Vertice> noVisitados = new ArrayList<Vertice>();
        ArrayList<Arista> visitada = new ArrayList<Arista>();
        
        for(Vertice v: hormiguero.getVertices()){
            Vertice aux = v;
            noVisitados.add(aux);
        }
        
        if(this.contador<this.hormigas){
            Random ram = new Random();
            int numero = (int) (Math.random() * hormiguero.getNumeroVertices());
            Vertice temp = noVisitados.get(numero);
            Vertice inicial = temp;
            hormiguero.feromonasIniciales();
            visitada = hormiguero.recorridoGrafo(temp);
            listaDeRecorridos.add(visitada);
            String recor = " ";
            Double distancia = 0.0;
            Vertice auxiliar = temp;
            for(Arista a: visitada){
                distancia = distancia + a.getPeso();
                if (auxiliar.getId().equals(a.getExtremo1().getId())){
                    recor = recor + a.getExtremo2().getId() + "\n" + " ";
                    auxiliar = a.getExtremo2();
                }else{
                    recor = recor + a.getExtremo1().getId() + "\n" + " ";
                    auxiliar = a.getExtremo1();
                }    
            }

            recorridos.add(distancia);
            this.contador++;

            String total = String.valueOf(distancia);

            //caja de informacion del recorrido
            JOptionPane.showMessageDialog(null,"Este es el recorrido numero: " + this.contador + "\n"+ "\n"+ "En este recorrido una de las " + this.hormigas + " hormigas partió de: " + inicial.getId() + "\n" +"\n" + "Luego siguió este orden en el recorrido de las ciudades: "+ "\n" + recor + "\n" + " Su distancia recorrida fue de: " + total );

            //this.dispose();
        }if(this.contador == this.hormigas){
            int posicion = 0;
            int i =0;
            Double mejorRecorrido = 900000000.0;
            for(Double p: recorridos){
                
                //System.out.println(recorridos.get(i));
                Double aux = recorridos.get(i);
                int equals = Double.compare(aux,mejorRecorrido);
                if (equals<0){
                    mejorRecorrido = recorridos.get(i);
                    posicion = i;
                }
                i++;
            }
            
            ArrayList<Arista> mejor = new ArrayList<Arista>();
            mejor = listaDeRecorridos.get(posicion);
            
            String recorr = " ";
            for(Arista a: mejor){
                recorr = recorr + a.getExtremo1().getId() + " - " + a.getExtremo2() + "\n" + " ";  
            }
            //INFORMACION DEL MEJOR CAMINO FINAL
            JOptionPane.showMessageDialog(null, "El recorrido con mas feromonas de esta iteración es cuando la hormiga sigue este orden de caminos: " + "\n" +  recorr + "\n"+"La distancia recorrida sería de: " + mejorRecorrido );
            hormiguero.feromonasEvaporadas();
            JOptionPane.showMessageDialog(null, "Se actualizaron las feromonas por evaporación.");
            //MUESTRA EN PANTALLA COMO QUEDO EL GRAFO EN LA ITERACIÓN
            JOptionPane.showMessageDialog(null,"A continuación se muestra la información del grafo actualizada luego de la iteración" + "\n" + hormiguero.toString());
            new Opciones(this.hormiguero).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
