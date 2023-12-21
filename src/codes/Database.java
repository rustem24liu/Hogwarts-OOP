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
    protected static ArrayList<User> subjects = new ArrayList<>();


    
    public static User getUser(String nickname){
        for(User u : users){
            if(u.getNickName().equals(nickname)){
                return u;
            }
        }
        return null;
    }
    public static Student getStudent(String nickname){
        for(Student s : students){
            if(s.getNickName().equals(nickname)){
                return s;
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
