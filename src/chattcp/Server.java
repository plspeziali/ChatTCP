package chattcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author paolo
 */
public class Server extends Chatter {

    private final int port;
    
    /**
     * Socket per connettersi al client
     */
    private ServerSocket connection;

    /**
     *
     * @param port Porta su cui ascoltare per le comunicazioni
     */
    public Server(int port) {
        super();
        this.name="Chatter1";
        this.state=true;
        this.colour="";
        this.port=port;
    }
    
    /**
     * Si connette al server, avvia la configurazione iniziale dell'utente
     * e i metodi per chattare
     */
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
