package chattcp;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Chatter {

    private final int port;
    
    private ServerSocket connection;

    public Server(int port) {
        super();
        this.name="Chatter1";
        this.state=true;
        this.colour="";
        this.port=port;
    }
    
    public void start(){
        try{
            connection = new ServerSocket(port);
            dataSocket = connection.accept();
            configure();
            sendMsg(true);
        } catch(IOException e2){//
            System.err.println(e2);
        }
        finally{
            close();
        }
    }
}
