package codes;

public class Complaint {
    private Teacher teacher;
    private Student student;
    private String details;
    private Urgency urgency;
    private String deanResponse;

    public Complaint(Teacher teacher, Student student, String details, Urgency urgency) {
        this.teacher = teacher;
        this.student = student;
        this.details = details;
        this.urgency = urgency;
    }
    public Urgency getUrgency() {
        return urgency;
    }

    public String getDeanResponse() {
        return deanResponse;
    }

    public void setDeanResponse(String deanResponse) {
        this.deanResponse = deanResponse;
    }

    @Override
    public String toString() {
        return "Complaint: [Teacher=" + teacher + ", Student=" + student +
                ", Details=" + details + ", Urgency=" + urgency;
    }

}
