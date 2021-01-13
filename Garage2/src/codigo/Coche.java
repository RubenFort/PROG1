package codigo;

public class Coche {

    private String matricula;
    private String marcaModelo;
    private int anoCompra;
    private double consumo;
    private boolean enPropieda;

    //Constructores
    Coche() {

    }

    Coche(String matricula, String marcaModelo, int anoCompra, double consumo, boolean enPropieda) {

        this.matricula = matricula;
        this.marcaModelo = marcaModelo;
        this.anoCompra = anoCompra;
        this.consumo = consumo;
        this.enPropieda = enPropieda;
    }

    //Metodos para recuperar e adjudicar valores (Getters y Setters)
    public String getMatricula() {
        return matricula;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public int getAnoCompra() {
        return anoCompra;
    }

    public double getConsumo() {
        return consumo;
    }

    public boolean getEnRpopiedad() {
        return enPropieda;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public void setAnoCompra(int anoCompra) {
        this.anoCompra = anoCompra;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setEnPropieda(boolean enPropieda) {
        this.enPropieda = enPropieda;
    }

}
