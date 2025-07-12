import java.util.*;

class Student {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Course: " + course);
    }
}

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student s = new Student(rollNo, name, course);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.rollNo == rollNo) {
                System.out.println("Student found:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = sc.nextInt();
        boolean removed = false;

        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.rollNo == rollNo) {
                itr.remove();
                removed = true;
                System.out.println("Student deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found!");
        }
    }
}
