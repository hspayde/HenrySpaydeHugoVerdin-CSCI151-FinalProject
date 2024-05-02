package Core;

import Model.Book;

public final class BookHolder {

    private Book book;
    private final static BookHolder INSTANCE = new BookHolder();

    private BookHolder(){}

    public static BookHolder getInstance() {
        return INSTANCE;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
