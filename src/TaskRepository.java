import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    
    public static List<Task> taskDB = new ArrayList<>();

    public boolean addTask(Task task) {
        return taskDB.add(task);
    }

    public Task updateTask(int index, Task task) {
        return taskDB.set(index, task);
    }
    public Task deleteTask(int index) {
        return taskDB.remove(index);
    }

    public List<Task> getTasks() {
        return taskDB;
    }

}
