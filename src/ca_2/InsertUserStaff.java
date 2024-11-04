package ca_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The InsertUserStaff class allows a user to add staff members with specific roles and departments.
 * It validates user input, saves the data to a file, and confirms success to the user.
 * 
 * This class demonstrates the use of enums (Come from CreateRandomData.java) for roles and departments, input validation, 
 * and file handling using BufferedWriter.
 * 
 */
public class InsertUserStaff {
    
    /**
     * Main method to run the program.
     * 
     * This method collects the user's name, management role, and department, validates each entry,
     * and saves the information to a file.
     * 
     * @param args Command line arguments
     */
    public static void InserStaff(Scanner scanner, String fileName) {
        
        System.out.println("  ❖ ❖ ❖ ❖ ❖ ❖ ❖ ❖ ❖ Register New Staff ❖ ❖ ❖ ❖ ❖ ❖ ❖ ❖ ❖");
        // Step 1: Get and validate the Staff's name
        String staffName;
        while (true) {
            System.out.print("    ☞ Please input the Staff Name: "); // Prompt user for name
            staffName = scanner.nextLine(); // Read name input

            // Check if the name contains only letters and spaces
            if (Pattern.matches("[a-zA-Z ]+", staffName)) { // Regex to validate name
                break; // Exit loop if name is valid
            } else {
                System.out.println("    ✘ Invalid name. Please enter only letters and spaces."); // Error for invalid input
            }
        }

        // Step 2: Display and select management role using a loop
        CreateRandomData.ManagerRoleType selectedRole = null; // Variable to store the selected role
        while (selectedRole == null) { // Loop until a valid role is selected
            System.out.println("    ✽ Please select from the following Management Staff:"); // Display role options
            int option = 1; // Start option numbering at 1

            // Loop through each role in the ManagerRoleType enum
            for (CreateRandomData.ManagerRoleType role : CreateRandomData.ManagerRoleType.values()) {
                System.out.println("    ☞ " + option + ". " + role); // Print each role with option number
                option++; // Increment option number
            }
            
            System.out.print("  ✽ Select option (1-" + CreateRandomData.ManagerRoleType.values().length + "): "); // Prompt for selection

            try {
                int roleChoice = scanner.nextInt(); // Read selected option
                scanner.nextLine();  // Consume the newline character

                // Validate role choice to ensure it's within valid range
                if (roleChoice >= 1 && roleChoice <= CreateRandomData.ManagerRoleType.values().length) {
                    selectedRole = CreateRandomData.ManagerRoleType.values()[roleChoice - 1]; // Assign the selected role
                } else {
                    System.out.println("    ✺ Invalid choice. Please select a valid option."); // Error for invalid choice
                }
            } catch (InputMismatchException e) { // Catch non-integer input
                System.out.println("    ✺ Invalid input. Please enter a number."); // Error message for non-numeric input
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Step 3: Display and select department using a loop
        CreateRandomData.DepartmentType selectedDepartment = null; // Variable to store the selected department
        while (selectedDepartment == null) { // Loop until a valid department is selected
            System.out.println("    ✽ Please select the Department:"); // Display department options
            int option = 1; // Start option numbering at 1

            // Loop through each department in the DepartmentType enum
            for (CreateRandomData.DepartmentType department : CreateRandomData.DepartmentType.values()) {
                System.out.println("    ☞ " + option + ". " + department); // Print each department with option number
                option++; // Increment option number
            }
            
            System.out.print("  ✽ Select option (1-" + CreateRandomData.DepartmentType.values().length + "): "); // Prompt for selection

            try {
                int departmentChoice = scanner.nextInt(); // Read selected option

                // Validate department choice to ensure it's within valid range
                if (departmentChoice >= 1 && departmentChoice <= CreateRandomData.DepartmentType.values().length) {
                    selectedDepartment = CreateRandomData.DepartmentType.values()[departmentChoice - 1]; // Assign the selected department
                } else {
                    System.out.println("    ✘ Invalid choice. Please select a valid option."); // Error for invalid choice
                }
            } catch (InputMismatchException e) { // Catch non-integer input
                System.out.println("    ✘ Invalid input. Please enter a number."); // Error message for non-numeric input
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Step 4: Save details to a file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Write Staff name, selected role, and department to the file
            writer.write(staffName + "," + selectedRole + "," + selectedDepartment);
            writer.newLine(); // Write a newline to separate entries

            // Display success message to the user
            System.out.println("\n    ❋ " + staffName + " has been added as " + selectedRole + " to " + selectedDepartment + " successfully!");
        } catch (IOException e) { // Catch any file writing exceptions
            System.out.println("    ✺ An error occurred while saving to file."); // Error message
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}
