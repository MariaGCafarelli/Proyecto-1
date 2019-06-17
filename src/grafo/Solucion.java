/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.io.IOException;

/**
 *
 * @author Mari
 */
public class Solucion {
    public static void main(String[] args) throws IOException {
        /*// TODO code application logic here
        Grafo grafo = new Grafo();
        grafo.cargarGrafo("segundo.txt");
        //grafo.feromonasIniciales();
        System.out.println(grafo.toString());
        Vertice v1 = grafo.obtenerVertice("caracas");
        Vertice v2 = grafo.obtenerVertice("colombia");
        grafo.recorridoGrafo(v1);
        //grafo.recorridoGrafo(v1);
        //grafo.recorridoGrafo(v2);
        
        //grafo.retornarGrafo("segundo");*/
        
        Hormiguero window = new Hormiguero();        
        window.setVisible(true);
    }
    
}
