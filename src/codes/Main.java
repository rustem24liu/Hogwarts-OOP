package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Rustem", "Temirgali", 18, "22B030451", "Owl", "liu_rus", "eWN)c_zn)");

        Admin admin1 = new Admin();
        admin1.addUsers(student1);

        Menu();



//        student1.LogIn();
//        admin1.addUsers(student1);
//
        for(User u : Database.users){
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
            if (answer.equals("1")) {
                boolean loggedin = false;
                System.out.println("\nNick Name: ");
                String nickName = reader.readLine();
                System.out.println("Password: ");
                String password = reader.readLine();
                for (User u : Database.users) {
                    if (nickName.equals(u.getNickName()) && password.equals(u.getPassword())) {
                        loggedin = true;
                        System.out.println("You logged in!");

                        if (u instanceof Student) {
                            Student student = (Student) u;
                            student.GreatHall();
                        } else {
                            System.out.println("who the fuck are you?");
                        }

                        return;
                    } else if (nickName.equals(u.getNickName()) && !password.equals(u.getPassword())) {
                        System.out.println("You write your password incorrectly!, TRY AGAIN!\n");
                        String newPassword = reader.readLine();
                        while (!newPassword.equals(u.getPassword()) && nickName.equals(u.getNickName())) {
                            System.out.println("You write your password incorrectly!, TRY AGAIN!\n");
//                            loggedin = true;
                            newPassword = reader.readLine();
                            if (newPassword.equals(u.getPassword())) {
                                loggedin = true;
                                System.out.println("You logged in!");
//                                break;
                            }
                        }
                    }
                }



                if (!loggedin) {
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

                                User newUser = new User(name, lastName, age, ID, owl, nickname, regPassword);
                                newUsers.add(newUser);
                                if(ans == 1){

                                }
                                else if(ans== 2){
                                    Student newStudent = new Student(name, lastName, age, ID, owl, nickname, regPassword);
                                    newStudents.add(newStudent);
                                    newStudent.GreatHall();
                                }
                                else if(ans == 3){

                                }
                                else if(ans == 4){

                                }
//                                else if(ans == 5){
//
//                                }

                                System.out.println("User registered successfully!");
                                loggedin = true;
                            } catch (IOException e) {
                                e.printStackTrace();  // Handle the exception based on your requirements
                            } catch (NumberFormatException n) {
                                n.printStackTrace();
                            }
                        }
                    }


                else if (answer.equals("2")) {
                        System.out.println("\nSystem closed");
                        break;
                    } else {
                        System.out.println("\nIncorrect input format");
                    }

                    // Add the new users to the existing list
                    Database.addAllUsers(newUsers);
//                    Database.addAllStudents(newStudents);

            }
        }}
