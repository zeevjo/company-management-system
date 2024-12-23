package com.companymanagementsystem.system;

import com.companymanagementsystem.models.Client;
import com.companymanagementsystem.models.Manager;
import com.companymanagementsystem.models.RegularWorker;

import java.util.ArrayList;
import java.util.Random;

public class Populate {

    private static final Random random = new Random();

    public static void clients(ArrayList<Client> clients) {
        for (int i = 0; i < 3; i++) {
            Client client = new Client("Client " + (i + 1), "Company " + (i + 1));
            for (int day = 1; day < 30; day++) {
                client.updateDailySpending(day, random.nextDouble() * 100);
            }
            clients.add(client);
        }
    }

    public static void managers(ArrayList<Manager> managers) {
        for (int i = 0; i < 2; i++) {
            Manager manager = new Manager("Manager " + (i + 1), random.nextDouble() * 5000 + 5000, random.nextDouble() * 2000);
            for (int day = 1; day < 30; day++) {
                manager.logHours(day, random.nextDouble() * 8);
            }
            managers.add(manager);
        }
    }

    public static void regularWorkers(ArrayList<RegularWorker> workers) {
        for (int i = 0; i < 5; i++) {
            RegularWorker worker = new RegularWorker("Worker " + (i + 1));
            for (int day = 1; day < 30; day++) {
                worker.logHours(day, random.nextDouble() * 8);
            }
            workers.add(worker);
        }
    }
}
