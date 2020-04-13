package Master;
import java.io.Serializable;
/**
 *
 * @author carlo
 */
public class PiTask implements Task, Serializable {
    
    private int digits;
    private Object result;
    
    public PiTask(int digits){
        this.digits = digits;
    }
    
    @Override
    public void execute(){
    //write code for calculation
    result = "Pi result for " + digits;
    }
    
    @Override
    public Object getResult(){
    return result;
    } 
    
    
}
