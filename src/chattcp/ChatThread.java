package chattcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChatThread extends Thread{

    private Chatter owner;

    public ChatThread(Chatter owner) {
            this.owner=owner;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(owner.getSocket().getInputStream());
            PrintWriter out = new PrintWriter(owner.getSocket().getOutputStream(), true);
            String msg = null;
            while(true){
                if ((msg = in.nextLine()) != null){
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
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
    }
}
