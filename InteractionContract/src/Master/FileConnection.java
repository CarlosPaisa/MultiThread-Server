package Master;

import java.net.*;
import java.io.*;

/**
 *
 * @author
 */
public class FileConnection extends Thread {

    private Socket clientSocket;
    private FileInputStream fis;
    private FileOutputStream fos;

    public FileConnection(Socket aclientSocket) {
        try {
            this.clientSocket = aclientSocket;
            fis = new FileInputStream(clientSocket.getInputStream());
            fos = new FileOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Error when getting Streams from Master" + e.getMessage());
        }
    }

    @Override
    public void run() {
        String ClassName = new String();//sera que llamo ClassNames de TaskConnection?
        while (true) {
            try {
                //Read the file name
                ClassName = fis.readUTF();
                //Send the file
                File ClassFile = new File(ClassName);//check if I have to change it for the numbers
                byte[] buffer = new byte[(int) ClassFile.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ClassFile));
                bis.read(buffer, 0, buffer.length);
                fos.write(buffer, 0, buffer.length);
                fos.flush();
                bis.close();
                System.out.println("File " + ClassName + " transferred.");
            } catch (EOFException e) {
                System.out.println("EOF" + e.getMessage());
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File " + ClassName + " cannot find.");
                break;
            } catch (SocketException e) {
                System.out.println("Client closed.");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
