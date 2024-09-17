import java.util.Date;

public class Task {

    int taskId;
    String title;
    String description;
    Status status;
    Date deadline;
    public Task(){

    }
    public Task(int taskId, String title, String description, Status status, Date deadline) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description + ", status=" + status
                + ", deadline=" + deadline + "]";
    }

    
    
}
enum Status {
    PENDING,
    INCOMPLETE,
    INPROGRESS,
    COMPLETE;
}