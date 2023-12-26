package codes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Employee extends User implements Researcher{
    private double salary = 2500.0;
    private boolean isResearcher = false;
    private ArrayList<ResearchPaper> researchPapers = new ArrayList<>();
    private boolean supervisor = false;
    public Employee() {
        super();
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName    /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName);
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName, String nickname, String password /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName, nickname, password);
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName, boolean isResearcher, String nickname, String password /*Faculties faculty*/) {

        super(firstName, secondName, age, ID, owlName, nickname, password);
        this.isResearcher = isResearcher;
    }



    public void GreatHall() throws Exception {
        try {
            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Salary");
                System.out.println("3) Change Password");
                System.out.println("4) Parcels(Messages)");
                System.out.println("5) Research");
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
                        if(isResearcher){
                            writeResearch();
                        }
                        else{
                            System.out.println("You cannot use this method, You are not researcher");
                        }

                        Database.logUserAction(this, "Research");
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
            n.printStackTrace();{

    }
        }
    }

    public void getSalary() {
        System.out.println(salary + "$");
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                " salary=" + salary +
                '}';
    }

    CitationComparator citationComparator = new CitationComparator();
    @Override
    public void writeResearch() throws IOException {
        boolean ok = true;
        while(ok){
            System.out.println("1) Print Papers");
            System.out.println("2) Write Papers");
            System.out.println("3) H-index");
            System.out.println("0) QUIT");
            int ans = Integer.parseInt(reader.readLine());
            switch (ans){
                case 1:
                    printPapers(citationComparator);
                    break;
                case 2:
                    System.out.print("Title of the paper: ");
                    String name = reader.readLine();
                    System.out.print("Descriptions: ");
                    String description = reader.readLine();
                    System.out.print("More Detail: ");
                    String pages = reader.readLine();
                    System.out.print("Number of citations: ");
                    int citations = Integer.parseInt(reader.readLine());

                    ResearchPaper researchPaper = new ResearchPaper(this, name, description, pages, citations);
                    researchPapers.add(researchPaper);
                    break;
                case 3:
                    int hIndexx = hIndex();
                    System.out.print("Your H-Index is: ");
                    System.out.println(hIndexx);
                    if(hIndexx > 3){
                        System.out.println("You are supervisor");
                        supervisor = true;
                    }
                    break;
                case 0:
                    ok = false;
                    break;
            }
        }
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        if (researchPapers.isEmpty()) {
            System.out.println("Research Papers is empty!");
        } else {
            // Sort the research papers using the provided comparator
            researchPapers.sort(comparator);

            // Print the sorted research papers
            for (ResearchPaper researchPaper : researchPapers) {
                System.out.println(researchPaper);
            }
        }
    }

    @Override
    public int hIndex() {

        researchPapers.sort(new CitationComparator());

        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {

            int citations = researchPapers.get(i).getCitation();
//            System.out.println(i + " - " + citations);
            if (citations >= i + 1) {
                hIndex = i + 1;
            }
//            else{
//                break;
//            }
        }

        return hIndex;
    }
}