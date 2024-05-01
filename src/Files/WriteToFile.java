package Files;
import java.io.FileWriter;
import java.io.IOException;
import Model.Book;
import static Files.ReadToBook.books;
import static Model.Book.bookToString;

public class WriteToFile {
    public static void main(String[] args) {
        /*This array needs to be built from the books in the tree map*/
        Book [] books = new Book [4];
        books[0] = new Book ("hugo","verdin",10,5,true,false,true,false,false,2.25,"good");
        books[1] = new Book ("hugo","verdin",10,5,true,false,true,false,false,2.25,"good");
        books[2] = new Book ("hugo","verdin",10,5,true,false,true,false,false,2.25,"good");
        books[3] = new Book ("hugo","verdin",10,5,true,false,true,false,false,2.25,"good");
        try {
            FileWriter myWriter = new FileWriter("Files/Books.txt");
            for (int i = 0; i < books.length; i++) {
                String bookInfo = bookToString(books[i]);
                myWriter.write(bookInfo + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
