package student;

public class Major {
    private static int nextId = 1;
    public static final int MAX_CAPACITY = 50;
    private int id;
    private String code;
    private String name;
    private Student[] students;
    private int studentCount;
    public static final Major DEFAULT_CS_MAJOR = new Major("23", "Computer Science");

    public Major() {
        this.id = nextId++;
        this.code = "";
        this.name = "";
        this.students = new Student[MAX_CAPACITY];
        this.studentCount = 0;
    }

    public Major(String code, String name) {
        this.id = nextId++;
        this.code = code;
        this.name = name;
        this.students = new Student[MAX_CAPACITY];
        this.studentCount = 0;
    }

    // Method to add a student
    public void addStudent(Student s) {
        if (s == null) {
            return;
        }
        if (studentCount < MAX_CAPACITY) {
            students[studentCount++] = s;
        }
        else {
            System.out.println("Maximal capacity reached for " + name);
        }
    }
    public Student findStudentByCNE(String cne) {
        if (cne == null) {
            return null;
        }
        for (int i = 0; i < studentCount; i++) {
            if (cne.equals(students[i].getCne())){
                return students[i];
            }
        }
        return null;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public boolean removeStudent(String cne) {
        Student found = findStudentByCNE(cne);
        if (found == null) {
            return false;
        }
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getCne().equals(cne)) {
                for (int j = i; j < studentCount; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                return true;
            }
        }
        return false;
    }

    public double getOccupancyRate() {
        return ((double) studentCount / MAX_CAPACITY) * 100;
    }

    public String getStudentListAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(students[i].getCne())
                    .append(" ")
                    .append(students[i].getLastName().toUpperCase())
                    .append(" ")
                    .append(students[i].getFirstName())
                    .append("\n");
        }
        return sb.toString();
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major[id=" + id + ", code=" + code + ", name=" + name + ", studentCount=" + studentCount + "]";
    }

    // Display all students in the major
    public void displayStudents() {
        System.out.print(getStudentListAsString());
    }


}
