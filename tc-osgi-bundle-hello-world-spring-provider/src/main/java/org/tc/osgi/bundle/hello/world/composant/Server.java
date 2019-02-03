import java.net.Socket;
import java.net.ServerSocket;

public class Server extends Activite{
    
    private int port;
    private transient java.util.ArrayList connectionListenerList;
    
    public Server() {
        super();
        this.setPort(80);
    }
    
    public int getPort() {
        return this.port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public synchronized void addConnectionListener(ConnectionListener listener) {
        if (connectionListenerList == null ) {
            connectionListenerList = new java.util.ArrayList();
        }
        connectionListenerList.add(listener);
    }
    
    public synchronized void removeConnectionListener(ConnectionListener listener) {
        if (connectionListenerList != null ) {
            connectionListenerList.remove(listener);
        }
    }
    
    private void fireConnectionListenerConnectionDetected(ConnectionEvent event) {
        java.util.ArrayList list;
        synchronized (this) {
            if (connectionListenerList == null) return;
            list = (java.util.ArrayList)connectionListenerList.clone();
        }
        for (int i = 0; i < list.size(); i++) {
            ((ConnectionListener)list.get(i)).connectionDetected(event);
        }
    }
    
    public void start(){
        try{
            server_socket = new ServerSocket(getPort());
            super.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private ServerSocket server_socket;
    
    protected void action() {
        try{
            Socket S = server_socket.accept();
            ConnectionEvent event = new ConnectionEvent(S);
            fireConnectionListenerConnectionDetected(event);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
