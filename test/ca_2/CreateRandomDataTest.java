/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhane
 */
public class CreateRandomDataTest {
    
    private static final String TEST_FILE_NAME = "Applicants_Form.txt";
    
    @Before
    public void setUp() {
        // Ensure the test file does not exist before each test
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            // ******* Not delete file : when the tester want to check the methor SearchOnTheList
            // put in commends this line file.delete();
            file.delete();
        }
    }
    
    @After
    public void tearDown() {
        // Clean up the test file after each test
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            // ******* Not delete file : when the tester want to check the methor SearchOnTheList
            // put in commends this line file.delete();
            file.delete();
        }
    }

    /**
     * Test of generateRandomEmployeeData method, of class CreateRandomData.
     */
    @Test
    public void testGenerateRandomEmployeeData() {
        System.out.println("Running test: generateRandomEmployeeData");
        
        // Call the method to generate random employee data
        CreateRandomData.generateRandomEmployeeData(TEST_FILE_NAME);
        
        // Check if the file was created
        File file = new File(TEST_FILE_NAME);
        assertTrue("File should have been created", file.exists());
        
        // Verify the file is not empty
        assertTrue("File should not be empty", file.length() > 0);

        // Check if the file contains expected formatted data
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_NAME))) {
            String line = reader.readLine();
            
            // Check that the first line is not null and follows the expected format
            assertNotNull("The file should contain at least one line", line);
            
            // Sample check for data format (Name, ManagementType, Department)
            String[] dataParts = line.split(",");
            assertEquals("The line should contain exactly 3 parts", 3, dataParts.length);

            // Further checks to ensure data content isn't empty
            assertFalse("Name should not be empty", dataParts[0].trim().isEmpty());
            assertFalse("ManagementType should not be empty", dataParts[1].trim().isEmpty());
            assertFalse("Department should not be empty", dataParts[2].trim().isEmpty());

        } catch (IOException e) {
            fail("An error occurred while reading the generated file: " + e.getMessage());
        }
    }
    
}
