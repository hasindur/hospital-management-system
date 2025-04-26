
package hospitalmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();  // Shared list for all persons

        int choice;

        do {
            System.out.println("\n=== Test Hospital Management System ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Add Patient");
            System.out.println("4. Schedule Shift");
            System.out.println("5. Cancel Shift");
            System.out.println("6. Display All People");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Birth Year: ");
                    int birthYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Specialty: ");
                    String specialty = scanner.nextLine();

                    addDoctor(people, id, name, birthYear, specialty);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Birth Year: ");
                    birthYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    addNurse(people, id, name, birthYear);
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Birth Year: ");
                    birthYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter illness: ");
                    String illness = scanner.nextLine();

                    addPatient(people, id, name, birthYear, illness);
                    break;


                case 4:

                    System.out.print("Enter Person ID: ");
                    String personId = scanner.nextLine();
                    System.out.print("Enter shift: ");
                    String shift = scanner.nextLine();

                    scheduleShift(people, personId, shift);
                    break;


                case 5:

                    System.out.print("Enter Person ID: ");
                    personId = scanner.nextLine();
                    System.out.print("Enter shift: ");
                    shift = scanner.nextLine();

                    cancelShift(people, personId, shift);
                    break;

                case 6:
                    displayAllDetails(people);
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }


    // Static method to add a Doctor
    private static void addDoctor(List<Person> list, String id, String name, int birthYear, String specialty) {
        Doctor doctor = new Doctor(id, name, birthYear, specialty);
        list.add(doctor);
        System.out.println("\nDoctor added successfully: " + doctor.getName());
    }

    // Static method to add a Nurse
    private static void addNurse(List<Person> list, String id, String name, int birthYear) {
        Nurse nurse = new Nurse(id, name, birthYear);
        list.add(nurse);
        System.out.println("\nNurse added successfully: " + nurse.getName());
    }

    // Static method to add a Patient
    private static void addPatient(List<Person> list, String id, String name, int birthYear, String illness) {
        Patient patient = new Patient(id, name, birthYear, illness);
        list.add(patient);
        System.out.println("\nPatient added successfully: " + patient.getName());
    }

    // Static method to display all details
    private static void displayAllDetails(List<Person> list) {
        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Person person : list) {
                person.displayDetails(); // Dynamically invokes the displayDetails() method
            }
        }
    }

    // Static method to schedule a shift
    private static void scheduleShift(List<Person> people, String personId, String shift) {
        boolean shiftScheduled = false;
        for (Person person : people) {
            if (person.getId().equals(personId) && person instanceof Schedulable) {
                ((Schedulable) person).scheduleShift(shift); // Casting to Schedulable
                shiftScheduled = true;
                break;
            }
        }
        if (!shiftScheduled) {
            System.out.println("Person with ID " + personId + " not found or is not schedulable.");
        }
    }

    // Static method to cancel a shift
    private static void cancelShift(List<Person> people, String personId, String shift) {
        boolean shiftCanceled = false;
        for (Person person : people) {
            if (person.getId().equals(personId) && person instanceof Schedulable) {
                ((Schedulable) person).cancelShift(shift); // Casting to Schedulable
                shiftCanceled = true;
                break;
            }
        }
        if (!shiftCanceled) {
            System.out.println("Person with ID " + personId + " not found or is not schedulable.");
        }
    }

}
