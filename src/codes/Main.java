package codes;

import jdk.jfr.DataAmount;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Student harry = new Student("Harry", "Potter", 11, "0", "Hedwig", "harry", "hogwartsbest");
        Student hermione = new Student("Hermione", "Granger", 11, "1", "Crookshanks", "hermi", "hermi");
        Student ron = new Student("Ron", "Weasley", 12, "2", "Scabbers", "ronny", "ronnyrocks");
        Student ginny = new Student("Ginny", "Weasley", 15, "3", "Arnold", "ginny", "ginny123");
        Student draco = new Student("Draco", "Malfoy", 14, "4", "Lucius", "draco", "malfoy");
        Student luna = new Student("Luna", "Lovegood", 13, "5", "Thestral", "luna", "radishlove");


        TheDailyProphet news1 = new TheDailyProphet("Bank", "Someone had stolen the money from the national bank!");
        TheDailyProphet news2 = new TheDailyProphet("Quidditch", "Gryffindor Wins the Quidditch Cup!");
        TheDailyProphet news3 = new TheDailyProphet("Dark Arts", "Ministry Warns of Dark Arts Activity in Diagon Alley");
        TheDailyProphet news4 = new TheDailyProphet("Magical Creatures", "New Fantastic Beasts Discovered in Forbidden Forest");

        Admin admin = new Admin();
        admin.setNickName("admin");
        admin.setPassword("admin1");

        Manager dumbledore = new Manager("Albus", "Dumbledore", 150, "M001", "Fawkes", "headmaster", "elderwand");
        Manager mcGonagall = new Manager("Minerva", "McGonagall", 70, "M002", "Tabby", "deputyhead", "transfiguration");

        admin.addUsers(harry);
        admin.addUsers(hermione);
        admin.addUsers(ron);
        admin.addUsers(ginny);
        admin.addUsers(draco);
        admin.addUsers(luna);
        admin.addUsers(dumbledore);
        admin.addUsers(mcGonagall);
        admin.addUsers(admin);

        dumbledore.addNews(news1);
        dumbledore.addNews(news2);
        mcGonagall.addNews(news3);
        mcGonagall.addNews(news4);

        admin.deleteUsers(luna);


        Menu();

        for(User u : Database.users){
            System.out.println(u);
        }
    }

    public static void Menu() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("-----WELCOME TO HOGWARTS-----" + "\n1 - LogIn\n2 - Exist\nYour choice: ");
            String answer = reader.readLine();
            boolean loggedin = false;
            if (answer.equals("1")) {
                System.out.println("\nNick Name: ");
                String nickName = reader.readLine();
                System.out.println("Password: ");
                String password = reader.readLine();

                for (User u : Database.users) {
                    if (nickName.equals(u.getNickName()) && password.equals(u.getPassword())) {
                        Database.logUserAction(u, "Log In");
                        loggedin = true;
                        System.out.println("You logged in!");
                        System.out.print("Welcome to our system " + u.getFirstName() + "(" + u.getClass() +")");
                        u.GreatHall();
                        break;
                    } else if (nickName.equals(u.getNickName()) && !password.equals(u.getPassword())) {
                        Database.logUserAction(u, "Tried to Log In");
                        System.out.println("You write your password incorrectly!, TRY AGAIN!\n");
                        String newPassword = reader.readLine();

                        if (!newPassword.equals(u.getPassword()) && nickName.equals(u.getNickName())) {
                            Database.logUserAction(u, "Tried to Log In");
                            System.out.println("You again wrote incorrectly! ");
                        } else {
                            System.out.println("You logged in!");
                            Database.logUserAction(u, "Log In");
                            loggedin = true;

                            if (u instanceof Student) {
                                Student student = (Student) u;
                                student.GreatHall();

                            } else {
                                System.out.println("who are you?");
                            }
                            break;

                        }
                    }
                }

                for (User u : Database.users) {
                    if (!loggedin && !u.getPassword().equals(password) && !u.getNickName().equals(nickName)) {
                        System.out.println("You should register!");
                        try {
                            System.out.println("You are: \n1) Employee\n2) Student\n3) Teacher\n4) Manager\n5) Admin\n0) Back to menu");
                            int ans = Integer.parseInt(reader.readLine());
                            if(ans == 0){
                                Menu();
                            }
                            System.out.print("Your name: ");
                            String name = reader.readLine();
                            System.out.print("Your last name: ");
                            String lastName = reader.readLine();
                            System.out.print("Your age: ");
                            int age = Integer.parseInt(reader.readLine());
                            System.out.print("Your ID: ");
                            String ID = reader.readLine();
                            System.out.print("Your Owl's name: ");
                            String owl = reader.readLine();
                            System.out.print("Set NickName:");
                            String nickname = reader.readLine();
                            if(Database.getUser(nickname) != null){
                                System.out.println("This user already exists!");
                                break;
                            }
                            System.out.print("Set password: ");
                            String regPassword = reader.readLine();
                            if (ans == 1) {

                            }
                            else if (ans == 2) {
                                Student newStudent = new Student(name, lastName, age, ID, owl, nickname, regPassword);
                                Database.users.add(newStudent);
                                newStudent.GreatHall();
                                loggedin = true;
                            }
                            else if (ans == 3) {

                            }
                            else if (ans == 4) {
                                Manager newManager = new Manager(name, lastName, age, ID, owl, nickname, regPassword);
                                Database.users.add(newManager);
                                newManager.GreatHall();
                                loggedin = true;
                            }
                            else if(ans == 5){
                                    Admin newAdmin = new Admin(name, lastName, age, ID, owl, nickname, regPassword);
                                    Database.users.add(newAdmin);
                                    newAdmin.GreatHall();
                                    loggedin = true;
                                }
                            Database.logUserAction(u, "Register");
                            System.out.println("User registered successfully!");
                            loggedin = true;
                        }
                        catch (IOException e) {
                            e.printStackTrace();  // Handle the exception based on your requirements
                        }
                        catch (NumberFormatException n) {
                            n.printStackTrace();
                        }
                    }
                }
            }


            else if (answer.equals("2")) {
                System.out.println("\nSystem closed");
                break;
            } else {
                System.out.println("\nIncorrect input format");
            }
            }
        }
}
