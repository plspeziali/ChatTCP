package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author paolo
 */
public class Chatter {

    /**
     * Nome dell'utente della chat
     */
    public String name;

    /**
     * Stato dell utente (online/offline)
     */
    public boolean state;

    /**
     * Colore dei messaggi dell'utente
     */
    public String colour;

    /**
     * Socket per la trasmissione dei dati tra Client e Server
     */
    public Socket dataSocket;
    
    /**
     * Thread per la ricezione dei messaggi
     */
    public ChatThread ct;
    
    /**
     * Area di memeoria dove si memorizzano i messaggi che arrivano mentre
     * l'utente è offline
     */
    public String buffer;
    
    /**
     * Area di memeoria dove si memorizza l'ultimo messaggio ricevuto
     */
    public String echo;
    
    /**
     * Metodo iniziale per la configurazione dell'utente:
     * inizializza i buffer ed avvia un ChatThread
     */
    public void configure(){
        buffer="";
        echo="";
        ct = new ChatThread(this);
        ct.start();
    }
        
    /**
     * Metodo per inviare messaggi all'interlocutore o per
     * eseguire i comandi possibili
     */
    public void sendMsg() {
        PrintWriter out;
        try {
            out = new PrintWriter(dataSocket.getOutputStream(), true);
            System.err.println("Connected!");
            out.println(colour+name+": "+"Hello! I'm "+name+", nice to meet you!"+"\u001B[0m");
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
                        out.println(colour+name+": Goodbye!"+"\u001B[0m");
                        out.println(msg);
                        break;
                    case "help":
                        printMan();
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
                            out.println(colour+name+": "+msg+"\u001B[0m");
                        } else {
                            System.out.println("You can't send messages while you are offline!");
                        }
                }
            } while (stop == false);
        } catch (IOException ex) {
            System.err.println("IOException error!");
        }
    }

    /**
     * Metodo che viene richiamato dal ChatThread alla ricezione
     * di un messaggio per stamparlo nello Standard Output
     * @param msg Messaggio da stampare
     */
    public void receiveMsg(String msg) {
        if(state == true){
            System.out.println(msg);
        } else {
            buffer = buffer.concat(msg+"\n");
        }
        echo = msg;
    }
    
    /**
     * Stampa il manuale e i comandi possibili
     */
    public void printMan(){
        System.out.println("Commands list:\nhelp: View the manual\n"
                + "end: Interrupt the communication\n"
                + "online: Set ypour status as \"online\"\n"
                + "offline: Set ypour status as \"offline\"\n"
                + "echo: Send the last message received\n"
                + "username: Set the username of the Chatter\n"
                + "colour: Set the colour of the messages");
    }

    /**
     * Chiude il Socket e le comunicazioni
     */
    public void close() {
        if (dataSocket!=null) {
            try {
                dataSocket.close();
            } catch (IOException ex) {
                System.err.println("IOException error!");
            }
        }
    }
    
    /**
     * Permette all'utente di cambiare il suo username
     */
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
    
    /**
     * Permette all'utente di cambiare il suo colore
     */
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
    
    /**
     * Permette all'utente di cambiare il suo stato
     * @param state Valore dello stato da impostare
     */
    public void setState(boolean state){
        if(state==this.state){
            System.out.println("You are already in this state!");
        } else if(state==true) {
            System.out.println("You are now online");
            System.out.print(buffer+colour);
            buffer="";
            this.state=state;
        } else if(state==false) {
            System.out.println("You are now offline");
            this.state=state;
        }
    }
    
    /**
     * Ritorna lo stato dell'utente
     * @return state
     */
    public boolean getState(){
        return state;
    }
    
    /**
     * Ritorna il dataSocket utilizzato nella comunicazione
     * @return dataSocket
     */
    public Socket getSocket(){
        return dataSocket;
    }
}
