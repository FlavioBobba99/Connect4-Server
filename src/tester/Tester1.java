package tester;

import core.ServerListenerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class Tester1 {

    public static int port = 25565;
    public static Logger serverLogger = Logger.getLogger("logger_1");

    public static void main(String[] args) {

        try {

            serverLogger.info("Server starting...");

            ServerSocket serverSocket = new ServerSocket(port);
            ServerListenerThread serverListenerThread = new ServerListenerThread(serverSocket);
            serverListenerThread.start();

            serverLogger.info("listening started on port:"+port);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
