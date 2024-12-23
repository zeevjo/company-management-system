package com.companymanagementsystem.system;

import com.companymanagementsystem.models.Client;
import com.companymanagementsystem.models.Manager;
import com.companymanagementsystem.models.RegularWorker;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {

    public static void start(ArrayList<Client> clients, ArrayList<Manager> managers, ArrayList<RegularWorker> workers) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> ManagementSystem.viewClientData(clients);
                case 2 -> ManagementSystem.viewManagerData(managers);
                case 3 -> ManagementSystem.viewWorkerData(workers);
                case 4 -> ManagementSystem.logWorkerHours(scanner, workers);
                case 5 -> ManagementSystem.updateClientSpending(scanner, clients);
                case 6 -> ManagementSystem.manageTeams(scanner, managers, workers);
                case 7 -> {
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n Choose an option:");
        System.out.println("1. View Client Data");
        System.out.println("2. View Manager Data");
        System.out.println("3. View Regular Worker Data");
        System.out.println("4. Log Hours for Worker");
        System.out.println("5. Update Client Spending");
        System.out.println("6. Manage Manager Teams");
        System.out.println("7. Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void viewClientData(ArrayList<Client> clients) {
        for (Client client : clients) {
            client.displayInfo();
        }
    }

    private static void viewManagerData(ArrayList<Manager> managers) {
        for (Manager manager : managers) {
            manager.displayInfo();
            manager.displayTeam();
        }
    }

    private static void viewWorkerData(ArrayList<RegularWorker> workers) {
        for (RegularWorker worker : workers) {
            worker.displayInfo();
        }
    }

    private static void logWorkerHours(Scanner scanner, ArrayList<RegularWorker> workers) {
        System.out.println("Enter Worker ID to log hours:");
        String workerId = scanner.next();

        for (RegularWorker worker : workers) {
            if (worker.getId().equals(workerId)) {
                System.out.println("Enter day (0-29):");
                int day = getValidDay(scanner);
                System.out.println("Enter hours worked:");
                double hours = getValidDouble(scanner);
                worker.logHours(day, hours);
                System.out.println("Hours logged successfully.");
                return;
            }
        }
        System.out.println("Worker not found.");
    }

    private static void updateClientSpending(Scanner scanner, ArrayList<Client> clients) {
        System.out.println("Enter Client ID to update spending:");
        String clientId = scanner.next();

        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                System.out.println("Enter day (0-29):");
                int day = getValidDay(scanner);
                System.out.println("Enter amount spent:");
                double amount = getValidDouble(scanner);
                client.updateDailySpending(day, amount);
                System.out.println("Spending updated successfully.");
                return;
            }
        }
        System.out.println("Client not found.");
    }

    private static void manageTeams(Scanner scanner, ArrayList<Manager> managers, ArrayList<RegularWorker> workers) {
        System.out.println("Enter Manager ID to manage team:");
        String managerId = scanner.next();

        for (Manager manager : managers) {
            if (manager.getId().equals(managerId)) {
                System.out.println("Enter Worker ID to add to the team:");
                String workerId = scanner.next();

                for (RegularWorker worker : workers) {
                    if (worker.getId().equals(workerId)) {
                        manager.addTeamMember(worker);
                        System.out.println("Worker added to team.");
                        return;
                    }
                }
                System.out.println("Worker not found.");
                return;
            }
        }
        System.out.println("Manager not found.");
    }

    private static int getValidDay(Scanner scanner) {
        int day;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid day (0-29):");
                scanner.next();
            }
            day = scanner.nextInt();
            if (day >= 0 && day <= 29) {
                return day;
            }
            System.out.println("Invalid day. Please enter a value between 0 and 29.");
        }
    }

    private static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
