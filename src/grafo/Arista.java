
package grafo;

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
    String stringRepresentacion = (id + " une la ciudad '"+  u.getId() + "' con '" + v.getId() + "'.  La distancia entre ellas es: " + String.valueOf(this.peso) + " y contine un rastro de feromonas de: " + String.valueOf(this.feromonas)+".");
    return stringRepresentacion;
  }

  public void setProbabilidad(Double probabilidad){ //toma las feromonas que ya tiene la arista y calcula su probabilidad
      this.probabilidad = probabilidad;
  }
  
  public Double getProbabilidad(){
      return this.probabilidad;
  }
  
  public void setFeromonasIniciales(Double feromonas){ //feromonas antes de comenzar el primer recorrido sobre un grafo
      this.feromonas = feromonas;
  }
  
  public void setFeromonas1(Double feromonasAct){ //actualizacion por paso de hormiga en su recorrido
      this.feromonas = this.feromonas + feromonasAct; 
  }
  
  public void setFeromonas2(){ //acutalizacion por evaporacion
      this.feromonas = this.feromonas*(0.5);
  }
  
  public Double getFeromonas(){
      return this.feromonas;
  }
}
