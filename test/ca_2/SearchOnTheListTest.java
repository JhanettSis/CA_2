/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca_2;

import static ca_2.SearchOnTheList.binarySearch;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhane
 */
public class SearchOnTheListTest {
    
    private final ArrayList<String> userNames = new ArrayList<>();
    private final ArrayList<String> managementTeam = new ArrayList<>();
    private final ArrayList<String> departments = new ArrayList<>();
    // To read the file for the method SearchOnThelist 
    //put en commend the lines on FileTester CreateRandomDataTest.java
    // Search the function Before and After on there.
    private static final String TEST_FILE = "Applicants_Form.txt";

    @Before
    public void setUp() {
        // Initialize lists with sample data
        // Sample data to be used in tests
        userNames.add("Alice Johnson");
        userNames.add("Bob Smith");
        userNames.add("Cole Horton");

        managementTeam.add("Team A");
        managementTeam.add("Team B");
        managementTeam.add("Team C");

        departments.add("HR");
        departments.add("IT");
        departments.add("Finance");
    }

    @After
    public void tearDown() {
        // Clear lists after each test
        userNames.clear();
        managementTeam.clear();
        departments.clear();
    }
    
    /**
     * Test for the binary search method in SearchOnTheList.
     */
    @Test
    public void testBinarySort() {
        System.out.println("Running binarySearch test...");

        // Sort lists in ascending order
        SortListAscDesc.quickSort(userNames, managementTeam, departments, true);

        // Test searching for an existing user
        int index = SearchOnTheList.binarySearch(userNames, "Bob Smith");
            if (index != -1) { // If the name was found
                System.out.println("Name fount in Position " + index);
                System.out.println("        ➽ Name Staff: " + userNames.get(index));
                System.out.println("        ➽ Management Team: " + managementTeam.get(index));
                System.out.println("        ➽ Department: " + departments.get(index));
            } 
            
        assertEquals("Bob Smith should be found at index 1", 1, index);
            
            
        // Test searching for a non-existing user
        index = SearchOnTheList.binarySearch(userNames, "Diana Prince");
        
        assertEquals("Diana Prince should not be found", 1, index);
    }

}
