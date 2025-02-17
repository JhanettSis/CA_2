Project: Hospital Management System (Java CLI)

This project is a hospital management system built using Java's Command Line Interface (CLI). It offers several functionalities for managing staff data, including sorting, searching, user insertion, random data generation, and file operations.

Search Methods:
The system employs Linear Search and Binary Search algorithms for efficiently retrieving information.

Linear Search: This method checks each element in the dataset sequentially, which is ideal for smaller, unsorted datasets. It ensures that the program can handle search queries even if the data isn't pre-ordered.
Binary Search: For larger and sorted datasets, Binary Search divides the data in half and eliminates half of the remaining elements with each step, making it much faster than Linear Search for larger datasets. This allows the system to handle more extensive data efficiently when sorting is applied.
Code Organization & Readability:
To ensure the project is clean, maintainable, and understandable by other developers, I organized the code into separate files for different functionalities. This separation promotes readability and makes it easier to manage and modify different parts of the program without unnecessary complexity.

Data Handling:
The program uses arrays to store and manage mock data. The data is stored in arrays to simulate a staff details. By using arrays, the program can efficiently process and access large datasets during execution.

User Interface & Interactivity:
A user-friendly menu-driven is implemented, allowing users to choose from various options easily. The system uses loops to keep the program running until the user decides to exit. This ensures a smooth user experience with repeated access to features without restarting the program.

Input Validation:
To ensure that the data entered by users is valid, I implemented input validation based on the data type required (e.g., validating that a user enters a valid number for options or a correctly formatted date for hospital admission). This prevents errors and ensures data integrity throughout the system.

Variable Naming:
In order to improve clarity for future developers, I renamed variables with meaningful names. By choosing descriptive and intuitive names for variables, I made it easier to understand the code's purpose, improving maintainability and reducing confusion when the code is updated or reviewed.
