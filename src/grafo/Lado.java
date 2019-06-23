
package grafo;

public abstract class Lado
{
  public String id;
  public double peso;

  public Lado(String id, double p) { 
  	this.id = id;
  	this.peso = p;
  }

  public String getId() {
    return this.id;
  }

  public double getPeso() {
    return this.peso;
  }

  public abstract String toString();
}
