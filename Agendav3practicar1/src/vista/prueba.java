
package vista;

import modelo.Contacto;
import modelo.Agenda;

public class prueba {

    public static Agenda pruebaAgenda;
    
    public static void main(String[] args) {
        
        //CREA AGENDA CAPACIDAD 3;
        System.out.println("----------------------------------------");
        System.out.println("CREA AGENDA CAPACIDAD 3");
        pruebaAgenda = new Agenda(3);
        
        //LISTAMOS AGENDA
        Contacto [] pruebaContactos;
        System.out.println("----------------------------------------");
        System.out.println("LISTAMOS AGENDA");
        
        pruebaContactos=pruebaAgenda.getAllContactos();
        for (int i = 0; i < pruebaContactos.length; i++) {
            System.out.println("ID: "+pruebaContactos[i].getId()+"  Nombre: "+pruebaContactos[i].getNombre());
            System.out.println("");
        }
        
        //AÑADO 3 CONTACTOS
        System.out.println("----------------------------------------");
        System.out.println("AÑADO 3 CONTACTOS");
        if(pruebaAgenda.addContacto(new Contacto("Luis", "02/02/2002", 677123123, 'A', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("Agenda llena, no se guardó el contacto");
        }
        
        if(pruebaAgenda.addContacto(new Contacto("Pepe", "22/11/2012", 981489669, 'F', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("Agenda llena, no se guardó el contacto");
        }
        
        if(pruebaAgenda.addContacto(new Contacto("Coco", "08/08/1980", 676114114, 'T', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("Agenda llena, no se guardó el contacto");
        }
        
        //LISTAMOS AGENDA
        System.out.println("----------------------------------------");
        System.out.println("LISTAMOS AGENDA");
        pruebaContactos=pruebaAgenda.getAllContactos();
        for (int i = 0; i < pruebaContactos.length; i++) {
            System.out.println("ID: "+pruebaContactos[i].getId()+"  Nombre: "+pruebaContactos[i].getNombre());
        }
        
        //AÑADO 1 CONTACTO (no se puede, va a dar false)
        System.out.println("----------------------------------------");
        System.out.println("AÑADO 1 CONTACTO");
        if (pruebaAgenda.addContacto(new Contacto("Ana", "24/07/1994", 986878878, 'T', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("Agenda llena, no se guardó el contacto");
        }
        
        //BORRO 1 CONTACTO
        System.out.println("----------------------------------------");
        System.out.println("BORRO 1 CONTACTO");
        if (pruebaAgenda.deleteContactoById(1)){
            System.out.println("Contacto borrado");
        } else {
            System.out.println("No se borró el contacto");
        }
        
        //LISTAMOS AGENDA
        System.out.println("----------------------------------------");
        System.out.println("LISTAMOS AGENDA");
        pruebaContactos=pruebaAgenda.getAllContactos();
        for (int i = 0; i < pruebaContactos.length; i++) {
            System.out.println("ID: "+pruebaContactos[i].getId()+"  Nombre: "+pruebaContactos[i].getNombre());   
        }
        
        //AÑADO 1 CONTACTO
        System.out.println("----------------------------------------");
        System.out.println("AÑADO 1 CONTACTO");
        if (pruebaAgenda.addContacto(new Contacto("Juan", "18/09/1998", 982456852, 'E', false))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("Agenda llena, no se guardó el contacto");
        }
        
                //LISTAMOS AGENDA
        System.out.println("----------------------------------------");
        System.out.println("LISTAMOS AGENDA");
        pruebaContactos=pruebaAgenda.getAllContactos();
        for (int i = 0; i < pruebaContactos.length; i++) {
            System.out.println("ID: "+pruebaContactos[i].getId()+"  Nombre: "+pruebaContactos[i].getNombre());   
        }
    }
    
}
