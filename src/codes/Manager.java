package codes;

import java.io.IOException;

//import static com.sun.beans.introspect.PropertyInfo.Name.description;

public class Manager extends User{
    private ManagerType managerType;
    private Double rating;
    static Manager manager = null;

    Manager() {

    }

    public Manager(String firstName, String secondName, int age, String ID, String owlName) {
        super(firstName, secondName, age, ID, owlName);
    }

    Manager(ManagerType managerType, Double rating) {
        this.managerType = managerType;
        this.rating = rating;
    }

    public Manager(String name, String lastName, int age, String id, String owl, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
    }

    public static boolean addNews(TheDailyProphet news1) {
        Database.news.add(news1);
        return false;
    }

    public static void removeNews(TheDailyProphet news1) {
        Database.news.remove(news1);
    }

    public static void updateNews(TheDailyProphet news1, TheDailyProphet news2) {
        Database.news.remove(news1);
        Database.news.add(news2);
    }

    @Override
    public void GreatHall() throws Exception {
        while (true) {
            System.out.println("\n$$===== Great Hall Menu =====$$");
            System.out.println("1) News");
            System.out.println("2) Make Request");
            System.out.println("3) Personal Data");
            System.out.println("4) Change Password");
            System.out.println("5) Send Parcel");
            System.out.println("6) View Parcel");
            System.out.println("7) Manage News");
            System.out.println("8) Logout");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    super.news();
                    break;
                case 2:
                    super.makeRequest();
                    break;
                case 3:
                    super.personalData();
                    break;
                case 4:
//                    super.changePassword();
                    break;
                case 5:
                    super.sendParcel();
                    break;
                case 6:
                    super.viewParcel();
                    break;
                case 7:
                    manageNews();
                    break;
                case 8:
                    LogOut();
                    System.out.println("Logged out. Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void manageNews() throws IOException {
        while (true) {
            System.out.println("\n$$===== News Management =====$$");
            System.out.println("1) Create News");
            System.out.println("2) Remove News");
            System.out.println("3) Update News");
            System.out.println("4) Back to Great Hall");
            System.out.print("Enter your choice: ");
            int newsChoice = Integer.parseInt(reader.readLine());

            switch (newsChoice) {
                case 1:
                    createNews();
                    break;
                case 2:
                    System.out.print("Write title that you want to delete: ");
                    String title = reader.readLine();
                    for (TheDailyProphet t : Database.news) {
                        if (t.getDescription().equals(title)) {
                            deleteNews(t);
                        }
                    }
                    break;
                case 3:
                    updateNews();
                    break;
                case 4:
                    System.out.println("Returning to Great Hall.");
                    return; // Break out of the inner loop and return to the Great Hall
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }




    public void createNews() throws IOException {
        try {
            String title, description;
            System.out.println("Enter Title: ");
            title = reader.readLine();
            System.out.println("Enter Description: ");
            description = reader.readLine();
            if (manager.addNews(new TheDailyProphet(title, description))) {
                System.out.println("\n[News was successfully created]");
//                Database.saveNews();
            } else {
                System.out.println("News creation disrupted. The similar news is already created");
            }
        } catch (ExceptionInInitializerError exception) {
            System.out.println("News creation disrupted");
        }
    }
    public void updateNewsDescription(String title, String newDescription) {
        for (TheDailyProphet news : Database.news) {
            if (news.getTitle().equals(title)) {
                news.setDescription(newDescription);
                System.out.println("News updated successfully!");
                return;
            }
        }
        System.out.println("News with title '" + title + "' not found.");
    }

    // Add this method to your existing Manager class
    public void updateNews() throws IOException {
        System.out.print("Enter the title of the news you want to update: ");
        String titleToUpdate = reader.readLine();

        // Check if the news with the provided title exists
        boolean newsExists = Database.news.stream().anyMatch(news -> news.getTitle().equals(titleToUpdate));

        if (newsExists) {
            System.out.print("Enter the new description for the news: ");
            String newDescription = reader.readLine();

            updateNewsDescription(titleToUpdate, newDescription);
//            Database.saveNews();  // Save the updated news to the database if needed
        } else {
            System.out.println("News with title '" + titleToUpdate + "' not found.");
        }
    }


    public static void deleteNews(TheDailyProphet n) {
        Database.news.remove(n);
    }

    @Override
    public String toString() {
        return "\n\n" +
                "Name: " + firstName + '\n' +
                "Last Name: " + secondName + '\n' +
                "Age: " + age + '\n' +
                "ID: '" + ID + '\n' +
                "Nick Name: " + getNickName() + '\n' +
                "Password: " + getPassword() + '\n' +
                "Manager Type: " + (managerType != null ? managerType.name() : "Not Assigned") + '\n' +
                "Rating: " + (rating != null ? rating : "Not Assigned") + '\n';
    }

}

