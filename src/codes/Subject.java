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

    public Subject(){

    }

    public Subject(String code, String title, int credits, Teacher teacher){
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.teacher = teacher;
    }

//    private HashSet<CourseFiles> courseFiles = new HashSet<>();
    private HashSet<Subject> prerequisites = new HashSet<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private HashMap<Student, Mark> marks = new HashMap<>();
//    private ArrayList<Lesson> lessons = new ArrayList<>();
    /**
     * @generated
     */
    public String getCode() {
        return code;
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

//    public void setStudents(Student s) {
//        students.add(s);
//        Mark m = new Mark();
//        m.setStudent(s);
//        marks.put(s, m);
//    }

    public ArrayList<Student> getStudents() {
        return students;
    }

//    public void setLessons(Lesson l) {
//        lessons.add(l);
//    }
//
//    public ArrayList<Lesson> getLessons(){
//        return lessons;
//    }
//
//    public void putMark(Student student, double points, Grade grade) {
//        try {
//            Mark mark = marks.get(student);
//            mark.putMark(grade, points);
//            System.out.println("Successful operation");
//        } catch(Exception e) {
//            System.out.println("Unsuccessful operation: This student is not " +
//                    "registered in this course.");
//        }
//
//    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Mark getMarkOfStudent(Student student){
        return marks.get(student);
    }

    public HashMap<Student, Mark> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<Student, Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Course: " + "code = '" + code + '\'' +
                ", title = '" + title + '\'' +
                ", credits = " + credits +
                ", teacher = " + teacher;
    }



}
