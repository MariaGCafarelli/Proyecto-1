/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;



public class Grafo {

    //ArryList que guardan los vertices y las aristas.
    private ArrayList <Vertice> listaVertices = new ArrayList<Vertice>();
    private ArrayList <Arista> listaArista = new ArrayList<Arista>();
    //ArryList que contiene los vertices adyacentesa un nodo.
    private ArrayList <ArrayList<Vertice>> listaVerticesAdyacentes = new ArrayList<ArrayList<Vertice>>();
    //Inicializo el numero de vertices y aristas que trae el archivo.
    private int numeroVertice, numeroLado;
    //Objetos vertices y arista.
    private Vertice v = null;
    private Arista a = null;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Constructor del grafo
    */
    
    public Grafo() {
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Devuelve la lista de vertices en el grafo.
    *@throws ArrayLista.
    */
    
    public ArrayList<Vertice> getVertices(){
        return this.listaVertices;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Devuelve el numero de vertices del grafo.
    *@throws int.
    */
    
    public int getNumeroVertices(){
        return this.numeroVertice;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Devuelve el numero de lados del grafo.
    *@throws int.
    */
    
    public int getNumeroLados(){
        return this.numeroLado;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Asiga el numero de vertices del grafo.
    *@param int numero de vertices del grafo.
    *@throws void.
    */
    
    public void setNumeroVertices(int vertices){
        this.numeroVertice = vertices; 
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Asiga el numero de lados del grafo.
    *@param int numero de lados del grafo.
    *@throws void.
    */
    
    public void setNumeroLados(int lados){
        this.numeroLado = lados;
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Toma un nodo y realiza el recorrido del grafo, las comparaciones las realiza a traves de la funcion "mejorOpcion", 
    * llega lo mas lejos que puede del inicio, y se regresa.
    *@param Vertice verticeInical de donde sale la hormiga.
    *@throws ArrayList<Arista> con el recorrido realizado por la hormiga.
    */
    
    public ArrayList<Arista> recorridoGrafo(Vertice verticeInicial){
        ArrayList<Vertice> noVisitados = new ArrayList<Vertice>();
        ArrayList<Arista> recorrido = new ArrayList<Arista>();
        
        for(Vertice v: this.listaVertices){
            Vertice aux = v;
            noVisitados.add(aux);
        }
        
        int contador = this.numeroVertice-1;
        Arista actual;
        Vertice verticeActual = verticeInicial;

        int auxiliar = noVisitados.indexOf(verticeInicial);
        noVisitados.remove(auxiliar);
        
        for(int i = 0 ; i < contador ; i++){           
            actual = mejorCamino(verticeActual,noVisitados);
            recorrido.add(actual);
            if(actual.getExtremo1().getId().equals(verticeActual.getId())){
                verticeActual = actual.getExtremo2();
            }else{
                verticeActual = actual.getExtremo1();
            }            
            auxiliar = noVisitados.indexOf(verticeActual);
            noVisitados.remove(auxiliar);
            //System.out.println(verticeActual);
            //System.out.println("ITERACION: " + i + " NUMERO DE VERTICES: " + noVisitados.size());            
        }
        
        actual = obtenerArista(verticeActual,verticeInicial);
        recorrido.add(actual);
        feromonasRecorrido(recorrido);
        
        //System.out.println(recorrido);
        
        return recorrido;
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Establece los valores iniciales de feromonas en todos las aristas. 
    *@param Double numero de nodos iniciales en el grafo.
    *@throws void.
    */
    
    public void feromonasIniciales(){
        Double feromonasIniciales = ( 1/((double)this.numeroVertice) );
        for(Arista a: listaArista){
            a.setFeromonasIniciales(feromonasIniciales);
        }
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Actualiza los valores finales de las feromonas cuando termina la iteracion. 
    *@throws void.
    */
    
    public void feromonasEvaporadas(){
        for(Arista a: listaArista){           
            a.setFeromonas2();
        }
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Actualiza la cantidad de feromonas en una arista si la hormiga paso por ella durante su recorrido. 
    *@param ArrayList con las aristas vistadas por la hormiga en su recorrido.
    *@throws void.
    */
    
    public void feromonasRecorrido(ArrayList<Arista> a){
        Double recorrido = 0.0;        
        for(Arista aux: a){
            recorrido = recorrido + aux.getPeso();
        }
        recorrido = (1/recorrido);
        for(Arista aux1: a){
            aux1.setFeromonas1(recorrido);
        }
        
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Toma un vertice y una lista de vertices, establece comparaciones entre sus probabilidades y decide
    * cual es la mejor opcion a tomar entre las aristas que unen al vertice y sus adyacentes.
    *@param Vertice inicial, ArrayList<Vertice> noVisitados.
    *@throws Arista.
    */ 
    
    public Arista mejorCamino(Vertice inicial, ArrayList<Vertice> noVisitados){ //llama a un array que contiene los vertices no visitados
        Arista auxiliar;
        int contador = 0;
        Double mayorProbabilidad = 0.0;
        Double arregloProbabilidades[] = new Double[noVisitados.size()];
        Arista arregloAristas[] = new Arista[noVisitados.size()];
       

        for(Vertice v: noVisitados){
            //auxiliar = obtenerArista(inicial,v);
            arregloProbabilidades[contador] = probabilidad(inicial,v);
            //System.out.println(arregloProbabilidades[contador]);
            arregloAristas[contador] = obtenerArista(inicial,v);
            contador++;
        }
        int i;
        
        for( i=0; i < noVisitados.size(); i++){
            Double aux = arregloProbabilidades[i];
            //System.out.println(aux);
            int equals = Double.compare(aux,mayorProbabilidad);
            if(equals > 0){
                mayorProbabilidad = arregloProbabilidades[i];
                contador = i;
            }
        }
        
      
        auxiliar = arregloAristas[contador];
        
        /*for(int j=0;j<arregloProbabilidades.length; j++){
            System.out.println(arregloProbabilidades[j]);
        }
        System.out.println(auxiliar.toString());*/
        return auxiliar;
        
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Establece l valor de la probabilidad entre un vertice y otro a traves de una formula preestablecida. 
    *@param Vertice verticeSalida, Vertice verticeLLegada.
    *@throws Double.
    */
    
    public Double probabilidad(Vertice verticeSalida, Vertice verticeLLegada){
        
        Double resultado2 = 0.0, probabilidad = null, fero = null, acumulado1 = null;
        Double resultado1,  cuadrado, multi, acumulado, fero2;
        Arista auxiliar, auxiliar2;
        //System.out.println("ESTA" + verticeSalida.getId() + verticeLLegada.getId());
        if (estaLado(verticeSalida.getId(),verticeLLegada.getId()) || estaLado(verticeLLegada.getId(),verticeSalida.getId())){
            //System.out.println("ESTA");
            auxiliar2 = obtenerArista(verticeSalida,verticeLLegada);
            acumulado = auxiliar2.getPeso();
            fero2 = auxiliar2.getFeromonas();
            resultado1 = fero2 * ((double) Math.pow((1/acumulado),2));
            
            for(Vertice v: listaVertices){ 

                if ( !verticeSalida.getId().equals(v.getId()) ){
                    auxiliar = obtenerArista(verticeSalida,v);
                    acumulado1 =  auxiliar.getPeso();
                    fero =  auxiliar.getFeromonas();
                    cuadrado = (double) Math.pow((1/acumulado1),2);
                    multi = cuadrado * fero;
                    resultado2 = (resultado2 + multi);
                }            
            }
            probabilidad = resultado1/resultado2;
            auxiliar2.setProbabilidad(probabilidad);
                        
        }else{
            return probabilidad;
        }        
        return probabilidad;                 
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    * Si el vertice v no esta en la lista de vertices, lo agrega en listaVertices y listVerticesAdyacentes.
    *@param Vertice v.
    *@throws boolean.
    */

    public boolean agregarVertice(Vertice v) { 
        boolean estaVerticee = false;
        Vertice vd = null;
        for (int i=0; i <listaVertices.size();i++){//listaVertices.size()
            vd = listaVertices.get(i);
            if (vd.getId().equals(v.getId())){
                estaVerticee = true;
                System.out.println(" Error al agregar el Vertice: " + v.toString());
                break;
            }   
        }
        if ((estaVerticee != true) || (listaVertices.size()== 0)){
            listaVertices.add(v);
            listaVerticesAdyacentes.add(new ArrayList<Vertice>());
            this.numeroVertice = this.numeroVertice + 1;
            return true;
        }

    
        return false;
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Verifica si un vertice no pertenece ya al grafo y lo crea.
    *@param String id.
    *@throws boolean.
    */

    public boolean agregarVertice(String id) { 
        if (estaVertice(id)){
            return false;
        }
        else {
            Vertice v = new Vertice(id);
            return agregarVertice(v);
        }   
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Si el vertice esta en el grafo, te devuelve su valor a partir de su nombre.
    *@param String id.
    *@throws Vertice.
    */

    public Vertice obtenerVertice(String id) throws NoSuchElementException{
        for (int i=0; i<numeroVertice; i++){
            v = listaVertices.get(i);
            if (v.getId().equals(id)){
                return v;
            }
        }   
        throw new NoSuchElementException("El id: " +id+ " no se encuentra en el grafo.");
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Verifica si el vertice existe en el grafo.
    *@param id del vertice.
    *@throws boolean.
    */

    public boolean estaVertice(String id) {
        for (int i=0; i<numeroVertice; i++){
            v = listaVertices.get(i); 
            if ((v.getId().equals(id) ) ){
                return true;
            }
        }   
        return false;        
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Verifica que el lado existe en el grafo a partir del nombre de los vertices que conecta.
    *@param String u, String v.
    *@throws boobean.
    */

    public boolean estaLado(String u, String v){
        for (Arista a: listaArista){
         
            if (a.getExtremo1().getId().equals(u) && a.getExtremo2().getId().equals(v) || a.getExtremo2().getId().equals(v) && a.getExtremo1().getId().equals(u)) {
                return true;
            }
        }   
        return false;    
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Si el vertice esta en el grafo, lo elimina de listaVertices, lo saca de donde sea adyacente en listaVerticesAdyacentes
    * y elimina las aristas a las que pertenece.
    *@param String id del vertice.
    *@throws boolean.
    */

    public boolean eliminarVertice(String id) { 
        int indice;
        if (estaVertice(id)){
            v = obtenerVertice(id);
            indice = listaVertices.indexOf(v);
            listaVertices.remove(v);
            listaVerticesAdyacentes.remove(indice);
            for (ArrayList<Vertice> a: listaVerticesAdyacentes){
            	if (a.contains(v)){
            		a.remove(v);
            	}
            }
            for(int j = 0; j<= numeroLado; j++){
                if (listaArista.get(j).getExtremo1() == v || listaArista.get(j).getExtremo2() == v){
                	listaArista.remove(j);
                }
            }
            return true;
        }
        return false;   
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Devuelve la lista de vertices.
    *@throws ArrayList de vertices existentes.
    */

    public List<Vertice> vertices() {
        return this.listaVertices;
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Devuelve la lista de aristas.
    *@throws ArrayList de las aristas existentes.
    */

    public List<Lado> lados() { 
        ArrayList<Lado> listaLados = new ArrayList<Lado>();
        for (Arista ad: listaArista){
            listaLados.add(ad);
        }
        return listaLados;
    }


 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Agrega una arista en el grafo si no existe previamente.
    *@param Arista a.
    *@throws boolean.
    */

    public boolean agregarArista(Arista a) {
    	int indice1, indice2;
    	for (Arista arist: listaArista){
            if (arist.getId().equals(a.getId()) ) {
    		return false;
            }
        }
    		
        listaArista.add(a);
        //listaArista.add(b);
                    
        indice1 = listaVertices.indexOf(a.getExtremo1());
        indice2 = listaVertices.indexOf(a.getExtremo2());
                    
        if (!(listaVerticesAdyacentes.get(indice1).contains(a.getExtremo1())))
            listaVerticesAdyacentes.get(indice1).add(a.getExtremo1());
                    
                
        if (!(listaVerticesAdyacentes.get(indice2).contains(a.getExtremo2())))
            listaVerticesAdyacentes.get(indice2).add(a.getExtremo2());
                    

        this.numeroLado = this.numeroLado + 1;
        return true;
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *Verifica que la arista es agregable y la crea.
    *@param id del vertice.
    *@param double peso del vertice.
    *@param String del id del vertice u.
    *@param String de; id del vertice v.
    *@throws boolean.  
    */

    public boolean agregarArista(String id, double peso, String u, String v) { 
        if (estaLado(u,v)==false){
            Vertice u1 = obtenerVertice(u);
            Vertice v1 = obtenerVertice(v); 
            Arista arista1 = new Arista(id,peso,u1,v1); 
            //Arista arista2 = new Arista(id,peso,v1,u1);
            return agregarArista(arista1);
           
            }
        return false;
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
    *Si la arista existe en el grafo, la quita de la lista de aristas.
    *@param String id de la arista a eliminar.
    *@throws boolean.
    */

    public boolean eliminarArista(String id) {
        int contador = 0;
        int indice1, indice2;
        boolean existe = false;
        Arista arist2 = null;
        
        for (Arista arist: listaArista){
            if (arist.getId().equals(id)){
                arist2 = arist; 
                existe = true;
                break;
            }
        }
        
        if (existe){
            this.numeroLado = this.numeroLado - 1;    
            for (Arista arist: listaArista){
                if ((arist.getExtremo1().getId().equals(arist2.getExtremo1().getId())) && (arist.getExtremo2().getId().equals(arist2.getExtremo2().getId()))) {
                    contador = contador + 1; 
                }    
            }
            System.out.println("contrador: " + contador);
            if (contador == 1){
                indice1 = listaVertices.indexOf(arist2.getExtremo1());
                indice2 = listaVertices.indexOf(arist2.getExtremo2());

                listaArista.remove(arist2);
                
                listaVerticesAdyacentes.get(indice1).remove(arist2.getExtremo1());
                listaVerticesAdyacentes.get(indice2).remove(arist2.getExtremo2());

            }
            return true;
        }
        else return false;
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Si la arista esta en el grafo, retorna su valor a partir de los vertices en sus extremos.
    //@param Vertice u, Vertice v.
    //@throws Arista.

    public Arista obtenerArista(Vertice u, Vertice v) throws NoSuchElementException {
        for (Arista a: listaArista){
            Vertice auxiliar1 = a.getExtremo1();
            Vertice auxiliar2 = a.getExtremo2();
            if (( auxiliar1.getId().equals(u.getId()) && auxiliar2.getId().equals(v.getId()) )) {
                return a;
            }else if( auxiliar1.getId().equals(v.getId()) && auxiliar2.getId().equals(u.getId()) ){
                return a;
            }
        } 
        throw new NoSuchElementException("La arista que introdujo no se encuentra en el grafo.");
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public String toString() {
        String cadenaGrafo;
        cadenaGrafo = ("" + String.valueOf(numeroVertice) + "\n");
        cadenaGrafo = (cadenaGrafo + String.valueOf(numeroLado) + "\n");
        for (Vertice vr: listaVertices){
            cadenaGrafo = (cadenaGrafo + vr.toString() + "\n");
        }
        for (Arista ar: listaArista){
            cadenaGrafo = (cadenaGrafo + ar.toString() + "\n");
        }
        return cadenaGrafo;
    }   
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    /**
    *Lee el archivo con el grafo guardado y agrega vertice a vertice, 
    *luego crea las aristas correspondientes y agrega sus valores en la lista de vertices adyacentes. 
    *Llama funciones de las clases Vertice, Lado.
    *@param string del nombre del archivo.
    *@throws boolean.
    */

    public boolean cargarGrafo(String Archivo)throws IOException{
        
        try{

            BufferedReader in = new BufferedReader(new FileReader(Archivo));
            String s;
            String[] separar; 
            int estaVerticee = 0, posicion1 = 0, posicion2 = 0;
            int contador = 1;
            s = in.readLine();
            this.numeroVertice = Integer.parseInt(s);
            s = in.readLine();
            this.numeroLado = Integer.parseInt(s);
            
            while ((s = in.readLine()) != null ){
                estaVerticee = 0;
                if (contador <= this.numeroVertice){
                    separar = s.split(" ");
                //VERTICES CON UNA SOLA PALABRA DE NOMBRE
                        v = new Vertice(separar[0].toLowerCase());
                        listaVertices.add(v);
                        listaVerticesAdyacentes.add(new ArrayList<Vertice>());
                }

                if (contador > numeroVertice){
                    estaVerticee = 0;
                    separar = s.split(" ");
                    Vertice vI = null;
                    Vertice vF = null;
                    boolean estaAristaa = false;
                    
                        for (int i=0; i<listaVertices.size(); i++){
                            v = listaVertices.get(i);
                            if (v.getId().equals(separar[1].toLowerCase())){
                                estaVerticee = estaVerticee + 1;
                                vI = v;
                                posicion1 = i;
                            }
                            if (v.getId().equals(separar[2].toLowerCase())){
                                estaVerticee = estaVerticee + 1 ;
                                posicion2 = i;
                                vF = v;

                            }
                        }
                        if (estaVerticee == 2){
                            Arista arista = new Arista(separar[0].toLowerCase(),Double.parseDouble(separar[3]),vI,vF); //ARISTAS CON UNA SOLA PALABRA DE NOMBRE
                            //System.out.println(separar[4]);
                            arista.setFeromonasIniciales(Double.parseDouble(separar[4]));
                            listaArista.add(arista);
                            if (!(listaVerticesAdyacentes.get(posicion1).contains(vF)))
                                listaVerticesAdyacentes.get(posicion1).add(vF);
                            if (!(listaVerticesAdyacentes.get(posicion2).contains(vI)))
                                listaVerticesAdyacentes.get(posicion2).add(vI);

                        }
                        else if (estaVerticee != 2) {
                            System.out.println(" Error al agregar el Arista: " + separar[0] + " " + separar[1]  + " " + separar[2]  + " " + separar[3]);
                        }
                    
                }
            contador = contador + 1;
            }
            in.close(); 
            return true;       
        }
        catch (Exception e){
            System.out.println("No se pudo cargar el grafo con exito.");
            e.printStackTrace();
            return false;
        } //TERMINADO
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    /**
    *A partir del grafo existente, crea un archivo de tipo .txt con el contenido de el. 
    *@param String del nombre del archivo.
    *@throws boolean.
    */
    
    public boolean retornarGrafo(String Archivo)throws IOException{
        
        try{
            String fileName = Archivo + ".txt";
            PrintWriter out = new PrintWriter(fileName);
            out.print(Integer.toString(this.numeroVertice));
            out.println();
            out.print(Integer.toString(this.numeroLado));
            for(Vertice v: this.listaVertices){
                out.println();
                out.print(v.getId());    
            }           
            for(Arista a: this.listaArista){
                out.println();
                out.print( a.getId() + " " + a.getExtremo1() + " " + a.getExtremo2() + " " + a.getPeso() + " " + a.getFeromonas());    
            }
            
            out.close();
            return true;       
        }
        catch (Exception e){
            System.out.println("No se pudo cargar el grafo en un .txt con exito.");
            e.printStackTrace();
            return false;
        } //TERMINADO
    }
        
}