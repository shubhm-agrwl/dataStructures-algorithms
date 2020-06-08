package com.shubham.dataStructures.tree;

  /*
  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

  Note:
  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

  Example 1:

  Input: root = [3,1,4,null,2], k = 1
     3
    / \
   1   4
    \
     2
  Output: 1

  Example 2:

  Input: root = [5,3,6,2,4,null,null,1], k = 3
         5
        / \
       3   6
      / \
     2   4
    /
   1
  Output: 3

 */

import java.util.ArrayList;
import java.util.LinkedList;

public class KthSmallestElement {

  private static int count = 0;

  public static void main(String[] args) {
    Node root = null;
    int keys[] = {20, 8, 22, 4, 12, 10, 14};

    for (int x : keys) {
      root = insert(root, x);
    }

    int k = 3;
    printKthSmallest(root, k);
  }

  private static void printKthSmallest(Node root, int k) {
    count = 0;

    Node res = kthSmallest(root, k);
    if (res == null) {
      System.out.println("There are less "
          + "than k nodes in the BST");
    } else {
      System.out.println("K-th Smallest"
          + " Element is " + res.data);
    }
  }

  private static Node kthSmallest(Node root, int k) {
    if (root == null) {
      return null;
    }

    // search in left subtree
    Node left = kthSmallest(root.left, k);

    // if k'th smallest is found in left subtree, return it
    if (left != null) {
      return left;
    }

    // if current element is k'th smallest, return it
    count++;
    if (count == k) {
      return root;
    }

    // else search in right subtree
    return kthSmallest(root.right, k);
  }

  private static Node insert(Node root, int x) {
    if (root == null) {
      return new Node(x);
    }
    if (x < root.data) {
      root.left = insert(root.left, x);
    } else if (x > root.data) {
      root.right = insert(root.right, x);
    }
    return root;
  }

  private static int kthSmallest2(Node root, int k) {
    LinkedList<Node> stack = new LinkedList<>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) {
        return root.data;
      }
      root = root.right;
    }
  }

  public ArrayList<Integer> inorder(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return arr;
    }
    inorder(root.left, arr);
    arr.add(root.data);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest3(Node root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }

}
