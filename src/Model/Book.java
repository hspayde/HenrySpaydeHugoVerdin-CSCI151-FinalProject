package Model;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Book {
    private String author = "";
    private String book_title = "";
    private int page_count = 0;
    private int current_page = 0;
    private boolean is_reading = false;
    private boolean owned = false;
    private boolean read = false;
    private boolean read_list = false;
    private boolean wish_list = false;
    private double rating = 0;
    private String comments = "";

    public Book(String author, String book_title, int page_count, int current_page, boolean is_reading, boolean owned, boolean read, boolean read_list, boolean wish_list, double rating, String comments) {
        this.author = author;
        this.book_title = book_title;
        this.page_count = page_count;
        this.current_page = current_page;
        this.is_reading = is_reading;
        this.owned = owned;
        this.read = read;
        this.read_list = read_list;
        this.wish_list = wish_list;
        this.rating = rating;
        this.comments = comments;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookTitle(String book_title) {
        this.book_title = book_title;
    }

    public void setPageCount(int page_count) {
        this.page_count = page_count;
    }

    public void setCurrentPage(int current_page) {
        this.current_page = current_page;
    }

    public void setIsReading(boolean is_reading) {
        this.is_reading = is_reading;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setReadList(boolean read_list) {
        this.read_list = read_list;
    }

    public void setWishList(boolean wish_list) {
        this.wish_list = wish_list;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public String returnAuthor() {
        return this.author;
    }

    public String returnBookTitle() {
        return this.book_title;
    }

    public int returnPageCount() {
        return this.page_count;
    }

    public int returnCurrentPage() {
        return this.current_page;
    }

    public boolean returnIsReading() {
        return this.is_reading;
    }

    public boolean returnOwned() {
        return this.owned;
    }

    public boolean returnRead() {
        return this.read;
    }

    public boolean returnReadList() {
        return this.read_list;
    }

    public boolean returnWishList() {
        return this.wish_list;
    }

    public double returnRating() {
        return this.rating;
    }

    public String returnComments() {
        return this.comments;
    }

    public String bookToString() {
        String bookInfo = "";
        bookInfo += this.author + "," + this.book_title + "," + Integer.toString(this.page_count) + "," + Integer.toString(this.current_page) + "," + Boolean.toString(this.is_reading) + "," + Boolean.toString(this.read) + "," + Boolean.toString(this.read_list) + "," + Boolean.toString(this.wish_list) + "," + Double.toString(this.rating) + "," + this.comments + ";";
        return bookInfo;
    }

    public Book stringToBook() {
        Book b = new Book("","",);
        try {
            File myObj = new File("Files/BooksRead.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.findInLine(",");
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return b;
    }
}
