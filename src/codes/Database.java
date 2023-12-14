package codes;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    protected static ArrayList<User> users = new ArrayList<>();
    protected static ArrayList<TheDailyProphet> news = new ArrayList<>();
    protected static ArrayList<Student> students = new ArrayList<>();
    protected static ArrayList<Student> managers = new ArrayList<>();
    protected static ArrayList<User> subjects = new ArrayList<>();

    public static User getUser(String username) {
        for (User user : users)
            if (user.getNickName().equals(username))
                return user;
        return null;
    }

    // Add this method to add new users to the existing list
    public static void addAllUsers(ArrayList<User> newUsers) {
        users.addAll(newUsers);
    }

    public static void addNews(int number,  String title , String description){
        TheDailyProphet n = new TheDailyProphet(title, description);
        news.add(n);
    }
    public static void addNews(TheDailyProphet n1) {
        news.add(n1);
    }


    public static void getNews(){
        for(TheDailyProphet news : news){
            System.out.println(news);
        }
    }


    public static void saveNews() {
    }
}
