package ca_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jhane
 
 * This class provides a menu-based search system for user names, management teams,
 * and departments. It includes methods to sort the data using Quick Sort, search using
 * Binary Search, and verify name validity.
 */
public class SearchOnTheList {

    /**
     * Displays the search menu, allowing the user to search for a name.
     * If a match is found, it displays relevant details.
     *
     * @param userNames      List of user names.
     * @param managementTeam List of management team names.
     * @param departments    List of department names.
     * @param scanner        Scanner for user input.
     * @param fileName       The name of the file being worked with.
     */
    public static void searchMenu(ArrayList<String> userNames, ArrayList<String> managementTeam, 
                                  ArrayList<String> departments, Scanner scanner, String fileName) {
        do {
            System.out.println("\n--- Search Options ---"); // Display search options header

            System.out.print("Please insert a name to search: "); // Prompt for input
            String searchChoice = scanner.nextLine(); // Read user input for search

            // Validate if the input is a valid name (no numbers or symbols)
            if (!isValidName(searchChoice)) {
                System.out.println("Please insert a valid name."); // Print error for invalid input
                continue; // Restart loop to prompt again
            }

            // Sort the userNames, managementTeam, and departments lists in parallel
            SortListAscDesc.quickSort(userNames, managementTeam, departments, true);

            // Perform binary search on the sorted userNames list
            int index = binarySearch(userNames, searchChoice);
            if (index != -1) { // If the name was found
                System.out.println("Name found: " + userNames.get(index));
                System.out.println("Management Team: " + managementTeam.get(index));
                System.out.println("Department: " + departments.get(index));
            } else { // If the name was not found
                System.out.println("Name not found.");
            }

            // Return to the main menu after the search
            CA_2.mainMenu(userNames, managementTeam, departments, scanner, fileName);

        } while (!CA_2.isValid); // Loop until the isValid condition is met
    }

    /**
     * Validates that the name contains only letters and spaces.
     *
     * @param name Name to be validated.
     * @return true if the name is valid, false otherwise.
     */
    private static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z ]+"); // Check for letters and spaces only
    }

    /**
     * Searches for a specific name in a sorted list using Binary Search.
     *
     * @param userNames List of sorted user names.
     * @param key       The name to search for.
     * @return The index of the found name, or -1 if not found.
     */
    private static int binarySearch(ArrayList<String> userNames, String key) {
        int low = 0; // Initialize low index
        int high = userNames.size() - 1; // Initialize high index

        while (low <= high) { // Loop until low exceeds high
            int mid = low + (high - low) / 2; // Calculate mid index
            int comparison = userNames.get(mid).compareToIgnoreCase(key); // Compare mid with key, ignoring case

            if (comparison == 0) { // If match found
                return mid; // Return index
            } else if (comparison < 0) { // If key is greater
                low = mid + 1; // Move low index to mid + 1
            } else { // If key is smaller
                high = mid - 1; // Move high index to mid - 1
            }
        }
        return -1; // Return -1 if not found
    }
}

