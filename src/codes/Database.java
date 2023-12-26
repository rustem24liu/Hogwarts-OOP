package codes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Database implements Serializable {
    protected static ArrayList<User> users = new ArrayList<>();
    protected static ArrayList<String> userActionsLog = new ArrayList<>();
    protected static ArrayList<String> requests = new ArrayList<>();
    protected static ArrayList<TheDailyProphet> news = new ArrayList<>();
//    protected static ArrayList<Message> messages = new ArrayList<>();
    protected static ArrayList<Student> students = new ArrayList<>();
    protected static ArrayList<Manager> managers = new ArrayList<>();
    protected static ArrayList<Subject> subjects = new ArrayList<>();
    protected static ArrayList<Complaint> complaints = new ArrayList<>();
    protected static ArrayList<Teacher> teachers = new ArrayList<>();
    protected static ArrayList<BlackList> blackList = new ArrayList<>();
    public static void getBlackList(){
        try {


            if (blackList.isEmpty()) {
                System.out.println("No students in Black List");
            } else {
                for (BlackList b : blackList) {
                    System.out.println(b);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public static ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public static void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public static void getTeacher(){
        System.out.println("----------Teachers----------");
        for(User u: users){
            if(u instanceof Teacher){
                Teacher teacher = (Teacher) u;
                System.out.println(teacher);
            }
        }
    }
    public static ArrayList<Student> getStudentsOrderByName() {
        ArrayList<Student> s = new ArrayList<>();
        for (User user: users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                s.add(student);
            }
        }
        s.sort(new SortStudentByName());
        return s;
    }

    public static ArrayList<Student> getStudentsOrderByGPA() {
        ArrayList<Student> s = new ArrayList<>();
        for (User user: users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                s.add(student);
            }
        }
        s.sort(new SortStudentByGPA());
        return s;
    }
    public static void getStudents(){
        System.out.println("----------Students----------");
        for(User u: users ){
            if(u instanceof Student){
                Student student = (Student) u;
                System.out.println(student);
            }
        }
    }

    
    public static User getUser(String nickname){
        for(User u : users){
            if(u.getNickName().equals(nickname)){
                return u;
            }
        }
        return null;
    }
    public static Student getStudent(String ID){
        for(User user: users){
            if(user instanceof Student){
                Student student = (Student) user;
                if(student.getID().equals(ID)){
                    return student;
                }
            }
        }
        return null;
    }
    public static void logUserAction(User user, String action) {
        String logEntry = new Date() + " - User: " + user.getNickName() + " - Action: " + action;
        userActionsLog.add(logEntry);
        System.out.println("Action logged: " + logEntry);
    }
    public static void getNews(){
        for(TheDailyProphet news : news){
            System.out.println(news);
        }
    }

    public static boolean getNewsByTitle(String title){
        for(TheDailyProphet theDailyProphet : news){
            if(theDailyProphet.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

}
