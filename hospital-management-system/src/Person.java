/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


import java.time.Year;

public abstract class Person {
    private String id;
    private String name;
    private int birthYear;

    // Constructor
    public Person(String id, String name, int birthYear) {
        setId(id);
        setName(name);
        setBirthYear(birthYear);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Final method to calculate age
    public final int calculateAge() {
        return Year.now().getValue() - birthYear;
    }

    // Abstract method
    public abstract void displayDetails();

    // Protected method for common details
    protected void displayBasicDetails() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + calculateAge());
    }
}
