package ca_2;
/**
 *
 * @author jhane
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles sorting options for user names, management teams, and departments.
 * It provides an interactive menu for users to choose sorting preferences.
 */
public class SortListAscDesc {

    /**
     * Enumeration for sorting by name details (ascending or descending).
     */
    enum SortByName {
        ASCENDING("Sort Name Ascending", 1),
        DESCENDING("Sort Name Descending", 2);

        private final int option; // Variable for option number
        private final String description; // Variable for option description

        /**
         * Constructor for SortByName enum.
         *
         * @param description A string representing the sort by name option description.
         * @param option An integer representing the option number.
         */
        SortByName(String description, int option) {
            this.description = description;
            this.option = option;
        }

        /**
         * Returns the option number associated with the sort by name option.
         * 
         * @return The option number.
         */
        public int getOption() {
            return option;
        }

        /**
         * Returns the description of the sort by name option.
         * 
         * @return The option description.
         */
        public String getDescription() {
            return description;
        }
    }

    /**
     * Displays a sorting menu and sorts the lists based on user preferences.
     *
     * @param userNames      List of user names to sort.
     * @param managementTeam  List of management team names to reorder.
     * @param departments     List of department names to reorder.
     * @param scanner        Scanner object for user input.
     * @param fileName       The name of the file being processed (if applicable).
     */
    public static void sortMenu(ArrayList<String> userNames, ArrayList<String> managementTeam,
                                 ArrayList<String> departments, Scanner scanner, String fileName) {
        
        do {
            System.out.println("\n--- Sort by Name Options ---"); // Display sorting options for names
            
            // Display ascending and descending sort options
            for (SortByName option : SortByName.values()) {
                System.out.println(option.getOption() + ") " + option.getDescription());
            }

            // Prompt for user's choice
            System.out.print("Please select sorting order: ");
            String orderChoice = scanner.nextLine(); // Read user input

            // Perform the selected sorting order
            switch (orderChoice) {
                case "1": // If user chooses ascending sort
                    System.out.println("Sorting names in ascending order..."); // Message indicating the choice
                    quickSort(userNames, managementTeam, departments, true); // Call quickSort method with ascending order
                    break;
                case "2": // If user chooses descending sort
                    System.out.println("Sorting names in descending order..."); // Message indicating the choice
                    quickSort(userNames, managementTeam, departments, false); // Call quickSort method with descending order
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    break;
            }

            // Optionally display the top 20 sorted names (to be implemented as needed)
            displayTopNames(userNames, managementTeam, departments);

            // Return to the main menu after sorting
            CA_2.mainMenu(userNames, managementTeam, departments, scanner, fileName);
            
        } while (!CA_2.isValid); // Loop continues until isValid is true
    }

    /**
     * Displays the top 20 names from the sorted list.
     *
     * @param userNames List of user names to display.
     */
    private static void displayTopNames(ArrayList<String> userNames, ArrayList<String> managementTeam,
                                 ArrayList<String> departments) {
        System.out.println("Top 20 sorted names:");
        /** If userNames.size() is less than 20, the loop will stop at the end of userNames. 
         *  If userNames.size() is 20 or more, the loop will only go up to 19 (the index 19), 
         *  resulting in a maximum of 20 iterations.
        */
        for (int i = 0; i < Math.min(20, userNames.size()); i++) {
            System.out.println("        -> " + (i + 1) + ": " + userNames.get(i) +
                                   " | Management Staff: " + managementTeam.get(i) +
                                   " | Department: " + departments.get(i));
        }
    }

    /**
     * Performs Quick Sort on the user names and related lists.
     *
     * @param userNames      List of user names to sort.
     * @param managementTeam  List of management team names to reorder.
     * @param departments     List of department names to reorder.
     * @param ascending      A boolean indicating sort order; true for ascending, false for descending.
     */
    public static void quickSort(ArrayList<String> userNames, ArrayList<String> managementTeam,
                                   ArrayList<String> departments, boolean ascending) {
        quickSortHelper(userNames, managementTeam, departments, 0, userNames.size() - 1, ascending);
    }

    /**
     * Helper method to perform recursive Quick Sort on lists.
     *
     * @param userNames      List of user names to sort.
     * @param managementTeam  List of management team names to reorder.
     * @param departments     List of department names to reorder.
     * @param low            Starting index of the sort range.
     * @param high           Ending index of the sort range.
     * @param ascending      A boolean indicating sort order; true for ascending, false for descending.
     */
    private static void quickSortHelper(ArrayList<String> userNames, ArrayList<String> managementTeam,
                                        ArrayList<String> departments, int low, int high, boolean ascending) {
        if (low < high) { // Base case for recursion
            int pivotIndex = partition(userNames, managementTeam, departments, low, high, ascending); // Get partition index
            quickSortHelper(userNames, managementTeam, departments, low, pivotIndex - 1, ascending); // Recursively sort left
            quickSortHelper(userNames, managementTeam, departments, pivotIndex + 1, high, ascending); // Recursively sort right
        }
    }

    /**
     * Partitions the lists based on a pivot, arranging elements around the pivot for Quick Sort.
     *
     * @param userNames      List of user names.
     * @param managementTeam  List of management team names.
     * @param departments     List of department names.
     * @param low            Starting index.
     * @param high           Ending index.
     * @param ascending      A boolean indicating sort order; true for ascending, false for descending.
     * @return The index position of the pivot element.
     */
    private static int partition(ArrayList<String> userNames, ArrayList<String> managementTeam,
                                 ArrayList<String> departments, int low, int high, boolean ascending) {
        String pivot = userNames.get(high); // Set pivot as the last element
        int i = low - 1; // Initialize the smaller element index

        for (int j = low; j < high; j++) { // Traverse list up to the pivot
            int comparison = userNames.get(j).compareToIgnoreCase(pivot); // Compare with pivot, ignoring case

            // Adjust comparison based on sort order
            if ((ascending && comparison < 0) || (!ascending && comparison > 0)) {
                i++; // Increment index for smaller/larger element
                swap(userNames, managementTeam, departments, i, j); // Swap elements to partition
            }
        }
        swap(userNames, managementTeam, departments, i + 1, high); // Place pivot in correct position
        return i + 1; // Return pivot index
    }

    /**
     * Swaps elements at specified indices in userNames, managementTeam, and departments lists.
     *
     * @param userNames      List of user names.
     * @param managementTeam  List of management team names.
     * @param departments     List of department names.
     * @param i              First index to swap.
     * @param j              Second index to swap.
     */
    private static void swap(ArrayList<String> userNames, ArrayList<String> managementTeam,
                             ArrayList<String> departments, int i, int j) {
        // Swap userNames
        String tempUserName = userNames.get(i);
        userNames.set(i, userNames.get(j));
        userNames.set(j, tempUserName);

        // Swap managementTeam
        String tempManagement = managementTeam.get(i);
        managementTeam.set(i, managementTeam.get(j));
        managementTeam.set(j, tempManagement);

        // Swap departments
        String tempDepartment = departments.get(i);
        departments.set(i, departments.get(j));
        departments.set(j, tempDepartment);
    }
}
