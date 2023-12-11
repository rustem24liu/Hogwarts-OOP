package codes;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    protected static ArrayList<User> users = new ArrayList<>();

//    public void saveData() {
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
//            outputStream.writeObject(users);
//            System.out.println("User data saved successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void loadData() {
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
//            Object object = inputStream.readObject();
//            if (object instanceof ArrayList) {
//                users = (ArrayList<User>) object;
//                System.out.println("User data loaded successfully.");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
}
