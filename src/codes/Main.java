package codes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User first = new User("rustem", "temirgali", 18, "22030451", "Uki");
        User second = new User("azamat", "Tiletay", 18, "22030595", "Owl");
        Admin admin = new Admin();
        admin.addUsers(first);
        admin.addUsers(second);
        Scanner s = new Scanner(System.in);

        String firstnick = s.next();
        String firstpass = s.next();

//        String secondnick = s.next();
//        String secondpass = s.next();

        first.LogIn(firstnick, firstpass);
        for(User u : Database.users){
            System.out.println(u);
        }


    }
}
