/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
