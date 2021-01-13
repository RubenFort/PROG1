package modelo;

public class Persona implements Parlanchin{

    private String nombre;
    private String nacionalidad;
    private String profesion;

    public Persona(String nombre, String nacionalidad, String profesion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.profesion = profesion;
    }

    @Override
    public String daBienvenida() {
        return "Buenas. Soy " + nombre + " de nacionalidad " + nacionalidad + " y mi profesion es " + profesion;
    }

    @Override
    public String despidete() {
        return "Encantado de haber estado con ustedes, se despide " + nombre;  
    }
    
}
