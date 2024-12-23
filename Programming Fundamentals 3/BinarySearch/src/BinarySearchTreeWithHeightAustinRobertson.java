/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 8
 Due: 11/13/2024
 Submitted: 11/13/2024
 Create a new class to extend the capabilities of the BST class to return the height of our binary tree
 */

import java.util.*;

public class BinarySearchTreeWithHeightAustinRobertson {
  public static void main(String[] args) {
    BSTWithHeight<String> tree = new BSTWithHeight<>();
    System.out.print("The height of an empty tree is " + tree.height());

    tree.insert("Green");
    System.out.print("\nThe height of the tree with one node is " + tree.height());

    tree.insert("Red");
    System.out.print("\nThe height of the tree with two nodes is " + tree.height());

    BSTWithHeight<String> tree1 = new BSTWithHeight<>();

    Scanner input = new Scanner(System.in);
    System.out.print("\nEnter six lower case strings: ");
    for (int i = 0; i < 6; i++) {
      String s = input.next();
      tree1.insert(s.trim());
    }
    System.out.print("The height of tree1 is " + tree1.height());

    BSTWithHeight<String> tree2 = new BSTWithHeight<>(new String[]
      {"Tom", "George", "Jean", "Jane", "Kevin", "Peter", "Susan",
        "Jen", "Kim", "Michael", "Michelle"});

    System.out.print("\nThe height of tree2 is " + tree2.height());

    BSTWithHeight<Integer> tree3 =
      new BSTWithHeight<>(new Integer[]{50, 45, 35, 48, 59, 51, 58});
    System.out.print("\nThe height of tree3 is " + tree3.height());
  }
}

interface Tree<E> extends java.util.Collection<E> {
  /** Return true if the element is in the tree */
  public boolean search(E e);

  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully */
  public boolean insert(E e);

  /** Delete the specified element from the tree
   * Return true if the element is deleted successfully */
  public boolean delete(E e);
  
  /** Get the number of nodes in the tree */
  public int getSize();
  
  /** Inorder traversal from the root*/
  public default void inorder() {
  }

  /** Postorder traversal from the root */
  public default void postorder() {
  }

  /** Preorder traversal from the root */
  public default void preorder() {
  }
  
  @Override /** Return true if the tree is empty */
  public default boolean isEmpty() {
    return size() == 0;
  };

  @Override
  public default boolean contains(Object e) {
    return search((E)e);
  }
  
  @Override
  public default boolean add(E e) {
    return insert(e);
  }
  
  @Override
  public default boolean remove(Object e) {
    return delete((E)e);
  }
  
  @Override
  public default int size() {
    return getSize();
  }
  
  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}

class BST<E> implements Tree<E> {
  protected TreeNode<E> root;
  protected int size = 0;
  protected java.util.Comparator<E> c; 

  /** Create a default BST with a natural order comparator */
  public BST() {
    this.c = new Comparator<E>() {
      public int compare(E e1, E e2) {
        return ((Comparable<E>)e1).compareTo(e2);
      }
    };
  }

  /** Create a BST with a specified comparator */
  public BST(java.util.Comparator<E> c) {
    this.c = c;
  }

  /** Create a binary tree from an array of objects */
  public BST(E[] objects) {
    this();
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  @Override /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (c.compare(e, current.element) < 0) {
        current = current.left;
      }
      else if (c.compare(e, current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }

    return false;
  }

  @Override /** Insert element e into the binary tree
   * Return true if the element is inserted successfully */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (c.compare(e, current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (c.compare(e, current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted

      // Create the new node and attach it to the parent node
      if (c.compare(e, parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }

    size++;
    return true; // Element inserted successfully
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  @Override /** Inorder traversal from the root */
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  /** This inner class is static, because it does not access 
      any instance members defined in its outer class */
  public static class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  @Override /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode<E> getRoot() {
    return root;
  }

  /** Returns a path from the root leading to the specified element */
  public java.util.ArrayList<TreeNode<E>> path(E e) {
    java.util.ArrayList<TreeNode<E>> list =
      new java.util.ArrayList<>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (c.compare(e, current.element) < 0) {
        current = current.left;
      }
      else if (c.compare(e, current.element) > 0) {
        current = current.right;
      }
      else
        break;
    }

    return list; // Return an array list of nodes
  }

  @Override /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (c.compare(e, current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (c.compare(e, current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed at by current
    }

    if (current == null)
      return false; // Element is not in the tree

    // Case 1: current has no left child
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.right;
      }
      else {
        if (c.compare(e, parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;

      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;     
    }

    size--; // Reduce the size of the tree
    return true; // Element deleted successfully
  }

  @Override /** Obtain an iterator. Use inorder. */
  public java.util.Iterator<E> iterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  private class InorderIterator implements java.util.Iterator<E> {
    // Store the elements in a list
    private java.util.ArrayList<E> list =
      new java.util.ArrayList<>();
    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root*/
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null) return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    @Override /** More elements for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;

      return false;
    }

    @Override /** Get the current element and move to the next */
    public E next() {
      return list.get(current++);
    }

    @Override // Remove the element returned by the last next()
    public void remove() {
      if (current == 0) // next() has not been called yet
        throw new IllegalStateException(); 

      delete(list.get(--current)); 
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  @Override /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }
}


/**
 * BSTWithHeight used to extends our BST class
 *
 * Class Information:
 * - Name: BSTWithHeight
 * - Dependencies:
 *   - java.util.Comparator
 *   - BST
 *   - TreeNode
 * - Package: None
 * - Inheritance: Extends BST<E>
 *
 * Purpose:
 * - The BSTWithHeight class extends the Binary Search Tree (BST)
 * class to include a method that we can use to find the height of our binary tree.
 *
 * Constants and Variables:
 * - Constants: None
 * - Variables: Inherits root and size from the BST class
 *
 * Constructors:
 * - BSTWithHeight(): Creates an empty binary search tree.
 * - BSTWithHeight(E[] objects): Creates a binary search tree and inserts the
 *                               elements from the specified array into the tree.
 */

class BSTWithHeight<E extends Comparable<E>> extends BST<E> {

  // Constructor without parameters, initializes an empty binary search tree
  public BSTWithHeight() {
    super();
  }

  // Constructor with an array of elements
  public BSTWithHeight(E[] objects) {
    super(objects);
  }

  /**
   * Return the height of this binary tree.
   */
  public int height() {
    return height(root); // Call the helper method to find the height of our tree from the root node
  }

  /**
   * Helper method to find the height of the tree starting from a given node.
   */
  private int height(TreeNode<E> node) {
    if (node == null) { // Base case
      return 0;
    } else {
      // Recursively find the height of the left and right subtrees
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);
      // Return the max height
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}


