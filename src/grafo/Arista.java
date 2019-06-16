
package grafo;
import java.text.DecimalFormat;

/**
 * Clase Arista que hereda de la Clase LADO. Posee 6 metodos. Arista, getPeso, getId, getExtremo1, getExtremo2, toString, clone
 *@param String id: Id del Arista
 *@param Double p: peso del Arista
 *@param Vertice u: El vertice inicial del Arista
 *@param Vertice v: El vertice final del Arista
 *@throw String stringRepresentacio: String que es de la forma "id + peso"
 */

public class Arista extends Lado
{
  private Vertice u;
  private Vertice v;
  Double feromonas;
  Double probabilidad;
  
  public Arista(String id, double peso, Vertice u, Vertice v) {
    super(id,peso);
    this.u = u;
    this.v = v;
    this.probabilidad = 0.0;
  }

  public Vertice getExtremo1() {
    return this.u;
  }

  public Vertice getExtremo2() {
    return this.v;
  }

  public String toString() {
    String stringRepresentacion = (id + " " + u.getId() + " " + v.getId() + " " + String.valueOf(this.peso) + " " + String.valueOf(this.feromonas));
    return stringRepresentacion;
  }

  public void setProbabilidad(Double probabilidad){ //toma las feromonas que ya tiene la arista y calcula su probabilidad, crear una variable que acumule la distancia que ha recorrido
      this.probabilidad = probabilidad;
  }
  
  public Double getProbabilidad(){
      return this.probabilidad;
  }
  
  public void setFeromonasIniciales(Double feromonas){
      this.feromonas = feromonas;
  }
  
  public void setFeromonas1(Double feromonasAct){ //actualizacion por paso de hormiga
      this.feromonas = this.feromonas + feromonasAct; 
  }
  
  public void setFeromonas2(){ //acutalizacion por evaporacion
      this.feromonas = this.feromonas*(0.5);
  }
  
  public Double getFeromonas(){
      return this.feromonas;
  }
}
