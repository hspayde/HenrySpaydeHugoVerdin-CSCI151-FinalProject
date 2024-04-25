package Core;

import java.util.Optional;
import java.util.function.Consumer;

public class TreeNode<K extends Comparable<K>, V> {

    private Optional<TreeNode<K, V>> left = Optional.empty();
    private Optional<TreeNode<K, V>> right = Optional.empty();
    private Optional<TreeNode<K, V>> parent = Optional.empty();
    private K key;
    private V value;
    private boolean isRed = true;
    private Direction direction;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        direction = Direction.ROOT;
    }

    public K get() {
        return key;
    }
    public V getValue() { return value; }
    public Optional<TreeNode<K, V>> getLeft() { return left; }
    public Optional<TreeNode<K, V>> getRight() { return right; }
    public boolean isLeaf() { return left.isEmpty() && right.isEmpty(); }
    public boolean ifRed() { return isRed; }

    public boolean insert(K key, V value, Optional<TreeNode<K, V>> sibling) {
        // Inserts a new node containing key and value, preserving the ordering.
        if(key.compareTo(this.key) < 0) {
            if(left.isPresent()) {
                if(left.get().insert(key, value, right) && direction != Direction.ROOT) {
                    isRed = true;
                }
            }else {
                left = Optional.of(new TreeNode(key, value));
                left.get().direction = Direction.LEFT;
                left.get().parent = Optional.of(this);
                if(isRed) {
                    return check(left, sibling);
                }
            }
        }else if(key.compareTo(this.key) > 0) {
            if(right.isPresent()) {
                if(right.get().insert(key, value, left) && direction != Direction.ROOT) {
                    isRed = true;
                }
            }else {
                right = Optional.of(new TreeNode(key, value));
                right.get().direction = Direction.RIGHT;
                right.get().parent = Optional.of(this);
                if(isRed) {
                    return check(right, sibling);
                }
            }
        }
        return false;
    }

    public boolean contains(K key) {
        // Return true if key is present in the tree, false otherwise
        //
        if(key.compareTo(this.key) == 0) {
            return true;
        }else if(key.compareTo(this.key) < 0) {
            if(left.isPresent()) {
                return left.get().contains(key);
            }else {
                return false;
            }
        }else if(key.compareTo(this.key) > 0) {
            if(right.isPresent()) {
                return right.get().contains(key);
            }else {
                return false;
            }
        }
        // Compare the parameter to this.key to determine which direction to go.
        // If the parameter is equal to this.key, return true
        // If the parameter is less than this.key, proceed with the left child.
        // If the parameter is greater than this.key, proceed with the right child.
        // If the child is empty, return false.
        // Otherwise, call contains recursively on the child.

        return false;
    }

    public int size() {
        // Return the number of nodes in the tree, which is 1 + the number of
        // nodes in the child trees.
        int count = 0;

        if(left.isPresent()) {
            count += left.get().size();
        }
        if(right.isPresent()) {
            count += right.get().size();
        }

        return count + 1;
    }

    public K getMin() {
        // Return the smallest (left-most) value in the tree.
        if(left.isPresent()) {
            return left.get().getMin();
        }else {
            return this.key;
        }
    }

    public K getMax() {
        // Return the largest (right-most) value in the tree.
        if(right.isPresent()) {
            return right.get().getMax();
        }else {
            return this.key;
        }
    }

    public int height() {
        // Return the height of the tree, which is the maximum number of
        // edges between the root and any leaf.
        int count = 1;

        if(this.isLeaf()) {
            return 0;
        }else {
            int leftCount = 0;
            int rightCount = 0;

            if(left.isPresent()) {
                leftCount += left.get().height();
            }
            if(right.isPresent()) {
                rightCount += right.get().height();
            }
            if(rightCount > leftCount) {
                return count + rightCount;
            }else {
                return count + leftCount;
            }
        }
    }

    public void preOrder(Consumer<K> op) {
        // Perform a preorder traversal using op.accept(value)
        op.accept(this.key);
        if(left.isPresent()) {
            left.get().preOrder(op);
        }
        if(right.isPresent()) {
            right.get().preOrder(op);
        }
    }

    public void postOrder(Consumer<K> op) {
        // Perform a postorder traversal using op.accept(value)
        if(left.isPresent()) {
            left.get().postOrder(op);
        }
        if(right.isPresent()) {
            right.get().postOrder(op);
        }
        op.accept(this.key);
    }

    public void inOrder(Consumer<K> op) {
        // Perform an inorder traversal using op.accept(value)
        if(left.isPresent()) {
            left.get().inOrder(op);
        }
        op.accept(this.key);
        if(right.isPresent()) {
            right.get().inOrder(op);
        }
    }

    public Optional<TreeNode<K, V>> leftRotateAt(K key) {
        if(key.compareTo(this.key) < 0) {
            if(left.isPresent()) {left = left.get().leftRotateAt(key);}

        }else if (key.compareTo(this.key) > 0) {
            if(right.isPresent()) {right = right.get().leftRotateAt(key);}

        }else if(key.compareTo(this.key) == 0) {
            if(right.isPresent()) {
                TreeNode<K, V> temp = right.get();
                temp.parent = this.parent;
                temp.direction = this.direction;
                right = right.get().left;
                right.get().parent = Optional.of(temp);
                right.get().direction = Direction.RIGHT;
                temp.left = Optional.of(this);
                temp.left.get().parent = Optional.of(temp);
                this.direction = Direction.LEFT;
                return Optional.of(temp);
            }
        }
        // - If target is less than key:
        //   - Set the left child to be the result of calling this method recursively.
        // - If target is greater than key:
        //   - Set the right child to be the result of calling this method recursively.
        // - If target and key are equivalent:
        // 		perform a left rotation of this node
        //      and return the key to be held by the parent.
        // - If key is not present, just return this.
        return Optional.of(this);
    }

    public Optional<TreeNode<K, V>> rightRotateAt(K value) {
        if(value.compareTo(this.key) < 0) {
            if(left.isPresent()) {left = left.get().rightRotateAt(value);}

        }else if (value.compareTo(this.key) > 0) {
            if(right.isPresent()) {right = right.get().rightRotateAt(value);}

        }else if(value.compareTo(this.key) == 0) {
            if(left.isPresent()) {
                TreeNode<K, V> temp = left.get();
                temp.parent = this.parent;
                temp.direction = this.direction;
                left = left.get().right;
                left.get().parent = Optional.of(temp);
                left.get().direction = Direction.LEFT;
                temp.right = Optional.of(this);
                temp.right.get().parent = Optional.of(temp);
                this.direction = Direction.RIGHT;
                return Optional.of(temp);
            }
        }
        // - If target is less than value:
        //   - Set the left child to be the result of calling this method recursively.
        // - If target is greater than value:
        //   - Set the right child to be the result of calling this method recursively.
        // - If target and value are equivalent:
        // 		perform a right rotation of this node
        //      and return the value to be held by the parent.
        // - If value is not present, just return Optional.empty().
        return Optional.of(this);
    }

    public boolean isLeft() {return direction == Direction.LEFT;}

    public boolean isRight() {return direction == Direction.RIGHT;}

    public boolean check(Optional<TreeNode<K, V>> child, Optional<TreeNode<K, V>> pibling) {
        if(pibling.isPresent()) {
            if (isRed && pibling.get().ifRed()) {
                case2(pibling);
                return true;
            }else if(isRed && !pibling.get().ifRed()) {
                case3(child);
                return true;
            }
        }else {
            if(isRed) {
                case3(child);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public void case2(Optional<TreeNode<K, V>> pibling) {
        isRed = false;
        pibling.get().isRed = false;
        if(parent.get().direction != Direction.ROOT) {
            Optional<TreeNode<K, V>> ggParent = parent.get().parent;
            if(parent.get().isLeft()) {
                check(parent, ggParent.get().getRight());
            }else {
                check(parent, ggParent.get().getLeft());
            }
        }
    }

    public void case3(Optional<TreeNode<K, V>> child) {
        if(child.get().isLeft() && this.isRight()) {
            child.get().isRed = false;
            rightRotateAt(this.key);
            leftRotateAt(parent.get().key);
        }else if(child.get().isRight() && this.isLeft()) {
            child.get().isRed = false;
            leftRotateAt(this.key);
            rightRotateAt(parent.get().key);
        }else if(child.get().isLeft() && this.isLeft()) {
            this.isRed = false;
            rightRotateAt(parent.get().key);
        }else if(child.get().isRight() && this.isRight()) {
            this.isRed = false;
            leftRotateAt(parent.get().key);
        }
    }
}

//Adapted from 151bst Lab