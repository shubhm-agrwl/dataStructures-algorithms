package com.shubham.dataStructures.tree;

public class PopulatingNextRightPointer {

  // Working

//  public Node connect(Node root) {
//    if (root == null) {
//      return root;
//    }
//    Queue queue = new LinkedList();
//    queue.add(root);
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      Node prev = null;
//      for (int i = 0; i < size; i++) {
//        Node curr = (Node) queue.poll();
//        curr.next = null;
//        if (prev != null) {
//          prev.next = curr;
//        }
//        if (curr.left != null) {
//          queue.add(curr.left);
//        }
//        if (curr.right != null) {
//          queue.add(curr.right);
//        }
//        prev = curr;
//      }
//    }
//    return root;
//
//  }

}
