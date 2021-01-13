
package codigo;

public class Garaje {
    
    private int maxCoches;
    private Coche[] coches;
   
    
    Garaje(int maxCoches){
        this.maxCoches = maxCoches;
        coches = new Coche[maxCoches];
    }
    
}
