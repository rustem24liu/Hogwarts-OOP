package codes;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Teacher extends User {
    private TeacherDegree teacherDegree;

    private Faculty faculty;

    private Double rating;

    private Subjects LessonType;


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

    public void setRaring(Double raring) {
        this.rating = raring;
    }

    public Subjects getLessonType() {
        return LessonType;
    }

//    public void setLessonType(Subject lessonType) {
//        LessonType = lessonType;
//    }

    public Teacher() {};

    public Teacher (String firstName, String secondName, int age, String ID, String owlName, TeacherDegree teacherDegree) {
        super(firstName, secondName, age, ID, owlName);
        this.teacherDegree = teacherDegree;

    }

    private HashMap<Student, HashMap<Course, Grade>> studentGrades = new HashMap<>();

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



    public void PutMarks(Student student, Course course, Grade grade) {
        System.out.println("Evaluating " + student.getFirstName() + " " + student.getSecondName() +
                " for the course " + Subjects.ASTRONOMY + ": " + grade);

        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);
    }

    public HashMap<Student, HashMap<Course, Grade>> getStudentGrades() {
        return studentGrades;
    }




}