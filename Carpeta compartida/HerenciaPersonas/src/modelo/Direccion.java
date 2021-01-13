package modelo;

//Esta clase no es especializable porque tiene la palabra "final", no puede tener

import java.util.Date;

//subclases
public final class Direccion extends Administracion{
    private int claveAccesoConsejeria;
    private double plusBeneficios = 300;

    public Direccion(String NIF, String apellido1, String apellido2, String nombre, 
                        NivelAdministracion nivel, int clave) {
        super(NIF, apellido1, apellido2, nombre, nivel); 
        this.claveAccesoConsejeria = clave;
    }

    @Override
    public double getSalario() {
        return plusBeneficios + super.getSalario();
    }

    @Override
    public boolean pideDiaLibre(Date dia) {
        //A la direccion siempre se le da el día libre
        return true;
    }
    
    
    
}
