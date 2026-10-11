package Instructor;

import student.Person;

public class Instructor extends Person {
    private String employeeNumber;

    public Instructor(String firstName, String secondName, String phone, String email, String employeeNumber) {
        super(firstName, secondName, phone, email);
        this.employeeNumber = employeeNumber;
    }

    public String cleanEmployeeNumber() {
        if (employeeNumber == null) return "";
        return employeeNumber.trim().replace(" ", "");
    }

    public String summaryLine() {
        return String.format("Instructor[employeeNumber=%s, lastName=%s, firstName=%s]",
                cleanEmployeeNumber(), getLastName(), getFirstName());
    }

    public String toCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instructor\n")
                .append("Employee #: ").append(cleanEmployeeNumber()).append("\n")
                .append("Name      : ").append(getLastName()).append(", ").append(getFirstName()).append("\n")
                .append("Email     : ").append(getEmail()).append("\n")
                .append("Phone     : ").append(getPhone());
        return sb.toString();
    }

    public String displayName() {
        StringBuilder sb = new StringBuilder();
        if (firstName != null && !firstName.isEmpty()) {
            sb.append(firstName).append(" ");
        }
        if (secondName != null && !secondName.isEmpty()) {
            sb.append(secondName);
        }
        return sb.toString().trim();
    }

    // Getter & Setter
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}