package codigo;

public class Coche {
    //Declaración de propiedades o atributos (los campos de structs en C)
    private String matricula; 
    private String marcaModelo; //El formato será marca-modelo
    private int añoCompra;
    private double consumo; //Litros consumidos/100km
    private boolean enPropiedad; //true es nuestro, false está alquilado o en leasing
    
    //constructores de clase
    Coche() {

    }
    
    Coche(String matricula, String marcaModelo, int añoCompra, double consumo, boolean enPropiedad) {
   
        this.matricula=matricula;
        this.marcaModelo=marcaModelo;
        this.añoCompra=añoCompra;
        this.consumo=consumo;
        this.enPropiedad=enPropiedad;
    }
    //metodos get para recuperar los atributos(getters)
    String getMatricula(){
        return matricula;
    }
    
    String getMarcaModelo(){
        return marcaModelo;
    }
    
    int getAñoCompra() {
        return añoCompra;
    }
    
    double getConsumo() {
        return consumo;
    }
    
    boolean isEnPropiedad(){
        return enPropiedad;
    }
    
    //metodos set para escribir los atributos
    void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    void setMarcaModelo (String marcaModelo){
        this.marcaModelo = marcaModelo;
    }
    
    void setAñoCompra (int añoCompra) {
        this.añoCompra = añoCompra;
    }
    
    void setConsumo (double consumo) {
        this.consumo = consumo;
    }
    
    void setEnPropiedad (boolean enPropiedad) {
        this.enPropiedad = enPropiedad;
    }
    
    
}
