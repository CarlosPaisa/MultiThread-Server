package Master;

import java.io.Serializable;
/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public interface Task {

    public void execute(); //will perform the task and set the result
   
    public Object getResult();//will return the result 

}
