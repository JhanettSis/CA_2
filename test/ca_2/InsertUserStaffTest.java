/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca_2;
/**
 *
 * @author jhane
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertUserStaffTest {

    private static final String TEST_FILE = "employees.txt";
    private final File file = new File(TEST_FILE);
    private final InputStream originalSystemIn = System.in;

    @Before
    public void setUp() throws IOException {
        // Clean up before each test to ensure the file is empty
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    @After
    public void tearDown() {
        // Clean up after each test
        if (file.exists()) {
            file.delete();
        }
        // Restore System.in to its original state
        System.setIn(originalSystemIn);
    }

    @Test
    public void testInsertStaffValidInput() throws IOException {
        // Simulating valid input using System.setIn()
        // Name: "Diego Doe", ManagerRoleType: "Assistant_Manager", DepartmentType: "Administrative"
        String simulatedInput = "Diego Doe\n2\n1\n"; 
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Call the InserStaff method
        Scanner scanner = new Scanner(System.in);
        String fileName = TEST_FILE;
        
        // InserStaff method is available and correctly implemented in InsertUserStaff class
        InsertUserStaff.InserStaff(scanner,  fileName);

        // Ensure the file was actually written
        File file = new File(TEST_FILE);
        assertTrue("File should exist after inserting staff.", file.exists());

        // After the method is executed, verify the content of the file
        BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE));
        String line = reader.readLine();
        reader.close();

        // Debugging output (optional)
        System.out.println("Line1 read from file: " + line);

        // Expected result to match with the format "Name, managementType, Department"
        String expectedLine = "Diego Doe,Assistant_Manager,Administrative";
        System.out.println(expectedLine);
        assertEquals("The file content should contain the correct staff entry.", expectedLine, line);
        
        // Expected result to match with the format "Name, managementType, Department"
        assertEquals("The file content should match the expected staff entry.", expectedLine.trim(), line != null ? line.trim() : null);
    }
}
