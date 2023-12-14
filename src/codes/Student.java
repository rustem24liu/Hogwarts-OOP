package codes;

import java.util.*;
public class Student extends User {
    private Integer yearOfStudy;
    private String property;
    private String organization;

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
//    public void getTranscript(){}
//
//    public void viewShedule(){}
//
//    public void rateTeachers(){}
//
//    public void viewinfiAboutTeacher(){}
//
//    public void viewSubject(){}
//
//    public void studentOrganizations(){}