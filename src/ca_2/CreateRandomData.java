
package ca_2;
/**
 *
 * @author jhane
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The CreateRandomData class is responsible for generating random employee data.
 * It uses predefined lists of names, management roles, and department types
 * to create Employee objects with randomly assigned attributes.
 * The generated data can be saved to a specified file.
 */

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
        Manager_Administrator,
        Assistant_Manager,
        Physicians_General_Practitioners,
        Nurse_Practitioners
    }

    // Enum defining different departments
    public enum DepartmentType {
        Administrative,
        Medical_Team,
        Laboratory_Diagnostic_Services,
        Facilities_Maintenance
    }

    // Inner Employee class to represent each employee's details
    static class Employee {
        private String employeeName;             // Stores the employee's name
        //private ManagerRoleType managerRole;     // Stores the manager role type for the employee
        private DepartmentType employeeDepartment;   // Stores the department for the employee

        // Constructor that initializes an employee's name, role, and department
        public Employee(String employeeName, ManagerRoleType managerRole, DepartmentType employeeDepartment) {
            this.employeeName = employeeName;             // Assigns name to the employee
            //this.managerRole = managerRole;               // Assigns a management role
            this.employeeDepartment = employeeDepartment; // Assigns a department
        }

        // Method to return a formatted string of the Employee’s details
        public String toString() {
            return employeeName + ", "  + employeeDepartment;
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
            else {
                System.out.println("There is a name: " + selectedName);
            }
        }

        // Print each employee’s details to the console
        for (Employee employee : employeeList) {
            System.out.println("    ✓ " + employee); // Calls the toString() method to print employee details
        }

        // Write employee details to a file
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Employee employee : employeeList) {
                fileWriter.write(employee.toString()); // Write each employee's string representation to file
                fileWriter.newLine();                  // Move to the next line after each employee
            }
        } catch (IOException error) { // Catches any errors during file writing
            System.out.println("    ✘ Error writing to file."); // Prints error message to the console
            error.printStackTrace(); // Shows detailed error information
        }
    }
}
