package grafo;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela Cafarelli
 */
public class Solucion {
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Grafo grafo = new Grafo();
        //Grafo grafo = new Grafo();
        //grafo.cargarGrafo("segundo2.txt");
        //grafo.feromonasIniciales();
        //System.out.println(grafo.toString());
        //Vertice v1 = grafo.obtenerVertice("caracas");
        //Vertice v2 = grafo.obtenerVertice("colombia");
        //ArrayList<Arista> a = new ArrayList<Arista>();
        //a = grafo.recorridoGrafo(v1);
        //System.out.println(a);
        //grafo.recorridoGrafo(v2);
        //grafo.eliminarVertice("caracas");
        //System.out.println(grafo.toString());
        //grafo.recorridoGrafo(v2);
        
        //grafo.retornarGrafo("segundo2");
        //JOptionPane.showMessageDialog(null,"En este recorrido la hormiga partió de: " + v1.getId() + "\nholaaaa" );   
        Hormiguero window = new Hormiguero(grafo);        
        window.setVisible(true);
    }
    
}
