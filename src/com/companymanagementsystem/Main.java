package com.companymanagementsystem;

import com.companymanagementsystem.models.Client;
import com.companymanagementsystem.models.Manager;
import com.companymanagementsystem.models.RegularWorker;
import com.companymanagementsystem.system.ManagementSystem;
import com.companymanagementsystem.system.Populate;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Create objects
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<RegularWorker> workers = new ArrayList<>();

        // Populate data
        Populate.clients(clients);
        Populate.managers(managers);
        Populate.regularWorkers(workers);

        // Start
        ManagementSystem.start(clients, managers, workers);
    }
}