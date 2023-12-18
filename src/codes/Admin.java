package codes;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Admin extends Employee{

    Admin(){
        super();
    }
    Admin(String name, String secondname, int age, String ID, String owl , String nickname, String password){
        super(name, secondname, age, ID, owl, nickname, password);
    }



    public void GreatHall() throws Exception {
        while (true) {
            System.out.println("\n$$===== Great Hall Menu =====$$");
            System.out.println("1) News");
            System.out.println("2) Change Password");
            System.out.println("3) Send Parcel");
            System.out.println("4) View Parcel");
            System.out.println("5) Manage users");
            System.out.println("6) See log files") ;
            System.out.println("7) Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    news();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    sendParcel();
                    break;
                case 4:
                    viewParcel();
                    break;
                case 5:
                    ManageUsers();
                    break;
                case 6:
                    viewAction();
                    break;
                case 7:
                    LogOut();
                    System.out.println("Logged out. Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }


    void news() {
        System.out.println("$            =====News=====         $");
        Database.getNews();
        System.out.println("$            ==============         $");
    }

    void changePassword() throws IOException {
        try {


            System.out.println("Enter your current password: ");
            String currentPassword = reader.readLine();
            if (currentPassword.equals(this.getPassword())) {
                System.out.print("Enter your new password: ");
                String newPassword = reader.readLine();

                System.out.print("Confirm your new password: ");
                String conPassword = reader.readLine();

                if(conPassword.equals(newPassword)) {
                    System.out.print("Changing password %-%-%-%-%-%-%-%-%-%-%-%-%");

                    this.setPassword(newPassword);

                    updatePasswordInDatabase(newPassword);

                    System.out.println("\nPassword changed successfully!");

                } else {
                    System.out.println("New passwords do not match. Please try again.");
                }
            } else {
                System.out.println("Incorrect current password. Password change failed.");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void updatePasswordInDatabase(String newPassword) {
        for (User u : Database.users) {
            if (u.getNickName().equals(this.getNickName())) {
                u.setPassword(newPassword);
                break;
            }
        }
    }
    private void viewAction(){
        if(Database.userActionsLog.isEmpty() || Database.userActionsLog == null){
            System.out.println("There is no action yet");
        }
        else{
            for(String s: Database.userActionsLog){
                System.out.println(s);
            }
        }
    }
    void sendParcel() {
        System.out.println("Send Parcel logic placeholder.");
    }

    void viewParcel() {
        System.out.println("View Parcel logic placeholder.");
    }
    void LogOut() throws Exception {
        Main.Menu();
    }

    public void ManageUsers() throws Exception{
        while(true){
            System.out.println("1) Create new User");
            System.out.println("2) Add User");
            System.out.println("3) Delete User");
            System.out.println("4) View all Users");
            System.out.println("0) Exit to main menu");
            System.out.print("Your choice: ");

            int ans = Integer.parseInt(reader.readLine());

            switch (ans){
                case 1:
                    System.out.println("You are: \n1) Employee\n2) Student\n3) Teacher\n4) Manager\n5) Admin\n0) Back to menu");
                    int answer = Integer.parseInt(reader.readLine());
                    if(answer == 0){
                        this.GreatHall();
                    }
                    System.out.print("User name: ");
                    String name = reader.readLine();
                    System.out.print("User last name: ");
                    String lastName = reader.readLine();
                    System.out.print("User age: ");
                    int age = Integer.parseInt(reader.readLine());
                    System.out.print("User ID: ");
                    String ID = reader.readLine();
                    System.out.print("User Owl's name: ");
                    String owl = reader.readLine();
                    System.out.print("Set NickName:");
                    String nickname = reader.readLine();
                    if(Database.getUser(nickname) != null){
                        System.out.println("This nickname already exists");
                        break;
                    }
                    System.out.print("Set password: ");
                    String regPassword = reader.readLine();

                    if (answer == 1) {

                    }
                    else if (answer == 2) {
                        Student newStudent = new Student(name, lastName, age, ID, owl, nickname, regPassword);
                        Database.users.add(newStudent);
                    }
                    else if (answer == 3) {

                    }
                    else if (answer == 4) {
                        Manager newManager = new Manager(name, lastName, age, ID, owl, nickname, regPassword);
                        Database.users.add(newManager);
//                        newManager.loggedin = true;
                    }
                    else if(ans == 5){
                        Admin newAdmin = new Admin();
//                        newAdmin.loggedin = true;
                    }
                    System.out.println("User registered successfully!");
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("Name of the User that you want to delete: ");
                    String ID_1 = reader.readLine();
                    deleteUsers(ID_1);
                    break;
                case 4:
                    System.out.println("All list of Users: ");
                    for(User u : Database.users){
                        System.out.println(u);
                    }
                    break;
                case 0:
                    Main.Menu();
                    break;
            }
        }
    }

    public void addUsers(User user) {
        if(Database.users == null){
            Database.users = new ArrayList<>();
        }
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

    public void deleteUsers(User user) {
        if (Database.users == null || Database.users.isEmpty()) {
            System.out.println("Database is empty!");
            return;
        }

        boolean userFound = false;

        for (User u : Database.users) {
            if (user.getNickName().equals(u.getNickName())) {
                Database.users.remove(user);
                userFound = true;
                System.out.println("User deleted!");
                break;
            }
        }

        if (!userFound) {
            System.out.println("There is no user with this nickname!");
        }
    }

    public static void deleteUsers(String ID){
        if(Database.users == null){
            System.out.println("Database is empty!");
        }
        boolean notuser = false;
        for(User u : Database.users){
            if(u.getID().equals(ID)){
                Database.users.remove(u);
                notuser = true;
                System.out.println("User deleted!");
                break;
            }
        }
        if(!notuser){
            System.out.println("There is no such user!");
        }
    }
    public void updateUsers(String ownfirstname, String newfirstname){
        for(User u : Database.users){
            if(u.getFirstName().equals(ownfirstname)){
                u.firstName = newfirstname;
                System.out.println("User's name changed from " + ownfirstname + " to " + newfirstname);
            }
            else{
                System.out.println("User not found!");
            }
        }
    }
    public void updateUsers(String ownfirstname, String newfirstname, String ownsecondname, String newsecondname){
        for(User u : Database.users){
            if(u.getFirstName().equals(ownfirstname) && u.getSecondName().equals(ownsecondname)){
                u.firstName = newfirstname;
                u.secondName = newsecondname;
                System.out.println("User's name changed from " + ownfirstname + " " + ownsecondname + " to " + newfirstname + " " + newsecondname);
            }
            else{
                System.out.println("User not found!");
            }
        }
    }


   public String toString(){
        return "Admin: "+ super.toString();
   }




}