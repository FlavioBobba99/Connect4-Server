package core;

import java.io.*;
import java.net.Socket;

import static tester.Tester1.serverLogger;

public class WorkerThread extends Thread{

    private Socket socket;
    private BufferedReader socketInput=null;
    private PrintWriter socketOutput=null;
    private Player player = null;
    private ServerMemory myMemory;

    public WorkerThread(Socket socket){

        this.socket = socket;
        setupReaders();
        myMemory = ServerMemory.getServerMemory();

    }

    @Override
    public void run() {

        serverLogger.info("handling of the connection inizialized");


        try {

            while (true) {

                System.out.println("aa");
                System.out.println(this.socketInput.readLine());
                parseString(this.socketInput.readLine());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    // metodo per inzializzare gli input e gli output
    private void setupReaders(){
        try {
            this.socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socketOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseString(String message){
        String[] parts = message.split(",");

        switch (parts[0]){
            case "newNick":
                this.player = new Player(socket,parts[1]);
                this.myMemory.addPlayer(player);
                break;
            /*
            case "addToken":
                if(gameStatus.lastcolor==parts[1])
                    //aggiunta token in parts[2]
                    break;
            case "casualMatch":*/
        }


    }

}
