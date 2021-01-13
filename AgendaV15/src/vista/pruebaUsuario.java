package vista;

import modelo.Agenda;
import modelo.Usuario;

public class pruebaUsuario {
    
    public static Agenda misAgenda;
    
    public static void main(String[] args){
        
        misAgenda=new Agenda();
        
        boolean a;
        
        Usuario u1 = new Usuario("ruben", "1234");
        a=misAgenda.addUsuario(u1);
        Usuario u2 = new Usuario("ruben", "1234");
        a=misAgenda.addUsuario(u2);
        Usuario u3 = new Usuario("pepe", "1234");
        a=misAgenda.addUsuario(u3);
        
        int indice = misAgenda.compruebaUsuario("pepe", "1234");
        
        System.out.println(indice);
        
    }
}
