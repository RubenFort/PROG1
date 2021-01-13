
package codigo;

public class Garage {
    
    private int maxCoches;
    private Coche[] coches;
    
    Garage (int maxCoches){
        this.maxCoches=maxCoches;
        coches=new Coche [maxCoches];
    }
}
