package modelo;

public class Mantenimiento extends Empleado{
  
    private Oficio oficio;  //Electricidad, Obra-General, Carpinteria
    private double precioHoraExtra = 9;
    private int horasExtraRealizadas;

    public Mantenimiento(String NIF, String apellido1, String apellido2, String nombre, Oficio oficio) {
        super(NIF, apellido1, apellido2, nombre);
        this.oficio = oficio;
    }

    public void setHorasExtraRealizadas(int horasExtraRealizadas) {
        this.horasExtraRealizadas = horasExtraRealizadas;
    }
    
    
    @Override
    public double getSalario() {
        return super.getSalario() + (horasExtraRealizadas * precioHoraExtra);
    }
    
}
