package codes;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

public class CareTaker extends Employee{
    public CareTaker() {
    }

    public CareTaker(String firstName, String secondName, int age, String ID, String owlName) {
        super(firstName, secondName, age, ID, owlName);
    }

    public CareTaker(String firstName, String secondName, int age, String ID, String owlName, String nickname, String password) {
        super(firstName, secondName, age, ID, owlName, nickname, password);
    }

    @Override
    public void GreatHall() throws Exception {
        try {
            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Salary");
                System.out.println("3) Change Password");
                System.out.println("4) Parcels(Messages)");
                System.out.println("5) Black list");
                System.out.println("0) Logout");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        news();
                        Database.logUserAction(this, "Viewed news");
                        break;
                    case 2:
                        System.out.print("Amount of salary is: ");
                        getSalary();
                        System.out.println("");
                        Database.logUserAction(this, "Salary option");
                        break;
                    case 3:
                        changePassword();
                        Database.logUserAction(this, "Changed password");
                        break;
                    case 4:
                        Messages();
                        Database.logUserAction(this, "Message");
                        break;
                    case 5:
                        blackList();
                        break;
                    case 0:
                        LogOut();
                        Database.logUserAction(this, "Logged out");
                        System.out.println("Logged out. Returning to the main menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
        catch (Exception n){
            n.printStackTrace();
        }
    }
    public void blackList() throws IOException {
        try{


        boolean ok = true;
        while (ok) {
            System.out.println("1) View Black List");
            System.out.println("2) Add to Black List");
            System.out.println("0) Quit");
            int ans = Integer.parseInt(reader.readLine());
            switch (ans) {
                case 1:
                    Database.getBlackList();
                    break;
                case 2:
                    Database.getStudents();
                    System.out.print("Student ID: ");
                    String id = reader.readLine();

                    Student student = Database.getStudent(id);
//                    System.out.println(student);
                    System.out.print("Cause of adding to black list: ");
                    String cause = reader.readLine();

                    BlackList blackList = new BlackList(student, cause);
                    Database.blackList.add(blackList);
                    break;
                case 0:
                    ok = false;
                    break;
            }
        }
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }


    @Override
    public String toString() {
        return "CareTaker{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", ID='" + ID + '\'' +
                ", loggedin=" + loggedin +
                '}';
    }
}
