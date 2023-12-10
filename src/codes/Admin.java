package codes;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Vector;

public class Admin extends Employee{

    public void addUsers(User user) {
        try {
            for (User u : Database.users) {
                if (user.getNickName().equals(u.getNickName())) {
                    System.out.println("You are in the DataBase");
                }
            }
        } catch (NullPointerException n) {
            Database.users.add(user);
        }
    }



//    public static void checkUser(User user){
//        for(User u: Database.users){
//            if(u.getNickName().equals(user.getNickName())){
//                System.out.println("");
//
//            }
//        }
//    }



}
