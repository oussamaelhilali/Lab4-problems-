package Instructor;

public class Subject {
    private int id;
    private String code;
    private String title;

    public Subject(int id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public String normalizedCode() {
        if (code == null) return "";
        return code.trim().toUpperCase();
    }

    public String properTitle() {
        if (title == null || title.isEmpty()) return "";

        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return sb.toString().trim(); // trim() removes the trailing space at the end
    }

    public boolean isIntroCourse() {
        boolean hasIntroTitle = title != null && title.toLowerCase().contains("intro");
        boolean startsWithIntroCode = normalizedCode().startsWith("INTRO-");

        return hasIntroTitle || startsWithIntroCode;
    }

    public String syllabusLine(Instructor inst) {
        StringBuilder sb = new StringBuilder();
        sb.append(normalizedCode())
                .append(" - ")
                .append(properTitle())
                .append(" (Instructor: ");

        if (inst != null) {
            sb.append(inst.getLastName()).append(" ").append(inst.getFirstName());
        } else {
            sb.append("TBA");
        }
        sb.append(")");

        return sb.toString();
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getTitle() {
        return title;
    }
}