package level3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class taskManager {
    private List<tasks> tasks;
    private final String filePath;

    public taskManager(String filePath) {
        this.filePath = filePath;
        this.tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(tasks task) {
        tasks.add(task);
        saveTasks();
    }

    public void updateTask(int index, tasks task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
            saveTasks();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public List<tasks> getTasks() {
        return tasks;
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    tasks.add(new tasks(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (tasks task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
