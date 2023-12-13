package codes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Library {
    public void addBook(String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        String author = st.nextToken();
        String title = st.nextToken();
        Book b = new Book(author, title);
        Book.books.add(b);
        System.out.println("Book added successfully!");
    }
    public void showBooks() {
        if(!Book.books.isEmpty()) {
            for(Book b: Book.books)
                System.out.println(b);
        }
        else
            System.out.println("No books yet, try adding one");
    }
    public void exit() throws Exception {
        System.out.println("Bye bye");
        Book.saveBooks();
    }
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome!");
        try {
            menu: while(true) {
                System.out.println("What do you want to do?\n1.Add\n2.View\n3.Exit");
                int choice = Integer.parseInt(br.readLine());
                if(choice==1) {
                    System.out.println("Enter author and title separated by comma");
                    addBook(br.readLine());
                }
                else if(choice==2) {
                    showBooks();
                }
                else if(choice==3) {
                    exit();
                    break menu;
                }
            }
        }
        catch(Exception e) {
            System.out.println("Smth bad happened! Saving resources");
            exit();
        }
    }
}