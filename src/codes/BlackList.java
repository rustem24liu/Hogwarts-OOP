package codes;

public class BlackList {
    private Student student;
    private String cause;

    public BlackList(Student student, String cause){
        this.student = student;
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "student=" + student +
                ", cause='" + cause + '\'' +
                '}';
    }
}
