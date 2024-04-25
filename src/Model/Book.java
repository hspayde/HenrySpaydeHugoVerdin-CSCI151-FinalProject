package Model;

import java.util.Scanner;

public class Book {
    private String author  = "";
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
    public Book(String author, String book_title, int page_count, int current_page, boolean is_reading,boolean owned, boolean read, boolean read_list, boolean wish_list, double rating, String comments){
        author = this.author;
        book_title = this.book_title;
        page_count = this.page_count;
        current_page = this.current_page;
        is_reading = this.is_reading;
        owned = this.owned;
        read = this.read;
        read_list = this.read_list;
        wish_list = this.wish_list;
        rating = this.rating;
        comments = this.comments;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setBookTitle(String book_title){
        this.book_title = book_title;
    }
    public void setPageCount(int page_count){
        this.page_count = page_count;
    }
    public void setCurrentPage(int current_page){
        this.current_page = current_page;
    }
    public void setIsReading(boolean is_reading){
        this.is_reading = is_reading;
    }
    public void setOwned(boolean owned){
        this.owned = owned;
    }
    public void setRead(boolean read){
        this.read = read;
    }
    public void setReadList(boolean read_list){
        this.read_list = read_list;
    }
    public void setWishList(boolean wish_list){
        this.wish_list = wish_list;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public void setComments(String comments){
        this.comments = comments;
    }


    public String returnAuthor(){
        return this.author;
    }
    public String returnBookTitle(){
        return this.book_title;
    }
    public int returnPageCount(){
        return this.page_count;
    }
    public int returnCurrentPage(){
        return this.current_page;
    }
    public boolean returnIsReading(){
        return this.is_reading;
    }
    public boolean returnOwned(){
        return this.owned;
    }
    public boolean returnRead(){
        return this.read;
    }
    public boolean returnReadList(){
        return this.read_list;
    }
    public boolean returnWishList(){
        return this.wish_list;
    }
    public double returnRating(){
        return this.rating;
    }
    public String returnComments(){
        return this.comments;
    }
}
