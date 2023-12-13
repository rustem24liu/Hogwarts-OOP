package codes;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    protected static ArrayList<User> users = new ArrayList<>();
    protected static ArrayList<Student> students = new ArrayList<>();
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
    public static void addAllStudents(ArrayList<Student> newStudents) {
        users.addAll(newStudents);
    }

    public static User getUserByNickname(String nickname) {
        for (User user : users) {
            if (user.getNickName().equals(nickname)) {
                return user;
            }
        }
        return null;
    }
}
