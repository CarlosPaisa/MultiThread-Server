package Master;

//import Master.Task;
import java.io.Serializable;

/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public class TaskObject implements Serializable {

    private Integer TaskID; //task to server 
    private Integer Credit;
    private Task concreteTask;//the server check the taskid here and pick one from here **pi task 

    //public TaskObject() {
    //}

    public Integer getTaskID() {
        return TaskID;
    }

    public void setTaskID(Integer TaskID) {
        this.TaskID = TaskID;
    }

    public Integer getCredit() {
        return Credit;
    }

    public void setCredit(Integer Credit) {
        this.Credit = Credit;
    }

    public Task getConcreteTask() {
        return concreteTask;
    }

    public void setConcreteTask(Task task) {
        this.concreteTask = task;
    }
}
