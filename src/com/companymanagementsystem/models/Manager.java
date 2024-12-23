package com.companymanagementsystem.models;

import com.companymanagementsystem.interfaces.Payable;

import java.util.ArrayList;

public class Manager extends Worker implements Payable {
    private static final int EXTRA_VACATION_DAYS = 10;
    private final ArrayList<Worker> _team;
    private double _baseSalary;
    private double _bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name);
        this.setVacationDays(this.getVacationDays() + Manager.EXTRA_VACATION_DAYS);
        this._team = new ArrayList<>();
        this._baseSalary = baseSalary;
        this._bonus = bonus;
    }

    @Override
    public double calculatePaycheck() {
        return this.getBaseSalary() + this.getBonus();
    }

    @Override
    public void displayPayDetails() {
        System.out.println("Pay Details for Manager:");
        System.out.println("Base Salary: $" + this.getBaseSalary());
        System.out.println("Bonus: $" + this.getBonus());
        System.out.println("Total Paycheck: $" + calculatePaycheck());
    }

    public void addTeamMember(Worker worker) {
        if (worker != null && !this.getTeam().contains(worker)) {
            this.getTeam().add(worker);
            System.out.println("Worker " + worker.getName() + " added to the team.");
        } else {
            System.out.println("Worker is either null or already part of the team.");
        }
    }

    public void displayTeam() {
        System.out.println("Team managed by " + this.getName() + ":");
        if (this.getTeam().isEmpty()) {
            System.out.println("No team members.");
        } else {
            for (Worker worker : this.getTeam()) {
                System.out.println("- " + worker.getName() + " (ID: " + worker.getId() + ")");
            }
        }
    }

    public double getBaseSalary() {
        return _baseSalary;
    }

    public void setBaseSalary(double _baseSalary) {
        this._baseSalary = _baseSalary;
    }

    public double getBonus() {
        return _bonus;
    }

    public void setBonus(double _bonus) {
        this._bonus = _bonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Manager Bonus: Included in paycheck.");
        displayTeam();
    }

    public ArrayList<Worker> getTeam() {
        return _team;
    }
}