package Master;
import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author  Carlos Arango Velasquez Student ID 12115800
 */
public class Master{
    

    public static void main (String args[]){      //the master starts and is listening in both ports
        int taskServerPort =8888;
        int fileServerPort =8889;
        
        System.out.println("Master is listening on port " + taskServerPort + "for object transfer");
        TaskServer taskServer = new TaskServer(taskServerPort);//to receive task objects and task lists
        taskServer.start();
        
        System.out.println("Master is listening on port " + fileServerPort + "for file transfer");
        FileServer fileServer = new FileServer(fileServerPort);//is on the website moodle
        fileServer.start();
             
    }
 }


