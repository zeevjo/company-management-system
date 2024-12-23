package com.companymanagementsystem.models;

import java.util.Arrays;

public class Client extends Person {
    private String _companyName;
    private double[] _dailySpending;

    public Client(String name, String companyName) {
        super(name);
        this._companyName = companyName;
        this._dailySpending = new double[30];
    }

    public String get_companyName() {
        return _companyName;
    }

    public double[] get_dailySpending() {
        return _dailySpending;
    }

    @Override
    public void displayInfo() {
        System.out.println("Client ID: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Company Name: " + this.get_companyName());
        System.out.println("Daily Spending (Last 30 Days): " + Arrays.toString(this.get_dailySpending()));
    }

    public void updateDailySpending(int day, double amount) {
        if (day < 1 || day > 30) {
            System.out.println("Invalid day. Please enter a day between 1 and 30.");
        } else {
            this.get_dailySpending()[day - 1] = amount;
        }
    }
}