package tabladelaverdad;

public class TablaDeLaVerdad {
//Tabla de la verdad de los operadores lógicos
    public static void main(String[] args) {
        boolean p, q;
        
        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
        
        p=q=true;
        
        System.out.print(p+"\t"+q+"\t");
        System.out.print((p&q)+"\t"+(p|q)+"\t");
        System.out.println((p^q)+"\t"+(!p));
        
        p=true;
        q=false;
        System.out.print(p+"\t"+q+"\t");
        System.out.print((p&q)+"\t"+(p|q)+"\t");
        System.out.println((p^q)+"\t"+(!p));
        
        p=false;
        q=true;
        System.out.print(p+"\t"+q+"\t");
        System.out.print((p&q)+"\t"+(p|q)+"\t");
        System.out.println((p^q)+"\t"+(!p)); 
        
        p=q=false;
        System.out.print(p+"\t"+q+"\t");
        System.out.print((p&q)+"\t"+(p|q)+"\t");
        System.out.println((p^q)+"\t"+(!p)); 
        
        
    }   
}
