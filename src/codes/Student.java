package codes;

import java.io.IOException;
import java.util.*;
public class Student extends User {
    private Integer yearOfStudy;
    private String property;
    private String organization;
    private Integer totalCredits;
    private Faculty faculty;
    private boolean moodOfHat = new Random().nextBoolean();
    private HashMap<Subject, Mark> marks = new HashMap<>();
    private ArrayList<Subject> subjects = new ArrayList<>();

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

    public void GreatHall() throws Exception {
        while (true) {
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
                    break; //  I SHOULD WRITE METHODS
                case 8:
                    break; //  I SHOULD WRITE METHODS
                case 9:
                    break;//  I SHOULD WRITE METHODS
                case 10:
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
                        System.out.println("You are inGryffndor!");
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
            System.out.println("Lesson Type: " + teacher.getLessonType());
            System.out.println("------------------------");
        }
    }
}