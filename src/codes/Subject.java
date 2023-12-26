package codes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Subject implements Serializable {
    private String code;
    private String title;
    private int credits;
    private int limitOfStudents;
    private Teacher teacher;
    private Faculty faculty;

    private HashSet<Subject> prerequisites = new HashSet<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private HashMap<Student, Mark> marks = new HashMap<>();

    public Subject(String code, String title, int credits, Teacher teacher, int limitOfStudents) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.teacher = teacher;
        this.limitOfStudents = limitOfStudents;
    }

    public String getCode() {
        return code;
    }

    public void setStudent(Student student){
        students.add(student);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public String getTeacherID(){
        return teacher.ID;
    }




    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getLimitOfStudents() {
        return limitOfStudents;
    }

    public void setLimitOfStudents(int limitOfStudents) {
        this.limitOfStudents = limitOfStudents;
    }

    public void setPrerequisites(Subject s) {
        prerequisites.add(s);
    }

    public HashSet<Subject> getPrerequisites() {
        return prerequisites;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
//    public void getTitle(){
//        return title;
//    }

    public void addStudent(Student student) {
        if (students.size() < limitOfStudents) {
            students.add(student);
            Mark m = new Mark();
            m.setStudent(student);
            marks.put(student, m);
        } else {
            System.out.println("Course is full. Cannot add more students.");
        }
    }

    public void putMark(Student student, double points, TypeOfMark typeOfMark){
        try {
            Mark mark = marks.get(student);
            mark.putMark(typeOfMark, points);
            System.out.println("Successful!");
        }
        catch (Exception e){
            System.out.println("Unsuccessful operation");
        }
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Mark getMarkOfStudent(Student student) {
        return marks.get(student);
    }

    public HashMap<Student, Mark> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Subject: " + "code = '" + code + '\'' +
                ", title = '" + title + '\'' +
                ", credits = " + credits +
                ", teacher = " + teacher;
    }
}
