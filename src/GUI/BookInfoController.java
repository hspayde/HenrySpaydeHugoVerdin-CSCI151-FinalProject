package GUI;

import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class BookInfoController {
    @FXML
    private TextField bookTitle;
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
    private TextField comments;
    private Book book;
    public void intialize() {
        bookTitle.setText(book.returnBookTitle());
        author.setText(book.returnAuthor());
        pa
    }
    public void updateBook(){
        book.setAuthor(author.getText());
        book.setBookTitle(bookTitle.getText());
        book.setPageCount(Integer.parseInt(pageCount.getText()));
        book.setCurrentPage(Integer.parseInt(currentPage.getText()));
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
