package modelo;

public class RegistroContactoMalFormadoException extends IllegalArgumentException {

    //Constructor1
    public RegistroContactoMalFormadoException() {
    }
    
    //Constructor2
    public RegistroContactoMalFormadoException(String msg) {
        
        super(msg);
    }
}
