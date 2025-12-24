class Student {
    String name;
    int age;
    int year;
    int id;
    Student(String name, int age, int year, int id) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.id = id;
    }
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Year: " + year+", ID: " + id);
    }
    void passYear() {
        year++;
    }
    void birthday() {
        age++;
    }
}
class GradeCalculator{
    int marks;
    GradeCalculator(int marks) {
        this.marks = marks;
    }

    char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
    void printmark() {
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
    void printPassStatus() {
        if (marks >= 60) {
            System.out.println("Status: Passed");
        } else {
            System.out.println("Status: Failed");
        }
    }

    boolean hasPassed() {
        return marks >= 60;
    }
}
class StudentRepository {
    private Student[] students;
    private int count = 0;

    StudentRepository(int capacity) {
        students = new Student[capacity];
    }

    void save(Student student) {
        students[count] = student;
        count++;
    }
    void removeStudentByID(int ID) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == ID) {
                System.out.println("Student " + students[i].name + " removed.");
                students[i].name = null;
                students[i].age = 0;
                students[i].year = 0;
                students[i].id = 0;
                count--;
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void printStudent(int index) {
        students[index].displayInfo();
    }

    void printAllStudents() {
        System.out.println("All Students:");
        for (int i = 0; i < count; i++) {
            students[i].displayInfo();
        }
    }
}
class EmailService {
    
    String line;
    void writemsg(String line) {
        this.line = line;
    }
    void sendResultEmail(String studentName, char grade, boolean passed) {
        System.out.println("Sending email to " + studentName);
        System.out.println("Grade: " + grade);
        if(passed == true) {
            System.out.println("Status: Passed");
        } else {
            System.out.println("Status: Failed");
        }
    }
    void sendmsg() {
        System.out.println(line);
    }
}
public class test2 {
    public static void main(String[] args) {
        Student student1 = new Student("Bin Billgates", 19, 2, 101);
        student1.displayInfo();
        student1.birthday();
        student1.passYear();
        student1.displayInfo();

        System.out.println("--------------------------------");

        GradeCalculator gradeCal = new GradeCalculator(85);
        gradeCal.calculateGrade();
        gradeCal.hasPassed();

        gradeCal.printmark();
        gradeCal.printPassStatus();

        System.out.println("--------------------------------");

        StudentRepository repository = new StudentRepository(67);
        repository.save(student1);
        repository.save(new Student("Fon", 67, 1, 102));
        repository.printStudent(1);
        repository.printAllStudents();
        System.out.print("Remove student:\n");
        repository.removeStudentByID(102);
        repository.printAllStudents();

        System.out.println("--------------------------------");

        EmailService emailService = new EmailService();
        emailService.sendResultEmail(student1.name, gradeCal.calculateGrade(), gradeCal.hasPassed());
        emailService.writemsg("Congrats");
        emailService.sendmsg();
    }
}
