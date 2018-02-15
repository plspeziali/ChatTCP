package chattcp;

import java.io.PrintWriter;
import java.util.Scanner;

public class ChatThread extends Thread{

    private Scanner in;

    private Chatter owner;
    
    private PrintWriter out;

    public ChatThread(Scanner in, PrintWriter out, Chatter owner) {
        this.in=in;
        this.out=out;
        this.owner=owner;
    }

    @Override
    public void run() {
        String msg = null;
        while(true){
            if ((msg = in.nextLine()) != null) {
                if(owner.getState()==true){
                    if(!msg.equals("end")){
                        owner.receiveMsg(msg);
                    } else {
                        break;
                    }
                } else {
                    out.println("The other user is offline, he will get the message as soon as he gets online!");
                    owner.receiveMsg(msg);
                }
            }
        }
    }
}
