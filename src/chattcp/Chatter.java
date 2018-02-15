package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chatter {

    public String name;

    public boolean state;

    public String colour;

    public Socket dataSocket;

    public PrintWriter out;

    public Scanner in;
    
    public ChatThread ct;
    
    public String buffer;
    
    public void configure(){
        try {
            in = new Scanner(dataSocket.getInputStream());
            out = new PrintWriter(dataSocket.getOutputStream());
            ct = new ChatThread(in,out,this);
            ct.start();
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
    }
        
    public void sendMsg() {
        System.err.println("Connected!");
        boolean stop = false;
        do {
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            String msg = "";
            try {
                msg = tastiera.readLine();
            } catch (IOException ex) {
                System.err.println("Keyboard input error");
            }
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
}
