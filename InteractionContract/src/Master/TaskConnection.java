package Master;

import java.net.*;
import java.io.*;
//import java.io.InputStream;
//import java.io.OutputStream;

/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public class TaskConnection extends Thread {

    //according with profe these are computing tasks
    private static final String[] computingTaskNames/*COMPUTING_TASK_NAMES*/ = { //cambiar formato 
        "Calculating Pi to 50 decimal digits ",
        "Calculating prime from 1 to 70 ",
        "Calculating GCD from 128 to 76 ",
        "Calculating Pi to 70 decimal digits",
        "Calculating prime from 1 to 100",
        "Calculating GCD of 252 and 24"
    };
    private static final String[] classNames /*CLASS_NAMES*/= {
        "PiTask.class",
        "PrimeTask.class",
        "GCDTask.class",
        "PiTask.class",
        "PrimeTask.class",
        "GCDTask.class"
    };
    //the objects of the tasks
    private static final Task[] concreteTasks/*CONCRETE_TASKS*/ = {//los numeros es lo que va a calcular 

        new PiTask(50),
        new PrimeTask(70),
        new GCDTask(128, 76), //como cada numero es calculado en pitask etc..
        new PiTask(70),
        new PrimeTask(100),
        new GCDTask(252, 24)
    };

    //credits of the tasks 
    private static final Integer[] credits/*CREDITS*/ = {
        new Integer(30),
        new Integer(20),
        new Integer(25),
        new Integer(35),
        new Integer(25),
        new Integer(30)
    };

    private Socket clientSocket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public TaskConnection(Socket clientSocket) {

        try {
            this.clientSocket = clientSocket;
            this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error when getting Streams from Master" + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object object = objectInputStream.readObject();
                if (object instanceof TaskList) {
                    TaskList taskList = (TaskList) object;
                    fillTaskList(taskList);
                    objectOutputStream.writeObject(taskList);

                } else if (object instanceof TaskObject) {
                    TaskObject taskObject = (TaskObject) object;
                    Integer taskID = taskObject.getTaskID();
                    Task concreteTasks = taskObject.getConcreteTask();   //check 3:02

                    //To do do something with the concrete task here***************************2:43 video 16
                    /*your task id put into task object and set up task object*/
                    //send taskObject back to the client /worker*******************************
                    
                    
                    objectOutputStream.writeObject(taskObject);
                    objectOutputStream.flush();
                }
            } catch (EOFException e) {
                System.out.println("Worker has left EOF Error: " + e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException " + e.getMessage());
                break;
            }
        } 
        if (clientSocket != null) {
            try {
                 clientSocket.close();
           } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                    e.printStackTrace();
            }
        }
    }
       

    private void fillTaskList(TaskList taskList) {
        taskList.setAvailableTaskNames(computingTaskNames); //check this too *********2:05 video 16
        taskList.setTaskClassNames(classNames);
    }

    private String getTaskName(Integer TaskId) {
        return computingTaskNames[TaskId];
    }

    private Task getConcreteTask(Integer TaskId) {
        return concreteTasks[TaskId];
    }

    private Integer getCredit(Integer TaskId) {
        return credits[TaskId];
    }
    
}