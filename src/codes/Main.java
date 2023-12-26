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

        Student harry = new Student("Harry", "Potter", 11, "0", "Hedwig", Faculty.GRYFFNDOR, "harry", "hogwartsbest");
        Student hermione = new Student("Hermione", "Granger", 11, "1", "Crookshanks", Faculty.GRYFFNDOR,  "hermi", "hermi");
        Student ron = new Student("Ron", "Weasley", 12, "2", "Scabbers",Faculty.GRYFFNDOR,  "ronny", "ronnyrocks");
        Student ginny = new Student("Ginny", "Weasley", 15, "3", "Arnold", Faculty.GRYFFNDOR, "ginny", "ginny123");
        Student draco = new Student("Draco", "Malfoy", 14, "4", "Lucius", Faculty.SLYTHERN ,"draco", "malfoy");
        Student luna = new Student("Luna", "Lovegood", 13, "5", "Thestral", Faculty.RAVANCLAW, "luna", "radishlove");


        TheDailyProphet news1 = new TheDailyProphet("Bank", "Someone had stolen the money from the national bank!");
        TheDailyProphet news2 = new TheDailyProphet("Quidditch", "Gryffindor Wins the Quidditch Cup!");
        TheDailyProphet news3 = new TheDailyProphet("Dark Arts", "Ministry Warns of Dark Arts Activity in Diagon Alley");
        TheDailyProphet news4 = new TheDailyProphet("Magical Creatures", "New Fantastic Beasts Discovered in Forbidden Forest");

        Admin admin = new Admin();
        admin.setNickName("admin");
        admin.setPassword("admin1");

        Manager dumbledore = new Manager("Albus", "Dumbledore", 150, "M001", "Fawkes", "headmaster", "elderwand");
//        Manager mcGonagall = new Manager("Minerva", "McGonagall", 70, "M002", "Tabby", "deputyhead", "transfiguration");

        Teacher teacher1 = new Teacher("Severus", "Snape", 38, "SN123", "Potter", TeacherDegree.MASTER, "snape", "password1");
        teacher1.setRating(9.5);
        Teacher teacher2 = new Teacher("Minerva", "McGonagall", 45, "MM789", "Gryffindor", TeacherDegree.DOCTOR, "mcgonagall", "password2");
        teacher2.setRating(10.0);
        Teacher teacher3 = new Teacher("Filius", "Flitwick", 63, "FF456", "Ravenclaw", TeacherDegree.BACHELOR, "flitwick", "pasord3");
        teacher3.setRating(8.8);


        Subject potionSubject = new Subject("POT101", "Potions", 4, teacher1, 100);
        Subject darkArtsSubject = new Subject("DAR102", "Defense Against the Dark Arts", 5, teacher1, 40);
        teacher1.setSubjects(potionSubject);
        teacher1.setSubjects(darkArtsSubject);

// Creating subjects for Teacher 2 (Minerva McGonagall)
        Subject transfigurationSubject = new Subject("TRA201", "Transfiguration", 4, teacher2, 30);
        Subject charmsSubject = new Subject("CHA202", "Charms", 5, teacher2, 20);
        teacher2.setSubjects(transfigurationSubject);
        teacher2.setSubjects(charmsSubject);

// Creating subjects for Teacher 3 (Filius Flitwick)
        Subject charmsSubject2 = new Subject("CHA301", "Charms II", 4, teacher3, 20);
        Subject flyingSubject = new Subject("FLY302", "Flying", 3, teacher3, 15);

        teacher3.setSubjects(charmsSubject2);
        teacher3.setSubjects(flyingSubject);

        Dean d = new Dean();

        d.setNickName("Dean");
        d.setPassword("dean1");
        admin.addUsers(d);

        // Adding subjects to Database.subjects
        Database.subjects.add(potionSubject);
        Database.subjects.add(darkArtsSubject);
        Database.subjects.add(transfigurationSubject);
        Database.subjects.add(charmsSubject);
        Database.subjects.add(charmsSubject2);
        Database.subjects.add(flyingSubject);

        admin.addUsers(harry);
        admin.addUsers(hermione);
        admin.addUsers(ron);
        admin.addUsers(ginny);
        admin.addUsers(draco);
        admin.addUsers(luna);
        admin.addUsers(dumbledore);
//        admin.addUsers(mcGonagall);
        admin.addUsers(admin);
        admin.addUsers(teacher1);
        admin.addUsers(teacher2);
        admin.addUsers(teacher3);

        dumbledore.addNews(news1);
        dumbledore.addNews(news2);
        dumbledore.addNews(news3);
        dumbledore.addNews(news4);

        admin.deleteUsers(luna);

//        harry.setSubjects(transfigurationSubject);
//        System.out.println(teacher1.viewStudents(transfigurationSubject));
        draco.setSubjects(charmsSubject);
        draco.setSubjects(transfigurationSubject);
        draco.setSubjects(potionSubject);

        teacher1.putMark(potionSubject, TypeOfMark.FIRST_ATTESTATION,10, draco);

        teacher1.putMark(potionSubject, TypeOfMark.SECOND_ATTESTATION,10, draco);

        teacher1.putMark(potionSubject, TypeOfMark.FINAL,10, draco);

        teacher2.putMark(charmsSubject, TypeOfMark.FIRST_ATTESTATION,10, draco);

        teacher2.putMark(charmsSubject, TypeOfMark.SECOND_ATTESTATION,10, draco);

        teacher2.putMark(charmsSubject, TypeOfMark.FINAL,10, draco);

//        teacher2.putMark(charmsSubject2, TypeOfMark.FIRST_ATTESTATION,10, draco);
//
//        teacher2.putMark(charmsSubject2, TypeOfMark.SECOND_ATTESTATION,10, draco);
//
//        teacher2.putMark(charmsSubject2, TypeOfMark.FINAL, 15, draco);








        Menu();

        for(User u : Database.users){
            System.out.println(u);
        }
    }

    public static void Menu() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\n-----WELCOME TO HOGWARTS-----" + "\n1 - LogIn\n2 - Exist\nYour choice: ");
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