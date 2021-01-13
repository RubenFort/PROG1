package modelo;

public class Perro implements Parlanchin{

    String nombre;
    String raza;
    int chipID;

    public Perro(String nombre, String raza, int chipID) {
        this.nombre = nombre;
        this.raza = raza;
        this.chipID = chipID;
    }

    @Override
    public String daBienvenida() {
        return "Guau, guau. Soy " + nombre + ". Un " + raza + " y mi ID es " + chipID;
    }

    @Override
    public String despidete() {
        return "Guauuuuuuuuuuuuuu se va " + nombre;
    }
    
}
