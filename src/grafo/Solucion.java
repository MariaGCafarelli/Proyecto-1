package grafo;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela Cafarelli
 * @author Jonh Erice
 */

public class Solucion {
    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo();  
        Hormiguero window = new Hormiguero(grafo);        
        window.setVisible(true);
        
    }
    
}
