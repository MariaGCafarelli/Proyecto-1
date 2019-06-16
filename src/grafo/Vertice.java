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
/**
 * Clase Vertice posee 5 metodos. Vertice, getPeso, getId, toString, clone
 *@param String id: Id del vertice
 *@param Double p: peso del vertice
 *@throw String stringRepresentacio: String que es de la forma "id + peso"
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

