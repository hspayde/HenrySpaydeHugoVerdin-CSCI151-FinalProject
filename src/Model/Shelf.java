package Model;

import Core.TreeNode;
import java.util.Optional;

public class Shelf {
    private TreeNode TreeMap;

    public Shelf(Book book) {
        TreeMap = new TreeNode(book.returnBookTitle(), book);
    }

    public void add(Book book) {
        TreeMap.insert(book.returnBookTitle(), book, Optional.empty());
    }

    public Book retrieve(Book book) {
        return (Book) TreeMap.retrieve(book.returnBookTitle());
    }
}
