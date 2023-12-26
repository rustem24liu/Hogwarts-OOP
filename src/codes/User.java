package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {
    //    private static final long serialVersionUID = 1L;
    public String firstName;
    public String secondName;
    public int age;
    public String ID;
    private String nickName;
    private String password;
    private boolean status;
    private String owlName;
    boolean loggedin = false;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ArrayList<Message> Parcel = new ArrayList<>();

    public User(){}

    public User(String firstName, String secondName, int age, String ID, String owlName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.ID = ID;
        this.owlName = owlName;
        this.status = true;
        this.nickName = "";
        this.password = "";
    }
    public User(String firstName, String secondName, int age, String ID, String owlName, String nickName, String password){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.ID = ID;
        this.owlName = owlName;
        this.status = true;
        this.nickName = nickName;
        this.password = password;
    }
    public boolean getStatus(){
        return status;
    }

    public String getNickName() {
        return nickName!=null ? nickName : "";
    }
    public String getPassword() {
        return password!=null ? password : "";
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSecondName(){
        return secondName;
    }
    public int getAge(){
        return age;
    }

    public String getID() {
        return ID;
    }

    public boolean isStatus() {
        return status;
    }

    public String getOwlName() {
        return owlName;
    }

    public boolean isLoggedin() {
        return loggedin;
    }

    public static BufferedReader getReader() {
        return reader;
    }

    public boolean isIslogged() {
        return loggedin;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public void GreatHall() throws Exception {
        try {


            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Make Request");
                System.out.println("3) Personal Data");
                System.out.println("4) Change Password");
                System.out.println("5) Parcels(Messages)");
                System.out.println("0) Logout");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        news();
                        Database.logUserAction(this, "View news");
                        break;
                    case 2:
                        makeRequest();
                        Database.logUserAction(this, "Made Request");
                        break;
                    case 3:
                        personalData();
                        Database.logUserAction(this, "Saw personal data");
                        break;
                    case 4:
                        changePassword();
                        Database.logUserAction(this, "Changed password");
                        break;
                    case 5:
                        Database.logUserAction(this, "Messages");
                        Messages();
                        // I will write method for message
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

    public int compareTo(User user){
        return user.getNickName().compareTo(nickName);
    }





    void news() {
        System.out.println("$            =====News=====         $");
        Database.getNews();
        System.out.println("$            ==============         $");
    }

    void makeRequest() throws IOException {
        System.out.print("Title of your request: ");
        String request = reader.readLine();
        System.out.print("Description: ");
        String desc = reader.readLine();
        System.out.println("Urgency level:\n1. ");

        String logEntry = new Date() + " - User: " + this.getNickName() + " - Title: " + request + " - Description: " + desc;
        Database.requests.add(logEntry);
        System.out.println("Request Made: " + logEntry);

    }

    void personalData() {

        System.out.println("\n\n" +
                "Name: " + firstName + '\n' +
                "Last Name: '" + secondName + '\n' +
                "Age:  " + age + '\n' +
                "ID: '" + ID + '\n' +
                "Owl Name='" + owlName + '\n' + "\n" +
                password
        );
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

    void Messages() throws Exception{
        while(true){
            System.out.println("----------Messages----------");
            System.out.println("-You have " + Parcel.size() + " messages");
            System.out.println("1) View messages");
            System.out.println("2) Send messages");
            System.out.println("0) Go back to Menu");
            System.out.print("Your choice: ");
            try {
                int answer = Integer.parseInt(reader.readLine());
                switch (answer){
                    case 1:
                        viewMessage();
                        Database.logUserAction(this, "Viewed Message");
                        break;
                    case 2:
                        Database.logUserAction(this, "Sent Message to" );
                        sendMessage();
                        break;
                    case 0:
                        this.GreatHall();
                        break;

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
    void viewMessage() throws IOException{
        for(Message m : Parcel){
            System.out.println(m);
        }
    }
    void sendMessage() throws IOException {
        System.out.print("Enter the recipient's nickname: ");
        String nickname = reader.readLine();

        User recipient = Database.getUser(nickname);

        if(recipient != null){
            System.out.println("Enter the message: ");
            String message = reader.readLine();

            Message message1 = new Message(this, recipient, message);

            recipient.receiveMessage(message1);

            System.out.println("Message sent!");

        }
        else {
            System.out.println("User not found!");
        }

    }
    void receiveMessage(Message message){
        Parcel.add(message);
    }

    void LogOut() throws Exception {
        Main.Menu();
    }

    @Override
    public String toString() {
        return "\n" +
                "Name: " + firstName +
                " Last Name: " + secondName  +
                " Age: " + age +
                " ID: " + ID +
                " Status: " + status +
                " Owl Name: " + owlName;
    }
}