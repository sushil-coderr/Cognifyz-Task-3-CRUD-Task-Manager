import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {

        int choice;

        System.out.println("=================================");
        System.out.println("       TASK MANAGEMENT APP");
        System.out.println("=================================");

        do {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("\nThank you for using Task Manager!");
                    break;

                default:
                    System.out.println("\n❌ Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    // CREATE
    public static void addTask() {

        System.out.print("\nEnter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task task = new Task(nextId, title, description);
        tasks.add(task);

        System.out.println("✅ Task added successfully!");
        System.out.println("Task ID: " + nextId);

        nextId++;
    }

    // READ
    public static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks available.");
            return;
        }

        System.out.println("\n========== TASK LIST ==========");

        for (Task task : tasks) {
            task.displayTask();
        }
    }

    // UPDATE
    public static void updateTask() {

        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks available to update.");
            return;
        }

        System.out.print("\nEnter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task task : tasks) {

            if (task.getId() == id) {

                System.out.print("Enter new title: ");
                String newTitle = sc.nextLine();

                System.out.print("Enter new description: ");
                String newDescription = sc.nextLine();

                task.setTitle(newTitle);
                task.setDescription(newDescription);

                System.out.println("✅ Task updated successfully!");
                return;
            }
        }

        System.out.println("❌ Task with ID " + id + " not found.");
    }

    // DELETE
    public static void deleteTask() {

        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks available to delete.");
            return;
        }

        System.out.print("\nEnter Task ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task task : tasks) {

            if (task.getId() == id) {

                tasks.remove(task);

                System.out.println("✅ Task deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Task with ID " + id + " not found.");
    }
}
