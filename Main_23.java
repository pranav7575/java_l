import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String contactInfo;

    public Student(int id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Grade='" + grade + '\'' +
                ", Contact Info='" + contactInfo + '\'' +
                '}';
    }
}

// Main class
public class Main_23 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static void main(String[] args) {
        if (adminLogin()) {
            menu();
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    private static boolean adminLogin() {
        System.out.println("Enter admin username:");
        String username = scanner.nextLine();
        System.out.println("Enter admin password:");
        String password = scanner.nextLine();
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("A. Add a new student");
            System.out.println("B. Remove a student by ID");
            System.out.println("C. Update student information");
            System.out.println("D. Display all students");
            System.out.println("E. Search for a student");
            System.out.println("F. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addStudent();
                    break;
                case "B":
                    removeStudent();
                    break;
                case "C":
                    updateStudent();
                    break;
                case "D":
                    displayStudents();
                    break;
                case "E":
                    searchStudent();
                    break;
                case "F":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        // Check for duplicate ID
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student contact information: ");
        String contactInfo = scanner.nextLine();

        students.add(new Student(id, name, age, gender, grade, contactInfo));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student toRemove = null;

        for (Student student : students) {
            if (student.getId() == id) {
                toRemove = student;
                break;
            }
        }

        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with this ID does not exist.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student toUpdate = null;

        for (Student student : students) {
            if (student.getId() == id) {
                toUpdate = student;
                break;
            }
        }

        if (toUpdate != null) {
            System.out.print("Enter new student name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) toUpdate.setName(name);

            System.out.print("Enter new student age (leave blank to keep current): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.trim().isEmpty()) toUpdate.setAge(Integer.parseInt(ageInput));

            System.out.print("Enter new student gender (leave blank to keep current): ");
            String gender = scanner.nextLine();
            if (!gender.trim().isEmpty()) toUpdate.setGender(gender);

            System.out.print("Enter new student grade (leave blank to keep current): ");
            String grade = scanner.nextLine();
            if (!grade.trim().isEmpty()) toUpdate.setGrade(grade);

            System.out.print("Enter new student contact information (leave blank to keep current): ");
            String contactInfo = scanner.nextLine();
            if (!contactInfo.trim().isEmpty()) toUpdate.setContactInfo(contactInfo);

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with this ID does not exist.");
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudent() {
        System.out.println("Search by: ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Grade");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println(student);
                        return;
                    }
                }
                System.out.println("Student with this ID does not exist.");
                break;

            case "2":
                System.out.print("Enter name: ");
                String name = scanner.nextLine().toLowerCase();
                for (Student student : students) {
                    if (student.getName().toLowerCase().contains(name)) {
                        System.out.println(student);
                    }
                }
                break;

            case "3":
                System.out.print("Enter grade: ");
                String grade = scanner.nextLine().toLowerCase();
                for (Student student : students) {
                    if (student.getGrade().toLowerCase().contains(grade)) {
                        System.out.println(student);
                    }
                }
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}
