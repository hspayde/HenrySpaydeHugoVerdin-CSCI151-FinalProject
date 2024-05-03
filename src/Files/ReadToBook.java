package Files;
import Model.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static Model.Book.stringToBook;

public final class ReadToBook {
    public static ArrayList<Book> books = new ArrayList<Book>();

    public static ArrayList<Book> readList() {
        try {
            File bookInfo = new File("Files/Books.txt");
            Scanner myReader = new Scanner(bookInfo);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Book b = stringToBook(data);
                books.add(b);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return books;
    }
}
