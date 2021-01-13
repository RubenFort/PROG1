package modelo;

public class Administracion extends Empleado{
    
    private NivelAdministracion categoria;

    public Administracion(String NIF, String apellido1, String apellido2, String nombre,
            NivelAdministracion nivel) {
        super(NIF, apellido1, apellido2, nombre);
        this.categoria = nivel;
    }

    @Override
    public double getSalario() {
        double salario = super.getSalario();
        switch(categoria) {
            case ADMINISTRATIVO:
                salario += 50;
                break;
            case JEFE_GRUPO:
                salario += 100;
                break;
            case JEFE_SECCION:
                salario += 150;
                break;
            case JEFE_SERVICIO:
                salario += 200;
                break;
        }
        return salario;
    }
}
