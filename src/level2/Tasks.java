package level2;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

public class Tasks {
    private ArrayList<Task> tasks;
    private int taskId;

    public Tasks() {
        tasks = new ArrayList<>();
        taskId = 1;
    }

    public void createTask(String description) {
        Task task = new Task(taskId, description, false);
        tasks.add(task);
        taskId++;
        System.out.println("Task created successfully!");
    }

    public void readTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() + ", Description: " + task.getDescription() + ", Completed: " + task.isCompleted());
        }
    }

    public void updateTask(int id, String description, boolean completed) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setCompleted(completed);
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public static void main(String[] args) {
        Tasks taskManager = new Tasks();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.next();
                    taskManager.createTask(description);
                    break;
                case 2:
                    taskManager.readTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.next();
                    System.out.print("Is task completed? (true/false): ");
                    boolean completed = scanner.nextBoolean();
                    taskManager.updateTask(id, newDescription, completed);
                    break;
                case 4:
                    System.out.print("Enter task ID: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}