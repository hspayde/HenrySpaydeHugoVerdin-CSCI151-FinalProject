package GUI;

import Model.Book;
import Model.Shelf;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

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
    private Shelf currentShelf;
    private Color[] colors = { Color.CADETBLUE, Color.DARKOLIVEGREEN, Color.DARKSEAGREEN, Color.GOLDENROD, Color.MEDIUMSEAGREEN, Color.MISTYROSE, Color.ROSYBROWN };


    public void initialize() {
        try {
            updateView(getList(currentShelf));
        }catch (Exception ignored) {}
    }

    public void updateView(ArrayList<Book> displayed) {
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
        Random rand = new Random();
        Book current;

        double bookWidth = pane1.getWidth() /50;
        double bookHeight = 50;

        for(int i = 0; i < displayed.size(); i++) {
            if(i < 50) {
                Rectangle book = new Rectangle(i * bookWidth, pane1.getHeight(), bookWidth, rand.nextDouble(50, 75));
                book.setFill(colors[rand.nextInt(0, colors.length - 1)]);
                book.setStroke(Color.BLACK);
                current = displayed.get(i);
                Book finalCurrent = current;
                book.setOnMouseDragOver(event -> {
                    dragOver(finalCurrent);
                });
                pane1.getChildren().add(book);
            }else if(i < 100) {
                Rectangle book = new Rectangle(i * bookWidth, pane1.getHeight(), bookWidth, rand.nextDouble(50, 75));
                book.setFill(colors[rand.nextInt(0, colors.length - 1)]);
                book.setStroke(Color.BLACK);
                current = displayed.get(i);
                Book finalCurrent = current;
                book.setOnMouseDragOver(event -> {
                    dragOver(finalCurrent);
                });
                pane2.getChildren().add(book);
            }else if(i < 150) {
                Rectangle book = new Rectangle(i * bookWidth, pane1.getHeight(), bookWidth, rand.nextDouble(50, 75));
                book.setFill(colors[rand.nextInt(0, colors.length - 1)]);
                book.setStroke(Color.BLACK);
                current = displayed.get(i);
                Book finalCurrent = current;
                book.setOnMouseDragOver(event -> {
                    dragOver(finalCurrent);
                });
                pane3.getChildren().add(book);
            }
        }
    }

    public void dragOver(Book book) {
        currentBookText.setText(book.returnBookTitle());
    }

    public ArrayList<Book> getList(Shelf current) {
        return current.inorder();
    }



}
