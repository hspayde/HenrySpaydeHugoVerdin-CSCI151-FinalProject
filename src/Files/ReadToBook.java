package Files;
import Model.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import static Model.Book.stringToBook;

public class ReadToBook {
    public static Book [] books = new Book[5];
    /*this array will be turned into the books for array map*/
    public static void main(String[] args) {
        int i = 0;
        try {
            File bookInfo = new File("Files/Books.txt");
            Scanner myReader = new Scanner(bookInfo);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Book b = stringToBook(data);
                books[i] = b;
                /*if (i >= books.length - 1) {
                    books = Arrays.copyOf(books, books.length + 5);
                }*/
                /*resize method I added, but I don't think it's actually needed*/
                i++;
            }
            System.out.println(Arrays.toString(books));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
