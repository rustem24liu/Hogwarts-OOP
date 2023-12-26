package codes;

import java.io.IOException;
import java.util.HashMap;

public class Master extends GraduateStudent{
    public Master() {
    }

    public Master(String firstName, String secondName, int age, String ID, String owlName, Integer yearOfStudy, String property, String organization) {
        super(firstName, secondName, age, ID, owlName, yearOfStudy, property, organization);
    }

    public Master(String name, String lastName, int age, String id, String owl, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
    }

    public Master(String name, String lastName, int age, String id, String owl, Faculty faculty, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, faculty, nickname, regPassword);
    }

    @Override
    public double getGPA() {
        return super.getGPA();
    }

    @Override
    public void GreatHall() throws Exception {
        super.GreatHall();
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

    @Override
    public void SortingHat() throws IOException {
        super.SortingHat();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
