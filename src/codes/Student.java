package codes;

public class Student extends User {
    private Integer yearOfStudy;
    private String property;
    private String organization;
    /*private Integer totalCredits;
    protected Vector<Course> courses;
    private Degree degree;
    private Integer creditLimit;
    private Integer chosenCredits = 0;*/

    public Student(){
        super();
    }
    public Student(String firstName, String secondName, int age, String ID, String owlName    /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName);
        this.yearOfStudy = yearOfStudy;
        /*this.totalCredits = 0;*/
        /*this.GPA = 0.0;*/
        /*this.courses = new Vector<Course>();*/
        /*this.faculty = faculty;*/
        this.property = property;
        this.organization = organization;
    }
    public Student(String firstName, String secondName, int age, String ID, String owlName , String nickNmae, String password  /*Faculties faculty*/) {
        super(firstName, secondName, age, ID, owlName, nickNmae, password);
        this.yearOfStudy = yearOfStudy;
        /*this.totalCredits = 0;*/
        /*this.GPA = 0.0;*/
        /*this.courses = new Vector<Course>();*/
        /*this.faculty = faculty;*/
        this.property = property;
        this.organization = organization;
    }

    /*public Student(String name, String surname, String birthDate, String phoneNumber, String email,
                   String password, String id, Integer yearOfStudy, Integer totalCredits, Double GPA, Vector<Course> courses, Faculty faculty, Degree degree, Integer creditLimit) {
        super(name, surname, birthDate, phoneNumber, email, password);
        this.id = id;
        this.yearOfStudy = yearOfStudy;
        this.totalCredits = totalCredits;
        this.GPA = GPA;
        this.courses = courses;
        this.faculty = faculty;
        this.degree = degree;
        this.creditLimit = creditLimit;

        //TODO Auto-generated constructor stub
    }*/


    public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /*public Integer getTotalCredits() {
        return this.totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Double getGPA() {
        return this.GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public Vector<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }


    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }


    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }*/




    //                          Operations

    public void registertorSubject(){}

    public void getTranscript(){}

    public void viewShedule(){}

    public void rateTeachers(){}

    public void viewinfiAboutTeacher(){}

    public void viewSubject(){}

    public void studentOrganizations(){}


}