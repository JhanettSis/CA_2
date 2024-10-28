/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;
/**
 *
 * @author jhane
 */
import java.io.BufferedWriter;   // For efficient writing to files
import java.io.FileWriter;       // To create and open a file for writing data
import java.io.IOException;      // To handle errors that may occur during file writing
import java.util.ArrayList;      // Provides a resizable array implementation for storing employee objects
import java.util.HashSet;        // Stores unique items, prevents duplicate names in this case
import java.util.List;           // Interface used to represent a list of employees
import java.util.Random;         // Generates random values, used for randomizing employee attributes
import java.util.Set;            // Interface for a collection that contains no duplicate elements

// Main class where we generate random employee data
public class CreateRandomData {
    
    //The list of the name is from the website https://1000randomnames.com/
    // Array of names for random selection when creating employees
    private static final String[] employeeNamesList = {
        "Kalani Henderson", "Beau Colon", "Remy Scott", "Leo McCarty", "Halo Howard",
            "Jeremiah Bruce", "Marilyn Pollard", "Savanna Armstrong", "Jianna Glass", "Allan Martin",
            "Mila Pratt", "Rowen McClain", "Marleigh Khan", "Kendrick Gilbert", "Jocelyn Roberts",
            "Josiah Hanna", "Cynthia Haley", "Leif Mack", "Julissa Lang", "Morgan O’Connell",
            "Jillian Herring", "Henrik Rasmussen", "Esperanza Briggs", "Case Stevens", "Katherine Kennedy",
            "Maxwell Horton", "Aitana Chavez", "Ian Brady", "Ryan Ellis", "Cole Horton",
            "Aitana McPherson", "Foster Lyons", "Kenzie Crosby", "Tristen Hart", "Gemma Patton",
            "Moises Knapp", "Linda Klein", "Marco Villanueva", "Monroe McDonald", "Calvin Rubio",
            "Hadassah Ball", "Shane Dalton", "Lilian Duffy", "Kyng Cortes", "Lea Melendez",
            "Nikolas McPherson", "Emmaline Greer", "Koda Barrett", "Kendall Hickman", "Jakobe Krueger",
            "Kamari Long", "Jace Hartman", "Kennedi Montoya", "Ford Hodge", "Coraline Hall",
            "Thomas Gilbert", "Jocelyn Herring", "Henrik Goodwin", "Shiloh Ayers", "Ulises Rush"
    };

    // Enum defining types of management roles
    public enum ManagerRoleType {
        ChiefExecutiveOfficer,   // Represents the CEO
        ChiefMedicalOfficer,     // Represents the CMO in charge of medical operations
        Doctor,                  // Represents a doctor managing medical teams
        NursingStaff             // Represents nursing staff involved in patient care
    }

    // Enum defining different departments
    public enum DepartmentType {
        EmergencyDepartment,     // Handles emergency medical situations
        SurgeryDepartment,       // Focuses on surgical procedures
        HumanResources           // Manages employee relations and resources
    }

    // Inner Employee class to represent each employee's details
    static class Employee {
        private String employeeName;             // Stores the employee's name
        private ManagerRoleType managerRole;     // Stores the manager role type for the employee
        private DepartmentType employeeDepartment;   // Stores the department for the employee

        // Constructor that initializes an employee's name, role, and department
        public Employee(String employeeName, ManagerRoleType managerRole, DepartmentType employeeDepartment) {
            this.employeeName = employeeName;             // Assigns name to the employee
            this.managerRole = managerRole;               // Assigns a management role
            this.employeeDepartment = employeeDepartment; // Assigns a department
        }

        // Method to return a formatted string of the Employee’s details
        public String toString() {
            return employeeName + ", " + managerRole + ", " + employeeDepartment;
        }
    }

    // Method to generate random employee data
    public static void generateRandomEmployeeData(String fileName) {
        // A Set to store unique employee names and avoid duplicates
        Set<String> uniqueEmployeeNames = new HashSet<>();
        // A List to store each created Employee object
        List<Employee> employeeList = new ArrayList<>();
        // Random object to select random attributes for each employee
        Random randomGenerator = new Random();

        // Loop to create employees with random attributes until all names are used
        while (employeeList.size() < employeeNamesList.length) { // Continues until all names are used
            // Select a random name from employeeNamesList
            String selectedName = employeeNamesList[randomGenerator.nextInt(employeeNamesList.length)];

            // If name is unique, add it to the set and proceed to create an employee
            if (uniqueEmployeeNames.add(selectedName)) {
                // Randomly selects a ManagerRoleType
                ManagerRoleType selectedManagerRole = ManagerRoleType.values()[randomGenerator.nextInt(ManagerRoleType.values().length)];

                // Randomly selects a DepartmentType
                DepartmentType selectedDepartment = DepartmentType.values()[randomGenerator.nextInt(DepartmentType.values().length)];

                // Create and add a new Employee object with selected attributes
                employeeList.add(new Employee(selectedName, selectedManagerRole, selectedDepartment));
            }
        }

        // Print each employee’s details to the console
        for (Employee employee : employeeList) {
            System.out.println(employee); // Calls the toString() method to print employee details
        }

        // Write employee details to a file
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employeeList) {
                fileWriter.write(employee.toString()); // Write each employee's string representation to file
                fileWriter.newLine();                  // Move to the next line after each employee
            }
        } catch (IOException error) { // Catches any errors during file writing
            System.out.println("Error writing to file."); // Prints error message to the console
            error.printStackTrace(); // Shows detailed error information
        }
    }
}
