
package Master;
import java.io.Serializable;
/**
 * 
 *
 * @author Carlos Andres Arango Velasquez Student ID 12115800
 */
public class GCDTask implements Task, Serializable {
    
    private int a; 
    private int b;
    private Object result;
    
    
    public GCDTask (int a, int b){
        this.a = a;
        this.b = b;
    }    
    
    @Override
    public void execute(){
        //write code for calculator 
        result = "GCD for ["+ a + " : " + b + "]";
    }
    
    @Override 
    public Object getResult(){
        return result;
    }
}
