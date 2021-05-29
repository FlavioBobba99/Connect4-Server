package core;

import java.io.*;
import java.net.Socket;

import static tester.Tester1.serverLogger;

public class WorkerThread extends Thread{

    private Socket socket;
    private BufferedReader socketInput=null;
    private PrintWriter socketOutput=null;

    public WorkerThread(Socket socket){

        this.socket = socket;
        setupReaders();

    }

    @Override
    public void run() {

        serverLogger.info("handling of the connection inizialized");


        try {

            while (true) {

                System.out.println("aa");
                System.out.println(this.socketInput.readLine());

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


}
