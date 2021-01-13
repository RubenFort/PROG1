package codigo;

public class Coche {
    
    //Declaración de propiedades o atributos (los campos de structs en C)
    private String matricula; 
    private  String marcaModelo; //El formato será marca-modelo
    private int añoCompra;
    private double consumo; //Litros consumidos/100km
    private boolean enPropiedad; //true es nuestro, false está alquilado o en leasing
    
    //Constructores de la clase
    Coche(){
        
    }
    
    Coche(String matricula, String marcaModelo, int añoCompra, double consumo, boolean enPropiedad){
      this.matricula =  matricula;
      this.marcaModelo = marcaModelo;
      this.añoCompra = añoCompra;
      this.consumo = consumo;
      this.enPropiedad = enPropiedad;
    }
    
    //Métodos get para recuperar los atributos
    public String getMatricula(){
        return matricula;
    }
    
    public String getMarcaModelo(){
        return marcaModelo;
    }
    
    public int getAñoCompra(){
        return añoCompra;
    }
    
    public double getConsumo(){
        return consumo;
    }
    
    public boolean isEnPropiedad(){
        return enPropiedad;
    }
    
    //Métodos set para escribir los atributos
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public void setMarcaModelo(String marcaModelo){
        this.marcaModelo = marcaModelo;
    }
    
    public void setAñoCompra(int añoCompra){
        this.añoCompra = añoCompra;
    }
    
    public void setConsumo(double consumo){
        this.consumo = consumo;
    }
    
    public void setEnPropiedad(boolean enPropiedad){
        this.enPropiedad = enPropiedad;
    }
    
}
