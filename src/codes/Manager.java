package codes;

import javax.xml.crypto.Data;
import java.io.IOException;


public class Manager extends User{
    private ManagerType managerType;
    private Double rating;
    public Manager(String firstName, String secondName, int age, String ID, String owlName) {
        super(firstName, secondName, age, ID, owlName);
    }
    public Manager(String name, String lastName, int age, String id, String owl, String nickname, String regPassword) {
        super(name, lastName, age, id, owl, nickname, regPassword);
    }
    public Manager(String name, String lastName, int age, String id, String owl, String nickname, String regPassword, ManagerType managerType, Double rating) {
        super(name, lastName, age, id, owl, nickname, regPassword);
        this.managerType = managerType;
        this.rating = rating;
    }

    @Override
    public void GreatHall() throws Exception {
        while (true) {
            System.out.println("\n$$===== Great Hall Menu =====$$");
            System.out.println("1) News");
            System.out.println("2) Personal Data");
            System.out.println("3) Change Password");
            System.out.println("4) Messages ");
            System.out.println("5) Manage News");
            System.out.println("6) Manage requests");
            System.out.println("7) View info about Teachers/Students");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    super.news();
                    break;
                case 2:
                    super.personalData();
                    break;
                case 3:
                    super.changePassword();
                    break;
                case 4:
                    super.sendMessage();
                    break;
                case 5:
                    manageNews();
                    break;
                case 6:
                    manageRequest();
                    break;
                case 7:
                    viewInfo();
                    break;
                case 0:
                    LogOut();
                    System.out.println("Logged out. Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public void viewInfo() throws Exception {
        boolean ok = true;
        while(ok){
            System.out.println("1) Info about Teachers");
            System.out.println("2) Info about Students");
            System.out.println("0) Quit");
            System.out.print("Your choice: ");
            int answer = Integer.parseInt(reader.readLine());
            switch(answer){
                case 1:
                    Database.getTeacher();
                    break;
                case 2:
                    boolean right = true;
                    while(right) {
                        System.out.println("1) By name");
                        System.out.println("2) By GPA");
                        System.out.println("0) QUIT");
                        int ans = Integer.parseInt(reader.readLine());
                        switch (ans) {
                            case 1:
                                System.out.println(Database.getStudentsOrderByName());
                                break;
                            case 2:
                                System.out.println(Database.getStudentsOrderByGPA());
                                break;
                            case 0:
                                right = false;
                                break;
                        }
                    }
//                    Database.getStudents();
                    break;
                case 0:
//                    this.GreatHall();
                    ok = false;
                    break;
            }

        }
    }
    private void manageRequest() throws IOException {
        while(true){
            System.out.println("1) View Requests");
            System.out.println("2) Answer Requests");
            System.out.println("Your choice: ");
            int answer = Integer.parseInt(reader.readLine());

            if(answer == 1){
                if(Database.requests.isEmpty() || Database.requests == null){
                    System.out.println("0 - Request, chill");
                    break;
                }
                else{
                    System.out.println(Database.requests.size() + " - Requests");
                    for(String s: Database.requests){
                        System.out.println(s);
                    }
                    break;
                }
            }
            else if(answer == 2){

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

    public boolean addNews(TheDailyProphet news1) {
        Database.news.add(news1);
        return false;
    }

    public void removeNews(TheDailyProphet news1) {
        Database.news.remove(news1);
    }

    public void updateNews(TheDailyProphet news1, TheDailyProphet news2) {
        Database.news.remove(news1);
        Database.news.add(news2);
    }


    public void createNews() throws IOException {
        try {
            String title, description;

            System.out.println("Enter Title: ");

            title = reader.readLine();

            System.out.println("Enter Description: ");

            description = reader.readLine();

            if (this.addNews(new TheDailyProphet(title, description))) {
                TheDailyProphet n = new TheDailyProphet(title, description);
                System.out.println("\n[News was successfully created]");
                addNews(n);

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

    public void updateNews() throws IOException {
        System.out.print("Enter the title of the news you want to update: ");
        String titleToUpdate = reader.readLine();

        boolean newsExists = Database.getNewsByTitle(titleToUpdate);

        if (newsExists) {
            System.out.print("Enter the new description for the news: ");
            String newDescription = reader.readLine();

            updateNewsDescription(titleToUpdate, newDescription);

        } else {
            System.out.println("News with title '" + titleToUpdate + "' not found.");
        }
    }


    public void deleteNews(TheDailyProphet n) {
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
