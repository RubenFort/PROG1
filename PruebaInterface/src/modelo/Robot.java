package modelo;

public class Robot implements Parlanchin{

    String fabricante;
    String modelo;
    int numeroSerie;

    public Robot(String fabricante, String modelo, int numeroSerie) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String daBienvenida() {
        return "Click, click. Soy un robot de marca " + fabricante + " mi modelo es  " + modelo + " y mi nº de serie es " + numeroSerie;
    }

    @Override
    public String despidete() {
        return "Daysi, daysi ... me están desconectando. Este es el final de " + numeroSerie;
    }
    
}
