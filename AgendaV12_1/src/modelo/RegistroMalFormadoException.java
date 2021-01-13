package modelo;

public class RegistroMalFormadoException extends IllegalArgumentException {

    //Constructor1
    public RegistroMalFormadoException() {
    }
    
    //Constructor2
    public RegistroMalFormadoException(String msg) {
        
        super(msg);
    }
}
