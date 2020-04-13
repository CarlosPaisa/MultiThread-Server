package Master;

import java.net.*;
import java.io.*;


/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public class FileServer extends Thread {

    private final int serverPort;

    public FileServer(int serverPort) {

        this.serverPort = serverPort;
    }

    public void run() {

        try {

            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("The File Server port " + serverPort + "is ready for transfer Files");
            while (true) {
                System.out.println("connecting with Worker");
                Socket socket = serverSocket.accept();

                System.out.println("Got a connection with Client! Starting a Thread Process");
                FileConnection connection = new FileConnection (socket); // create class FileServerConnection
                connection.start();
            }
        } catch (IOException e) {

            System.out.println("Error when listening a connection" + e.getMessage());
            e.printStackTrace();

        }

    }

}
