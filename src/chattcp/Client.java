package chattcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Chatter {
    
    private final int port;
    
    private final String address;

    public Client(int port, String address) {
        this.name="Chatter2";
        this.state=true;
        this.colour="";
        this.port=port;
        this.address=address;
    }
    
    public void start(){
        try {
            dataSocket = new Socket(address,port);
            configure();
            sendMsg();
        } catch (ConnectException e){
            System.err.println("Can't reach server");
        }
        catch(UnknownHostException e1){
            System.err.println("DNS Error!");
        }
        catch(IOException e2){//
            System.err.println(e2);
        }
        finally {
            close();
        }
    }
}
