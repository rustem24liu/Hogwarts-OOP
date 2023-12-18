package codes;

public class Message {
    private User sender;
    private User getter;
    private String text;

    Message(){}
    Message(User sender, User getter, String text){
        this.sender = sender;
        this.getter = getter;
        this.text = text;
    }
    public User getSender() {
        return sender;
    }

    public User getGetter() {
        return getter;
    }

    public String getText() {
        return text;
    }
    public String toString(){
        return (sender.getNickName() +": "+text);
    }
}
