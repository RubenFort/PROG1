
package codigo;

public class Garage {
    
    private int maxCoches;
    private int ocupacion = 0;
    private Coche[] coches;
    private Coche cocheLocalizado;
    
    Garage (int maxCoches) {
         this.maxCoches=maxCoches;
         coches= new Coche [maxCoches];
    }
    
    public boolean añadirCoche (Coche c) {
        if (ocupacion>=maxCoches) {
            return false;
        }
        coches [ocupacion]=c;
        ocupacion ++;
        System.out.println(""+ocupacion);
        return true;
    }
   
    public boolean borrarCoche (String matricula) {
    
        return true;
    }
    
    public Coche[] getListaCoches(){        
        return coches;
    }
    
    public Coche mostrarDetalle(String mat){
        int i, j=0;
        
        for (i = 0; i < ocupacion; i++) {
            if(coches[i].getMatricula().equals(mat)) {
             j=i;
            }
        }
            return coches[j];
    }
    
    public int getOcupacion (){
        return ocupacion;
    }
    
}
