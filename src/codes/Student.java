package codes;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static codes.User.reader;

public class Student extends User {
    private Integer yearOfStudy;
    private String property;
    private String organization;
    public int totalCredits;
    private Faculty faculty;
    private boolean moodOfHat = new Random().nextBoolean();
    public HashMap<Subject, Mark> marks = new HashMap<>();
    public ArrayList<Subject> subjects = new ArrayList<>();
    private LocalDate date = LocalDate.now();
    public boolean isTotalCreditsCalculated = false;
    public double GPA;
    {
        for (Subject c : marks.keySet()) {
            Mark mark = marks.get(c);
            GPA += (mark.getDigitMark() * c.getCredits()) / (c.getCredits() * marks.size());
        }
    }


    //    private boolean dos = false;
    List<String> gryffindor = Arrays.asList("bravery", "daring", "nerve", "chivalry");
    List<String> hufflepuff = Arrays.asList("hard work", "dedication", "patience", "loyalty", "fair play");
    List<String> ravenclaw = Arrays.asList("intelligence", "knowledge", "curiosity", "creativity", "wit");
    List<String> slytherin = Arrays.asList("ambition", "leadership", "self-preservation", "cunning", "resourcefulness");
    public Student(){};
    public Student(String firstName, String secondName, int age, String ID, String owlName, Integer yearOfStudy, String property, String organization /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName);
        this.yearOfStudy = yearOfStudy;
        this.property = property;
        this.organization = organization;
    }

    public Student(String name, String lastName, int age, String id, String owl, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
    }
    public Student(String name, String lastName, int age, String id, String owl, Faculty faculty, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
        this.faculty = faculty;
    }

    public double getGPA(){
        return GPA;
    }




    public void GreatHall() throws Exception {
        if(!isTotalCreditsCalculated) {
            {
                for (Subject s : subjects) {
                    totalCredits += s.getCredits();
                }
            }
            isTotalCreditsCalculated = true;
        }
        boolean ok = true;
        int cnt = 0;
        for (Mark mark : marks.values()) {
            if (mark != null && mark.getLiteralMark().equals("F")) {
                cnt++;
            }
            if (cnt >= 3) {
                ok = false;
                System.out.println("\nYou have more than 3 fails! You cannot to open GREAT HALL!");
                break;  // Exit the loop once you reach 3 F grades
            }
        }
        while (ok) {
            System.out.println("\n$$===== Great Hall Menu =====$$");
            System.out.println("1) News");
            System.out.println("2) Make Request");
            System.out.println("3) Personal Data");
            System.out.println("4) Change Password");
            System.out.println("5) Parcels(Messages)");
            System.out.println("6) Sorting Hat");
            System.out.println("7) View my subjects info");
            System.out.println("8) Subject registration");
            System.out.println("9) View Transcript");
            System.out.println("10) Teachers rate/info");
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
                    personalData();
                    Database.logUserAction(this, "Saw personal data");
                    break;
                case 4:
                    changePassword();
                    Database.logUserAction(this, "Changed password");
                    break;
                case 5:
                    Database.logUserAction(this, "Messages");
                    Messages();
                    // I will write method for message
                    break;
                case 6:
                    SortingHat();
                    break;
                case 7:
                    viewSubjects();
                    break; //  I SHOULD WRITE METHODS
                case 8:
                    SubjectRegistration();
                    break; //  I SHOULD WRITE METHODS
                case 9:
                    viewTranscript();
                    break;//  I SHOULD WRITE METHODS
                case 10:
                    TeacherInfo();
                    break;//  I SHOULD WRITE METHODS
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

    public int compareTo(User o){
        Student s = (Student) o;
        return getFirstName().compareTo(o.getFirstName());
    }
    public int compareTo(Student s){
        return Double.compare(this.getGPA(), s.getGPA());
    }
    public void viewSubjects(){
        if(subjects.isEmpty()){
            System.out.println("You don't have any subjects!");
        }
        else {
            for (Subject s : subjects) {
                System.out.println(s);
            }
        }
    }

    public void setSubjectMarks(Subject subject, Mark m){
        marks.put(subject, m);

    }
    public void SubjectRegistration() throws IOException {

        if (totalCredits >= 21) {
            System.out.println("You have already reached the maximum credits. Cannot register for more subjects.");
            return;
        }

        System.out.println("Available Subjects:");
        for (Subject s : Database.subjects) {
            System.out.println(s);
        }

        System.out.print("\nEnter the code of the subject to choose: ");
        String code = reader.readLine();

        // Check if the subject exists in the database
        Subject selectedSubject = null;
        for (Subject s : Database.subjects) {
            if (s.getCode().equalsIgnoreCase(code)) {
                selectedSubject = s;
                break;
            }
        }

        if (selectedSubject == null) {
            System.out.println("Subject with code " + code + " not found in the database.");
            return;
        }

        // Check if the subject is already registered by the student
        if (subjects.contains(selectedSubject)) {
            System.out.println("You are already registered for the selected subject.");
            return;
        }

        // Check if the student has enough credits to register for the subject
        if (totalCredits + selectedSubject.getCredits() > 21) {
            System.out.println("Adding this subject will exceed the maximum credit limit.");
            return;
        }

        // Register the subject for the student
        selectedSubject.addStudent(this);
        subjects.add(selectedSubject);
        totalCredits += selectedSubject.getCredits();
        System.out.println("Subject " + selectedSubject.getTitle() + " successfully registered!");
//        System.out.println("Total credit: " + getCredits());
    }

    public int getCredits(){
        return totalCredits;
    }






    public void TeacherInfo() throws Exception {
        while(true) {
            System.out.println("1) Info about teachers");
            System.out.println("2) Rate teachers");
            System.out.println("0) Quit");

//            BufferedReader reader;
            int answer = Integer.parseInt(reader.readLine());
            switch (answer) {
                case 1:
                    System.out.println("-----Info about teachers-----");
                    for(Subject s: subjects){
                        System.out.println(s.getTeacher() + "| Subject: " + s.getTitle());
                    }
                    break;
                case 2:
                    for(Subject s: subjects){
                        System.out.println(s.getTeacher() + " | ID: " + s.getTeacherID() +" | "+ "Subject: " + s.getTitle());
                    }
                    System.out.print("Teacher's ID that you want to rate: ");
                    String ID =  reader.readLine();
                    System.out.println("Rate: 0 to 10: ");
                    double rating = Double.parseDouble(reader.readLine());
                    boolean ok = false;
                    for(Subject s : subjects){
                        if(s.getTeacherID().equals(ID)){
                            ok = true;
                            Teacher teacher = s.getTeacher();
                            teacher.setRating(rating);
                        }
                    }
                    if(ok){
                        System.out.println("Successful operation");
                    }
                    if(!ok){
                        System.out.println("Something went wrong");
                    }
                    break;
                case 0:
                    this.GreatHall();
                    break;
            }
        }
        }


    public void viewTranscript() {
        double totalGPA = 0;

        for (Subject c : marks.keySet()) {
            Mark mark = marks.get(c);

            if (mark != null) {
                System.out.print(c.getTitle() + " | " + mark.getFirstAttestation() + " | "
                        + mark.getSecondAttestation() + " | " + mark.getFinal() + " | "
                        + mark.getTotal() + " | " + mark.getLiteralMark() +
                        " | " + mark.getDigitMark() + " | " + "\n");

                totalGPA += (mark.getDigitMark() * c.getCredits()) / (c.getCredits() * marks.size());
            } else {
                System.out.println(c.getTitle() + " | N/A | N/A | N/A | N/A | N/A | N/A | N/A");
            }
        }

        System.out.println("Total GPA: " + totalGPA);
    }


    public void SortingHat() throws IOException {
        if(faculty != null){
            System.out.println("You already in " + faculty +" faculty. You cannot change your FACULTY!");
        }
        else{

            if(moodOfHat) {
                System.out.print("Alright I will choose for you faculty, But what can you say about your properties? ");
                String propertyStudent = reader.readLine();
                propertyStudent.toLowerCase();

//            searchWordInHouses(propertyStudent, Hufflepuff, Gryffindor, Ravenclaw, Slytherin);
                boolean exist = false;
                for (String w : gryffindor) {
                    if (w.equals(propertyStudent)) {
                        exist = true;
                        this.faculty = Faculty.GRYFFNDOR;
                        System.out.println("You are in GRYFFINDOR!");
                    }
                }
                for (String w : hufflepuff) {
                    if (w.equals(propertyStudent)) {
                        exist = true;
                        this.faculty = Faculty.HUFFLEPUFF;
                        System.out.println("You are in HUFFLEPUFF!");
                    }
                }
                for (String w : ravenclaw) {
                    if (w.equals(propertyStudent)) {
                        exist = true;
                        this.faculty = Faculty.RAVANCLAW;
                        System.out.println("You are in RAVANCLAW!");
                    }
                }
                for (String w : slytherin) {
                    if (w.equals(propertyStudent)) {
                        exist = true;
                        this.faculty = Faculty.SLYTHERN;
                        System.out.println("You are in SLYTHERN");
                    }
                }
                if(!exist){
                    this.faculty = Faculty.values()[new Random().nextInt(Faculty.values().length)];
                    System.out.println("You are in " + this.faculty);
                }

            }
            else{
                System.out.println("I will choose it randomly!");
                this.faculty = Faculty.values()[new Random().nextInt(Faculty.values().length)];
                System.out.println("You are in "+this.faculty);

            }

        }
    }
    private static boolean containsWordIgnoreCase(String text, String word) {
        text = text.toLowerCase();
        word = word.toLowerCase();
        String[] words = text.split("\\s*,\\s*");
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
    public void setSubjects(Subject subject){
        subjects.add(subject);
        subject.addStudent(this);
    }
    public String getFullName(){
        return (firstName + " " + secondName);
    }

    public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public void viewinfiAboutTeacher(HashMap<String, Teacher> teachers) {
        System.out.println("List of Teachers:");

        for (Teacher teacher : teachers.values()) {
            System.out.println("Name: " + teacher.getFirstName() + " " + teacher.getSecondName());
            System.out.println("Academic Degree: " + teacher.getTeacherDegree());
            System.out.println("Faculty: " + teacher.getFaculty());
            System.out.println("Rating: " + teacher.getRaring());
//            System.out.println("Lesson Type: " + teacher.getLessonType());
            System.out.println("------------------------");
        }
    }
}