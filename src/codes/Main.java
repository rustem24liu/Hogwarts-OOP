package codes;

import jdk.jfr.DataAmount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Rustem", "Temirgali", 18, "22B030451", "Owl", "liu_rus", "ew");

        Student student2 = new Student("Azamat", "li", 48, "B030451", "Owl", "aza", "aza");
//
        Manager manager1 = new Manager("Hagrid", "Rus", 99, "51e", "Owef", "ewew", "ew1");

        TheDailyProphet n1 = new TheDailyProphet("Bank", "someone had stole the money from national bank!");

        Admin admin = new Admin();
//        admin.addUsers(student1);
//        manager1.addNews(n1);
//
//        admin.addUsers(student2);
//        admin.addUsers(manager1);

        Menu();

        for(User u: Database.users){
            System.out.println(u);
        }




    }

    public static void Menu() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<User> newUsers = new ArrayList<>();
        ArrayList<Student> newStudents = new ArrayList<>();
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
                    loggedin = true;
                    System.out.println("You logged in!");

                    System.out.println("Class of u: " + u.getClass());
                    u.GreatHall();
                    break;

            } else if (nickName.equals(u.getNickName()) && !password.equals(u.getPassword())) {
                        System.out.println("You write your password incorrectly!, TRY AGAIN!\n");
                        String newPassword = reader.readLine();

                        if (!newPassword.equals(u.getPassword()) && nickName.equals(u.getNickName())) {
                            System.out.println("You again wrote incorrectly! ");
                        } else {
                            System.out.println("You logged in!");
                            loggedin = true;

                            if (u instanceof Student) {
                                Student student = (Student) u;
                                student.GreatHall();
                            } else {
                                System.out.println("who the fuck are you?");
                            }
                            break;

                        }
                    }
                }

                for (User u : Database.users) {


                    if (!loggedin && !u.getPassword().equals(password) && !u.getNickName().equals(nickName)) {
                        System.out.println("You should register!");
                        try {
                            System.out.println("You are: \n1) Employee\n2) Student\n3) Teacher\n4) Manager\n5) Admin\n");
                            int ans = Integer.parseInt(reader.readLine());
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
                            System.out.print("Set password: ");
                            String regPassword = reader.readLine();

//                            User newUser = new User(name, lastName, age, ID, owl, nickname, regPassword);
//                            newUsers.add(newUser);
                            if (ans == 1) {

                            } else if (ans == 2) {
                                Student newStudent = new Student(name, lastName, age, ID, owl, nickname, regPassword);
                                newUsers.add(newStudent);
                                newStudent.GreatHall();
                                loggedin = true;
                            } else if (ans == 3) {

                            } else if (ans == 4) {
                                Manager newManager = new Manager(name, lastName, age, ID, owl, nickname, regPassword);

                                // Check if the nickname or password already exists
                                for (User existingUser : Database.users) {
                                    if (existingUser.getNickName().equals(nickname) || existingUser.getPassword().equals(regPassword)) {
                                        System.out.println("Nickname or password already exists. Choose a different one.");
                                        // Handle accordingly, maybe break out of the registration process or ask for new input.
                                        return;
                                    }
                                }

                                newUsers.add(newManager);
                                newManager.GreatHall();
                                loggedin = true;
                            }
                                else if(ans == 5){
                                    Admin newAdmin = new Admin();
                                    newUsers.add(newAdmin);
                                    newAdmin.GreatHall();
                                    loggedin = true;
                                }

                            System.out.println("User registered successfully!");
                            loggedin = true;
                        } catch (IOException e) {
                            e.printStackTrace();  // Handle the exception based on your requirements
                        } catch (NumberFormatException n) {
                            n.printStackTrace();
                        }
                    }
                }
            }


                else if (answer.equals("2")) {
//                for(User u : Database.users){
//                    System.out.println(u);
//                }
                        System.out.println("\nSystem closed");
                        break;
                    } else {
                        System.out.println("\nIncorrect input format");
                    }

//                    Database.addAllUsers(newUsers);

            }
        }
}
