package com.zaidan.todosystem;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            TodoOperations operations = new TodoOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Library List Menu ---");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter Author Name : ");
                        String author = scanner.nextLine();
                        operations.addTodo(new Todo(title, author, description));
                        break;

                    case 2:
                        System.out.println("All To-Dos:");
                        operations.getTodos().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Book ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        operations.updateTodo(updateId, newTitle, newDescription);
                        break;

                    case 4:
                        System.out.print("Enter Book ID to delete: ");
                        int deleteId = scanner.nextInt();
                        operations.deleteTodo(deleteId);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
