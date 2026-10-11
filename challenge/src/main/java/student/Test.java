package student;

public class Test {
    public static void main(String[] args) {
        // 4.a Create a couple of majors
        Major csMajor = Major.DEFAULT_CS_MAJOR;
        Major mathMajor = new Major("12", "Applied Mathematics");

        // 4.b Create some students associated with these majors
        // Using the 5-parameter constructor defaults them to Computer Science
        Student s1 = new Student("SAFI", "Amal", "0600000001", "amal@test.com", "22885676");
        Student s2 = new Student("ALAMI", "Samir", "0600000002", "samir@test.com", "23585976");

        // Using the 6-parameter constructor links this student to Applied Mathematics
        Student s3 = new Student("BENALI", "Fatima", "0600000003", "fatima@test.com", "21998877", mathMajor);

        // 4.c Display computer science students
        System.out.println("The list of students in the computer science major is:");
        csMajor.displayStudents();

        // ---------------------------------------------------------
        // 11. Call the newly created methods (Steps 6, 7, 8, 9)[cite: 5]
        // ---------------------------------------------------------
        System.out.println("\n--- Testing New Methods ---");

        // Step 7: Count students
        System.out.println("Computer science capacity: " + Major.MAX_CAPACITY + " students");
        System.out.println("Current enrollment: " + csMajor.getStudentCount() + " students");

        // Step 9: Occupancy rate
        System.out.printf("Occupancy rate = %.1f%%\n", csMajor.getOccupancyRate());

        // Step 6: Find student
        System.out.print("\nSearching for CNE '23585976': ");
        Student found = csMajor.findStudentByCNE("23585976");
        if (found != null) {
            System.out.println("Found " + found.getFullNameFormatted());
        } else {
            System.out.println("Not found.");
        }

        // Step 8: Remove student
        System.out.println("Removing student with CNE '22885676'...");
        boolean isRemoved = csMajor.removeStudent("22885676");
        System.out.println("Removal successful? " + isRemoved);

        System.out.println("\nUpdated list of students in Computer Science:");
        csMajor.displayStudents();
    }
}