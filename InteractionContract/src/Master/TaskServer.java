package Master;

import java.net.*;
import java.io.*;
//package Master;

/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public class TaskServer extends Thread {

    private final int serverPort;       //recuerda cambiar esta vuelta cucho!!!!!****

    public TaskServer(int serverPort) {

        this.serverPort = serverPort;
    }

    public void run() {

        try {

            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("The Task Server port " + serverPort + "is ready for transfer objects");
            while (true) {
                System.out.println("connecting with Worker");
                Socket socket = serverSocket.accept();

                System.out.println("Got a connection with Client! Starting a Thread Process");
                TaskConnection connection = new TaskConnection(socket); // check where the TaskConnection should be declared 
                connection.start();
            }
        } catch (IOException e) {

            System.out.println("Error when listening a connection" + e.getMessage());
            e.printStackTrace();

        }

    }

}
