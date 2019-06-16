/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author Mari
 */
import java.util.*;

public interface GrafoInterface
{

    //public boolean cargarGrafo(String dirArchivo);
    
    public int numeroDeVertices();

    public int numeroDeLados();
    
    public boolean agregarVertice(Vertice v);

    public boolean agregarVertice(String id);
    
    public Vertice obtenerVertice(String id);

    public boolean estaVertice(String id);

    public boolean estaLado(String u, String v);

    public boolean eliminarVertice(String id);

    public List<Vertice> vertices();

    public List<Lado> lados();

    //public int grado(String id);

    //public List<Vertice> adyacentes(String id);
 
    //public List<Lado> incidentes(String id);

    //public Object clone();

    //public String toString();
}
