package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chatter {

    public String name;

    public boolean state;

    public String colour;

    public Socket dataSocket;
    
    public ChatThread ct;
    
    public String buffer;
    
    public String echo;
    
    public void configure(){
        buffer="";
        echo="";
        ct = new ChatThread(this);
        ct.start();
    }
        
    public void sendMsg(boolean server) {
        PrintWriter out;
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
                    case "colour":
                        setColour();
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
        System.out.println("Write your new name");
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        boolean cont = false;
        do{
            try {
                name = tastiera.readLine();
            } catch (IOException ex) {
                System.err.println("IOException error!");
            }
            if(!name.contains(":")){
                cont = true;
            } else {
                System.out.println("Your name can't contain the : symbol, write another one!");
            }
        }
        while(cont!=true);
        this.name = name;
        System.out.println("Name changed succesfully!");
    }
    
    public void setColour(){
        System.out.println("Choose your colour:\nBlack (default)\nRed (r)\nGreen (g)\nYellow (y)\nBlue (b)\nPurple (p)\nCyan (c)");
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String colour = "";
        try {
            colour = tastiera.readLine();
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
        switch(colour){
            case "r":
                this.colour="\u001B[31m";
                break;
            case "g":
                this.colour="\u001B[32m";
                break;
            case "y":
                this.colour="\u001B[33m";
                break;
            case "b":
                this.colour="\u001B[34m";
                break;
            case "p":
                this.colour="\u001B[35m";
                break;
            case "c":
                this.colour="\u001B[36m";
                break;
            default:
                this.colour="\u001B[0m";
        }
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
