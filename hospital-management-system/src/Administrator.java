/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

/**
 *
 * @author DCS
 */
public final class Administrator extends Person {

    private String department;

    public Administrator(String id, String name, int age, String department) {
        super(id, name, age);
        setDepartment(department);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public final void adminAccess() {
        System.out.println("Administrator access granted.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Administrator Details : ");
        displayBasicDetails();
        System.out.println("Department : " +department);
    }
}
