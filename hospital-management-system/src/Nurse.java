/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


import java.util.ArrayList;

import java.util.List;

public class Nurse extends Person implements Schedulable {


    private List<String> shifts; // To store scheduled shifts

    public Nurse(String id, String name, int birthYear) {

        super(id, name, birthYear);

        this.shifts = new ArrayList<>();

    }


    @Override
    public void scheduleShift(String shift) {

        if (!shifts.contains(shift)) {

            shifts.add(shift);

            System.out.println("Shift " + shift + " scheduled for Nurse " + getName());

        } else {

            System.out.println("Shift " + shift + " is already scheduled for Nurse " + getName());

        }

    }

    @Override
    public void cancelShift(String shift) {

        if (shifts.remove(shift)) {

            System.out.println("Shift " + shift + " canceled for Nurse " + getName());

        } else {

            System.out.println("Shift " + shift + " not found for Nurse " + getName());

        }

    }

    @Override
    public void displayDetails() {
        System.out.println("Nurse Details : ");
        displayBasicDetails();
        System.out.println("Shifts        : " + shifts);
    }

}

