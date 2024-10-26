/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.util.Scanner; // Importing the Scanner class for user input

/**
 * The CA_2 class serves as the main entry point for the Hospital system application.
 * It manages the user interface and allows interaction through various menu options, 
 * including sorting, searching, and user management functionalities.
 */
public class CA_2 {

    // Enumeration for main menu options
    enum MainMenuOption { 
        /**
         * Defines the main menu options available to the user, sorting,
         * searching, user management, random generation, file operations, and exit.
         */
        SORT("Sort", 1),
        SEARCH("Search", 2), 
        INSERT_USER("Insert a new user", 3), 
        GENERATE_RANDOM("Generate random people", 4), 
        CHANGE_FILE("Do you want to change the file .txt?", 5), 
        EXIT("Exit", 6);

        private final int option; // A variable to hold the option number
        private final String description; // A variable to hold the option description

        /**
         * Constructor for MainMenuOption enum.
         *
         * @param description A string representing the menu option description.
         * @param option An integer representing the option number.
         */
        MainMenuOption(String description, int option) { 
            this.description = description; 
            this.option = option; 
        }

        /** 
         * Returns the option number associated with the menu option.
         * 
         * @return The option number.
         */
        public int getOption() { 
            return option; 
        }

        /** 
         * Returns the description of the menu option.
         * 
         * @return The option description.
         */
        public String getDescription() { 
            return description; 
        }
    }

    // Enumeration for sort options
    enum SortOption { 
        /**
         * Defines the available sorting options, including sorting by name,
         * management staff, and department.
         */
        SORT_BY_NAME("Sort by Name", 1), 
        SORT_BY_MANAGEMENT("Sort by Management Staff", 2), 
        SORT_BY_DEPARTMENT("Sort by Department", 3);

        private final int option; // Variable for option number
        private final String description; // Variable for description

        /**
         * Constructor for SortOption enum.
         *
         * @param description A string representing the sort option description.
         * @param option An integer representing the option number.
         */
        SortOption(String description, int option) { 
            this.description = description; 
            this.option = option; 
        }

        /** 
         * Returns the option number associated with the sort option.
         * 
         * @return The option number.
         */
        public int getOption() { 
            return option; 
        }

        /** 
         * Returns the description of the sort option.
         * 
         * @return The option description.
         */
        public String getDescription() { 
            return description; 
        }
    }

    // Enumeration for sort by name details
    enum SortByName { 
        /**
         * Defines the sorting options available for sorting names,
         * including ascending and descending orders.
         */
        ASCENDING("Sort Name Ascending", 1), 
        DESCENDING("Sort Name Descending", 2); 

        private final int option; // Variable for option number
        private final String description; // Variable for description

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

    // Enumeration for search options
    enum SearchOption { 
        /**
         * Defines the available search options, including searching by name,
         * management staff, and department.
         */
        SEARCH_BY_NAME("Search by Name", 1), 
        SEARCH_BY_MANAGEMENT("Search by Management Staff", 2), 
        SEARCH_BY_DEPARTMENT("Search by Department", 3); 

        private final int option; // Variable for option number
        private final String description; // Variable for description

        /**
         * Constructor for SearchOption enum.
         *
         * @param description A string representing the search option description.
         * @param option An integer representing the option number.
         */
        SearchOption(String description, int option) { 
            this.description = description; 
            this.option = option; 
        }

        /** 
         * Returns the option number associated with the search option.
         * 
         * @return The option number.
         */
        public int getOption() { 
            return option; 
        }

        /** 
         * Returns the description of the search option.
         * 
         * @return The option description.
         */
        public String getDescription() { 
            return description; 
        }
    }
    public static boolean exit = false; // A flag to control the exit of the program
    /**
     * The main method serves as the entry point for the program execution.
     * It initializes the Scanner for user input and displays the main menu
     * until the user decides to exit.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for user input
        

        // Loop that continues until the user decides to exit
        while (!exit) { 
            // Displaying the main menu
            System.out.println("\n--- Hospital Main Menu ---"); 
            mainMenu(scanner); // Call to mainMenu method to display options
        }
        scanner.close(); // Closing the Scanner to prevent resource leaks
        System.out.println("Thank you for using the Hospital system. Goodbye!"); // Goodbye message
    }

    /**
     * Displays the main menu options and handles user choices.
     *
     * @param scanner Scanner object for user input.
     */
    private static void mainMenu(Scanner scanner) { 
        int index = 0; // Variable to iterate through menu options
        boolean isvalid = false;

        // Displaying the main menu options
        while (index < MainMenuOption.values().length) { 
            MainMenuOption option = MainMenuOption.values()[index]; // Getting current option
            System.out.println(option.getOption() + ") " + option.getDescription()); // Printing option number and description
            index++; // Moving to the next option
        }

        String mainChoice; // Variable to store user's choice
        do {
            System.out.print("Please select an option: "); // Prompting the user for input
            mainChoice = scanner.nextLine(); // Reading user input

            // Switch statement to handle user choices
            switch (mainChoice) { 
                case "1": // If user chooses 'Sort'
                    sortMenu(scanner); // Call to sortMenu method
                    break;
                case "2": // If user chooses 'Search'
                    searchMenu(scanner); // Call to searchMenu method
                    break;
                case "3": // If user chooses 'Insert a new user'
                    System.out.println("You have chosen to insert a new user."); // Message indicating the choice
                    // Code to insert a new user here
                    break;
                case "4": // If user chooses 'Generate random people'
                    System.out.println("Generating random people..."); // Message indicating the choice
                    // Code to generate random people here
                    break;
                case "5": // If user chooses 'Change the file'
                    System.out.println("You chose to change the file .txt."); // Message indicating the choice
                    // Code to change the file here
                    break;
                case "6": // If user chooses 'Exit'
                    // Asking for confirmation to exit
                    System.out.print("Are you sure you want to exit? (y/n): "); 
                    String confirmExit = scanner.nextLine().trim(); // Reading user's confirmation (first character)
                    
                    if (confirmExit.equalsIgnoreCase("y")) { // If user confirms exit
                        exit = true; // Exit the program
                        isvalid = true;
                    }
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    break;
            }
        } while (!isvalid); // Loop continues until a valid option is chosen
    }

    /**
     * Displays sorting options and handles user choices for sorting.
     *
     * @param scanner Scanner object for user input.
     */
    private static void sortMenu(Scanner scanner) { 
        boolean backToMain = false; // Flag to control returning to the main menu

        do {
            System.out.println("\n--- Sort Options ---"); // Displaying sort options header
            int index = 0; // Variable to iterate through sort options
            while (index < SortOption.values().length) { 
                SortOption option = SortOption.values()[index]; // Getting current sort option
                System.out.println(option.getOption() + ") " + option.getDescription()); // Printing sort option number and description
                index++; // Moving to the next option
            }

            String sortChoice; // Variable to store user's choice
            System.out.print("Please select a sorting option: "); // Prompting for input
            sortChoice = scanner.nextLine(); // Reading user input

            // Switch statement to handle sorting choices
            switch (sortChoice) { 
                case "1": // If user chooses to sort by name
                    sortByNameMenu(scanner); // Call to sortByNameMenu method
                    break;
                case "2": // If user chooses to sort by management staff
                    System.out.println("Sorting by Management Staff..."); // Message indicating the choice
                    // Code to sort by management staff here
                    break;
                case "3": // If user chooses to sort by department
                    System.out.println("Sorting by Department..."); // Message indicating the choice
                    // Code to sort by department here
                    break;
                case "4": // If user chooses to return to the main menu
                    backToMain = true; // Set the flag to true to break out of the loop
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    break;
            }
        } while (!backToMain); // Loop continues until user chooses to return to main menu
    }

    /**
     * Displays sorting options for names and handles user choices.
     *
     * @param scanner Scanner object for user input.
     */
    private static void sortByNameMenu(Scanner scanner) { 
        boolean backToSort = false; // Flag to control returning to the sort menu

        do {
            System.out.println("\n--- Sort By Name Options ---"); // Displaying sort by name options header
            int index = 0; // Variable to iterate through sort by name options
            while (index < SortByName.values().length) { 
                SortByName option = SortByName.values()[index]; // Getting current sort by name option
                System.out.println(option.getOption() + ") " + option.getDescription()); // Printing option number and description
                index++; // Moving to the next option
            }

            String nameSortChoice; // Variable to store user's choice
            System.out.print("Please select a sort by name option: "); // Prompting for input
            nameSortChoice = scanner.nextLine(); // Reading user input

            // Switch statement to handle sorting by name choices
            switch (nameSortChoice) { 
                case "1": // If user chooses ascending sort
                    System.out.println("Sorting names in ascending order..."); // Message indicating the choice
                    mainMenu(scanner); // Call to mainMenu method to display options
                    // Code to sort names in ascending order here
                    break;
                case "2": // If user chooses descending sort
                    System.out.println("Sorting names in descending order..."); // Message indicating the choice
                    mainMenu(scanner); // Call to mainMenu method to display options
                    // Code to sort names in descending order here
                    break;
                case "3": // If user chooses to return to the sort menu
                    backToSort = true; // Set the flag to true to break out of the loop
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    break;
            }
        } while (!backToSort); // Loop continues until user chooses to return to sort menu
    }

    /**
     * Displays searching options and handles user choices for searching.
     *
     * @param scanner Scanner object for user input.
     */
    private static void searchMenu(Scanner scanner) { 
        boolean backToMain = false; // Flag to control returning to the main menu

        do {
            System.out.println("\n--- Search Options ---"); // Displaying search options header
            int index = 0; // Variable to iterate through search options
            while (index < SearchOption.values().length) { 
                SearchOption option = SearchOption.values()[index]; // Getting current search option
                System.out.println(option.getOption() + ") " + option.getDescription()); // Printing option number and description
                index++; // Moving to the next option
            }

            String searchChoice; // Variable to store user's choice
            System.out.print("Please select a search option: "); // Prompting for input
            searchChoice = scanner.nextLine(); // Reading user input

            // Switch statement to handle searching choices
            switch (searchChoice) { 
                case "1": // If user chooses to search by name
                    System.out.println("Searching by Name..."); // Message indicating the choice
                    mainMenu(scanner); // Call to mainMenu method to display options
                    // Code to search by name here
                    break;
                case "2": // If user chooses to search by management staff
                    System.out.println("Searching by Management Staff..."); // Message indicating the choice
                    mainMenu(scanner); // Call to mainMenu method to display options                    
                    // Code to search by management staff here
                    break;
                case "3": // If user chooses to search by department
                    System.out.println("Searching by Department..."); // Message indicating the choice
                    mainMenu(scanner); // Call to mainMenu method to display options
                    // Code to search by department here
                    break;
                case "4": // If user chooses to return to the main menu
                    backToMain = true; // Set the flag to true to break out of the loop
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    break;
            }
            
        } while (!backToMain); // Loop continues until user chooses to return to main menu
    }
}