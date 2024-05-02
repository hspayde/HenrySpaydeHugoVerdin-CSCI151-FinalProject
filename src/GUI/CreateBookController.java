package GUI;

import Core.BookHolder;
import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateBookController {

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
    private Slider slideRating;
    @FXML
    private TextArea comments;


    public void initialize() {}
    public void createBook(){
        Book newbook = new Book(this.author.getText(), this.bookTitle.getText(), this.pageCount.getText(), this.currentPage.getText(), this.readingY.isSelected(),this.owned.isSelected(),this.read.isSelected(), this.readList.isSelected(), this.wishList.isSelected(), this.genre.getText(), this.slideRating.getValue(), this.comments.getText());
        BookHolder bookHolder = BookHolder.getInstance();
        bookHolder.setBook(newbook);
    }
}
