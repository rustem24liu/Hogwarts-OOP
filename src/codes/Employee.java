package codes;

public class Employee extends User{
    public Employee() {
        super();
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName    /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName);
    }
    public Employee(String firstName, String secondName, int age, String ID, String owlName, String nickname, String password /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName, nickname, password);
    }


}
