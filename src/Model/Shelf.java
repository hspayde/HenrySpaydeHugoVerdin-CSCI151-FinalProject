package Model;

import Core.TreeNode;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Shelf {
    private TreeNode<String, Book> treeMap;

    public Shelf() {
    }

    public void add(Book book) {
        if(treeMap == null) {
            treeMap = new TreeNode(book.returnBookTitle(), book);
        }else {
            treeMap.insert(book.returnBookTitle(), book, Optional.empty());
            System.out.println(treeMap.size());
        }
    }

    public Book retrieve(Book book) {
        return (Book) treeMap.retrieve(book.returnBookTitle());
    }

    public ArrayList<Book> inorder() {
        if(treeMap != null) {
            return traverse((node, op) -> node.inOrder(op));
        }
        return null;
    }

    public ArrayList<Book> traverse(BiConsumer<TreeNode<String, Book>, Consumer<Book>> traversal) {
        ArrayList<Book> result = new ArrayList<>();
        traversal.accept(treeMap, v -> result.add(v));
        return result;
    }

    public boolean contains(Book book) {
        return treeMap.contains(book.returnBookTitle());
    }
}
