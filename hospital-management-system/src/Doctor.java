/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Schedulable {
    private String specialty;
    private List<String> shifts; // To store scheduled shifts

    public Doctor(String id, String name, int birthYear, String specialty) {
        super(id, name, birthYear);
        setSpecialty(specialty);
        this.shifts = new ArrayList<>();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public void scheduleShift(String shift) {
        if (!shifts.contains(shift)) {
            shifts.add(shift);
            System.out.println("Shift " + shift + " scheduled for Doctor " + getName());
        } else {
            System.out.println("Shift " + shift + " is already scheduled for Doctor " + getName());
        }
    }

    @Override
    public void cancelShift(String shift) {
        if (shifts.remove(shift)) {
            System.out.println("Shift " + shift + " canceled for Doctor " + getName());
        } else {
            System.out.println("Shift " + shift + " not found for Doctor " + getName());
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor Details : ");
        super.displayBasicDetails();
        System.out.println("Specialty      : " + specialty );
        System.out.println("Shifts         : " + shifts);
    }
}

