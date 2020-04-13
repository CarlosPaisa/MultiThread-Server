
package Master;
import java.io.Serializable;
/**
 *
 * @author 
 */
public class PrimeTask implements Task, Serializable {
    private int n;
    private Object result;
    
    public PrimeTask(int n){
        this.n=n;
    }
    
    @Override 
    public void execute(){
        //write code for calculation
        result ="primer for " + n;
    }
    
    @Override
    public Object getResult(){
        return result;
    }
}
