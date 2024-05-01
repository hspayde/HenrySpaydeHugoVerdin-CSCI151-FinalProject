package Files;
import java.io.FileWriter;
import java.io.IOException;
import Model.Book;
public class WriteToFile {
    public static void main(String[] args) {
        Book b = new Book("hugo", "verdin", 10, 5, true, true, false, true, false, 2.25, "good");

        String bookInfo = b.bookToString();
        try {
            FileWriter myWriter = new FileWriter("Files/BooksRead.txt");
            myWriter.write(bookInfo);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
