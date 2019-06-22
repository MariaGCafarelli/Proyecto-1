
package grafo;

/**
 *
 * @author Maria Gabriela Cafarelli
 */
/**
 * Clase Vertice posee 3 metodos. Vertice, getId, toString
 *@param String id: Id del vertice
 *@throw String stringRepresentacio: String que es de la forma "id"
 */

public class Vertice
{
  private String id;
 
  public Vertice(String id) {
    this.id = id;
  }   
  
  public String getId() {
    return this.id;
  }
  
  public String toString() { 
    String stringRepresentacion = (id);
    return stringRepresentacion;
  }

}

