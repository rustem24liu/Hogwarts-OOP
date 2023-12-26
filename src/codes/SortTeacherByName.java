package codes;

import java.util.Comparator;

public class SortTeacherByName implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
