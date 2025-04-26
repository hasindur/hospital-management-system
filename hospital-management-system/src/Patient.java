/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


public class Patient extends Person {
    private String illness;

    public Patient(String id, String name, int age, String illness) {
        super(id, name, age);
        setIllness(illness);
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
    
    

    @Override
    public void displayDetails() {
        System.out.println("Patient Details : ");
        super.displayBasicDetails();
        System.out.println("Illness         : " + illness);
    }
}
