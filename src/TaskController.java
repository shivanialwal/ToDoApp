import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskController {
    TaskService taskService = new TaskService();

    public void showMenu() throws ParseException {
        System.out.println("Welcome to the todo App");
        System.out.println("Menu: ");
        System.out.println("1. Add a task");
        System.out.println("2. Update a task");
        System.out.println("3. Delete a task");
        System.out.println("4. View all tasks");
        System.out.println("5. exit");
        try (Scanner actionNumber_value = new Scanner(System.in)) {
            int actionNumber = actionNumber_value.nextInt();
            performAction(actionNumber);
        }

    }

    public void performAction(int actionNumber) throws ParseException {

        switch (actionNumber) {
            case 1:
                addTask();
                break;
            case 2:
                updateTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                viewTasks();
                break;
            default:
                System.out.println("Operation does not exist");
                break;
        }
    }

    public void addTask() throws ParseException {
        Scanner title_value = new Scanner(System.in);
        Scanner desc_value = new Scanner(System.in);
        Scanner date_value = new Scanner(System.in);

        try {
            Task task = getUserInput(title_value, desc_value, Status.PENDING, date_value);
            taskService.addTask(task);
        } catch (Exception e) {
            System.out.println("Exception " + e.getLocalizedMessage());
        } finally {
            title_value.close();
            desc_value.close();
            date_value.close();
        }
    }

    public void updateTask() {
        Scanner title_value = new Scanner(System.in);
        Scanner desc_value = new Scanner(System.in);
        Scanner date_value = new Scanner(System.in);
        Scanner taskId_value = new Scanner(System.in);
        Scanner status_value = new Scanner(System.in);

        try {
            System.out.println("Select the status of the task ");
            System.out.println("1. PENDING ");
            System.out.println("2. INCOMPLETE ");
            System.out.println("3. INPROGRESS ");
            System.out.println("4. COMPLETE ");
            int statusStr = status_value.nextInt();
            Status status;
            switch (statusStr) {
                case 1:
                    status = Status.PENDING;
                    break;
                case 2:
                    status = Status.INCOMPLETE;
                    break;
                case 3:
                    status = Status.INPROGRESS;
                    break;
                case 4:
                    status = Status.COMPLETE;
                    break;
                default:
                    status = Status.PENDING;
                    break;
            }
            Task task = getUserInput(title_value, desc_value, status, date_value);
            int taskId = taskId_value.nextInt();
            taskService.updateTask(taskId, task);
        } catch (Exception e) {
            System.out.println("Exception " + e.getLocalizedMessage());
        } finally {
            title_value.close();
            desc_value.close();
            date_value.close();
            taskId_value.close();
            status_value.close();
        }
    }

    public void deleteTask() {
        System.out.println("Enter the latest task Id you wish delete");
        try (Scanner taskId_value = new Scanner(System.in)) {
            int taskId = taskId_value.nextInt();
            taskService.deleteTask(taskId);
        }
    }

    public void viewTasks() {
        taskService.viewTasks();
    }

    public Task getUserInput(Scanner title_value, Scanner desc_value, Status status, Scanner date_value)
            throws ParseException {
        System.out.println("Enter title");
        String title = title_value.nextLine();
        System.out.println("Enter description");
        String desc = desc_value.nextLine();
        System.out.println("Enter date (dd/mm/yyyy):");
        String dateStr = date_value.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dateStr);
        int length = taskService.viewTasks().size();
        Task task = new Task(length + 1, title, desc, status, date);
        return task;
    }
}
