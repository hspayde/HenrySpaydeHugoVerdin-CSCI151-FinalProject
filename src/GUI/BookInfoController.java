package GUI;

import Core.BookHolder;
import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BookInfoController {
    @FXML
    private Label bookTitle;
    @FXML
    private TextField author;
    @FXML
    private TextField pageCount;
    @FXML
    private TextField currentPage;
    @FXML
    private CheckBox readingY;
    @FXML
    private CheckBox readingN;
    @FXML
    private CheckBox owned;
    @FXML
    private CheckBox read;
    @FXML
    private CheckBox readList;
    @FXML
    private CheckBox wishList;
    @FXML
    private TextField genre;
    @FXML
    private TextField rating;
    @FXML
    private Slider sliderating;
    @FXML
    private TextArea comments;
    private Book book;
    public void initialize() {
        BookHolder bookHolder = BookHolder.getInstance();
        book = bookHolder.getBook();
        bookTitle.setText(book.returnBookTitle());
        author.setText(book.returnAuthor());
        pageCount.setText(book.returnPageCount());
        currentPage.setText(book.returnCurrentPage());
        readingY.setSelected(book.returnIsReading());
        readingN.setSelected(!book.returnIsReading());
        read.setSelected(book.returnRead());
        readList.setSelected(book.returnReadList());
        wishList.setSelected(book.returnWishList());
        genre.setText(book.returnGenre());
        rating.setText(String.valueOf(book.returnRating()));
        sliderating.setBlockIncrement(book.returnRating());
        comments.setText(book.returnComments());
    }
    public void updateBook(){
        book.setAuthor(author.getText());
        book.setBookTitle(bookTitle.getText());
        book.setPageCount(pageCount.getText());
        book.setCurrentPage(currentPage.getText());
        book.setIsReading(readingY.isSelected());
        book.setOwned(owned.isSelected());
        book.setRead(read.isSelected());
        book.setReadList(readList.isSelected());
        book.setWishList(wishList.isSelected());
        book.setGenre(genre.getText());
        book.setRating(Double.parseDouble(rating.getText()));
        book.setComments(comments.getText());
    }
    public void setRating(){
        this.rating.setText(Double.toString(sliderating.getValue()));
    }

}
