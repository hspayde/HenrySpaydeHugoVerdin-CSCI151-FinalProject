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
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    Book test = new Book("Author", "Title", 55, 25, true, true, true, true, true, 4, "comments");
    Book test1 = new Book("Autho", "Tite", 5, 2, true, true, true, true, true, 4, "comments");
    Book test2 = new Book("Auor", "tle", 85, 5, true, true, true, true, true, 4, "comments");



    private Shelf owned = new Shelf(test);
    private Shelf read = new Shelf(test);
    private Shelf readList = new Shelf(test);
    private Shelf wishList = new Shelf(test);
    private Shelf currentShelf = owned;
    private Color[] colors = { Color.CADETBLUE, Color.DARKOLIVEGREEN, Color.DARKSEAGREEN, Color.GOLDENROD, Color.MEDIUMSEAGREEN, Color.MISTYROSE, Color.ROSYBROWN };


    public void initialize() {
        currentShelfText.setText("Owned");
        owned.add(test);
        read.add(test1);
        wishList.add(test2);
        try {
            updateView();
        }catch (Exception ignored) {}
    }

    public void ownedButton() {
        currentShelf = owned;
        currentShelfText.setText("Owned");
        updateView();
    }

    public void readButton() {
        currentShelf = read;
        currentShelfText.setText("Read");
        updateView();
    }

    public void readListButton() {
        currentShelf = readList;
        currentShelfText.setText("Reading List");
        updateView();
    }

    public void wishListButton() {
        currentShelf = wishList;
        currentShelfText.setText("Wish List");
        updateView();
    }

    public void updateView() {
        ArrayList<Book> displayed = getList(currentShelf);
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
        Random rand = new Random();
        Book current;

        double bookWidth = pane1.getPrefWidth() /50;


        for(int i = 0; i < displayed.size(); i++) {
            double bookHeight = rand.nextDouble(50, 75);
            if(i < 50) {
                Rectangle book = new Rectangle(i * bookWidth, pane1.getPrefHeight() - bookHeight, bookWidth, bookHeight);
                book.setFill(colors[rand.nextInt(0, colors.length - 1)]);
                book.setStroke(Color.BLACK);
                current = displayed.get(i);
                Book finalCurrent = current;
                book.setOnMouseDragOver(event -> {
                    dragOver(finalCurrent);
                });
                pane1.getChildren().add(book);
            }else if(i < 100) {
                Rectangle book = new Rectangle(i * bookWidth, pane2.getPrefHeight() - bookHeight, bookWidth, bookHeight);
                book.setFill(colors[rand.nextInt(0, colors.length - 1)]);
                book.setStroke(Color.BLACK);
                current = displayed.get(i);
                Book finalCurrent = current;
                book.setOnMouseDragOver(event -> {
                    dragOver(finalCurrent);
                });
                pane2.getChildren().add(book);
            }else if(i < 150) {
                Rectangle book = new Rectangle(i * bookWidth, pane3.getPrefHeight() - bookHeight, bookWidth, bookHeight);
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
