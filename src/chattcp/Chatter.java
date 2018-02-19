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
    
    public String echo;
    
    public static boolean flagServer=false ;
    
    public static boolean flagClient=false;
    
    public void configure(){
        buffer="";
        echo="";
        ct = new ChatThread(this);
        ct.start();
    }
        
    public void sendMsg(boolean server) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(dataSocket.getOutputStream(), true);
            System.err.println("Connected!");
            boolean stop = false;
            String msg;
            do {
                BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
                msg = tastiera.readLine();
                switch(msg){
                    case "":
                        break;
                    case "end":
                        stop = true;
                        out.println(msg);
                        break;
                    case "online":
                        setState(true);
                        break;
                    case "offline":
                        setState(false);
                        break;
                    case "echo":
                        out.println(colour+name+": "+echo.substring(echo.indexOf(':')+2));
                        break;
                    case "username":
                        setName();
                        break;
                    default:
                        if(state==true){
                            if(msg.contains("smile")){
                                msg = msg.replaceAll("smile", "☺");
                            }
                            if(msg.contains("like")){
                                msg = msg.replaceAll("like", "👍");
                            }
                            if(msg.contains("tom cruise")){
                                msg = msg.replaceAll("tom cruise", "😎");
                            }
                            out.println(colour+name+": "+msg);
                        } else {
                            System.out.println("You can't send messages while you are offline!");
                        }
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
            buffer = buffer.concat(msg+"\n");
        }
        echo = msg;
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
            System.out.print(buffer);
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
