package com.companymanagementsystem.models;

import java.util.ArrayList;

abstract public class Person {
    private static int _idCounter = 0;
    private final String _id;
    private String _name;

    public Person(String name){
        this._id = Person.generateUniqueId();
        this._name = name;
    }

    public String getId() {
        return this._id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    abstract void displayInfo();

    public static void resetAllDays(ArrayList<Worker> workers){
        for (Worker worker : workers) {
            worker.resetVacationDays();
            worker.resetSickDays();
        }
    }

    private static String generateUniqueId() {
        return "P" + (++Person._idCounter);
    }
}
