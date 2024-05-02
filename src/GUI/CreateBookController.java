package GUI;

import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.awt.*;

import static Model.Book.bookToString;

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
    private TextField rating;
    @FXML
    private Slider sliderating;
    @FXML
    private TextArea comments;


    public void initialize() {}
    public void createbook(){
        Book newbook = new Book(this.author.getText(), this.bookTitle.getText(), Integer.parseInt(this.pageCount.getText()), Integer.parseInt(this.currentPage.getText()), this.readingY.isSelected(),this.owned.isSelected(),this.read.isSelected(), this.readList.isSelected(), this.wishList.isSelected(), this.genre.getText(), Integer.parseInt(this.rating.getText()), this.comments.getText());
        System.out.println(bookToString(newbook));
    }
    public void setRating(){
        this.rating.setText(Double.toString(sliderating.getValue()));
    }
}
