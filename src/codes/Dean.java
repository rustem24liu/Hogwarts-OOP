package codes;

import java.io.IOException;
import java.util.ArrayList;

public class Dean extends User {
    private static Dean instance;
    private ArrayList<Complaint> complaints  = new ArrayList<Complaint>();
    public static Dean getInstance() {
        if (instance == null) {
            instance = new Dean();
        }
        return instance;
    }

    public void GreatHall() throws Exception {
        try {


            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Complaints");
                System.out.println("3) Change Password");
                System.out.println("4) Parcels(Messages)");
                System.out.println("0) Logout");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        news();
                        Database.logUserAction(this, "Secret");
                        break;
                    case 2:
                        complaint();
                        Database.logUserAction(this, "Secret");
                        break;
                    case 3:
                        changePassword();
                        Database.logUserAction(this, "Secret");
                        break;
                    case 4:
                        Messages();
                        Database.logUserAction(this, "Secret");
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

    public void complaint() throws IOException {
        boolean ok = true;
        while (ok) {
            System.out.println("Dean Menu:");
            System.out.println("1) View Complaints");
            System.out.println("2) Answer Complaints");
            System.out.println("0) Exit");
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    viewComplaints();
                    break;
                case 2:
                    System.out.print("Enter the index of the complaint to answer: ");
                    int index = Integer.parseInt(reader.readLine());
                    if (index >= 0 && index < complaints.size()) {
                        System.out.println("Enter your response:");
                        String response = reader.readLine();
                        respondToComplaint(complaints.get(index), response);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 0:
                    ok = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void viewComplaints() {
        System.out.println("Dean: " + this);
        for (Complaint complaint : Database.getComplaints()) {
            System.out.println(complaint);
        }
    }

    public void respondToComplaint(Complaint complaint, String response) {
        complaint.setDeanResponse(response);
    }
}
