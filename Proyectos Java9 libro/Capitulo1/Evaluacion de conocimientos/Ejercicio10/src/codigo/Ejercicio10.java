
package codigo;

public class Ejercicio10 {

    //Pasa de pulgadas a metros
    //imprime 12 pies, con un salto de linea cade pie
    //1 pie son 12 pulgadas
    public static void main(String[] args) {
        int pulgada;
        double metro; 
        int count;
        int j=0;

        count = 0; 
        for(pulgada = 1; j < 13; pulgada++) { 
          
          metro = (pulgada * 0.0254) + (j * 0.3048); // 1 metro = 39.37 pulgadas 
          System.out.println(j+ "."+pulgada + " pulgada son " + 
                             metro + " metros.");  
          // every 10th line, print a blank line        
          if(pulgada == 12) { 
            j++;
            System.out.println(); 
            pulgada = 0; // reset the line counter 
          } 
        } 
    }
}
