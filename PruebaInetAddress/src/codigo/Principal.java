package codigo;

import java.net.InetAddress;

public class Principal {

    public static void main(String[] args) {
        
        InetAddress loopBack = InetAddress.getLoopbackAddress();
        
        System.out.println("LoopBack Address: " + loopBack);
        
    }
    
}
