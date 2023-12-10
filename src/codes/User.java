package codes;

public class User {
    public String firstName;
    public String secondName;
    public int age;

    public String ID;
    private String nickName;
    private String password;
    private boolean status;
    private String owlName;
    public User(){}

    public User(String firstName, String secondName, int age, String ID, String owlName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.ID = ID;
        this.owlName = owlName;
    }

    public String getNickName() {
        return nickName;
    }
    public String getPassword() {
        return password;
    }


    public void LogIn(String nickName, String password){
        this.nickName = nickName;
        this.password = password;
        for(User u : Database.users){
            if(u.getNickName().equals(this.nickName) && u.getPassword().equals(this.password)) {
                status = true;
            }
            else if(u.getNickName().equals(this.nickName) && !u.getPassword().equals(this.password)){
                while(true){
                    System.out.println("Your password is incorrect! Try again!");
                    if(u.getNickName().equals(this.nickName) && u.getPassword().equals(this.password)) {
                        status = true;
                        return ;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", ID='" + ID + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", owlName='" + owlName + '\'' +
                '}';
    }
}
