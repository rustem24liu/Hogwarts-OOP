package codes;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Database implements Serializable {
//    private static final String FILE_PATH = "users.txt";
//    private static final long serialVersionUID = 1L;

    static Vector<User> users = new Vector<>();
    static {
        if (new File("users.ser").exists()) {
            try {
                users = readUsers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Vector<User> readUsers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Vector<User> users = (Vector<User>) ois.readObject();
        fis.close();
        ois.close();
        return users;
    }

    static void saveUsers() {
        try {
            FileOutputStream fos = new FileOutputStream("users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
