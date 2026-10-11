package student;

public class Student extends Person {
    private String cne;
    private Major major;

    public Student(String nom, String prenom, String telephone, String email, String cne, Major major) {
        super(prenom, nom, telephone, email);
        this.cne = cne;
        this.major = major;

        if (this.major != null) {
            this.major.addStudent(this);
        }
    }
    public Student(String nom, String prenom, String telephone, String email, String cne) {
        this(nom, prenom, telephone, email, cne, Major.DEFAULT_CS_MAJOR);
    }

    // Getters
    public String getCne() {
        return cne;
    }

    public Major getMajor() {
        return major;
    }

    // Setters
    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getFullNameFormatted() {
        String formattedLast = "";
        String formattedFirst = "";

        if (secondName != null) {
            formattedLast = secondName.toUpperCase();
        }

        if (firstName != null && !firstName.isEmpty()) {
            formattedFirst = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        }

        return String.format("%s, %s", formattedLast, formattedFirst);
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", CNE=" + cne + ", Name=" + getFullNameFormatted() + "]";
    }


}

