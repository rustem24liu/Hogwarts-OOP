package codes;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Vector;

public class Admin extends Employee{

    public void addUsers(User user) {
        boolean userExists = false;
        for (User u : Database.users) {
            if (user.getNickName().equals(u.getNickName())) {
                System.out.println("User already exists in the Database");
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            Database.users.add(user);
            System.out.println("User added to the Database");
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
