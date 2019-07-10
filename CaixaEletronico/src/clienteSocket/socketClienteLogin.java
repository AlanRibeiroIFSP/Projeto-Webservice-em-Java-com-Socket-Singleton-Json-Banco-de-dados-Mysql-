package clienteSocket;
import java.io.IOException;
import java.net.Socket;

public class socketClienteLogin {      
    private final Socket socket;
    private static final String USUARIO="localhost";
    private static final Integer PORTA=8182;

    @SuppressWarnings("empty-statement")
    public socketClienteLogin() throws IOException {
        this.socket = new Socket(USUARIO, PORTA);;
    }
    
    public Socket getSocket(){
        return socket;
    }

  

    
    
    
    
    
    
}