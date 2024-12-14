package level3;

import java.util.Scanner;

public class taskMain {
    public static void main(String[] args) {
        taskManager taskManager = new taskManager("tasks.txt");
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Task Manager");
        System.out.println("Commands: add, update, delete, list, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(new tasks(title, description));
                    break;

                case "update":
                    System.out.print("Enter task index to update: ");
                    int updateIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTask(updateIndex, new tasks(newTitle, newDescription));
                    break;

                case "delete":
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    taskManager.deleteTask(deleteIndex);
                    break;

                case "list":
                    System.out.println("Tasks:");
                    for (int i = 0; i < taskManager.getTasks().size(); i++) {
                        tasks task = taskManager.getTasks().get(i);
                        System.out.println(i + ": " + task.getTitle() + " - " + task.getDescription());
                    }
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
