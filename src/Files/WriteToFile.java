package Files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Book;

public final class WriteToFile {
    public static void writeFile(ArrayList<Book> books) {
        try {
            FileWriter myWriter = new FileWriter("Files/Books.txt");
            for (int i = 0; i < books.size(); i++) {
                String bookInfo = Book.bookToString(books.get(i));
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
