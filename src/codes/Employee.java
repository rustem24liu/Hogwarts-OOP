package codes;

import java.io.IOException;
import java.util.Objects;

public class Employee extends User{
    private double salary = 2500.0;
    public Employee() {
        super();
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName    /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName);
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName, String nickname, String password /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName, nickname, password);
    }

    public void GreatHall() throws Exception {
        try {
            while (true) {
                System.out.println("\n$$===== Great Hall Menu =====$$");
                System.out.println("1) News");
                System.out.println("2) Salary");
                System.out.println("3) Change Password");
                System.out.println("4) Parcels(Messages)");
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
}