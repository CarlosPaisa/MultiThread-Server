package Master;

import java.io.Serializable;

/**
 *
 * @author Carlos Arango Velasquez Student ID 12115800
 */
public class TaskList implements Serializable {

    private String[] availableTasksNames;
    private String[] taskClassNames;

    public String[] getAvailableTasks() {
        return availableTasksNames;
    }

    public void setAvailableTasks(String[] taskNames) {
        this.availableTasksNames = taskNames;
    }

    public String[] getTaskClassName() {
        return taskClassNames;
    }

    public void setTaskClassName(String[] TaskClassName) {
        this.taskClassNames = taskClassNames;
    }
}
