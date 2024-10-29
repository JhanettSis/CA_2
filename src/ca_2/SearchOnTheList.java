/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            quickSort(userNames, managementTeam, departments);

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
     * Sorts the userNames, managementTeam, and departments lists in ascending order
     * based on userNames using Quick Sort.
     *
     * @param userNames      List of user names to be sorted.
     * @param managementTeam List of management team names to be reordered in parallel.
     * @param departments    List of department names to be reordered in parallel.
     */
    private static void quickSort(ArrayList<String> userNames, ArrayList<String> managementTeam, ArrayList<String> departments) {
        quickSortHelper(userNames, managementTeam, departments, 0, userNames.size() - 1);
    }

    /**
     * Helper method to perform recursive Quick Sort on lists.
     *
     * @param userNames      List of user names to be sorted.
     * @param managementTeam List of management team names to be reordered in parallel.
     * @param departments    List of department names to be reordered in parallel.
     * @param low            Starting index of the sort range.
     * @param high           Ending index of the sort range.
     */
    private static void quickSortHelper(ArrayList<String> userNames, ArrayList<String> managementTeam, 
                                        ArrayList<String> departments, int low, int high) {
        if (low < high) { // Base case for recursion
            int pivotIndex = partition(userNames, managementTeam, departments, low, high); // Get partition index
            quickSortHelper(userNames, managementTeam, departments, low, pivotIndex - 1); // Recursively sort left
            quickSortHelper(userNames, managementTeam, departments, pivotIndex + 1, high); // Recursively sort right
        }
    }

    /**
     * Partitions the list based on a pivot, arranging elements around the pivot for Quick Sort.
     *
     * @param userNames      List of user names.
     * @param managementTeam List of management team names.
     * @param departments    List of department names.
     * @param low            Starting index.
     * @param high           Ending index.
     * @return The index position of the pivot element.
     */
    private static int partition(ArrayList<String> userNames, ArrayList<String> managementTeam, 
                                 ArrayList<String> departments, int low, int high) {
        String pivot = userNames.get(high); // Set pivot as the last element
        int i = low - 1; // Initialize the smaller element index

        for (int j = low; j < high; j++) { // Traverse list up to the pivot
            if (userNames.get(j).compareTo(pivot) < 0) { // Compare with pivot
                i++; // Increment index for smaller element
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
     * @param managementTeam List of management team names.
     * @param departments    List of department names.
     * @param i              Index of the first element.
     * @param j              Index of the second element.
     */
    private static void swap(ArrayList<String> userNames, ArrayList<String> managementTeam, 
                             ArrayList<String> departments, int i, int j) {
        String tempUserName = userNames.get(i); // Temporary variable for userNames swap
        userNames.set(i, userNames.get(j)); // Swap userNames
        userNames.set(j, tempUserName);

        String tempManagement = managementTeam.get(i); // Temporary variable for managementTeam swap
        managementTeam.set(i, managementTeam.get(j)); // Swap managementTeam
        managementTeam.set(j, tempManagement);

        String tempDepartment = departments.get(i); // Temporary variable for departments swap
        departments.set(i, departments.get(j)); // Swap departments
        departments.set(j, tempDepartment);
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

