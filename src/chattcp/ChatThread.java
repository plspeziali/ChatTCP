package chattcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author paolo
 */
public class ChatThread extends Thread{

    private final Chatter owner;

    /**
     * Costruttore
     * @param owner L'oggetto Chatter (e quindi l'utente) a cui
     * appartiene questo ChatThread
     */
    public ChatThread(Chatter owner) {
            this.owner=owner;
    }

    @Override
    public void run() {
        receiveMsg();
    }
    
    /**
     *  Permette di ascoltare l'input del Socket e leggere i messaggi in arrivo
     */
    public void receiveMsg(){
        try {
            Scanner in = new Scanner(owner.getSocket().getInputStream());
            PrintWriter out = new PrintWriter(owner.getSocket().getOutputStream(), true);
            String msg = null;
            while(true){
                if(owner.getSocket().isConnected()){
                    if ((msg = in.nextLine()) != null){
                        if(owner.getState()==true){
                            owner.receiveMsg(msg);
                        } else {
                            out.println("The other user is offline, he will get the message as soon as he gets online!");
                            owner.receiveMsg(msg);
                        }
                    }
                } else {
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
    }
}
