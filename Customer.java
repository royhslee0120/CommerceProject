package commerce;

public class Customer {

    private String name;
    private String email;
    private String grade;

    public Customer(String name, String email, String grade) {
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

        @Override
    public String toString() {
        return String.format("고객명: %s | 이메일: %s | 등급: %s",name, email, grade);
    }
}
