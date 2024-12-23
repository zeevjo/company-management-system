package com.companymanagementsystem.models;

import com.companymanagementsystem.interfaces.Payable;

public class RegularWorker extends Worker implements Payable {
    private static final int START_SICK_DAYS = 15;
    private int _sickDays;

    public RegularWorker(String name) {
        super(name);
        this._sickDays = RegularWorker.START_SICK_DAYS;
    }

    @Override
    public double calculatePaycheck() {
        double hourlyRate = 20.0;
        return hourlyRate * super.calculateMonthlyHours();
    }

    @Override
    public void displayPayDetails(){}

    public boolean takeSickDays(int days) {
        if (days <= 0) {
            System.out.println("Invalid number of sick days requested.");
            return false;
        }

        if (days > this.getSickDays()) {
            System.out.println("Insufficient sick days. Request denied.");
            return false;
        }

        this.setSickDays(this.getSickDays() - days);
        System.out.println("Sick days approved. Remaining sick days: " + this.getSickDays());
        return true;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sick Days Remaining: " + this.getSickDays());
    }

    public void setSickDays(int _sickDays) {
        this._sickDays = _sickDays;
    }

    public int getSickDays() {
        return this._sickDays;
    }
}