package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static tester.Tester1.serverLogger;

public class ServerListenerThread extends Thread{

    private ServerSocket serverSocket;

    public ServerListenerThread(ServerSocket serverSocket){

        this.serverSocket = serverSocket;

    }

    @Override
    public void run() {
        //TODO implementare logica decente es controllo stato socket e che non si a chiuso
        while (true){

            try {

                Socket newConnectedSocket = this.serverSocket.accept();
                serverLogger.info("Inbound Connnection detected on address:"+newConnectedSocket.getInetAddress());
                WorkerThread workerThread = new WorkerThread(newConnectedSocket);
                serverLogger.info("Handling of the connection given to a new thread");
                workerThread.start();

            } catch (IOException e) {
                //TODO IMPLEMNETARE STAMPA ERRORI
                e.printStackTrace();

            }


        }

    }
}
