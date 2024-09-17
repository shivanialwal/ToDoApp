
import java.util.List;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();

    public int addTask(Task task) {
        int taskId = 0;
        taskRepository.addTask(task);
        System.out.println("-----------------------------------------------");
        System.out.println("Task Id: " + task.taskId);
        System.out.println("Title: " + task.title);
        System.out.println("Description: " + task.description);
        System.out.println("Deadline: " + task.deadline);
        System.out.println("Status "+task.status);
        return taskId;
    }

    public Task updateTask(int taskId, Task task) {
        System.out.println("Updating task " + taskId);
        return taskRepository.updateTask(taskId, task);

    }

    public void deleteTask(int taskId) {
        System.out.println("Deleting task " + taskId);
        taskRepository.deleteTask(taskId);
    }

    public List<Task> viewTasks() {
        System.out.println("Viewing tasks");
        return taskRepository.getTasks();
    }
}
