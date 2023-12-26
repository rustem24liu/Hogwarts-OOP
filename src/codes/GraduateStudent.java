package codes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class GraduateStudent extends Student implements Researcher {
    boolean supervisor = false;
    private ArrayList<ResearchPaper> researchPapers = new ArrayList<>();
    public GraduateStudent() {
    }

    public GraduateStudent(String firstName, String secondName, int age, String ID, String owlName, Integer yearOfStudy, String property, String organization) {
        super(firstName, secondName, age, ID, owlName, yearOfStudy, property, organization);
    }

    public GraduateStudent(String name, String lastName, int age, String id, String owl, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
    }

    public GraduateStudent(String name, String lastName, int age, String id, String owl, Faculty faculty, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, faculty, nickname, regPassword);
    }

    @Override
    public double getGPA() {
        return super.getGPA();
    }

    @Override
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
            System.out.println("6) View my subjects info");
            System.out.println("7) Subject registration");
            System.out.println("8) View Transcript");
            System.out.println("9) Teachers rate/info");
            System.out.println("10) Research");
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
                    viewSubjects();
                    break; //  I SHOULD WRITE METHODS
                case 7:
                    SubjectRegistration();
                    break; //  I SHOULD WRITE METHODS
                case 8:
                    viewTranscript();
                    break;//  I SHOULD WRITE METHODS
                case 9:
                    TeacherInfo();
                    break;//  I SHOULD WRITE METHODS
                case 10:
                    writeResearch();
                    break;
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

    @Override
    public int compareTo(User o) {
        return super.compareTo(o);
    }

    @Override
    public int compareTo(Student s) {
        return super.compareTo(s);
    }

    @Override
    public void viewSubjects() {
        super.viewSubjects();
    }

    @Override
    public void setSubjectMarks(Subject subject, Mark m) {
        super.setSubjectMarks(subject, m);
    }

    @Override
    public void SubjectRegistration() throws IOException {
        super.SubjectRegistration();
    }

    @Override
    public int getCredits() {
        return super.getCredits();
    }

    @Override
    public void TeacherInfo() throws Exception {
        super.TeacherInfo();
    }

    @Override
    public void viewTranscript() {
        super.viewTranscript();
    }

    @Override
    public void setSubjects(Subject subject) {
        super.setSubjects(subject);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public Integer getYearOfStudy() {
        return super.getYearOfStudy();
    }

    @Override
    public void setYearOfStudy(Integer yearOfStudy) {
        super.setYearOfStudy(yearOfStudy);
    }

    @Override
    public String getProperty() {
        return super.getProperty();
    }

    @Override
    public void setProperty(String property) {
        super.setProperty(property);
    }

    @Override
    public String getOrganization() {
        return super.getOrganization();
    }

    @Override
    public void setOrganization(String organization) {
        super.setOrganization(organization);
    }

    @Override
    public void viewinfiAboutTeacher(HashMap<String, Teacher> teachers) {
        super.viewinfiAboutTeacher(teachers);
    }

    @Override
    public boolean getStatus() {
        return super.getStatus();
    }

    @Override
    public String getNickName() {
        return super.getNickName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getSecondName() {
        return super.getSecondName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    @Override
    public String getOwlName() {
        return super.getOwlName();
    }

    @Override
    public boolean isLoggedin() {
        return super.isLoggedin();
    }

    @Override
    public boolean isIslogged() {
        return super.isIslogged();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setNickName(String nickName) {
        super.setNickName(nickName);
    }

    @Override
    void news() {
        super.news();
    }

    @Override
    void makeRequest() throws IOException {
        super.makeRequest();
    }

    @Override
    void personalData() {
        super.personalData();
    }

    @Override
    void changePassword() throws IOException {
        super.changePassword();
    }

    @Override
    void Messages() throws Exception {
        super.Messages();
    }

    @Override
    void viewMessage() throws IOException {
        super.viewMessage();
    }

    @Override
    void sendMessage() throws IOException {
        super.sendMessage();
    }

    @Override
    void receiveMessage(Message message) {
        super.receiveMessage(message);
    }

    @Override
    void LogOut() throws Exception {
        super.LogOut();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

// main part
CitationComparator citationComparator = new CitationComparator();

    @Override
    public void writeResearch() throws IOException {
        boolean ok = true;
        while(ok){
            System.out.println("1) Print Papers");
            System.out.println("2) Write Papers");
            System.out.println("3) H-index");
            System.out.println("0) QUIT");
            int ans = Integer.parseInt(reader.readLine());
            switch (ans){
                case 1:
                    printPapers(citationComparator);
                    break;
                case 2:
                    System.out.print("Title of the paper: ");
                    String name = reader.readLine();
                    System.out.print("Descriptions: ");
                    String description = reader.readLine();
                    System.out.print("More Detail: ");
                    String pages = reader.readLine();
                    System.out.print("Number of citations: ");
                    int citations = Integer.parseInt(reader.readLine());

                    ResearchPaper researchPaper = new ResearchPaper(this, name, description, pages, citations);
                    researchPapers.add(researchPaper);
                    break;
                case 3:
                    int hIndexx = hIndex();
                    System.out.print("Your H-Index is: ");
                    System.out.println(hIndexx);
                    if(hIndexx > 3){
                        System.out.println("You are supervisor");
                        supervisor = true;
                    }
                    break;
                case 0:
                    ok = false;
                    break;
            }
        }
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        if (researchPapers.isEmpty()) {
            System.out.println("Research Papers is empty!");
        } else {
            // Sort the research papers using the provided comparator
            researchPapers.sort(comparator);

            // Print the sorted research papers
            for (ResearchPaper researchPaper : researchPapers) {
                System.out.println(researchPaper);
            }
        }
    }


    @Override
    public int hIndex() {

        researchPapers.sort(new CitationComparator());

        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {

            int citations = researchPapers.get(i).getCitation();
//            System.out.println(i + " - " + citations);
            if (citations >= i + 1) {
                hIndex = i + 1;
            }
//            else{
//                break;
//            }
        }

        return hIndex;
    }
}
