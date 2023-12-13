package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.SQLOutput;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public String firstName;
    public String secondName;
    public int age;

    public String ID;
    private String nickName;
    private String password;
    private boolean status;
    private String owlName;
    boolean loggedin = false;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public User(){}

    public User(String firstName, String secondName, int age, String ID, String owlName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.ID = ID;
        this.owlName = owlName;
        this.nickName = "";
        this.password = "";
    }
    public User(String firstName, String secondName, int age, String ID, String owlName, String nickName, String password){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.ID = ID;
        this.owlName = owlName;
        this.nickName = nickName;
        this.password = password;
    }

    public String getNickName() {
        return nickName!=null ? nickName : "";
    }
    public String getPassword() {
        return password!=null ? password : "";
    }


    public void setPassword(String password){
        this.password = password;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }



    public void LogIn(BufferedReader reader) {
        if (this.getNickName().isEmpty() || this.getPassword().isEmpty()) {
            System.out.println(this.firstName + " you need to register!");
            Register(reader);
        } else {
            for (User u : Database.users) {
                if (u.getNickName().equals(this.getNickName()) && u.getPassword().equals(this.getPassword())) {
                    System.out.println("Success!");
                    loggedin = true;
                    return;  // Add return statement to exit the method upon successful login
                }
            }
            if(!loggedin){
                System.out.println("Incorrect!");
            }

        }
    }

    public void Register(BufferedReader reader) {
//        while(loggedin) {
            try {
                System.out.println("Enter your nickname: ");
                this.nickName = this.reader.readLine();

                System.out.println("Enter your password: ");
                this.password = this.reader.readLine();

                System.out.println("User registered successfully!");
            } catch (IOException e) {
                e.printStackTrace();  // Handle the exception based on your requirements
            }
//        }
    }

    private boolean checkLogin() {
        for (User u : Database.users) {
            if (u.getNickName().equals(this.getNickName()) && u.getPassword().equals(this.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void GreatHall() throws Exception {
            while (true) {
                System.out.println("\n\n$$===== Great Hall Menu =====$$");
                System.out.println("1) View Info");
                System.out.println("2) News");
                System.out.println("3) Make Request");
                System.out.println("4) Personal Data");
                System.out.println("5) Parcels");
                System.out.println("6) Change Password");
                System.out.println("7) Logout");
                System.out.println("8) Send Parcel");
                System.out.println("9) View Parcel");
                System.out.println("10) Change Language (enum: kz, ru, eg)");
                System.out.println("0) Exit Great Hall");

                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        viewInfo();
                        break;
                    case 2:
                        news();
                        break;
                    case 3:
                        makeRequest();
                        break;
                    case 4:
                        personalData();
                        break;
                    case 5:
                        parcels();
                        break;
                    case 6:
                        changePassword();
                        break;
                    case 7:
                        LogOut();
                        System.out.println("Logged out. Returning to the main menu.");
                        return;
                    case 8:
                        sendParcel();
                        break;
                    case 9:
                        viewParcel();
                        break;
                    case 10:
                        changeLanguage();
                        break;
                    case 0:
//                        Database.saveUsers();
                        System.out.println("Exiting Great Hall. Returning to the main menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
    }

    void viewInfo() {
        System.out.println("====================================");
        System.out.println(this.toString());
        System.out.println("====================================");

    }

    void news() {
        System.out.println("News logic placeholder.");
    }

    void makeRequest() {
        System.out.println("Make Request logic placeholder.");
    }

    void personalData() {

        System.out.println("\n\n" +
                    "Name: " + firstName + '\n' +
                    "Last Name: '" + secondName + '\n' +
                    "Age:  " + age + '\n' +
                    "ID: '" + ID + '\n' +
//                    "Status'" + status + '\n' +
                    "Owl Name='" + owlName + '\n' + "\n" +
                password
        );
        }

    void parcels() {
        System.out.println("Parcels logic placeholder.");
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
//                for(int i = 0; i < 10; ++i){
//                    System.out.print("%");
//                }
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

    void sendParcel() {
        System.out.println("Send Parcel logic placeholder.");
    }

    void viewParcel() {
        System.out.println("View Parcel logic placeholder.");
    }

    void changeLanguage() {
        System.out.println("Change Language logic placeholder.");
    }
    void LogOut(){
        System.out.println("something");
    }







    @Override
    public String toString() {
        return "\n\n" +
                "Name: " + firstName + '\n' +
                "Last Name: " + secondName + '\n' +
                "Age: " + age + '\n' +
                "ID: '" + ID + '\n' +
                "Nick Name: " + nickName + '\n' +
                "Password: " + password + '\n' +
                "Status: " + status + '\n' +
                "Owl Name: " + owlName + '\n';
    }
}
