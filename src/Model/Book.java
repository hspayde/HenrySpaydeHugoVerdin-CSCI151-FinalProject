package Model;

public class Book {
    private String author;
    private String book_title;
    private int page_count;
    private int current_page;
    private boolean is_reading;
    private boolean owned;
    private boolean read;
    private boolean read_list;
    private boolean wish_list;
    private String genre;
    private double rating;
    private String comments;

    public Book(String author, String book_title, int page_count, int current_page, boolean is_reading, boolean owned, boolean read, boolean read_list, boolean wish_list, String genre, double rating, String comments) {
        this.author = author;
        this.book_title = book_title;
        this.page_count = page_count;
        this.current_page = current_page;
        this.is_reading = is_reading;
        this.owned = owned;
        this.read = read;
        this.read_list = read_list;
        this.wish_list = wish_list;
        this.genre = genre;
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

    public void setWishList(boolean wish_list) {this.wish_list = wish_list;}
    public void setGenre(String genre) {
        this.genre = genre;
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
    public String returnGenre(){return this.genre; }

    public double returnRating() {
        return this.rating;
    }

    public String returnComments() {
        return this.comments;
    }

    public static String bookToString(Book book) {
        String bookInfo = "";
        bookInfo += book.author + "," + book.book_title + "," + Integer.toString(book.page_count) + "," + Integer.toString(book.current_page) + "," + Boolean.toString(book.is_reading)  +"," + Boolean.toString(book.owned) + "," + Boolean.toString(book.read) + "," + Boolean.toString(book.read_list) + "," + Boolean.toString(book.wish_list) + "," + book.genre + "," + Double.toString(book.rating) + "," + book.comments;
        return bookInfo;
    }

    public static Book stringToBook(String book) {
        String [] bookinfo = book.split(",");
        Book b = new Book(bookinfo[0],bookinfo[1],Integer.valueOf(bookinfo[2]),Integer.valueOf(bookinfo[3]),Boolean.parseBoolean(bookinfo[4]),Boolean.parseBoolean(bookinfo[5]),Boolean.parseBoolean(bookinfo[6]),Boolean.parseBoolean(bookinfo[7]), Boolean.parseBoolean(bookinfo[8]), bookinfo[9], Double.parseDouble(bookinfo[10]),bookinfo[11]);
        return b;
    }
}
