import java.net.Socket;

public class ConnectionEvent {
    
    public ConnectionEvent(Socket S){
        socket = S;
    }
    
    private Socket socket;
    
    public Socket getSocket(){
        return socket;
    }
    
}
