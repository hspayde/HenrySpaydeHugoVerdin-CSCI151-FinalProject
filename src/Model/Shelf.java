package Model;

import Core.TreeNode;
import java.util.Optional;

public class Shelf {
    private TreeNode TreeMap;

    public Shelf(Book book) {
        TreeMap = new TreeNode(book.returnBookTitle(), book);
    }
}
