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
        // TODO code application logic here
        Grafo grafo = new Grafo();
        grafo.cargarGrafo("ejemplo.txt");
        System.out.println(grafo.toString());
        
        
        /*Arista arista;
        grafo.agregarVertice("caracas");
        grafo.agregarVertice("colombia");
        grafo.agregarVertice("peru");
        grafo.agregarVertice("lima");
        grafo.agregarVertice("chile");
        boolean agregarArista = grafo.agregarArista("carretera1", 300.0,"caracas","colombia");
        Vertice v1,v2;
        v1 = grafo.obtenerVertice("caracas");
        v2 = grafo.obtenerVertice("chile");
        //arista = grafo.obtenerArista(v1,v2);
        grafo.agregarArista("carretera2", 100.0,"caracas","peru");
        grafo.agregarArista("carretera3", 500.0,"caracas","lima");
        grafo.agregarArista("carretera4", 30.0,"caracas","chile");
        grafo.agregarArista("carretera5", 700.0,"colombia","peru");
        grafo.agregarArista("carretera6", 200.0,"colombia","lima");
        grafo.agregarArista("carretera7", 50.0,"colombia","chile");
        grafo.agregarArista("carretera8", 550.0,"peru","lima");
        grafo.agregarArista("carretera9", 950.0,"peru","chile");
        grafo.agregarArista("carretera10", 540.0,"chile","lima");
        //System.out.println(agregarArista);
        //System.out.println(grafo.toString());
        //boolean eliminarArista = grafo.eliminarArista("carretera1");
        grafo.feromonasIniciales();
        
        //Double prueba = arista.getFeromonas();
        //System.out.println(arista);
        //System.out.println(grafo.toString());
        //Arista prueba2 = grafo.obtenerArista(v1,v2);
        grafo.recorridoGrafo(v1);
        
        arista = grafo.obtenerArista(v2,v1);
        Double prueba = arista.getFeromonas();
        System.out.println(prueba);
        grafo.recorridoGrafo(v1);
        grafo.recorridoGrafo(v2); */
    }
    
}
