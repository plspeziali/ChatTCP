package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chatter {

    public String name;

    public boolean state;

    public String colour;

    public Socket dataSocket;
    
    public ChatThread ct;
    
    public String buffer;
    
    public static boolean flagServer=false ;
    
    public static boolean flagClient=false;
    
    public void configure(){
        ct = new ChatThread(this);
        ct.start();
    }
        
    public void sendMsg(boolean server) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(dataSocket.getOutputStream(), true);
            System.err.println("Connected!");
            boolean stop = false;
            do {
                BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
                String msg = "";
                msg = tastiera.readLine();
                switch(msg){
                    case "":
                        break;
                    case "end":
                        stop = true;
                        out.println(msg);
                        break;
                    default:
                        out.println(colour+name+": "+msg);
                }
            } while (stop == false);
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
    }

    public void receiveMsg(String msg) {
        if(state == true){
            System.out.println(msg);
        } else {
            buffer.concat("msg\n");
        }
    }

    public void close() {
        if (dataSocket!=null) {
            try {
                dataSocket.close();
            } catch (IOException ex) {
                System.err.println("IOException error!");
            }
        }
    }
    
    public void setName(){
        
    }
    
    public void setColour(){
        
    }
    
    public void setState(boolean state){
        if(state==this.state){
            System.out.println("You are already in this state!");
        } else if(state==true) {
            System.out.println("You are now online");
            System.out.println(buffer);
            buffer="";
            this.state=state;
        } else if(state==false) {
            System.out.println("You are now offline");
            this.state=state;
        }
    }
    
    public boolean getState(){
        return state;
    }
    
    public Socket getSocket(){
        return dataSocket;
    }
}
