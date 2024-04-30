package Model;

import Core.TreeNode;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Shelf {
    private TreeNode<String, Book> treeMap;

    public Shelf(Book book) {
        treeMap = new TreeNode(book.returnBookTitle(), book);
    }

    public void add(Book book) {
        treeMap.insert(book.returnBookTitle(), book, Optional.empty());
    }

    public Book retrieve(Book book) {
        return (Book) treeMap.retrieve(book.returnBookTitle());
    }

    public ArrayList<Book> inorder() {
        return traverse((node, op) -> node.inOrder(op));
    }

    public ArrayList<Book> traverse(BiConsumer<TreeNode<String, Book>, Consumer<Book>> traversal) {
        ArrayList<Book> result = new ArrayList<>();
        traversal.accept(treeMap, v -> result.add(v));
        return result;
    }
}
