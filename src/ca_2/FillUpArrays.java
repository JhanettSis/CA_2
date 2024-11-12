
package ca_2;

/**
 *
 * @author jhane
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The FillUpArrays class is responsible for reading data from the file Applicants_Form.txt 
 * and separate on three ArrayLists with user names, management roles, and department.
 * It also provides methods to display the first few entries from the lists.
 */
public class FillUpArrays {

    
    
    // This method reads a file and fills three ArrayLists with user names, management team, and department.
    public static void setFile(String fileName, Scanner scanner) {
        // Initializing ArrayLists to store user names, management team, and department
        //UserNames stores user names, ManagementTeam store management team, Departments store department
        ArrayList<String> UserNames = new ArrayList<>();
        ArrayList<String> ManagementTeam= new ArrayList<>();
        ArrayList<String> Departments = new ArrayList<>();
        
        // 'Try' statement to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            // Variable to store each line read from the file.
            String line;

            // This loop runs while there are more lines to read in the file.
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by comma and trim each part to remove extra spaces
                String[] parts = line.split(",");

                // Check if It has enough parts in the array (expecting at least 3 for this example)
                if (parts.length >= 3) {
                    String userNameItem = parts[0].trim(); // First part is the username
                    String managementMember = parts[1].trim(); // Second part is a member of management
                    String departmentItem = parts[2].trim(); // Third part is the department

                    // Add the values to their respective ArrayLists
                    UserNames.add(userNameItem); // Add username to UserNames list
                    ManagementTeam.add(managementMember); // Add management to ManagementTeam list
                    Departments.add(departmentItem); // Add department to Departments list
                } else {
                    // If not enough parts are found, print a message and skip the line.
                    //System.out.println("Skipping invalid line (not enough parts): " + line);
                }
            }

            CA_2.mainMenu(UserNames, ManagementTeam, Departments, scanner, fileName); // Call to mainMenu method to display options
            
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message with the details.
            System.out.println("    ✘ File not found: " + e.getMessage());
        } catch (IOException e) {
            // Handle IO exceptions during file reading.
            System.out.println("    ✘ Error reading the file: " + e.getMessage());
        }
    }

    // This method displays the first 20 user names and their associated.
    public static void displayArrayList(ArrayList<String> userNames, ArrayList<String> managementTeam, ArrayList<String> departments) {
        // Prints a decorative line for displaying the users.
        System.out.println("    ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ");
        System.out.println("    ✾ Displaying up to 5 user names and their:");

        // This loop runs for the first 5 users and shows their names and.
        for (int i = 0; i < 5; i++) {
            // Check if there are enough users to display.
            if (i < userNames.size() && i < managementTeam.size() && i < departments.size()) {
                // Print the user name, management ID, and department ID
                System.out.println("        ✓ " + (i + 1) + ": " + userNames.get(i) +
                                   " | Management Staff: " + managementTeam.get(i) +
                                   " | Department: " + departments.get(i));
            }
        }

        // Tells the user there are more users if they exist.
        if (userNames.size() > 5) {
            System.out.println("    ✾ -------> There are more ... ");
        }
    }
}
