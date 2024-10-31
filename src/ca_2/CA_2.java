package ca_2;
/**
 *
 * @author jhane
 */
import java.util.ArrayList;
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
        EXIT("Exit", 5);

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

    
    public static boolean isValid = false;
    public static boolean endProgram = false;
    
    private static boolean confirmExit(Scanner scanner) {
        System.out.println("    \n❖ Are you sure you want to exit? (Press 'y' to exit!)");
        System.out.println("    ❖ Otherwise press any key!");
        return scanner.nextLine().equalsIgnoreCase("y");
    }
    
    public static ArrayList<String> UserNames, ManagementTeam, Departments = new ArrayList<>();
            
    
    /**
     * The main method serves as the entry point for the program execution.
     * It initializes the Scanner for user input and displays the main menu
     * until the user decides to exit.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for user input
        
        // This string will have the name of the file entered by the user.
        String fileName = "";
        
        // Loop that continues until the user decides to exit
        while (!endProgram) { 
            // Displaying the main menu
            System.out.println("☸☸==================☸☸  Hospital Main Menu  ☸☸==================☸☸");
            // Shows a menu header to the user.
            // Asks the user to input the name of the file to read.
            System.out.println("  ❖ Please enter the full path to read the file");
            System.out.println("     (e.g., C:/username/Downloads/Applicants_Form.txt). ");
            System.out.println("     Make sure to include the drive letter and all folders leading to the file.");
            
            System.out.print("  ❖ Please insert the name of the file to read: ");
            // Reads the file name from the user's input.
            fileName = scanner.nextLine();
            // Calls a method to read the file and return the data in an ArrayList.
            FillUpArrays.setFile(fileName, scanner);
            
           if (confirmExit(scanner)) {
                    endProgram = true; // Exit the program if confirmed
                    
                }
                                    
        }
        scanner.close(); // Closing the Scanner to prevent resource leaks
        System.out.println("Thank you for using the Hospital system. Goodbye!"); // Goodbye message
    }

    /**
     * Displays the main menu options and handles user choices.
     *
     * @param scanner Scanner object for user input.
     */
    public static void mainMenu(ArrayList<String> UserNames, ArrayList<String> ManagementTeam,ArrayList<String> Departments, Scanner scanner, String fileName) { 
        int index = 0; // Variable to iterate through menu options
        
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
                    SortListAscDesc.sortMenu(UserNames, ManagementTeam, Departments, scanner, fileName); // Call to sortMenu method
                    
                    break;
                case "2": // If user chooses 'Search'
                    SearchOnTheList.searchMenu(UserNames, ManagementTeam, Departments, scanner, fileName); // Call to searchMenu method
                    break;
                case "3": // If user chooses 'Insert a new user'
                    System.out.println("You have chosen to insert a new user."); // Message indicating the choice
                    // Code to insert a new user here
                    break;
                case "4": // If user chooses 'Generate random people'
                    CreateRandomData.generateRandomEmployeeData(fileName); // Calls method to generate and save employee data
                    FillUpArrays.setFile(fileName, scanner);
                    break;
                case "5": 
                    if (confirmExit(scanner)) { 
                        scanner.close(); // Closing the Scanner to prevent resource leaks
                        System.out.println("Thank you for using the Hospital system. Goodbye!"); // Goodbye message
                        System.exit(0);
                    }
                    break;
                default: // If user inputs an invalid option
                    System.out.println("Choose a valid option."); // Message indicating invalid choice
                    isValid = false;
                    break;
            }
        } while (!isValid); // Loop continues until a valid option is chosen
    }
}