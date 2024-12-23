package com.companymanagementsystem.models;

import java.util.Arrays;

abstract public class Worker extends Person {
    private static final int START_VACATION_DAYS = 10;
    private final double[] _dailyHours;
    private int _vacationDays;

    public Worker(String name) {
        super(name);
        this._dailyHours = new double[30];
        this._vacationDays = Worker.START_VACATION_DAYS;
    }

    protected abstract double calculatePaycheck();

    @Override
    public void displayInfo() {
        System.out.println("Worker ID: " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Remaining Vacation Days: " + this.getVacationDays());
        System.out.println("Daily Hours (Last 30 Days): " + Arrays.toString(this.getDailyHours()));
    }

    public void logHours(int day, double hours) {
        if (day < 1 || day > 30) {
            System.out.println("Invalid day. Please enter a day between 1 and 30.");
        } else if (hours < 0) {
            System.out.println("Invalid hours. Hours cannot be negative.");
        } else {
            this.getDailyHours()[day - 1] = hours;
        }
    }

    protected boolean takeVacationDays(int days) {
        if (days <= 0) {
            System.out.println("Invalid number of days. Days must be positive.");
            return false;
        }
        if (this.getVacationDays() >= days) {
            this.setVacationDays(this.getVacationDays() - days);
            return true;
        } else {
            System.out.println("Insufficient vacation days available.");
            return false;
        }
    }

    protected double calculateMonthlyHours() {
        double totalHours = 0;
        for (double hours : this.getDailyHours()) {
            totalHours += hours;
        }
        return totalHours;
    }

    protected void resetVacationDays() {
        this.setVacationDays(Worker.START_VACATION_DAYS);
    }

    protected void resetSickDays() {
        Arrays.fill(this.getDailyHours(), 0);
    }

    public int getVacationDays() {
        return this._vacationDays;
    }

    public double[] getDailyHours() {
        return this._dailyHours;
    }

    public void setVacationDays(int vacationDays) {
        this._vacationDays = vacationDays;
    }
}