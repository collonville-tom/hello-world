
public class StartServer {
    
    public StartServer() {
    }
    
    public static void main(String[] args) {
        Server S = new Server();
        S.start();
        System.out.println("<SERVER RUNNING ...>");
        S.addConnectionListener(new ConnectionListener(){
           public void connectionDetected(ConnectionEvent e){
               System.out.println("<CONNECTION DETECTEE>");
           }
        });
    }
}
