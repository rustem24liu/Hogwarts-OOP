package codes;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        User first = new User("rustem", "temirgali", 18, "22030451", "Uki");
        User second = new User("azamat", "Tiletay", 18, "22030595", "Owl");
        Admin admin = new Admin();

        Scanner s = new Scanner(System.in);
        first.LogIn();

//        first.Register();
        admin.addUsers(first);

//        admin.addUsers(second);

        first.Register();
//        second.LogIn();

        for(User user : Database.users){
            System.out.println(user);
        }


        first.GreatHall();
        Database.saveUsers();


    }
}
