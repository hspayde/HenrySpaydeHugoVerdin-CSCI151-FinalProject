package GUI;

import Model.Shelf;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private TextField currentBookText;
    @FXML
    private TextField currentShelfText;
    @FXML
    private TextField bookTitleText;
    @FXML
    private TextField authorText;
    @FXML
    private TextField pageCountText;
    @FXML
    private TextField currentPageText;
    @FXML
    private CheckBox readingY;
    @FXML
    private CheckBox readingN;
    @FXML
    private CheckBox ownedBox;
    @FXML
    private CheckBox readBox;
    @FXML
    private CheckBox readListBox;
    @FXML
    private CheckBox wishListBox;
    @FXML
    private TextField genreText;
    @FXML
    private TextField ratingText;
    @FXML
    private TextArea commentsText;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    private Shelf owned;
    private Shelf read;
    private Shelf readList;
    private Shelf wishList;

    public void initialize() {
    }



}
