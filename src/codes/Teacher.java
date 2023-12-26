package codes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Teacher extends Employee    {
    private TeacherDegree teacherDegree;

    private Faculty faculty;

    private Double rating;

    private Subjects LessonType;
    private ArrayList<Subject> subjects = new ArrayList<>();

    private ArrayList<Complaint> complaints = new ArrayList<Complaint>();


    public Teacher() {};

    public Teacher (String firstName, String secondName, int age, String ID, String owlName, TeacherDegree teacherDegree, String nickname, String password) {
        super(firstName, secondName, age, ID, owlName, nickname, password);
        this.teacherDegree = teacherDegree;
    }

    public void GreatHall() throws Exception {
        try {


            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Make Request");
                System.out.println("3) Send complaint");
                System.out.println("4) Personal Data");
                System.out.println("5) Change Password");
                System.out.println("6) Parcels(Messages)");
                System.out.println("7) View my subjects info");
                System.out.println("8) Manage subjects");
                System.out.println("9) View students/Put Marks");
                System.out.println("0) Logout");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
//                    System.out.println(date.getMonth());
                        news();
                        Database.logUserAction(this, "View news");
                        break;
                    case 2:
                        makeRequest();
                        Database.logUserAction(this, "Made Request");
                        break;
                    case 3:
                        // send complaint method
                        sendComplaint();
                        break;
                    case 4:
                        personalData();
                        Database.logUserAction(this, "Saw personal data");
                        break;

                    case 5:
                        changePassword();
                        Database.logUserAction(this, "Changed password");
                        break;
                    case 6:
                        Database.logUserAction(this, "Messages");
                        Messages();
                        // I will write method for message
                        break;
                    case 7:
                        viewSubjects();
                        break;
                    case 8:

                        break; //  I SHOULD WRITE METHODS
                    case 9:
                        Students();
                        break; //  I SHOULD WRITE METHODS

                    case 0:
                        LogOut();
                        Database.logUserAction(this, "Logged out");
                        System.out.println("Logged out. Returning to the main menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
        catch (NumberFormatException n){
            System.out.println("Choose the correct number!");
        }
    }
    public Dean getDean() {
        return Dean.getInstance(); // Return the single instance of Dean
    }
    public void sendComplaint() throws IOException {
        boolean ok = true;
        while(ok){
            System.out.println("All students");
            Database.getStudents();
            System.out.println("1) Send complaint");
            System.out.println("0) Back");
            int ans = Integer.parseInt(reader.readLine());
            switch (ans){
                case 1:
                    System.out.print("Student ID for complaint: ");
                    String id = reader.readLine();
                    Student selectStudent = Database.getStudent(id);
                    System.out.println("Write details of the complaint");
                    String detail = reader.readLine();
                    System.out.println("Choose the urgency of complaint:\n1) LOW\n2) MEDIUM\n3) HIGH");
                    int urgency = Integer.parseInt(reader.readLine());
                    Urgency finalurgency = null;
                    switch (urgency) {
                        case 1:
                            finalurgency = Urgency.LOW;
                            break;
                        case 2:
                            finalurgency = Urgency.MEDIUM;
                            break;
                        case 3:
                            finalurgency = Urgency.HIGH;
                            break;
                    }
                    sendComplaint(selectStudent, detail, finalurgency);
                    break;
                case 0:
                    ok = false;
                    break;
            }


        }
    }

    public void sendComplaint(Student student, String details, Urgency urgency) {
        Complaint complaint = new Complaint(this, student, details, urgency);
        Database.addComplaint(complaint);
    }

    public void viewComplaints() {
        for (Complaint complaint : complaints) {
            System.out.println(complaint);
        }
    }


    public void viewSubjects(){
        for(Subject s: subjects){
            System.out.println(s);
        }
    }

    public void setSubjects(Subject subject){
        subjects.add(subject);
    }

    public void Students() throws Exception {
        try {
            System.out.println("1) Info about students");
            System.out.println("2) Put Marks");
            System.out.println("0) Quit");
            System.out.print("Your choice: ");
            int answer = Integer.parseInt(reader.readLine());
            switch (answer) {
                case 1:
                    System.out.print("Code of Subject: ");
                    String code = reader.readLine();
                    Subject subject = null;
                    boolean oki = false;
                    for (Subject s : subjects) {
                        if (s.getCode().equals(code)) {
                            oki = true;
                            subject = s;
                        }
                    }
                    if (oki) {
                        System.out.println(viewStudents(subject));
                    } else if (!oki) {
                        System.out.println("Unsuccessful operation");
                    }
                    break;
                case 2:
                    beforeMark();
                    break;
                case 0:
                    this.GreatHall();
                    break;
            }
        }
        catch (NumberFormatException n){
            System.out.println("Unsuccessful operation");
        }

    }
    public ArrayList<Student>viewStudents(Subject subject){
        return subject.getStudents();
    }


    public TeacherDegree getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(TeacherDegree teacherDegree) {
        this.teacherDegree = teacherDegree;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Double getRaring() {
        return rating;
    }

    public void setRating(Double raring) {
        this.rating = raring;
    }
    private HashMap<Student, HashMap<Subject, Grade>> studentGrades = new HashMap<>();

    public void viewInfo() {
        System.out.println("Teacher Information:");
        System.out.println("Name: " + getFirstName() + " " + getSecondName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getID());
        System.out.println("Owl Name: " + getOwlName());
        System.out.println("Academic Degree: " + teacherDegree);
        System.out.println("Faculty: " + faculty);
        System.out.println("Rating: " + rating);
        System.out.println("Lesson Type: " + LessonType);
        System.out.println("Courses Taught:");

    }
    public Subject getSubject(String code){
        boolean ok = false;
        for(Subject s: subjects){
            if(s.getCode().equals(code)){
                ok = true;
                System.out.println("Successful operation");
                return s;

            }
        }
        if(!ok){
            System.out.println("Error");
        }
       return null;
    }

    public void beforeMark(){
        try{
            for(Subject s: subjects){
                System.out.println(s);
            }
            System.out.print("Enter code from the list: " );
            String choice = reader.readLine();
            Subject subject = getSubject(choice);

            while(true) {
                System.out.println("""
                        1. Put student mark
                        0. Exit back""");
                choice = reader.readLine();
                if (choice.equals("0")) {
                    break;
                }
                else if (choice.equals("1")) {
                    System.out.println(viewStudents(subject));
                    System.out.print("Enter student ID: ");
                    String input = reader.readLine();
                    String finalInput = input;
                    Student student = subject.getStudents().stream()
                            .filter(s -> s.getID().equals(finalInput))
                            .findFirst()
                            .orElse(null);
                    assert subject != null;
                    if (student != null) {
                        assert student != null;
                        System.out.println("Student: " + student.getFullName() +"\n");
                        System.out.println("""
                                Choose type of mark
                                1. First attestation
                                2. Second attestation
                                3. Final""");
                        input = reader.readLine();
                        TypeOfMark tm = switch (input) {
                            case "1" -> TypeOfMark.FIRST_ATTESTATION;
                            case "2" -> TypeOfMark.SECOND_ATTESTATION;
                            case "3" -> TypeOfMark.FINAL;
                            default -> null;
                        };
                        System.out.println("Please enter your mark");
                        input = reader.readLine();
                        double studentPoint = Double.parseDouble(input);
                        this.putMark(subject, tm, studentPoint, student);
                        System.out.println("Mark was added");
                    }
                    else {
                        System.out.println("Student doesn't exist");
                    }
                }
            }
        }
        catch (NullPointerException | IOException e){
            System.out.println("Error");
        }
    }


    public void putMark(Subject subject, TypeOfMark typeOfMark, double points, Student student) {
        subject.putMark(student, points, typeOfMark);
        Mark m = subject.getMarkOfStudent(student);
        student.setSubjectMarks(subject, m);
    }

    public String toString(){
        return ("Name: " + firstName + " " + secondName + ", Rating: " + rating + "/10");
    }
}