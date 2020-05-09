package com.shubham.dataStructures.tree;

  /*
  In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

  Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

  We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

  Return true if and only if the nodes corresponding to the values x and y are cousins.

   Example 1:

  Input: root = [1,2,3,4], x = 4, y = 3
  Output: false

  Example 2:

  Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
  Output: true

  Example 3:

  Input: root = [1,2,3,null,4], x = 2, y = 3
  Output: false
 */

public class BinaryTreeCheckCousins {

  Node root;

  // Recursive function to check if two Nodes are
  // siblings
  boolean isSibling(Node node, Node a, Node b) {
    // Base case
    if (node == null) {
      return false;
    }

    if ((null != node.left) && (null != node.right)) {

      return ((node.left.data == a.data && node.right.data == b.data) ||
          (node.left.data == b.data && node.right.data == a.data) ||
          isSibling(node.left, a, b) ||
          isSibling(node.right, a, b));
    } else {
      return (isSibling(node.left, a, b) ||
          isSibling(node.right, a, b));
    }
    //return false;
  }

  // Recursive function to find level of Node 'ptr' in
  // a binary tree
  int level(Node node, Node ptr, int lev) {

    if (node == null) {
      return 0;
    }

    if (node.data == ptr.data) {
      return lev;
    }

    // Return level if Node is present in left subtree
    int l = level(node.left, ptr, lev + 1);
    if (l != 0) {
      return l;
    }

    // Else search in right subtree
    return level(node.right, ptr, lev + 1);
  }

  // Returns 1 if a and b are cousins, otherwise 0
  boolean isCousin(Node node, Node a, Node b) {
    // 1. The two Nodes should be on the same level
    //       in the binary tree.
    // 2. The two Nodes should not be siblings (means
    //    that they should not have the same parent
    //    Node).
    return ((level(node, a, 1) == level(node, b, 1)) &&
        (!isSibling(node, a, b)));
  }

  public static void main(String args[]) {
    BinaryTreeCheckCousins tree = new BinaryTreeCheckCousins();
    tree.root = new Node(1);
    //tree.root.left = new Node(2);
    tree.root.right = new Node(2);
    tree.root.right.left = new Node(3);
    //tree.root.left.right = new Node(5);
    //tree.root.left.right.right = new Node(15);
    //tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(5);
    tree.root.right.left.left = new Node(4);
    tree.root.right.left.left.left = new Node(6);

    Node Node1, Node2;
    Node1 = new Node(5);
    Node2 = new Node(3);
    if (tree.isCousin(tree.root, Node1, Node2)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
