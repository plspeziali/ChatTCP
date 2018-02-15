package chattcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server extends Chatter {

    private final int port;
    
    private ServerSocket connection;

    public Server(int port) {
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
            sendMsg();
        } catch(IOException e2){//
            System.err.println(e2);
        }
        finally{
            close();
        }
    }
}
